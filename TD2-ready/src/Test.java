import java.util.NoSuchElementException;

public class Test {

  public static void main(String[] args) {
    test1a();
    test1b();
    test2();
    test3();
    test4();
  }

  /* Cette fonction vérifie que les fonctions de hash se comportent bien de la
   * manière attendue. */
  public static void test1a() {

    System.out.print("test1a ");

    System.out.print(new Objet1("").hash()+" ");
    System.out.print(new Objet1("coucou").hash()+" ");
    System.out.print(new Objet1("Quelques tests").hash()+" ");
    System.out.print(new Objet1("pour s'assurer").hash()+" ");
    System.out.print(new Objet1("que votre fonction").hash()+" ");
    System.out.print(new Objet1("donne la bonne").hash()+" ");
    System.out.print(new Objet1("sortie").hash()+" ");

    System.out.println("end");
  }

  public static void test1b() {
    System.out.print("test1b ");

    System.out.print(new Objet2("").hash()+" ");
    System.out.print(new Objet2("coucou").hash()+" ");
    System.out.print(new Objet2("Quelques tests").hash()+" ");
    System.out.print(new Objet2("pour s'assurer").hash()+" ");
    System.out.print(new Objet2("que votre fonction").hash()+" ");
    System.out.print(new Objet2("donne la bonne").hash()+" ");
    System.out.print(new Objet2("sortie").hash()+" ");

    System.out.println("end");
  }

  /* Cette fonction vérifie votre implémentation des listes. */
  public static void test2() {
    System.out.print("test2 ");
    Liste l = new Liste();
    Objet o = new Objet2("1");
    l.ajouteTete(o);
    System.out.print(l.longueur()+" ");
    l.ajouteTete(new Objet2("2")).ajouteTete(new Objet2("3"));
    System.out.print(l.contient(o)+" ");
    System.out.print(l.longueur()+" ");
    System.out.print(l.contient(new Objet2("4"))+" ");
    System.out.print(l.contient(new Objet2("2"))+" ");
    System.out.print(l.supprimeTete().longueur()+" ");
    System.out.print(l.contient(new Objet2("3"))+" ");
    System.out.print(l.contient(o)+" ");
    try {
      System.out.print("1 ");
      l.supprimeTete();
      System.out.print(l.longueur()+" ");
      System.out.print("2 ");
      l.supprimeTete();
      System.out.print(l.longueur()+" ");
      System.out.print("3 ");
      l.supprimeTete();
      System.out.print("4 ");
    } catch (NoSuchElementException e) {
      System.out.print("5 ");
      System.out.print(l.longueur()+" ");
    } catch (Exception e) {
      System.out.print("6 ");
      System.out.print(l.longueur()+" ");
    }
    l.ajouteTete(new Objet2("5"));
    System.out.print(l.longueur()+" ");
    System.out.print(l.contient(new Objet2("5"))+" ");
    System.out.println("end");
  }

  /* Cette fonction vérifie votre gestion des collisions. Ces deux chaînes ont
   * quelque chose de particulier. Quoi donc ? */
  public static void test3() {
    System.out.print("test3 ");
    TableDeHachage t = new TableDeHachage(10);
    t.ajoute(new Objet1("FB"));
    System.out.print(t.contient(new Objet1("Ea")));
    System.out.println(" end");
  }

  /* Cette fonction vérifie que la table de hachage se comporte de la manière
   * attendue, en générant des chaînes aléatoires, et en les ajoutant
   * successivement dans la table de hachage. Cette fonction utilise Objet2,
   * avec une fonction de hash déjà écrite, pour ne pas vous pénaliser si vous
   * n'avez pas réussi à faire la partie 1. */
  public static void test4() {
    System.out.print("test4 ");
    TableDeHachage t = new TableDeHachage(3000);
    for (int i = 0; i < 1500; i++) {
      t.ajoute(new Objet3("chaine"+Prng.next()));
    }
    System.out.print(t.contient(new Objet3(""))+" ");
    System.out.print(t.contient(new Objet3("chaine"))+" ");
    System.out.print(t.contient(new Objet3("eniach"))+" ");
    System.out.print(t.contient(new Objet3("chaine877819790"))+" ");
    System.out.print(t.contient(new Objet3("chaine878197790"))+" ");
    System.out.print(t.contient(new Objet3("chaine1517273377"))+" ");
    System.out.print(t.contient(new Objet3("chaine1172753377"))+" ");
    System.out.print(t.contient(new Objet3("chaine1462863342"))+" ");
    System.out.print(t.contient(new Objet3("chaine1628643342"))+" ");
    System.out.print(t.contient(new Objet3("chaine1715469037"))+" ");
    int[] remplissage = t.remplissageMax();
    assert remplissage.length == 2;
    System.out.println(remplissage[0] + " " + remplissage[1] + " end");
  }

}

class Prng {
  static int seed = 1;
  static int m = 2147483647;
  static int a = 16807;
  static int b = 0;

  static int next() {
    seed = (int) ((((long) seed) * a + b) % m);
    return seed;
  }
}
