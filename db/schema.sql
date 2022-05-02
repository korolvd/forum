CREATE TABLE IF NOT EXISTS post
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(2000),
    description TEXT,
    created TIMESTAMP without time zone NOT NULL DEFAULT now()
);

CREATE TABLE IF NOT EXISTS users
(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);