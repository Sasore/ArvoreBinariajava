/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvorebinaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author soare
 */
public class Arvore {

    public No inserir(No node, No valor) {
        if (valor.getValor() < node.valor) {
            if (node.esquerda != null) {
                inserir(node.esquerda, valor);
            } else {
                System.out.println("  Inserindo " + valor.getValor() + "(" + valor.getNome() + ") a esqueda de " + node.valor);
                node.esquerda = new No(valor);
            }
        } else if (valor.getValor() > node.valor) {
            if (node.direita != null) {
                inserir(node.direita, valor);
            } else {
                System.out.println("  Inserindo " + valor.getValor() + " a direita de " + node.valor);
                node.direita = new No(valor);
            }
        }
        return node;
    }

    //Imprimir Arvore
    public void EmOrdem(No node) {
        if (node != null) {
            System.out.println("imprimindo em ordem");
            EmOrdem(node.getEsquerda());
            System.out.println("-------------");
            System.out.println("no: " + node.getValor());
            System.out.println("no: " + node.getNome());
            System.out.println("no: " + node.getAno());
            System.out.println("no: " + node.getDescricao());
            System.out.println("-------------");
            EmOrdem(node.getDireita());
        }
    }

    public ArrayList<No> ImprimeEmOrdem(No node, ArrayList<No> arrayArvore) {
        if (node != null) {
            ImprimeEmOrdem(node.getEsquerda(), arrayArvore);
            arrayArvore.add(node);
            ImprimeEmOrdem(node.getDireita(), arrayArvore);
        }
        return arrayArvore;
    }

    //Remover No
    public No remover(No node, int valor) {
        System.out.println("  Corendo No " + node.valor);
        if (node == null) {
            System.out.println("  Arvore vazia ");
        }
        if (valor < node.valor) {
            node.esquerda = remover(node.esquerda, valor);
        } else if (valor > node.valor) {
            node.direita = remover(node.direita, valor);
        } else if (node.esquerda != null && node.direita != null) // 2 filhos
        {
            System.out.println("  Removeu No " + node.valor);
            JOptionPane.showMessageDialog(null, "O no " + valor + "foi removido");
            node.valor = encontraMinimo(node.direita).valor;
            node.direita = removeMinimo(node.direita);
        } else {
            System.out.println("  Removeu No " + node.valor);
            JOptionPane.showMessageDialog(null, "O no " + valor + "foi removido");
            node = (node.esquerda == null) ? node.esquerda : node.direita;
        }
        return node;
    }

    public No removeMinimo(No node) {
        if (node == null) {
            System.out.println("  ERRO ");
        } else if (node.esquerda != null) {
            node.esquerda = removeMinimo(node.esquerda);
            return node;
        } else {
            return node.direita;
        }
        return null;
    }

    public No encontraMinimo(No node) {
        if (node != null) {
            while (node.esquerda != null) {
                node = node.esquerda;
            }
        }
        return node;
    }

    //Pesquisa chave
    public No pesquisarNo(No raiz, No registro) {
        if (raiz == null) {
            System.out.println("raiz nula");
            registro = null;
        } else {
            if (registro.getValor() == raiz.getValor()) {
                registro.setValor(raiz.getValor());
                registro.setNome(raiz.getNome());
                registro.setAno(raiz.getAno());
                registro.setDescricao(raiz.getDescricao());
                System.out.println("Pesquisa: Achou o no procurado!");
                System.out.println("" + registro.getValor());
                System.out.println("" + registro.getNome());
                System.out.println("" + registro.getAno());
                System.out.println("" + registro.getDescricao());
            }
            if (registro.getValor() < raiz.getValor()) {
                pesquisarNo(raiz.getEsquerda(), registro);
            }
            if (registro.getValor() > raiz.getValor()) {
                pesquisarNo(raiz.getDireita(), registro);
            }
            if (!(registro.getValor() < raiz.getValor()) && !(registro.getValor() > raiz.getValor()) && !(registro.getValor() == raiz.getValor())) {
                registro.valor = 0;//não existe na arvore
            }
        }
        return registro;
    }
}//fim da classe Arvore
