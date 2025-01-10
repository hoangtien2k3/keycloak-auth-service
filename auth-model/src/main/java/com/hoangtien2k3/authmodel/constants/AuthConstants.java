package com.hoangtien2k3.authmodel.constants;

public final class AuthConstants {
    public static final long[] EMPLOYEE_CODE_MAX = {0L};
    public static final String SUCCESS = "common.success";
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_INACTIVE = 0;

    public static final class Notification {
        public static final String SEVERITY = "NORMAL";
        public static final String CONTENT_TYPE = "text/plain";
        public static final String CATEGORY_TYPE = "ANNOUNCEMENT"; // THONG_BAO
        public static final String CHANNEL_TYPE = "EMAIL";
    }

    public static final class Message {
        public static final String EMAIL_INVALID = "dto.email.invalid";
    }

    public static final class OAuth {
        public static final String AUTHOR_CODE = "authorization_code";
        public static final String UMA_TICKET = "urn:ietf:params:oauth:grant-type:uma-ticket";
        public static final String RESPONSE_MODE_PERMISSION = "permissions";
        public static final String REDIRECT_URI = "http://localhost:3000/callback";
        public static final String AUTHORIZATION = "Authorization";
        public static final String BEARER = "Bearer ";
        public static final String CLIENT_CREDENTIALS = "client_credentials"; // grant_type de lay token by clientId va
    }

    public static final class TenantType {
        public static final String ORGANIZATION = "ORGANIZATION";
    }

    public static final class System {
        public static final String hoangtien2k3 = "hoangtien2k3";
    }

    public static final class Field {
        public static final String STATE = "state";
    }
}
