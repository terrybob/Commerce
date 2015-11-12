package Commerce;

public abstract class ChampSpe {

	private String etiquette;
	private Object[] champsDispo;
	private Boolean[] choixUser;

	public ChampSpe(String etiquette, Object[] champsDispo) {
		super();
		setEtiquette(etiquette);
		setChampsDispo(champsDispo);
		setChoixUser(new Boolean[champsDispo.length]);
	}

	public boolean estValide(Produit p) {
		Object valeur = getChamp(p);
		boolean ok = true;
		for (int i = 0; i < champsDispo.length; i++) {
			if (choixUser[i]) {
				ok = false;
				if (valeur.equals(champsDispo[i]))
					return true;
			}
		}
		return ok;
	}

	public void selectChoix(boolean b, int i) {
		choixUser[i] = b;
	}

	public abstract Object getChamp(Produit p);

	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public Object[] getChampsDispo() {
		return champsDispo;
	}

	public void setChampsDispo(Object[] champsDispo) {
		this.champsDispo = champsDispo;
	}

	public Boolean[] getChoixUser() {
		return choixUser;
	}

	public void setChoixUser(Boolean[] choixUser) {
		this.choixUser = choixUser;
	}

}
