CREATE TABLE IF NOT EXISTS post
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(2000),
    description TEXT,
    created TIMESTAMP without time zone NOT NULL DEFAULT now()
);