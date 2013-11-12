import java.util.LinkedList;

class Noeud {
    public char value;
    public LinkedList<Noeud> fils = new LinkedList<>();

    Noeud(char c) {
        value = c;
    }

    public void ajouteFils(Noeud a) {
        int i = 0;
        for(i =0; i < fils.size(); i++){
            Noeud n = fils.get(i);
            if(n.value > a.value) {
                break;
            }
        }
        fils.add(i, a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        if(!fils.isEmpty()) {
            sb.append(fils.toString());
        }
        return sb.toString();
    }

    Noeud getNoeudWithChar(char c) {
        Noeud next = null;
        for(Noeud n: fils) {
            if(c == n.value) {
                next = n;
                break;
            }
        }
        return next;
    }

    boolean existeMotRecursif(String s, int pos) {
        if(pos == s.length()) {
            Noeud next = this.getNoeudWithChar('*');
            return next != null;
        }

        char c = s.charAt(pos);
        Noeud next = this.getNoeudWithChar(c);

        if(next == null) {
            return false;
        } else {
            return next.existeMotRecursif(s, pos +1);
        }
    }

    boolean ajouteMotRecursif(String s, int pos) {
        if(pos == s.length()) {
            Noeud n = this.getNoeudWithChar('*');
            if (n != null) {
                return false;
            } else {
                this.ajouteFils(new Noeud('*'));
                return true;
            }
        }
        char c = s.charAt(pos);
        Noeud n = this.getNoeudWithChar(c);
        if (n == null) {
            n = new Noeud(c);
            this.ajouteFils(n);
        }
        return n.ajouteMotRecursif(s, pos + 1);
    }

    void listeMotsAlphabetique(StringBuilder sb) {
        if (value == '*') {
            System.out.print(sb.toString() + " ");
        } else {
            if(value != '_') sb.append(value);
            for (Noeud n: fils) {
                n.listeMotsAlphabetique(new StringBuilder(sb.toString()));
            }
        }
    }
}

class Dictionnaire {
    Noeud racine = new Noeud('_');

    public boolean existeMot(String s) {
        return racine.existeMotRecursif(s, 0);
    }

    public String toString() {
        return racine.toString();
    }

    public boolean ajouteMot(String s) {
        return racine.ajouteMotRecursif(s, 0);
    }

    public boolean estPrefixe(String s) {
        Noeud n = racine;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n = n.getNoeudWithChar(c);
            if(n == null) {
                return false;
            }
        }
        return true;
    }

    public void listeMotsAlphabetique() {
       racine.listeMotsAlphabetique(new StringBuilder());
    }
}
