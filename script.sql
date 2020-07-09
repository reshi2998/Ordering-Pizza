
SET GLOBAL time_zone = '-3:00';
DROP SCHEMA IF EXISTS `proyecto2`;
CREATE SCHEMA `proyecto2`
DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `proyecto2`;

-- ========================================================
-- 						TABLA IMAGENES
-- ========================================================
CREATE TABLE `proyecto2`.`imagenes` (
  `id_imagen` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(250) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `imagen` MEDIUMBLOB,
  PRIMARY KEY (`id_imagen`));
  
INSERT INTO `proyecto2`.`imagenes`(`nombre`, `tipo`, `imagen`)
 VALUES ('suprema','jpg',LOAD_FILE('C:\Users\Josue\Desktop\Proyecto#2Progra\imgPizzasMySQL\suprema.jpg')),
        ('margarita','jpg',LOAD_FILE('C:\Users\Josue\Desktop\Proyecto#2Progra\imgPizzasMySQL\margarita.jpg')),
        ('jamon_hongos','jpg',LOAD_FILE('C:\Users\Josue\Desktop\Proyecto#2Progra\imgPizzasMySQL\jamonhongos.jpg')),
        ('vegetariana','jpg',LOAD_FILE('C:\Users\Josue\Desktop\Proyecto#2Progra\imgPizzasMySQL\vegetariana.jpg')),
        ('pepperoni','jpg',LOAD_FILE('C:\Users\Josue\Desktop\Proyecto#2Progra\imgPizzasMySQL\pepperoni.jpg'));  
        
-- select * from `proyecto2`.`imagenes`;

