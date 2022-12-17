-- SQL script for table creation used in the project

DROP TABLE IF EXISTS public.television;

CREATE TABLE public.television
(
    id SERIAL PRIMARY KEY,
    model text NOT NULL,
    producer text NOT NULL,
    production_country text,
    width integer NOT NULL,
    height integer NOT NULL,
    CONSTRAINT positive_width_and_height CHECK (width > 0 AND height > 0)
)