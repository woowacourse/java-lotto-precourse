package domain;

import java.util.InputMismatchException;

public abstract class UserInputException extends RuntimeException {
    abstract void printErrorMessage();
}
