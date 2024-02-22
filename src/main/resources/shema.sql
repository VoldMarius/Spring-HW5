CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(20),
    date_create TIMESTAMP
);

INSERT INTO tasks (description, status, date_create)
VALUES ('Task 1', 'NOT_STARTED', 2022-01-01 00:00:00);

INSERT INTO tasks (description, status, date_create)
VALUES ('Task 2', 'IN_PROGRESS', 2022-01-01 00:00:00);

INSERT INTO tasks (description, status, date_create)
VALUES ('Task 3', 'COMPLETED', 2022-01-01 00:00:00);