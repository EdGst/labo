package Kinomichi.Exception;

public class KinomichiException extends Exception{
    public KinomichiException() {
    }

    public KinomichiException(String message) {
        super(message);
    }

    public KinomichiException(String message, Throwable cause) {
        super(message, cause);
    }

    public KinomichiException(Throwable cause) {
        super(cause);
    }

    public KinomichiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
