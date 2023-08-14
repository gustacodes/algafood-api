INSERT INTO cozinha (id, nome) VALUES (1, 'Tailandesa')
INSERT INTO cozinha (id, nome) VALUES (2, 'Indiana')

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Thai Gourmet', 10, 1)
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Thai Delivery', 9.50, 1)
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Tuk Tuk Comida', 15, 2)

INSERT INTO forma_pagamento (descricao) VALUES ('Cartao de Credito')
INSERT INTO forma_pagamento (descricao) VALUES ('Cartao de Debito')
INSERT INTO forma_pagamento (descricao) VALUES ('Em dinheiro')

INSERT INTO permissao (nome, descricao) VALUES ('Gustavo', 'ACESSO IRESTRITO')
INSERT INTO permissao (nome, descricao) VALUES ('Pamella', 'ACESSO RESTRITO')

INSERT INTO estado (id, nome) VALUES (1, 'Alagoas')

INSERT INTO cidade (nome, estado_id) VALUES ('Maceio', 1)
INSERT INTO cidade (nome, estado_id) VALUES ('Arapiraca', 1)
INSERT INTO cidade (nome, estado_id) VALUES ('Penedo', 1)

INSERT INTO estado (id, nome) VALUES (2, 'Pernambuco')

INSERT INTO cidade (nome, estado_id) VALUES ('Recife', 2)
INSERT INTO cidade (nome, estado_id) VALUES ('Sertania', 2)
INSERT INTO cidade (nome, estado_id) VALUES ('Garanhuns', 2)

INSERT INTO estado (id, nome) VALUES (3, 'Rio Grande do Norte')

INSERT INTO cidade (nome, estado_id) VALUES ('Caicó', 3)
INSERT INTO cidade (nome, estado_id) VALUES ('Mossoró', 3)
INSERT INTO cidade (nome, estado_id) VALUES ('Natal', 3)