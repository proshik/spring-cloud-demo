package ru.proshik.thinkclearly.account.exception;

/**
 * Created by proshik on 04.12.16.
 */
public class PasswordNotEqualsConfirmPasswordException extends RuntimeException {

    public PasswordNotEqualsConfirmPasswordException(String message) {
        super(message);
    }

}