-- ========================================================
-- 						TABLA USUARIOS
-- ========================================================
DROP TABLE IF EXISTS `proyecto2`.`usuario` ;
CREATE TABLE IF NOT EXISTS `proyecto2`.`usuario` (
  `id_usuario` VARCHAR(16) NOT NULL,
  `clave_acceso` VARCHAR(45) NOT NULL,
  `rol` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;
  
INSERT INTO `proyecto2`.`usuario`(`id_usuario`, `clave_acceso`, `rol`)
 VALUES ('admin','123',0),
        ('user','123',1);  
  
  
-- ========================================================
-- 						TABLA PIZZA
-- ========================================================  
DROP TABLE IF EXISTS `proyecto2`.`pizza` ;
CREATE TABLE IF NOT EXISTS `proyecto2`.`pizza` (
  `id_pizza` INT NOT NULL AUTO_INCREMENT,
  `tamano` VARCHAR(16) NOT NULL,
  `tipo_pasta` VARCHAR(16) NOT NULL,
  `nombre_pizza` VARCHAR(45) NOT NULL,
  `ingredientes` VARCHAR(65) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `id_imagen` INT NOT NULL,
  PRIMARY KEY (`id_pizza`),
  INDEX `fk_pizza_imagenes_idx` (`id_imagen` ASC),
  CONSTRAINT `fk_pizza_imagenes`
    FOREIGN KEY (`id_imagen`)
    REFERENCES `proyecto2`.`imagenes` (`id_imagen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `proyecto2`.`pizza`(`tamano`, `tipo_pasta`, `nombre_pizza`, `ingredientes`, `precio`, `id_imagen`)
 VALUES ('Personal','Delgada','Suprema','Queso Mozarella,Pepperoni,Carne Molida,Jamon',2000,1),
        ('Grande','Delgada','Margarita','Queso Mozarella,Albahaca',12000,2),
        ('Familiar','Delgada','Jamon y hongos','Queso Mozarella,Jamon,Hongos',8000,3),
        ('Personal','Delgada','Pepperoni','Queso Mozarella,Pepperoni',2000,5),
        ('Grande','Delgada','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones',12000,4),
        ('Personal','Gruesa','Suprema','Queso Mozarella,Pepperoni,Carne Molida,Jamon',2000,1),
        ('Grande','Gruesa','Margarita','Queso Mozarella,Albahaca',12000,2),
        ('Familiar','Gruesa','Jamon y hongos','Queso Mozarella,Jamon,Hongos',8000,3),
        ('Personal','Gruesa','Pepperoni','Queso Mozarella,Pepperoni',2000,5),
        ('Grande','Gruesa','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones',12000,4);  
	 
     INSERT INTO `proyecto2`.`pizza`(`tamano`, `tipo_pasta`, `nombre_pizza`, `ingredientes`,`precio`, `id_imagen`)
 VALUES ('Familiar','Delgada','Suprema','Queso Mozarella,Pepperoni,Carne Molida,Jamon',8000,1),
        ('Familiar','Delgada','Margarita','Queso Mozarella,Albahaca',8000,2),
        ('Grande','Delgada','Jamon y hongos','Queso Mozarella,Jamon,Hongos',12000,3),
        ('Familiar','Delgada','Pepperoni','Queso Mozarella,Pepperoni',8000,5),
        ('Personal','Delgada','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones',2000,4),
        ('Grande','Gruesa','Suprema','Queso Mozarella,Pepperoni,Carne Molida,Jamon',12000,1),
        ('Familiar','Gruesa','Margarita','Queso Mozarella,Albahaca',8000,2),
        ('Grande','Gruesa','Jamon y hongos','Queso Mozarella,Jamon,Hongos',12000,3),
        ('Familiar','Gruesa','Pepperoni','Queso Mozarella,Pepperoni',8000,5);
       -- ('Personal','Gruesa','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones');  
     
  INSERT INTO `proyecto2`.`pizza`(`tamano`, `tipo_pasta`, `nombre_pizza`, `ingredientes`,`precio`, `id_imagen`)
 VALUES ('Grande','Delgada','Suprema','Queso Mozarella,Pepperoni,Carne Molida,Jamon',12000,1),
        ('Personal','Delgada','Margarita','Queso Mozarella,Albahaca',2000,2),
        ('Personal','Delgada','Jamon y hongos','Queso Mozarella,Jamon,Hongos',2000,3),
        ('Grande','Delgada','Pepperoni','Queso Mozarella,Pepperoni',12000,5),
        ('Familiar','Delgada','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones',8000,4),
        ('Familiar','Gruesa','Suprema','Queso Mozarella,Pepperoni,Carne Molida,Jamon',8000,1),
        ('Personal','Gruesa','Margarita','Queso Mozarella,Albahaca',2000,2),
        ('Peronsal','Gruesa','Jamon y hongos','Queso Mozarella,Jamon,Hongos',2000,3),
        ('Grande','Gruesa','Pepperoni','Queso Mozarella,Pepperoni',12000,5),
        ('Familiar','Gruesa','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones',8000,4),
        ('Personal','Gruesa','Vegetariana','Queso Mozarella,Cebolla,Chile Dulce,Albahaca,Champinones',2000,4);
  
-- ========================================================
-- 						TABLA CLIENTE
-- ========================================================
DROP TABLE IF EXISTS `proyecto2`.`cliente` ;
CREATE TABLE IF NOT EXISTS `proyecto2`.`cliente` (
  `id_cliente` VARCHAR(16) NOT NULL,
  `usuario_id` VARCHAR(16) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `proyecto2`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `proyecto2`.`cliente`(`id_cliente`, `usuario_id`, `apellidos`, `nombre`, `direccion`, `telefono`)
 VALUES ('123456','admin','Moraga Alfaro', 'Sara', 'Grecia', '60612501'),
		('456789','user','Vega Zamora', 'Salome', 'Alajuela', '88776655');
 
  
-- ========================================================
-- 					TABLA ACOMPANAMIENTOS
-- ========================================================
  DROP TABLE IF EXISTS `proyecto2`.`acompanamientos` ; 
  CREATE TABLE IF NOT EXISTS acompanamientos (
    `id_acompanamientos` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(45) NOT NULL,
    `precioAcomp` DOUBLE NOT NULL,
    `disponible` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id_acompanamientos`))
  ENGINE=InnoDB;
  
  INSERT INTO `proyecto2`.`acompanamientos`(`nombre`,`precioAcomp`,`disponible`) values ('Sin acompañamientos','0',1)
  ,('Coca Cola 2L','2200',1), 
  ('Pepsi 1.5L','2000',1),('Limonada','800',1),('Té Blanco 500ml','1100',1),('Té Frío Melocotón 750ml','1200',1),
  ('Breadsticks Grande','2500',1),('Breadsticks Pequeños','1800',1),('Galletas Choco Chips  Individual','1500',1),
  ('Paquetex3 Galletas Choco Chips','3000',1),('Salsa Pesto','1000',1),('Rollos de Canela','1800',1),
  ('Queque de Chocolate','1500',1),('Salsa Ranch','1000',1),('Pure de Papa','1600',1);
  
-- ========================================================
-- 						TABLA EXTRAS
-- ========================================================
  DROP TABLE IF EXISTS `proyecto2`.`extras` ; 
  CREATE TABLE IF NOT EXISTS extras (
  `id_extras` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `disponible` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id_extras`))
  ENGINE=InnoDB;
  
   INSERT INTO `proyecto2`.`extras`(`nombre`,`precio`,`disponible`) values ('Sin extras','0',1),('Extra Tocino','600',1),('Extra Cebolla','400',1),
   ('Extra Aguacate','600',1),('Extra Queso','350',1),('Extra Pollo','800',1),('Extra Albahaca','250',1),('Extra Hongos','400',1),('Extra Jalapeño','400',1),
   ('Extra Chile dulce','400',1),('Extra Pepperoni','300',1);


-- ========================================================
-- 						TABLA COMENTARIOS
-- ========================================================
  DROP TABLE IF EXISTS `proyecto2`.`comentarios` ;
   CREATE TABLE `proyecto2`.`comentarios` (
  `id_comentario` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(250) NOT NULL,
 `fecha` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`id_comentario`));
  
   INSERT INTO `proyecto2`.`comentarios` (`comentario`, `fecha`) values
   ( '¡Muy ricas pizzas!', default),
   ('Excelente Servicio!!', default),
   ('La mejor pizza de Pepperoni de la vida', default);
  
-- ========================================================
-- 						TABLA ORDENES
-- ========================================================
  DROP TABLE IF EXISTS `proyecto2`.`ordenes` ;
  CREATE TABLE IF NOT EXISTS ordenes (
  `id_orden` INT NOT NULL AUTO_INCREMENT,
  `id_pizza` INT NOT NULL,
  `acompanamientos` VARCHAR(50) NOT NULL,
  `extras` VARCHAR(50) NOT NULL,
  `id_cliente` VARCHAR(16) NOT NULL,
  `unidad_pizza` INT NOT NULL,
  `precioTotal` DOUBLE NOT NULL,
  `fecha` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`id_orden`),
  INDEX `fk_ordenes_cli` (`id_cliente` ASC),
  INDEX `fk_ordenes_pizz` (`id_pizza` ASC),
  CONSTRAINT `fk_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `proyecto2`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pizza`
    FOREIGN KEY (`id_pizza`)
    REFERENCES `proyecto2`.`pizza` (`id_pizza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `proyecto2`.`ordenes` (`id_pizza`,`acompanamientos`,`extras`,`id_cliente`,`unidad_pizza`,`precioTotal`) values
 (8,'Limonada','Extra Tocino','456789',1,7400),(12,'Salsa Ranch','Extra Queso','456789',1,9350),
 (8,'Rollos de Canela','Extra Pollo','456789',1,10600),(8,'Rollos de Canela','Extra Aguacate','456789',1,10400),
 (7,'BreadSticks Grandes','Extras Hongos',456789,2,26900),(6,'Limonada','Extra Tocino','456789',1,7400),
 (12,'Salsa Ranch','Extra Queso','456789',1,9350), (5,'Rollos de Canela','Extra Pollo','456789',1,10600),
 (5,'Rollos de Canela','Extra Aguacate','456789',1,10400), (10,'BreadSticks Pequeños','Extras Cebolla',456789,2,26900);
 