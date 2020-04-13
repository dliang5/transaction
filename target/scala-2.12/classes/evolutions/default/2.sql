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
    transaction_summary_id INTEGER NOT NULL DEFAULT(1),
    transaction_month1 INTEGER NOT NULL DEFAULT(1),
    transaction_month2 INTEGER NOT NULL DEFAULT(1),
    transaction_month3 INTEGER NOT NULL DEFAULT(1),
    transaction_month4 INTEGER NOT NULL DEFAULT(1),
    transaction_month5 INTEGER NOT NULL DEFAULT(1),
    transaction_month6 INTEGER NOT NULL DEFAULT(1),
    transaction_month7 INTEGER NOT NULL DEFAULT(1),
    transaction_month8 INTEGER NOT NULL DEFAULT(1),
    transaction_month9 INTEGER NOT NULL DEFAULT(1),
    transaction_month10 INTEGER NOT NULL DEFAULT(1),
    transaction_month11 INTEGER NOT NULL DEFAULT(1),
    transaction_month12 INTEGER NOT NULL DEFAULT(1),
    transaction_year INTEGER NOT NULL DEFAULT(2000)
);

# --- !Downs
DROP TABLE transactions
DROP TABLE transaction_summaries