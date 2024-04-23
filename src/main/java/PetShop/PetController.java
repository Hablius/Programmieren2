package PetShop;

import javafx.event.ActionEvent;

public class PetController {
    private PetView view;
    private PetModel model;

    public PetController(PetModel model, PetView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    public void addPet(ActionEvent event) {
        Pet.Species species = view.getSpecies();
        Pet.Gender gender = view.getGender();
        String name = view.getName();
        if (species != null && gender != null && !name.isBlank()) {
            Pet pet = new Pet(species, gender, name);
            model.addPet(pet);
            view.updateView();
        }
    }

    public void deletePet(ActionEvent event) {
        model.deleteCurrentPet();
        view.updateView();
    }

    public void nextPet(ActionEvent event) {
        model.nextPet();
        view.updateView();
    }

    public void previousPet(ActionEvent event) {
        model.previousPet();
        view.updateView();
    }
}