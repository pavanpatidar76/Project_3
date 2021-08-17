package in.co.rays.exception;



/**
 * RecordNotFoundException thrown when a record not found occurred
 *
 * @author PAWAN PATIDAR
 *
 */
public class RecordNotFoundException extends Exception{

    /**
     * @param msg
     *            error message
     */
    public RecordNotFoundException(String msg) {
        super(msg);

    }
}