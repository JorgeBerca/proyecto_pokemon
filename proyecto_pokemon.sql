-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-04-2024 a las 11:05:57
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_pokemon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combate`
--

CREATE TABLE `combate` (
  `ID_COMBATE` int(11) NOT NULL,
  `FECHA_HORA` datetime NOT NULL,
  `ID_ENTRENADOR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_ENTRENADOR` int(11) NOT NULL,
  `NOM_ENTRENADOR` varchar(20) NOT NULL,
  `PASS` varchar(20) DEFAULT NULL,
  `POKEDOLLARS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mochila`
--

CREATE TABLE `mochila` (
  `ID_ENTRENADOR` int(11) NOT NULL,
  `ID_OBJETO` int(11) NOT NULL,
  `NUM_OBJETO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `ID_MOVIMIENTO` int(11) NOT NULL,
  `NOM_MOVIMIENTO` varchar(20) NOT NULL,
  `POTENCIA` int(11) DEFAULT NULL,
  `TIPO` varchar(20) NOT NULL,
  `ESTADO` varchar(20) DEFAULT NULL,
  `QUITA` int(11) DEFAULT NULL,
  `TURNOS` int(11) DEFAULT NULL,
  `MEJORA` varchar(20) DEFAULT NULL,
  `CANT_MEJORA` int(11) DEFAULT NULL,
  `NIVEL_APRENDIZAJE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`ID_MOVIMIENTO`, `NOM_MOVIMIENTO`, `POTENCIA`, `TIPO`, `ESTADO`, `QUITA`, `TURNOS`, `MEJORA`, `CANT_MEJORA`, `NIVEL_APRENDIZAJE`) VALUES
(1, 'Ascuas', 40, 'Fuego', NULL, NULL, NULL, NULL, NULL, 6),
(2, 'Puño fuego', 75, 'Fuego', NULL, NULL, NULL, NULL, NULL, 26),
(3, 'LLamarada', 85, 'Fuego', NULL, NULL, NULL, NULL, NULL, 30),
(4, 'Lanzallamas', 90, 'Fuego', NULL, NULL, NULL, NULL, NULL, 15),
(5, 'Fuego fatuo ', NULL, 'Fuego', 'Quemado', NULL, NULL, NULL, NULL, 20),
(6, 'Dragoaliento', 60, 'Dragon', NULL, NULL, NULL, NULL, NULL, 15),
(7, 'Garra dragón', 80, 'Dragon', NULL, NULL, NULL, NULL, NULL, 22),
(8, 'Cometa draco', 110, 'Dragon', NULL, NULL, NULL, NULL, NULL, 35),
(9, 'Pulso dragón ', 85, 'Dragon', NULL, NULL, NULL, NULL, NULL, 23),
(10, 'Pistola agua', 40, 'Agua', NULL, NULL, NULL, NULL, NULL, 12),
(11, 'Hidrobomba', 110, 'Agua', NULL, NULL, NULL, NULL, NULL, 32),
(12, 'Surf', 90, 'Agua', NULL, NULL, NULL, NULL, NULL, 24),
(13, 'Burbuja', 40, 'Agua', NULL, NULL, NULL, NULL, NULL, 14),
(14, 'Corte furia', 40, 'Bicho', NULL, NULL, NULL, NULL, NULL, 12),
(15, 'Tijera X', 80, 'Bicho', NULL, NULL, NULL, NULL, NULL, 26),
(16, 'Zumbido', 90, 'Bicho', NULL, NULL, NULL, NULL, NULL, 26),
(17, 'Megacuerno', 120, 'Bicho', NULL, NULL, NULL, NULL, NULL, 36),
(18, 'Impactrueno', 40, 'Electrico', NULL, NULL, NULL, NULL, NULL, 14),
(19, 'Rayo', 90, 'Electrico', NULL, NULL, NULL, NULL, NULL, 26),
(20, 'Rayo', 90, 'Electrico', NULL, NULL, NULL, NULL, NULL, 26),
(21, 'Bola voltio', 110, 'Electrico', NULL, NULL, NULL, NULL, NULL, 32),
(22, 'Puño hielo', 75, 'Hielo', NULL, NULL, NULL, NULL, NULL, 20),
(23, 'Rayo hielo', 90, 'Hielo', NULL, NULL, NULL, NULL, NULL, 26),
(24, 'Ventisca', 110, 'Hielo', NULL, NULL, NULL, NULL, NULL, 34),
(25, 'Rayo aurora', 65, 'Hielo', NULL, NULL, NULL, NULL, NULL, 12),
(26, 'Doble patada', 60, 'Lucha', NULL, NULL, NULL, NULL, NULL, 15),
(27, 'Puño dinamico', 100, 'Lucha', NULL, NULL, NULL, NULL, NULL, 27),
(28, 'Tajo cruzado', 100, 'Lucha', NULL, NULL, NULL, NULL, NULL, 29),
(29, 'Ultrapuño', 40, 'Lucha', NULL, NULL, NULL, NULL, NULL, 6),
(30, 'A bocajarro', 120, 'Lucha', NULL, NULL, NULL, NULL, NULL, 34),
(31, 'Somnifero', NULL, 'Planta', 'Dormido', NULL, 3, NULL, NULL, 20),
(32, 'Hoja afilada ', 55, 'Planta', NULL, NULL, NULL, NULL, NULL, 12),
(33, 'Látigo cepa', 45, 'Planta', NULL, NULL, NULL, NULL, NULL, 9),
(34, 'Rayo solar', 120, 'Planta', NULL, NULL, NULL, NULL, NULL, 34),
(35, 'Hoja aguda', 90, 'Planta', NULL, NULL, NULL, NULL, NULL, 25),
(36, 'Lengüetazo', 30, 'Fantasma', NULL, NULL, NULL, NULL, NULL, 13),
(37, 'Bola sombra', 80, 'Fantasma', NULL, NULL, NULL, NULL, NULL, 25),
(38, 'Garra umbría', 70, 'Fantasma', NULL, NULL, NULL, NULL, NULL, 20),
(39, 'Golpe umbrío', 120, 'Fantasma', NULL, NULL, NULL, NULL, NULL, 36),
(40, 'Golpe umbrío', 120, 'Fantasma', NULL, NULL, NULL, NULL, NULL, 36),
(41, 'Psicoonda', 40, 'Psiquico', NULL, NULL, NULL, NULL, NULL, 14),
(42, 'Psicorrayo', 65, 'Psiquico', NULL, NULL, NULL, NULL, NULL, 20),
(43, 'Psíquico', 90, 'Psiquico', NULL, NULL, NULL, NULL, NULL, 26),
(44, 'Cabezazo zen', 80, 'Psiquico', NULL, NULL, NULL, NULL, NULL, 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento_pokemon`
--

