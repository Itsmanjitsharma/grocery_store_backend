CREATE TABLE Billing_Transaction (
    id SERIAL PRIMARY KEY,
    total_bill NUMERIC,
    payment_method VARCHAR(255),
    payment_status VARCHAR(255),
    customer_name VARCHAR(255),
    billing_date DATE,
    billing_type VARCHAR(255)
);

CREATE TABLE Billing (
    id SERIAL PRIMARY KEY,
    product VARCHAR(255),
    quantity NUMERIC,
    sell_cost NUMERIC,
    total_cost NUMERIC,
    bill_date DATE,
    billing_transaction_id BIGINT
);


CREATE TABLE Customer (
    customer_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    mobile VARCHAR(255),
    email VARCHAR(255),
    type VARCHAR(255)
);

CREATE TABLE store_inventory (
    id SERIAL PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,
    quantity DECIMAL NOT NULL,
    purchase_cost DECIMAL NOT NULL,
    sell_cost DECIMAL NOT NULL,
    wholesale_cost DECIMAL NOT NULL
);

CREATE TABLE stock_transactions (
    transaction_id SERIAL PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,
    quantity DECIMAL NOT NULL,
    purchase_cost DECIMAL(10, 2) NOT NULL,
    sell_cost DECIMAL(10, 2) NOT NULL,
    wholesale_cost DECIMAL(10, 2) NOT NULL,
    stock_value DECIMAL(10, 2) NOT NULL,
    party_name VARCHAR(255) NOT NULL,
    purchase_date DATE NOT NULL
);

CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    item VARCHAR(255),
    price DOUBLE PRECISION,
    quantity INT
);