package Test;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import NotesElevesProfesseurs.Eleve;

public  class Version4 extends JFrame implements ActionListener
{
    private ModeleDynamiqueObjet modele = new ModeleDynamiqueObjet();
    private JTable tableau;

    public Version4()
    {
        super();
        setTitle("Affichage de l'ensemble des élèves des deux promotions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableau = new JTable(modele);
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        JPanel boutons = new JPanel();
        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));
        getContentPane().add(boutons, BorderLayout.SOUTH);
        pack();
    }

    private class AddAction extends AbstractAction
    {

        private AddAction()
        {
            super("Ajouter");
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            modele.addEleve(new Eleve("Toto", "Test", 1, 1, 2000));
        }
    }

    public void actionPerformed(ActionEvent e)
    {
    //        modele.addEleve(new Eleve("Toto", "Test", 3, 11, 2000));
    }

    private class RemoveAction extends AbstractAction
    {
        private RemoveAction()
        {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e)
        {
            int[] selection = tableau.getSelectedRows();
            for(int i = selection.length - 1; i >= 0; i--)
            {
                modele.removeEleve(selection[i]);
            }
        }
    }

    public static void main()
    {
        System.out.println("\n\nCréation de l'interface graphique avec JTable");
        new Version4().setVisible(true);
    }
}