/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author miolivc
 */

@Entity
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private int name;
    @OneToMany
    private final List<String> contatos;

    public Pessoa() {
        this.contatos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void addContatos(String telefone) {
        contatos.add(telefone);
    }

    public void removeContato(String telefone) {
        contatos.remove(telefone);
    }
    
    public List<String> get() {
        return Collections.unmodifiableList(contatos);
    }
}    
    
