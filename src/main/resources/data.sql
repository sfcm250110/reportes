INSERT INTO USUARIO (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME) VALUES ('admin@admin.com', 'admin', 'admin', '$2a$04$/ziyQDLsLLPnhjR.Xb.UO.8hlPzXEWGmsyBrFpM/9W1U5kxAJmSVW', 'admin');

INSERT INTO ROL (DESCRIPTION, NAME) VALUES ('ROLE_ADMIN', 'ADMIN');
INSERT INTO ROL (DESCRIPTION, NAME) VALUES ('ROLE_USER', 'USER');
INSERT INTO ROL (DESCRIPTION, NAME) VALUES ('ROLE_SUPERVISOR', 'SUPERVISOR');

INSERT INTO USUARIO_ROLES (USUARIO_ID, ROL_ID) VALUES ('1', '1');