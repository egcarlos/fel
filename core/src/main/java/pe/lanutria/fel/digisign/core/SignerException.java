/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.lanutria.fel.digisign.core;

/**
 *
 * @author carlosecheverria
 */
public class SignerException extends RuntimeException {

    public SignerException() {
    }

    public SignerException(String message) {
        super(message);
    }

    public SignerException(String message, Throwable cause) {
        super(message
                + " " + cause.getMessage(), cause);
    }

    public SignerException(Throwable cause) {
        this("Error raised while executing signature process.", cause);
    }

    public SignerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
