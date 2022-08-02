package uk.jlennie.mapreduce;

public class IDException extends Exception {
    public IDException(String error) {
        super(error);
    }

    public IDException(int badId) {
        super("The ID " + badId + " has caused an exception");
    }

    public IDException() {
        super("Some ID has caused an exception");
    }
}
