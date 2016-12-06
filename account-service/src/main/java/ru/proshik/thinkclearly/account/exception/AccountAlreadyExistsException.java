package ru.proshik.thinkclearly.account.exception;

/**
 * Created by proshik on 04.12.16.
 */
public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
