package com.appmobile.Validator;

import com.appmobile.Dto.UtilisateurDto;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if (utilisateurDto == null) {
            errors.add("l'objet est nul");
        }
        if (utilisateurDto.getNom() == null || utilisateurDto.getNom().isEmpty()){
            errors.add("Le nom est manquant");
        }
        if (utilisateurDto.getEmail() == null || !utilisateurDto.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.add("L'email n'est pas valide");
        }
        if (utilisateurDto.getPassword() == null || utilisateurDto.getPassword().length() < 8 || !utilisateurDto.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            errors.add("Le mot de passe ne respecte pas les critères");
        }
        return errors;
    }
}
