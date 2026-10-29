/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_sistema_de_control_de_hangares_v2.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author jfabr
 */
@Entity
@Table(name = "naves")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_nave", discriminatorType = DiscriminatorType.STRING)
public abstract class Nave implements Serializable 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nave_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(name = "estado_sistema", nullable = false, length = 20)
    private String estadoSistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planeta_origen_id")
    private Planeta planetaOrigen;

    public Nave() {}

    public Nave(String nombre, String modelo, String estadoSistema) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.estadoSistema = estadoSistema;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getNombre() {
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() { 
         return modelo; 
     }
    public void setModelo(String modelo) { 
         this.modelo = modelo; 
     }

    public String getEstadoSistema() { 
         return estadoSistema; 
     }
    public void setEstadoSistema(String estadoSistema) {
         this.estadoSistema = estadoSistema; 
    }

    public Planeta getPlanetaOrigen() { 
        return planetaOrigen;
    }
    public void setPlanetaOrigen(Planeta planetaOrigen) {
        this.planetaOrigen = planetaOrigen; 
    }







}


