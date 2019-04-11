package domain;

public abstract class UserInputException extends RuntimeException {
    abstract void printErrorMessage();
}
