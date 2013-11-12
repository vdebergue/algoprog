class TableDeHachage {

  Liste[] listes;
  int n;

  public TableDeHachage(int n) {
    listes = new Liste[n];
    this.n = n;
    for(int i = 0; i < n; i ++) {
        listes[i] = new Liste();
    }
  }

  private int modu(int x, int n) {
    int r = x % n;
    if (r < 0) r += n;
    return r;
  }

  public void ajoute(Objet o) {
    int i = modu(o.hash(), n);
    listes[i].ajouteTete(o);
  }

  public boolean contient(Objet o) {
    int i = modu(o.hash(), n);
    return listes[i].contient(o);
  }

  public int[] remplissageMax() {
    int indice = 0;
    int max = 0;
    for(int i = 0; i < n; i++) {
        if(max < listes[i].longueur()) {
            indice = i;
            max = listes[i].longueur();
        }
    }
    return new int[]{indice,listes[indice].longueur()};
  }
}