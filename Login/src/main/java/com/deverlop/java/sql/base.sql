create database `baseJavaUsuario`;
use `baseJavaUsuario`;
create table `users` (
  `id` varchar(36),
  `email` varchar(40) not null,
  `password` varchar(60) not null
);
alter table `users`
  add primary key (id);

INSERT INTO `users` (id, email, password) 
    values  (uuid(), 'ricardo-ave-gonzalez@deverlop.com', 'abc1234'),
            (uuid(), 'ana-deverlop@deverlop.com', 'fffffffffff1234'),
            (uuid(), 'geronimo@gmail.com', 'e3ih213o4eio2332oi1234'),
            (uuid(), 'natalia-morales@hotmail.com', '124f43f434f43'),
            (uuid(), 'rfernando-el-gordo@caraoque.com', '1222fvc34');

