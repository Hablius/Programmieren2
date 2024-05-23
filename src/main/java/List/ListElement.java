package List;

public class ListElement<T> {
    private final T data;
    private ListElement<T> next = null;

    protected ListElement(T data) {
        this.data = data;
    }

    protected T getData() {
        return data;
    }

    protected ListElement<T> getNext() {
        return next;
    }

    protected void setNext(ListElement<T> next) {
        this.next = next;
    }
}
