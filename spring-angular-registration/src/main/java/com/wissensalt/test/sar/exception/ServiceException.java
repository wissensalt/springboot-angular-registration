package com.wissensalt.test.sar.exception;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ServiceException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3882661372718700763L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
