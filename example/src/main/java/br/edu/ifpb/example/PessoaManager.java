/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.example;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author miolivc
 */
public class PessoaManager {
    private final EntityManager manager;
    private final EntityTransaction transaction;

    public PessoaManager() {
        this.manager = Persistence.createEntityManagerFactory("jpa-example").createEntityManager();
        this.transaction = manager.getTransaction();
    }
    
    public void addPessoa(Pessoa pessoa) {
        transaction.begin();
        manager.persist(pessoa);
        transaction.commit();
    }
    
    public void remove(Pessoa pessoa) {
        transaction.begin();
        manager.remove(pessoa);
        transaction.commit();
    }
    
    public void edit(Pessoa pessoa) {
        transaction.begin();
        manager.merge(pessoa);
        transaction.commit();
    }
    
    public Pessoa get(int id) {
        Pessoa pessoa = null;
        transaction.begin();
        pessoa = manager.find(Pessoa.class, id);
        transaction.commit();
        return pessoa;
    }
    
    public List<Pessoa> list() {
        List<Pessoa> pessoas = null;
        transaction.begin();
        pessoas = manager.createQuery("SELECT * FROM PESSOA").getResultList();
        transaction.commit();
        return pessoas;
    }
}
