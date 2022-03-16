CREATE TABLE entrega (
                         id bigint not null AUTO_INCREMENT,
                         cliente_id bigint not null,
                         taxa decimal(10,2) not null,
                         status varchar(20) not null,
                         data_pedido datetime not null,
                         data_finalizacao datetime,

                         destinatario_nome varchar(60) not null,
                         destinatario_logradouro varchar(255) not null,
                         destinatario_numero varchar(30) not null,
                         destinatario_complemento varchar(60),
                         destinatario_bairro varchar(30) not null,

                         PRIMARY KEY (id)
);

ALTER TABLE entrega add CONSTRAINT fk_entrega_cliente FOREIGN key (cliente_id) REFERENCES cliente (id);