package com.wa.trade;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	String nom;
	String prenom;
	String adresse1;
	String adresse2;
	String codePostal;
	String ville;
	String pays;
	String tel;
	String email;
	transient private Panier panier = new Panier();

	public Client(String nom, String prenom, String adresse1, String adresse2,
			String codePostal, String ville, String pays, String tel, String email) {
		super();
		setNom(nom);
		setPrenom(prenom);
		setAdresse1(adresse1);
		setAdresse2(adresse2);
		setCodePostal(codePostal);
		setVille(ville);
		setPays(pays);
		setTel(tel);
		setEmail(email);
	}

	public Client() {
	}
	
	public boolean a(String email) {
		if (email.equals(getEmail()))
			return true;
		return false;
	}

	public Client newInstance(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adr1 = request.getParameter("adr1");
		String adr2 = request.getParameter("adr2");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String pays = request.getParameter("pays");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		return new Client(nom, prenom, adr1, adr2, cp, ville, pays, tel, email);
	}

	public void ajouterProduit(Produit p) {
		panier.ajouterProduit(p);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
}
