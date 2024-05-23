package List;

public class SinglyLinkedList<T> {
    private ListElement<T> head = null;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int position, T data) throws ListException {
        if (position < 0 || position > size) {
            throw new ListException(position < 0 ? ListException.ListErrorCode.PositionTooSmall : ListException.ListErrorCode.PositionTooLarge);
        }
        ListElement<T> newNode = new ListElement<>(data);
        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            ListElement<T> current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    public T get(int position) throws ListException {
        if (position < 0 || position >= size) {
            throw new ListException(position < 0 ? ListException.ListErrorCode.PositionTooSmall : ListException.ListErrorCode.PositionTooLarge);
        }
        ListElement<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T remove(int position) throws ListException {
        if (position < 0 || position >= size) {
            throw new ListException(position < 0 ? ListException.ListErrorCode.PositionTooSmall : ListException.ListErrorCode.PositionTooLarge);
        }
        ListElement<T> current = head;
        if (position == 0) {
            head = head.getNext();
        } else {
            ListElement<T> prev = null;
            for (int i = 0; i < position; i++) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(current.getNext());
        }
        size--;
        return current.getData();
    }

    public int size() {
        return size;
    }

    public boolean contains(T data) {
        ListElement<T> current = head;
        while (current != null) {
            if ((data == null && current.getData() == null) || (data != null && data.equals(current.getData()))) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}
