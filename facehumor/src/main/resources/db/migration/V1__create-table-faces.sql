CREATE TABLE faces (
                       id BIGSERIAL PRIMARY KEY,
                       photoURL VARCHAR(500),
                       joy BOOLEAN NOT NULL,
                       anger BOOLEAN NOT NULL,
                       surprise BOOLEAN NOT NULL,
                       sorrow BOOLEAN NOT NULL,
                       headwear BOOLEAN NOT NULL
);