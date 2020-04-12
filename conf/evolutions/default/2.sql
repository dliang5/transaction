# --- !Ups
CREATE table transactions
(
    user_id UUID,
    transaction_amount INTEGER NOT NULL DEFAULT(0),
    transaction_date DATE NOT NULL DEFAULT CURRENT_DATE

)

CREATE table transaction_summaries
(
    user_id UUID
    total_transaction_amount INTEGER NOT NULL DEFAULT(0),
    transaction_month INTEGER NOT NULL DEFAULT(1)
    transaction_year INTEGER NOT NULL DEFAULT(2000)
)

# --- !Downs
DROP TABLE transactions
DROP TABLE transaction_summaries