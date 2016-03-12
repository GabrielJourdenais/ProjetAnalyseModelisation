package classmeetmodels;

public enum SessionCours {
	H("Hiver"), E("Ete"), A("Automne");

	private final String label;

	SessionCours(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
