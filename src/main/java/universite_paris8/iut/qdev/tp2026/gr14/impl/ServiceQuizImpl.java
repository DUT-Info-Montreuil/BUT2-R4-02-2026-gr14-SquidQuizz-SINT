package universite_paris8.iut.qdev.tp2026.gr14.impl;

import universite_paris8.iut.qdev.tp2026.gr14.interfaces.IServicesQuiz;
import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;

/**
 * Implémentation des services du quiz
 */
public class ServiceQuizImpl implements IServicesQuiz {

    /**
     * détermine les éléments disponibles pour lancer une partie
     */
    @Override
    public ElementsPourUnePartieDTO determinerElementsDispoPourPartie() {

        return new ElementsPourUnePartieDTO(1, "Nom", "Prenom", "Pseudo");
    }
}