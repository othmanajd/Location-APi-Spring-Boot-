package com.appmobile.Controller;

import com.appmobile.Controller.Api.UtilisateurApi;
import com.appmobile.Dto.UtilisateurDto;
import com.appmobile.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public ResponseEntity<UtilisateurDto> save(UtilisateurDto utilisateurDto) {
        UtilisateurDto savedUser = utilisateurService.save(utilisateurDto);
        return ResponseEntity.ok(savedUser);
    }

    @Override
    public ResponseEntity<UtilisateurDto> findByEmail(String email) {
        UtilisateurDto utilisateurDto = utilisateurService.findByEmail(email);
        return ResponseEntity.ok(utilisateurDto);
    }
}
