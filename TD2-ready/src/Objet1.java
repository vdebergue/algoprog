public class Objet1 extends Objet {

    private String nom;

    public Objet1(String nom) {
        this.nom = nom;
    }

    @Override
    public int hash() {
        int h = 0;
        int n = nom.length();
        for(int i = 0; i < n; i++) {
            int calc = calc(nom.charAt(i), n - 1 - i);
            h =  h + calc;
        }
        return h;
    }

    private int calc(int c, int exposant) {
        int a = 1;
        for(int i=0; i < exposant; i ++) a = a * 31;
        return c * a;
    }

    @Override
    public String nom() {
        return nom;
    }
}