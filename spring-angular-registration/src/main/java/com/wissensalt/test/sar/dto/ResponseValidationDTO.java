package com.wissensalt.test.sar.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class ResponseValidationDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5800369745118333312L;
    private Boolean isValid;
    private String message;
}
