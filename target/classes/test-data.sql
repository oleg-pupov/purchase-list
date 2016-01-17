INSERT INTO users (name, password, enabled) VALUES ('oleg', 'password', true);
INSERT INTO users (name, password, enabled) VALUES ('lena', 'password', true);

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 1);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 2);


INSERT INTO pencils (color) VALUES ('red');
INSERT INTO pencils (color) VALUES ('blue');
INSERT INTO pencils (color) VALUES ('green');
