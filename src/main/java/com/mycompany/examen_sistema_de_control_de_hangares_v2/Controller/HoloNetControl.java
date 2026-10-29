/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_sistema_de_control_de_hangares_v2.Controller;

import com.mycompany.examen_sistema_de_control_de_hangares_v2.modelos.CazaLigero;
import com.mycompany.examen_sistema_de_control_de_hangares_v2.modelos.Nave;
import com.mycompany.examen_sistema_de_control_de_hangares_v2.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jfabr
 */
public class HoloNetControl 
{
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public List<CazaLigero> obtenerCazasOperativosPorBando(String bando)
    {
    try (Session session = sessionFactory.openSession()) {
           
            String hql = "SELECT c FROM CazaLigero c JOIN c.planetaOrigen p " +
                         "WHERE p.afiliacion = :bando AND c.estadoSistema != 'Mantenimiento'";
            return session.createQuery(hql, CazaLigero.class)
                          .setParameter("bando", bando)
                          .getResultList();
        }
    }
    
    
    
    public List<Nave> obtenerFlotaCriticaPolimorfica() {
        try (Session session = sessionFactory.openSession()) {
           
            String hql = "SELECT n FROM Nave n JOIN FETCH n.planetaOrigen " +
                         "WHERE n.estadoSistema = 'Critico'";
            return session.createQuery(hql, Nave.class).getResultList();
        }
    }

    
    public List<Object[]> obtenerReporteGeneralFiltrado() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT n.nombre, TYPE(n), p.nombre FROM Nave n LEFT JOIN n.planetaOrigen p";
            return session.createQuery(hql, Object[].class).getResultList();
        }
    }
    
    
    
}
