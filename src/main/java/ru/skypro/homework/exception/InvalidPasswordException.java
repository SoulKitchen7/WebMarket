package ru.skypro.homework.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}
