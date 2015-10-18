package com.br.lp3.jms.model;

import java.io.Serializable;

/**
 *
 * @author Bianca
 */
public class Conta implements Serializable{
    private String user;
    private int num;
    private double saldo;

    public Conta() {
    }

    public Conta(String user, int num, double saldo) {
        this.user = user;
        this.num = num;
        this.saldo = saldo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "user=" + user + ", num=" + num + ", saldo=" + saldo + '}';
    }
    
    
}
