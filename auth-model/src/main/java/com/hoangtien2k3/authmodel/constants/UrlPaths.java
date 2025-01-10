package com.hoangtien2k3.authmodel.constants;

public class UrlPaths {

    public interface Auth {
        String PREFIX = "v1/auth";
        String LOGIN = "/login";
        String SIGNUP = "/signup";
        String CONFIRM_OTP_FOR_CREATE_ACCOUNT = "/confirm-create";
        String FORGOT_PASSWORD = "/forgot-password";
        String GET_ALL_USERID = "/get-all";
        String CHANGE_PASSWORD = "/change-password";
        String CREATE_TEST_PERFORMANCE_USER = "/test-account";

        String REFRESH_TOKEN = "/refresh";
        String LOGOUT = "/logout";
        String GET_TOKEN_FROM_AUTHORIZATION_CODE = "/provider-code";
        String GET_TOKEN_FROM_PROVIDER_CODE = "/client-code";
        String GET_PERMISSION = "/permissions";
        String GET_ORG_PERMISSION = "/org-permissions";
        String RESET_PASSWORD = "/reset-password";

        String GET_TWO_WAY_PASSWORD = "/two-way-password";
        String ACTION_LOGIN = "action-login";
        String CONFIRM_OTP = "/confirm-otp"; // ham xac nhan otp
        String GENERATE_OTP = "/generate-otp"; // ham sinh ma otp
    }

    public interface Noti {
        String PREFIX = "/v1/transmission";
        String CREATE_NOTI = "/create-noti";
    }

    public interface User {
        String PREFIX = "v1/user";
        String GET_USER = "";
        String UPDATE_USER = "update";
        String CONTACTS = "contacts";
        String GET_USER_BY_ID = "/id/{id}";
        String USER_PROFILES = "search";
        String GET_PROFILES = "{id}";
        String KEYCLOAK = "/keycloak";
    }

    public interface ActionLog {
        String PREFIX = "v1/action-log";
    }
}
