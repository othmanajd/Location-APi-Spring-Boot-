package com.appmobile.Controller;

import com.appmobile.Controller.Api.ProduitApi;
import com.appmobile.Dto.ProduitDto;
import com.appmobile.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController implements ProduitApi {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Override
    public ResponseEntity<ProduitDto> save(@RequestBody ProduitDto produitDto) {
        ProduitDto savedProduit = produitService.save(produitDto);
        return ResponseEntity.ok(savedProduit);
    }

    @Override
    public ResponseEntity<List<ProduitDto>> getProduitsByNom(@PathVariable String nom) {
        List<ProduitDto> produits = produitService.findByNom(nom);
        return ResponseEntity.ok(produits);
    }

    @Override
    public ResponseEntity<List<ProduitDto>> getProduitsByCategorie(@PathVariable String categorie) {
        List<ProduitDto> produits = produitService.findByCategorie(categorie);
        return ResponseEntity.ok(produits);
    }

    @Override
    public ResponseEntity<List<ProduitDto>> getAllProduits() {
        List<ProduitDto> produits = produitService.findAll();
        return ResponseEntity.ok(produits);
    }
    @Override
    public ResponseEntity<List<ProduitDto>> getProduitsByStatus(@PathVariable String statu) {
        List<ProduitDto> produits = produitService.findByStatus(statu);
        return ResponseEntity.ok(produits);
    }
}
