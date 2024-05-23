package List;

public class ListController {
    private SinglyLinkedList<String> list;
    private ListView view;

    public ListController(SinglyLinkedList<String> list, ListView view) {
        this.list = list;
        this.view = view;
    }

    public void addElement(String data) {
        try {
            list.add(list.size(), data);
            view.displayMessage("Element added: " + data);
        } catch (ListException e) {
            view.displayMessage("Error adding element: " + e.getMessage());
        }
    }

    public void removeElement(int position) {
        try {
            String removedData = list.remove(position);
            view.displayMessage("Element removed: " + removedData);
        } catch (ListException e) {
            view.displayMessage("Error removing element: " + e.getMessage());
        }
    }

    public void displayList() {
        view.displayList(list);
    }

    public void checkContains(String data) {
        boolean contains = list.contains(data);
        view.displayMessage("List contains \"" + data + "\": " + contains);
    }
}
