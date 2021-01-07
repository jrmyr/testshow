CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id uuid NOT NULL,
    prename varchar(64) NULL,
    lastname varchar(64) NULL,
    age int8 NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

INSERT INTO users VALUES
(uuid_generate_v1(),'Hans','Hamster', 43),
(uuid_generate_v1(),'Karl','Müller', 23),
(uuid_generate_v1(),'Gustav','Müllershausen', 65),
(uuid_generate_v1(),'Else','Schmitt', 23)
