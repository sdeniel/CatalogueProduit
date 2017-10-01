package dao;

import java.util.List;

import metier.Produit;

public interface IProduitDao {

	public Produit save(Produit p);

	public List<Produit> rechercheParMC(String mc);

	public Produit getProduit(int id);

	public Produit update(Produit p, int id);

	public void deleteProduit(int id);

}
