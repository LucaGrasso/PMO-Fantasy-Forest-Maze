/* Creazione DB */
DROP
DATABASE IF EXISTS fantasyDB;
CREATE
DATABASE fantasyDB DEFAULT CHARACTER SET latin1;
USE
fantasyDB;

/* Creo la tabella */
DROP TABLE IF EXISTS utenti;
CREATE TABLE utenti
(
    username     VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(180) NOT NULL,
    PRIMARY KEY(username)
) ENGINE=INNODB;


/* Popolo la tabella con dei dati
INSERT INTO utenti (user_PK, user_name, user_password, Sesso, record_score)
values (1, 'User1', '123456', 'M', 900),
       (2, 'User2', '123456', 'M', 780),
       (3, 'User3', '123456', 'F', 3000),
       (4, 'User4', '123456', 'X', 1000),
       (5, 'User5', '123456', 'F', 100),
       (6, 'User6', '123456', 'F', 900),
       (7, 'User7', '123456', 'X', 510),
       (8, 'User8', '123456', 'M', 10),
       (9, 'User9', '123456', 'M', 500),
       (10, 'User10', '123456', 'M', 100);*/