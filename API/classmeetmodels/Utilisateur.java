package classmeetmodels;

public class Utilisateur {

	private String codeUtilisateur;
	private String motDePasse;
	private String prenom;
	private String nom;
	private String courriel;
	private String typeUtilisateur;

	public Utilisateur() {
		super();
		this.codeUtilisateur = "";
		this.motDePasse = "";
		this.prenom = "";
		this.nom = "";
		this.courriel = "";
		this.typeUtilisateur = "";
	}

	/**
	 * @param codeUtilisateur
	 * @param motDePasse
	 * @param prenom
	 * @param nom
	 * @param courriel
	 * @param typeUtilisateur
	 */
	public Utilisateur(String codeUtilisateur, String motDePasse, String prenom, String nom, String courriel,
			String typeUtilisateur) {
		super();
		this.codeUtilisateur = codeUtilisateur;
		this.motDePasse = motDePasse;
		this.prenom = prenom;
		this.nom = nom;
		this.courriel = courriel;
		this.typeUtilisateur = typeUtilisateur;
	}

	/**
	 * @return the codeUtilisateur
	 */
	public String getCodeUtilisateur() {
		return codeUtilisateur;
	}

	/**
	 * @param codeUtilisateur
	 *            the codeUtilisateur to set
	 */
	public void setCodeUtilisateur(String codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the courriel
	 */
	public String getCourriel() {
		return courriel;
	}

	/**
	 * @param courriel
	 *            the courriel to set
	 */
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	/**
	 * @return the typeUtilisateur
	 */
	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	/**
	 * @param typeUtilisateur
	 *            the typeUtilisateur to set
	 */
	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [codeUtilisateur=" + codeUtilisateur + ", motDePasse=" + motDePasse + ", prenom=" + prenom
				+ ", nom=" + nom + ", courriel=" + courriel + ", typeUtilisateur=" + typeUtilisateur + "]";
	}

}
