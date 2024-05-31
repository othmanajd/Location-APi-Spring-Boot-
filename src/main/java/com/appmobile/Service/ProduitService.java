package com.appmobile.Service;

import com.appmobile.Dto.ProduitDto;

import java.util.List;

public interface ProduitService {
    ProduitDto save(ProduitDto produitDto);
    List<ProduitDto> findByNom(String nom);
    List<ProduitDto> findByCategorie(String categorie);
    List<ProduitDto> findAll();
    List<ProduitDto> findByStatus(String statu);
}
