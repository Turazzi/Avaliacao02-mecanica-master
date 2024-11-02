CREATE TABLE consertos (
                           id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           entrada VARCHAR(10) NOT NULL,
                           saida VARCHAR(10) NOT NULL,
                           mecanico VARCHAR(100) NOT NULL,
                           experiencia INT NOT NULL,
                           marca VARCHAR(100),
                           modelo VARCHAR(20),
                           ano VARCHAR(4) NOT NULL
);
