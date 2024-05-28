INSERT INTO public.customer(
	added_on, contact, updated_on, added_by, customer_email, customer_first_name, customer_last_name, customer_password, updated_by)
	VALUES ('2024-05-08 16:00:09.54997', 9876543245, '2024-05-10 12:00:09.54997', 'mainak', 'ganesh@gmail.com', 'sweta', 'das', 'sweta12', 'priyanka');

INSERT INTO public.account(
	account_balance, account_number, customer_customer_id, added_on, opened_date, update_on, account_type, addedby, update_by)
	VALUES (1000, 787645, 1, '2024-05-23 16:00:09.54997', '2024-05-21 18:00:10.54997', '2024-05-27 13:45:09.54997', 'SAVINGS', 'piku', 'sima');

INSERT INTO public._user(
	email, first_name, last_name, password, role)
	VALUES ('test@gmail.com', 'Bubu', 'Sen', '245263', 'MANAGER');

INSERT INTO public._user(
	email, first_name, last_name, password, role)
	VALUES ('ganesh@gmail.com', 'Bubu', 'Sen', '244445', 'MANAGER');