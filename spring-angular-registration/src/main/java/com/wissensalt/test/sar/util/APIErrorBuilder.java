package com.wissensalt.test.sar.util;

import com.wissensalt.test.sar.dto.ResponseAPIErrorDTO;

import java.util.Date;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class APIErrorBuilder {

    private static final Integer NOT_FOUND_STATUS = 404;
    private static final Integer INTERNAL_SERVER_ERROR = 500;
    private static final Integer BAD_REQUEST = 400;
    private static final Integer CONFLICT = 409;
    private static final Integer GONE = 401;

    public static ResponseAPIErrorDTO notFound(Class p_Exception, String p_Message, String p_Path) {
        return new ResponseAPIErrorDTO(
                new Date(),
                NOT_FOUND_STATUS,
                p_Exception.getCanonicalName(),
                p_Message,
                p_Path,
                "Not Found"
        );
    }


    public static ResponseAPIErrorDTO conflict(Class p_Exception, String p_Message, String p_Path) {
        return new ResponseAPIErrorDTO(
                new Date(),
                CONFLICT,
                p_Exception.getCanonicalName(),
                p_Message,
                p_Path,
                "Conflict"
        );
    }

    public static ResponseAPIErrorDTO internalServerError(Class p_Exception, String p_Message, String p_Path) {
        return new ResponseAPIErrorDTO(
                new Date(),
                INTERNAL_SERVER_ERROR,
                p_Exception.getCanonicalName(),
                p_Message,
                p_Path,
                "Internal Server Error"
        );
    }

    public static ResponseAPIErrorDTO badRequest(Class p_Exception, String p_Message, String p_Path) {
        return new ResponseAPIErrorDTO(
                new Date(),
                BAD_REQUEST,
                p_Exception.getCanonicalName(),
                p_Message,
                p_Path,
                "Bad Request"
        );
    }

    public static ResponseAPIErrorDTO gone(Class p_Exception, String p_Message, String p_Path) {
        return new ResponseAPIErrorDTO(
                new Date(),
                GONE,
                p_Exception.getCanonicalName(),
                p_Message,
                p_Path,
                "Gone"
        );
    }
}
