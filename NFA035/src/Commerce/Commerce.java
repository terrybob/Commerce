package Commerce;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

public class Commerce implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Commerce instance;
	private static File sauvegarde = new File("commerce.dat");
	private ListeClient listeClient = new ListeClient();
	private CarnetCommande carnetCommande = new CarnetCommande();
	private Catalogue catalogue = new Catalogue();

	private Commerce() {
	}

	public static Commerce getInstance() {
		if (instance == null)
			instance = new Commerce();
		return instance;
	}

	public static void enregistrerDonnees() throws IOException {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(sauvegarde);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);

			oos.writeObject(instance);
			SerialGenerator.enregistrerCompteur(oos);
			oos.flush();
		} finally {
			if (oos != null)
				oos.close();
		}
	}

	public static void restituerDonnees() throws IOException,
			ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(sauvegarde);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			instance = (Commerce) ois.readObject();
			SerialGenerator.restituerCompteur(ois);
			// test affichage
			instance.getListeClient().afficher();
			instance.getCarnetCommande().afficher();
			instance.getCatalogue().afficher();
		} finally {
			if (ois != null)
				ois.close();
		}
	}

	public void ajouterCommande(Commande cmd) {
		carnetCommande.ajouter(cmd);
	}

	public Collection<Commande> chercherNonValidees() {
		return carnetCommande.chercherNonValidees();
	}

	public void ajouterProduit(Produit p) {
		catalogue.ajouter(p);
	}

	public void ajouterClient(Client c) {
		listeClient.ajouter(c);
	}

	public void chercherClient(String email) {
		listeClient.chercher(email);
	}

	public int size() {
		return getCatalogue().getContenuCatalogue().size();
	}

	public Produit get(int index) {
		return ((Commerce) getCatalogue().getContenuCatalogue()).get(index);
	}

	public int indexOf(Object o) {
		return ((Commerce) getCatalogue().getContenuCatalogue()).indexOf(o);
	}

	public ListeClient getListeClient() {
		return listeClient;
	}

	public void setListeClient(ListeClient listeClient) {
		this.listeClient = listeClient;
	}

	public CarnetCommande getCarnetCommande() {
		return carnetCommande;
	}

	public void setCarnetCommande(CarnetCommande carnet) {
		this.carnetCommande = carnet;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public static File getSauvegarde() {
		return sauvegarde;
	}

	public static void setSauvegarde(File sauvegarde) {
		Commerce.sauvegarde = sauvegarde;
	}

}
