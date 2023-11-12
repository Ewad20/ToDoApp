--liquibase formatted sql
--changeset JanuaryDev:1
CREATE TABLE category(
    id SERIAL primary key,
    name varchar(100),
    description varchar(400)
);