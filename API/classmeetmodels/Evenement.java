package classmeetmodels;

public class Evenement {

	private String nom;
	private String description;
	private String dateEvenements;
	private String lieu;

	public Evenement() {
		super();
		this.nom = "";
		this.description = "";
		this.dateEvenements = "";
		this.lieu = "";
	}

	public Evenement(String nom, String description,
			String dateEvenements, String lieu) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateEvenements = dateEvenements;
		this.lieu = lieu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateEvenements() {
		return dateEvenements;
	}

	public void setDateEvenements(String dateEvenements) {
		this.dateEvenements = dateEvenements;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
