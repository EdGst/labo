package Kinomichi.Personne;



    public class Personne {

        String nom ="X";
        String prenom ="X";
        String club = "club inconnu";

        boolean responsable = false;



        public Personne(String nom, String prenom, String club, boolean responsable){
            this.nom = nom;
            this.prenom = prenom;
            this.club = club;
            this.responsable = responsable;

        }

        public String getNom(){

            return nom;
        }
        public String getPrenom() {
            return prenom;
        }
        public String getClub() {
            return club;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
        public void setClub(String club) {
            this.club = club;
        }

        @Override
        public String toString() {
            return "Personne{" +
                    "nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", club='" + club + '\'' +
                    ", responsable=" + responsable +
                    '}';
        }
    }


