CREATE TABLE IF NOT EXISTS modules (
    id   CHAR(36)    NOT NULL,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS actions (
    id        CHAR(36)    NOT NULL,
    name      VARCHAR(45) NOT NULL,
    module_id CHAR(36)    NOT NULL,
    PRIMARY KEY (id),
	constraint fk_actions__modules FOREIGN KEY (module_id) REFERENCES modules (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS roles (
    id   CHAR(36)    NOT NULL,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS role_actions (
    role_id   CHAR(36) NOT NULL,
    action_id CHAR(36) NOT NULL,
	PRIMARY KEY (role_id, action_id),
	CONSTRAINT fk_role_actions__roles FOREIGN KEY (role_id) REFERENCES roles (id),
	CONSTRAINT fk_role_actions__actions FOREIGN KEY (action_id) REFERENCES actions (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS users (
    id                CHAR(36)     NOT NULL,
    username          VARCHAR(320) NOT NULL,
    email             VARCHAR(320) NOT NULL,
    password          VARCHAR(320) NOT NULL,
    name              VARCHAR(45)  NOT NULL,
    lastname          VARCHAR(45)  NOT NULL,
    phone             VARCHAR(25)  NOT NULL,
    profile_photo_url TEXT         NOT NULL,
    created_date      DATETIME     NOT NULL,
    updated_date      DATETIME     NOT NULL,
    deleted_date      DATETIME     NOT NULL,
    role_id           CHAR(36)     NOT NULL,
    PRIMARY KEY (id),
	CONSTRAINT fk_users__roles FOREIGN KEY (role_id) REFERENCES roles (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS sessions (
    id      CHAR(36) NOT NULL,
    token   TEXT     NOT NULL,
    user_id CHAR(36) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_sessions__users FOREIGN KEY (user_id) REFERENCES users (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
