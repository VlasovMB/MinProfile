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
    first_name VARCHAR(100),
    last_name  VARCHAR(100),
    balance    FLOAT,
    user_id    INT UNIQUE,

    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Insert users
INSERT INTO users
VALUES (null, 'admin', '$2a$10$Xl/H1gV4/NdFWO7yl/GxVulQeITTN.lbG7MaOPPp9KzqMy2FfwlEK');
INSERT INTO users
VALUES (null, 'user', '$2a$10$o/vo56LPaCUCtStfALL53OfwhncGY.JXCqfssLx0eqW5h9qpHd95.');
INSERT INTO users
VALUES (null, 'user2', '$2a$10$pb6hq87G38DYEKynkOdFgOiNUUzdbC058A17dDsMMsE8AXEKyu3WK');

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
VALUES (null, 'jdbc:h2:mem:admin', 'username:sa password: ', 1000000.01, 1);
INSERT INTO accounts
VALUES (null, 'пользователь', 'богатый', 50000.56, 2);
INSERT INTO accounts
VALUES (null, 'тестовый', 'без денег', 0, 3);
