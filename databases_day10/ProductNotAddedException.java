package databases_day10;

public class ProductNotAddedException extends Exception{
    public ProductNotAddedException() {
    }

    public ProductNotAddedException(String message) {
        super(message);
    }

    public ProductNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotAddedException(Throwable cause) {
        super(cause);
    }

    public ProductNotAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

