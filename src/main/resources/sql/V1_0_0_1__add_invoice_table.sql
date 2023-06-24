CREATE TABLE invoices(
    uuid UUID DEFAULT MD5(RANDOM()::TEXT || CLOCK_TIMESTAMP()::TEXT)::UUID PRIMARY KEY,

    amount bigint DEFAULT 0,

    supplier_name VARCHAR(255),
    supplier_ICO VARCHAR(255),

    customer_name VARCHAR(255),
    customer_ICO VARCHAR(255),

    payment_type VARCHAR(255),

    invoice_date TIMESTAMP WITH TIME ZONE,                  -- datum vystavení
    invoice_due_date TIMESTAMP WITH TIME ZONE,              -- datum splatnosti
    invoice_fulfillment_date TIMESTAMP WITH TIME ZONE,      -- datum uskutočnění plnění

    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);