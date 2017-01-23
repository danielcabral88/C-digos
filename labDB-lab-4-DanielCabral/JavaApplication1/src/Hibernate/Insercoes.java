/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Entidades.*;
import Utilitarios.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Usuário
 */
public class Insercoes {
    
    public void inserir (int cont){
        
        /********** Instância dos Cursos ****************/
        
        ArrayList<Curso> cursos = new ArrayList<>();
        
        Curso c = new Curso("noturno", 8, "Josenildo", "Sistemas de Informacao"); // Instancio meus objetos para o teste
        Curso c2 = new Curso ("noturno", 10, "Mauro", "Engenharia Elétrica");
        
        
        
        /********** Instância de Professores ****************/
        
//        ArrayList<Professor> professores = new ArrayList<>();
        
        Professor p = new Professor ("João de Cristo", 7500);
        Professor p1 = new Professor ("Paulo Roberto", 5000);
        Professor p2 = new Professor ("Mauro Luis", 15000);
        Professor p3 = new Professor ("Vanessa Lopes", 8000);
        Professor p4 = new Professor ("Karla Mariana", 6000);
        Professor p5 = new Professor ("Jack Stone", 9000);
        Professor p6 = new Professor ("Dionicésio Madagascar", 5670);
        Professor p7 = new Professor ("Marcus Marcel", 5650);
        Professor p8 = new Professor ("Jefferson Lima", 5120);
        Professor p9 = new Professor ("Lucca Frederiksen", 12000);
        
        /********** Instância de Disciplinas ****************/
        
        Set<Disciplina> hd = new HashSet();
        Set<Disciplina> hd2 = new HashSet();
        
        Disciplina d = new Disciplina (p, "Etica e Sociedade", 40);
        Disciplina d1 = new Disciplina (p1, "Introdução a Ciência da Computação", 60);
        Disciplina d2 = new Disciplina (p2, "Banco de Dados", 90);
        Disciplina d3 = new Disciplina (p3, "Linguagem de Programação I", 60);
        Disciplina d4 = new Disciplina (p4, "Gestão e Administração", 90);
        Disciplina d5 = new Disciplina (p5, "Estrutura de Dados", 40);
        Disciplina d6 = new Disciplina (p6, "Inteligência Artificial", 40);
        Disciplina d7 = new Disciplina (p7, "Algoritmo e Estrutura de Dados", 90);
        Disciplina d8 = new Disciplina (p8, "Pesquisa Operacional", 60);
        Disciplina d9 = new Disciplina (p9, "Estatística e Probabilidade", 60);
        
        /************* HashSet do Curso c ***************/
        
        hd.add(d);
        hd.add(d1);
        hd.add(d2);
        hd.add(d3);
        hd.add(d4);
        hd.add(d5);
        hd.add(d6);
        hd.add(d7);
        hd.add(d8);
        hd.add(d9);
        
        /************* HashSet do Curso c2 ****************/
        
        hd2.add(d);
        hd2.add(d4);
        hd2.add(d9);
        
        /********** Adicionando disciplinas aos cursos *************/
        
        c.setDisciplinas(hd);
        c2.setDisciplinas(hd2);
               
        Session se = ConnectionManager.getSessionFactory().getCurrentSession();
        se.beginTransaction();
        se.save(c);
        se.save(c2);
        se.save(p);
        se.save(p1);
        se.save(p2);
        se.save(p3);
        se.save(p4);
        se.save(p5);
        se.save(p6);
        se.save(p7);
        se.save(p8);
        se.save(p9);
        se.save(d);
        se.save(d1);
        se.save(d2);
        se.save(d3);
        se.save(d4);
        se.save(d5);
        se.save(d6);
        se.save(d7);
        se.save(d8);
        se.save(d9);
        
        se.getTransaction().commit();
//        se.disconnect();
        
//        professores.add(p);
//        professores.add(p1);
//        professores.add(p2);
//        professores.add(p3);
//        professores.add(p4);
//        professores.add(p5);
//        professores.add(p6);
//        professores.add(p7);
//        professores.add(p8);
//        professores.add(p9);
 
/************* Inserção de Alunos ******************/        
        
        cursos.add(c);
        cursos.add(c2);

        
        Random r = new Random();
        GerarNome gn = new GerarNome();
        Set<Nota> notas = new HashSet();
        
        
        
        for (int i = 0 ; i < cont ; i++){
            Aluno a;
            Nota n = new Nota();
            Nota n1 = new Nota();
            Nota n2 = new Nota();
            Nota n3 = new Nota();
            if (r.nextInt(2)> 0 ){
                
                a = new Aluno (cursos.get(1), gn.retornaNome());
                
                n.setAluno(a);
                n.setValor(r.nextFloat()*10);
                
                n1.setAluno(a);
                n1.setValor(r.nextFloat()*10);
                
                n2.setAluno(a);
                n2.setValor(r.nextFloat()*10);
                
                n3.setAluno(a);
                n3.setValor(r.nextFloat()*10);
                
                notas.add(n);
                notas.add(n1);
                notas.add(n2);
                notas.add(n3);
                
                a.setDisciplinas(hd2);
                a.setNotas(notas);
                
            }else {
                a = new Aluno (cursos.get(0), gn.retornaNome());
                         
                n.setAluno(a);
                n.setValor(r.nextFloat()*10);
                
                n1.setAluno(a);
                n1.setValor(r.nextFloat()*10);
                
                n2.setAluno(a);
                n2.setValor(r.nextFloat()*10);
                
                n3.setAluno(a);
                n3.setValor(r.nextFloat()*10);
                
                notas.add(n);
                notas.add(n1);
                notas.add(n2);
                notas.add(n3);
                
                a.setDisciplinas(hd);
                a.setNotas(notas);
                
            }
            Session se2 = ConnectionManager.getSessionFactory().getCurrentSession();
            se2.beginTransaction();
            se2.save(a);
            se2.save(n);
            se2.save(n1);
            se2.save(n2);
            se2.save(n3);
            se2.getTransaction().commit();
            notas.clear();
        }
        
        
    }
}