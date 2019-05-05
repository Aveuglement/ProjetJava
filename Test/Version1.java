package Test;

import java.util.ArrayList;
import java.util.List;

import NotesElevesProfesseurs.Eleve;
import NotesElevesProfesseurs.IllegalStateException;
import NotesElevesProfesseurs.Professeur;
import NotesElevesProfesseurs.Promotion;
import NotesElevesProfesseurs.Evaluation;

public class Version1
{
    public static void main()
    {
        List<Eleve> eleves = new ArrayList<>();
        List<Professeur> professeurs = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();

        //Déclaration des élèves
        eleves.add(new Eleve("Alice", "Dupont", 1, 1, 1998)); //eleves.get(0)
        eleves.add(new Eleve("Bob", "Bertrand", 3, 5, 1998)); //eleves.get(1)
        eleves.add(new Eleve("Casper", "Dupuit", 13, 12, 1998)); //eleves.get(2)
        eleves.add(new Eleve ("Donald", "Mac", 26, 7, 1998)); //eleves.get(3)
        eleves.add( new Eleve("Elodie", "Hugo", 17, 4, 1998)); //eleves.get(4)
        eleves.add(new Eleve("Florian", "Lee", 9, 4, 1998)); //eleves.get(5)
        eleves.add(new Eleve("Gaston", "Lagaffe", 19, 2, 1997)); //eleves.get(6)
        eleves.add(new Eleve("Hugo", "Dior", 14, 9, 1997)); //eleves.get(7)
        eleves.add(new Eleve("Julien", "Gautier", 22, 3, 1999)); //eleves.get(8)
        eleves.add(new Eleve("Killian", "Souchet", 5, 11, 1997)); //eleves.get(9)
        eleves.add(new Eleve("Lucie", "Fight", 10, 10, 1997)); //eleves.get(10)
        eleves.add(new Eleve("Morgane", "Pixie", 9, 8, 1997));//eleves.get(11)

        //Déclaration des professeurs
        professeurs.add(new Professeur("Emile", "Durand")); //professeurs.get(0)
        professeurs.add(new Professeur("Frédéric", "Soma")); //professeurs.get(1)
        professeurs.add(new Professeur("Jean", "Nevro")); //professeurs.get(2)
        professeurs.add(new Professeur("Arthur", "Collin")); //professeurs.get(3)

        //Déclaration des promotions
        promotions.add(new Promotion("2020")); //promotions.get(0)
        promotions.add(new Promotion("2021")); //promotions.get(1)

        //Répartition des élèves dans les différentes promotions
        for(int i = 6; i <  12; i ++)
        {
            System.out.println(i);
            System.out.println(eleves.get(i).getPrenom());
            promotions.get(0).add(eleves.get(i));
        }
        for(int i = 0; i < 6; i ++)
        {
            System.out.println(i);
            System.out.println(eleves.get(i).getPrenom());
            promotions.get(1).add(eleves.get(i));
        }

        //Affectation des notes des professeurs aux élèves

        eleves.get(6).evaluations.add(new Evaluation(eleves.get(6), professeurs.get(0),"Mathématiques", 14.00));
        eleves.get(7).evaluations.add(new Evaluation(eleves.get(7), professeurs.get(0),"Mathématiques", 7.50));
        eleves.get(8).evaluations.add(new Evaluation(eleves.get(8), professeurs.get(0),"Mathématiques", 10.40));
        eleves.get(9).evaluations.add(new Evaluation(eleves.get(9), professeurs.get(0),"Mathématiques", 9.00));
        eleves.get(10).evaluations.add(new Evaluation(eleves.get(10), professeurs.get(0),"Mathématiques", 17.80));
        eleves.get(11).evaluations.add(new Evaluation(eleves.get(11), professeurs.get(0),"Mathématiques", 6.00));
        eleves.get(0).evaluations.add(new Evaluation(eleves.get(0), professeurs.get(0),"Mathématiques", 16.00));
        eleves.get(1).evaluations.add(new Evaluation(eleves.get(1), professeurs.get(0),"Mathématiques", 4.65));
        eleves.get(2).evaluations.add(new Evaluation(eleves.get(2), professeurs.get(0),"Mathématiques", 15.70));
        eleves.get(3).evaluations.add(new Evaluation(eleves.get(3), professeurs.get(0),"Mathématiques", 10.00));
        eleves.get(4).evaluations.add(new Evaluation(eleves.get(4), professeurs.get(0),"Mathématiques", 13.50));
        eleves.get(5).evaluations.add(new Evaluation(eleves.get(5), professeurs.get(0),"Mathématiques", 11.75));

        eleves.get(6).evaluations.add(new Evaluation(eleves.get(6), professeurs.get(1),"Communication", 7.00));
        eleves.get(7).evaluations.add(new Evaluation(eleves.get(7), professeurs.get(1),"Communication", 11.00));
        eleves.get(8).evaluations.add(new Evaluation(eleves.get(8), professeurs.get(1),"Communication", 16.40));
        eleves.get(9).evaluations.add(new Evaluation(eleves.get(9), professeurs.get(1),"Communication", 8.30));
        eleves.get(10).evaluations.add(new Evaluation(eleves.get(10), professeurs.get(1),"Communication", 15.00));
        eleves.get(11).evaluations.add(new Evaluation(eleves.get(11), professeurs.get(1),"Communication", 5.70));
        eleves.get(0).evaluations.add(new Evaluation(eleves.get(0), professeurs.get(1),"Communication", 12.00));
        eleves.get(1).evaluations.add(new Evaluation(eleves.get(1), professeurs.get(1),"Communication", 9.50));
        eleves.get(2).evaluations.add(new Evaluation(eleves.get(2), professeurs.get(1),"Communication", 5.70));
        eleves.get(3).evaluations.add(new Evaluation(eleves.get(3), professeurs.get(1),"Communication", 8.00));
        eleves.get(4).evaluations.add(new Evaluation(eleves.get(4), professeurs.get(1),"Communication", 11.50));
        eleves.get(5).evaluations.add(new Evaluation(eleves.get(5), professeurs.get(1),"Communication", 9.75));

        eleves.get(6).evaluations.add(new Evaluation(eleves.get(6), professeurs.get(2),"Informatique", 17.00));
        eleves.get(7).evaluations.add(new Evaluation(eleves.get(7), professeurs.get(2),"Informatique", 14.50));
        eleves.get(8).evaluations.add(new Evaluation(eleves.get(8), professeurs.get(2),"Informatique", 12.40));
        eleves.get(9).evaluations.add(new Evaluation(eleves.get(9), professeurs.get(2),"Informatique", 13.30));
        eleves.get(10).evaluations.add(new Evaluation(eleves.get(10), professeurs.get(2),"Informatique", 16.00));
        eleves.get(11).evaluations.add(new Evaluation(eleves.get(11), professeurs.get(2),"Informatique", 11.70));
        eleves.get(0).evaluations.add(new Evaluation(eleves.get(0), professeurs.get(2),"Informatique", 15.00));
        eleves.get(1).evaluations.add(new Evaluation(eleves.get(1), professeurs.get(2),"Informatique", 17.65));
        eleves.get(2).evaluations.add(new Evaluation(eleves.get(2), professeurs.get(2),"Informatique", 19.00));
        eleves.get(3).evaluations.add(new Evaluation(eleves.get(3), professeurs.get(2),"Informatique", 1.00));
        eleves.get(4).evaluations.add(new Evaluation(eleves.get(4), professeurs.get(2),"Informatique", 10.00));
        eleves.get(5).evaluations.add(new Evaluation(eleves.get(5), professeurs.get(2),"Informatique", 13.75));

        eleves.get(6).evaluations.add(new Evaluation(eleves.get(6), professeurs.get(3),"Physique", 3.15));
        eleves.get(7).evaluations.add(new Evaluation(eleves.get(7), professeurs.get(3),"Physique", 8.50));
        eleves.get(8).evaluations.add(new Evaluation(eleves.get(8), professeurs.get(3),"Physique", 15.75));
        eleves.get(9).evaluations.add(new Evaluation(eleves.get(9), professeurs.get(3),"Physique", 14.90));
        eleves.get(10).evaluations.add(new Evaluation(eleves.get(10), professeurs.get(3),"Physique", 10.00));
        eleves.get(11).evaluations.add(new Evaluation(eleves.get(11), professeurs.get(3),"Physique", 12.00));
        eleves.get(0).evaluations.add(new Evaluation(eleves.get(0), professeurs.get(3),"Physique", 6.35));
        eleves.get(1).evaluations.add(new Evaluation(eleves.get(1), professeurs.get(3),"Physique", 15.50));
        eleves.get(2).evaluations.add(new Evaluation(eleves.get(2), professeurs.get(3),"Physique", 7.80));
        eleves.get(3).evaluations.add(new Evaluation(eleves.get(3), professeurs.get(3),"Physique", 13.00));
        eleves.get(4).evaluations.add(new Evaluation(eleves.get(4), professeurs.get(3),"Physique", 19.00));
        eleves.get(5).evaluations.add(new Evaluation(eleves.get(5), professeurs.get(3),"Physique", 3.00));




        //Affichage des caractéristiques de l'élève choisi
        System.out.println("Affichage de l'élève Elodie : ");
        System.out.println(eleves.get(4));

        //Affichage de tous les élèves de la promotion 2020
        System.out.println("\n\nElèves de la promotion 2020 : ");
        for (Object eleve: promotions.get(0).getEleves()) {
            System.out.println(eleve);
        }

        //Affichage de tous les élèves de la promotion 2021
        System.out.println("\n\nElèves de la promotion 2021 : ");
        for (Object eleve: promotions.get(1).getEleves()) {
            System.out.println(eleve);
        }

        //Affichage des caractéristiques de l'élève recherché : ici l'élève 7
        if (promotions.get(0).rechercher(7) == null) {
            System.out.println("\n\nL'élève se trouve dans la promotion 2021");
            System.out.println(promotions.get(1).rechercher(7));
        }
        else {
            System.out.println("\n\nL'élève se trouve dans la promotion 2020");
            System.out.println(promotions.get(0).rechercher(7));
        }

        //Affichage des élèves de la promotion 2020 par ordre croissant et décroissant en fonction de leur médiane et de leur moyenne
        System.out.println("\n\n\nTri croissant de la promotion 2020 en fonction de la moyenne");
        promotions.get(0).triEleve(0, 0);
        for (Object eleve: promotions.get(0).getEleves()) {
            System.out.println(eleve);
        }

        System.out.println("\n\n\nTri croissant de la promotion 2020 en fonction de la mediane");
        promotions.get(0).triEleve(0, 1);
        for (Object eleve: promotions.get(0).getEleves()) {
            System.out.println(eleve);
        }

        System.out.println("\n\n\nTri décroissant de la promotion 2020 en fonction de la moyenne");
        promotions.get(0).triEleve(1, 0);
        for (Object eleve: promotions.get(0).getEleves()) {
            System.out.println(eleve);
        }

        System.out.println("\n\n\nTri décroissant de la promotion 2020 en fonction de la mediane");
        promotions.get(0).triEleve(1, 1);
        for (Object eleve: promotions.get(0).getEleves()) {
            System.out.println(eleve);
        }

        //Affichage des élèves de la promotion 2021 par ordre croissant et décroissant en fonction de leur médiane et de leur moyenne
        System.out.println("\n\n\nTri croissant de la promotion 2021 en fonction de la moyenne");
        promotions.get(1).triEleve(0, 0);
        for (Object eleve: promotions.get(1).getEleves()) {
            System.out.println(eleve);
        }

        System.out.println("\n\n\nTri croissant de la promotion 2021 en fonction de la mediane");
        promotions.get(1).triEleve(0, 1);
        for (Object eleve: promotions.get(1).getEleves()) {
            System.out.println(eleve);
        }

        System.out.println("\n\n\nTri décroissant de la promotion 2021 en fonction de la moyenne");
        promotions.get(1).triEleve(1, 0);
        for (Object eleve: promotions.get(1).getEleves()) {
            System.out.println(eleve);
        }

        System.out.println("\n\n\nTri décroissant de la promotion 2021 en fonction de la mediane");
        promotions.get(1).triEleve(1, 1);
        for (Object eleve: promotions.get(1).getEleves()) {
            System.out.println(eleve);
        }

        //Changement de note par le professeur
        try {System.out.println("\n\nMr Nevro souhaite changer la note d'Elodie (id = 5) de la promotion 2021 en informatique : ");
            int indice = eleves.get(4).rechercherEvaluation(professeurs.get(2), "Informatique");
            System.out.println("\nAvant modification : ");
            System.out.println(eleves.get(4));

            System.out.println(promotions.get(1));
            System.out.println(indice);

            professeurs.get(2).setNote(promotions.get(1), 5, 15, indice, "Informatique");
            System.out.println("\n\nAprès modification : ");
            System.out.println(eleves.get(4));
        } catch(IllegalStateException e) {
            e.printStackTrace();
        }

        //Instructions qui permettent de vider toutes les arrayList et de réinitialiser l'identifiant des élèves
        eleves.removeAll(eleves);
        Eleve.resetId();
        professeurs.removeAll(professeurs);
        promotions.removeAll(promotions);
    }
}