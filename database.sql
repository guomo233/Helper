create database helper character set utf8 ;

use helper ;

create table task (taskId int auto_increment primary key, city varchar(50), beginPosition varchar(50), endPosition varchar(50), beginTime datetime, endTime datetime, remark text, demand text, status int, pay decimal(10, 1), receiveUsername varchar(20) references user(username), releaseUsername varchar(20) references user(username), updateTime datetime) ;

create table user (username varchar(20) primary key, password varchar(20), phone varchar(11), finishTimes int, evaluate float(3,2), sex varchar(10)) ;

create table massage (massageId int auto_increment primary key, senderUsername varchar(20) references user(username), targetUsername varchar(20) references user(username), title text, content text, sendTime datetime, isSkimed boolean) ;

create table recording (recordingId int auto_increment primary key, username varchar(20), action text, updateTime datetime) ;