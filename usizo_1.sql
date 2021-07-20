-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 08 juil. 2021 à 13:40
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `usizo`
--

-- --------------------------------------------------------

--
-- Structure de la table `data_base_object`
--

DROP TABLE IF EXISTS `data_base_object`;
CREATE TABLE IF NOT EXISTS `data_base_object` (
  `dtype` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1hmr4jq3u65oes75csu7glfxj` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `data_base_object`
--

INSERT INTO `data_base_object` (`dtype`, `id`, `img_url`, `nom`, `type`, `password`, `role_id`) VALUES
('User', 1, 'https://steamuserimages-a.akamaihd.net/ugc/794237560596039857/B9B4B62FD6EF6B14BB4BF8C3288BBE33D0C887BB/?imw=512&&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=false', 'illu', NULL, '$2a$10$BF3WZ0iGIZUTIAfn0klvE.zK8g/0dnksA3ET7Xtttndmlws16wj1a', 2),
('User', 2, 'https://lh3.googleusercontent.com/P5gYv4mST3KelPzV7Ut9zija-VdXHf1F2jQTSQWBfocP6COPRV-m42dgXXKlZWX5GYq1yeKUKP3xT3PftkvtKA', 'Dyl', NULL, '$2a$10$BF3WZ0iGIZUTIAfn0klvE.zK8g/0dnksA3ET7Xtttndmlws16wj1a', 2),
('User', 3, 'https://pbs.twimg.com/profile_images/1117850000199966721/QbY6x8NK.png', 'dam', NULL, '$2a$10$BF3WZ0iGIZUTIAfn0klvE.zK8g/0dnksA3ET7Xtttndmlws16wj1a', 2),
('Product', 5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbSnkPyUD-uJnwlGRyIOAC9U4S-O9XX4AAtzqhIMg5Oifsn7O5My9tJ87stJDIXKSGJPisvKo&usqp=CAc', 'Nutella', 'Alimentation', NULL, NULL),
('Product', 6, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSciBw4A2GNb3wu4cYi4pXNvsXHnIPIZw27OmM9vSL-FrByYK85bQnp1smo52mwfZoqhC1T-GE&usqp=CAc', 'Shampoo', 'Hygiene', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(9);

-- --------------------------------------------------------

--
-- Structure de la table `need`
--

DROP TABLE IF EXISTS `need`;
CREATE TABLE IF NOT EXISTS `need` (
  `id` int(11) NOT NULL,
  `founded` bit(1) NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKepchlc3pr40voww7ny9jqy19x` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `need`
--

INSERT INTO `need` (`id`, `founded`, `quantity`, `product_id`) VALUES
(7, b'0', 6, 5),
(8, b'0', 3, 6);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Structure de la table `shopping_list`
--

DROP TABLE IF EXISTS `shopping_list`;
CREATE TABLE IF NOT EXISTS `shopping_list` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `shopping_list`
--

INSERT INTO `shopping_list` (`id`, `name`) VALUES
(2, 'illu\'s List'),
(3, 'illu\'s List2'),
(4, 'illu\'s List3');

-- --------------------------------------------------------

--
-- Structure de la table `shopping_list_members`
--

DROP TABLE IF EXISTS `shopping_list_members`;
CREATE TABLE IF NOT EXISTS `shopping_list_members` (
  `shopping_list_id` int(11) NOT NULL,
  `members_id` int(11) NOT NULL,
  KEY `FK48ajlla79vr5f3s6qaio273ep` (`members_id`),
  KEY `FKemr7uhxmsv3rsm6tqf86183t4` (`shopping_list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `shopping_list_members`
--

INSERT INTO `shopping_list_members` (`shopping_list_id`, `members_id`) VALUES
(2, 1),
(3, 1),
(4, 1),
(2, 2),
(2, 3),
(3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `shopping_list_need_list`
--

DROP TABLE IF EXISTS `shopping_list_need_list`;
CREATE TABLE IF NOT EXISTS `shopping_list_need_list` (
  `shopping_list_id` int(11) NOT NULL,
  `need_list_id` int(11) NOT NULL,
  UNIQUE KEY `UK_8huf2velgx5vipny2qyw9ut9r` (`need_list_id`),
  KEY `FKruksegmsuec0389l3mhbol2iy` (`shopping_list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `shopping_list_need_list`
--

INSERT INTO `shopping_list_need_list` (`shopping_list_id`, `need_list_id`) VALUES
(3, 7),
(3, 8);

-- --------------------------------------------------------

--
-- Structure de la table `user_shopping_lists`
--

DROP TABLE IF EXISTS `user_shopping_lists`;
CREATE TABLE IF NOT EXISTS `user_shopping_lists` (
  `user_id` int(11) NOT NULL,
  `shopping_lists` int(11) DEFAULT NULL,
  KEY `FK2vb7pntdp1qsyit6uav9lm62m` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_shopping_lists`
--

INSERT INTO `user_shopping_lists` (`user_id`, `shopping_lists`) VALUES
(1, 2),
(1, 3),
(1, 4);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `data_base_object`
--
ALTER TABLE `data_base_object`
  ADD CONSTRAINT `FK1hmr4jq3u65oes75csu7glfxj` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Contraintes pour la table `need`
--
ALTER TABLE `need`
  ADD CONSTRAINT `FKepchlc3pr40voww7ny9jqy19x` FOREIGN KEY (`product_id`) REFERENCES `data_base_object` (`id`);

--
-- Contraintes pour la table `shopping_list_members`
--
ALTER TABLE `shopping_list_members`
  ADD CONSTRAINT `FK48ajlla79vr5f3s6qaio273ep` FOREIGN KEY (`members_id`) REFERENCES `data_base_object` (`id`),
  ADD CONSTRAINT `FKemr7uhxmsv3rsm6tqf86183t4` FOREIGN KEY (`shopping_list_id`) REFERENCES `shopping_list` (`id`);

--
-- Contraintes pour la table `shopping_list_need_list`
--
ALTER TABLE `shopping_list_need_list`
  ADD CONSTRAINT `FK5yfghfkvn7yfx5jp92ljjbcc5` FOREIGN KEY (`need_list_id`) REFERENCES `need` (`id`),
  ADD CONSTRAINT `FKruksegmsuec0389l3mhbol2iy` FOREIGN KEY (`shopping_list_id`) REFERENCES `shopping_list` (`id`);

--
-- Contraintes pour la table `user_shopping_lists`
--
ALTER TABLE `user_shopping_lists`
  ADD CONSTRAINT `FK2vb7pntdp1qsyit6uav9lm62m` FOREIGN KEY (`user_id`) REFERENCES `data_base_object` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
