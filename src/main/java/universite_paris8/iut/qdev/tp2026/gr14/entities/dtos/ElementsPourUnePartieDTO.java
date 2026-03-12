package universite_paris8.iut.qdev.tp2026.gr14.entities.dtos;

/**
 * DTO qui contient les informations nécessaires
 * pour lancer une partie
 */
public class ElementsPourUnePartieDTO {

    // identifiant du joueur
    private int id;

    // nom du joueur
    private String nom;

    // prenom du joueur
    private String prenom;

    // pseudo du joueur
    private String pseudo;

    // constructeur vide
    public ElementsPourUnePartieDTO() {
    }

    // constructeur complet
    public ElementsPourUnePartieDTO(int id, String nom, String prenom, String pseudo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}