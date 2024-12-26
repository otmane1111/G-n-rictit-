package otmane;
import java.util.ArrayList;
import java.util.List;

class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit p) {
        produits.add(p);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit produit = findById(id);
        if (produit != null) {
            produits.remove(produit);
        }
    }
}