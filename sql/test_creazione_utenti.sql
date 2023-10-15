USE
fantasyDB;
fantasyDB
CREATE TABLE userApplication
(
    user_PK       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    user_name     VARCHAR(15) NOT NULL UNIQUE,
    user_password VARCHAR(15) NOT NULL,
    record_score  INT DEFAULT '0' CHECK (record_score > 0)
);
