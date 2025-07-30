CREATE TABLE product(
    id SERIAL PRIMARY KEY, -- auto increment
    name VARCHAR(100) NOT NULL,
    price NUMERIC(5,2) NOT NULL, -- 5 num no total, só 2 dps da virgula
    quantity INTEGER DEFAULT 0,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE
);