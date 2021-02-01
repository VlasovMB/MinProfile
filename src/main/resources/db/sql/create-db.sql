-- Table: users
CREATE TABLE users
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Table: roles
CREATE TABLE roles
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE
);

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles
(
    id      INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
);

--Table: accounts
CREATE TABLE accounts
(
    id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    balance    FLOAT,
    user_id    INT UNIQUE,

    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Insert users
INSERT INTO users
VALUES (null, 'admin', '123');
INSERT INTO users
VALUES (null, 'user', 'user');
INSERT INTO users
VALUES (null, 'user2', 'user2');

-- Insert roles
INSERT INTO roles
VALUES (null, 'role_user');
INSERT INTO roles
VALUES (null, 'role_admin');

-- Insert mapping user_roles
INSERT INTO user_roles
VALUES (null,1, 2);
INSERT INTO user_roles
VALUES (null,1, 1);
INSERT INTO user_roles
VALUES (null,2, 1);
INSERT INTO user_roles
VALUES (null,3, 1);

-- Insert account
INSERT INTO accounts
VALUES (null, 'super', 'class', 1000000.01, 1);
INSERT INTO accounts
VALUES (null, 'v', 'vendetta', 1000000.01, 2);
INSERT INTO accounts
VALUES (null, 'mac', 'os', 0, 3);
