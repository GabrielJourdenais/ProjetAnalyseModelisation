package classmeetmodels;

public class CoursTemp {
	private String sigle;
	private String titre;
	private String session;
	private int annee;
	private int noGroupeCours;
	private String codeEnseignant;

	public CoursTemp() {
		super();
		this.sigle = "";
		this.titre = "";
		this.session = "";
		this.annee = 0;
		this.noGroupeCours = 0;
		this.codeEnseignant = "";
	}

	/**
	 * @param sigle
	 * @param titre
	 * @param session
	 * @param annee
	 * @param noGroupeCours
	 * @param codeEnseignant
	 */
	public CoursTemp(String sigle, String titre, String session, int annee, int noGroupeCours,
			String codeEnseignant) {
		super();
		this.sigle = sigle;
		this.titre = titre;
		this.session = session;
		this.annee = annee;
		this.noGroupeCours = noGroupeCours;
		this.codeEnseignant = codeEnseignant;
	}

	/**
	 * @return the sigle
	 */
	public String getSigle() {
		return sigle;
	}

	/**
	 * @param sigle
	 *            the sigle to set
	 */
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(String session) {
		this.session = session;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee
	 *            the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * @return the noGroupeCours
	 */
	public int getNoGroupeCours() {
		return noGroupeCours;
	}

	/**
	 * @param noGroupeCours
	 *            the noGroupeCours to set
	 */
	public void setNoGroupeCours(int noGroupeCours) {
		this.noGroupeCours = noGroupeCours;
	}

	/**
	 * @return the codeEnseignant
	 */
	public String getCodeEnseignant() {
		return codeEnseignant;
	}

	/**
	 * @param codeEnseignant
	 *            the codeEnseignant to set
	 */
	public void setCodeEnseignant(String codeEnseignant) {
		this.codeEnseignant = codeEnseignant;
	}
}
