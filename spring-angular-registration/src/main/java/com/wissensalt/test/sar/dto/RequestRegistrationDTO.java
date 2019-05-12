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
public class RequestRegistrationDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3198880434676247053L;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String dob;
    private Integer gender;
    private String email;
}
