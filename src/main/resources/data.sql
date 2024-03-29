-- POSTGRES / H2
INSERT INTO USUARIO(ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('USUARIO_ID_SEQ'), 'scabrera', 'Santiago', 'Cabrera', 'santiago.cabrera.murillo@gmail.com', '$2a$04$WH2Ch6GCfKJpK8lTcSkfg.9yavgEMOFr3551WSApclkgWM2vzKqm.'); -- scabrera
INSERT INTO USUARIO(ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('USUARIO_ID_SEQ'), 'George', 'George', 'Apolo', 'grapoloutpl@gmail.com', '$2a$04$B/AznvHwy60JFTro3V3N8OWmo6kpLIDabOFNryzzSLpZn7G4xyune'); -- gr0119
INSERT INTO USUARIO(ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('USUARIO_ID_SEQ'), 'Frank', 'Frank', NULL, NULL, '$2a$04$Lh2sIf4GGRepsc.dLrexCuJPUrcot869xg3udXjRrj4IV4u6NW35e'); -- fr0219
INSERT INTO USUARIO(ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('USUARIO_ID_SEQ'), 'Vicente', 'Vicente', NULL, NULL, '$2a$04$Xr37LtfutO//iDVxoa7nN.bXkI/hBTqeuIsTcR9jNIl7N5XawpBSu'); -- vi0319
INSERT INTO USUARIO(ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('USUARIO_ID_SEQ'), 'Miguel', 'Miguel', NULL, NULL, '$2a$04$K/ZNCWsxP1l3dyl.92XKoeyNXFJQoLdY6C1FfHTUPfZX6Ai.5.w0.'); -- mi0419
INSERT INTO USUARIO(ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('USUARIO_ID_SEQ'), 'Agustin', 'Agustín', NULL, NULL, '$2a$04$NIzCBu9O0gmAxUMIKI2QKOcMAvhvzhJ5Op3cT.Cy45ZU7RTDUUaWO'); -- ag0519

INSERT INTO ROL(ID, DESCRIPTION, NAME) VALUES (NEXTVAL('ROL_ID_SEQ'), 'ROLE_ADMIN', 'ADMIN');
INSERT INTO ROL(ID, DESCRIPTION, NAME) VALUES (NEXTVAL('ROL_ID_SEQ'), 'ROLE_ALMACEN', 'ALMACEN');
INSERT INTO ROL(ID, DESCRIPTION, NAME) VALUES (NEXTVAL('ROL_ID_SEQ'), 'ROLE_COMERCIAL', 'COMERCIAL');
INSERT INTO ROL(ID, DESCRIPTION, NAME) VALUES (NEXTVAL('ROL_ID_SEQ'), 'ROLE_PROPIETARIO', 'PROPIETARIO');

INSERT INTO USUARIO_ROLES(USUARIO_ID, ROL_ID) VALUES(1, 1);
INSERT INTO USUARIO_ROLES(USUARIO_ID, ROL_ID) VALUES(2, 2);
INSERT INTO USUARIO_ROLES(USUARIO_ID, ROL_ID) VALUES(3, 3);
INSERT INTO USUARIO_ROLES(USUARIO_ID, ROL_ID) VALUES(4, 3);
INSERT INTO USUARIO_ROLES(USUARIO_ID, ROL_ID) VALUES(5, 4);
INSERT INTO USUARIO_ROLES(USUARIO_ID, ROL_ID) VALUES(6, 4);
