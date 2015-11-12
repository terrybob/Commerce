package Commerce;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Catalogue implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<Produit> contenuCatalogue;

	public Catalogue() {
		super();
		setContenuCatalogue(new LinkedList<Produit>());
	}

	public Collection<Produit> extraireProduit(TypeProduit typeProd,
			double prix, String intitule, String marque, String description,
			Collection<ChampSpe> param) {
		Collection<Produit> ctn = new LinkedList<Produit>();
		for (Produit p : contenuCatalogue) {
			if (!typeProd.estDeBonType(p))
				continue;
			if (prix > 0 && p.getPrix() != prix)
				continue;
			if ((!intitule.isEmpty()) && !p.getIntitule().equals(intitule))
				continue;
			boolean ok = true;
			for (ChampSpe csp : param) {
				if (!csp.estValide(p)) {
					ok = false;
					break;
				}
			}
			if (ok)
				ctn.add(p);
		}
		return ctn;
	}

	public void ajouter(Produit p) {
		contenuCatalogue.add(p);
	}

	public Collection<Produit> getContenuCatalogue() {
		return contenuCatalogue;
	}

	public void setContenuCatalogue(Collection<Produit> ctnCat) {
		contenuCatalogue = ctnCat;
	}

	public Iterator<Produit> iterator() {
		return contenuCatalogue.iterator();
	}

	// ****** HORS FIL ROUGE ******

	public void afficher() {
		Iterator<Produit> itr = iterator();
		while (itr.hasNext()) {
			Produit p = itr.next();
			System.out.println(p);
		}
	}

}
