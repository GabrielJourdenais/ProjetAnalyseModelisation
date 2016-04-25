package classmeetmodels;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evenement {

	private String nom;
	private String description;
	private Date dateHeureEvenement;
	private int dureeM;
	private String lieu;
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public Evenement() {
		super();
		this.nom = "";
		this.description = "";
		this.dateHeureEvenement = new Date();
		this.dureeM=0;
		this.lieu = "";
	}

	public Evenement(String nom, String description,
			String dateHeureEvenement, int dureeM, String lieu) throws ParseException {
		super();
		this.nom = nom;
		this.description = description;
		this.dateHeureEvenement = format.parse(dateHeureEvenement);
		this.dureeM=dureeM;
		this.lieu = lieu;
	}
	
	public Evenement(String nom, String description,
			Date dateHeureEvenement, int dureeM, String lieu){
		super();
		this.nom = nom;
		this.description = description;
		this.dateHeureEvenement = dateHeureEvenement;
		this.dureeM=dureeM;
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

	public String getDateHeureEvenement() {
		return dateFormat.format(dateHeureEvenement);
	}
	
	public void setDateHeureEvenement(String dateHeureEvenement) throws ParseException {
		this.dateHeureEvenement = format.parse(dateHeureEvenement);
	}
	
	public int getDureeM() {
		return dureeM;
	}

	public void setDureeM(int dureeM) {
		this.dureeM = dureeM;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
