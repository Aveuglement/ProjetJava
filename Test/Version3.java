package Test;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import NotesElevesProfesseurs.Eleve;
import NotesElevesProfesseurs.Evaluation;
import NotesElevesProfesseurs.IllegalStateException;
import NotesElevesProfesseurs.Professeur;
import NotesElevesProfesseurs.Promotion;

public class Version3 extends ApplicationFrame
{
    //Constructeur qui permet de créer un graphique
    public Version3(String titreApplication, String titreGraphique, CategoryDataset dataset)
    {
        super(titreApplication);
        JFreeChart barChart = ChartFactory.createBarChart(titreGraphique,"Matières","Notes", dataset, PlotOrientation.VERTICAL,true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    //Méthode qui définit les axes et le contenu du graphique
    private static CategoryDataset createDataset(Promotion promotion)
    {
        final String Moyenne = "Moyenne";
        final String Mediane = "Médiane";
        final String NoteMax = "Note max";
        final String NoteMin = "Note min";
        final String Informatique = "Informatique";
        final String Communication = "Communication";
        final String Physique = "Physique";
        final String Mathématiques = "Mathématiques";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            dataset.addValue(promotion.moyenne("Informatique"), Informatique, Moyenne);
            dataset.addValue(promotion.mediane("Informatique"), Informatique, Mediane);
            dataset.addValue(promotion.valeur("Informatique", "max"), Informatique, NoteMax);
            dataset.addValue(promotion.valeur("Informatique", "min"), Informatique, NoteMin);
            dataset.addValue(promotion.moyenne("Communication"), Communication, Moyenne);
            dataset.addValue(promotion.mediane("Communication"), Communication, Mediane);
            dataset.addValue(promotion.valeur("Communication", "max"), Communication, NoteMax);
            dataset.addValue(promotion.valeur("Communication", "min"), Communication, NoteMin);
            dataset.addValue(promotion.moyenne("Physique"), Physique, Moyenne);
            dataset.addValue(promotion.mediane("Physique"), Physique, Mediane);
            dataset.addValue(promotion.valeur("Physique", "max"), Physique, NoteMax);
            dataset.addValue(promotion.valeur("Physique", "min"), Physique, NoteMin);
            dataset.addValue(promotion.moyenne("Mathématiques"), Mathématiques, Moyenne);
            dataset.addValue(promotion.mediane("Mathématiques"), Mathématiques, Mediane);
            dataset.addValue(promotion.valeur("Mathématiques", "max"), Mathématiques, NoteMax);
            dataset.addValue(promotion.valeur("Mathématiques", "min"), Mathématiques, NoteMin);
        } catch(IllegalStateException e) {
            System.out.println("IllegalStateException error !");
        }
        return dataset;
    }

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

        //Création du graphique
        System.out.println("\n\nCréation des graphiques avec JFreeChart");
        CategoryDataset dataset = createDataset(promotions.get(0));
        CategoryDataset dataSet = createDataset(promotions.get(1));
        Version3 chart = new Version3("Statistiques des notes par matière","Diversité des notes par matière de la promotion 2020", dataset);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
        Version3 chart2 = new Version3("Statistiques des notes par matière","Diversité des notes par matière de la promotion 2021", dataSet);
        chart2.pack();
        RefineryUtilities.centerFrameOnScreen(chart2);
        chart2.setVisible(true);

        //Instructions qui permettent de vider toutes les arrayList et de réinitialiser l'identifiant des élèves
        eleves.removeAll(eleves);
        Eleve.resetId();
        professeurs.removeAll(professeurs);
        promotions.removeAll(promotions);
    }
}