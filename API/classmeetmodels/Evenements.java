package classmeetmodels;

public class Evenements {

	private String sigle;
	private int noGroupeCours;
	private int noEquipe;
	private String nom;
	private String description;
	private String dateEvenements;
	private String lieu;

	public Evenements() {
		super();
		this.sigle = "";
		this.noGroupeCours = 0;
		this.noEquipe = 0;
		this.nom = "";
		this.description = "";
		this.dateEvenements = "";
		this.lieu = "";
	}

	public Evenements(String sigle, int noGroupeCours, int noEquipe, String nom, String description,
			String dateEvenements, String lieu) {
		super();
		this.sigle = sigle;
		this.noGroupeCours = noGroupeCours;
		this.noEquipe = noEquipe;
		this.nom = nom;
		this.description = description;
		this.dateEvenements = dateEvenements;
		this.lieu = lieu;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public int getNoGroupeCours() {
		return noGroupeCours;
	}

	public void setNoGroupeCours(int noGroupeCours) {
		this.noGroupeCours = noGroupeCours;
	}

	public int getNoEquipe() {
		return noEquipe;
	}

	public void setNoEquipe(int noEquipe) {
		this.noEquipe = noEquipe;
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

	@Override
	public String toString() {
		return "Evenements [sigle=" + sigle + ", noGroupeCours=" + noGroupeCours + ", noEquipe=" + noEquipe + ", nom="
				+ nom + ", description=" + description + ", dateEvenements=" + dateEvenements + ", lieu=" + lieu + "]";
	}

}
