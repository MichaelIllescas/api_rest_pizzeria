-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2024 a las 11:52:56
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
-- Base de datos: `pizzeria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE `customer` (
  `id_customer` varchar(15) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `customer`
--

INSERT INTO `customer` (`id_customer`, `adress`, `email`, `name`, `phone_number`) VALUES
('110410415', 'Ap #720-1833 Curabitur Av.', 'mercedesbalorclub@hotmail.com', 'Mercedes Balor', '(688) 944-6619'),
('182120056', 'Ap #268-1749 Id St.', 'heymanboss@hotmail.com', 'Matthew Heyman', '(185) 738-9267'),
('192758012', '705-6031 Aliquam Street', 'wangwatson@icloud.com', 'Drew Watson', '(362) 881-5943'),
('262132898', '241-9121 Fames St.', 'stonecold@icloud.com', 'Karl Austin', '(559) 596-3381'),
('303265780', 'Ap #206-5413 Vivamus St.', 'figthowens@platzi.com', 'Shelton Owens', '(821) 880-6661'),
('363677933', 'Ap #937-4424 Vestibulum. Street', 'bianca0402@platzi.com', 'Bianca Neal', '(792) 406-8858'),
('394022487', 'P.O. Box 341, 7572 Odio Rd.', 'beckytwobelts@icloud.com', 'Becky Alford', '(559) 398-7689'),
('474771564', '925-3988 Purus. St.', 'johareigns@outlook.com', 'Johanna Reigns', '(801) 370-4041'),
('531254932', '461-4278 Dignissim Av.', 'wyattplay@google.co', 'Clarke Wyatt', '(443) 263-8555'),
('617684636', 'Ap #732-8087 Dui. Road', 'aleximorgan@hotmail.com', 'Alexa Morgan', '(830) 212-2247'),
('644337170', 'Ap #308-4700 Mollis Av.', 'elgenerico@outlook.com', 'Sami Rollins', '(508) 518-2967'),
('762085429', '177-1125 Consequat Ave', 'codyforchamp@google.com', 'Cody Rollins', '(740) 271-3631'),
('782668115', 'Ap #696-6846 Ullamcorper Avenue', 'amityrogers@outlook.com', 'Charlotte Riddle', '(744) 344-7768'),
('863264988', 'P.O. Box 136, 4534 Lacinia St.', 'draketheory@hotmail.com', 'Drake Theory', '(826) 607-2278'),
('885583622', '9063 Aliquam, Road', 'brockalford595@platzi.com', 'Brock Alford', '(732) 218-4844');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order_item`
--

