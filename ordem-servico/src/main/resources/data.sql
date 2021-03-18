INSERT INTO tb_cliente (email,nome, telefone, cpf) VALUES ('bob@teste.com', 'Bob', '8888-8888', '883.391.260-40');
INSERT INTO tb_cliente (email,nome, telefone, cpf) VALUES ('maria@teste.com','Maria', '7777-7777', '977.641.170-30');
INSERT INTO tb_cliente (email,nome, telefone, cpf) VALUES ('alex@teste.com','Alex', '5555-5555', '604.746.340-19');

insert into tb_ordem_servico (data_abertura ,  data_finalizacao , descricao , preco, status , id_cliente) values ('2021-01-01' , '2021-10-20', 'Ordem de serviço 1', '50.000' , 0, 1);
insert into tb_ordem_servico (data_abertura ,  data_finalizacao , descricao , preco, status , id_cliente) values ('2021-04-01' , '2021-09-20', 'Ordem de serviço 2', '20.000' , 0, 2);
insert into tb_ordem_servico (data_abertura ,  data_finalizacao , descricao , preco, status , id_cliente) values ('2021-02-10' , '2021-12-20', 'Ordem de serviço 3', '20000.000' , 0, 2);


insert  into tb_comentario (descricao , data_envio, id_ordem_servico) values ('Comentario 1 da ordem de servico 1' , '2021-01-10' , 1);
insert  into tb_comentario (descricao , data_envio, id_ordem_servico) values ('Comentario 2 da ordem de servico 1' , '2021-01-10' , 1);
insert  into tb_comentario (descricao , data_envio, id_ordem_servico) values ('Comentario 1 da ordem de servico 2' , '2021-05-10' , 2);

