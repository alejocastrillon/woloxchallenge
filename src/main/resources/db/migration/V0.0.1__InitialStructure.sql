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
    id INT NOT NULL AUTO_INCREMENT,
    album_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS shared_album_permission(
    shared_album_id INT NOT NULL,
    permission VARCHAR(10) NOT NULL);