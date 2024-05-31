package com.appmobile.Dto;

import com.appmobile.Entity.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;
    private String tele;
    private String role;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur==null)return null;
        else {
            return UtilisateurDto.builder()
                    .id(utilisateur.getId())
                    .nom(utilisateur.getNom())
                    .email(utilisateur.getEmail())
                    .password(utilisateur.getPassword())
                    .tele(utilisateur.getTele())
                    .role(utilisateur.getRole())
                    .build();
        }
    }
    public static Utilisateur fromDto(UtilisateurDto utilisateurDto){
        if(utilisateurDto==null)return null;
        return Utilisateur.builder()
                .id(utilisateurDto.getId())
                .nom(utilisateurDto.getNom())
                .email(utilisateurDto.getEmail())
                .password(utilisateurDto.getPassword())
                .tele(utilisateurDto.getTele())
                .role(utilisateurDto.getRole())
                .build();
    }
}
