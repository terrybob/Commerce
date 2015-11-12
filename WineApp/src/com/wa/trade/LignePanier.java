package com.wa.trade;

import java.io.Serializable;

public class LignePanier implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produit produit;
	private int quantite;

	public LignePanier(Produit p, int quantite) {
		super();
		setProduit(p);
		setQuantite(quantite);
	}

	public LignePanier() {
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
