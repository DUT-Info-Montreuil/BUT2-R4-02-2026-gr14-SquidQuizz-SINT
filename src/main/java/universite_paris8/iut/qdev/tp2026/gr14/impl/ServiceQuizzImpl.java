package universite_paris8.iut.qdev.tp2026.gr14.impl;

import universite_paris8.iut.qdev.tp2026.gr14.interfaces.IServicesQuiz;
import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;

/**
 * Implémentation des services du quiz
 */
public class ServiceQuizzImpl implements IServicesQuiz {

    // vérifie que le pseudo du joueur est valide
    @Override
    public void traiterUnJoueur(String pseudo) {

        if (pseudo == null || pseudo.isEmpty()) {
            throw new IllegalArgumentException("Pseudo invalide");
        }

        System.out.println("Pseudo valide : " + pseudo);
    }

    @Override
    public ElementsPourUnePartieDTO preparerLesElementsDeLaPartie(String pseudo) {
        // méthode temporaire, les joueurs seront gérés via une liste plus tard
        return null;
    }
}