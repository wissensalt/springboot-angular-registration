package com.wissensalt.test.sar.validation;

import com.wissensalt.test.sar.dto.ResponseValidationDTO;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <REQUEST_DTO>
 */
public interface IRequestValidator<REQUEST_DTO> {

    ResponseValidationDTO validate(REQUEST_DTO p_Request);
}
