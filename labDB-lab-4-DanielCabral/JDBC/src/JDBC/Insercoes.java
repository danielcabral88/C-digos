/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import ObjetosDTO.*;
import ObjetosDAO.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuário
 */
public class Insercoes {
    
    public void inserir (int cont){
        
        /********** Instância dos Cursos ****************/
        
        ArrayList<Curso> cursos = new ArrayList<>();
        
        Curso c = new Curso("noturno", 8, "Josenildo", "Sistemas de Informacao"); // Instancio meus objetos para o teste
        CursoDAO cdao = new CursoDAO();
        cdao.inserir(c);
        c.setIdCurso(cdao.consultaIDLast());
        
        Curso c2 = new Curso ("noturno", 10, "Mauro", "Engenharia Elétrica");
        CursoDAO cdao2 = new CursoDAO();
        cdao2.inserir(c2);
        c2.setIdCurso(cdao2.consultaIDLast());
        
        
        /********** Instância de Professores ****************/
        
//        ArrayList<Professor> professores = new ArrayList<>();
        
        Professor p = new Professor ("João de Cristo", 7500);
        ProfessorDAO pdao = new ProfessorDAO();
        pdao.inserir(p);
        p.setMatricula(pdao.consultaIDLast());
        
        Professor p1 = new Professor ("Paulo Roberto", 5000);
        ProfessorDAO pdao1 = new ProfessorDAO();
        pdao1.inserir(p1);
        p1.setMatricula(pdao1.consultaIDLast());
        
        Professor p2 = new Professor ("Mauro Luis", 15000);
        ProfessorDAO pdao2 = new ProfessorDAO();
        pdao2.inserir(p2);
        p2.setMatricula(pdao2.consultaIDLast());
        
        Professor p3 = new Professor ("Vanessa Lopes", 8000);
        ProfessorDAO pdao3 = new ProfessorDAO();
        pdao3.inserir(p3);
        p3.setMatricula(pdao3.consultaIDLast());
        
        Professor p4 = new Professor ("Karla Mariana", 6000);
        ProfessorDAO pdao4 = new ProfessorDAO();
        pdao4.inserir(p4);
        p4.setMatricula(pdao4.consultaIDLast());
        
        Professor p5 = new Professor ("Jack Stone", 9000);
        ProfessorDAO pdao5 = new ProfessorDAO();
        pdao5.inserir(p5);
        p5.setMatricula(pdao5.consultaIDLast());
        
        Professor p6 = new Professor ("Dionicésio Madagascar", 5670);
        ProfessorDAO pdao6 = new ProfessorDAO();
        pdao6.inserir(p6);
        p6.setMatricula(pdao6.consultaIDLast());
        
        Professor p7 = new Professor ("Marcus Marcel", 5650);
        ProfessorDAO pdao7 = new ProfessorDAO();
        pdao7.inserir(p7);
        p7.setMatricula(pdao7.consultaIDLast());
        
        Professor p8 = new Professor ("Jefferson Lima", 5120);
        ProfessorDAO pdao8 = new ProfessorDAO();
        pdao8.inserir(p8);
        p8.setMatricula(pdao8.consultaIDLast());
        
        Professor p9 = new Professor ("Lucca Frederiksen", 12000);
        ProfessorDAO pdao9 = new ProfessorDAO();
        pdao9.inserir(p9);
        p9.setMatricula(pdao9.consultaIDLast());
        
        
        /********** Instância de Disciplinas ****************/
        
//        Set<Disciplina> hd = new HashSet();
//        Set<Disciplina> hd2 = new HashSet();
        
        Disciplina d = new Disciplina (p, "Etica e Sociedade", 40);
        DisciplinaDAO ddao = new DisciplinaDAO();
        ddao.inserir(d);
        d.setIdDisciplina(ddao.consultaIDLast());
        
        Disciplina d1 = new Disciplina (p1, "Introdução a Ciência da Computação", 60);
        DisciplinaDAO ddao1 = new DisciplinaDAO();
        ddao1.inserir(d1);
        d1.setIdDisciplina(ddao1.consultaIDLast());
        
        Disciplina d2 = new Disciplina (p2, "Banco de Dados", 90);
        DisciplinaDAO ddao2 = new DisciplinaDAO();
        ddao2.inserir(d2);
        d2.setIdDisciplina(ddao2.consultaIDLast());
        
        Disciplina d3 = new Disciplina (p3, "Linguagem de Programação I", 60);
        DisciplinaDAO ddao3 = new DisciplinaDAO();
        ddao3.inserir(d3);
        d3.setIdDisciplina(ddao3.consultaIDLast());
        
        Disciplina d4 = new Disciplina (p4, "Gestão e Administração", 90);
        DisciplinaDAO ddao4 = new DisciplinaDAO();
        ddao4.inserir(d4);
        d4.setIdDisciplina(ddao4.consultaIDLast());
        
        Disciplina d5 = new Disciplina (p5, "Estrutura de Dados", 40);
        DisciplinaDAO ddao5 = new DisciplinaDAO();
        ddao5.inserir(d5);
        d5.setIdDisciplina(ddao5.consultaIDLast());
        
        Disciplina d6 = new Disciplina (p6, "Inteligência Artificial", 40);
        DisciplinaDAO ddao6 = new DisciplinaDAO();
        ddao6.inserir(d6);
        d6.setIdDisciplina(ddao6.consultaIDLast());
        
        Disciplina d7 = new Disciplina (p7, "Algoritmo e Estrutura de Dados", 90);
        DisciplinaDAO ddao7 = new DisciplinaDAO();
        ddao7.inserir(d7);
        d7.setIdDisciplina(ddao7.consultaIDLast());
        
        Disciplina d8 = new Disciplina (p8, "Pesquisa Operacional", 60);
        DisciplinaDAO ddao8 = new DisciplinaDAO();
        ddao8.inserir(d8);
        d8.setIdDisciplina(ddao8.consultaIDLast());
        
        Disciplina d9 = new Disciplina (p9, "Estatística e Probabilidade", 60);
        DisciplinaDAO ddao9 = new DisciplinaDAO();
        ddao9.inserir(d9);
        d9.setIdDisciplina(ddao9.consultaIDLast());
        
        /****************** Adicionando Disciplinas referentes ao Curso 1 e 2 *****************/
        
        ArrayList<Disciplina> d_curso = new ArrayList<>();
        ArrayList<Disciplina> d_curso1 = new ArrayList<>();
        
        d_curso.add(d);
        d_curso.add(d1);
        d_curso.add(d2);
        d_curso.add(d3);
        d_curso.add(d4);
        d_curso.add(d5);
        d_curso.add(d6);
        d_curso.add(d7);
        d_curso.add(d8);
        d_curso.add(d9);
        
        d_curso1.add(d);
        d_curso1.add(d4);
        d_curso1.add(d9);       
        
        /************* Relacionamento do Curso c ***************/
        
        CursoDisciplina cd = new CursoDisciplina();
        cd.setidCurso(c.getIdCurso());
        cd.setidDisciplina(d.getIdDisciplina());
        CursoDisciplinaDAO cddao = new CursoDisciplinaDAO();
        cddao.Inserir(cd);
        
        CursoDisciplina cd1 = new CursoDisciplina();
        cd1.setidCurso(c.getIdCurso());
        cd1.setidDisciplina(d1.getIdDisciplina());
        CursoDisciplinaDAO cddao1 = new CursoDisciplinaDAO();
        cddao1.Inserir(cd1);
        
        CursoDisciplina cd2 = new CursoDisciplina();
        cd2.setidCurso(c.getIdCurso());
        cd2.setidDisciplina(d2.getIdDisciplina());
        CursoDisciplinaDAO cddao2 = new CursoDisciplinaDAO();
        cddao2.Inserir(cd2);
        
        CursoDisciplina cd3 = new CursoDisciplina();
        cd3.setidCurso(c.getIdCurso());
        cd3.setidDisciplina(d3.getIdDisciplina());
        CursoDisciplinaDAO cddao3 = new CursoDisciplinaDAO();
        cddao3.Inserir(cd3);
        
        CursoDisciplina cd4 = new CursoDisciplina();
        cd4.setidCurso(c.getIdCurso());
        cd4.setidDisciplina(d4.getIdDisciplina());
        CursoDisciplinaDAO cddao4 = new CursoDisciplinaDAO();
        cddao4.Inserir(cd4);
        
        CursoDisciplina cd5 = new CursoDisciplina();
        cd5.setidCurso(c.getIdCurso());
        cd5.setidDisciplina(d5.getIdDisciplina());
        CursoDisciplinaDAO cddao5 = new CursoDisciplinaDAO();
        cddao5.Inserir(cd5);
        
        CursoDisciplina cd6 = new CursoDisciplina();
        cd6.setidCurso(c.getIdCurso());
        cd6.setidDisciplina(d6.getIdDisciplina());
        CursoDisciplinaDAO cddao6 = new CursoDisciplinaDAO();
        cddao6.Inserir(cd6);
        
        CursoDisciplina cd7 = new CursoDisciplina();
        cd7.setidCurso(c.getIdCurso());
        cd7.setidDisciplina(d7.getIdDisciplina());
        CursoDisciplinaDAO cddao7 = new CursoDisciplinaDAO();
        cddao7.Inserir(cd7);
        
        CursoDisciplina cd8 = new CursoDisciplina();
        cd8.setidCurso(c.getIdCurso());
        cd8.setidDisciplina(d8.getIdDisciplina());
        CursoDisciplinaDAO cddao8 = new CursoDisciplinaDAO();
        cddao8.Inserir(cd8);
        
        CursoDisciplina cd9 = new CursoDisciplina();
        cd9.setidCurso(c.getIdCurso());
        cd9.setidDisciplina(d9.getIdDisciplina());
        CursoDisciplinaDAO cddao9 = new CursoDisciplinaDAO();
        cddao9.Inserir(cd9);
      
//        hd.add(d);
//        hd.add(d1);
//        hd.add(d2);
//        hd.add(d3);
//        hd.add(d4);
//        hd.add(d5);
//        hd.add(d6);
//        hd.add(d7);
//        hd.add(d8);
//        hd.add(d9);
        
        /************* Relacionamento do Curso c2 ****************/
        
        CursoDisciplina c2d = new CursoDisciplina();
        c2d.setidCurso(c2.getIdCurso());
        c2d.setidDisciplina(d.getIdDisciplina());
        CursoDisciplinaDAO c2ddao = new CursoDisciplinaDAO();
        c2ddao.Inserir(c2d);
        
        CursoDisciplina c2d1 = new CursoDisciplina();
        c2d1.setidCurso(c2.getIdCurso());
        c2d1.setidDisciplina(d4.getIdDisciplina());
        CursoDisciplinaDAO c2ddao1 = new CursoDisciplinaDAO();
        c2ddao1.Inserir(c2d1);
        
        CursoDisciplina c2d2 = new CursoDisciplina();
        c2d2.setidCurso(c2.getIdCurso());
        c2d2.setidDisciplina(d9.getIdDisciplina());
        CursoDisciplinaDAO c2ddao2 = new CursoDisciplinaDAO();
        c2ddao2.Inserir(c2d2);
//        
//        hd2.add(d);
//        hd2.add(d4);
//        hd2.add(d9);
        
        /********** Adicionando disciplinas aos cursos *************/
        
//        c.setDisciplinas(hd);
//        c2.setDisciplinas(hd2);
               
//        Session se = ConnectionManager.getSessionFactory().getCurrentSession();
//        se.beginTransaction();
//        se.save(c);
//        se.save(c2);
//        se.save(p);
//        se.save(p1);
//        se.save(p2);
//        se.save(p3);
//        se.save(p4);
//        se.save(p5);
//        se.save(p6);
//        se.save(p7);
//        se.save(p8);
//        se.save(p9);
//        se.save(d);
//        se.save(d1);
//        se.save(d2);
//        se.save(d3);
//        se.save(d4);
//        se.save(d5);
//        se.save(d6);
//        se.save(d7);
//        se.save(d8);
//        se.save(d9);
//        
//        se.getTransaction().commit();
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
//        Set<Nota> notas = new HashSet();
        
        Aluno a = new Aluno();
        AlunoDAO adao = new AlunoDAO();
        DisciplinaAluno dis_aluno = new DisciplinaAluno();
        DisciplinaAlunoDAO dis_alunodao = new DisciplinaAlunoDAO();
        
        Nota n = new Nota();
        NotaDAO ndao = new NotaDAO();
        
        Nota n1 = new Nota();
        NotaDAO ndao1 = new NotaDAO();
        
        Nota n2 = new Nota();
        NotaDAO ndao2 = new NotaDAO();
        
        Nota n3 = new Nota();
        NotaDAO ndao3 = new NotaDAO();
        
        
        for (int i = 0 ; i < cont ; i++){
            
            if (r.nextInt(2)> 0 ){
                
                a.setCurso(cursos.get(1));
                a.setNome(gn.retornaNome());
                
                adao.inserir(a);
                a.setMatricula(adao.consultaIDLast());
                dis_aluno.setidAluno(a.getMatricula());
                dis_aluno.setidDisciplina(d_curso1.get(r.nextInt(3)).getIdDisciplina());
                dis_alunodao.Inserir(dis_aluno);
                
                n.setAluno(a);
                n.setValor(r.nextFloat()*10);
                ndao.inserir(n);
                
                n1.setAluno(a);
                n1.setValor(r.nextFloat()*10);
                ndao1.inserir(n1);
                
                n2.setAluno(a);
                n2.setValor(r.nextFloat()*10);
                ndao2.inserir(n2);
                
                n3.setAluno(a);
                n3.setValor(r.nextFloat()*10);
                 ndao3.inserir(n3);
                
//                notas.add(n);
//                notas.add(n1);
//                notas.add(n2);
//                notas.add(n3);
                
//                a.setDisciplinas(hd2);
//                a.setNotas(notas);
                
            }else {
                a.setCurso(cursos.get(0));
                a.setNome(gn.retornaNome());
                adao.inserir(a);
                a.setMatricula(adao.consultaIDLast());
                
                dis_aluno.setidAluno(a.getMatricula());
                dis_aluno.setidDisciplina(d_curso.get(r.nextInt(10)).getIdDisciplina());
                dis_alunodao.Inserir(dis_aluno);
                
                n.setAluno(a);
                n.setValor(r.nextFloat()*10);
                ndao.inserir(n);
                
                n1.setAluno(a);
                n1.setValor(r.nextFloat()*10);
                ndao1.inserir(n1);
                
                n2.setAluno(a);
                n2.setValor(r.nextFloat()*10);
                ndao2.inserir(n2);
                
                n3.setAluno(a);
                n3.setValor(r.nextFloat()*10);
                ndao3.inserir(n3);
                
//                notas.add(n);
//                notas.add(n1);
//                notas.add(n2);
//                notas.add(n3);
//                
//                a.setDisciplinas(hd);
//                a.setNotas(notas);
//                
            }
//            Session se2 = ConnectionManager.getSessionFactory().getCurrentSession();
//            se2.beginTransaction();
//            se2.save(a);
//            se2.save(n);
//            se2.save(n1);
//            se2.save(n2);
//            se2.save(n3);
//            se2.getTransaction().commit();
//            notas.clear();
        }
        
        
    }
}