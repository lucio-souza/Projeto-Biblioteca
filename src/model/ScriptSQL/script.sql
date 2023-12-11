create database ProjetoBiblioteca;
use ProjetoBiblioteca;
create table Bibliotecario(
id int auto_increment primary key,
email varchar(30) unique,
senha int
);
create table Livro(
id int auto_increment primary key,
titulo varchar(50) unique not null,
dtPublicacao date not null,
genero varchar(20),
status varchar(20) default'disponivel',
autor varchar(20) not null
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
dtEntrega date,
status varchar(20) default'Em Andamento',
constraint chaveCliente foreign key(idCliente) references Cliente(id),
constraint chaveLivro foreign key(idLivro) references Livro(id)
);
DELIMITER //
CREATE TRIGGER gatilho_definir_dtEntrega
BEFORE INSERT ON Emprestimo
FOR EACH ROW
BEGIN
    SET NEW.dtEntrega = DATE_ADD(NEW.dtReserva, INTERVAL 10 DAY);
END;
//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE atualizarStatusAtrasado()
BEGIN
    UPDATE Emprestimo
    SET status = 'atrasado'
    WHERE dtEntrega < CURDATE();
END;
//

CREATE EVENT verificarAtraso
ON SCHEDULE EVERY 1 DAY 
DO
BEGIN
    CALL atualizarStatusAtrasado();
END;
//
DELIMITER ;
