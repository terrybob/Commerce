package com.wa.trade;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Stock implements Iterable<Produit>, Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	protected Collection<Produit> ctn;
	

	public Stock() {
		super();
		setContenu(new HashSet<Produit>());
	}
	
	public void ajouter(Produit p) {
		ctn.add(p);
	}
	
	public Produit chercher(Produit prod) {
		for (Produit p : ctn) {
			if (p.equals(prod))
				return p;
		}
		return null;
	}
	
	public Produit chercher(String intitule) {
		for (Produit p : ctn) {
			if (p.a(intitule))
				return p;
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ctn == null) ? 0 : ctn.hashCode());
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
		Stock other = (Stock) obj;
		if (ctn == null) {
			if (other.ctn != null)
				return false;
		} else if (!ctn.equals(other.ctn))
			return false;
		return true;
	}

	public Collection<Produit> getContenu() {
		return ctn;
	}

	public void setContenu(Collection<Produit> stock) {
		this.ctn = stock;
	}

	@Override
	public Iterator<Produit> iterator() {
		return ctn.iterator();
	}
}
