public class Objet2 extends Objet {

    private String nom;

    public Objet2(String nom) {
        this.nom = nom;
    }

    @Override
    public int hash() {
        return hashbis(nom.length() - 1);
    }

    private int hashbis(int i) {
        if(i == -1) return 5381;
        return hashbis(i -1) * 33 ^ (int) nom.charAt(i);
    }

    @Override
    public String nom() {
        return nom;
    }
}