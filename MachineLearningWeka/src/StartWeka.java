import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;


public class StartWeka {

	public static void main(String[] args) throws Exception{
		
		long tempo;
		
		BufferedReader breader = null;
		
		breader = new BufferedReader(new FileReader("C:/Users/Daniel Cabral/Documents/soybeans.arff"));
		
		Instances dataset = new Instances(breader);
		dataset.setClassIndex(dataset.numAttributes() -1);
		
		breader.close();
		
		// NaiveBayes
		NaiveBayes nB = new NaiveBayes();
		tempo = System.currentTimeMillis();
		nB.buildClassifier(dataset);
		Evaluation eval = new Evaluation(dataset);
		eval.crossValidateModel(nB, dataset, 10, new Random(1));
		System.out.println(eval.toSummaryString("\nResultados NaiveBayes\n========================\n", true));
		System.out.println("Tempo: " + (System.currentTimeMillis() - tempo) + "ms\n");
		System.out.println(eval.toClassDetailsString());
		System.out.println(eval.toMatrixString());
		System.out.println(eval.fMeasure(1) + " " + eval.precision(1) + " " + eval.recall(1));	
		
		//J48
		J48 j48 = new J48();
		tempo = System.currentTimeMillis();
		j48.buildClassifier(dataset);
		System.out.println("\n" + j48.toSummaryString());
		Evaluation evalj48 = new Evaluation(dataset);
		evalj48.crossValidateModel(j48, dataset, 10, new Random(1));
		System.out.println(evalj48.toSummaryString("\nResultados J48\n========================\n", true));
		System.out.println("Tempo: " + (System.currentTimeMillis() - tempo) + "ms\n");
		System.out.println(evalj48.toClassDetailsString()); 
		System.out.println(evalj48.toMatrixString());
		System.out.println(evalj48.fMeasure(1) + " " + eval.precision(1) + " " + eval.recall(1));	
	}

}
