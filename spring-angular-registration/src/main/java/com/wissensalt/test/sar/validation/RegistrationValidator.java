package com.wissensalt.test.sar.validation;

import com.wissensalt.test.sar.dao.IUserDAO;
import com.wissensalt.test.sar.dto.RequestRegistrationDTO;
import com.wissensalt.test.sar.dto.ResponseValidationDTO;
import com.wissensalt.test.sar.exception.DAOException;
import com.wissensalt.test.sar.model.User;
import com.wissensalt.test.sar.statval.ISarConstant.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
@Qualifier(value = Bean.REGISTRATION_VALIDATOR)
public class RegistrationValidator implements IRequestValidator<RequestRegistrationDTO> {

    @Autowired private IUserDAO userDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationValidator.class);

    @Override
    public ResponseValidationDTO validate(RequestRegistrationDTO p_Request) {
        ResponseValidationDTO result = new ResponseValidationDTO();
        result.setIsValid(false);
        if (p_Request.getMobileNumber() != null && p_Request.getMobileNumber().length() > 0) {
            if (GeneralValidation.isValidPhoneNumber(p_Request.getMobileNumber())) {
                User user = null;
                try {
                    user = userDAO.findByMobileNumber(p_Request.getMobileNumber());
                } catch (DAOException e) {
                    LOGGER.error("Error searching user by mobile number {} : {}", p_Request.getMobileNumber(), e.toString());
                }
                if (user == null) {
                    if (p_Request.getFirstName() != null && p_Request.getFirstName().length() > 0) {
                        if (p_Request.getLastName() != null && p_Request.getFirstName().length() > 0) {
                            if (p_Request.getEmail() != null && p_Request.getEmail().length()> 0) {
                                if (GeneralValidation.isValidEmail(p_Request.getEmail())) {
                                    try {
                                        user = userDAO.findByEmail(p_Request.getEmail());
                                    } catch (DAOException e) {
                                        LOGGER.error("Error find User By Email {} : {}", p_Request.getEmail(), e.toString());
                                    }
                                    if (user == null) {
                                        result.setIsValid(true);
                                    }else {
                                        result.setMessage("User with email "+p_Request.getEmail()+" has already exist");
                                    }
                                }else {
                                    result.setMessage("Email must be in valid format");
                                }
                            }else {
                                result.setMessage("Email can not be null & length must be > 0");
                            }
                        }else {
                            result.setMessage("Last Name can not be null & length must be > 0");
                        }
                    }else {
                        result.setMessage("First Name can not be null & length must be > 0");
                    }
                }else {
                    result.setMessage("User with Phone Number "+p_Request.getMobileNumber()+" is exist");
                }
            }else {
                result.setMessage("Phone Number must be in valid Indonesia format");
            }
        }else {
            result.setMessage("Mobile Phone can not be null & length must be > 0");
        }
        return result;
    }
}
