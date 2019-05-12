package com.wissensalt.test.sar.service.impl;

import com.wissensalt.test.sar.dao.IUserDAO;
import com.wissensalt.test.sar.exception.DAOException;
import com.wissensalt.test.sar.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created on 5/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDAO userDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user;
        try {
            user = userDAO.findByCodeAndStatus(s, true);
        } catch (DAOException e) {
            LOGGER.error("error find user by code {} : {}", s, e.toString());
            throw new UsernameNotFoundException("User Name not Found");
        }
        return user;
    }
}
