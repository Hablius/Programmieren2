package List;

public class SortedList<T extends Comparable<T>> extends SinglyLinkedList<T> {
    public void add(T data) {
        try {
            super.add(getSortPosition(data), data);
        } catch (ListException e) {
            // This should not happen in a correctly implemented list
        }
    }

    @Override
    public void add(int pos, T data) throws ListException {
        throw new UnsupportedOperationException("can't add at a specific position in a sorted list");
    }

    private int getSortPosition(T data) {
        int position = 0;
        try {
            for (int i = 0; i < size(); i++) {
                if (get(i).compareTo(data) < 0) {
                    position++;
                }
            }
        } catch (ListException e) {
            // This should not happen
        }
        return position;
    }
}
