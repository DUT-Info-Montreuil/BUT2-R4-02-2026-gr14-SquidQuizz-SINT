package universite_paris8.iut.qdev.tp2026.gr14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import universite_paris8.iut.qdev.tp2026.gr14.impl.ServiceQuizImpl;
import universite_paris8.iut.qdev.tp2026.gr14.entities.dtos.ElementsPourUnePartieDTO;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import universite_Paris8.iut.qdev.tp2026.gr14.services.IQuestionnaireServices;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class ServiceQuizMockTest {

    @Mock
    IserviceJoueur joueurService;

    @Mock
    IQuestionnaireServices questionnaireService;

    @InjectMocks
    ServiceQuizImpl serviceQuiz;

    // =========================
    // TEST 1 : comportement normal
    // =========================
    @Test
    void test_mock_preparerPartie_OK() {

        // GIVEN
        when(joueurService.listerJoueurs()).thenReturn(new ArrayList<>());
        when(questionnaireService.parcourirQuestionnaireDTO("file")).thenReturn(new ArrayList<>());

        // WHEN
        ElementsPourUnePartieDTO result = serviceQuiz.determinerElementsDispoPourPartie();

        // THEN
        assertNotNull(result);

        verify(joueurService, times(1)).listerJoueurs();
    }

    // =========================
    // TEST 2 : mock joueur appelé
    // =========================
    @Test
    void test_mock_joueur_called() {

        when(joueurService.listerJoueurs()).thenReturn(new ArrayList<>());

        serviceQuiz.determinerElementsDispoPourPartie();

        verify(joueurService).listerJoueurs();
    }

    // =========================
    // TEST 3 : mock questionnaire appelé
    // =========================
    @Test
    void test_mock_questionnaire_called() {

        when(questionnaireService.parcourirQuestionnaireDTO("file")).thenReturn(new ArrayList<>());

        serviceQuiz.determinerElementsDispoPourPartie();

        verify(questionnaireService).parcourirQuestionnaireDTO("file");
    }

    // =========================
    // TEST 4 : exception simulée joueur
    // =========================
    @Test
    void test_mock_exception_joueur() {

        when(joueurService.listerJoueurs()).thenThrow(new RuntimeException("Erreur joueur"));

        assertThrows(RuntimeException.class, () -> {
            serviceQuiz.determinerElementsDispoPourPartie();
        });
    }

}