package com.wissensalt.test.sar.statval;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISarConstant {

    interface Bean {
        String REGISTRATION_VALIDATOR = "bean-registration-validator";
    }

    interface Path {
        String REGISTRATION = "/registration";
        String LOGIN = "/login";
        String REGISTER = "/register";
        String DASHBOARD = "/api/dashboard";
    }

    interface RoleCode {
        String ADMIN = "ROLE_ADMIN";
    }

    interface RoleName {
        String ADMIN = "ADMIN";
    }
}
