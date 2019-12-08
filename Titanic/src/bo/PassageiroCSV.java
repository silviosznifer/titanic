package bo;

import java.math.BigDecimal;

public class PassageiroCSV {
	private String PassengerId;
	private String Survived;
	private String Pclass;
	private String Name;
	private String Sex;
	private String Age;
	private String SibSp;
	private String Parch;
	private String Ticket;
	private String Fare;
	private String Cabin;
	private String Embarked;
	private String Age_Pclass; // sugestões do site
	private String Fare_por_pessoa; // sugestões do site
	private String titulo; // sugestões do site
	
	public PassageiroCSV(String csv, boolean comClasse) {
		// Fromato esperado (sem classe): "892,3,male,34.5,0,0,8,N,Q"
		
		String [] campos = csv.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		
		if (comClasse) {
			this.PassengerId = campos[0];
			this.Survived = campos[1];
			this.Pclass = campos[2];
			this.Name = campos[3];
			this.Sex = campos[4];
			this.Age = campos[5];
			this.SibSp = campos[6];
			this.Parch = campos[7];
			this.Ticket = campos[8];
			this.Fare = campos[9];
			this.Cabin = campos[10];
			if (campos.length > 11)	this.Embarked = campos[11];
			
		} else {
			this.PassengerId = campos[0];
			this.Survived = "";
			this.Pclass = campos[1];
			this.Name = campos[2];
			this.Sex = campos[3];
			this.Age = campos[4];
			this.SibSp = campos[5];
			this.Parch = campos[6];
			this.Ticket = campos[7];
			this.Fare = campos[8];
			this.Cabin = campos[9];
			if (campos.length > 10)	this.Embarked = campos[10];
		}
				
	}
	
	public PassageiroCSV(String csv) {
		this(csv, true);
	}
	
