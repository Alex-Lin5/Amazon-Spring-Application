CREATE DATABASE IF NOT EXISTS onlineshopping;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9emlp6m95v5er2bcqkjsw48he` (`user_id`),
  CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cart_products`
--

DROP TABLE IF EXISTS `cart_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_products` (
  `cart_id` int NOT NULL,
  `products_id` int NOT NULL,
  UNIQUE KEY `UK3kg5kx19f8oy0lo76hdhc1uw1` (`products_id`),
  KEY `FKnlhjc091rdu9k5c8u9xwp280w` (`cart_id`),
  CONSTRAINT `FKhyhnx21758m3wmbi4ps96m0yw` FOREIGN KEY (`products_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKnlhjc091rdu9k5c8u9xwp280w` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `on_sale` datetime(6) DEFAULT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `image_link` varchar(255) DEFAULT NULL,
  `preference` varchar(255) DEFAULT NULL,
  `profile_name` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKc1dkiawnlj6uoe6fnlwd6j83j` (`user_id`),
  CONSTRAINT `FKawh070wpue34wqvytjqr4hj5e` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_admin` bit(1) NOT NULL,
  `otp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  `profile_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK47dq8urpj337d3o65l3fsjph3` (`cart_id`),
  UNIQUE KEY `UK1mcjtpxmwom9h9bf2q0k412e0` (`profile_id`),
  CONSTRAINT `FKof44u64o1d7scaukghm9veo23` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`),
  CONSTRAINT `FKtqa69bib34k2c0jhe7afqsao6` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



/*------------------------------------------------------------------*/

INSERT INTO User (id, email, password, is_admin, profile_id, cart_id) VALUES (1, 'inituser1@example.com', 'initUser1', false, 1, 1);
INSERT INTO User (id, email, password, is_admin, profile_id, cart_id) VALUES (2, 'inituser2@example.com', 'initUser2', false, 2, 2);

INSERT INTO Profile (id, profile_name, image_link, description, preference, user_id) VALUES (1, 'main', 'none', 'it is description', 'no preference', 1);
INSERT INTO Profile (id, profile_name, image_link, description, preference, user_id) VALUES (2, 'main', 'none', 'it is description', 'no preference', 2);

INSERT INTO Product (id, image, description, name, price, on_sale) VALUES (1, 'none', 'product description', 'product1', 3.6, NOW());
INSERT INTO Product (id, image, description, name, price, on_sale) VALUES (2, 'none', 'product description', 'product2', 54.0, NOW()+1000);
INSERT INTO Product (id, image, description, name, price, on_sale) VALUES (3, 'none', 'product description', 'product3', 15.8, NOW()+2000);

INSERT INTO Cart (id, payment, user_id) VALUES (1, 'none', 1);
INSERT INTO Cart (id, payment, user_id) VALUES (2, 'none', 2);

INSERT INTO cart_products(cart_id, products_id) VALUES (1, 1);
INSERT INTO cart_products(cart_id, products_id) VALUES (1, 2);

