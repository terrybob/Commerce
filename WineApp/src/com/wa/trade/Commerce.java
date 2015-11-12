package com.wa.trade;

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
import java.util.HashSet;

public class Commerce implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Commerce instance;
	private static File sauvegarde = new File("WineApp.dat");
	private ListeClients listeClients = new ListeClients();
	private CarnetCommandes carnetCommandes = new CarnetCommandes();
	private Stock stock = new Stock();

	private Commerce() {
	}

	public static Commerce getInstance() {
		if (instance == null)
			instance = new Commerce();
		return instance;
	}

	public static void exportToFile() throws IOException {
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

	public static void importFromFile() throws IOException,
			ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(sauvegarde);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			instance = (Commerce) ois.readObject();
			SerialGenerator.restituerCompteur(ois);
		} finally {
			if (ois != null)
				ois.close();
		}
	}

	public static Collection<Produit> importStock()
			throws ClassNotFoundException, IOException {
		importFromFile();
		Collection<Produit> coll = new HashSet<Produit>();
		for (Produit p : getInstance().getStock().getContenu())
			coll.add(p);
		return coll;
	}

	public static Collection<Client> importClient()
			throws ClassNotFoundException, IOException {
		importFromFile();
		Collection<Client> coll = new HashSet<Client>();
		for (Client c : getInstance().getListeClients().getContenu())
			coll.add(c);
		return coll;
	}

	public void ajouterClient(Client c) {
		listeClients.ajouter(c);
	}

	public void ajouterCommande(Commande cmd) {
		carnetCommandes.ajouter(cmd);
	}

	public void ajouterProduit(Produit p) {
		stock.ajouter(p);
	}

	public Client chercherClient(String email) {
		return listeClients.chercher(email);
	}

	public Collection<Commande> chercherNonValidees() {
		return carnetCommandes.chercherNonValidees();
	}

	public Collection<Commande> chercherNonLivrees() {
		return carnetCommandes.chercherNonValidees();
	}

	public Produit chercherProduit(Produit p) {
		return stock.chercher(p);
	}

	public Produit chercherProduit(String intitule) {
		return stock.chercher(intitule);
	}

	public ListeClients getListeClients() {
		return listeClients;
	}

	public void setListeClients(ListeClients listeClients) {
		this.listeClients = listeClients;
	}

	public CarnetCommandes getCarnetCommande() {
		return carnetCommandes;
	}

	public void setCarnetCommandes(CarnetCommandes carnet) {
		this.carnetCommandes = carnet;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public static File getSauvegarde() {
		return sauvegarde;
	}

	public static void setSauvegarde(File sauvegarde) {
		Commerce.sauvegarde = sauvegarde;
	}

}
