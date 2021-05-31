CREATE SCHEMA `ordermanagement`;

CREATE TABLE `ordermanagement`.`client`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(45) NULL,
    `phone_number` VARCHAR(45) NULL,
    `address`      VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ordermanagement`.`product`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(45) NULL,
    `price`       VARCHAR(45) NULL,
    `description` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ordermanagement`.`delivery`
(
    `id`    INT         NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(45) NULL,
    `price` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `ordermanagement`.`booking`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `quantity`    VARCHAR(45) NULL,
    `date`        VARCHAR(45) NULL,
    `id_client`   INT         NULL,
    `id_product`  INT         NULL,
    `id_delivery` INT         NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_client`
        FOREIGN KEY (`id_client`)
            REFERENCES `ordermanagement`.`client` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_product`
        FOREIGN KEY (`id_product`)
            REFERENCES `ordermanagement`.`product` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_delivery`
        FOREIGN KEY (`id_delivery`)
            REFERENCES `ordermanagement`.`delivery` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);