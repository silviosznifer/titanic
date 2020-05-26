package executor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class VerificarAcuracia {
	public static void main (String [] args) throws IOException {
		String arqCSVCompleto = "datasets/train.csv";
		String arqCSVSubmission = "datasets/Submissions/FilteredClassifier_30_submission.csv";
		String linha;
		double acertos=0, erros = 0;
		
		RandomAccessFile brCompleto = new RandomAccessFile(arqCSVCompleto, "r");
		BufferedReader brSubmission = new BufferedReader(new FileReader(arqCSVSubmission));
		
		linha = brSubmission.readLine(); // Ignorando a primeira linha de cabeçalho;
		
		while ((linha = brSubmission.readLine()) != null) {
			
			if (VerificarAcuracia.encontrarId(linha, brCompleto)) acertos++;
			else erros++;

		}
		
		double resultado = (acertos/(acertos+erros))*100;
		
		System.out.println("Acurácia: " + resultado + "%");
		
		brCompleto.close();
		brSubmission.close();
		
	}
	
	public static boolean encontrarId(String idSobreviveu, RandomAccessFile brCompleto) throws IOException  {
		String linha;
		
		System.out.println("----> idSobreviveu: "+idSobreviveu);
		
		while ((linha = brCompleto.readLine()) != null) {
			
			if (linha.substring(0, idSobreviveu.length()).equals(idSobreviveu)) {
				System.out.println("Encontrei!!");
				brCompleto.seek(0);
				return true;
			}
			
		}
		brCompleto.seek(0);
		return false;
	}

}
