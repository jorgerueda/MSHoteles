-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-12-2015 a las 10:05:12
-- Versión del servidor: 10.1.8-MariaDB
-- Versión de PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mshoteles`
--
CREATE DATABASE IF NOT EXISTS `mshoteles` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mshoteles`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
CREATE TABLE `Cliente` (
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(60) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `ID_Cliente` int(11) NOT NULL,
  `flag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO `Cliente` (`Nombre`, `Apellidos`, `DNI`, `ID_Cliente`, `flag`) VALUES
('Jorge', 'Rueda', '700821', 1, 1),
('pepo', 'ruedo', '700', 2, 0),
('pipi', 'ruedi', '70082152', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ClienteEstandar`
--

DROP TABLE IF EXISTS `ClienteEstandar`;
CREATE TABLE `ClienteEstandar` (
  `ID_Cliente` int(11) NOT NULL,
  `PuntosAcumulados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ClienteEstandar`
--

INSERT INTO `ClienteEstandar` (`ID_Cliente`, `PuntosAcumulados`) VALUES
(2, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ClienteVip`
--

DROP TABLE IF EXISTS `ClienteVip`;
CREATE TABLE `ClienteVip` (
  `ID_Cliente` int(11) NOT NULL,
  `Descuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ClienteVip`
--

INSERT INTO `ClienteVip` (`ID_Cliente`, `Descuento`) VALUES
(1, 50),
(3, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Habitacion`
--

DROP TABLE IF EXISTS `Habitacion`;
CREATE TABLE `Habitacion` (
  `Piso` int(11) NOT NULL,
  `Ocupado` tinyint(1) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `ID_Habitacion` int(11) NOT NULL,
  `flag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Habitacion`
--

INSERT INTO `Habitacion` (`Piso`, `Ocupado`, `Numero`, `Tipo`, `ID_Habitacion`, `flag`) VALUES
(4, 0, 432, 'doble', 1, 1),
(3, 0, 321, 'simple', 2, 1),
(5, 0, 543, 'simple', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HabitacionesReservadas`
--

DROP TABLE IF EXISTS `HabitacionesReservadas`;
CREATE TABLE `HabitacionesReservadas` (
  `ID_Habitacion` int(11) NOT NULL,
  `ID_Reserva` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `HabitacionesReservadas`
--

INSERT INTO `HabitacionesReservadas` (`ID_Habitacion`, `ID_Reserva`) VALUES
(1, 6),
(1, 9),
(1, 11),
(2, 6),
(2, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Reserva`
--

DROP TABLE IF EXISTS `Reserva`;
CREATE TABLE `Reserva` (
  `Precio` float NOT NULL,
  `FechaEntrada` date NOT NULL,
  `FechaSalida` date NOT NULL,
  `ID_Cliente` int(11) NOT NULL,
  `NumeroOcupantes` int(11) NOT NULL,
  `ID_Reserva` int(11) NOT NULL,
  `flag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Reserva`
--

INSERT INTO `Reserva` (`Precio`, `FechaEntrada`, `FechaSalida`, `ID_Cliente`, `NumeroOcupantes`, `ID_Reserva`, `flag`) VALUES
(100, '2015-09-16', '2015-09-17', 1, 1, 6, 1),
(1000, '2014-08-16', '2014-08-17', 3, 1, 7, 1),
(200, '2012-06-12', '2013-06-13', 1, 1, 8, 1),
(12, '0029-02-12', '0025-01-01', 1, 2, 9, 1),
(12, '0001-01-01', '0002-03-02', 1, 2, 11, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`ID_Cliente`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `ClienteEstandar`
--
ALTER TABLE `ClienteEstandar`
  ADD PRIMARY KEY (`ID_Cliente`);

--
-- Indices de la tabla `ClienteVip`
--
ALTER TABLE `ClienteVip`
  ADD PRIMARY KEY (`ID_Cliente`);

--
-- Indices de la tabla `Habitacion`
--
ALTER TABLE `Habitacion`
  ADD PRIMARY KEY (`ID_Habitacion`);

--
-- Indices de la tabla `HabitacionesReservadas`
--
ALTER TABLE `HabitacionesReservadas`
  ADD PRIMARY KEY (`ID_Habitacion`,`ID_Reserva`);

--
-- Indices de la tabla `Reserva`
--
ALTER TABLE `Reserva`
  ADD PRIMARY KEY (`ID_Reserva`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `Habitacion`
--
ALTER TABLE `Habitacion`
  MODIFY `ID_Habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `Reserva`
--
ALTER TABLE `Reserva`
  MODIFY `ID_Reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ClienteEstandar`
--
ALTER TABLE `ClienteEstandar`
  ADD CONSTRAINT `clienteestandar_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `Cliente` (`ID_Cliente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `ClienteVip`
--
ALTER TABLE `ClienteVip`
  ADD CONSTRAINT `clientevip_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `Cliente` (`ID_Cliente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `Reserva`
--
ALTER TABLE `Reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `Cliente` (`ID_Cliente`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
