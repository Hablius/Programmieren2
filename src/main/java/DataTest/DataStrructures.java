package DataTest;

import java.util.*;

public class DataStrructures {
    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();
    Set<Integer> treeSet = new TreeSet<>();
    Set<Integer> hashSet = new HashSet<>();

    public void prepareTestData(int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int value = random.nextInt();
            arrayList.add(value);
            linkedList.add(value);
            treeSet.add(value);
            hashSet.add(value);
        }
    }

    public long performOperation(Collection<Integer> collection, String operationType, int testData) {
        long startTime = System.nanoTime();
        switch (operationType) {
            case "insert":
                collection.add(testData);
                break;
            case "search":
                collection.contains(testData);
                break;
            case "remove":
                collection.remove(testData);
                break;
        }
        return System.nanoTime() - startTime;
    }

    public List<Integer> getArrayList() {
        return arrayList;
    }

    public List<Integer> getLinkedList() {
        return linkedList;
    }

    public Set<Integer> getTreeSet() {
        return treeSet;
    }

    public Set<Integer> getHashSet() {
        return hashSet;
    }
}
