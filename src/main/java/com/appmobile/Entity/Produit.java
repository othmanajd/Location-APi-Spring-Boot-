package com.appmobile.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nom", nullable = false, updatable = false)
    private String nom;

    @Column(name ="categorie", nullable = false, updatable = false)
    private String categorie;

    @Column(name ="dureeLocation", nullable = false, updatable = false)
    private String dureeLocation;

    @Column(name ="idLocateur", nullable = false, updatable = false)
    private Long idLocateur;

    @Column(name ="statu", nullable = false, updatable = false)
    private String statu;

    @Column(name ="urlImage", nullable = false, updatable = false)
    private String urlImage;

    @Column(name ="idClient" )
    private Long idClient;

    @CreatedDate
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Instant dateCreation;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant dateModification;

}
