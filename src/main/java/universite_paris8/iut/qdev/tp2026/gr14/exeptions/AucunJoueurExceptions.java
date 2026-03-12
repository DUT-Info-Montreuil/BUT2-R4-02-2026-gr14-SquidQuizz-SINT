package universite_paris8.iut.qdev.tp2026.gr14.exeptions;

/**
 * Exception levée quand aucun joueur n'est trouvé
 */
public class AucunJoueurExceptions extends Exception {

    public AucunJoueurExceptions(String message) {
        super(message);
    }

}