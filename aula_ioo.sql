create database aula_ioo;
use aula_ioo;

create table produto(
	id serial,
    descricao character varying(50),
    preco double precision
    );
    
insert into produto (descricao, preco) values ("bolsa de algodao", 25.99);
insert into produto (descricao, preco) values ("whip-whiplash", 99.99);
insert into produto (descricao, preco) values ("ser humano", 1.99);
insert into produto (descricao, preco) values ("album de kpop", 879.99);
insert into produto (descricao, preco) values ("ticket compra riachuelo", 2500.99);
insert into produto (descricao, preco) values ("a", 1);

select * from produto;

SET SQL_SAFE_UPDATES = 0;

update produto set descricao = "abacaxi", preco = 14 where id =3;
update produto set descricao = 'mouse razer', preco = 500 where id = 9;