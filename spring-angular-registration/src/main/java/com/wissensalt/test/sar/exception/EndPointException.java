package com.wissensalt.test.sar.exception;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class EndPointException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3606509494328908116L;

    public EndPointException(String message) {
        super(message);
    }

    public EndPointException(String message, Throwable cause) {
        super(message, cause);
    }
}
