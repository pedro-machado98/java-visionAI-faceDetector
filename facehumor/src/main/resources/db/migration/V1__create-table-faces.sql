CREATE TABLE faces (
                       id BIGSERIAL PRIMARY KEY,
                       photoURL VARCHAR(2000) NOT NULL,
                       joy BOOLEAN NOT NULL,
                       anger BOOLEAN NOT NULL,
                       surprise BOOLEAN NOT NULL,
                       sorrow BOOLEAN NOT NULL,
                       headwear BOOLEAN NOT NULL
);