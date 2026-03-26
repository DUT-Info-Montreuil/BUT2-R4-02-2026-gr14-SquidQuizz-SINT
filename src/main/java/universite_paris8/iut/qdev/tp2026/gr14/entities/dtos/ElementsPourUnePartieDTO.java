package universite_paris8.iut.qdev.tp2026.gr14.entities.dtos;

public class ElementsPourUnePartieDTO {

    private int id;
    private String nom;
    private String prenom;
    private String pseudo;

    public ElementsPourUnePartieDTO() {}

    public ElementsPourUnePartieDTO(int id, String nom, String prenom, String pseudo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }
}