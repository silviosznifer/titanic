package bo;

/** 
@attribute PassengerId integer
@attribute Survived {0, 1}
@attribute Pclass integer
@attribute Sex integer
@attribute Age integer
@attribute SibSp integer
@attribute Parch integer
@attribute Fare integer
@attribute Cabin integer
@attribute Embarked integer
@attribute 'Age_Pclass' integer
@attribute 'Fare_por_pessoa' integer
@attribute 'titulo' integer
**/

public class PassageiroArff {
	private int PassengerId;
	private String Survived;
	private int Pclass;
	private int Sex;
	private int Age;
	private int Parentes;
	private int Fare;
	private int Cabin;
	private int Embarked;
	private int Age_Pclass; // sugestões do site
	private int Fare_por_pessoa; // sugestões do site
	private int titulo; // sugestões do site
	
	public PassageiroArff(String csv) {
		// Fromato esperado (sem classe): "892,3,male,34.5,0,0,8,N,Q"
		
		String [] campos = csv.split(",");
		
		this.PassengerId = Integer.parseInt(campos[0]);
		this.Pclass = Integer.parseInt(campos[1]);
		this.Sex = Integer.parseInt(campos[2]);
		if (campos[3].isEmpty()) this.Age = 0;
		else this.Age = Integer.parseInt(campos[3]);
		this.Parentes = Integer.parseInt(campos[4]);
		this.Fare = Integer.parseInt(campos[5]);
		this.Cabin = Integer.parseInt(campos[6]);
		this.Embarked = Integer.parseInt(campos[7]);
		this.Age_Pclass = Integer.parseInt(campos[8]);
		this.Fare_por_pessoa = Integer.parseInt(campos[9]);
		this.titulo = Integer.parseInt(campos[10]);
				
	}
	
	public int getAge_Pclass() {
		return Age_Pclass;
	}

	public void setAge_Pclass(int age_Pclass) {
		Age_Pclass = age_Pclass;
	}

	public int getFare_por_pessoa() {
		return Fare_por_pessoa;
	}

	public void setFare_por_pessoa(int fare_por_pessoa) {
		Fare_por_pessoa = fare_por_pessoa;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public int getPassengerId() {
		return PassengerId;
	}
	public void setPassengerId(int passengerId) {
		PassengerId = passengerId;
	}
	public String getSurvived() {
		return Survived;
	}
	public void setSurvived(String survived) {
		Survived = survived;
	}
	public int getPclass() {
		return Pclass;
	}
	public void setPclass(int pclass) {
		Pclass = pclass;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getParentes() {
		return Parentes;
	}
	public void setParentes(int parentes) {
		Parentes = parentes;
	}
	public int getFare() {
		return Fare;
	}
	public void setFare(int fare) {
		Fare = fare;
	}
	public int getCabin() {
		return Cabin;
	}
	public void setCabin(int cabin) {
		Cabin = cabin;
	}
	public int getEmbarked() {
		return Embarked;
	}
	public void setEmbarked(int embarked) {
		Embarked = embarked;
	}
	
	
}
