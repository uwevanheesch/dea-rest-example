package nl.han.oose;

public class ItemResourceError {
    private String code;
    private String message;

    public ItemResourceError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ItemResourceError() {
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
