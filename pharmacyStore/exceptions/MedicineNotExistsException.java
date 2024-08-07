package pharmacyStore.exceptions;

public class MedicineNotExistsException extends Exception{
    public MedicineNotExistsException() {
    }

    public MedicineNotExistsException(String message) {
        super(message);
    }

    public MedicineNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicineNotExistsException(Throwable cause) {
        super(cause);
    }

    public MedicineNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
