package Commerce;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialGenerator implements Serializable {

	private static final long serialVersionUID = 1L;

	private static SerialGenerator instanceProduit;
	private static SerialGenerator instanceCommande;
	private Integer compteur = 0;

	private SerialGenerator() {
	}

	public static SerialGenerator getInstanceProduit() {
		if (instanceProduit == null)
			instanceProduit = new SerialGenerator();
		return instanceProduit;
	}

	public static SerialGenerator getInstanceCommande() {
		if (instanceCommande == null)
			instanceCommande = new SerialGenerator();
		return instanceCommande;
	}

	public static void enregistrerCompteur(ObjectOutputStream oos)
			throws IOException {
		oos.writeObject(instanceProduit);
		oos.writeObject(instanceCommande);
	}

	public static void restituerCompteur(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		instanceProduit = (SerialGenerator) ois.readObject();
		instanceCommande = (SerialGenerator) ois.readObject();
	}

	public int getCompteur() {
		return ++this.compteur;
	}

	public void setCompteur(Integer compteur) {
		this.compteur = compteur;
	}

}
