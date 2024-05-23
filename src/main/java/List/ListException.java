package List;

public class ListException extends Exception {
    public enum ListErrorCode { PositionTooSmall, PositionTooLarge; }

    public ListException(ListErrorCode error) {
        super(error.toString());
    }
}
