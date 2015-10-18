/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31400051
 */
@Entity
@Table(name = "CONTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findByIdConta", query = "SELECT c FROM Conta c WHERE c.idConta = :idConta"),
    @NamedQuery(name = "Conta.findByNomeConta", query = "SELECT c FROM Conta c WHERE c.nomeConta = :nomeConta"),
    @NamedQuery(name = "Conta.findBySaldo", query = "SELECT c FROM Conta c WHERE c.saldo = :saldo")})
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTA")
    private Integer idConta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOME_CONTA")
    private String nomeConta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO")
    private double saldo;

    public Conta() {
    }

    public Conta(Integer idConta) {
        this.idConta = idConta;
    }

    public Conta(Integer idConta, String nomeConta, double saldo) {
        this.idConta = idConta;
        this.nomeConta = nomeConta;
        this.saldo = saldo;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Conta[ idConta=" + idConta + " ]";
    }
    
}
