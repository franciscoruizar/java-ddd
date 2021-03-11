--
-- Table structure for table roles
--

CREATE TABLE IF NOT EXISTS roles (
  id char(36) NOT NULL,
  name varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table modules
--

CREATE TABLE IF NOT EXISTS modules (
  id char(36) NOT NULL,
  name varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--
-- Table structure for table actions
--

CREATE TABLE IF NOT EXISTS actions (
  id char(36) NOT NULL,
  method varchar(45) NOT NULL,
  module_id char(36) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_actions__modules (module_id),
  CONSTRAINT fk_actions__modules FOREIGN KEY (module_id) REFERENCES modules (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table authorizations
--

CREATE TABLE IF NOT EXISTS authorizations (
  role_id char(36) NOT NULL,
  action_id char(36) NOT NULL,
  PRIMARY KEY (role_id,action_id),
  KEY fk_authorizations__actions (action_id),
  CONSTRAINT fk_authorizations__actions FOREIGN KEY (action_id) REFERENCES actions (id),
  CONSTRAINT fk_authorizations__roles FOREIGN KEY (role_id) REFERENCES roles (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table users
--

CREATE TABLE IF NOT EXISTS users (
  id char(36) NOT NULL,
  username varchar(320) UNIQUE NOT NULL,
  email varchar(320) NOT NULL,
  password varchar(320) NOT NULL,
  name varchar(45) NOT NULL,
  lastname varchar(45) NOT NULL,
  phone varchar(25) NOT NULL,
  profile_photo_url text NOT NULL,
  created_date datetime NOT NULL,
  updated_date datetime NOT NULL,
  deleted_date datetime DEFAULT NULL,
  role_id char(36) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_users__roles (role_id),
  CONSTRAINT fk_users__roles FOREIGN KEY (role_id) REFERENCES roles (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table sessions
--

CREATE TABLE IF NOT EXISTS sessions (
  id char(36) NOT NULL,
  token text NOT NULL,
  user_id char(36) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_sessions__users (user_id),
  CONSTRAINT fk_sessions__users FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
