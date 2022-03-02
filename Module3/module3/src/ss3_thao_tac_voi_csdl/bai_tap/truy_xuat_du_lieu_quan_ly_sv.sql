use quan_ly_sinh_vien;

select * from student
where student_name like "h%";

select * from class
where start_date like "%12%";

select * from `subject`
where credit between 3 and 5;

SET SQL_SAFE_UPDATES = 0;
update student
set id_class = 2
where student_name = 'Hung';
SET SQL_safe_updates = 1;
select * from student;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT S.student_name , Subj.sub_name, M.mark
FROM student S 
JOIN mark M on S.student_id = M.student_id
JOIN `subject` Subj on M.sub_id = Subj.sub_id
ORDER BY mark DESC ,student_name ASC;
 