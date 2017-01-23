import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class ContactLensesWaka{
	
	public static void main(String[] args) throws Exception{
		BufferedReader breader = null; // cria o leitor do arquivo
		breader = new BufferedReader(new FileReader("C:/Users/Daniel Cabral/Documents/contactlenses.arff")); //breader recebe o arquivo contactlenses.arff
		Instances lentes = new Instances(breader); //Cria o objeto lente do tipo Instances para o arquivo como parâmetro
		lentes.setClassIndex(lentes.numAttributes()-1); //Seta o index de lentes com o numero do ultimo atributo
		
		breader = new BufferedReader(new FileReader("C:/Users/Daniel Cabral/Documents/contactlenses2.arff")); //breader recebe o arquivo contactlenses.arff
		Instances lentesmissing = new Instances(breader); //Cria o objeto lente do tipo Instances para o arquivo como parâmetro
		lentesmissing.setClassIndex(lentes.numAttributes()-1); //Seta o index de lentes com o numero do ultimo atributo
		
		breader.close(); //Fechar o leitor
		
		J48 arvore = new J48(); // Cria o classificador do tipo J48
		arvore.buildClassifier(lentes);
		Instances resultado = new Instances(lentesmissing); // Instancia o resultado com lentesmissing
		
		for (int i = 0 ; i < lentesmissing.numInstances(); i++){ // laço pra percorrer todos os itens de lentesmissing
			double aux = arvore.classifyInstance(lentesmissing.instance(i)); //joga em aux o valor resultante da classificação
			resultado.instance(i).setClassValue(aux); // joga em resultado o valor obtido
		}
		
		// salvar
		BufferedWriter bwriter = new BufferedWriter(
				new FileWriter("C:/Users/Daniel Cabral/Documents/contactlensesresultado.arff"));
		bwriter.write(resultado.toString());
		
		bwriter.close();
		
	}

}
