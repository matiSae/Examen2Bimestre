-- database: ../DataBases/qmExoTrop.sqlite
DROP TABLE IF EXISTS ExoBot;
DROP TABLE IF EXISTS TipoArma;
DROP TABLE IF EXISTS TipoExobot;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE Usuario(
    IdUsuario                                                     INTEGER PRIMARY KEY AUTOINCREMENT
    ,Usuario                                                       VARCHAR(15) NOT NULL UNIQUE
    ,Contrasena                                                VARCHAR(15) NOT NULL
    ,Cedula                                                        VARCHAR(10) NOT NULL
    ,Estado                                                        VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion                                          DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica                                          DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE TipoExobot(
     IdTipoExobot                                            INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre                                                     VARCHAR(15)  NOT NULL UNIQUE
    ,Estado                                                       VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);
CREATE TABLE TipoArma (
     IdTipoArma                                                INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre                                                       VARCHAR(15)  NOT NULL UNIQUE
    ,Estado                                                       VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE Exobot (
     IdExobot                                                       INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdTipoExobot                                               INTEGER NOT NULL REFERENCES TipoExobot (IdTipoExobot)
    ,IdTipoArma                                                  INTEGER NOT NULL REFERENCES TipoArma        (IdTipoArma)
    ,Entreno                                                          VARCHAR(2) NOT NULL DEFAULT 'NO'
    ,NoAccion                                                       INTEGER  NOT NULL DEFAULT 0

    ,Estado                                                             VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

-- Insert initial data into Sexo table
INSERT INTO Usuario 
 (Usuario, Contrasena, Cedula)  VALUES 
('patmic',' 123','1728482140');

INSERT INTO TipoExobot
 (Nombre)  VALUES
 ('ExoAsalto')
,('ExoExplorador')
,('Exolnfanteria')
,('ExoMedico')
,('ExoComando');

INSERT INTO TipoArma
 (Nombre)  VALUES 
 ('Laser')
,('Bayoneta');

INSERT INTO EXOBOT
(IdTipoExobot, IdTipoArma) VALUES
(3, 1),
(1, 1),
(3, 1),
(4, 1);
