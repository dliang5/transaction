# --- !Ups

CREATE TABLE transactions
(
    user_id VARCHAR(250) NOT NULL,
    transaction_id INTEGER NOT NULL DEFAULT(1),
    transaction_amount INTEGER NOT NULL DEFAULT(0),
    transaction_date DATE NOT NULL DEFAULT CURRENT_DATE

);

CREATE TABLE transaction_summaries
(
    user_id VARCHAR(250) NOT NULL,
    transaction_month1 INTEGER NOT NULL DEFAULT(0),
    transaction_month2 INTEGER NOT NULL DEFAULT(0),
    transaction_month3 INTEGER NOT NULL DEFAULT(0),
    transaction_totals INTEGER NOT NULL DEFAULT(0)
);

# --- !Downs
DROP TABLE transactions
DROP TABLE transaction_summaries