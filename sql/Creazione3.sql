/* Creazione DB */
DROP
    DATABASE IF EXISTS fantasyDB;
CREATE
    DATABASE fantasyDB DEFAULT CHARACTER SET latin1;
USE
    fantasyDB;

/* Creo la tabella */
DROP TABLE IF EXISTS userApplication;
CREATE TABLE userApplication
(
    /*user_PK       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,*/
    user_name     VARCHAR(15) NOT NULL UNIQUE,
    user_password VARCHAR(15) NOT NULL,
    /*Sesso         ENUM('M', 'F','X'),*/
    Sesso         VARCHAR(1),
    record_score  INT DEFAULT 0 CHECK (record_score > -1)
) ENGINE = INNODB;


/* Popolo la tabella con dei dati */
INSERT INTO userApplication (/*user_PK,*/ user_name, user_password, Sesso, record_score)
values ('User1', '123456', 'M', 900),
       ('User2', '123456', 'M', 780),
       ('User3', '123456', 'F', 3000),
       ('User4', '123456', 'X', 1000),
       ('User5', '123456', 'F', 100),
       ('User6', '123456', 'F', 900),
       ('User7', '123456', 'X', 510),
       ('User8', '123456', 'M', 10),
       ('User9', '123456', 'M', 500),
       ('User10', '123456', 'M', 100);