/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : enfermerasdb

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2014-12-22 23:27:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `enfermeras`
-- ----------------------------
DROP TABLE IF EXISTS `enfermeras`;
CREATE TABLE `enfermeras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(255) NOT NULL,
  `ap_paterno` varchar(255) NOT NULL,
  `ap_materno` varchar(255) NOT NULL,
  `año_nacimineto` varchar(255) NOT NULL,
  `tipo_enfermera` varchar(255) NOT NULL,
  `tipo_contrato` varchar(255) NOT NULL,
  `cantidad_horas` varchar(255) NOT NULL,
  `grupo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60582214 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of enfermeras
-- ----------------------------
INSERT INTO `enfermeras` VALUES ('1', 'Juana', 'Cuenca', 'Lopez', '83', 'enfermera', 'provisional', '160', 'Grupo 1');
INSERT INTO `enfermeras` VALUES ('2', 'Maritza', 'Perez', 'Perez', '80', 'licenciada', 'fijo', '160', 'Grupo 1');
INSERT INTO `enfermeras` VALUES ('3', 'Valentina', 'Mollo', 'Gutierrez', '86', 'enfermera', 'provisional', '160', 'Grupo 2');
INSERT INTO `enfermeras` VALUES ('4', 'Celeste', 'Zelada', 'Gutierrez', '86', 'lincenciada', 'fijo', '160', 'Grupo 2');
INSERT INTO `enfermeras` VALUES ('5', 'Luisa', 'Saravia', 'Robles', '86', 'enfermera', 'provisional', '160', 'Grupo 3');
INSERT INTO `enfermeras` VALUES ('6', 'Monica', 'Doy', 'Simples', '83', 'lincenciada', 'fijo', '160', 'Grupo 3');
INSERT INTO `enfermeras` VALUES ('7', 'Ana', 'Villaroel', 'Comit', '86', 'enfermera', 'provisional', '160', 'Grupo 4');
INSERT INTO `enfermeras` VALUES ('8', 'Fernanda', 'Torrez', 'Gutierrez', '86', 'lincenciada', 'fijo', '160', 'Grupo 4');
INSERT INTO `enfermeras` VALUES ('9', 'Patricia', 'Pareja', 'Leitas', '86', 'enfermera', 'provisional', '160', 'Grupo 5');
INSERT INTO `enfermeras` VALUES ('10', 'Inoe', 'Chaplim', 'Simples', '83', 'lincenciada', 'fijo', '160', 'Grupo 5');
INSERT INTO `enfermeras` VALUES ('11', 'Jimena', 'Soto', 'Leitas', '86', 'enfermera', 'provisional', '160', 'Grupo 6');
INSERT INTO `enfermeras` VALUES ('12', 'Nana', 'Cejada', 'Simples', '83', 'lincenciada', 'fijo', '160', 'Grupo 6');

-- ----------------------------
-- Table structure for `turnos`
-- ----------------------------
DROP TABLE IF EXISTS `turnos`;
CREATE TABLE `turnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `hora_inicio` varchar(255) NOT NULL,
  `hora_fin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of turnos
-- ----------------------------
INSERT INTO `turnos` VALUES ('1', 'mañana', '08:00', '14:00');
INSERT INTO `turnos` VALUES ('2', 'tarde', '14:00', '20:00');
INSERT INTO `turnos` VALUES ('3', 'nocha A', '20:00', '08:00');
INSERT INTO `turnos` VALUES ('4', 'noche B', '20:00', '08:00');
INSERT INTO `turnos` VALUES ('5', 'noche C', '20:00', '08:00');
INSERT INTO `turnos` VALUES ('6', 'volante', '20:00', '08:00');
