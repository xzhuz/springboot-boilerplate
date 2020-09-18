drop table `users` if exists;

CREATE TABLE `users`(
    `id`          int(20)       not null auto_increment primary key,
    `avatar`      varchar(1023) not null DEFAULT '',
    `description` varchar(1023) not null DEFAULT '',
    `email`       varchar(127)  not null DEFAULT '',
    `expire_time` timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `nickname`    varchar(255)  NOT NULL,
    `password`    varchar(255)  NOT NULL,
    `username`    varchar(50)   NOT NULL,
    `deleted`     tinyint       not null DEFAULT 0,
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP
);