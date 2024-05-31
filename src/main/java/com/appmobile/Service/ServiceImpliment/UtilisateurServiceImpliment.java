package com.appmobile.Service.ServiceImpliment;

import com.appmobile.Dto.UtilisateurDto;
import com.appmobile.Entity.Utilisateur;
import com.appmobile.Exception.ErrorCodes;
import com.appmobile.Exception.InvalidEntityException;
import com.appmobile.Repository.UtilisateurRepository;
import com.appmobile.Service.UtilisateurService;
import com.appmobile.Validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UtilisateurServiceImpliment implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurServiceImpliment(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.Utilisateur_NOT_VALID, errors);
        }

        if (userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le même email existe déjà",
                    ErrorCodes.Utilisateur_ALREADY_IN_USE,
                    Collections.singletonList("Un autre utilisateur avec le même email existe déjà dans la BDD"));
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        Utilisateur utilisateur = utilisateurRepository.save(UtilisateurDto.fromDto(dto));
        return UtilisateurDto.fromEntity(utilisateur);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);

        Utilisateur foundUtilisateur = utilisateur.orElseThrow(() -> {
            log.error("Utilisateur with email {} not found", email);
            return new InvalidEntityException("Utilisateur avec l'email " + email + " n'a pas été trouvé", ErrorCodes.Utilisateur_NOT_FOUND);
        });

        return UtilisateurDto.fromEntity(foundUtilisateur);
    }

    private boolean userAlreadyExists(String email) {
        return utilisateurRepository.findByEmail(email) != null;
    }
}
