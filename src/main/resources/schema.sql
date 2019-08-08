DROP TABLE IF EXISTS ROL;
CREATE TABLE ROL(
    ID          INT             AUTO_INCREMENT  PRIMARY KEY,
    NAME        VARCHAR(30)     NOT NULL,
    DESCRIPTION VARCHAR(250)    NOT NULL
);

DROP TABLE IF EXISTS USUARIO;
CREATE TABLE USUARIO(
    ID          INT             AUTO_INCREMENT  PRIMARY KEY,
    FIRST_NAME  VARCHAR(20)     NOT NULL,
    LAST_NAME   VARCHAR(20)     NOT NULL,
    EMAIL       VARCHAR(30)     NOT NULL,
    USERNAME    VARCHAR(10)     NOT NULL,
    PASSWORD    VARCHAR(300)    NOT NULL
);

DROP TABLE IF EXISTS USUARIO_ROLES;
CREATE TABLE USUARIO_ROLES(       
    USUARIO_ID  INT     NOT NULL,
    ROL_ID	INT	NOT NULL 
);

/*
-- SECUENCIAS
DROP SEQUENCE ROL_ID_SEQ;
DROP SEQUENCE USUARIO_ID_SEQ;
CREATE SEQUENCE ROL_ID_SEQ;
CREATE SEQUENCE USUARIO_ID_SEQ;


-- TABLA: ROL
DROP TABLE IF EXISTS ROL;
CREATE TABLE ROL(
    ID       	INT		DEFAULT NEXTVAL('ROL_ID_SEQ')	PRIMARY KEY	NOT NULL,
    NAME        TEXT                                				NOT NULL,
    DESCRIPTION TEXT                                				NOT NULL
);

-- TABLA: USUARIO
DROP TABLE IF EXISTS USUARIO;
CREATE TABLE USUARIO(
    ID	         INT		DEFAULT NEXTVAL('USUARIO_ID_SEQ')	PRIMARY KEY	NOT NULL,
    FIRST_NAME  TEXT    								NOT NULL,
    LAST_NAME   TEXT                                					NOT NULL,
    EMAIL       TEXT                                					NOT NULL,
    USERNAME    TEXT                                					NOT NULL,
    PASSWORD    TEXT                                					NOT NULL
);

-- TABLA: USUARIO_ROLES
DROP TABLE IF EXISTS USUARIO_ROLES;
CREATE TABLE USUARIO_ROLES(       
    USUARIO_ID	INT		NOT NULL,
    ROL_ID	INT		NOT NULL 
);  
*/