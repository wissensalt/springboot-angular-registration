package com.wissensalt.test.sar.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 6/6/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Getter
@Setter
public class RequestLoginDTO implements Serializable{
    /**
     *
     *
     */
    private static final long serialVersionUID = -3717873746249151313L;

    private String userName;
    private String password;
}
