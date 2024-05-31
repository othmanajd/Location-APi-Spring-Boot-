package com.appmobile.Service.ServiceImpliment;

import com.appmobile.Dto.ProduitDto;
import com.appmobile.Entity.Produit;
import com.appmobile.Repository.ProduitRepository;
import com.appmobile.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpliment implements ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpliment(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        Produit produit = ProduitDto.fromDto(produitDto);
        Produit savedProduit = produitRepository.save(produit);
        return ProduitDto.fromEntity(savedProduit);
    }

    @Override
    public List<ProduitDto> findByNom(String nom) {
        List<Produit> produits = produitRepository.findByNom(nom);
        return produits.stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public List<ProduitDto> findByStatus(String statu) {
        List<Produit> produits = produitRepository.findByStatu(statu);
        return produits.stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProduitDto> findByCategorie(String categorie) {
        List<Produit> produits = produitRepository.findByCategorie(categorie);
        return produits.stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduitDto> findAll() {
        List<Produit> produits = produitRepository.findAll();
        return produits.stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());
    }
}
