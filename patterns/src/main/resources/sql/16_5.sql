INSERT INTO POSTS (USER_ID, BODY) VALUES (4, 'I will do my task from ToDo list');

COMMIT;

UPDATE POSTS
SET BODY = 'To delete'
WHERE BODY = 'I will do my task from ToDo list';

COMMIT;

DELETE FROM POSTS
WHERE BODY = 'To delete';

COMMIT;