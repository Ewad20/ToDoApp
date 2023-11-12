--liquibase formatted sql
--changeset JanuaryDev:1

CREATE TABLE status
(
    id           SERIAL PRIMARY KEY,
    name         varchar(255),
    display_name varchar(255),
    user_id      bigint references users (id)
);