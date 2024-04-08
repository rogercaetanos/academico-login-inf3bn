IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='usuarios' and xtype='U')

create table usuarios (
id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(45) NULL,
email VARCHAR(45) NOT NULL,
senha VARCHAR(200) NOT NULL,
tipo_usuario VARCHAR(30) NOT NULL,
cod_status_usuario BIT NULL,

UNIQUE(email)
)