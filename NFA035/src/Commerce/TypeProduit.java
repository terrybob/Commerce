package Commerce;

import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JPanel;

import FilRouge.ig.ProdCahierForm;
import FilRouge.ig.ProdCrayonForm;
import FilRouge.ig.ProdStyloForm;
import FilRouge.ig.ProdVideForm;

public enum TypeProduit {
	CRAYON {

		@Override
		protected String terminaison(Produit p) {
			Crayon c = (Crayon) p;
			return c.getDurete().name();
		}

		@Override
		protected Produit newInstance(DonneesInvalidesException er,
				double prix, String intitule, String marque,
				String description, Object[] param) {
			if (param.length != 1) {
				er.ajouterMessage("Nombre de paramètres incohérents");
				return null;
			}
			if (!(param[0] instanceof Crayon.DureteCrayon)) {
				er.ajouterMessage("Dureté non valide");
				return null;
			}
			Crayon.DureteCrayon dc = (Crayon.DureteCrayon) param[0];
			return new Crayon(prix, intitule, marque, description, dc);
		}

		@Override
		protected Collection<ChampSpe> getChampsSpe() {
			Collection<ChampSpe> contenu = new LinkedList<ChampSpe>();
			contenu.add(new ChampSpe("Dureté", Crayon.DureteCrayon.values()) {

				@Override
				public Object getChamp(Produit p) {
					return ((Crayon) p).getDurete();
				}

			});
			return contenu;
		}

		@Override
		public boolean estDeBonType(Produit p) {
			return p instanceof Crayon;
		}

		@Override
		public JPanel getPanel() {
			return new ProdCrayonForm();
		}

	},
	GOMME {

		@Override
		protected String terminaison(Produit p) {
			return "###";
		}

		@Override
		protected Produit newInstance(DonneesInvalidesException er,
				double prix, String intitule, String marque,
				String description, Object[] param) {
			if (param.length != 0) {
				er.ajouterMessage("Nombre de paramètres incohérents");
				return null;
			}
			return new Gomme(prix, intitule, marque, description);
		}

		@Override
		protected Collection<ChampSpe> getChampsSpe() {
			return new LinkedList<ChampSpe>();
		}

		@Override
		public boolean estDeBonType(Produit p) {
			return p instanceof Gomme;
		}

		@Override
		public JPanel getPanel() {
			return new ProdVideForm();
		}

	},
	STYLO {

		@Override
		protected String terminaison(Produit p) {
			Stylo s = (Stylo) p;
			return s.getType().name();
		}

		@Override
		protected Produit newInstance(DonneesInvalidesException er,
				double prix, String intitule, String marque,
				String description, Object[] param) {
			if (param.length != 2) {
				er.ajouterMessage("Nombre de paramètres incohérents");
				return null;
			}
			if (!(param[0] instanceof String)) {
				er.ajouterMessage("Couleur de stylo non valide");
				return null;
			}
			if (!(param[1] instanceof Stylo.TypeStylo)) {
				er.ajouterMessage("Type non valide");
				return null;
			}
			String couleur = (String) param[0];
			Stylo.TypeStylo typeStylo = (Stylo.TypeStylo) param[1];
			return new Stylo(prix, intitule, marque, description, couleur,
					typeStylo);
		}

		@Override
		protected Collection<ChampSpe> getChampsSpe() {
			Collection<ChampSpe> contenu = new LinkedList<ChampSpe>();
			contenu.add(new ChampSpe("Couleur", new String[] { "bleu", "vert",
					"rouge", "noir" }) {

				@Override
				public Object getChamp(Produit p) {
					return ((Stylo) p).getCouleur();
				}

			});
			contenu.add(new ChampSpe("Type", Stylo.TypeStylo.values()) {

				@Override
				public Object getChamp(Produit p) {
					return ((Stylo) p).getType();
				}

			});
			return contenu;
		}

		@Override
		public boolean estDeBonType(Produit p) {
			return p instanceof Stylo;
		}

		@Override
		public JPanel getPanel() {
			return new ProdStyloForm();
		}

	},
	CAHIER {

		@Override
		protected String terminaison(Produit p) {
			Cahier c = (Cahier) p;
			return c.getType().name();
		}

		@Override
		protected Produit newInstance(DonneesInvalidesException er,
				double prix, String intitule, String marque,
				String description, Object[] param) {
			if (param.length != 6) {
				er.ajouterMessage("Nombre de paramètres incohérents");
				return null;
			}
			if (!(param[0] instanceof Cahier.CarreauCahier)) {
				er.ajouterMessage("Type de carreaux non valide");
				return null;
			}
			if (!(param[1] instanceof Cahier.TypeCahier)) {
				er.ajouterMessage("Type de cahier non valide");
				return null;
			}
			if (!(param[2] instanceof String)) {
				er.ajouterMessage("Couleur de cahier non valide");
				return null;
			}
			if (!(param[3] instanceof Integer)) {
				er.ajouterMessage("Grammage non valide");
				return null;
			}
			if (!(param[4] instanceof String)) {
				er.ajouterMessage("Dimensions non valide");
				return null;
			}
			if (!(param[5] instanceof Integer)) {
				er.ajouterMessage("Nombre de feuilles non valide");
				return null;
			}
			Cahier.CarreauCahier cc = (Cahier.CarreauCahier) param[0];
			Cahier.TypeCahier tc = (Cahier.TypeCahier) param[1];
			String coul = (String) param[2];
			int gram = (int) param[3];
			String dim = (String) param[4];
			int nbF = (int) param[5];
			return new Cahier(prix, intitule, marque, description, cc, tc,
					coul, gram, dim, nbF);
		}

		@Override
		protected Collection<ChampSpe> getChampsSpe() {
			Collection<ChampSpe> contenu = new LinkedList<ChampSpe>();
			contenu.add(new ChampSpe("Carreaux", Cahier.CarreauCahier.values()) {

				@Override
				public Object getChamp(Produit p) {
					return ((Cahier) p).getType();
				}

			});
			contenu.add(new ChampSpe("Type", Cahier.TypeCahier.values()) {

				@Override
				public Object getChamp(Produit p) {
					return ((Cahier) p).getType();
				}

			});
			contenu.add(new ChampSpe("Couleur", new String[] { "bleu", "vert",
					"rouge", "noir" }) {

				@Override
				public Object getChamp(Produit p) {
					return ((Cahier) p).getType();
				}

			});
			contenu.add(new ChampSpe("Grammage", new Integer[] { 70, 80, 90 }) {

				@Override
				public Object getChamp(Produit p) {
					return ((Cahier) p).getType();
				}

			});
			contenu.add(new ChampSpe("Dimensions", new String[] { "17 x 22",
					"21 x 29.7", "24 x 32" }) {

				@Override
				public Object getChamp(Produit p) {
					return ((Cahier) p).getType();
				}

			});
			contenu.add(new ChampSpe("Pages",
					new Integer[] { 48, 96, 160, 192 }) {

				@Override
				public Object getChamp(Produit p) {
					return ((Cahier) p).getType();
				}

			});
			return contenu;
		}

		@Override
		public boolean estDeBonType(Produit p) {
			return p instanceof Cahier;
		}

		@Override
		public JPanel getPanel() {
			return new ProdCahierForm();
		}

	},
	LOT {

		@Override
		protected String terminaison(Produit p) {
			return "###";
		}

		@Override
		protected Produit newInstance(DonneesInvalidesException er,
				double prix, String intitule, String marque,
				String description, Object[] param) {
			if (param.length != 0) {
				er.ajouterMessage("Nombre de paramètres incohérents");
				return null;
			}
			return new Gomme(prix, intitule, marque, description);
		}

		@Override
		protected Collection<ChampSpe> getChampsSpe() {
			return new LinkedList<ChampSpe>();
		}

		@Override
		public boolean estDeBonType(Produit p) {
			return p instanceof Lot;
		}

		@Override
		public JPanel getPanel() {
			return new ProdVideForm();
		}

	};

	public String prefixe() {
		return this.name().substring(0, 3);
	}

	public String creerReference(Produit p) {
		return this.prefixe()
				+ String.format("%06d", SerialGenerator.getInstanceProduit()
						.getCompteur()) + this.terminaison(p);
	}

	public Produit monterProduit(String intitule, String marque,
			String description, double prix, Object... param)
			throws DonneesInvalidesException {
		DonneesInvalidesException er = new DonneesInvalidesException();
		Produit p = newInstance(er, prix, intitule, marque, description, param);
		if (intitule == null || intitule == "")
			er.ajouterMessage("Paramètre non valide : Intitulé");
		if (marque == null || marque == "")
			er.ajouterMessage("Paramètre non valide : Marque");
		if (prix <= 0)
			er.ajouterMessage("Paramètre non valide : Prix");
		if (er.aMessage())
			throw er;
		return p;
	}

	protected abstract String terminaison(Produit p);

	protected abstract Produit newInstance(DonneesInvalidesException er,
			double prix, String intitule, String marque, String description,
			Object[] param);

	protected abstract Collection<ChampSpe> getChampsSpe();

	public abstract boolean estDeBonType(Produit p);

	public abstract JPanel getPanel();

}
