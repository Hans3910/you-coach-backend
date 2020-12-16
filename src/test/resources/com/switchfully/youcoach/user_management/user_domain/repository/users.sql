INSERT INTO topic_name (name) VALUES ('Mathematics');
INSERT INTO topic_name (name) VALUES ('English');
INSERT INTO topic_name (name) VALUES ('Dutch');
INSERT INTO topic_name (name) VALUES ('Biology');
INSERT INTO topic_name (name) VALUES ('History');
INSERT INTO topic_name (name) VALUES ('Java');
INSERT INTO public.topic (id, topic_name, is_first_grade, is_second_grade, is_third_grade, is_fourth_grade, is_fifth_grade, is_sixth_grade, is_seventh_grade) VALUES ('461c32d6c26a4d798e1a4889ab43443b', 'Java', true, true, true, true, true, false, false);
INSERT INTO public.topic (id, topic_name, is_first_grade, is_second_grade, is_third_grade, is_fourth_grade, is_fifth_grade, is_sixth_grade, is_seventh_grade) VALUES ('a3b0853243fb4e6588c38693747b7c2f', 'Biology', false, false, true, true, true, true, true);
INSERT INTO coachee (id) VALUES ('2b457aaa7a024144b4b4d5bf4de89a1e');
INSERT INTO coachee (id) VALUES ('890ef7dd86734f1ea6fda704ffd09384');
INSERT INTO coachee (id) VALUES ('a461bcfeaa264d648ad655fae39408ec');
INSERT INTO coachee (id) VALUES ('fa6f0fcea3c3453c827bcd3579ebb576');
INSERT INTO coachee (id) VALUES ('81f70231f922477498a4979963bc0156');
INSERT INTO coachee (id) VALUES ('92e8230220d747428df576c3195f6527');
INSERT INTO coachee (id) VALUES ('e8d0d2f6a1aa46ea957244a46c604648');
INSERT INTO coachee (id) VALUES ('536cc8f7c16b48649b0141cfe5dd9390');
INSERT INTO coachee (id) VALUES ('99b6666178ad4094a947c73022443aaf');
INSERT INTO coachee (id) VALUES ('cabd92a628f74f619ff940561ac4e4f4');
INSERT INTO coach (id, coach_xp, introduction, availability, topic_one_id, topic_two_id) VALUES ('123e4567e89b42d3a456556642440000', 450, 'I was a difficult student', 'Monday: 8:00-10:00', '461c32d6c26a4d798e1a4889ab43443b', 'a3b0853243fb4e6588c38693747b7c2f');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('442cf588d4484ee18d94a1701f5763ae', 'coachee1@mail.com', 'coachee', 'number1', '81f70231f922477498a4979963bc0156', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('7911f5a40192444da179aa694fd024ad', 'coachee2@mail.com', 'coachee', 'number2', '92e8230220d747428df576c3195f6527', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('c5718253b3ff497abb82587cf26d1338', 'alexschouten@student.com', 'Alex', 'Schouten', '99b6666178ad4094a947c73022443aaf', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('06bac24305a84dcc93823ed85b94e648', 'coachee@andcoach.com', 'Coachee', 'And Coach', '536cc8f7c16b48649b0141cfe5dd9390', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('588b228027c8488995a58a496647aa3d', 'guillermo@admin.com', 'Guillermo', 'Sáez Gómez', '2b457aaa7a024144b4b4d5bf4de89a1e', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('fbca4e37de504862affa37cba27389ec', 'hans@admin.com', 'Hans', 'Hendrickx', 'a461bcfeaa264d648ad655fae39408ec', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('54053b7b2f1245e3b1836fe4c7745442', 'sil@admin.com', 'Sil', 'Zoons', '890ef7dd86734f1ea6fda704ffd09384', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('4f9d820077074f40aa4433dc0ea46472', 'jeroen@admin.com', 'Jeroen', 'De Man', 'fa6f0fcea3c3453c827bcd3579ebb576', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('549e3e1d085742b1966ca125a4c34ed0', 'coachee3@student.com', 'coachee3', 'number3', 'cabd92a628f74f619ff940561ac4e4f4', null, '');
INSERT INTO users (id, email, first_name, last_name, coachee_id, coach_id, picture_url) VALUES ('92b85fa976e2430cba5e8b90e1f8c78f', 'christoph.marckx@gmail.com', 'Christoph', 'Marckx', 'e8d0d2f6a1aa46ea957244a46c604648', '123e4567e89b42d3a456556642440000', 'https://a4-images.myspacecdn.com/images03/3/c5e95d36dd404986bb96c16667d1db4d/300x300.jpg');