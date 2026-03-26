package universite_paris8.iut.qdev.tp2026.gr14.interfaces;

import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.AucunJoueurExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.QuestionnaireIndisponibleExceptions;

public interface IServicesQuiz {

    ElementsPourUnePartieDTO determinerElementsDispoPourPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions;

    ElementsPourUnePartieDTO preparerLesElementsDeLaPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions;

}