package problemas;



import interfaces.Estado;

import java.util.LinkedList;
import java.util.List;


public class EstadoMissionariosCanibais implements Estado{
    
    public String getDescricao() {
        return
        "Tres misssionarios e tres canibais \n\n";
    }
    
    //atributos do estado
    final int missionario, canibal;
    
    //lado do barco
    final char barco;
    
    //operacao que gerou o estado
    final String op;
    
    //Recebe a quantidade de canibais na margem esquerda
    public EstadoMissionariosCanibais(int m, int c,char b, String o) {
        missionario = m;
        canibal = c;
        barco = b;
        op = o;
    }
    
    public boolean ehMeta(){
    	return missionario == 0 && canibal == 0;
    }
    
    public int custo() {
        return 1;
    }
    
    public Estado geraAleatorio() {
    	return new EstadoMissionariosCanibais(canibal, canibal, barco, op);
    }
    
    //Lista de sucessores
    public List<Estado> sucessores(){
        List<Estado> suc = new LinkedList<Estado>(); //Lista de sucessores
        //Levar um missionario
        levar1m(suc);
        //levar dois missionarios
        levar2m(suc);
        //levar 1 missionario e 1 canibal
        levar1m1c(suc);
        //levar 1 canibal
        levar1c(suc);
        //levar 2 canibais
        levar2c(suc);
        
        //Retornar a lista de Sucessores
        return suc;
    }
    
    //Lista de antecessores, para busca bidirecional
    public List<Estado> antecessores(){
        return sucessores();
    }
    
    //Verifica se o sucessor gerado e valido
    public boolean ehValido(){
        if (missionario < canibal && missionario != 0)
            return false;
        if (3-missionario < 3-canibal && 3-missionario != 0)
            return false;
        return true;
    }
    
