package ru.proshik.thinkclearly.account.exception;

/**
 * Created by proshik on 04.12.16.
 */
public class PasswordNotEqualstConfirmPasswordException extends RuntimeException {

    public PasswordNotEqualstConfirmPasswordException(String message) {
        super(message);
    }

}
