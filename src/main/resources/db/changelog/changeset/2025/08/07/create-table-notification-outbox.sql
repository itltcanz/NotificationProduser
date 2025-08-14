--liquibase formatted sql
--changeset Perevertaylo Ilya:2025-08-07-create-table-notification

CREATE TABLE IF NOT EXISTS notification (
    id          UUID            NOT NULL    DEFAULT gen_random_uuid()   PRIMARY KEY,
    created_at  TIMESTAMP       NOT NULL    DEFAULT now(),
    topic       VARCHAR(255)    NOT NULL,
    key         VARCHAR(36)     NOT NULL,
    value       TEXT            NOT NULL,
    sent        BOOLEAN         NOT NULL    DEFAULT FALSE,
    attempt     INTEGER         NOT NULL    DEFAULT 1
)