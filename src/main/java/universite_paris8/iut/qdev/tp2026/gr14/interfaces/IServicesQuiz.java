package universite_paris8.iut.qdev.tp2026.gr14.interfaces;

import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;

/**
 * Interface des services du quiz
 */
public interface IServicesQuiz {

    // vérifie qu'un joueur est valide
    void traiterUnJoueur(String pseudo);

    // prépare les éléments nécessaires pour une partie
    ElementsPourUnePartieDTO preparerLesElementsDeLaPartie(String pseudo);

}