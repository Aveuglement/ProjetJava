package NotesElevesProfesseurs;
import java.util.Comparator;

public class Compare implements Comparator<Eleve>
{
    private int type;
    private static final int MOYENNE = 0;
    private static final int MEDIANE = 1;
    private int sens;
    private static final int CROISSANT = 0;
    private static final int DECROISSANT = 1;

    public Compare(int sens, int type)
    {
        this.sens = sens;
        this.type = type;
    }

    //Méthode qui permet de trier les élèves en fonction du type de tri (moyenne ou médiane) et du sens (croissant ou décroissant)
    @Override
    public int compare(Eleve eleve1, Eleve eleve2)
    {
        switch (type) {
            case MOYENNE : if(sens == CROISSANT) {
                return eleve1.compareToMoyenne(eleve2);
            }
            return eleve2.compareToMoyenne(eleve1);
            case MEDIANE : if (sens == CROISSANT) {
                return eleve1.compareToMediane(eleve2);
            }
            return eleve2.compareToMediane(eleve1);
        }
        System.out.println("\n\nTriage en fonction des moyennes par ordre croissant (par défaut)");
        return eleve1.compareToMoyenne(eleve2);
    }
}