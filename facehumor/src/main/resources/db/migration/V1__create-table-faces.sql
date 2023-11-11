CREATE TABLE faces (
                       id BIGSERIAL PRIMARY KEY,
                       photoURL VARCHAR(2000) NOT NULL,
                       joy SMALLINT NOT NULL,
                       anger SMALLINT NOT NULL,
                       surprise SMALLINT NOT NULL,
                       sorrow SMALLINT NOT NULL,
                       headwear SMALLINT NOT NULL
);