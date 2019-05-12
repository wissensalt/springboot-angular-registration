package com.wissensalt.test.sar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseData implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8524185686815426024L;
    private String responseCode;
    private String responseMsg;
}
