/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31400051
 */
public class UsuarioDAO implements GenericDAO<Usuario>{

    @Override
    public boolean insert(Usuario u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        System.out.println(u.getLogin() + "inserido.");
        return Boolean.TRUE;
    }

    @Override
    public List<Usuario> read() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> lista = query.getResultList(); 
        em.getTransaction().commit();
        em.close();
        return lista;
    }

    @Override
    public boolean update(Usuario u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(u);       
        em.getTransaction().commit();
        em.close();
        System.out.println(u.getLogin() + "alterado.");
        return Boolean.TRUE;
       
    }

    @Override
    public boolean remove(Usuario u) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();          
        Usuario usu = em.find(Usuario.class, u.getIdUsu());
        em.remove(usu);        
        em.getTransaction().commit();
        em.close(); 
        System.out.println(u.getLogin() + "removido.");
        return Boolean.TRUE;
    }
    
}
