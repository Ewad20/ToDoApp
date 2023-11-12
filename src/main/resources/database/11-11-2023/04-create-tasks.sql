--liquibase formatted sql
--changeset JanuaryDev:1
CREATE TABLE task
(
    id          SERIAL primary key,
    summary     varchar(1000) not null,
    description varchar(5000),
    start_date  date,
    end_date    date,
    category_id bigint references _category (id),
    status      bigint references status (id)
);