/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_sistema_de_control_de_hangares_v2.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;
/**
 *
 * @author jfabr
 */
@Entity
@Table(name="planetas")
public class Planeta implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planeta_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(length = 50)
    private String clima;

    @Column(length = 50)
    private String afiliacion = "Neutral";

    @OneToMany(mappedBy = "planetaOrigen", cascade = CascadeType.ALL)
    private List<Nave> naves;

    public Planeta() {}

    public Planeta(String nombre, String clima, String afiliacion) {
        this.nombre = nombre;
        this.clima = clima;
        this.afiliacion = afiliacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClima() { return clima; }
    public void setClima(String clima) { this.clima = clima; }

    public String getAfiliacion() { return afiliacion; }
    public void setAfiliacion(String afiliacion) { this.afiliacion = afiliacion; }

    public List<Nave> getNaves() { return naves; }
    public void setNaves(List<Nave> naves) { this.naves = naves; }



}