CREATE TABLE `order_item` (
  `id_item` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `id_pizza` int(11) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `quantity` decimal(2,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `order_item`
--

INSERT INTO `order_item` (`id_item`, `id_order`, `id_pizza`, `price`, `quantity`) VALUES
(1, 1, 1, 23.00, 1.0),
(1, 2, 2, 18.50, 1.0),
(1, 3, 3, 22.00, 1.0),
(1, 4, 8, 42.00, 2.0),
(1, 5, 10, 11.00, 0.5),
(1, 6, 11, 23.00, 1.0),
(2, 1, 4, 19.95, 1.0),
(2, 2, 6, 24.00, 1.0),
(2, 5, 12, 9.50, 0.5),
(3, 2, 7, 19.50, 1.0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizza`
--

CREATE TABLE `pizza` (
  `id_pizza` int(11) NOT NULL,
  `avaiable` tinyint(4) NOT NULL,
  `description` varchar(150) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `vegan` tinyint(4) DEFAULT NULL,
  `vegetarian` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pizza`
--

INSERT INTO `pizza` (`id_pizza`, `avaiable`, `description`, `name`, `price`, `vegan`, `vegetarian`) VALUES
(1, 1, 'Pepperoni, Homemade Tomato Sauce & Mozzarella.', 'Pepperoni', 23.00, 0, 0),
(2, 1, 'Fior de Latte, Homemade Tomato Sauce, Extra Virgin Olive Oil & Basil.', 'Margherita', 18.50, 0, 1),
(3, 1, 'Fior de Latte, Homemade Tomato Sauce, Extra Virgin Olive Oil & Basil.', 'Vegan Margherita', 22.00, 1, 1),
(4, 1, 'Hass Avocado, House Red Sauce, Sundried Tomatoes, Basil & Lemon Zest.', 'Avocado Festival', 19.95, 0, 1),
(5, 0, 'Homemade Tomato Sauce, Mozzarella, Pineapple & Ham.', 'Hawaiian', 20.50, 0, 0),
(6, 1, 'Portobello Mushrooms, Mozzarella, Parmesan & Goat Cheeses with Alfredo Sauce.', 'Goat Chesse', 24.00, 0, 0),
(7, 1, 'Artichokes, Roasted Peppers, Rapini, Sundried Tomatoes, Onion, Shaved Green Bell Peppers & Sunny Seasoning.', 'Mother Earth', 19.50, 0, 1),
(8, 1, 'Mild Italian Sausage, Pepperoni, Bacon, Homemade Tomato Sauce & Mozzarella.', 'Meat Lovers', 21.00, 0, 0),
(9, 0, 'Marinated Chicken with Cilantro, Red Onions, Gouda, Parmesan & Mozzarella Cheeses.', 'Marinated BBQ Chicken', 20.95, 0, 0),
(10, 1, 'Wild mushrooms, Baby Kale, Shiitake Bacon & Lemon Vinaigrette. Soy free.', 'Truffle Cashew Cream', 22.00, 1, 1),
(11, 1, 'Beef Chorizo, Sundried Tomatoes, Salsa Verde, Pepper, Jalapeno & pistachios', 'Rico Mor', 23.00, 0, 0),
(12, 1, 'Fresh Spinach, Marinated Artichoke Hearts, Garlic, Fior de Latte, Mozzarella & Parmesan.', 'Spinach Artichoke', 18.95, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizza_order`
--

CREATE TABLE `pizza_order` (
  `id_order` int(11) NOT NULL,
  `aditional_notes` varchar(200) DEFAULT NULL,
  `date` datetime NOT NULL,
  `id_customer` varchar(15) NOT NULL,
  `method` char(1) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `total` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pizza_order`
--

INSERT INTO `pizza_order` (`id_order`, `aditional_notes`, `date`, `id_customer`, `method`, `price`, `total`) VALUES
(1, 'Don\'t be late pls.', '2024-10-04 17:01:53', '192758012', 'D', 0.00, 42.95),
(2, NULL, '2024-07-27 17:01:53', '474771564', 'S', 0.00, 62.00),
(3, NULL, '2024-07-28 17:01:53', '182120056', 'C', 0.00, 22.00),
(4, NULL, '2024-07-29 17:01:53', '617684636', 'S', 0.00, 42.00),
(5, 'Please bring the jalapeños separately.', '2024-07-30 17:01:53', '192758012', 'D', 0.00, 20.50),
(6, NULL, '2024-07-31 17:01:53', '782668115', 'D', 0.00, 23.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`),
  ADD UNIQUE KEY `UKdwk6cx0afu8bs9o4t536v1j5v` (`email`);

--
-- Indices de la tabla `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`id_item`,`id_order`),
  ADD KEY `FKakuoq412rnkuv4k0xsqeam5k0` (`id_order`),
  ADD KEY `FKgy49avjjdhl48p67qplglv6sr` (`id_pizza`);

--
-- Indices de la tabla `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`id_pizza`),
  ADD UNIQUE KEY `UK6n1plxa8aecur40e4q2vpcrps` (`name`);

--
-- Indices de la tabla `pizza_order`
--
ALTER TABLE `pizza_order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `FKnlayechpuwervvwn2ius58ney` (`id_customer`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pizza`
--
ALTER TABLE `pizza`
  MODIFY `id_pizza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `pizza_order`
--
ALTER TABLE `pizza_order`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `FKakuoq412rnkuv4k0xsqeam5k0` FOREIGN KEY (`id_order`) REFERENCES `pizza_order` (`id_order`),
  ADD CONSTRAINT `FKgy49avjjdhl48p67qplglv6sr` FOREIGN KEY (`id_pizza`) REFERENCES `pizza` (`id_pizza`);

--
-- Filtros para la tabla `pizza_order`
--
ALTER TABLE `pizza_order`
  ADD CONSTRAINT `FKnlayechpuwervvwn2ius58ney` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
