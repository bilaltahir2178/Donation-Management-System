create database donations

use donations

create table beneficiaryprojects(
project varchar(30),
beneficiary varchar(30))

create table project(
nam varchar(30) primary key,
descrip varchar(200),
manager varchar(30),
budget int
)


create table issuedonations(
project varchar(30),
beneficiary varchar(30),
amount int,
weight int)


insert into issuedonations values('project 1','salman',10,20)

delete from project
delete from volunteer
delete from donor
update volunteer set avail = 1

 select * from beneficiaryprojects

 delete from beneficiaryprojects



insert into project values('Usama','sad','no',10)
insert into project values('Bilal')


select * from donor
select * from project

select count(nam) from project where nam like 'test 1'

go 

create table donation(
project varchar(30),
donor varchar(30),
dontype varchar(5),
amount int)
go

create table volunteer(
nam varchar(30),
cnic varchar(30) primary key,
addr varchar (100),
phone varchar(20),
dob varchar(10),
avail bit)

select * from volunteer where nam like 'SHAHZAIB'


create table donor(
nam varchar(30),
cnic varchar(30) primary key,
addr varchar (100),
phone varchar(20),
dob varchar(10))

select * from donor
go
create table Beneficiary(
nam varchar(30),
cnic varchar(30) primary key,
addr varchar (100),
phone varchar(20),
dob varchar(10))

create table team(
project varchar(30),
volunteer varchar(30))



go
select * from Beneficiary
select * from project where manager like 'usama'

select count(nam) from project where nam like 'test'

go
create procedure addProject
@nam varchar(30), @desc varchar(200), @manager varchar(30) , @budget int
as
begin

insert into project values(@nam,@desc,@manager,@budget)
end

create table projectvolunteers(
project varchar(30),
volunteer varchar(30))

go
create procedure addbeneficiaryprojects
@project varchar(30), @beneficiary varchar(30)
as
begin
insert into beneficiaryprojects values(@project,@beneficiary)
end

select * from beneficiary
go
create procedure addprojectvolunteers
@project varchar(30), @volunteer varchar(30)
as
begin
insert into projectvolunteers values(@project,@volunteer)
end

delete from projectvolunteers
select * from projectvolunteers
select * from donor 
select * from project
delete from donation
select * from donation
select * from Beneficiary
select sum(amount) from donation where donor like 'Bilal' and project like 'project'


go
select sum(amount) from donation where donor like 'Bilal Tahir' and project = 'project 1'




go
create procedure addDonation
@project varchar(30), @donor varchar(30), @type varchar(50) , @amount int
as
begin

insert into donation values(@project,@donor,@type,@amount)
end


go
create procedure addDonor
@nam varchar(30),@phone varchar(11), @address varchar(200), @cnic varchar(20),@dob varchar(10)
as
begin

insert into donor values(@nam,@cnic,@address,@phone,@dob)
end

go
create procedure addBeneficiary
@nam varchar(30),@phone varchar(11), @address varchar(200), @cnic varchar(20),@dob varchar(10)
as
begin
insert into Beneficiary values(@nam,@cnic,@address,@phone,@dob)
end

go
create procedure addVolunteer
@avail bit , @nam varchar(30), @cnic varchar(30), @address varchar(100) , @phone varchar(21) , @dob varchar(10)
as
begin

insert into volunteer values(@nam,@cnic,@address,@phone,@dob,@avail)

end


