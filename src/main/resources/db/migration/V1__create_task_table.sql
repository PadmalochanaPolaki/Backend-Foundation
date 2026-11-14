CREATE TABLE task (
    task_id          VARCHAR(36)  PRIMARY KEY,
    task_name        VARCHAR(255) NOT NULL,
    task_description TEXT,
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);