package classmeetmodels;

public class Utilisateur {

	private String codeUtilisateur;
	private String motDePasse;
	private String prenom;
	private String nom;
	private String courriel;

	public Utilisateur() {
		super();
		this.codeUtilisateur = "";
		this.motDePasse = "";
		this.prenom = "";
		this.nom = "";
		this.courriel = "";
	}

	/**
	 * @param codeUtilisateur
	 * @param motDePasse
	 * @param prenom
	 * @param nom
	 * @param courriel
	 */
	public Utilisateur(String codeUtilisateur, String motDePasse, String prenom, String nom, String courriel) {
		super();
		this.codeUtilisateur = codeUtilisateur;
		this.motDePasse = motDePasse;
		this.prenom = prenom;
		this.nom = nom;
		this.courriel = courriel;
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
		Utilisateur other = (Utilisateur) obj;
		if (codeUtilisateur == null) {
			if (other.codeUtilisateur != null) {
				return false;
			}
		} else if (!codeUtilisateur.equals(other.codeUtilisateur)) {
			return false;
		}
		if (courriel == null) {
			if (other.courriel != null) {
				return false;
			}
		} else if (!courriel.equals(other.courriel)) {
			return false;
		}
		if (motDePasse == null) {
			if (other.motDePasse != null) {
				return false;
			}
		} else if (!motDePasse.equals(other.motDePasse)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Utilisateur [codeUtilisateur=" + codeUtilisateur + ", motDePasse=" + motDePasse + ", prenom=" + prenom
				+ ", nom=" + nom + ", courriel=" + courriel + "]";
	}

}
