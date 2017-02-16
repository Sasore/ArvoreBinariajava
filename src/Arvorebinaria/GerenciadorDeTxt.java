/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvorebinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import Arvorebinaria.No;
import Arvorebinaria.Arvore;

/**
 *
 * @author soare
 */
public class GerenciadorDeTxt {

    public void gravarTxt(No arvore) throws IOException {
        Scanner ler = new Scanner(System.in);
        int i, n;
        FileWriter arq = new FileWriter("arvoreBinaria.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        System.out.println("chaman do função em ordem");
        preOrdem(arvore, arq);
        arq.close();

        System.out.println("\nArvore  foi gravada com sucesso!");
    }

    private void preOrdem(No no, FileWriter arq) {

        if (no != null) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(String.valueOf(no.getValor()) + "\r\n");
            gravarArq.printf(no.getNome() + " \r\n");
            gravarArq.printf(String.valueOf(no.getAno()) + " \r\n");
            gravarArq.printf(no.getDescricao() + " \r\n");
            preOrdem(no.getEsquerda(), arq);
            preOrdem(no.getDireita(), arq);
        }
    }

    public static No lerTxt(No raiz) throws IOException {
        String path = "arvoreBinaria.txt";
        No no = new No();
        Arvore arvore = new Arvore();
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int count = 1;
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {
                if(count==1){
                    no.setValor(Integer.valueOf(linha.trim()));
                    System.out.println("no valor "+no.getValor());
                }else
                    if(count==2){
                        no.setNome(linha);
                        System.out.println("no nome "+no.getNome());
                    }
                else
                        if(count==3){
                            no.setAno(Integer.valueOf(linha.trim()));
                            System.out.println("no ano "+no.getAno());
                        }
                else
                            if(count==4){
                                no.setDescricao(linha);
                                System.out.println("no desc "+no.getDescricao());
                                if(raiz==null){
                                    raiz= new No();
                                    raiz.setValor(no.getValor());
                                    raiz.setNome(no.getNome());
                                    raiz.setAno(no.getAno());
                                    raiz.setDescricao(no.getDescricao());
                                }
                                else{
                                    arvore.inserir(raiz, no);
                                            
                                            }
                                count=0;
                            }
                count++;

            } else {
                break;
            }
            
        }
        buffRead.close();
        return raiz;
    }

}
