#create schema inventorydb collate utf8mb4_general_ci;

#drop table produtos;
Create table produtos(
    codigo varchar(15) not null,
    nome varchar(50) not null,
    descricao varchar(200),
    quant_total float(3) not null,
    estoque_min float(3) not null,
    Constraint pk_codigo PRIMARY KEY (codigo)
);

#drop table lotes;
Create table lotes(
	id int not null auto_increment,
    codigo varchar(15) not null,
    codigo_p varchar(15) not null,
    data_vencimento date not null,
    quant float(3),
    Primary key(id),
    Constraint fk_codigo_p Foreign key(codigo_p) references produtos(codigo)
);

#Delete from produtos;
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("FARTRI", "FARINHA DE TRIGO", "Farinha de trigo refinado", 0, 1750);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("FARMIL", "FARINHA DE MILHO", "Farinha de milho granulometria 0.5", 0, 2000);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("FARARR", "FARINHA DE ARROZ", "Farinha de arroz refinado", 0, 1500);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("SORLEI", "SORO DE LEITE", "Soro de leite concentrado", 0, 1000);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("POOSSO", "PÓ DE OSSO", "Farinha de pó de osso de frango", 0, 500);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("VITA", "VITAMINA A", "Vitamina A - retinol", 0, 500);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("VITB12", "VITAMINA B12", "Vitamina B12 - Cianocobalamina", 0, 1000);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("VITB6", "VITAMINA B6", "Vitamina B6 - Piridoxina", 0, 500);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("VITC", "VITAMINA C", "Vitamina C - Ácido ascórbico", 0, 500);
INSERT INTO produtos(codigo, nome, descricao, quant_total, estoque_min) VALUES ("ARGINI", "ARGININA", "Aminoácido Arginina", 0, 750);
INSERT INTO produtos(codigo, nome, descricao, quant_total,estoque_min) VALUES ("METION", "METIONINA", "Aminoácido Metionina", 0, 750);
#Select * from produtos;

#Delete from lotes;
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30012023", "FARTRI", "2024-01-30", 2000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT27122022", "FARTRI", "2023-12-27", 1000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT01122022", "FARMIL", "2023-12-01", 1000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT15112022", "FARMIL", "2023-11-15", 1000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT21112022", "FARARR", "2023-11-21", 1250);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT25112022", "FARARR", "2023-11-25", 1000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT21052023", "SORLEI", "2023-11-21", 1000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT01062023", "SORLEI", "2023-12-01", 750);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT01092023", "POOSSO", "2023-12-01", 1000);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT07092023", "POOSSO", "2023-12-07", 1500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30012023", "VITA", "2024-01-30", 250);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT27122022", "VITA", "2023-12-27", 750);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30012023", "VITB12", "2024-01-30", 500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT27122022", "VITB12", "2023-12-27", 500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30012023", "VITC", "2024-01-30", 500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT27122022", "VITC", "2023-12-27", 500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30032023", "ARGINI", "2024-03-30", 500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30122022", "ARGINI", "2023-12-30", 500);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30032023", "METION", "2024-03-30", 300);
INSERT INTO lotes(codigo, codigo_p, data_vencimento, quant) VALUES("LT30122022", "METION", "2023-12-30", 300);
#Select * from lotes;

Update produtos as p set p.quant_total = 3000 where p.codigo = "FARTRI";
Update produtos as p set p.quant_total = 2000 where p.codigo = "FARMIL";
Update produtos as p set p.quant_total = 2250 where p.codigo = "FARARR";
Update produtos as p set p.quant_total = 1750 where p.codigo = "SORLEI";
Update produtos as p set p.quant_total = 2500 where p.codigo = "POOSSO";
Update produtos as p set p.quant_total = 1000 where p.codigo = "VITA";
Update produtos as p set p.quant_total = 1000 where p.codigo = "VITB12";
Update produtos as p set p.quant_total = 1000 where p.codigo = "VITC";
Update produtos as p set p.quant_total = 1000 where p.codigo = "ARGINI";
Update produtos as p set p.quant_total = 600 where p.codigo = "METION";
#Select * from produtos;


