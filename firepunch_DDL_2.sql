-- ID 부분만 동거님 DB에 맞게 수정해주시면 되요
-- process 컬럼 번호만 수정이 좀 된겁니다.
UPDATE firepunch.exporting_export
SET buyer_company_name='Acme Corporation', buyer_company_address='123 Main Street, Anytown, USA', buyer_company_tel='555-1234', buyer_email='acme@example.com', buyer_country='USA', incoterm='FOB', payment_method='TT', place_of_loading='INCHEON', place_of_unloading='SHANGHAI', contract_date='2024-10-15', deadline_date='2024-12-15', registered_datetime='2024-10-20 10:43:51', process=0, user_id=1
WHERE id=265;
UPDATE firepunch.exporting_export
SET buyer_company_name='Beta Industries', buyer_company_address='456 Oak Street, Somewhere, USA', buyer_company_tel='555-5678', buyer_email='beta@example.com', buyer_country='Canada', incoterm='FOB', payment_method='LC', place_of_loading='BUSAN', place_of_unloading='VANCOUVER', contract_date='2024-09-01', deadline_date='2024-11-21', registered_datetime='2024-10-20 10:43:51', process=3, user_id=1
WHERE id=266;
UPDATE firepunch.exporting_export
SET buyer_company_name='Kappa Corporation', buyer_company_address='707 Pine Street, Elsewhere Again, USA', buyer_company_tel='555-7890', buyer_email='kappa@example.com', buyer_country='USA', incoterm='DDP', payment_method='LC', place_of_loading='BUSAN', place_of_unloading='LOSANGELES', contract_date='2024-07-25', deadline_date='2024-11-29', registered_datetime='2024-10-20 10:43:51', process=2, user_id=1
WHERE id=274;
