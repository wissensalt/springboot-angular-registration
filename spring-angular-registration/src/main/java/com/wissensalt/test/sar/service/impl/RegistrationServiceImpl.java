package com.wissensalt.test.sar.service.impl;

import com.wissensalt.test.sar.dao.IUserDAO;
import com.wissensalt.test.sar.dto.RequestRegistrationDTO;
import com.wissensalt.test.sar.dto.ResponseData;
import com.wissensalt.test.sar.dto.ResponseValidationDTO;
import com.wissensalt.test.sar.mapper.UserMapper;
import com.wissensalt.test.sar.service.IRegistrationService;
import com.wissensalt.test.sar.statval.ISarConstant;
import com.wissensalt.test.sar.statval.ISarConstant.Bean;
import com.wissensalt.test.sar.util.APIErrorBuilder;
import com.wissensalt.test.sar.validation.IRequestValidator;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static com.wissensalt.test.sar.statval.ISarConstant.Path.REGISTER;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired private IUserDAO userDAO;
    @Autowired private UserMapper userMapper;
    @Autowired @Qualifier(Bean.REGISTRATION_VALIDATOR) private IRequestValidator<RequestRegistrationDTO> registrationValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public ResponseEntity register(RequestRegistrationDTO p_Request) throws ServiceException {
        ResponseEntity response;
        ResponseValidationDTO responseValidation = registrationValidator.validate(p_Request);
        if (responseValidation.getIsValid()) {
            userDAO.save(userMapper.convert(p_Request));
            response = ResponseEntity.ok(new ResponseData("200", "Success Register User"));
        }else {
            LOGGER.error("Request is not Valid {}", responseValidation.getMessage());
            response = new ResponseEntity<>(APIErrorBuilder.badRequest(RegistrationServiceImpl.class, responseValidation.getMessage(), ISarConstant.Path.REGISTRATION.concat(REGISTER)), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
