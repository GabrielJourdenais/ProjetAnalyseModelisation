package classmeetmodels;

public class Cours {

	private String sigle;
	private String titre;
	private SessionCours session;
	private int annee;

	public Cours() {
		super();
		this.sigle = "";
		this.titre = "";
		this.session = SessionCours.H;
		this.annee = 0;
	}

	/**
	 * @param sigle
	 * @param titre
	 * @param session
	 * @param annee
	 */
	public Cours(String sigle, String titre, SessionCours session, int annee) {
		super();
		this.sigle = sigle;
		this.titre = titre;
		this.session = session;
		this.annee = annee;
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
	 * @param obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cours other = (Cours) obj;
		if (annee != other.annee) {
			return false;
		}
		if (session != other.session) {
			return false;
		}
		if (sigle == null) {
			if (other.sigle != null) {
				return false;
			}
		} else if (!sigle.equals(other.sigle)) {
			return false;
		}
		if (titre == null) {
			if (other.titre != null) {
				return false;
			}
		} else if (!titre.equals(other.titre)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cours [sigle=" + sigle + ", titre=" + titre + ", session=" + session + ", annee=" + annee + "]";
	}

}