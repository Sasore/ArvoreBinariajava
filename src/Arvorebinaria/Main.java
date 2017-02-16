package Arvorebinaria;

import java.io.IOException;

//Arquivo Principal
public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    
    public void run() throws IOException {
        Interface mostrar= new Interface();
        mostrar.setVisible(true);
       
    }
    
}