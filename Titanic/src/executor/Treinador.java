package executor;

import java.io.BufferedReader;
import java.io.FileReader;

import modelo.ModeloTitanic;

public class Treinador {

	public static void main(String[] args) throws Exception {
		// TODO Ler do CSV
		String arquivoCSV = "datasets/test_tratado_30.csv";
		String linha;
		String resultado = "";
		
		ModeloTitanic m = new ModeloTitanic();
		
		BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
		
        while ((linha = br.readLine()) != null) {
        	
        	if (linha != null) {
        		System.out.print(linha.split(",")[0]+",");
        		
        		//resultado = m.classificarNaiveBayes(linha);
        		// resultado  = m.classificarJ48(linha);
        		
        		resultado  = m.classificarFilteredClassifier(linha);        		
        		
        		//System.out.println(linha);
        		
        		//resultado = m.classificarRandomForest(linha);
        		//resultado = m.classificarRandomTree(linha);
        		
        		//resultado = m.classificarMultilayerPerceptron(linha);
        		
        		//resultado = m.classificarPART(linha);
        		
        		//resultado = m.classificarJrip(linha);
        		
        		//resultado = m.classificarRegression(linha);
        		//resultado = m.classificarKStar(linha);
        		
        		if (resultado.equals("N")) System.out.println("0");
        		else System.out.println("1");
        	}
        	
        }
        
        br.close();
				
	}

}
