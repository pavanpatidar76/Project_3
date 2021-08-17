package in.co.rays.exception;


/**
 * DuplicateRecordException thrown when a duplicate record occurred
 *
 * @author PAWAN PATIDAR
 *
 */
public class DuplicateRecordException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}


