DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
    id INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
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

-- Inserts
INSERT INTO `user` (`name`) VALUES ('John');
INSERT INTO `user` (`name`) VALUES ('Jane');