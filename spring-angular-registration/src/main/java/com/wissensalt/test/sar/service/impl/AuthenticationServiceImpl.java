package com.wissensalt.test.sar.service.impl;

import com.wissensalt.test.sar.dao.IUserDAO;
import com.wissensalt.test.sar.exception.DAOException;
import com.wissensalt.test.sar.exception.ServiceException;
import com.wissensalt.test.sar.model.User;
import com.wissensalt.test.sar.service.IAuthenticationService;
import com.wissensalt.test.sar.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created on 5/17/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private IUserDAO userDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String p_UserName) throws ServiceException {
        User user = null;
        try {
            user = userDAO.findByCodeOrEmail(p_UserName, p_UserName);
        } catch (DAOException e) {
            LOGGER.error("Error Searching User By UserName or PhoneNumber of Email {}", e.toString());
        }
        if(user != null) {
            LOGGER.debug("User Found : {}", user.getCode());
            return user;
        }else {
            LOGGER.warn("User Not Found");
            return null;
        }
    }

    @Override
    public void updateStatusLoggedIn(User p_User) throws ServiceException {
        p_User.setLastLogin(new Date());
        p_User.setLoginStatus(Boolean.TRUE);
        userDAO.save(p_User);
    }

    @Override
    public void updateStatusLoggedOut(String p_UserName) throws ServiceException {
        User p_User = null;
        try {
            p_User = userDAO.findByCodeAndStatus(p_UserName, true);
        } catch (DAOException e) {
            LOGGER.error("Error Searching User {} : {}", p_UserName, e.toString());
        }
        if (p_User != null) {
            p_User.setLoginStatus(Boolean.FALSE);
            userDAO.save(p_User);
        }else {
            LOGGER.error("Error Updating Status Logout");
        }
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        CookieUtil.clearBasicAuth(httpServletRequest, httpServletResponse, authentication);
        new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
    }

    @Override
    public void logoutJwt(HttpServletResponse httpServletResponse, String p_CookieName) throws ServiceException {
        CookieUtil.clear(httpServletResponse, p_CookieName);
    }
}
