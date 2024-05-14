package DataTest;

import javafx.scene.control.TableView;

import java.util.Random;

public class TestController {
    private DataStrructures model;
    private TestView view;

    public TestController(DataStrructures model, TestView view) {
        this.model = model;
        this.view = view;
    }

    public void runTests() {
        model.prepareTestData(10000);  // Vorbereitung der Testdaten
        testAndDisplayResults();
    }

    private void testAndDisplayResults() {
        Random random = new Random();
        int testData = random.nextInt();

        // Testen und Ergebnisse für jede Datenstruktur erfassen
        long arrayListTime = model.performOperation(model.getArrayList(), "insert", testData);
        long linkedListTime = model.performOperation(model.getLinkedList(), "insert", testData);
        long treeSetTime = model.performOperation(model.getTreeSet(), "insert", testData);
        long hashSetTime = model.performOperation(model.getHashSet(), "insert", testData);

        view.displayResults("ArrayList", arrayListTime);
        view.displayResults("LinkedList", linkedListTime);
        view.displayResults("TreeSet", treeSetTime);
        view.displayResults("HashSet", hashSetTime);
    }
}
