package main.exceptions;

public class SceneNotFoundException extends Exception {
    public SceneNotFoundException() {super();}

    public SceneNotFoundException(String message) {
        super(message);
    }
}
