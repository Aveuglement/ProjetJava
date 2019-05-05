package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import NotesElevesProfesseurs.Promotion;
import NotesElevesProfesseurs.Evaluation;
import NotesElevesProfesseurs.Eleve;
import NotesElevesProfesseurs.Professeur;

public class Version2
{
    public static void main()
    {
        List<Eleve> eleves = new ArrayList<>();
        List<Professeur> professeurs = new ArrayList<>();
        List<Promotion> promotions = new ArrayList<>();
        Scanner sc;
        String ligne;

        try {
            sc = new Scanner(new File("C:\\Users\\Monseigneur\\Desktop\\Lepesqueur_Lillo_Mehaddi\\Tests.csv"));
            while (sc.hasNext()) {
                ligne = sc.nextLine();
                String[] data = ligne.split(";");
                if ("Professeur".equals(data[0])) {
                    professeurs.add(new Professeur(data[1], data[2]));
                }
                if ("Eleve".equals(data[0])) {
                    Eleve eleve = new Eleve(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                    eleves.add(eleve);
                    for (Promotion promotion : promotions) {
                        if (promotion.getNom().equals(data[6])) {
                            promotion.add(eleve);
                        }
                    }
                }
                if ("Promotion".equals(data[0])) {
                    promotions.add(new Promotion(data[1]));
                }
                if ("Evaluation".equals(data[0])) {
                    for (Eleve eleve : eleves)
                    {
                        if (eleve.getId() == (Integer.parseInt(data[2]))) {
                            for (Professeur professeur : professeurs)
                            {
                                if (professeur.getId() == (Integer.parseInt(data[4]))) {
                                    eleve.getEvaluation().add(new Evaluation(eleve, professeur, data[5], Double.parseDouble(data[6])));
                                }
                            }
                        }
                    }
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error !");
        }
        for (Promotion promotion : promotions) {
            for (Object eleve : promotion.getEleves()) {
                System.out.println(eleve);
            }
        }

        //Instructions qui permettent de vider toutes les arrayList et de réinitialiser l'identifiant des élèves
        eleves.removeAll(eleves);
        Eleve.resetId();
        professeurs.removeAll(professeurs);
        promotions.removeAll(promotions);
    }
}