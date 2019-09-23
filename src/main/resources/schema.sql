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
    EMAIL       VARCHAR(50)     NOT NULL,
    USERNAME    VARCHAR(10)     NOT NULL,
    PASSWORD    VARCHAR(300)    NOT NULL
);

DROP TABLE IF EXISTS USUARIO_ROLES;
CREATE TABLE USUARIO_ROLES(       
    USUARIO_ID  INT     NOT NULL,
    ROL_ID		INT		NOT NULL 
);

DROP TABLE IF EXISTS ACTIVIDAD;
CREATE TABLE ACTIVIDAD(
	ID						INT						AUTO_INCREMENT  PRIMARY KEY,
	CLIENTE					VARCHAR(255)			NOT NULL,
	COBRO					INT						NOT NULL,
	ELABORADO_POR			VARCHAR(255)			NOT NULL,
	FECHA_CREACION			TIMESTAMP				NOT NULL,
	HORA_ENTRADA_MANANA		TIMESTAMP				NOT NULL,
	HORA_ENTRADA_TARDE		TIMESTAMP				NOT NULL,
	HORA_SALIDA_MANANA		TIMESTAMP				NOT NULL,
	HORA_SALIDA_TARDE		TIMESTAMP				NOT NULL,
	INCIDENCIA				VARCHAR(255)			NOT NULL,
	OTROS					VARCHAR(255)			NOT NULL,
	PEDIDO					INT						NOT NULL,
	POBLACION				VARCHAR(255)			NOT NULL,
	VISITA					INT						NOT NULL
);

DROP TABLE IF EXISTS REPORTE;
CREATE TABLE REPORTE(
	ID						INT						AUTO_INCREMENT  PRIMARY KEY,
	NUMERO					VARCHAR(255)			NOT NULL,
	ELABORADO_POR			VARCHAR(255)			NOT NULL,
	FECHA_DESDE				TIMESTAMP				NOT NULL,
	FECHA_HASTA				TIMESTAMP				NOT NULL,
	FECHA_CREACION			TIMESTAMP				NOT NULL,
	TIPO					VARCHAR(255)			NOT NULL
);

DROP TABLE IF EXISTS REPORTE_ACTIVIDAD;
CREATE TABLE REPORTE_ACTIVIDAD(
	ID_REPORTE_ACTIVIDAD	INT		AUTO_INCREMENT	PRIMARY KEY,
	ID_REPORTE				INT		NOT NULL,
	ID_ACTIVIDAD			INT		NOT NULL
);

-- SECUENCIAS
DROP SEQUENCE IF EXISTS ROL_ID_SEQ;
DROP SEQUENCE IF EXISTS USUARIO_ID_SEQ;
DROP SEQUENCE IF EXISTS VISITA_ID_SEQ;
DROP SEQUENCE IF EXISTS ACTIVIDAD_ID_SEQ;
DROP SEQUENCE IF EXISTS REPORTE_ID_SEQ;
DROP SEQUENCE IF EXISTS REPORTE_ACTIVIDAD_ID_SEQ;

CREATE SEQUENCE ROL_ID_SEQ;
CREATE SEQUENCE USUARIO_ID_SEQ;
CREATE SEQUENCE VISITA_ID_SEQ;
CREATE SEQUENCE ACTIVIDAD_ID_SEQ;
CREATE SEQUENCE REPORTE_ID_SEQ;
CREATE SEQUENCE REPORTE_ACTIVIDAD_ID_SEQ;

/*
-- POSTGRES

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
    ID	        INT		DEFAULT NEXTVAL('USUARIO_ID_SEQ')	PRIMARY KEY	NOT NULL,
    FIRST_NAME  TEXT    												NOT NULL,
    LAST_NAME   TEXT                                					NOT NULL,
    EMAIL       TEXT                                					NOT NULL,
    USERNAME    TEXT                                					NOT NULL,
    PASSWORD    TEXT                                					NOT NULL
);

-- TABLA: USUARIO_ROLES
DROP TABLE IF EXISTS USUARIO_ROLES;
CREATE TABLE USUARIO_ROLES(       
    USUARIO_ID	INT		NOT NULL,
    ROL_ID		INT		NOT NULL 
);

-- TABLA: ACTIVIDAD
DROP TABLE IF EXISTS ACTIVIDAD;
CREATE TABLE ACTIVIDAD(
	ID	        			INT		DEFAULT NEXTVAL('ACTIVIDAD_ID_SEQ')	PRIMARY KEY	NOT NULL,
	CLIENTE					TEXT,
	COBRO					INT														NOT NULL,
	ELABORADO_POR			TEXT,
	FECHA_CREACION			TIME													NOT NULL,
	HORA_ENTRADA_MANANA		TIME													NOT NULL,
	HORA_ENTRADA_TARDE		TIME													NOT NULL,
	HORA_SALIDA_MANANA		TIME													NOT NULL,
	HORA_SALIDA_TARDE		TIME													NOT NULL,
	INCIDENCIA				TEXT,
	OTROS					TEXT,
	PEDIDO					INT														NOT NULL,
	POBLACION				TEXT,
	VISITA					INT														NOT NULL
);

-- TABLA: REPORTE
DROP TABLE IF EXISTS REPORTE;
CREATE TABLE REPORTE(
	ID						INT		DEFAULT NEXTVAL('REPORTE_ID_SEQ')	PRIMARY KEY	NOT NULL,
	NUMERO					TEXT			NOT NULL,
	ELABORADO_POR			TEXT			NOT NULL,
	FECHA_DESDE				TIME			NOT NULL,
	FECHA_HASTA				TIME			NOT NULL,
	FECHA_CREACION			TIME			NOT NULL,
	TIPO					TEXT			NOT NULL
);

-- TABLA: REPORTE
DROP TABLE IF EXISTS REPORTE_ACTIVIDAD;
CREATE TABLE REPORTE_ACTIVIDAD(
	ID_REPORTE_ACTIVIDAD	INT		DEFAULT NEXTVAL('REPORTE_ACTIVIDAD_ID_SEQ')	PRIMARY KEY	NOT NULL,
	ID_REPORTE				INT		NOT NULL,
	ID_ACTIVIDAD			INT		NOT NULL
);
*/