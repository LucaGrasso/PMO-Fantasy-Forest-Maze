DELIMITER
//
DROP PROCEDURE IF EXISTS ClassificaUser//
CREATE PROCEDURE ClassificaUser()
BEGIN
SELECT user_name, record_score
FROM userApplication
ORDER BY record_score desc;
END
//
DELIMITER ;