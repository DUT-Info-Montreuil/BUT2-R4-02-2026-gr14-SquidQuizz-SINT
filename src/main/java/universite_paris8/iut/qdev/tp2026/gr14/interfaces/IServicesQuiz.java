package universite_paris8.iut.qdev.tp2026.gr14.interfaces;

import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;

/**
 * Interface des services du quiz
 */
public interface IServicesQuiz {

    // prépare les éléments nécessaires pour une partie
    ElementsPourUnePartieDTO determinerElementsDispoPourPartie();
}