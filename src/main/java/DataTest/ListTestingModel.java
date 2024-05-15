package DataTest;

import java.util.*;

public class ListTestingModel {
    public enum LIST_TYPES { ArrayList, LinkedList, TreeSet, HashSet }
    public enum WHERE_CHOICES { Start, Middle, End, Search }

    /**
     * Führt den definierten Test aus und gibt die gesamte verstrichene Zeit in Sekunden zurück
     * @param amountOfData Die Anzahl der Elemente, die zur Liste hinzugefügt werden sollen
     * @param listType Der Typ der Liste, die verwendet werden soll
     * @param whereChoice Wo die Elemente in der Liste eingefügt werden sollen
     * @return die verstrichene Zeit in Sekunden als float
     */
    public float runTest(Integer amountOfData, LIST_TYPES listType, WHERE_CHOICES whereChoice) {
        // Erstelle die Datenobjekte in einem Array
        SampleData[] data = createData(amountOfData);
        Collection<SampleData> collection = createCollection(listType);

        // Führe den Test aus
        long startTime = System.currentTimeMillis();
        if (whereChoice == WHERE_CHOICES.Search) {
            for (SampleData datum : data) {
                collection.contains(datum);
            }
        } else {
            addDataToCollection(data, collection, whereChoice);
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0f;
    }

    private SampleData[] createData(Integer amountOfData) {
        SampleData[] data = new SampleData[amountOfData];
        for (int i = 0; i < amountOfData; i++) {
            data[i] = new SampleData();
        }
        return data;
    }

    private Collection<SampleData> createCollection(LIST_TYPES listType) {
        switch (listType) {
            case ArrayList: return new ArrayList<>();
            case LinkedList: return new LinkedList<>();
            case TreeSet: return new TreeSet<>();
            case HashSet: return new HashSet<>();
            default: return new ArrayList<>();
        }
    }

    private void addDataToCollection(SampleData[] data, Collection<SampleData> collection, WHERE_CHOICES whereChoice) {
        if (whereChoice == WHERE_CHOICES.Start && collection instanceof List) {
            List<SampleData> list = (List<SampleData>) collection;
            for (SampleData datum : data) {
                list.add(0, datum);
            }
        } else if (whereChoice == WHERE_CHOICES.Middle && collection instanceof List) {
            List<SampleData> list = (List<SampleData>) collection;
            for (SampleData datum : data) {
                list.add(list.size() / 2, datum);
            }
        } else if (whereChoice == WHERE_CHOICES.End) {
            collection.addAll(Arrays.asList(data));
        }
    }
}
