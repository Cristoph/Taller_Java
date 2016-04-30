-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 27-04-2016 a las 21:34:04
-- Versión del servidor: 5.0.45
-- Versión de PHP: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `t-skplata`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `clientes`
-- 

CREATE TABLE `Clientes` (
  `rut` varchar(200) collate utf8_unicode_ci NOT NULL,
  `nombres` varchar(200) collate utf8_unicode_ci NOT NULL,
  `apellidos` varchar(200) collate utf8_unicode_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `domicilio` varchar(200) collate utf8_unicode_ci NOT NULL,
  `fono` int(10) NOT NULL,
  `mail` varchar(200) collate utf8_unicode_ci NOT NULL,
  `tipoCuenta` varchar(200) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`rut`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 
-- Volcar la base de datos para la tabla `clientes`
-- 