use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from `subject` where credit = (select max(credit));

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select *
from subject
where sub_id = (select sub_id from mark where mark = (select max(mark.mark) from mark));

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg (ifnull(mark.mark,0)) as diem_trung_binh from student
left join mark on mark.student_id = student.student_id
group by student.student_id
order by mark.mark desc;