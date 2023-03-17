-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-03-2023 a las 22:31:31
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pos_ventamvc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajas`
--

CREATE TABLE `cajas` (
  `id_caja` int(11) NOT NULL,
  `nombre_caja` varchar(70) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cajas`
--

INSERT INTO `cajas` (`id_caja`, `nombre_caja`, `estado`) VALUES
(1, 'Principal', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  `estado` varchar(12) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `categoria`, `estado`) VALUES
(1, 'Vegetales', 'Activo'),
(2, 'Aseo', 'Activo'),
(3, 'Aseo Personal', 'Activo'),
(4, 'Enlatados', 'Activo'),
(5, 'Gaseosa', 'Activo'),
(6, 'Granos', 'Activo'),
(7, 'Confitería', 'Activo'),
(8, 'Dulces', 'Activo'),
(9, 'Comestibles', 'Activo'),
(10, 'Bebidas', 'Activo'),
(11, 'Alimento animal', 'Activo'),
(12, 'Hijiene personal', 'Activo'),
(13, 'Alimenticio', 'Activo'),
(14, 'Endulzante', 'Activo'),
(15, 'Licor', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `estado` varchar(12) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `telefono`, `direccion`, `estado`) VALUES
(1, 'Nora Jakeline Rúa Quiróz', '3187215980', 'Calle 4 Nro 32 - 11', 'Activo'),
(2, 'Robin Castaño Aguirre', '3228657766', 'Carrera 22 Nro 57A - 15', 'Activo'),
(3, 'Roberto Hernández', '3124987151', 'Diagonal 6 Nro 5 - 08', 'Activo'),
(4, 'Juan Andrés', '3215804141', 'Calle 23 Nro 44-08', 'Activo'),
(5, 'Katerine Miranda', '5403030', 'Av 44 Nro 43-09', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `total` decimal(10,1) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`id_compra`, `id_proveedor`, `id_usuario`, `total`, `fecha`) VALUES
(1, 5, 4, '152000.0', '2023-03-10 19:36:27'),
(2, 2, 3, '440000.0', '2023-03-10 19:36:34'),
(3, 6, 2, '160000.0', '2023-03-10 19:36:38'),
(4, 3, 1, '91000.0', '2023-03-10 19:36:44'),
(5, 2, 4, '60000.0', '2023-03-10 19:37:59'),
(6, 6, 3, '420000.0', '2023-03-10 19:38:04'),
(7, 6, 2, '170000.0', '2023-03-10 19:38:09'),
(8, 3, 1, '180000.0', '2023-03-10 19:38:12'),
(9, 1, 1, '1115000.0', '2023-03-10 19:38:22'),
(10, 3, 2, '900000.0', '2023-03-10 19:38:29'),
(11, 1, 3, '1475000.0', '2023-03-10 19:38:33'),
(12, 1, 4, '335000.0', '2023-03-10 19:38:37'),
(13, 4, 1, '210000.0', '2023-03-10 19:38:45'),
(14, 6, 2, '300000.0', '2023-03-10 19:38:57'),
(15, 3, 3, '200000.0', '2023-03-10 19:39:02'),
(16, 6, 4, '1600000.0', '2023-03-10 19:39:07'),
(17, 2, 4, '65000.0', '2023-03-10 19:39:31'),
(18, 6, 3, '130000.0', '2023-03-10 19:39:35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE `configuracion` (
  `id_conf` int(11) NOT NULL,
  `nit` varchar(30) NOT NULL,
  `nombreEmpresa` varchar(100) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `Mensaje` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`id_conf`, `nit`, `nombreEmpresa`, `telefono`, `direccion`, `Mensaje`) VALUES
