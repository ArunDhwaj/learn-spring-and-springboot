INSERT INTO user_details(id, birth_date, name)
values('1001', current_date(), 'Abhishek');

INSERT INTO user_details(id, birth_date, name)
values('1002', current_date(), 'Aarush');

INSERT INTO post(id, description, user_id)
values('2001', 'I want to learn AWS', 1001);

INSERT INTO post(id, description, user_id)
values('2002', 'I want to learn DevOps', 1001);

INSERT INTO post(id, description, user_id)
values('2003', 'I want to learn GCP', 1002);

INSERT INTO post(id, description, user_id)
values('2004', 'I want to learn multi-cloud', 1002);
