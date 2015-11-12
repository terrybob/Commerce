package com.wa.trade;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CarnetCommandes implements Iterable<Commande>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Collection<Commande> ctn;

	public CarnetCommandes() {
		super();
		setContenu(new HashSet<Commande>());
	}

	public void ajouter(Commande c) {
		ctn.add(c);
	}

	public Collection<Commande> chercherNonValidees() {
		Collection<Commande> coll = new HashSet<Commande>();
		for (Commande cmd : ctn) {
			if (cmd.isValidation() == false)
				coll.add(cmd);
		}
		return coll;
	}
	
	public Collection<Commande> chercherNonLivrees() {
		Collection<Commande> coll = new HashSet<Commande>();
		for (Commande cmd : ctn) {
			if (cmd.isLivraison() == false)
				coll.add(cmd);
		}
		return coll;
	}

	public Collection<Commande> getContenu() {
		return ctn;
	}

	public void setContenu(Collection<Commande> contenu) {
		this.ctn = contenu;
	}

	@Override
	public Iterator<Commande> iterator() {
		return ctn.iterator();
	}

}
