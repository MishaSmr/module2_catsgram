package ru.yandex.practicum.catsgram.exceptions;

public class InvalidEmailException extends Exception{

    public InvalidEmailException(String message) {
        super(message);
    }
}
