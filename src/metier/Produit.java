package metier;

public class Produit {

	private int id, quantite;
	private String designation;
	private double prix;

	public Produit() {
		super();
	}

	public Produit(String designation, int quantite, double prix) {
		super();
		this.designation = designation;
		this.quantite = quantite;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", quantite=" + quantite + ", designation=" + designation + ", prix=" + prix + "]";
	}

}
