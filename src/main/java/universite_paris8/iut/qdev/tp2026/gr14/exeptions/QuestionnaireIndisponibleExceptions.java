package universite_paris8.iut.qdev.tp2026.gr14.exeptions;

/**
 * Exception levée quand aucun questionnaire n'est disponible
 */
public class QuestionnaireIndisponibleExceptions extends Exception {

    public QuestionnaireIndisponibleExceptions(String message) {
        super(message);
    }

}