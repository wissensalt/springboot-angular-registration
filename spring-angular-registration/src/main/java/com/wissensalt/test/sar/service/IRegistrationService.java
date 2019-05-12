package com.wissensalt.test.sar.service;

import com.wissensalt.test.sar.dto.RequestRegistrationDTO;
import com.wissensalt.test.sar.exception.ServiceException;
import org.springframework.http.ResponseEntity;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRegistrationService {

    ResponseEntity register(RequestRegistrationDTO p_Request) throws ServiceException;
}
