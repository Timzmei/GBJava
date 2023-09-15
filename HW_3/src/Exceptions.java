class CountFieldException extends Exception {
    public CountFieldException(String message) {
        super("The number of fields is " + message + " than required!");
    }
}

class TypeDataExceptoin extends Exception {
    public TypeDataExceptoin(int index) {
        super("The field [" + index + "] has an invalid type!");
    }
}

class FormatException extends Exception {
    public FormatException() {
        super("Incorrect phone format!");
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}