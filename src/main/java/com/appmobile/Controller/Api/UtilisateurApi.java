package com.appmobile.Controller.Api;

import com.appmobile.Dto.UtilisateurDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.appmobile.Util.Constants.APP_ROOT;
@RequestMapping(APP_ROOT+"/api/utilisateurs")

public interface UtilisateurApi {
    @PostMapping("/creer")
    ResponseEntity<UtilisateurDto> save(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping("/find/email/{email}")
    ResponseEntity<UtilisateurDto> findByEmail(@PathVariable String email);
}

