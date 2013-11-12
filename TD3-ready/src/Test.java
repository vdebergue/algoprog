import java.io.*;
import java.util.*;

public class Test {

  // Test existence
  public static void test1() {
    Noeud a1 = new Noeud('*');
    Noeud a2 = new Noeud('*');
    Noeud a3 = new Noeud('*');
    Noeud b = new Noeud('l');
    Noeud c = new Noeud('e');
    Noeud d = new Noeud('a');
    Noeud e = new Noeud('s');
    b.ajouteFils(c);
    b.ajouteFils(d);
    c.ajouteFils(e);
    c.ajouteFils(a1);
    d.ajouteFils(a2);
    e.ajouteFils(a3);
    //System.out.println(b);

    Dictionnaire dico = new Dictionnaire();
    dico.racine.ajouteFils(b);

    System.out.printf("test1 %b %b %b %b %b %b %b end\n",
      dico.existeMot(""),
      dico.existeMot("la"),
      dico.existeMot("les"),
      dico.existeMot("sa"),
      dico.existeMot("se"),
      dico.existeMot("lu"),
      dico.existeMot("l")
    );
    // System.out.println(dico);
  }

  // Test ajout
  public static void test2() {
    Dictionnaire dico =  new Dictionnaire();
    boolean b1 = dico.ajouteMot("le");
    boolean b2 = dico.ajouteMot("loup");
    dico.ajouteMot("les");
    dico.ajouteMot("louve");

    System.out.printf("test2 %b %b %b %b %b %b %b %b %b %b %b end\n",
      dico.existeMot("le"),
      dico.existeMot("les"),
      dico.existeMot("lou"),
      dico.existeMot("lesa"),
      dico.existeMot("loupp"),
      dico.ajouteMot("le"),
      dico.ajouteMot("loup"),
      dico.ajouteMot("louv"),
      dico.ajouteMot("lulu"),
      b1, b2
    );
    // System.out.println(dico);
  }

  // Test préfixe
  public static void test3() {
    Dictionnaire dico =  new Dictionnaire();
    dico.ajouteMot("le");
    dico.ajouteMot("loup");
    dico.ajouteMot("les");
    dico.ajouteMot("louve");

    System.out.printf("test3 %b %b %b %b end\n",
      dico.estPrefixe("le"),
      dico.estPrefixe("les"),
      dico.estPrefixe("lou"),
      dico.estPrefixe("lu")
    );
    // System.out.println(dico);
  }

  // Test énumération
  public static void test4() {
    Dictionnaire dico = new Dictionnaire();
    dico.ajouteMot("fartee");
    dico.ajouteMot("radiographier");
    dico.ajouteMot("refrene");
    dico.ajouteMot("refrene");
    dico.ajouteMot("refrene");
    dico.ajouteMot("refrene");
    dico.ajouteMot("depelotonnates");
    dico.ajouteMot("sericiculteurs");
    dico.ajouteMot("panoramiquerons");
    dico.ajouteMot("fautasses");
    dico.ajouteMot("contractuelle");
    dico.ajouteMot("enerveriez");
    dico.ajouteMot("cagnardent");
    dico.ajouteMot("vertuchou");
    dico.ajouteMot("postates");
    dico.ajouteMot("stererent");
    dico.ajouteMot("fanion");
    dico.ajouteMot("reequilibrames");
    dico.ajouteMot("balafrez");
    dico.ajouteMot("voltez");
    dico.ajouteMot("antirides");
    dico.ajouteMot("tintinnabulerait");
    dico.ajouteMot("rougissant");
    dico.ajouteMot("emmerdons");
    dico.ajouteMot("favorables");
    dico.ajouteMot("affirmera");
    dico.ajouteMot("mer");
    dico.ajouteMot("rapprochai");
    dico.ajouteMot("dessecheraient");
    dico.ajouteMot("revoterent");
    dico.ajouteMot("redefiniras");
    dico.ajouteMot("separent");
    dico.ajouteMot("capturai");
    dico.ajouteMot("standardiserais");
    dico.ajouteMot("raffolons");
    dico.ajouteMot("idiotifiates");
    dico.ajouteMot("envideras");
    dico.ajouteMot("contrevins");
    dico.ajouteMot("saboterie");
    dico.ajouteMot("sediments");
    dico.ajouteMot("ambitionnerent");
    dico.ajouteMot("repliqueriez");
    dico.ajouteMot("transsudions");
    dico.ajouteMot("inseminions");
    dico.ajouteMot("providence");
    dico.ajouteMot("inhumations");
    dico.ajouteMot("criailles");
    dico.ajouteMot("emechez");
    dico.ajouteMot("declarait");
    dico.ajouteMot("dulcifiaient");
    dico.ajouteMot("degueulerions");
    dico.ajouteMot("mimera");
    dico.ajouteMot("bafouez");
    dico.ajouteMot("perennisasses");
    dico.ajouteMot("principautes");
    dico.ajouteMot("poulinerait");
    dico.ajouteMot("aida");
    dico.ajouteMot("critiquee");
    dico.ajouteMot("detoureras");
    dico.ajouteMot("rapapillotasses");
    dico.ajouteMot("souche");
    dico.ajouteMot("incrementez");
    dico.ajouteMot("enliassee");
    dico.ajouteMot("approchais");
    dico.ajouteMot("peinturera");
    dico.ajouteMot("rependrai");
    dico.ajouteMot("demantelement");
    dico.ajouteMot("captatoires");
    dico.ajouteMot("rationneriez");
    dico.ajouteMot("cascadeurs");
    dico.ajouteMot("gazonnai");
    dico.ajouteMot("calorifugerez");
    dico.ajouteMot("alluvionnera");
    dico.ajouteMot("agitassiez");
    dico.ajouteMot("truffee");
    dico.ajouteMot("decrepassiez");
    dico.ajouteMot("tarabiscotons");
    dico.ajouteMot("basilical");
    dico.ajouteMot("rassorties");
    dico.ajouteMot("statuees");
    dico.ajouteMot("egayerez");
    dico.ajouteMot("mollarderaient");
    dico.ajouteMot("raison");
    dico.ajouteMot("emmetreront");
    dico.ajouteMot("shahs");
    dico.ajouteMot("coudent");
    dico.ajouteMot("expiee");
    dico.ajouteMot("stylisions");
    dico.ajouteMot("anticonstitutionnellement");
    dico.ajouteMot("torpillais");
    dico.ajouteMot("subirons");
    dico.ajouteMot("merisiers");
    dico.ajouteMot("saisonnerons");
    dico.ajouteMot("sursaturee");
    dico.ajouteMot("transmettait");
    dico.ajouteMot("solifluerais");
    dico.ajouteMot("dedommageant");
    dico.ajouteMot("repassasse");
    dico.ajouteMot("fadeur");
    dico.ajouteMot("velleites");
    dico.ajouteMot("aspecterait");

    System.out.print("test4 ");
    dico.listeMotsAlphabetique();
    System.out.println("end");
    // System.out.println(dico);
  }
  
  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
  }
  
}

