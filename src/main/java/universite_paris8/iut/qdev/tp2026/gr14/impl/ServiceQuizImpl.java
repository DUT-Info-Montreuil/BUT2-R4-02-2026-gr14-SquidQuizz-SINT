package universite_paris8.iut.qdev.tp2026.gr14.impl;

import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.AucunJoueurExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.exceptions.QuestionnaireIndisponibleExceptions;
import universite_paris8.iut.qdev.tp2026.gr14.interfaces.IServicesQuiz;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;

import universite_Paris8.iut.qdev.tp2026.gr14.services.interfaces.IQuestionnaireServices;
import universite_Paris8.iut.qdev.tp2026.gr14.entities.dto.QuestionnaireDTO;

import java.util.List;

/**
 * Implémentation des services du quiz
 */
public class ServiceQuizImpl implements IServicesQuiz {

    private IserviceJoueur joueurService;
    private IQuestionnaireServices questionnaireService;

    // constructeur pour Mockito
    public ServiceQuizImpl(IserviceJoueur joueurService, IQuestionnaireServices questionnaireService) {
        this.joueurService = joueurService;
        this.questionnaireService = questionnaireService;
    }

    @Override
    public ElementsPourUnePartieDTO determinerElementsDispoPourPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions {

        // appel service joueur
        List<JoueurDTO> joueurs = joueurService.listerJoueurs();

        if (joueurs == null || joueurs.isEmpty()) {
            throw new AucunJoueurExceptions("Aucun joueur disponible");
        }

        // appel service questionnaire
        List<QuestionnaireDTO> questionnaires =
                questionnaireService.parcourirQuestionnaireDTO("FR");

        if (questionnaires == null || questionnaires.isEmpty()) {
            throw new QuestionnaireIndisponibleExceptions("Aucun questionnaire disponible");
        }

        // on prend le premier joueur
        JoueurDTO joueur = joueurs.get(0);

        ElementsPourUnePartieDTO dto = new ElementsPourUnePartieDTO();
        dto.setNom(joueur.getNom());
        dto.setPrenom(joueur.getPrenom());
        dto.setPseudo(joueur.getPseudo());

        return dto;
    }

    @Override
    public ElementsPourUnePartieDTO preparerLesElementsDeLaPartie()
            throws AucunJoueurExceptions, QuestionnaireIndisponibleExceptions {

        ElementsPourUnePartieDTO dto = determinerElementsDispoPourPartie();
        dto.setPseudo(dto.getPseudo() + "_READY");

        return dto;
    }
}