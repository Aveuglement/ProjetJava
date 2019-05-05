package NotesElevesProfesseurs;

public class Professeur extends NomPrenom
{

    private int id;
    private static int NUMERO = 1;

    // Constructeur d'initialisation
    public Professeur(String prenom, String nom)
    {
        super(prenom,nom);
        setId(id);
    }

    //Accesseur pour le nom du professeur
    public String getNom()
    {
        return nom;
    }

    //Accesseur et mutateur pour l'identifiant du professeur
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = Professeur.NUMERO;
        Professeur.NUMERO++;
    }
    
    //Méthode qui permet de réinitialiser l'affectation de l'id
    public static void resetId()
    {
        Professeur.NUMERO = 1;
    }

    //Méthode qui permet au professeur de rechercher un élève dans la promotion en fonction de son id
    public Eleve rechercher(Promotion promotion, int id)
    {
        return promotion.rechercher(id);
    }

    //Permet à un professeur de modifier une note
    public void setNote(Promotion promotion, int id, double note, int indice, String matiere) throws IllegalStateException
    {
        Eleve eleve = rechercher(promotion, id);
        Evaluation eval = null;
        if (eleve == null) {
            throw new IllegalStateException("Eleve inexistant dans la promotion !");
        }
        if(indice >= 0) {
            System.out.print("\nModification de la note: ");
            eleve.getEvaluation().get(indice).setNote(note);
            System.out.print(eleve.getEvaluation().get(indice).getNote());
        }
        else {
            eval = new Evaluation(eleve, this, matiere, note);
        }
    }

    @Override // Décris un professeur
    public String toString()
    {
        return super.toString();
    }
}
