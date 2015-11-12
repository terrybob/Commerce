package Commerce;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Panier implements Iterable<LignePanier> {

	protected Collection<LignePanier> contenuPanier;

	public Panier() {
		super();
		setContenuPanier(new LinkedList<LignePanier>());
	}

	public void ajouterProduit(Produit p) {
		for (LignePanier lp : contenuPanier) {
			if (lp.getProduit().equals(p)) {
				lp.setQuantite(lp.getQuantite() + 1);
				return;
			}
		}
		contenuPanier.add(new LignePanier(p, 1));
	}

	public void supprimerProduit(Produit p) {
		contenuPanier.remove(new LignePanier(p, 0));
	}

	public void setQuantite(Produit p, int qt) {
		for (LignePanier lp : contenuPanier) {
			if (lp.getProduit().equals(p))
				lp.setQuantite(qt);
		}
	}

	public double getMontant() {
		double montant = 0;
		for (LignePanier lp : contenuPanier)
			montant = montant + (lp.getQuantite() * lp.getProduit().getPrix());
		return montant;
	}

	public Collection<LignePanier> getContenuPanier() {
		return contenuPanier;
	}

	public void setContenuPanier(Collection<LignePanier> contenuPanier) {
		this.contenuPanier = contenuPanier;
	}

	// ****** HORS FIL ROUGE ******

	public Iterator<LignePanier> iterator() {
		return contenuPanier.iterator();
	}

	public void afficher() {
		Iterator<LignePanier> itr = iterator();
		while (itr.hasNext()) {
			LignePanier lp = itr.next();
			System.out.println(lp);
		}
	}

}
