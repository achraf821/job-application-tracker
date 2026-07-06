CREATE TABLE application (
    id          BIGSERIAL PRIMARY KEY,
    company     VARCHAR(255) NOT NULL,
    position    VARCHAR(255) NOT NULL,
    status      VARCHAR(50)  NOT NULL DEFAULT 'TO_APPLY',
    applied_at  DATE,
    notes       TEXT,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP NOT NULL DEFAULT NOW()
);