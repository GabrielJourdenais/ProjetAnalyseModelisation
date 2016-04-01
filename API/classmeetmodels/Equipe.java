package classmeetmodels;

public class Equipe {

	private int noEquipe;
	private String nomEquipe;
	private String chefEquipe;
	private String sigleCours;
	private int noGroupeCours;
	
	public Equipe()
	{
		this.noEquipe=0;
		this.nomEquipe="";
		this.chefEquipe="";
		this.sigleCours="";
		this.noGroupeCours=0;
	}
	
	public Equipe(int noEquipe, String nomEquipe, String chefEquipe,String sigleCours,int noGroupeCours) {
		super();
		this.noEquipe = noEquipe;
		this.nomEquipe = nomEquipe;
		this.chefEquipe = chefEquipe;
		this.sigleCours = sigleCours;
		this.noGroupeCours = noGroupeCours;
	}

	public int getNoEquipe() {
		return noEquipe;
	}

	public void setNoEquipe(int noEquipe) {
		this.noEquipe = noEquipe;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public String getChefEquipe() {
		return chefEquipe;
	}

	public void setChefEquipe(String chefEquipe) {
		this.chefEquipe = chefEquipe;
	}

	public String getSigleCours() {
		return sigleCours;
	}

	public void setSigleCours(String sigleCours) {
		this.sigleCours = sigleCours;
	}

	public int getNoGroupeCours() {
		return noGroupeCours;
	}

	public void setNoGroupeCours(int noGroupeCours) {
		this.noGroupeCours = noGroupeCours;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		if (chefEquipe == null) {
			if (other.chefEquipe != null)
				return false;
		} else if (!chefEquipe.equals(other.chefEquipe))
			return false;
		if (noEquipe != other.noEquipe)
			return false;
		if (noGroupeCours != other.noGroupeCours)
			return false;
		if (nomEquipe == null) {
			if (other.nomEquipe != null)
				return false;
		} else if (!nomEquipe.equals(other.nomEquipe))
			return false;
		if (sigleCours == null) {
			if (other.sigleCours != null)
				return false;
		} else if (!sigleCours.equals(other.sigleCours))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipe [noEquipe=" + noEquipe + ", nomEquipe=" + nomEquipe + ", chefEquipe=" + chefEquipe
				+ ", sigleCours=" + sigleCours + ", noGroupeCours=" + noGroupeCours + "]";
	}
	
	
	
}
