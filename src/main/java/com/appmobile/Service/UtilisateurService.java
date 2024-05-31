package com.appmobile.Service;

import com.appmobile.Dto.UtilisateurDto;
public interface UtilisateurService  {
    UtilisateurDto save(UtilisateurDto u);
    UtilisateurDto findByEmail(String email);
}
