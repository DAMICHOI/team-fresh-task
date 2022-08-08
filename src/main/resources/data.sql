INSERT INTO CUSTOMER (company_name, manager_name, contact, created_at)
VALUES ('TEST1', '테스트', '01011111111', CURRENT_TIMESTAMP)
     , ('TEST2', '가나다', '01022222222', CURRENT_TIMESTAMP)
     , ('COMPANY', '김아무개', '01033333333', CURRENT_TIMESTAMP);

INSERT INTO CARRIER (carrier_name, company_name, created_at)
VALUES ('운송기사1', '회사1', CURRENT_TIMESTAMP)
     , ('운송기사2', '회사2', CURRENT_TIMESTAMP)
     , ('운송기사3', '회사3', CURRENT_TIMESTAMP);

INSERT INTO PENALTY (voc_id, created_at)
VALUES (1, CURRENT_TIMESTAMP)
     , (2, CURRENT_TIMESTAMP);
UPDATE PENALTY SET is_confirm = TRUE where id = 1;

INSERT INTO REPARATION (voc_id, amount, created_at)
VALUES (1, 50000, CURRENT_TIMESTAMP);

INSERT INTO VOC (type, contents, status, customer_id, carrier_id, penalty_id, reparation_id, created_at)
VALUES ('CARRIER', '다른 배송지로 운송되어 클레임 인입', 'PROCEED', 3, 1, 1, 1, CURRENT_TIMESTAMP)
     , ('CUSTOMER', '고객사의 물건 누락으로 배송 실수', 'END', 1, 2, NULL, NULL, CURRENT_TIMESTAMP);
