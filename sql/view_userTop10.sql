CREATE
OR REPLACE VIEW view_userTop10 AS
SELECT user_name, record_score
FROM userApplication
ORDER BY record_score DESC LIMIT 10;