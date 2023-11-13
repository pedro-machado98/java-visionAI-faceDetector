CREATE TABLE faces (
                       id BIGSERIAL PRIMARY KEY,
                       photoURL VARCHAR(500),
                       name VARCHAR(255),
                       type VARCHAR(50),
                       face_img_data BYTEA,
                       joy BOOLEAN NOT NULL,
                       anger BOOLEAN NOT NULL,
                       surprise BOOLEAN NOT NULL,
                       sorrow BOOLEAN NOT NULL,
                       headwear BOOLEAN NOT NULL
);