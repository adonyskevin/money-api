CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	ativo BOOLEAN NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(6),
	complemento VARCHAR(40),
	bairro VARCHAR(40),
	cep VARCHAR(8),
	cidade VARCHAR(40),
	estado VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;