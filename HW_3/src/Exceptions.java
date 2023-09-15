class CountFieldException extends Exception {
    public CountFieldException(String message) {
        super("Количество полей " + message + " чем требуется!");
    }
}

class TypeDataExceptoin extends Exception {
    public TypeDataExceptoin(int index) {
        super("Поле [" + index + "] имеет недопустимый тип!");
    }
}

class FormatException extends Exception {
    public FormatException() {
        super("Неправильный формат номера телефона!");
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}