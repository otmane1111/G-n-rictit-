package otmane;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par ID");
            System.out.println("3. Ajouter un produit");
            System.out.println("4. Supprimer un produit par ID");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    for (Produit p : metier.getAll()) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'ID du produit à rechercher : ");
                    long idRecherche = scanner.nextLong();
                    Produit produitTrouve = metier.findById(idRecherche);
                    if (produitTrouve != null) {
                        System.out.println("Produit trouvé : " + produitTrouve);
                    } else {
                        System.out.println("Aucun produit avec cet ID.");
                    }
                    break;

                case 3:
                    System.out.print("ID : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consomme la ligne
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la ligne
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Stock : ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idSupp = scanner.nextLong();
                    metier.delete(idSupp);
                    System.out.println("Produit supprimé (s'il existait).");
                    break;

                case 5:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
