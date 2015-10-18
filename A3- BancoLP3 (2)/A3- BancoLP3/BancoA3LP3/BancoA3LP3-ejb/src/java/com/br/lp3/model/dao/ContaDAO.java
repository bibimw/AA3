/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.entities.Conta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author dahda
 */
public class ContaDAO implements GenericDAO<Conta>{

    public ContaDAO() {
    }   

   
    @Override
    public boolean insert(Conta c){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        System.out.println(c.getNomeConta() + "inserido.");
        return Boolean.TRUE;
    }

    @Override
    public List<Conta> read(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT c FROM Conta c");
        List<Conta> lista = query.getResultList(); 
        em.getTransaction().commit();
        em.close();
        return lista;
    }

    @Override
    public boolean update(Conta c){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(c);
       
        em.getTransaction().commit();
        em.close();
        System.out.println(c.getNomeConta() + "alterado.");
        return Boolean.TRUE;
    }

    @Override
    public boolean remove(Conta c){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoA3LP3");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();          
        Conta c1 = em.find(Conta.class, c.getIdConta());
        em.remove(c1);        
        em.getTransaction().commit();
        em.close(); 
        System.out.println(c.getNomeConta() + "removido.");
        return Boolean.TRUE;
    }
    

 
}
