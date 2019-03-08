package xo.model.exceptions;

public class AlreadyOccupiedException extends AbstractXOException {
    public AlreadyOccupiedException() {
        super("Not a valid cell! The cell is busy.");
    }
}