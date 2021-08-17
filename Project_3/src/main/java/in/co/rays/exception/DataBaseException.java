package in.co.rays.exception;



/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 *
 * @author PAWAN PATIDAR
 *
 */
public class DataBaseException extends Exception {

    /**
     * @param msg
     *            : Error message
     */
    public DataBaseException(String msg) {
        super(msg);
    }
}

