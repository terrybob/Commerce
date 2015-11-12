package com.wa.trade;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class Panier implements Iterable<LignePanier>{
	protected Collection<LignePanier> ctn;

	public Panier() {
		super();
		setContenu(new HashSet<LignePanier>());
	}

	public void ajouterProduit(Produit p) {
		for (LignePanier lp : ctn) {
			if (lp.getProduit().equals(p)) {
				lp.setQuantite(lp.getQuantite() + 1);
				return;
			}
		}
		ctn.add(new LignePanier(p, 1));
	}

	public void supprimerProduit(Produit p) {
		ctn.remove(new LignePanier(p, 0));
	}

	public void setQuantite(Produit p, int qt) {
		for (LignePanier lp : ctn) {
			if (lp.getProduit().equals(p))
				lp.setQuantite(qt);
		}
	}

	public double getMontant() {
		double montant = 0;
		for (LignePanier lp : ctn)
			montant = montant + (lp.getQuantite() * lp.getProduit().getPrix());
		return montant;
	}

	public Collection<LignePanier> getContenu() {
		return ctn;
	}

	public void setContenu(Collection<LignePanier> contenuPanier) {
		this.ctn = contenuPanier;
	}

	@Override
	public Iterator<LignePanier> iterator() {
		return ctn.iterator();
	}
}
