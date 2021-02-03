/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Exception response class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {

    /**
     * Exception date.
     */
    private Date timeStamp;
    /**
     * Exception message.
     */
    private String message;
    /**
     * Exception details.
     */
    private String details;

}