(1, '200.654.321-1', 'Mi Tienda ', '3205601212', 'Calle 90 Nro 35-21', '¡Te esperamos pronto, nuestra tienda innovadora a tu disposición!. Gracias por tu compra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_cajas`
--

CREATE TABLE `detalle_cajas` (
  `id_detalle_cajas` int(11) NOT NULL,
  `fecha_apertura` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fecha_cierre` datetime DEFAULT NULL,
  `monto_inicial` double(10,1) NOT NULL,
  `monto_final` double(10,1) DEFAULT NULL,
  `total_ventas` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_caja` int(11) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_cajas`
--

INSERT INTO `detalle_cajas` (`id_detalle_cajas`, `fecha_apertura`, `fecha_cierre`, `monto_inicial`, `monto_final`, `total_ventas`, `id_usuario`, `id_caja`, `estado`) VALUES
(1, '2023-03-14 03:07:10', NULL, 1000.0, NULL, NULL, 2, 1, 0),
(2, '2023-03-14 03:08:11', '2023-03-13 14:20:35', 45000.0, 0.0, 0, 1, 1, 0),
(3, '2023-03-14 16:55:58', '2023-03-14 11:55:58', 400000.0, 499000.0, 2, 1, 1, 0),
(4, '2023-03-14 17:35:55', '2023-03-14 12:35:55', 600000.0, 700100.0, 5, 1, 1, 0),
(5, '2023-03-14 18:06:11', '2023-03-14 13:06:10', 100000.0, 978600.0, 7, 1, 1, 0),
(6, '2023-03-14 18:11:11', '2023-03-14 13:11:11', 250000.0, 1332200.0, 10, 1, 1, 0),
(7, '2023-03-14 20:03:19', '2023-03-14 15:03:18', 300000.0, 1514000.0, 12, 1, 1, 0),
(8, '2023-03-14 20:18:37', '2023-03-14 15:18:36', 130000.0, 192400.0, 3, 2, 1, 0),
(9, '2023-03-14 20:41:52', '2023-03-14 15:41:50', 30000.0, 352400.0, 5, 2, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE `detalle_compra` (
  `id` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` decimal(10,1) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `sub_total` decimal(10,1) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_compra`
--

INSERT INTO `detalle_compra` (`id`, `id_compra`, `id_producto`, `precio`, `cantidad`, `sub_total`, `fecha`) VALUES
(1, 1, 2, '13000.0', 4, '52000.0', '2022-08-11 01:30:18'),
(2, 1, 4, '10000.0', 10, '100000.0', '2022-08-11 01:30:18'),
(3, 2, 1, '20000.0', 7, '140000.0', '2022-08-11 01:34:11'),
(4, 2, 6, '15000.0', 20, '300000.0', '2022-08-11 01:34:11'),
(5, 3, 3, '80000.0', 2, '160000.0', '2022-08-11 01:37:33'),
(6, 4, 2, '13000.0', 7, '91000.0', '2022-08-11 01:39:10'),
(7, 5, 5, '3000.0', 20, '60000.0', '2022-08-12 01:59:53'),
(8, 6, 1, '20000.0', 15, '300000.0', '2022-08-12 02:54:22'),
(9, 6, 6, '15000.0', 8, '120000.0', '2022-08-12 02:54:22'),
(10, 7, 4, '10000.0', 10, '100000.0', '2022-08-12 03:00:50'),
(11, 7, 4, '10000.0', 7, '70000.0', '2022-08-12 03:00:50'),
(12, 8, 1, '20000.0', 9, '180000.0', '2022-08-12 03:05:06'),
(13, 9, 4, '10000.0', 50, '500000.0', '2022-08-12 03:27:16'),
(14, 9, 6, '15000.0', 21, '315000.0', '2022-08-12 03:27:16'),
(15, 9, 1, '20000.0', 15, '300000.0', '2022-08-12 03:27:16'),
(16, 10, 1, '20000.0', 20, '400000.0', '2022-09-18 02:55:33'),
(17, 10, 4, '10000.0', 50, '500000.0', '2022-09-18 02:55:33'),
(18, 11, 7, '3000.0', 25, '75000.0', '2023-03-02 18:25:03'),
(19, 11, 8, '40000.0', 15, '600000.0', '2023-03-02 18:25:03'),
(20, 11, 3, '80000.0', 10, '800000.0', '2023-03-02 18:25:03'),
(21, 12, 2, '13000.0', 20, '260000.0', '2023-03-02 18:36:29'),
(22, 12, 5, '3000.0', 25, '75000.0', '2023-03-02 18:36:29'),
(23, 13, 6, '15000.0', 13, '195000.0', '2023-03-02 18:42:57'),
(24, 13, 5, '3000.0', 5, '15000.0', '2023-03-02 18:42:57'),
(25, 14, 6, '15000.0', 20, '300000.0', '2023-03-02 19:04:28'),
(26, 15, 8, '40000.0', 5, '200000.0', '2023-03-02 19:07:54'),
(27, 16, 3, '80000.0', 20, '1600000.0', '2023-03-02 19:23:59'),
(28, 17, 2, '13000.0', 5, '65000.0', '2023-03-02 19:35:34'),
(29, 18, 2, '13000.0', 10, '130000.0', '2023-03-02 22:21:09');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_det_venta` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `precio_unitario` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_det_venta`, `id_venta`, `precio_unitario`, `cantidad`, `subtotal`, `id_producto`, `id_cliente`, `id_usuario`, `fecha`) VALUES
(1, 1, 95000, 5, 475000, 3, 1, 1, '2023-03-14 03:10:41'),
(2, 2, 3400, 1, 3400, 5, 1, 2, '2023-03-14 03:28:02'),
(3, 2, 3500, 2, 7000, 7, 1, 2, '2023-03-14 03:28:02'),
(4, 3, 12000, 2, 24000, 4, 4, 1, '2023-03-14 16:55:36'),
(5, 4, 3400, 1, 3400, 5, 2, 3, '2023-03-14 17:02:10'),
(6, 4, 5000, 1, 5000, 8, 2, 3, '2023-03-14 17:02:10'),
(7, 5, 23000, 2, 46000, 1, 3, 3, '2023-03-14 17:04:01'),
(8, 5, 3400, 3, 10200, 5, 3, 3, '2023-03-14 17:04:01'),
(9, 5, 15500, 1, 15500, 2, 3, 3, '2023-03-14 17:04:01'),
(10, 6, 3500, 1, 3500, 7, 5, 3, '2023-03-14 17:06:03'),
(11, 6, 95000, 1, 95000, 3, 5, 3, '2023-03-14 17:06:03'),
(12, 7, 15500, 2, 31000, 2, 4, 1, '2023-03-14 17:30:49'),
(13, 7, 17000, 1, 17000, 6, 4, 1, '2023-03-14 17:30:49'),
(14, 7, 23000, 1, 23000, 1, 4, 1, '2023-03-14 17:30:49'),
(15, 8, 3400, 1, 3400, 5, 1, 1, '2023-03-14 17:32:23'),
(16, 8, 5000, 3, 15000, 8, 1, 1, '2023-03-14 17:32:23'),
(17, 9, 12000, 4, 48000, 4, 3, 1, '2023-03-14 17:35:11'),
(18, 9, 3500, 2, 7000, 7, 3, 1, '2023-03-14 17:35:11'),
(19, 9, 15500, 3, 46500, 2, 3, 1, '2023-03-14 17:35:11'),
(20, 9, 3400, 3, 10200, 5, 3, 1, '2023-03-14 17:35:11'),
(21, 10, 95000, 1, 95000, 3, 3, 1, '2023-03-14 18:01:03'),
(22, 10, 3500, 1, 3500, 7, 3, 1, '2023-03-14 18:01:03'),
(23, 11, 95000, 1, 95000, 3, 3, 1, '2023-03-14 18:05:57'),
(24, 11, 17000, 5, 85000, 6, 3, 1, '2023-03-14 18:05:57'),
(25, 12, 12000, 8, 96000, 4, 5, 1, '2023-03-14 18:08:58'),
(26, 12, 17000, 2, 34000, 6, 5, 1, '2023-03-14 18:08:59'),
(27, 12, 5000, 6, 30000, 8, 5, 1, '2023-03-14 18:08:59'),
(28, 13, 23000, 3, 69000, 1, 4, 1, '2023-03-14 18:09:55'),
(29, 13, 17000, 3, 51000, 6, 4, 1, '2023-03-14 18:09:55'),
(30, 14, 3400, 4, 13600, 5, 3, 1, '2023-03-14 18:10:55'),
(31, 14, 12000, 5, 60000, 4, 3, 1, '2023-03-14 18:10:55'),
(32, 15, 23000, 2, 46000, 1, 5, 1, '2023-03-14 20:01:49'),
(33, 15, 3400, 2, 6800, 5, 5, 1, '2023-03-14 20:01:49'),
(34, 16, 17000, 2, 34000, 6, 2, 1, '2023-03-14 20:02:59'),
(35, 16, 95000, 1, 95000, 3, 2, 1, '2023-03-14 20:02:59'),
(36, 17, 3400, 5, 17000, 5, 3, 2, '2023-03-14 20:14:17'),
(37, 17, 15500, 2, 31000, 2, 3, 2, '2023-03-14 20:14:17'),
(38, 17, 12000, 2, 24000, 4, 3, 2, '2023-03-14 20:14:17'),
(39, 17, 23000, 3, 69000, 1, 3, 2, '2023-03-14 20:14:17'),
(40, 18, 17000, 2, 34000, 6, 4, 2, '2023-03-14 20:18:21'),
(41, 18, 3500, 2, 7000, 7, 4, 2, '2023-03-14 20:18:21'),
(42, 19, 12000, 2, 24000, 4, 5, 2, '2023-03-14 20:39:57'),
(43, 19, 5000, 1, 5000, 8, 5, 2, '2023-03-14 20:39:57'),
(44, 20, 12000, 3, 36000, 4, 3, 2, '2023-03-14 20:40:45'),
(45, 20, 95000, 1, 95000, 3, 3, 2, '2023-03-14 20:40:45');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medidas`
--

CREATE TABLE `medidas` (
  `id` int(11) NOT NULL,
  `medida` varchar(30) NOT NULL,
  `nombre_corto` varchar(5) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medidas`
--

INSERT INTO `medidas` (`id`, `medida`, `nombre_corto`, `estado`) VALUES
(1, 'Gramos', 'gs', 'Activo'),
(2, 'Kilo', 'k', 'Activo'),
(3, 'Kilos', 'ks', 'Activo'),
(4, 'Arroba', '@', 'Activo'),
(5, 'Onza', 'oz', 'Activo'),
(6, 'Paca', 'p', 'Activo'),
(7, 'Libra', 'l', 'Activo'),
(8, 'Bulto', 'b', 'Activo'),
(9, 'Caja', 'c', 'Activo'),
(10, 'Litros', 'lts', 'Activo'),
(11, 'Galón', 'gl', 'Activo'),
(12, 'Unidad', 'u', 'Activo'),
(13, 'Unidades', 'uds', 'Activo'),
(14, 'Decena', 'dcn', 'Activo'),
(15, 'Paquete', 'pte', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `codigo` varchar(25) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 0,
  `precio_compra` decimal(10,1) NOT NULL,
  `precio_venta` decimal(10,1) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_medida` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `codigo`, `descripcion`, `cantidad`, `precio_compra`, `precio_venta`, `id_proveedor`, `id_medida`, `id_categoria`, `estado`) VALUES
(1, 'EEE-43', 'Garrafa de aceite x 3000', 47, '21000.0', '23000.0', 6, 7, 7, 'Activo'),
(2, 'AFE-09K', 'Tarro de cola granulada x 800 gramos', 32, '13000.0', '15500.0', 2, 1, 13, 'Activo'),
(3, 'UEG44', 'Frijol Cargamnto', 20, '80000.0', '95000.0', 6, 3, 9, 'Activo'),
(4, 'TTE-hb2', 'Frasco de mermelada', 87, '10000.0', '12000.0', 1, 10, 8, 'Activo'),
(5, 'JHT-9KO', 'Bolsa de leche Colanta líquida', 21, '3000.0', '3400.0', 4, 10, 10, 'Activo'),
(6, 'REEB-0P', 'Garrafa de límpido x 5000', 55, '15000.0', '17000.0', 3, 10, 2, 'Activo'),
(7, 'AEE-33', 'Crema dental pequeña', 17, '3000.0', '3500.0', 6, 1, 12, 'Activo'),
(8, 'WWW-98', 'Mermelada de Mora', 2, '40000.0', '5000.0', 4, 13, 13, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `nit` varchar(20) NOT NULL,
  `proveedor` varchar(50) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `direccion` varchar(70) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `nit`, `proveedor`, `telefono`, `direccion`, `estado`) VALUES
(1, '890.358.544-1', 'Delicias la 32', '3225809025', 'Calle 90 Nro 64B - 40', 'Activo'),
(2, '891.879.410-2', 'SurtiMax', '5221010', 'Av 15 Nro 78 -90', 'Activo'),
(3, '891.358.361-1', 'Productos la Montaña', '3215894710', 'Carrera 80 Nro 80- 09', 'Activo'),
(4, '547.689.253-9', 'Exito', '2401111', 'Carrera 55 Nro 88- 90', 'Activo'),
(5, '579.500.58-9', 'Abarrotes La Rebaja', '3214587730', 'Diagonal 6 Nro 54 -0 9', 'Activo'),
(6, '580.900477-3', 'Mayoritarios SA', '2101414', 'Carrera 45 Nro76 - 90', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(20) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre_rol`, `estado`) VALUES
(1, 'Administrador', 'Activo'),
(2, 'Empleado', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `id_caja` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `estado` varchar(12) NOT NULL DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `usuario`, `nombre`, `clave`, `id_caja`, `id_rol`, `estado`) VALUES
(1, 'diego', 'Diego Mauricio Arango García', 'admin', 1, 1, 'Activo'),
(2, 'java', 'Desarrollo en Java MVC', '0000', 1, 1, 'Activo'),
(3, 'admin', 'mvc111', '1111', 1, 2, 'Activo'),
(4, 'aprendiz', 'Programador', '2222', 1, 2, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `total` double NOT NULL,
  `pago_con` int(11) NOT NULL DEFAULT 0,
  `devolucion` int(11) NOT NULL DEFAULT 0,
  `id_usuario` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `total`, `pago_con`, `devolucion`, `id_usuario`, `fecha`) VALUES
(1, 475000, 500000, 25000, 1, '2023-03-14 03:10:41'),
(2, 10400, 11000, 600, 2, '2023-03-14 03:28:02'),
(3, 24000, 25000, 1000, 1, '2023-03-14 16:55:36'),
(4, 8400, 10000, 1600, 3, '2023-03-14 17:02:10'),
(5, 71700, 72000, 300, 3, '2023-03-14 17:04:01'),
(6, 98500, 100000, 1500, 3, '2023-03-14 17:06:03'),
(7, 71000, 71000, 0, 1, '2023-03-14 17:30:49'),
(8, 18400, 20000, 1600, 1, '2023-03-14 17:32:23'),
(9, 111700, 112000, 300, 1, '2023-03-14 17:35:11'),
(10, 98500, 100000, 1500, 1, '2023-03-14 18:01:03'),
(11, 180000, 200000, 20000, 1, '2023-03-14 18:05:57'),
(12, 160000, 200000, 40000, 1, '2023-03-14 18:08:58'),
(13, 120000, 120000, 0, 1, '2023-03-14 18:09:55'),
(14, 73600, 80000, 6400, 1, '2023-03-14 18:10:55'),
(15, 52800, 60000, 7200, 1, '2023-03-14 20:01:49'),
(16, 129000, 150000, 21000, 1, '2023-03-14 20:02:59'),
(17, 141000, 150000, 9000, 2, '2023-03-14 20:14:17'),
(18, 41000, 50000, 9000, 2, '2023-03-14 20:18:21'),
(19, 29000, 30000, 1000, 2, '2023-03-14 20:39:57'),
(20, 131000, 150000, 19000, 2, '2023-03-14 20:40:45');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajas`
--
ALTER TABLE `cajas`
  ADD PRIMARY KEY (`id_caja`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_proveedor` (`id_proveedor`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`id_conf`);

--
-- Indices de la tabla `detalle_cajas`
--
ALTER TABLE `detalle_cajas`
  ADD PRIMARY KEY (`id_detalle_cajas`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_caja` (`id_caja`);

--
-- Indices de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_compra` (`id_compra`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id_det_venta`),
  ADD KEY `Fk_ventas` (`id_venta`),
  ADD KEY `Fk_usuarios` (`id_usuario`),
  ADD KEY `Fk_productos` (`id_producto`),
  ADD KEY `Fk_clientes` (`id_cliente`);

--
-- Indices de la tabla `medidas`
--
ALTER TABLE `medidas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_proveedor` (`id_proveedor`),
  ADD KEY `id_medida` (`id_medida`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `id_caja` (`id_caja`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cajas`
--
ALTER TABLE `cajas`
  MODIFY `id_caja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  MODIFY `id_conf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalle_cajas`
--
ALTER TABLE `detalle_cajas`
  MODIFY `id_detalle_cajas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id_det_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de la tabla `medidas`
--
ALTER TABLE `medidas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `Fk_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`),
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `detalle_cajas`
--
ALTER TABLE `detalle_cajas`
  ADD CONSTRAINT `detalle_cajas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `detalle_cajas_ibfk_2` FOREIGN KEY (`id_caja`) REFERENCES `cajas` (`id_caja`);

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `Fk_compras` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  ADD CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `Fk_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `Fk_productos` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `Fk_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `Fk_ventas` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`),
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`id_medida`) REFERENCES `medidas` (`id`),
  ADD CONSTRAINT `productos_ibfk_3` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_caja`) REFERENCES `cajas` (`id_caja`),
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
