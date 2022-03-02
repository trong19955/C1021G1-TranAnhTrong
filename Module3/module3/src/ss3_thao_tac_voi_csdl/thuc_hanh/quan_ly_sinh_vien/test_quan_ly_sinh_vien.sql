USE quan_ly_sinh_vien;

INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
 
SELECT * FROM class;
 
INSERT INTO student (student_id, student_name, address, phone, status_student, id_class)
VALUES (1,'Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_id, student_name, address, status_student, id_class)
VALUES (2, 'Hoa', 'Hai phong', 1, 2);
INSERT INTO student (student_id, student_name, address, phone, status_student, id_class)
VALUES (3, 'Manh', 'HCM', '0123123123', 0, 3);
SELECT * FROM student;

INSERT INTO `subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
SELECT * FROM `subject`;

INSERT INTO mark (mark_id, sub_id, student_id, mark, exam_times)
VALUES (1, 1, 1, 8, 1),
       (2, 1, 2, 10, 2),
       (3, 2, 1, 12, 1);
SELECT * FROM mark;