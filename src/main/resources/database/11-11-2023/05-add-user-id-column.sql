--liquibase formatted sql
--changeset JanuaryDev:1
ALTER TABLE task
    ADD COLUMN user_id bigint references users(id);