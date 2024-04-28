package PetManagement;

import java.io.*;
import java.util.ArrayList;

public class PetModel {
    public enum Species { DOG, CAT, BIRD, REPTILE, FISH }
    public enum Gender { MALE, FEMALE }

    private ArrayList<Pet> pets;
    private static final String PETS_FILE = "pets.txt";
    private static final String SEPARATOR = ";";

    public PetModel() {
        pets = new ArrayList<>();
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void loadPets() throws IOException {
        File file = new File(PETS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    pets.add(readPet(line));
                }
            }
        }
    }

    private Pet readPet(String line) {
        String[] attributes = line.split(SEPARATOR);
        Pet.Species species = Pet.Species.valueOf(attributes[0].toUpperCase());
        Pet.Gender gender = Pet.Gender.valueOf(attributes[1].toUpperCase());
        String name = attributes[2];
        return new Pet(species, gender, name);
    }

    public void savePets() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PETS_FILE))) {
            for (Pet pet : pets) {
                writer.write(pet.toString() + "\n");
            }
        }
    }
}
