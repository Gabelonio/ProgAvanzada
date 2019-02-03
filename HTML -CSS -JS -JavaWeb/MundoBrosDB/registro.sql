CREATE TABLE `registros` (
  `con_id` int(11) NOT NULL auto_increment COMMENT 'identificador del personaje',
  `con_clase` varchar(15) NOT NULL COMMENT 'clase del personaje',
  `con_nombre` varchar(30) NOT NULL COMMENT 'nombre del personaje',
  `con_altura` varchar(10) NOT NULL COMMENT 'altura del personaje',
  `con_color` varchar(10) NOT NULL COMMENT 'color personaje',
  PRIMARY KEY  (`con_id`)
) ENGINE=InnoDB;

INSERT INTO `registros` VALUES (1,'Bowser','Mateo','156','Original'),
(2,'Luigi','Daniel Montiel','170','Azul');