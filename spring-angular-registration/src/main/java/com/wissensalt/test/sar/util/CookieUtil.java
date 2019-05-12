package com.wissensalt.test.sar.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 7/9/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CookieUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieUtil.class);

    public static void create(HttpServletResponse httpServletResponse, String name, String value, Boolean secure, Integer maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }

    public static void clear(HttpServletResponse httpServletResponse, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

    public static void clearBasicAuth(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String JAVA_COOKIE_SESSION = "JSESSIONID";
        if (httpServletRequest.getCookies() != null) {
            for(Cookie cookie : httpServletRequest.getCookies()) {
                if(cookie.getName().equals(JAVA_COOKIE_SESSION)) {
                    cookie.setMaxAge(0);
                    cookie.setPath(httpServletRequest.getContextPath());
                    httpServletResponse.addCookie(cookie);
                    //Clear the other cookie
                    Cookie cookieWithSlash = (Cookie) cookie.clone();
                    cookieWithSlash.setPath(httpServletRequest.getContextPath() + "/");
                    httpServletResponse.addCookie(cookieWithSlash);
                }
            }
            new CookieClearingLogoutHandler(JAVA_COOKIE_SESSION).logout(httpServletRequest, httpServletResponse, authentication);
        } else {
            LOGGER.info("Cookie is Empty, Cancel Process Clearing Cookie");
        }
    }

    public static String getValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
}
