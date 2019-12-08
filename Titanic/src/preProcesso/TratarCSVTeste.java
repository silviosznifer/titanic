package preProcesso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import bo.PassageiroCSV;

public class TratarCSVTeste {

	public static void main(String[] args) throws IOException {
		
		String linha;
		String arquivoCSV = "datasets/test.csv";
		String documento = "";
		
		PassageiroCSV p;
		
		BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
		
		//FileWriter arq = new FileWriter("datasets/train_tratado.csv");
	    //PrintWriter gravarArq = new PrintWriter(arq);
		
		linha = br.readLine(); // Ignorando a primeira linha de cabeçalho;
		
		
		
        while ((linha = br.readLine()) != null) {
        	
        	if (linha != null) {
        		p = new PassageiroCSV(linha, false);
        		System.out.println(p.toStringCSVTesteTratado());	
        		//documento += p.toStringCSVTesteTratado() + "\n";
        		//System.out.println(p.toString());
        	}
        	
        }
        
        br.close();
        
        System.out.println(documento);
	}

}
