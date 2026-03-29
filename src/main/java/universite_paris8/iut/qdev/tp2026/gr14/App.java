package universite_paris8.iut.qdev.tp2026.gr14;

import universite_paris8.iut.qdev.tp2026.gr14.impl.ServiceQuizImpl;
import universite_paris8.iut.qdev.tp2026.gr14.interfaces.IServicesQuiz;

public class App {

    public static void main(String[] args) {

        IServicesQuiz service = new ServiceQuizImpl();

        try {
            System.out.println("=== TEST ===");

            System.out.println(service.determinerElementsDispoPourPartie().getPseudo());
            System.out.println(service.preparerLesElementsDeLaPartie().getPseudo());

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}