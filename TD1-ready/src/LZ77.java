// Ces squelettes sont à compléter et sont là uniquement pour prévenir des
// erreurs de compilation.
class Element {
	public Occurrence o;
	public int nextChar;
  Element (Occurrence e, int s) {
  	o = e;
  	nextChar = s;
  }
}

class Occurrence {
	public int taille;
	public int retour;
  Occurrence (int retour, int taille) {
  	this.taille = taille;
  	this.retour = retour;
  }

  public String toString() {
  	return "Occurrence: t = " + this.taille + " r = " + this.retour;
  }
}

class LZ77 {
	public static Occurrence plusLongueOccurrence(int[] t, int positionCourante, int tailleFenetre) {
		int debutFenetre = (positionCourante > tailleFenetre) ? positionCourante - tailleFenetre : 0;
		Occurrence plusLongueOccurrence = new Occurrence(0,0);
		for(int i = positionCourante; i < positionCourante + tailleFenetre && i < t.length; i++) {
			int taille = i - positionCourante + 1;
			// trouver une occurence entre la chaine t[positionCourante -> i] et t[debutFenetre -> positionCourante]
			int retour = retourOccurrence(t, debutFenetre, positionCourante, taille);
			if (retour != 0 && taille > plusLongueOccurrence.taille) {
				//System.out.println(plusLongueOccurrence);
				plusLongueOccurrence = new Occurrence(retour, taille);
			}
		}
		return plusLongueOccurrence;
	}

	private static int retourOccurrence(int[] t, int debut, int positionCourante, int longueur) {
		for (int i = debut; i < positionCourante; i++) {
			// occurrence ?
			boolean match = true;
			int j = 0;
			while(match && j < longueur) {
				match = (t[i + j] == t[positionCourante + j]);
				j++;
			}
			if(match) {
				return positionCourante - i;
			}
		}
		return 0;
	}
}