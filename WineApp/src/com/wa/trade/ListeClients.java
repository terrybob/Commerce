package com.wa.trade;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ListeClients implements Iterable<Client>, Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<Client> ctn;

	public ListeClients() {
		super();
		setContenu(new HashSet<Client>());
	}

	public void ajouter(Client c) {
		ctn.add(c);
	}

	public Client chercher(String email) {
		for (Client c : ctn) {
			if (c.a(email))
				return c;
		}
		return null;
	}

	public Collection<Client> getContenu() {
		return ctn;
	}

	public void setContenu(Collection<Client> contenu) {
		this.ctn = contenu;
	}

	@Override
	public Iterator<Client> iterator() {
		return ctn.iterator();
	}

}