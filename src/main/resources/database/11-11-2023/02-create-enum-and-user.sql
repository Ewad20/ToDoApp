--liquibase formatted sql
--changeset JanuaryDev:1
CREATE TYPE _role AS ENUM ('admin', 'user');

--liquibase formatted sql
--changeset JanuaryDev:2
CREATE TABLE users
(
    id                         SERIAL PRIMARY KEY,
    username                   VARCHAR(255) NOT NULL,
    password                   VARCHAR(255) NOT NULL,
    is_enabled                 BOOLEAN      NOT NULL,
    is_account_non_expired     BOOLEAN      NOT NULL,
    is_account_non_locked      BOOLEAN      NOT NULL,
    is_credentials_non_expired BOOLEAN      NOT NULL,
    role                       _role        NOT NULL
);
