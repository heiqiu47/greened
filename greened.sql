-- ----------------------------
-- 1、用户表
-- ----------------------------
drop table if exists user;
create table user
(
    user_id       bigint(20)   not null auto_increment comment '用户ID',
    user_phone    varchar(11)  not null UNIQUE comment '手机号码',
    user_password varchar(100) not null comment '密码',
    user_type     char(1)      default '1' comment '用户类型（0系统用户）',
    nick_name     varchar(30)  default 'user' comment '用户名称',
    user_sex      char(1) comment '用户性别（0男 1女 2未知）',
    user_avatar   varchar(100) default '' comment '头像地址',
    login_date    datetime comment '最后登录时间',
    create_time   datetime comment '创建时间',
    update_time   datetime comment '更新时间',
    primary key (user_id)
) engine = innodb
  auto_increment = 100 comment = '用户表';

insert into user
values (100, '13322111111', '123456', '0', '湫', '0', '', sysdate(), sysdate(), sysdate());
insert into user
values (101, '15888888888', '123456', '1', '西瓜', '1', '', sysdate(), sysdate(), sysdate());

-- ----------------------------
-- 2、动态表
-- ----------------------------
drop table if exists post;
create table post
(
    post_id      int(20)      not null auto_increment comment '动态ID',
    user_id      int(20)      not null comment '动态发布者id',
    post_content varchar(255) not null comment '动态内容',
    post_img     varchar(100) default null comment '动态图片',
    post_star    int(5)       default 0,
    post_reply   int(5)       default 0,
    status       char(1)      default '0' comment '状态（0正常 1关闭）',
    create_time  datetime comment '创建时间',
    update_time  datetime comment '更新时间',
    primary key (post_id)
) engine = innodb comment = '动态表';

insert into post
values (1, 100, 'Hello World', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (2, 100, '你好世界', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (3, 101, 'Hello World', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (4, 102, '你好世界', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (5, 102, '西瓜好甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (6, 102, '西瓜不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (7, 102, '西瓜真的好甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (8, 102, '西瓜不真的甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (9, 102, '西瓜好真的甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (10, 102, '西瓜真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (11, 102, '西瓜真的真的好甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (12, 102, '西瓜真的真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (13, 102, '西瓜好真的真的甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (14, 102, '西瓜真的真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (15, 102, '冬瓜好甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (16, 102, '冬瓜不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (17, 102, '冬瓜真的好甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (18, 102, '冬瓜真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (19, 102, '冬瓜好真的甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (20, 102, '冬瓜真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (21, 102, '冬瓜好真的甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (22, 102, '冬瓜真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (23, 102, '南瓜真的好甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (24, 102, '南瓜不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (25, 102, '南瓜真的不甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (26, 101, '南瓜甜', null, 0, 0, '0', sysdate(), sysdate());
insert into post
values (27, 101, '南瓜真的真的好甜', 0, 0, null, '0', sysdate(), sysdate());
insert into post
values (28, 103, '南瓜真的真的不甜', 0, 0, null, '0', sysdate(), sysdate());
insert into post
values (29, 101, '南瓜真的真的不甜', 0, 0, null, '0', sysdate(), sysdate());

-- ----------------------------
-- 3、关注表
-- ----------------------------
drop table if exists follow;
create table follow
(
    follow_id      int(20) not null auto_increment comment '关注ID',
    user_id        int(20) not null comment '用户id',
    follow_user_id int(20) default null comment '被关注者ID',
    create_time    datetime comment '创建时间',
    primary key (follow_id)
) engine = innodb comment = '关注表';

insert into follow
values (1, 101, 100, sysdate());


-- ----------------------------
-- 4、点赞表
-- ----------------------------
drop table if exists star;
create table star
(
    star_id     int(20) not null auto_increment comment '点赞ID',
    user_id     int(20) not null comment '用户ID',
    post_id     int(20) default null comment '动态ID',
    create_time datetime comment '创建时间',
    primary key (star_id)
) engine = innodb comment = '点赞表';

insert into star
values (1, 100, 1, sysdate());

-- ----------------------------
-- 5、评论与回复表
-- ----------------------------
drop table if exists reply;
create table reply
(
    reply_id      int(20)      not null auto_increment comment '评论与回复ID',
    user_id       int(20)      not null comment '用户ID',
    post_id       int(20) default null comment '动态ID',
    reply_content varchar(255) not null comment '评论与回复内容',
    reply_user_id int(20) default null comment '被评论与回复者ID',
    create_time   datetime comment '创建时间',
    primary key (reply_id)
) engine = innodb comment = '评论与回复表';

insert into reply
values (1, 101, 1, '你好', 100, sysdate());