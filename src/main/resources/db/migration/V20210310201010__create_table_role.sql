create table if not exists role
(
    id          varchar(50) not null comment '角色id',
    name        varchar(50) not null comment '角色名称',
    description varchar(50) not null comment '角色描述'
)
    engine = innoDB
    default charset = utf8mb4
    comment '角色表';
