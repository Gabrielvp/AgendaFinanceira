
-- MySQL Script generated by MySQL Workbench
-- 06/28/15 13:31:52
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AgendaFinanceira
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AgendaFinanceira
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AgendaFinanceira` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `AgendaFinanceira` ;

-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`pessoa` (
  `idPessoa` INT  NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NULL,
  `completo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`endereco` (
  `idendereco` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(150) NOT NULL,
  `numero` INT NOT NULL,
  `cep` CHAR(10) NOT NULL,
  `bairro` VARCHAR(100) NOT NULL,
  `cidade` VARCHAR(50) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `ponto_referencia` VARCHAR(50) NULL,
  `tipo_endereco` INT NOT NULL,
  `endereco_principal` TINYINT(1) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idendereco`, `idPessoa`),
  INDEX `fk_endereco_pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_endereco_pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `AgendaFinanceira`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`documento` (
  `iddocumento` INT Primary KEY NOT NULL AUTO_INCREMENT ,
  `cpf` CHAR(14) NOT NULL,
  `rg` VARCHAR(20) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`iddocumento`, `idPessoa`),
  INDEX `fk_documento_pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_documento_pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `AgendaFinanceira`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`telefone` (
  `idtelefone` INT NOT NULL AUTO_INCREMENT,
  `numero` CHAR(14) NOT NULL,
  `telefone_principal` TINYINT(1) NULL,
  `tipo_telefone` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idtelefone`, `idPessoa`),
  INDEX `fk_telefone_pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_telefone_pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `AgendaFinanceira`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`agendamento` (
  `idagendamento` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `hora` TIME(0) NOT NULL,
  `descricao` VARCHAR(100) NULL,
  `dia` VARCHAR(100) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idagendamento`, `idPessoa`),
  INDEX `fk_agendamento_pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_agendamento_pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `AgendaFinanceira`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`orcamento` (
  `idorcamento` INT NOT NULL AUTO_INCREMENT,
  `fatura` INT NULL,
  `data` DATE NOT NULL,
  `cliente` VARCHAR(150) NOT NULL,
  `total` DOUBLE NOT NULL,
  `desconto` DOUBLE NULL,
  `aprovado` TINYINT(1) NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idorcamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`fatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`fatura` (
  `idFatura` INT NOT NULL AUTO_INCREMENT,
  `fatura` VARCHAR(45) NOT NULL,
  `total` DOUBLE NOT NULL,
  `dt_emissao` DATE NOT NULL,
  `quitado` TINYINT(1) NULL,
  `forma_pagamento` VARCHAR(100) NOT NULL,
  `idorcamento` INT NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idFatura`, `idorcamento`, `idPessoa`),
  INDEX `fk_debito_orcamento1_idx` (`idorcamento` ASC),
  INDEX `fk_debito_pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_debito_orcamento1`
    FOREIGN KEY (`idorcamento`)
    REFERENCES `AgendaFinanceira`.`orcamento` (`idorcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_debito_pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `AgendaFinanceira`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`parcela`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`parcela` (
  `idParcela` INT NOT NULL AUTO_INCREMENT,
  `parcelas` INT NOT NULL,
  `vl_parcela` DOUBLE NOT NULL,
  `dt_entrada` DATE NOT NULL,
  `intervalo` INT NOT NULL,
  `quitado` TINYINT(1) NULL,
  `dt_geracao` DATE NOT NULL,
  `dt_vencimento` DATE NOT NULL,
  `dt_pagamento` DATE NULL,
  `valor_pago` DOUBLE NULL,
  `idFatura` INT NOT NULL,
  PRIMARY KEY (`idParcela`, `idFatura`),
  INDEX `fk_debito_parcelado_debito1_idx` (`idFatura` ASC),
  CONSTRAINT `fk_debito_parcelado_debito1`
    FOREIGN KEY (`idFatura`)
    REFERENCES `AgendaFinanceira`.`fatura` (`idFatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`configuracoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`configuracoes` (
  `idconfiguracoes` INT NOT NULL AUTO_INCREMENT,
  `horaInicial` TIME NOT NULL,
  `horaFinal` TIME NOT NULL,
  `intervalo` INT NOT NULL,
  `almocoInicio` TIME NULL,
  `almocoFim` TIME NULL,
  `dia` INT NOT NULL,
  PRIMARY KEY (`idconfiguracoes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`produto` (
  `idproduto` INT NOT NULL AUTO_INCREMENT,
  `produto` VARCHAR(150) NOT NULL,
  `qtd` DOUBLE NOT NULL,
  `vl_compra` DOUBLE NOT NULL,
  `vl_venda` DOUBLE NOT NULL,
  `marca` VARCHAR(150) NOT NULL,
  `modelo` VARCHAR(150) NOT NULL,
  `cod_barras` VARCHAR(45) NULL,
  `observacao` VARCHAR(500) NULL,
  `ativo` BOOLEAN NOT NULL,
  `unidade`INT NOT NULL,
  `ncm`INT NOT NULL,
  `origem` INT NOT NULL,
  PRIMARY KEY (`idproduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`servico` (
  `idservico` INT NOT NULL AUTO_INCREMENT,
  `servico` VARCHAR(150) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idservico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`orcamento_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`orcamento_produto` (
  `idorcamento` INT NOT NULL,
  `idproduto` INT NOT NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idorcamento`, `idproduto`),
  INDEX `fk_orcamento_has_produto_produto1_idx` (`idproduto` ASC),
  INDEX `fk_orcamento_has_produto_orcamento1_idx` (`idorcamento` ASC),
  CONSTRAINT `fk_orcamento_has_produto_orcamento1`
    FOREIGN KEY (`idorcamento`)
    REFERENCES `AgendaFinanceira`.`orcamento` (`idorcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_has_produto_produto1`
    FOREIGN KEY (`idproduto`)
    REFERENCES `AgendaFinanceira`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgendaFinanceira`.`orcamento_servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaFinanceira`.`orcamento_servico` (
  `idorcamento` INT NOT NULL,
  `idservico` INT NOT NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`idorcamento`, `idservico`),
  INDEX `fk_orcamento_has_servico_servico1_idx` (`idservico` ASC),
  INDEX `fk_orcamento_has_servico_orcamento1_idx` (`idorcamento` ASC),
  CONSTRAINT `fk_orcamento_has_servico_orcamento1`
    FOREIGN KEY (`idorcamento`)
    REFERENCES `AgendaFinanceira`.`orcamento` (`idorcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_has_servico_servico1`
    FOREIGN KEY (`idservico`)
    REFERENCES `AgendaFinanceira`.`servico` (`idservico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
