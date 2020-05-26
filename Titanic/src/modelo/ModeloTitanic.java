package modelo;

import bo.PassageiroArff;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.lazy.KStar;
import weka.classifiers.meta.ClassificationViaRegression;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.RandomTree;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ModeloTitanic {
	private Instances instancias;
	private DataSource ds = new DataSource("datasets/titanic_tratado_70.arff");
	
	public ModeloTitanic() throws Exception {
		this.instancias = ds.getDataSet();
		this.instancias.setClassIndex(0);
	}
	
	public Instances getInstancias() {
		return this.instancias;
	}
	
	public String classificarNaiveBayes(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(this.instancias);
		
		double resultado[] = nb.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	}
	
	public String classificarJ48(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		J48 m = new J48();
		m.setNumFolds(20);
		m.setReducedErrorPruning(true);
		m.setUnpruned(false);
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarRandomForest(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		RandomForest m = new RandomForest();
		m.setCalcOutOfBag(true);
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarMultilayerPerceptron(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		MultilayerPerceptron m = new MultilayerPerceptron();
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarPART(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		PART m = new PART();
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarJrip(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		JRip m = new JRip();
		m.setUsePruning(false);
		m.setFolds(4);
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarRegression(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		ClassificationViaRegression m = new ClassificationViaRegression();
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarKStar(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		KStar m = new KStar();
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarFilteredClassifier(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
		FilteredClassifier m = new FilteredClassifier();
		
		weka.filters.supervised.attribute.Discretize d = new weka.filters.supervised.attribute.Discretize();
		d.setInvertSelection(true);
		d.setBinRangePrecision(6);
		
		m.setBatchSize("100");
		m.setFilter(d);		
		m.setNumDecimalPlaces(2);
		m.setSeed(1);
		
		weka.classifiers.trees.J48 j48 = new weka.classifiers.trees.J48();
		j48.setMinNumObj(2);
		j48.setConfidenceFactor((float)0.25);
		// weka.classifiers.meta.FilteredClassifier -F "weka.filters.supervised.attribute.Discretize -R first-last -precision 6" -S 1 -W weka.classifiers.trees.J48 -- -C 0.25 -M 2		
		m.setClassifier(j48);
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > resultado[0]) return "S";
		else return "N";
	
	}
	
	public String classificarRandomTree(String novaInstancia) throws Exception {
		
		Instance novo = this.novaInstancia(novaInstancia);
		
//		RandomForestClassifier(criterion = "gini", 
//      min_samples_leaf = 1, 
//      min_samples_split = 10,   
//      n_estimators=100, 
//      max_features='auto', 
//      oob_score=True, 
//      random_state=1, 
//      n_jobs=-1)
		
		RandomTree m = new RandomTree();
		m.setNumFolds(100);
		m.buildClassifier(this.instancias);
		
		double resultado[] = m.distributionForInstance(novo);
		
		//System.out.println(resultado.length + " - " + resultado[0] + " - " + resultado[1]);
		
		if (resultado[1] > 0.75) return "S";
		else return "N";
	
	}
	
	
	
	
	private Instance novaInstancia(String novaInstancia) {
		
		Instance novo = new DenseInstance(12); // número de carcteristicas
		novo.setDataset(this.instancias);
		
		PassageiroArff p = new PassageiroArff(novaInstancia);
		
		/** 
		@attribute 'Survived' {N, S}
		@attribute 'Pclass' integer
		@attribute 'Sex' integer
		@attribute 'Age' integer
		@attribute 'parentes' integer
		@attribute 'Fare' integer
		@attribute 'Cabin' integer
		@attribute 'Embarked' integer
		@attribute 'Age_Pclass' integer
		@attribute 'Fare_por_pessoa' integer
		@attribute 'titulo' integer
		**/
		
		novo.setValue(1, p.getPclass());
		novo.setValue(2, p.getSex());
		novo.setValue(3, p.getAge());
		novo.setValue(4, p.getParentes());
		novo.setValue(6, p.getFare());
		novo.setValue(7, p.getCabin());
		novo.setValue(8, p.getEmbarked());
		novo.setValue(9, p.getAge_Pclass());
		novo.setValue(10, p.getFare_por_pessoa());
		novo.setValue(11, p.getTitulo());
		
		return novo;
		
	}

}
