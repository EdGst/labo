package Kinomichi.Exception;

public class MissInputException extends KinomichiException{
    public MissInputException(String message) {
        super(message);
    }

    public  void getMessage(String message) {
        System.out.println(message);
    }
}
