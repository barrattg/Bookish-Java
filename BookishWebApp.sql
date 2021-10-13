CREATE TABLE `technologies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `logoUrl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
 
INSERT INTO `technologies`
(id, name, logoUrl)
VALUES
(1,'Java','https://pngimage.net/wp-content/uploads/2018/06/java-logo-png-transparent-background-7.png'),
(2,'Spring','https://www.logolynx.com/images/logolynx/98/980c5fe716efb66c936eebe1937d5489.png'),
(3,'Thymeleaf','https://www.thymeleaf.org/images/thymeleaf.png'),
(4,'MySQL','https://www.mysql.com/common/logos/logo-mysql-170x115.png'),
(5,'HTML','https://www.w3.org/html/logo/downloads/HTML5_Logo_256.png'),
(6,'CSS','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/CSS3_logo_and_wordmark.svg/2000px-CSS3_logo_and_wordmark.svg.png');
