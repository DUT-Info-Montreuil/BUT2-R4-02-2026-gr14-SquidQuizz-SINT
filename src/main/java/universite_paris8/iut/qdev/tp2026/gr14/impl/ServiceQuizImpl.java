package universite_paris8.iut.qdev.tp2026.gr14.impl;

import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.AucunJoueurExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.QuestionnaireIndisponibleExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.interfaces.IServicesQuiz;

public class ServiceQuizImpl implements IServicesQuiz {

    @Override
    public ElementsPourUnePartieDTO determinerElementsDispoPourPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions {

        // simulation
        boolean joueurDisponible = true;
        boolean questionnaireDisponible = true;

        if (!joueurDisponible) {
            throw new AucunJoueurExceptions("Aucun joueur disponible");
        }

        if (!questionnaireDisponible) {
            throw new QuestionnaireIndisponibleExceptions("Aucun questionnaire disponible");
        }

        ElementsPourUnePartieDTO dto = new ElementsPourUnePartieDTO();
        dto.setId(1);
        dto.setNom("Dupont");
        dto.setPrenom("Jean");
        dto.setPseudo("Milou");

        return dto;
    }

    @Override
    public ElementsPourUnePartieDTO preparerLesElementsDeLaPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions {

        // on récupère les éléments
        ElementsPourUnePartieDTO dto = determinerElementsDispoPourPartie();

        // on peut simuler une préparation
        dto.setPseudo(dto.getPseudo() + "_READY");

        return dto;
    }
}