/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen_sistema_de_control_de_hangares_v2;

import com.mycompany.examen_sistema_de_control_de_hangares_v2.Controller.HoloNetControl;
import com.mycompany.examen_sistema_de_control_de_hangares_v2.modelos.CazaLigero;
import com.mycompany.examen_sistema_de_control_de_hangares_v2.modelos.Nave;
import java.util.List;

/**
 *
 * @author jfabr
 */
public class Examen_Sistema_de_Control_de_Hangares_v2 {

    public static void main(String[] args) {
        HoloNetControl con = new HoloNetControl();
        
        System.out.println("=== Cazas Operativos por Bando (Imperio) ===");
        List<CazaLigero> cazas = con.obtenerCazasOperativosPorBando("Imperio");
        
        for (CazaLigero c : cazas) 
        {
            
            System.out.println("-> Caza: "+c.getNombre()+"| Modelo: "+c.getNombre()+"| Potencia de Fuego "+ c.getPotenciaFuego());
        
        }
        
        System.out.println("===Flota en Estado Crítico (FETCH JOIN) ===");
        
        List<Nave> flotaCritica=con.obtenerFlotaCriticaPolimorfica();
        
        
        for (Nave nave : flotaCritica) 
        {
           
        System.out.println("-> Nave Crítica: " + nave.getNombre() + " | Estado: " + nave.getEstadoSistema() + " | Planeta Origen: " + nave.getPlanetaOrigen());
        
        }
        
        System.out.println("-> Reporte General Filtrado (LEFT JOIN + TYPE) ===");
        List<Object[]> reporte = con.obtenerReporteGeneralFiltrado();
        for (Object[] fila : reporte) {
            String nombreNave = (String) fila[0];
            Object tipoNave = fila[1];
            String nombrePlaneta = (String) fila[2];
            System.out.println("-> Nave: " + nombreNave + " | Tipo (Clase): " + tipoNave + " | Planeta: " + nombrePlaneta);
        }
        
    }
}
