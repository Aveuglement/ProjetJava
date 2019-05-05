package NotesElevesProfesseurs;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Eleve extends NomPrenom
{
    private int id;
    private static int NUMERO = 1;
    private int jour;
    private int mois;
    private int annee;
    public ArrayList<Evaluation> evaluations;
    public static final int NB_EVALUATIONS = 10;
    private Date naissance;
    private Promotion promotion;
    private double moyenne;
    private double mediane;

    //Constructeur d'initialisation
    public Eleve(String prenom, String nom, int jour, int mois, int annee)
    {
        super(prenom,nom);
        this.naissance = new Date(jour, mois, annee);
        setId(id);
        evaluations = new ArrayList<Evaluation>();
    }

    //Accesseur et mutateur pour l'identifiant
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = Eleve.NUMERO;
        Eleve.NUMERO++;
    }

    //Méthode qui permet de réinitialiser l'affectation de l'id
    public static void resetId()
    {
        Eleve.NUMERO = 1;
    }

    //Accesseur pour le prénom
    public String getPrenom()
    {
        return prenom;
    }


    //Accesseur pour le nom
    public String getNom()
    {
        return nom;
    }

    //Accesseur et mutateur pour la promotion
    public String getPromotion()
    {
        return promotion.getNom();
    }
    public void setPromotion(Promotion promotion)
    {
        this.promotion = promotion;
    }

    //Accesseur pour la moyenne
    public double getMoyenne()
    {
        try {
            moyenne = moyenne();
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException error moyenne ! ");
        }
        return moyenne ;
    }

    //Accesseur pour la médiane
    public double getMediane()
    {
        try {
            mediane = mediane();
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException error mediane ! ");
        }
        return mediane;
    }

    //Accesseur pour la note d'une matière d'un élève
    public double getNote(String matiere)
    {
        for (Evaluation eval : evaluations) {
                if (eval.getMatiere() == matiere) {
                    return eval.getNote();
                }
            }

        return 0.0;
    }

    //Méthode qui retourne la liste des évaluations
    public List<Evaluation> getEvaluation()
    {
        return evaluations;
    }

    //Méthode qui permet de calculer la moyenne des évaluations d'un élève
    public double moyenne() throws IllegalStateException
    {
        double somme = 0.0;
        if (evaluations.isEmpty()) {
            throw new IllegalStateException("L'élève n'a aucune note !");
        }
        for (Evaluation eval : evaluations) {
            somme += eval.getNote();
        }
        return somme/evaluations.size();
    }

    //Méthode qui permet de calculer la médiane des évaluations d'un élève
    public double mediane() throws IllegalStateException
    {
        if (evaluations.isEmpty()) {
            throw new IllegalStateException("L'élève n'a aucune note !");
        }
        Collections.sort(evaluations);
        int compteur = evaluations.size();
        if (evaluations.size()%2 == 0) {
            compteur = compteur/2;
            double resultat = (evaluations.get(compteur - 1).getNote() + evaluations.get(compteur).getNote());
            return resultat/2;
        }
        else {
            compteur = ((compteur + 1)/ 2);
            return evaluations.get(compteur - 1).getNote();
        }
    }

    //Méthode qui range dans une instance de la classe HashSet tous les professeurs correcteurs
    public Set<Professeur>getCorrecteurs()
    {
        HashSet<Professeur> correcteurs = new HashSet<Professeur>();
        for (Evaluation eval : evaluations)
        {
            correcteurs.add(eval.getProfesseur());
        }
        return correcteurs;
    }

    //Méthode surchargée qui permet d'afficher les différentes caractéristiques de l'élève
    @Override
    public String toString()
    {
        String ret = "";
        StringBuilder notes = new StringBuilder();
        for(Evaluation eval : evaluations)
        {
            notes.append(eval.getMatiere()).append(" ").append(eval.getNote()).append(" ");
        }
        if (promotion == null) {
            try {
                ret += "\n" + super.toString() + " Id : " + this.getId() + "\nNotes : " + notes + "\nMoyenne = " + moyenne() + "\nMediane = " + mediane() + "\nCorrecteur(s): " + getCorrecteurs();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                ret += "\n" + super.toString() + " Id : " + this.getId() + "\nPromotion: " + this.promotion.getNom() + "\nNotes : " + notes +  "\nMoyenne = " + moyenne() + "\nMediane = " + mediane() + "\nCorrecteur(s): " + getCorrecteurs();
            } catch(IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 3 + id;
        hash += super.hashCode();
        hash = hash * 12 + naissance.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Eleve) {
            if (id == ((Eleve) obj).id) {
                return true;
            }
        }
        return false;
    }

    //Méthode qui permet de comparer la moyenne entre deux objets
    public int compareToMoyenne(Object obj)
    {
        assert obj instanceof Eleve : "L'objet donné en paramètre n'est pas de type Eleve !";
        Eleve eleve = (Eleve) obj;
        try {
            double a = this.moyenne();
            double b = eleve.moyenne();
            if (a > b) {
                return 1;
            }
            if (a == b) {
                return 0;
            }
            if (a < b) {
                return -1;
            }
        } catch(IllegalStateException e) {
            System.out.println("L'élève n'a pas de notes !");
        }
        return 0;
    }

    //Méthode qui permet de comparer la médiane entre deux objets
    public int compareToMediane(Object obj) {
        assert obj instanceof Eleve : "L'objet donné en paramètre n'est pas de type Eleve !";
        Eleve eleve = (Eleve) obj;
        try {
            double a = this.mediane();
            double b = eleve.mediane();
            if (a > b) {
                return 1;
            }
            if (a == b) {
                return 0;
            }
            if (a < b) {
                return -1;
            }
        } catch (IllegalStateException e) {
            System.out.println("L'élève n'a pas de notes !");
        }
        return 0;
    }

    //Méthode qui permet de recherhcher la ième evaluation d'un élève
    public int rechercherEvaluation(Professeur professeur, String matiere)
    {
        int indice, compteur = evaluations.size();
        for (indice = 0; indice < compteur; indice ++)
        {
            Evaluation evaluation = evaluations.get(indice);
            if (evaluation.has(professeur, matiere) == true) {
                return indice;
            }
        }
        return -1;
    }
}