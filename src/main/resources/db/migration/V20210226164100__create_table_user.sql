create table if not exists user
(
    id       varchar(50)    not null comment '用户id',
    username varchar(50)    not null comment '用户名称',
    email    varchar(50)    not null comment '用户邮箱',
    age      decimal(38, 4) null comment '用户年龄'
)
    engine = innoDB
    default charset = utf8mb4
    collate utf8mb4_bin
    comment '用户表';
