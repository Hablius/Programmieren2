package PetManagement;

public class Pet {
    public enum Species { DOG, CAT, BIRD, REPTILE, FISH }
    public enum Gender { MALE, FEMALE }

    private Species species;
    private Gender gender;
    private String name;

    public Pet(Species species, Gender gender, String name) {
        this.species = species;
        this.gender = gender;
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return species + ";" + gender + ";" + name;
    }
}
