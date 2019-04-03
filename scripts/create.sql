CREATE SCHEMA `dbfoodtruck` ;

CREATE TABLE `dbfoodtruck`.`sobremesa` (
  `id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `light` INT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC));

  ALTER TABLE `dbfoodtruck`.`sobremesa` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

INSERT INTO SOBREMESA(ID, NOME, PRECO, LIGHT) VALUES (1, 'Sagu', 3.5, 0);
INSERT INTO SOBREMESA(ID, NOME, PRECO, LIGHT) VALUES (2, 'Pudim light', 4.45, 1);
INSERT INTO SOBREMESA(ID, NOME, PRECO, LIGHT) VALUES (3, 'Mousse', 8.9, 0);
INSERT INTO SOBREMESA(ID, NOME, PRECO, LIGHT) VALUES (4, 'Gelatina', 1.45, 1);

