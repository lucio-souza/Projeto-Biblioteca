create database ProjetoBiblioteca;
use ProjetoBiblioteca;
create table Livro(
id int auto_increment primary key,
titulo varchar(50) unique not null,
dtPublicacao date not null,
genero varchar(20),
status varchar(20) default'livre'
);
create table Cliente(
id int auto_increment primary key,
cpf varchar(20) unique,
nome varchar(50) not null,
telefone int
);
create table Emprestimo(
id int auto_increment primary key,
idCliente int,
idLivro int,
dtReserva date not null,
dtEntrega date not null,
constraint chaveCliente foreign key(idCliente) references Cliente(id),
constraint chaveLivro foreign key(idLivro) references Livro(id)
);
