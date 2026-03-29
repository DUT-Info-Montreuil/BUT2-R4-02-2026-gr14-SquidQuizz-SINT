package universite_paris8.iut.qdev.tp2026.gr14.impl;

import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.AucunJoueurExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.QuestionnaireIndisponibleExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.interfaces.IServicesQuiz;

/**
 * Implémentation des services du quiz
 * (version intégrateur avec simulation en attendant les autres modules)
 */
public class ServiceQuizImpl implements IServicesQuiz {

    /**
     * Détermine les éléments disponibles pour lancer une partie
     */
    @Override
    public ElementsPourUnePartieDTO determinerElementsDispoPourPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions {

        // Simulation (sera remplacée par appel aux modules joueur et questionnaire)
        boolean joueurDisponible = true;
        boolean questionnaireDisponible = true;

        // Vérification joueur
        if (!joueurDisponible) {
            throw new AucunJoueurExceptions("Aucun joueur disponible");
        }

        // Vérification questionnaire
        if (!questionnaireDisponible) {
            throw new QuestionnaireIndisponibleExceptions("Aucun questionnaire disponible");
        }

        // Création des données pour la partie
        ElementsPourUnePartieDTO dto = new ElementsPourUnePartieDTO();
        dto.setId(1);
        dto.setNom("Dupont");
        dto.setPrenom("Jean");
        dto.setPseudo("Milou");

        return dto;
    }

    /**
     * Prépare les éléments avant de lancer la partie
     */
    @Override
    public ElementsPourUnePartieDTO preparerLesElementsDeLaPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions {

        // Récupération des éléments
        ElementsPourUnePartieDTO dto = determinerElementsDispoPourPartie();

        // Simulation d'une préparation
        dto.setPseudo(dto.getPseudo() + "_READY");

        return dto;
    }
}