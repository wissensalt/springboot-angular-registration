package com.wissensalt.test.sar.validation;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class GeneralValidation {
    /**
     * Validate Email
     * @param email String
     * @return boolean
     */
    public static boolean isValidEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        email = email.trim();
        return email.matches(emailPattern) && email.length() > 0;
    }

    /**
     * Validate if a String is a Phone Number
     * @param phoneNumber String
     * @return boolean
     */
    public static boolean isValidPhoneNumber(String phoneNumber){
//        String phoneNumberPattern = "^([0-9\\(\\)\\/\\+ \\-]*)$";
        String phoneNumberPattern = "^08[0-9]{9,}$";
        phoneNumber = phoneNumber.trim();
        return phoneNumber.matches( phoneNumberPattern ) && phoneNumber.length() > 0;
    }
}
