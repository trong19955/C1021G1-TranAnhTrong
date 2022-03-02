drop database student_management1;
create database student_management1;

use student_management1;

create table student(
id_student int,
name_student varchar(70),
primary key (id_student)
 );
 
 insert into student value(1,"trong");
 select * from student;
 create table teacher(
 id_teacher int auto_increment,
 name_teacher varchar(70),
 age_teacher int,
 country_teacher varchar(70),
 primary key (id_teacher)
 );
 
 insert into teacher value(1,"haiTT",25,"danang");
 select * from teacher;