--liquibase formatted sql
--changeset Perevertaylo Ilya:2025-08-07-create-table-notification-outbox

CREATE TABLE IF NOT EXISTS notification_outbox (
    id          UUID            NOT NULL    DEFAULT gen_random_uuid()   PRIMARY KEY,
    created_at  TIMESTAMPTZ     NOT NULL    DEFAULT now(),
    topic       VARCHAR(255)    NOT NULL,
    key         UUID            NOT NULL,
    value       JSONB           NOT NULL,
    sent        BOOLEAN         NOT NULL    DEFAULT FALSE,
    attempt     INTEGER         NOT NULL    DEFAULT 0
)