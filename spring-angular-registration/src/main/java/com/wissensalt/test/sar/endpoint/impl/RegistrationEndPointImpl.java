package com.wissensalt.test.sar.endpoint.impl;

import com.wissensalt.test.sar.dto.RequestRegistrationDTO;
import com.wissensalt.test.sar.endpoint.IRegistrationEndPoint;
import com.wissensalt.test.sar.exception.EndPointException;
import com.wissensalt.test.sar.exception.ServiceException;
import com.wissensalt.test.sar.service.IRegistrationService;
import com.wissensalt.test.sar.statval.ISarConstant;
import com.wissensalt.test.sar.util.APIErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.wissensalt.test.sar.statval.ISarConstant.Path.REGISTER;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@RequestMapping(ISarConstant.Path.REGISTRATION)
public class RegistrationEndPointImpl implements IRegistrationEndPoint {

    @Autowired private IRegistrationService registrationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationEndPointImpl.class);

    @PostMapping(ISarConstant.Path.REGISTER)
    @Override
    public ResponseEntity register(@RequestBody RequestRegistrationDTO p_Request) throws EndPointException {
        try {
            return registrationService.register(p_Request);
        } catch (ServiceException e) {
            LOGGER.error("Error conduct register : {}", e.toString());
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(RegistrationEndPointImpl.class, "Error Register Process : "+e.getMessage(), ISarConstant.Path.REGISTRATION.concat(REGISTER)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
