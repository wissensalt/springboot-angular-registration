package com.wissensalt.test.sar.exception;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DAOException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2682641418110879822L;

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
