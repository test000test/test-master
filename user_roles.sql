create table user_roles
(
    id   integer not null
        primary key,
    name varchar(100),
    role varchar(60)
);

alter table user_roles
    owner to postgres;

