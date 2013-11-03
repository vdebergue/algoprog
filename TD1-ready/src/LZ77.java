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
    int tailleBufferFenetre = Math.min(positionCourante - debutFenetre, tailleFenetre);
		Occurrence plusLongueOccurrence = new Occurrence(0,0);
		for(int i = positionCourante; i < positionCourante + tailleBufferFenetre && i < t.length; i++) {
			int taille = i - positionCourante + 1;
			// trouver une occurence entre la chaine t[positionCourante -> i] et t[debutFenetre -> positionCourante -1]
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

  public static int LZ77Longueur(int[] t, int tailleFenetre) {
    int length = 0;
    int i = 0;
    Occurrence o;
    while(i < t.length) {
      o = plusLongueOccurrence(t, i, tailleFenetre);
      length += 1;
      i += o.taille + 1;
    }
    return length;
  }

  public static Element[] LZ77(int[] t, int tailleFenetre) {
    Element[] out = new Element[LZ77Longueur(t, tailleFenetre)];
    int i = 0;
    int outIndex = 0;
    Occurrence o;
    Element e;
    while(i < t.length) {
      o = plusLongueOccurrence(t, i, tailleFenetre);
      e = new Element(o, t[i+ o.taille]);
      out[outIndex] = e;
      outIndex ++;
      i += o.taille + 1;
    }
    return out;
  }

  public static void afficheEncode(Element[] t) {
    for(Element e: t) {
      System.out.printf("(%d,%d)%d", e.o.retour, e.o.taille, e.nextChar);
    }
    System.out.print("\n");
  }

  public static int LZ77InverseLongueur(Element[] t) {
    int length = 0;
    for(Element e: t) {
      length += e.o.taille + 1;
    }
    return length;
  }

  public static int[] LZ77Inverse(Element[] t) {
    int[] out = new int[LZ77InverseLongueur(t)];
    int outIndex = 0;
    for(Element e : t) {
      blit(out, out, outIndex - e.o.retour, e.o.taille, outIndex);
      out[outIndex + e.o.taille] = e.nextChar;
      outIndex += e.o.taille + 1;
    }
    return out;
  }

  // t1[start -> start + len] ==> t2[start2 -> start + len]
  private static void blit(int[] t1, int[] t2, int start1, int len, int start2) {
    for(int i = 0; i < len; i++) {
      t2[start2 + i] = t1[start1 + i];
    }
  }

  public static void afficheDecode(int[] t) {
    for(int i: t) {
      System.out.print(i + " ");
    }
    System.out.print("\n");
  }
}