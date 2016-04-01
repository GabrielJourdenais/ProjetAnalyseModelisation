package classmeetmodels;

public class Message {

	private String de;
	private String a;
	private String objet;
	private String texte;

	public Message() {
		super();
		this.de = "";
		this.a = "";
		this.objet = "";
		this.texte = "";
	}

	/**
	 * @param codeUtilisateur
	 * @param de
	 * @param a
	 * @param objet
	 * @param texte
	 */
	public Message(String de, String a, String objet, String texte) {
		super();
		this.de = de;
		this.a = a;
		this.objet = objet;
		this.texte = texte;
	}
	
	/**
	 * @return the de
	 */
	public String getDe() {
		return de;
	}

	/**
	 * @param de
	 *            the de to set
	 */
	public void setDe(String de) {
		this.de = de;
	}

	/**
	 * @return the a
	 */
	public String getA() {
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * @return the objet
	 */
	public String getObjet() {
		return objet;
	}

	/**
	 * @param objet
	 *            the objet to set
	 */
	public void setObjet(String objet) {
		this.objet = objet;
	}

	/**
	 * @return the texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * @param texte
	 *            the texte to set
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (de == null) {
			if (other.de != null)
				return false;
		} else if (!de.equals(other.de))
			return false;
		if (objet == null) {
			if (other.objet != null)
				return false;
		} else if (!objet.equals(other.objet))
			return false;
		if (texte == null) {
			if (other.texte != null)
				return false;
		} else if (!texte.equals(other.texte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [de=" + de + ", a=" + a + ", objet=" + objet + ", texte=" + texte + "]";
	}

	
	
}