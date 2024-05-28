
DROP TABLE IF EXISTS public._user CASCADE;

CREATE TABLE IF NOT EXISTS _user (
    id integer AUTO_INCREMENT PRIMARY KEY,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255)
);


DROP TABLE IF EXISTS CUSTOMER CASCADE;

CREATE TABLE public.customer
(
    customer_id integer AUTO_INCREMENT PRIMARY KEY,
    added_on timestamp(6) without time zone,
    contact bigint NOT NULL,
    updated_on timestamp(6) without time zone,
    added_by character varying(255),
    customer_email character varying(255),
    customer_first_name character varying(255),
    customer_last_name character varying(255),
    customer_password character varying(255),
    updated_by character varying(255)
);

DROP TABLE IF EXISTS public.ACCOUNT CASCADE;

CREATE TABLE public.account
(
    account_id integer AUTO_INCREMENT PRIMARY KEY,
    account_balance double precision NOT NULL,
    account_number integer NOT NULL,
    added_on timestamp(6) without time zone,
    opened_date timestamp(6) without time zone,
    update_on timestamp(6) without time zone,
    account_type character varying(255),
    addedby character varying(255),
    update_by character varying(255),
    customer_customer_id integer
);




