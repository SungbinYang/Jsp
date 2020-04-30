create table board (
	seq int(11) not null primary key auto_increment comment '글번호',
	title varchar(255) not null comment '제목',
	content text not null default '' comment '내용',
	regdate datetime not null default current_timestamp() comment '등록일시',
	writer varchar(20) not null comment '등록자',
	cnt int(11) not null default 0 comment '조회수'
);
