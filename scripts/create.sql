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
