/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alejandroutp
 * Created: 29/01/2021
 */

CREATE TABLE IF NOT EXISTS shared_album(
    id INT NOT NULL,
    user_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    can_read BOOLEAN NOT NULL,
    can_write BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS permission_user_shared_album(
    id INT NOT NULL AUTO_INCREMENT,
    shared_album_id INT NOT NULL,
    FOREIGN KEY(shared_album_id) REFERENCES shared_album(id),
    user_id INT NOT NULL,
    can_read BOOLEAN NOT NULL,
    can_write BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);