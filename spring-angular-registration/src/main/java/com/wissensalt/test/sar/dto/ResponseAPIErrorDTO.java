package com.wissensalt.test.sar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPIErrorDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2021006695807894437L;
    private Date timestamp;
    private Integer status;
    private String exception;
    private String message;
    private String path;
    private String error;
}
