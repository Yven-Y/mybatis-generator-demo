CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT '学生id',
  `name` varchar(255) NOT NULL COMMENT '学生姓名',
  `gender` tinyint(2) DEFAULT NULL COMMENT '学生性别，1男生，0女生',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into student (id, name, gender) values (1, '张三', 1);
insert into student (id, name, gender) values (2, '李四', 1);
insert into student (id, name, gender) values (3, '王五', 1);
insert into student (id, name, gender) values (4, '赵六', 1);