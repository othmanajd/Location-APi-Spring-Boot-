package com.appmobile.Dto;

import com.appmobile.Entity.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    private Long id;
    private String nom;
    private String categorie;
    private String dureeLocation;
    private Long idLocateur;
    private String statu;
    private Long idClient;
    private Instant dateCreation;
    private Instant dateModification;
    private String urlImage;
    public static ProduitDto fromEntity(Produit produit){
        if(produit==null)return null;
        else {
            return ProduitDto.builder()
                    .id(produit.getId())
                    .nom(produit.getNom())
                    .categorie(produit.getCategorie())
                    .dureeLocation(produit.getDureeLocation())
                    .idLocateur(produit.getIdLocateur())
                    .statu(produit.getStatu())
                    .idClient(produit.getIdClient())
                    .dateCreation(produit.getDateCreation())
                    .dateModification(produit.getDateModification())
                    .urlImage(produit.getUrlImage())
                    .build();
        }
    }
    public static Produit fromDto(ProduitDto produitDto){
        if(produitDto==null)return null;
        return Produit.builder()
                .id(produitDto.getId())
                .nom(produitDto.getNom())
                .categorie(produitDto.getCategorie())
                .dureeLocation(produitDto.getDureeLocation())
                .idLocateur(produitDto.getIdLocateur())
                .statu(produitDto.getStatu())
                .idClient(produitDto.getIdClient())
                .dateCreation(produitDto.getDateCreation())
                .dateModification(produitDto.getDateModification())
                .urlImage(produitDto.getUrlImage())
                .build();
    }
}
