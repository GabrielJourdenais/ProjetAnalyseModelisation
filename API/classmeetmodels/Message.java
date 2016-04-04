package classmeetmodels;

public class Message {

	private int id;
	private String de;
	private String a;
	private String objet;
	private String texte;
	private String dateMessage;

	public Message() {
		super();
		this.id=0;
		this.de = "";
		this.a = "";
		this.objet = "";
		this.texte = "";
		this.dateMessage = "";
	}

	/**
	 * @param codeUtilisateur
	 * @param de
	 * @param a
	 * @param objet
	 * @param texte
	 * @param dateMessage
	 */
	public Message(int id,String de, String a, String objet, String texte, String dateMessage) {
		super();
		this.id=id;
		this.de = de;
		this.a = a;
		this.objet = objet;
		this.texte = texte;
		this.dateMessage = dateMessage;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(String dateMessage) {
		this.dateMessage = dateMessage;
	}
	
	
	
}