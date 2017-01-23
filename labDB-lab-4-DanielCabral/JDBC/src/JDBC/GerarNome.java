/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.util.Random;

/**
 *
 * @author Usuário
 */
public class GerarNome {
    
    char[] consoantes;
    char[] vogais;  
    
    public GerarNome(){
        
    }
    
    public String retornaNome (){
        consoantes = new char [22];
        vogais = new char [5];
        
        consoantes [0] = 'B';
        consoantes [1] = 'C';
        consoantes [2] = 'D';
        consoantes [3] = 'F';
        consoantes [4] = 'G';
        consoantes [5] = 'H';
        consoantes [6] = 'J';
        consoantes [7] = 'K';
        consoantes [8] = 'L';
        consoantes [9] = 'M';
        consoantes [10] = 'N';
        consoantes [11] = 'P';
        consoantes [12] = 'Q';
        consoantes [13] = 'R';
        consoantes [14] = 'S';
        consoantes [15] = 'T';
        consoantes [16] = 'V';
        consoantes [17] = 'X';
        consoantes [18] = 'Z';
        consoantes [19] = 'W';
        consoantes [20] = 'K';
        consoantes [21] = 'Y';
        
        vogais [0] = 'A';
        vogais [1] = 'E';
        vogais [2] = 'I';
        vogais [3] = 'O';
        vogais [4] = 'U';
        
        Random r = new Random();
                   
        String nome = new StringBuilder().append(consoantes[r.nextInt(22)]).append(vogais [r.nextInt(5)]).append(consoantes [r.nextInt(22)]).append(vogais [r.nextInt(5)]).toString();
        return nome;
    }
    
    
}
