package Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String version;
        System.out.print("\n " + "___________________________________________________________________________________" + "\n|" + "\t\t\t\t\t\t\t\t\t" + "Projet : Java 2" + "\t\t\t\t\t\t\t\t\t" + "|\n\n|" + "\t\t\t\t\t" + "Lepesqueur Clara, Lillo Joanna, Mehaddi Gustave" + "  " + "\t\t\t\t" + "|\n" + "\t\t\t\t\t\t\t\t" + "Groupe 7, Promotion 2021\n|" + "___________________________________________________________________________________" + "|\n");

        do {
            System.out.print("\n\nVeuillez choisir la version à tester (1, 2, 3 ou 4) (pour quitter tapez : q) : ");
            version = sc.nextLine();
            switch (version) {
                case "1":
                    Version1.main();
                    break;
                case "2":
                    Version2.main();
                    break;
                case "3":
                    Version3.main();
                    break;
                case "4":
                    Version4.main();
                    break;
                default:
                    System.out.println("Saisie incorrecte !");
                    break;
            }
        }while(version != "q");
    }
}
