DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS adress;

CREATE TABLE `user` (
    id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    adress_id INT UNIQUE NOT NULL ,
    PRIMARY KEY (id)
);
CREATE TABLE post (
    id INT NOT NULL AUTO_INCREMENT,
    caption VARCHAR(255) NOT NULL,
    topic VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES `user`(id)
);
CREATE TABLE vote (
    id INT NOT NULL AUTO_INCREMENT,
    `timestamp` DATE NOT NULL,
    upvote BOOLEAN NOT NULL,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (post_id) REFERENCES post(id),
    FOREIGN KEY (user_id) REFERENCES `user`(id)
);
CREATE TABLE comment (
    id INT NOT NULL AUTO_INCREMENT,
    text VARCHAR(255) NOT NULL,
    upvotes INT NOT NULL DEFAULT 0,
    downvotes INT NOT NULL DEFAULT 0,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES `user`(id),
    FOREIGN KEY (post_id) REFERENCES post(id)
);
CREATE TABLE adress (
    id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    zip INT NOT NULL,
    country VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Inserts
INSERT INTO adress (street, city, zip, country) VALUES ('Main Street', 'New York', 12345, 'USA');
INSERT INTO adress (street, city, zip, country) VALUES ('Schlierenstrasse', 'Ennetbaden', 5408, 'Switzerland');
INSERT INTO `user` (`name`, adress_id) VALUES ('John', 1);
INSERT INTO `user` (`name`, adress_id) VALUES ('Jane', 2);