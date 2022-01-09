package Controller;

public class Produit {
	private int idProduit;
	private String nomProduit;
	private float prixProduit;
	public float getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}
	private int idFournisseur;
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public Produit(int idProduit, String nomProduit, float prixProduit, int idFournisseur) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.idFournisseur = idFournisseur;
	}
	
	

}
