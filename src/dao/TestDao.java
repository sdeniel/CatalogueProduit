package dao;

public class TestDao {

	public static void main(String[] args) {
		ProduitDaoImpl dao = new ProduitDaoImpl();

		// INSERT (OK)
		// Produit p1 = new Produit("clavier", 90, 120);
		// dao.save(p1);
		// System.out.println(p1.toString());

		// SELECT par mot clé (OK)
		// List<Produit> prod = dao.rechercheParMC("so");
		// for (Produit p : prod)
		// System.out.println(p);

		// SELECT par id (OK)
		// System.out.println(dao.getProduit(2));

		// DELETE par id (OK)
		// dao.deleteProduit(4);

		// UPDATE par produit (OK)
		// dao.update(new Produit("souris Rival X2", 90, 38), 3);
	}

}
