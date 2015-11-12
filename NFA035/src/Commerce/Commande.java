package Commerce;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<LigneCommande> contenuCommande;
	private String numero;
	private Date date;
	private Client client;
	private boolean validation;

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
		contenuCommande = new LinkedList<LigneCommande>();
		for (LignePanier lp : cl.getPanier())
			contenuCommande.add(new LigneCommande(lp));
		setContenuCommande(contenuCommande);
	}

	@Override
	public String toString() {
		return "Commande [N°="
				+ getNumero()
				+ ", Client="
				+ getClient()
				+ ", Date="
				+ new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE)
						.format(new Date()) + ", Validation=" + isValidation()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result
				+ ((contenuCommande == null) ? 0 : contenuCommande.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + (validation ? 1231 : 1237);
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
		if (contenuCommande == null) {
			if (other.contenuCommande != null)
				return false;
		} else if (!contenuCommande.equals(other.contenuCommande))
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
		if (validation != other.validation)
			return false;
		return true;
	}

	public double getMontant() {
		double montant = 0;
		for (LigneCommande lc : contenuCommande)
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

	public Collection<LigneCommande> getContenuCommande() {
		return contenuCommande;
	}

	public void setContenuCommande(Collection<LigneCommande> contenuCommande) {
		this.contenuCommande = contenuCommande;
	}

	// ****** HORS FIL ROUGE ******

	public void afficher() {
		for (LigneCommande lc : contenuCommande)
			System.out.println(lc);
	}

}