	public String getPassengerId() {
		return PassengerId;
	}
	public void setPassengerId(String passengerId) {
		PassengerId = passengerId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public String getSurvived() {
		return Survived;
	}
	public void setSurvived(String survived) {
		Survived = survived;
	}
	public String getPclass() {
		return Pclass;
	}
	public void setPclass(String pclass) {
		Pclass = pclass;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getSibSp() {
		return SibSp;
	}
	public void setSibSp(String sibSp) {
		SibSp = sibSp;
	}
	public String getParch() {
		return Parch;
	}
	public void setParch(String parch) {
		Parch = parch;
	}
	public String getFare() {
		return Fare;
	}
	public void setFare(String fare) {
		Fare = fare;
	}
	public String getCabin() {
		return Cabin;
	}
	public void setCabin(String cabin) {
		Cabin = cabin;
	}
	public String getEmbarked() {
		return Embarked;
	}
	public void setEmbarked(String embarked) {
		Embarked = embarked;
	}
	
	public String toString() {
		return this.PassengerId + "," +
		this.Survived + "," +
		this.Pclass  + "," +
		this.Name  + "," +
		this.Sex  + "," +
		this.Age  + "," +
		this.SibSp + "," +
		this.Parch + "," +
		this.Ticket + "," +
		this.Fare + "," +
		this.Cabin + "," +
		this.Embarked + "," +
		this.Age_Pclass + "," +
		this.Fare_por_pessoa + "," +
		this.titulo;
	}
	
	public String toString(boolean comClasse) {
		if (comClasse) return this.toString();
		else {
			return this.PassengerId + "," +
			this.Pclass  + "," +
			this.Name  + "," +
			this.Sex  + "," +
			this.Age  + "," +
			this.SibSp + "," +
			this.Parch + "," +
			this.Ticket + "," +
			this.Fare + "," +
			this.Cabin + "," +
			this.Embarked + "," +
			this.Age_Pclass + "," +
			this.Fare_por_pessoa + "," +
			this.titulo;
		}
	}
	
	public String toStringCSVTesteTratado() {
		
		String idade = tratarAge(this.Age, this.Sex);
		String fare = tratarFare(this.Fare);
		
		return this.PassengerId + "," +
				this.Pclass  + "," +
				tratarSex(this.Sex)  + "," +
				idade  + "," +
				tratarParentes(this.SibSp, this.Parch) + "," +
				fare + "," +
				tratarCabin(this.Cabin) + "," +
				tratarEmbarked(this.Embarked) + "," +
				tartarAge_Pclass(idade, this.Pclass) + "," +
				tratarFare_por_Pessoa(fare, this.SibSp, this.Parch)  + "," +
				tratarTitulo(this.Name);
	}
	
	
	public String getAge_Pclass() {
		return Age_Pclass;
	}

	public void setAge_Pclass(String age_Pclass) {
		Age_Pclass = age_Pclass;
	}

	public String getFare_por_pessoa() {
		return Fare_por_pessoa;
	}

	public void setFare_por_pessoa(String fare_por_pessoa) {
		Fare_por_pessoa = fare_por_pessoa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String toStringCSVTreinoTratado() {
				
		String idade = tratarAge(this.Age, this.Sex);
		String fare = tratarFare(this.Fare);
		
		return tratarSurvived(this.Survived) + "," +
		this.Pclass  + "," +
		tratarSex(this.Sex)  + "," +
		idade  + "," +
		tratarParentes(this.SibSp, this.Parch) + "," +
		fare + "," +
		tratarCabin(this.Cabin) + "," +
		tratarEmbarked(this.Embarked) + "," +
		tartarAge_Pclass(idade, this.Pclass) + "," +
		tratarFare_por_Pessoa(fare, this.SibSp, this.Parch)  + "," +
		tratarTitulo(this.Name);
	}
	
	public String tratarTitulo(String name) {
		// {"Mr": 1, "Miss": 2, "Mrs": 3, "Master": 4, "Rare": 5}
		if (name.contains("Mr")) return "1";
		else if (name.contains("Miss")) return "2";
		else if (name.contains("Mrs")) return "3";
		else if (name.contains("Master")) return "4";
		else if (name.contains("Rare")) return "5";
		else return "1";
	}
	
	public String tartarAge_Pclass(String age, String pclass) {
		return String.valueOf((new BigDecimal(age).intValue()) * (new BigDecimal(pclass).intValue()));
	}
	
	public String tratarFare_por_Pessoa(String fare, String sibsp, String parch) {
		int numPessoas = ((new BigDecimal(sibsp).intValue()) + (new BigDecimal(parch).intValue())+1);
		int bFare = new BigDecimal(fare).intValue();
		return String.valueOf(new BigDecimal(bFare / numPessoas).intValue());
	}
	
	
	public String tratarSex(String sex) {
		if (sex.equals("male")) return "0";
		else return "1";
	}
	
	public String tratarSurvived(String survived) {
		if (survived.equals("0")) return "N";
		else return "S";
	}
	
	public String tratarParentes(String sibsp, String parch) {
		return String.valueOf((new BigDecimal(sibsp).intValue()) + (new BigDecimal(parch).intValue()));
	}
	
	public String tratarAge(String age, String sex) {
		String retorno = "";
		int idade = 0;
		if (age == null || age.isBlank() || age.isEmpty()) {
			// Como idade está vazia, usando a média. 23 para mulheres e 24 para homens
			if (sex.equals("male")) idade = 24;
			else idade = 23;
		} else { 
			// retornoar a parte inteira da idade
			idade = new BigDecimal(age).intValue();
		}
		
		// Agrupamento de idades por grupos - sugestão do site
//	    dataset.loc[ dataset['Age'] <= 11, 'Age'] = 0
//	    dataset.loc[(dataset['Age'] > 11) & (dataset['Age'] <= 18), 'Age'] = 1
//	    dataset.loc[(dataset['Age'] > 18) & (dataset['Age'] <= 22), 'Age'] = 2
//	    dataset.loc[(dataset['Age'] > 22) & (dataset['Age'] <= 27), 'Age'] = 3
//	    dataset.loc[(dataset['Age'] > 27) & (dataset['Age'] <= 33), 'Age'] = 4
//	    dataset.loc[(dataset['Age'] > 33) & (dataset['Age'] <= 40), 'Age'] = 5
//	    dataset.loc[(dataset['Age'] > 40) & (dataset['Age'] <= 66), 'Age'] = 6
//	    dataset.loc[ dataset['Age'] > 66, 'Age'] = 6
		if (idade <= 11) return "0";
		else if (idade > 11 && idade <= 18) return "1";
		else if (idade > 18 && idade <= 22) return "2";
		else if (idade > 22 && idade <= 27) return "3";
		else if (idade > 27 && idade <= 33) return "4";
		else if (idade > 33 && idade <= 40) return "5";
		else return "6";
		
	}
	
	public String tratarFare(String fare) {
		// retornar a parte inteira do Fare 
		if (fare == null || fare.isBlank() || fare.isEmpty()) return "31"; // Média do arquivo de treinamento
		else return String.valueOf(new BigDecimal(fare).intValue());
	}
	
	public String tratarCabin(String cabin) {
		if (cabin == null || cabin.isBlank() || cabin.isEmpty()) return "0";
		else {
			if (cabin.indexOf('U') >= 0) return "8";
			else if (cabin.indexOf('G') >= 0) return "7";
			else if (cabin.indexOf('F') >= 0) return "6";
			else if (cabin.indexOf('E') >= 0) return "5";
			else if (cabin.indexOf('D') >= 0) return "4";
			else if (cabin.indexOf('C') >= 0) return "3";
			else if (cabin.indexOf('B') >= 0) return "2";
			else if (cabin.indexOf('A') >= 0) return "1";
			else return "0";		
		}
	}
	
	public String tratarEmbarked(String embarked) {
		if (embarked == null || embarked.isBlank() || embarked.isEmpty()) return "0"; // retorna "0" pois é o da maioria
		else {
			if (embarked.equals("S")) return "0";
			else if (embarked.equals("C")) return "1";
			else return "2";
		}
	}
	
	

}
 