/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuário
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Insercoes in = new Insercoes();
        String tempo;
        try {
            
            BufferedWriter fr = new BufferedWriter (new FileWriter("Lista.txt",true));
            
            for (int i = 0 ; i < 50 ; i++){
                long start = System.currentTimeMillis();
                in.inserir(10000);   
                long total = System.currentTimeMillis() - start;
                tempo = String.valueOf(total);
//                tempo = String.valueOf(i);
                fr.write(tempo);    
                fr.newLine();
                fr.flush();
        }
            fr.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }             
    }
}
