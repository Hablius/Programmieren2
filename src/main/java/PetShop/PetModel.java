package PetShop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PetModel {
    private ObservableList<Pet> pets = FXCollections.observableArrayList();
    private int currentIndex = -1;

    public void addPet(Pet pet) {
        pets.add(pet);
        if (currentIndex == -1) {
            currentIndex = 0;
        }
    }

    public void deleteCurrentPet() {
        if (!pets.isEmpty() && currentIndex != -1) {
            pets.remove(currentIndex);
            if (pets.isEmpty()) {
                currentIndex = -1;
            } else if (currentIndex >= pets.size()) {
                currentIndex = pets.size() - 1;
            }
        }
    }

    public Pet getCurrentPet() {
        if (!pets.isEmpty() && currentIndex != -1) {
            return pets.get(currentIndex);
        }
        return null;
    }

    public void nextPet() {
        if (currentIndex < pets.size() - 1) {
            currentIndex++;
        }
    }

    public void previousPet() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public ObservableList<Pet> getAllPets() {
        return pets;
    }
}