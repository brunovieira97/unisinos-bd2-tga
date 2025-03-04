DROP TABLE CLIENTEPEDIDO;
DROP TABLE CLIENTE;
DROP TABLE PEDIDOITEM;
DROP TABLE PRODUTO;
DROP TABLE FORNECEDOR;
DROP TABLE PEDIDO;
DROP TABLE ENDERECO;

CREATE TABLE ENDERECO (
    CODIGOENDERECO INT GENERATED ALWAYS AS IDENTITY,
    LOGRADOURO VARCHAR(100) NOT NULL,
    NUMERO VARCHAR(10) NOT NULL,
    COMPLEMENTO VARCHAR(20) NULL,
    BAIRRO VARCHAR(50) NULL,
    CIDADE VARCHAR(50) NOT NULL,
    ESTADO VARCHAR(50) NOT NULL,
    PAIS VARCHAR(50) NULL,
    PRIMARY KEY (CODIGOENDERECO)
);

CREATE TABLE CLIENTE (
    CODIGOCLIENTE INT GENERATED ALWAYS AS IDENTITY,
    NOME VARCHAR(100) NOT NULL,
    CPF CHAR(14) NULL,
    CODIGOENDERECO INT NULL,
    PRIMARY KEY (CODIGOCLIENTE),
    FOREIGN KEY (CODIGOENDERECO) REFERENCES ENDERECO (CODIGOENDERECO)
);

CREATE TABLE FORNECEDOR (
    CODIGOFORNECEDOR INT GENERATED ALWAYS AS IDENTITY,
    RAZAOSOCIAL VARCHAR(100) NOT NULL,
    CNPJ CHAR(18) NULL,
    CODIGOENDERECO INT NULL,
    PRIMARY KEY (CODIGOFORNECEDOR),
    FOREIGN KEY (CODIGOENDERECO) REFERENCES ENDERECO (CODIGOENDERECO)
);

CREATE TABLE PRODUTO (
    CODIGOPRODUTO INT GENERATED ALWAYS AS IDENTITY,
    DESCRICAO VARCHAR(100) NOT NULL,
    VALORUNITARIO DECIMAL(15,2) NOT NULL,
    CODIGOFORNECEDOR INT NULL,
    PRIMARY KEY (CODIGOPRODUTO),
    FOREIGN KEY (CODIGOFORNECEDOR) REFERENCES FORNECEDOR (CODIGOFORNECEDOR)
);

CREATE TABLE PEDIDO (
    CODIGOPEDIDO INT GENERATED ALWAYS AS IDENTITY,
    VALORTOTAL DECIMAL(15,2) NOT NULL,
    CODIGOENDERECO INT NULL,
    SITUACAO CHAR(1) NOT NULL,
    DATAPEDIDO DATE NOT NULL,
    PRIMARY KEY (CODIGOPEDIDO),
    FOREIGN KEY (CODIGOENDERECO) REFERENCES ENDERECO (CODIGOENDERECO)
);

CREATE TABLE PEDIDOITEM (
    CODIGOPEDIDOITEM INT GENERATED ALWAYS AS IDENTITY,
    CODIGOPEDIDO INT NOT NULL,
    CODIGOPRODUTO INT NOT NULL,
    QUANTIDADE INT NOT NULL,
    VALOR DECIMAL(15,2) NOT NULL,
    PRIMARY KEY (CODIGOPEDIDOITEM),
    FOREIGN KEY (CODIGOPEDIDO) REFERENCES PEDIDO (CODIGOPEDIDO),
    FOREIGN KEY (CODIGOPRODUTO) REFERENCES PRODUTO (CODIGOPRODUTO)
);

CREATE TABLE CLIENTEPEDIDO (
    CODIGOCLIENTE INT NOT NULL,
    CODIGOPEDIDO INT NOT NULL,
    PRIMARY KEY (CODIGOCLIENTE, CODIGOPEDIDO),
    FOREIGN KEY (CODIGOCLIENTE) REFERENCES CLIENTE (CODIGOCLIENTE),
    FOREIGN KEY (CODIGOPEDIDO) REFERENCES PEDIDO (CODIGOPEDIDO)
);