CREATE TABLE `movimiento_pokemon` (
  `ID_MOVIMIENTO` int(11) NOT NULL,
  `ID_POKEMON` int(11) NOT NULL,
  `ACTIVO` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto`
--

CREATE TABLE `objeto` (
  `ID_OBJETO` int(11) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `ATAQUE` int(11) DEFAULT NULL,
  `AT_ESPECIAL` int(11) DEFAULT NULL,
  `DEFENSA` int(11) DEFAULT NULL,
  `DEF_ESPECIAL` int(11) DEFAULT NULL,
  `VELOCIDAD` int(11) DEFAULT NULL,
  `PRECIO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokedex`
--

CREATE TABLE `pokedex` (
  `NUM_POKEDEX` int(11) NOT NULL,
  `NOM_POKEMON` varchar(30) NOT NULL,
  `TIPO1` varchar(20) NOT NULL,
  `TIPO2` varchar(20) DEFAULT NULL,
  `SPRITE_DELANTE` varchar(255) NOT NULL,
  `SPRITE_DETRAS` varchar(255) NOT NULL,
  `SONIDO` varchar(100) NOT NULL,
  `NIVEL_EVOLUCION` int(11) DEFAULT NULL,
  `FK_NUM_POKEDEX_EVO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pokedex`
--

INSERT INTO `pokedex` (`NUM_POKEDEX`, `NOM_POKEMON`, `TIPO1`, `TIPO2`, `SPRITE_DELANTE`, `SPRITE_DETRAS`, `SONIDO`, `NIVEL_EVOLUCION`, `FK_NUM_POKEDEX_EVO`) VALUES
(1, 'Bulbasaur', 'Planta', 'Veneno', 'C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Bubasaur_frente.png', 'C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Bubasaur_detras.png', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Bulbasaur.mp3\"', 16, NULL),
(2, 'Ivysaur', 'Planta', 'Veneno ', 'C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Ivysaur_frente.png', 'C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Ivysaur_detras.png', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Ivysaur.mp3\"', 32, NULL),
(3, 'Venusaur', 'Planta', 'Veneno', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\venusaur_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\venusaur_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Venusaur.mp3\"', NULL, NULL),
(4, 'Charmander', 'Fuego', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Charmander_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Charmander_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Charmander.mp3\"', 16, NULL),
(5, 'Charmeleon', 'Fuego', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Charmeleon_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Charmeleon_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Charmeleon.mp3\"', 36, NULL),
(6, 'Charizard', 'Fuego', 'Volador', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Charizard_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\Charizard_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Charizard.mp3\"', NULL, NULL),
(7, 'Squirtle', 'Agua', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\squirtle_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\squirtle_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Squirtle.mp3\"', 16, NULL),
(8, 'Wartortle', 'Agua', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\wartortle_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\wartortle_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Wartortle.mp3\"', 36, NULL),
(9, 'Blastoise', 'Agua', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\blastoise_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\blastoise_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Blastoise.mp3\"', NULL, NULL),
(10, 'Caterpie', 'Bicho', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\caterpie_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\caterpie_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Caterpie.mp3\"', 7, NULL),
(11, 'Metapod', 'Bicho', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\metapod_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\metapod_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Metapod.mp3\"', 10, NULL),
(12, 'Butterfree', 'Bicho', 'Volador', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\butterfree_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\butterfree_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Butterfree.mp3\"', NULL, NULL),
(13, 'Weedle', 'Bicho ', 'Veneno', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\weedle_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\weedle_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Weedle.mp3\"', 7, NULL),
(14, 'Kakuna', 'Bicho ', 'Veneno ', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\kakuna_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\kakuna_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Kakuna.mp3\"', 10, NULL),
(15, 'Beedrill', 'Bicho', 'Veneno', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\beedrill_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\beedrill_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Beedrill.mp3\"', NULL, NULL),
(16, 'Pidgey', 'Normal', 'Volador', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\pidgey_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\pidgey_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Pidgey.mp3\"', 18, NULL),
(17, 'Pidgeotto', 'Normal', 'Volador', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\pidgeotto_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\pidgeotto_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Pidgeotto.mp3\"', 36, NULL),
(18, 'Pidgeot', 'Normal', 'Volador', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\pidgeot_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\pidgeot_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Pidgeot.mp3\"', NULL, NULL),
(19, 'Rattata', 'Normal', '', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\rattata_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\rattata_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Rattata.mp3\"', 20, NULL),
(20, 'Raticate', 'Normal', '', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\raticate_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\raticate_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Raticate.mp3\"', NULL, NULL),
(21, 'Exeggcute', 'Planta', 'Psiquico', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\exeggcute_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\exeggcute_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Exeggcute.mp3\"', 26, NULL),
(22, 'Exeggutor', 'Planta', 'Psiquico', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\exeggutor_frente.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\exeggutor_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Exeggutor.mp3\"', NULL, NULL),
(23, 'Pikachu', 'Electrico', NULL, 'E:\\imagenes de los pokemons\\pikachu_delante.png', 'E:\\imagenes de los pokemons\\pikachu_detras.png', 'E:\\imagenes de los pokemons\\pikachu_sonido.mp3', 24, NULL),
(24, 'Raichu', 'Electrico', NULL, 'E:\\imagenes de los pokemons\\raichu_delante.png', 'E:\\imagenes de los pokemons\\raichu_detras.png', 'E:\\imagenes de los pokemons\\raichu_sonido.mp3', NULL, NULL),
(25, 'Vulpix', 'Fuego', NULL, 'E:\\imagenes de los pokemons\\vulpix_delante.png', 'E:\\imagenes de los pokemons\\vulpix_detras.png', 'E:\\imagenes de los pokemons\\vulpix_sonido.mp3', 24, NULL),
(26, 'Ninetales', 'Fuego', NULL, 'E:\\imagenes de los pokemons\\ninetales_delante.png', 'E:\\imagenes de los pokemons\\ninetales_detras.png', 'E:\\imagenes de los pokemons\\ninetales_sonido.mp3', NULL, NULL),
(27, 'Oddish', 'Planta', 'Veneno', 'E:\\imagenes de los pokemons\\oddish_delante.png', 'E:\\imagenes de los pokemons\\oddish_detras.png', 'E:\\imagenes de los pokemons\\oddish_sonido.mp3', 21, NULL),
(28, 'Gloom', 'Planta', 'Veneno', 'E:\\imagenes de los pokemons\\gloom_delante.png', 'E:\\imagenes de los pokemons\\gloom_detras.png', 'E:\\imagenes de los pokemons\\gloom_sonido.mp3', NULL, NULL),
(29, 'Diglett', 'Tierra', NULL, 'E:\\imagenes de los pokemons\\diglett_delante.png', 'E:\\imagenes de los pokemons\\diglett_detras.png', 'E:\\imagenes de los pokemons\\diglett_sonido.mp3', 26, NULL),
(30, 'Dugtrio', 'Tierra', NULL, 'E:\\imagenes de los pokemons\\dugtrio_delante.png', 'E:\\imagenes de los pokemons\\dugtrio_detras.png', 'E:\\imagenes de los pokemons\\dugtrio_sonido.mp3', NULL, NULL),
(31, 'Meowth', 'Normal', NULL, 'E:\\imagenes de los pokemons\\meowth_delante.png', 'E:\\imagenes de los pokemons\\meowth_detras.png', 'E:\\imagenes de los pokemons\\meowth_sonido.mp3', 28, NULL),
(32, 'Persian', 'Normal', NULL, 'E:\\imagenes de los pokemons\\persian_delante.png', 'E:\\imagenes de los pokemons\\persian_detras.png', 'E:\\imagenes de los pokemons\\persian_sonido.mp3', NULL, NULL),
(33, 'Psyduck', 'Agua', NULL, 'E:\\imagenes de los pokemons\\psyduck_delante.png', 'E:\\imagenes de los pokemons\\psyduck_detras.png', 'E:\\imagenes de los pokemons\\psyduck_sonido.mp3', NULL, NULL),
(34, 'Growlithe', 'Fuego', NULL, 'E:\\imagenes de los pokemons\\growlithe_delante.png', 'E:\\imagenes de los pokemons\\growlithe_detras.png', 'E:\\imagenes de los pokemons\\growlithe_sonido.mp3', 24, NULL),
(35, 'Arcanine', 'Fuego', NULL, 'E:\\imagenes de los pokemons\\arcanine_delante.png', 'E:\\imagenes de los pokemons\\arcanine_detras.png', 'E:\\imagenes de los pokemons\\arcanine_sonido.mp3', NULL, NULL),
(36, 'Abra', 'Psiquico', NULL, 'E:\\imagenes de los pokemons\\abra_delante.png', 'E:\\imagenes de los pokemons\\abra_detras.png', 'E:\\imagenes de los pokemons\\abra_sonido.mp3', 16, NULL),
(37, 'Kadabra', 'Psiquico', NULL, 'E:\\imagenes de los pokemons\\kadabra_delante.png', 'E:\\imagenes de los pokemons\\kadabra_detras.png', 'E:\\imagenes de los pokemons\\kadabra_sonido.mp3', 26, NULL),
(38, 'Alakazam', 'Psiquico', NULL, 'E:\\imagenes de los pokemons\\alakazam_delante.png', 'E:\\imagenes de los pokemons\\alakazam_detras.png', 'E:\\imagenes de los pokemons\\alakazam_sonido.mp3', NULL, NULL),
(39, 'Gastly', 'Fantasma', 'Veneno', 'E:\\imagenes de los pokemons\\gastly_delante.png', 'E:\\imagenes de los pokemons\\gastly_detras.png', 'E:\\imagenes de los pokemons\\gastly_sonido.mp3', 23, NULL),
(40, 'Haunter', 'Fantasma', 'Veneno', 'E:\\imagenes de los pokemons\\haunter_delante.png', 'E:\\imagenes de los pokemons\\haunter_detras.png', 'E:\\imagenes de los pokemons\\haunter_sonido.mp3', 30, NULL),
(41, 'Gengar', 'Fantasma', 'Veneno', 'E:\\imagenes de los pokemons\\gengar_delante.png', 'E:\\imagenes de los pokemons\\gengar_detras.png', 'E:\\imagenes de los pokemons\\gengar_sonido.mp3', NULL, NULL),
(42, 'Lapras', 'Agua', 'Hielo', 'E:\\imagenes de los pokemons\\lapras_delante.png', 'E:\\imagenes de los pokemons\\lapras_detras.png', 'E:\\imagenes de los pokemons\\lapras_sonido.mp3', NULL, NULL),
(43, 'Snorlax', 'Normal', NULL, 'E:\\imagenes de los pokemons\\snorlax_delante.png', 'E:\\imagenes de los pokemons\\snorlax_detras.png', 'E:\\imagenes de los pokemons\\snorlax_sonido.mp3', NULL, NULL),
(44, 'Machop', 'Lucha', NULL, 'E:\\imagenes de los pokemons\\machop_delante.png', 'E:\\imagenes de los pokemons\\machop_detras.png', 'E:\\imagenes de los pokemons\\machop_sonido.mp3', 28, NULL),
(45, 'Machoke', 'Lucha', NULL, 'E:\\imagenes de los pokemons\\machoke_delante.png', 'E:\\imagenes de los pokemons\\machoke_detras.png', 'E:\\imagenes de los pokemons\\machoke_sonido.mp3', 34, NULL),
(46, 'Machamp', 'Lucha', NULL, 'E:\\\\imagenes de los pokemons\\\\machamp_delante.png', '\"E:\\\\imagenes de los pokemons\\\\machamp_detras.png\"', '\"E:\\\\imagenes de los pokemons\\\\machamp_sonido.mp3\"', 0, NULL),
(47, 'Magikarp', 'Agua', NULL, '\"E:\\\\imagenes de los pokemons\\\\magikarp_delante.png\"', '\"E:\\\\imagenes de los pokemons\\\\magikarp_detras.png\"', '\"E:\\\\imagenes de los pokemons\\\\magikarp_sonido.mp3\"', 30, NULL),
(48, 'Gyarados', 'Agua', 'Volador', '\"E:\\\\imagenes de los pokemons\\\\gyarados_delante.png\"', '\"E:\\\\imagenes de los pokemons\\\\gyarados_detras.png\"', '\"E:\\\\imagenes de los pokemons\\\\gyarados_sonido.mp3\"', 0, NULL),
(49, 'Scyther', 'Bicho', 'Volador', '\"E:\\\\imagenes de los pokemons\\\\scyther_delante.png\"', '\"E:\\\\imagenes de los pokemons\\\\scyther_detras.png\"', '\"E:\\\\imagenes de los pokemons\\\\scyther_sonido.mp3\"', 0, NULL),
(50, 'Arceus', 'Normal', NULL, '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\arceus_delante.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\Sprites\\\\arceus_detras.png\"', '\"C:\\\\Users\\\\jorge\\\\Desktop\\\\Proyecto_Pokemon\\\\base_de_datos\\\\sonidos_pokemon\\\\Arceus.mp3\"', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `ID_POKEMON` int(11) NOT NULL,
  `NUM_POKEDEX` int(11) DEFAULT NULL,
  `ID_ENTRENADOR` int(11) DEFAULT NULL,
  `CAJA` int(11) NOT NULL,
  `NOMBRE` varchar(15) DEFAULT NULL,
  `MOTE` varchar(30) DEFAULT NULL,
  `SALUD` int(11) NOT NULL,
  `ATAQUE` int(11) NOT NULL,
  `DEFENSA` int(11) NOT NULL,
  `VELOCIDAD` int(11) NOT NULL,
  `AT_ESPECIAL` int(11) NOT NULL,
  `DEF_ESPECIAL` int(11) NOT NULL,
  `NIVEL` int(11) NOT NULL,
  `FERTILIDAD` int(11) NOT NULL,
  `SEXO` char(1) NOT NULL,
  `ESTADO` varchar(20) NOT NULL,
  `EXPERIENCIA` int(11) NOT NULL,
  `MOVIMIENTO1` text DEFAULT NULL,
  `MOVIMIENTO2` text DEFAULT NULL,
  `MOVIMIENTO3` text DEFAULT NULL,
  `MOVIMIENTO4` text DEFAULT NULL,
  `TIPO1` varchar(50) NOT NULL,
  `TIPO2` varchar(50) NOT NULL,
  `ID_OBJETO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `ID_TURNO` int(11) NOT NULL,
  `ACCION_ENTRENADOR` varchar(150) NOT NULL,
  `ACCION_RIVAL` varchar(150) NOT NULL,
  `ID_COMBATE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `combate`
--
ALTER TABLE `combate`
  ADD PRIMARY KEY (`ID_COMBATE`),
  ADD KEY `ID_ENTRENADOR` (`ID_ENTRENADOR`);

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`ID_ENTRENADOR`);

--
-- Indices de la tabla `mochila`
--
ALTER TABLE `mochila`
  ADD PRIMARY KEY (`ID_ENTRENADOR`,`ID_OBJETO`),
  ADD KEY `fk_objeto` (`ID_OBJETO`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`ID_MOVIMIENTO`);

--
-- Indices de la tabla `movimiento_pokemon`
--
ALTER TABLE `movimiento_pokemon`
  ADD PRIMARY KEY (`ID_MOVIMIENTO`,`ID_POKEMON`),
  ADD KEY `ID_POKEMON` (`ID_POKEMON`);

--
-- Indices de la tabla `objeto`
--
ALTER TABLE `objeto`
  ADD PRIMARY KEY (`ID_OBJETO`);

--
-- Indices de la tabla `pokedex`
--
ALTER TABLE `pokedex`
  ADD PRIMARY KEY (`NUM_POKEDEX`),
  ADD KEY `FK_NUM_POKEDEX_EVO` (`FK_NUM_POKEDEX_EVO`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`ID_POKEMON`),
  ADD KEY `NUM_POKEDEX` (`NUM_POKEDEX`),
  ADD KEY `ID_ENTRENADOR` (`ID_ENTRENADOR`),
  ADD KEY `ID_OBJETO` (`ID_OBJETO`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`ID_TURNO`),
  ADD KEY `ID_COMBATE` (`ID_COMBATE`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `combate`
--
ALTER TABLE `combate`
  ADD CONSTRAINT `combate_ibfk_1` FOREIGN KEY (`ID_ENTRENADOR`) REFERENCES `entrenador` (`ID_ENTRENADOR`);

--
-- Filtros para la tabla `mochila`
--
ALTER TABLE `mochila`
  ADD CONSTRAINT `fk_entrenador` FOREIGN KEY (`ID_ENTRENADOR`) REFERENCES `entrenador` (`ID_ENTRENADOR`),
  ADD CONSTRAINT `fk_objeto` FOREIGN KEY (`ID_OBJETO`) REFERENCES `objeto` (`ID_OBJETO`);

--
-- Filtros para la tabla `movimiento_pokemon`
--
ALTER TABLE `movimiento_pokemon`
  ADD CONSTRAINT `movimiento_pokemon_ibfk_1` FOREIGN KEY (`ID_MOVIMIENTO`) REFERENCES `movimientos` (`ID_MOVIMIENTO`),
  ADD CONSTRAINT `movimiento_pokemon_ibfk_2` FOREIGN KEY (`ID_POKEMON`) REFERENCES `pokemon` (`ID_POKEMON`);

--
-- Filtros para la tabla `pokedex`
--
ALTER TABLE `pokedex`
  ADD CONSTRAINT `pokedex_ibfk_1` FOREIGN KEY (`FK_NUM_POKEDEX_EVO`) REFERENCES `pokedex` (`NUM_POKEDEX`);

--
-- Filtros para la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD CONSTRAINT `pokemon_ibfk_1` FOREIGN KEY (`NUM_POKEDEX`) REFERENCES `pokedex` (`NUM_POKEDEX`),
  ADD CONSTRAINT `pokemon_ibfk_2` FOREIGN KEY (`ID_ENTRENADOR`) REFERENCES `entrenador` (`ID_ENTRENADOR`),
  ADD CONSTRAINT `pokemon_ibfk_3` FOREIGN KEY (`ID_OBJETO`) REFERENCES `objeto` (`ID_OBJETO`);

--
-- Filtros para la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD CONSTRAINT `turnos_ibfk_1` FOREIGN KEY (`ID_COMBATE`) REFERENCES `combate` (`ID_COMBATE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
