package PetShop;

public class Pet {
    public enum Species {CAT, DOG, HORSE};
    public enum Gender {MALE, FEMALE};

    private static int highestID = 0;
    private final int ID;
    private Species species;
    private Gender gender;
    private String name;

    public Pet(Species species, Gender gender, String name) {
        this.ID = getNextID();
        this.species = species;
        this.gender = gender;
        this.name = name;
    }

    private static int getNextID() {
        return highestID++;
    }

    public int getID() {
        return ID;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}