CREATE TABLE autores(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER NOT NULL,
    nacionalidade VARCHAR(15)
);

CREATE TABLE livros(
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano_publicacao INTEGER NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    genero VARCHAR(100) NOT NULL,
    editora VARCHAR(100),
    status_leitura VARCHAR(10) NOT NULL,
    nota INTEGER CHECK (nota BETWEEN 1 AND 5),
    autor_id BIGINT NOT NULL,

        CONSTRAINT fk_livros_autores
        FOREIGN KEY (autor_id)
        REFERENCES autores(id)
);