INSERT INTO user(user_id, name) VALUES (1, 'John');
INSERT INTO user(user_id, name) VALUES (2, 'Jan');

INSERT INTO code(code_id, name) VALUES (1, 'Email');
INSERT INTO code(code_id, name) VALUES (2, 'SMS');
INSERT INTO code(code_id, name) VALUES (3, 'Mail');

INSERT INTO user_codes(user_id, code_id) VALUES (1, 1);
INSERT INTO user_codes(user_id, code_id) VALUES (1, 2);

INSERT INTO user_codes(user_id, code_id) VALUES (2, 1);
INSERT INTO user_codes(user_id, code_id) VALUES (2, 2);
INSERT INTO user_codes(user_id, code_id) VALUES (2, 3);