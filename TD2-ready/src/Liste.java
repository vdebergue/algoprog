import java.util.NoSuchElementException;

public class Liste {

    public Cellule tete = null;
    public int longueur = 0;

    public Liste() {
    }

    public int longueur() {
        return longueur;
    }

    public Liste ajouteTete(Objet val){
        longueur += 1;
        tete = new Cellule(val, tete);
        return this;
    }

    public Liste supprimeTete() {
        if(longueur == 0) throw new NoSuchElementException();
        else {
            tete = tete.suivant;
            longueur -= 1;
            return this;
        }
    }

    public boolean contient(Objet o) {
        if (longueur == 0) return false;
        if (tete.objet.nom().equals(o.nom())) return true; 
        Cellule c = tete;
        while(c.suivant != null) {
            c = c.suivant;
            if(c.objet.nom().equals(o.nom())) return true;
        }
        return false;
    }

}

class Cellule {
    public Objet objet;
    public Cellule suivant;

    public Cellule(Objet o, Cellule s) {
        objet = o;
        suivant = s;
    }
}