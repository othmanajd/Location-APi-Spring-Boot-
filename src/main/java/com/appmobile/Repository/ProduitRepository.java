package com.appmobile.Repository;

import com.appmobile.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByCategorie(String categorie);
    List<Produit> findByNom(String nom);
    List<Produit> findByStatu(String statu);

}
