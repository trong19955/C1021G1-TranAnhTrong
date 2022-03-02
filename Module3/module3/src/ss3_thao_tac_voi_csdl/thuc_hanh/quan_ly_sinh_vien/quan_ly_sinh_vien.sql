drop database if exists quan_ly_sinh_vien;
create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

create table class(
id_class int primary key,
name_class varchar(50) null,
start_date date,
status_class bit null
);

create table student(
student_id int primary key,
student_name varchar(50) null,
address varchar(50) null,
phone int,
status_student bit,
id_class int,
foreign key(id_class) references class(id_class)
);
create table `subject`(
sub_id int primary key,
sub_name varchar(50) null,
credit int,
status_name bit
);
create table mark(
mark_id int primary key,
sub_id int,
foreign key(sub_id) references `subject`(sub_id),
student_id int,
foreign key(student_id) references student(student_id),
mark int,
exam_times int
);