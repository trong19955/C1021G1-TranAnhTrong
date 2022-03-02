use quan_ly_sinh_vien;

select*from student
where status_student = true ;

select* from `subject`
where credit < 10;

select s.student_id, s.student_name, a.name_class
from student s join class a on s.id_class = a.id_class;

select s.student_id, s.student_name, c.name_class
from student s join class c on s.id_class = c.id_class
where c.name_class = 'A2';

select s.student_id, s.student_name, sub.sub_name, m.mark
from student s join mark m on s.student_id = m.student_id join subject sub on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';