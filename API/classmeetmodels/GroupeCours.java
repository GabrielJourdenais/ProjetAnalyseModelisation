package classmeetmodels;

public class GroupeCours {

	private int noGroupeCours;
	private SessionCours session;
	private int annee;
	private String codeEnseignant;
	
	public GroupeCours() {
		super();
		this.session = SessionCours.H;
		this.annee = 0;
		this.noGroupeCours = 0;
		this.codeEnseignant = "";
	}

	/**
	 * @param session
	 * @param annee
	 * @param noGroupeCours
	 * @param codeEnseignant
	 */
	public GroupeCours(int noGroupeCours, SessionCours session, int annee, 
			String codeEnseignant) {
		super();
		this.noGroupeCours = noGroupeCours;
		this.session = session;
		this.annee = annee;
		this.codeEnseignant = codeEnseignant;
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
	 * @return the session
	 */
	public SessionCours getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(SessionCours session) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupeCours other = (GroupeCours) obj;
		if (annee != other.annee)
			return false;
		if (codeEnseignant == null) {
			if (other.codeEnseignant != null)
				return false;
		} else if (!codeEnseignant.equals(other.codeEnseignant))
			return false;
		if (noGroupeCours != other.noGroupeCours)
			return false;
		if (session != other.session)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupeCours [noGroupeCours=" + noGroupeCours + ", session=" + session + ", annee=" + annee
				+ ", codeEnseignant=" + codeEnseignant + "]";
	}
	
	
	
}
