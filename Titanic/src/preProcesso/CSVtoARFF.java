package preProcesso;

public class CSVtoARFF {

	public static String incluirCabecalho(String documento) {
		String cabecalho = "@relation titanic_tratado\n\n" + 
							"@attribute 'Survived' {N, S}\n" +
							"@attribute 'Pclass' integer\n" +
							"@attribute 'Sex' integer\n" +
							"@attribute 'Age' integer\n" +
							"@attribute 'parentes' integer\n" +
							"@attribute 'Fare' integer\n" +
							"@attribute 'Cabin' integer\n" +
							"@attribute 'Embarked' integer\n" +
							"@attribute 'Age_Pclass' integer\n" +
							"@attribute 'Fare_por_pessoa' integer\n" +
							"@attribute 'titulo' integer\n\n" +
							"@data\n";
		return cabecalho+documento;
	}

}