    // Movimenta um missionario de uma margem a outra
    public void levar1m(List<Estado> suc){
    	//Se o barco estiver do lado direto e Houver pelo menos 1 missionário neste lado
        if (barco == 'd' && missionario > 0){
            //Gera um sucessor
            EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario-1,canibal,'e',"Levar 1 missionário para margem esquerda");
            //Verifica se o sucessor gerado é valido
            if (novo.ehValido())
                //Se for válido, adiciona na lista de sicessores
                suc.add(novo);
        } else {
        	//Se o barco estiver do lado esquerdo e houver pelo menos 1 missionário nesse lado
            if (barco == 'e' && missionario < 3) {
                //Gerar o sucessor
                EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario+1,canibal,'d',"Levar 1 missionário para margem direita");
                //Verificar se ele é válido
                if (novo.ehValido())
                    //Adicionar na lista de sucessores
                    suc.add(novo);
            }
        }
    }
    
    // Movimenta 2 missionarios de uma margem a outra
    public void levar2m(List<Estado> suc){
    	//Se o barco estiver do lado direito e houver dois missionários deste lado
        if (barco == 'd' && missionario > 1){
            //Gerar o sucessor
            EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario-2,canibal,'e',"Levar 2 missionários para margem esquerda");
            //Verificar se ele é válido
            if (novo.ehValido())
                //Adicionar na lista de sucessores
                suc.add(novo);
        }else{
        	//Se o barco estiver do lado esquerdo e houver pelo menos 2 missionários deste lado
            if (barco == 'e' && missionario < 2){
                //Gerar sucessor
                EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario+2,canibal,'d',"Levar 2 missionários para margem direita");
                //Verificar se ele é válido
                if (novo.ehValido())
                    //Adicionar na lista de sucessores
                    suc.add(novo);
            }
        }
    }
    
    //Movimentar 1 missionário e 1 canibal
    public void levar1m1c(List<Estado> suc){
    	//Se o barco estiver do lado direito e houver pelo menos um missionário e um canibal deste lado
        if (barco == 'd' && missionario > 0 && canibal > 0){
            //Gerar sucessor
            EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario-1,canibal-1,'e',"Levar 1 missionário e 1 canibal para margem esquerda");
            //Verificar se ele é válido
            if (novo.ehValido())
                //Adicionar na lista de sucessores
                suc.add(novo);
        }else{
        	//Se o barco estiver do lado esquerdo e houver pelo menos um missionário e um canibal deste lado
            if (barco == 'e' && missionario < 3 && canibal <3){
                //Gerar Sucessor
                EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario+1,canibal+1,'d',"Levar 1 missionário e 1 canibal para margem direita");
                //Verificar se ele é válido
                if (novo.ehValido())
                    //Adicionar na lista de sucessores
                    suc.add(novo);
            }
        }
    }
    
    //Movimentar um canibal de uma margem a outra
    public void levar1c(List<Estado> suc){
    	//Se o barco estiver no lado direito e houver pelo menos 1 canibal deste lado
        if (barco == 'd' && canibal > 0){
            //Gerar sucessor
            EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario,canibal-1,'e',"Levar 1 canibal para margem esquerda");
            //Verificar se ele é válido
            if (novo.ehValido())
                //Adicionar na lista
                suc.add(novo);
        }else{
        	//Se o barco estiver do lado esquerdo e houver pelo menos um canibal deste lado
            if (barco == 'e' && canibal < 3){
                //Gerar sucessor
                EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario,canibal+1,'d',"Levar 1 canibal para margem direita");
                //Verificar se ele é válido
                if (novo.ehValido())
                    //Adicionar na lista de sucessores
                    suc.add(novo);
            }
        }
    }
    
    //Levar 2 canibais de uma margem a outra
    public void levar2c(List<Estado> suc){
        //Se o barco estiver do lado direto e houver pelo menos 2 canibais deste lado
        if (barco == 'd' && canibal > 1){
            //Gerar sucessor
            EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario,canibal-2,'e',"Levar 2 canibais para margem esquerda");
            //Verificar se é válido
            if (novo.ehValido())
                //Adicionar na lista de sucessores
                suc.add(novo);
        }else{
        	//Se o barco estiver do lado esquerdo e houver pelo menos dois canibais deste lado
            if (barco == 'e' && canibal < 2){
                //Gerar sucessor
                EstadoMissionariosCanibais novo = new EstadoMissionariosCanibais(missionario,canibal+2,'d',"Levar 2 canibais para margem direita");
                //Verificar se ele é válido
                if (novo.ehValido())
                    //Adicionar na lista
                    suc.add(novo);
            }
        }
    }
    
    public String toString() {
        String dir = "", esq = "";
        if (missionario == 3)
            dir += "MMM";
        if (missionario == 2){
            dir += "MM";
            esq += "M";
        }
        if (missionario == 1){
            dir += "M";
            esq += "MM";
        }
        if (missionario == 0)
            esq += "MMM";
        
        if (canibal == 3)
            dir += "CCC";
        if (canibal == 2){
            dir += "CC";
            esq += "C";
        }
        if (canibal == 1){
            dir += "C";
            esq += "CC";
        }
        if (canibal == 0)
            esq += "CCC";
        if (barco == 'e')
            esq += 'B';
        else
            dir = 'B'+dir;
        
        return esq+"|"+dir+"( "+op+" )"+"\n";
    }
    
    /*
    public static void main(String[] a) throws IOException {
        EstadoMissionariosCanibais inicial = new EstadoMissionariosCanibais(3,3,'d',"");
        //Resolucao finau = new Resolucao(0,0,'e',"");
        
        Nodo n = null;
        
        System.out.println("Busca em Largura");
        n = new BuscaLargura(new MostraStatusConsole()).busca(inicial);
        if (n != null) 
        	System.out.println("Passos para travessia:\n"+n.montaCaminho().replace(';','-')+"\n");
        
    } */
    
    
    //Verifica se um estado é igual a outro já inserido na lista de sucessores (usado para poda)
    public boolean equals(Object o) {
    	try {
            EstadoMissionariosCanibais e = (EstadoMissionariosCanibais)o;
            if (missionario == e.missionario && canibal == e.canibal && barco == e.barco)
                return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//retorna o hashCode desse estado(usado para poda, conjunto de fechados)
    public int hashCode() {
        return (missionario + "," + canibal + barco).hashCode();
    }
    
}
