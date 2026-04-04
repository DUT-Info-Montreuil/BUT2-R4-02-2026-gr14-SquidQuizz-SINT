package universite_paris8.iut.qdev.tp2026.gr14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import universite_paris8.iut.qdev.tp2026.gr14.impl.ServiceQuizImpl;
import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr14.services.interfaces.IQuestionnaireServices;
import universite_Paris8.iut.qdev.tp2026.gr14.entities.dto.QuestionnaireDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceQuizMockTestAlpay {


    @Mock
    IserviceJoueur joueurService;

    @Mock
    IQuestionnaireServices questionnaireService;


    ServiceQuizImpl objetATester;


    @BeforeEach
    public void init(TestInfo testInfo) {
        objetATester = new ServiceQuizImpl();
        System.out.println("Appel du test : " + testInfo.getDisplayName());
    }

    //  Données de test
    private ArrayList<JoueurDTO> listeJoueursValide() {
        ArrayList<JoueurDTO> joueurs = new ArrayList<>();
        joueurs.add(new JoueurDTO("Doe", "John", "JohnD", 2000, new String[]{"sport"}, LangueEnum.FR));
        return joueurs;
    }

    private List<QuestionnaireDTO> listeQuestionnairesValide() {
        List<QuestionnaireDTO> questionnaires = new ArrayList<>();
        QuestionnaireDTO q = new QuestionnaireDTO();
        q.setId(1);
        q.setLibelleQuestionnaire("Sport niv 1");
        questionnaires.add(q);
        return questionnaires;
    }



    // TEST 1 : cas nominal → DTO non null
    @Test
    public void test_determinerElements_OK() throws Exception {
        when(joueurService.listerJoueurs()).thenReturn(listeJoueursValide());
        when(questionnaireService.parcourirQuestionnaireDTO(anyString()))
                .thenReturn(listeQuestionnairesValide());

        ElementsPourUnePartieDTO result = objetATester.determinerElementsDispoPourPartie();

        assertNotNull(result);
        verify(joueurService).listerJoueurs();
        verify(questionnaireService).parcourirQuestionnaireDTO(anyString());
    }

    // TEST 2 : valeurs du DTO retourné
    @Test
    public void test_valeursDTO() throws Exception {
        when(joueurService.listerJoueurs()).thenReturn(listeJoueursValide());
        when(questionnaireService.parcourirQuestionnaireDTO(anyString()))
                .thenReturn(listeQuestionnairesValide());

        ElementsPourUnePartieDTO result = objetATester.determinerElementsDispoPourPartie();

        assertEquals("JohnD", result.getPseudo());
        assertEquals("John", result.getPrenom());
        assertEquals("Doe", result.getNom());
    }

    // TEST 3 : aucun joueur exception
    @Test
    public void test_aucunJoueur_leveException() throws Exception {
        when(joueurService.listerJoueurs()).thenReturn(new ArrayList<>());

        assertThrows(RuntimeException.class, () ->
                objetATester.determinerElementsDispoPourPartie());


        verify(questionnaireService, never()).parcourirQuestionnaireDTO(anyString());
    }

    // TEST 4 : aucun questionnaire exception
    @Test
    public void test_aucunQuestionnaire_leveException() throws Exception {
        when(joueurService.listerJoueurs()).thenReturn(listeJoueursValide());
        when(questionnaireService.parcourirQuestionnaireDTO(anyString()))
                .thenReturn(new ArrayList<>());

        assertThrows(RuntimeException.class, () ->
                objetATester.determinerElementsDispoPourPartie());
    }

    // TEST 5 : mock joueur lève une exception
    @Test
    public void test_exception_joueur() {
        when(joueurService.listerJoueurs())
                .thenThrow(new RuntimeException("Erreur joueur"));

        assertThrows(RuntimeException.class, () ->
                objetATester.determinerElementsDispoPourPartie());
    }

    // TEST 6 : mock questionnaire lève une exception
    @Test
    public void test_exception_questionnaire() throws Exception {
        when(joueurService.listerJoueurs()).thenReturn(listeJoueursValide());
        when(questionnaireService.parcourirQuestionnaireDTO(anyString()))
                .thenThrow(new RuntimeException("Erreur questionnaire"));

        assertThrows(RuntimeException.class, () ->
                objetATester.determinerElementsDispoPourPartie());
    }
}