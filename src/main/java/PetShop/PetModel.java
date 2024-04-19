package PetShop;

public class PetModel {

        private Pet currentPet;

        public void savePet(Pet.Species species, Pet.Gender gender, String name) {
            currentPet = new Pet(species, gender, name);
        }

        public void deletePet() {
            currentPet = null;
        }

        public Pet getPet() {
            return currentPet;
        }
        // erstelle eine Methode um alle Pet Objekte die eingegeben worden sind anzuzeigen

    
}
