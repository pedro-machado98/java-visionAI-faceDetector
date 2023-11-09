create table faces(

                        id bigint not null auto_increment,
                        photoURL varchar(2000) not null,
                        joy tinyint not null,
                        anger tinyint not null,
                        surprise tinyint not null,
                        sorrow tinyint not null,
                        headwear tinyint not null,

                        primary key(id)

);