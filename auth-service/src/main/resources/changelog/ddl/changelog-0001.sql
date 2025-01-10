-- database changelog

-- user_otp
CREATE TABLE user_otp
(
    id        VARCHAR(36) PRIMARY KEY,
    type      VARCHAR(30) NOT NULL,
    email     VARCHAR(50) NOT NULL,
    otp       VARCHAR(6)  NOT NULL,
    exp_time  TIMESTAMP   NOT NULL,
    tries     INTEGER,
    status    INTEGER,
    create_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP,
    create_by VARCHAR(50),
    update_by VARCHAR(50)
);

-- individual
CREATE TABLE individual
(
    id                VARCHAR(36) PRIMARY KEY,
    user_id           VARCHAR(36),
    username          VARCHAR(50),
    name              VARCHAR(100),
    code              TEXT,
    image             VARCHAR(500),
    gender            VARCHAR(10),
    birthday          TIMESTAMP,
    email             VARCHAR(50),
    email_account     VARCHAR(50),
    phone             VARCHAR(20),
    address           VARCHAR(255),
    province_code     VARCHAR(10),
    district_code     VARCHAR(10),
    precinct_code     VARCHAR(10),
    status            INTEGER,
    create_at         TIMESTAMP,
    create_by         VARCHAR(100),
    update_at         TIMESTAMP,
    update_by         VARCHAR(100),
    position_code     VARCHAR(20),
    password_change   BOOLEAN,
    probation_day     TIMESTAMP,
    start_working_day TIMESTAMP
);

-- user_credential
CREATE TABLE user_credential
(
    id          VARCHAR(36) PRIMARY KEY,
    user_id     VARCHAR(36),
    username    VARCHAR(50),
    hash_pwd    TEXT,
    status      INTEGER,
    create_at   TIMESTAMP,
    create_by   VARCHAR(100),
    update_at   TIMESTAMP,
    update_by   VARCHAR(100),
    pwd_changed INTEGER
);

-- action_log
CREATE TABLE action_log
(
    id         VARCHAR(36) PRIMARY KEY,
    user_id    VARCHAR(36) NOT NULL,
    username   VARCHAR(50) NOT NULL,
    ip         VARCHAR(45) NOT NULL,
    type       VARCHAR(20) NOT NULL,
    user_agent TEXT,
    create_at  TIMESTAMP   NOT NULL
);
CREATE INDEX idx_action_log_user_id ON action_log (user_id);
CREATE INDEX idx_action_log_create_at ON action_log (create_at);

-- permission_policy
CREATE TABLE permission_policy
(
    id                                     VARCHAR(36) PRIMARY KEY,
    type                                   VARCHAR(100),
    value                                  VARCHAR(500),
    code                                   VARCHAR(255),
    description                            TEXT,
    keycloak_id                            VARCHAR(100),
    keycloak_name                          VARCHAR(100),
    policy_id                              VARCHAR(100),
    individual_organization_permissions_id VARCHAR(30),
    status                                 INTEGER,
    sso_id                                 VARCHAR(30),
    create_at                              TIMESTAMP,
    create_by                              VARCHAR(100),
    update_at                              TIMESTAMP,
    update_by                              VARCHAR(100),
    CONSTRAINT fk_individual_organization_permissions FOREIGN KEY (individual_organization_permissions_id) REFERENCES individual_organization_permissions(id)
);

-- organization
CREATE TABLE organization
(
    id             VARCHAR(36) NOT NULL PRIMARY KEY,
    name           VARCHAR(255) NULL,
    image          VARCHAR(500) NULL,
    business_type  VARCHAR(255) NULL,
    founding_date  TIMESTAMP NULL,
    email          VARCHAR(200) NULL,
    phone          VARCHAR(12) NULL,
    province_code  VARCHAR(5) NULL,
    district_code  VARCHAR(5) NULL,
    precinct_code  VARCHAR(5) NULL,
    street_block   VARCHAR(200) NULL,
    state          SMALLINT NULL,
    status         SMALLINT NULL,
    create_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    create_by      VARCHAR(255) NULL,
    update_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    update_by      VARCHAR(255) NULL,
    tax_department VARCHAR(255) NULL,
    org_type       VARCHAR(20) NULL,
    nation         VARCHAR(150) NULL
);

