## Requêtes pour la création des deux tables

DROP TABLE IF EXISTS `bhuser`;
CREATE TABLE IF NOT EXISTS `bhuser` (
  `BHUSERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `USERPASSWORD` varchar(50) DEFAULT NULL,
  `MOTTO` varchar(100) NOT NULL,
  `USEREMAIL` varchar(100) NOT NULL,
  `JOINDATE` date NOT NULL,
  PRIMARY KEY (`BHUSERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bhpost`;
CREATE TABLE IF NOT EXISTS `bhpost` (
  `POSTID` int(11) NOT NULL AUTO_INCREMENT,
  `POSTDATE` date NOT NULL,
  `POSTTEXT` varchar(141) NOT NULL,
  `BHUSERID` int(11) NOT NULL,
  PRIMARY KEY (`POSTID`),
  KEY `BHUSERID` (`BHUSERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


## Insertion d'éléments de test dans la table

INSERT INTO `bhuser` (`BHUSERID`, `USERNAME`, `USERPASSWORD`, `MOTTO`, `USEREMAIL`, `JOINDATE`) VALUES (NULL, 'user 1', 'password', 'L\'écureuil a beau être petit, il n\'est pas l\'esclave de l\'éléphant', 'user1@domain.com', '2017-02-15'), (NULL, 'user 2', 'password', 'L\'âme n\'a pas de couleur.', 'user2@domain.com', '2017-04-26'), (NULL, 'user 3', 'password', 'Le commencement de la sagesse, c\'est la crainte de l\'Eternel.', 'user3@domain.com', '2017-04-08'), (NULL, 'user 4', 'password', 'Les choses ne sont pas si douloureuses ni difficiles d\'elles-mêmes ;', 'user4@domain.com', '2017-08-31');


INSERT INTO `bhpost` (`POSTID`, `POSTDATE`, `POSTTEXT`, `BHUSERID`) VALUES
(1, '2019-01-15', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mi nibh, rhoncus vitae scelerisque nec, pellentesque sit amet lectus. ', 1),
(2, '2018-05-09', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.', 2),
(3, '2018-04-19', 'Etiam laoreet odio arcu, eget interdum nisi malesuada in. ', 1),
(4, '2017-07-12', 'Sed pretium volutpat sapien quis tempus. In et massa sollicitudin, congue leo ut, ultricies metus.', 3),
(5, '2018-08-16', 'Mauris dapibus venenatis feugiat. Morbi porta, ipsum sed accumsan fermentum, est magna pellentesque lorem', 2),
(6, '2017-10-19', 'Nunc vitae aliquam nisl. Quisque scelerisque nisi at pharetra dictum. Nulla fringilla sed magna at placerat. ', 1);


