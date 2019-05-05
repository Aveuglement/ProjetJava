package NotesElevesProfesseurs;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Promotion
{
    private String nom;
    private List<Eleve> eleves;

    //Constructeur d'initialisation
    public Promotion(String nom)
    {
        this.nom = nom;
        this.eleves = new ArrayList<>();
    }

    //Accesseur et mutateur pour le nom
    public String getNom()
    {
        return nom;
    }

    public void add(Eleve eleve)
    {
        eleves.add(eleve);
        eleve.setPromotion(this);
    }

    //Accesseur en lecture des élèves qui retourne une copie
    public List<Eleve> getEleves()
    {
        return new ArrayList<>(eleves);
    }

    //Méthode qui permet de rechercher un élève dans la promotion en fonction de son id
    public Eleve rechercher(int id)
    {
        for (Eleve eleve : eleves)
        {
            if (eleve.getId() == id) {
                return eleve;
            }
        }
        return null;
    }

    public void triEleve(int sens, int type)
    {
        Collections.sort(eleves, new Compare(sens, type));
    }

    //Méthode qui permet de calculer la moyenne des notes dans une matière d'une promotion
    public double moyenne(String matiere) throws IllegalStateException
    {
        double somme = 0.0;
        int compteur = 0;
        for (Eleve eleve : eleves)
        {
            if (eleve.evaluations.isEmpty()) {
                throw new IllegalStateException("L'élève n'a aucune note !");
            }
            for (Evaluation eval : eleve.evaluations)
            {
                if (eval.getMatiere() == matiere) {
                    somme += eval.getNote();
                    compteur ++;
                }
            }
        }
        return somme/compteur;
    }

    //Méthode qui permet de calculer la médiane des notes dans une matière d'une promotion
    public double mediane(String matiere) throws IllegalStateException
    {
        ArrayList<Double> evalMatiere = new ArrayList<Double>();
        for (Eleve eleve : eleves) {
            if (eleve.evaluations.isEmpty()) {
                throw new IllegalStateException("L'élève n'a aucune note !");
            }
            for (Evaluation eval : eleve.evaluations) {
                if (eval.getMatiere() == matiere) {
                    evalMatiere.add(eval.getNote());
                }
            }
        }
        Collections.sort(evalMatiere);
        int compteur = evalMatiere.size();
        if (evalMatiere.size() % 2 == 0) {
            compteur = compteur / 2;
            double resultat = evalMatiere.get(compteur - 1) + evalMatiere.get(compteur);
            return resultat / 2;
        } else {
            compteur = ((compteur + 1) / 2);
            return evalMatiere.get(compteur - 1);
        }
    }
    //Méthode qui permet de calculer la note maximal et minimum parmis tous les élèves d'une promotion
    public double valeur(String matiere, String valeur) throws IllegalStateException
    {
        ArrayList<Double> evalMatiere = new ArrayList<Double>();
        for (Eleve eleve : eleves) {
            if (eleve.evaluations.isEmpty()) {
                throw new IllegalStateException("L'élève n'a aucune note !");
            }
            for (Evaluation eval : eleve.evaluations)
            {
                if (eval.getMatiere() == matiere) {
                    evalMatiere.add(eval.getNote());
                }
            }
        }
        Collections.sort(evalMatiere);
        if (valeur == "max") {
            int index = evalMatiere.size();
            return evalMatiere.get(index - 1);
        }
        if (valeur == "min") {
            return evalMatiere.get(0);
        }
        return 10.0; //Valeur par défaut des valeurs
    }
}