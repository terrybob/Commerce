package com.wa.trade;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<LigneCommande> ctn;
	private String numero;
	private Date date;
	private Client client;
	private boolean validation;
	private boolean livraison;

	public Commande(Client cl) {
		super();
		setClient(cl);
		setNumero(""
				+ new SimpleDateFormat("yyyyMM", Locale.FRANCE)
						.format(new Date())
				+ String.format("%04d", SerialGenerator.getInstanceCommande()
						.getCompteur()));
		setDate(date);
		setValidation(false);
		setLivraison(false);
		ctn = new HashSet<LigneCommande>();
		for (LignePanier lp : cl.getPanier())
			ctn.add(new LigneCommande(lp));
		setContenu(ctn);
	}

	public void livrer() throws Exception {
		for (LignePanier lp : ctn) {
			if (isValidation()
					&& lp.getProduit().getqCond() - lp.getQuantite() >= 0) {
				lp.getProduit().setqAct(
						lp.getProduit().getqAct() - lp.getQuantite());
				lp.getProduit().setqCond(
						lp.getProduit().getqCond() - lp.getQuantite());
			} else
				throw new Exception();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((ctn == null) ? 0 : ctn.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + (livraison ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (ctn == null) {
			if (other.ctn != null)
				return false;
		} else if (!ctn.equals(other.ctn))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (livraison != other.livraison)
			return false;
		return true;
	}

	public double getMontant() {
		double montant = 0;
		for (LigneCommande lc : ctn)
			montant = montant + lc.getQuantite() * lc.getProduit().getPrix();
		return montant;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public boolean isLivraison() {
		return livraison;
	}

	public void setLivraison(boolean livraison) {
		this.livraison = livraison;
	}

	public Collection<LigneCommande> getContenu() {
		return ctn;
	}

	public void setContenu(Collection<LigneCommande> contenuCommande) {
		this.ctn = contenuCommande;
	}
}
