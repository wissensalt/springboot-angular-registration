package com.wissensalt.test.sar.endpoint;

import com.wissensalt.test.sar.dto.ResponseData;
import com.wissensalt.test.sar.exception.EndPointException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 5/9/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping("/auth")
public interface IAuthEndPoint<LOGIN_DATA, RESPONSE_DTO> {

    @PostMapping("/logout")
    ResponseData logout(HttpServletRequest p_Request, HttpServletResponse p_Response) throws EndPointException;

    @PostMapping("/login")
    RESPONSE_DTO login(@RequestBody LOGIN_DATA login_data, HttpServletResponse p_Response, HttpServletRequest p_Request) throws EndPointException;
}