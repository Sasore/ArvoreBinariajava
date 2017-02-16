/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvorebinaria;

/**
 *
 * @author soare
 */
public class No {

    No esquerda;
    No direita;
    int valor;
    String nome;
    int ano;
    String descricao;

    public No(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;

    }

    public No(int valor) {
        this.valor = valor;

    }

    public No(No no) {
        this.valor = no.valor;
        this.nome = no.getNome();
        this.ano = no.getAno();
        this.descricao = no.getDescricao();

    }

    public No() {
        esquerda = null;
        direita = null;
        nome = "";
        valor = 0;
        descricao = "";
        ano = 0;

    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
