import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Museum {

    ArrayList<ArtWork> esposizione = new ArrayList<>(5);
    LinkedList<ArtWork> deposito = new LinkedList<>();
    TreeSet<Statue> collezioneStatue = new TreeSet<>();
    TreeSet<Painting> collezioneDipinti = new TreeSet<>();
    TreeSet<Author> artisti = new TreeSet<>(Author::compareTo);

    public void checkArtWork(ArtWork artwork) {
        if (esposizione.size() <= 5) {
            if (!esposizione.contains(artwork)) {
                esposizione.add(artwork);
                System.out.println("L'opera è in esposizione");
            }

        } else {
            deposito.add(artwork);
            System.out.println("L'opera è in magazzino");
        }
    }

    public ArtWork move(int codice) {
        ArtWork temp = null;
        for (ArtWork o : esposizione) {
            if (o.getCodiceIdentificativo() == codice) {
                temp = o;
                break;
            }
        }

        if (temp != null) {
            deposito.add(temp);
            esposizione.remove(temp);
            System.out.println("L'opera con codice " + codice + " è stata spostata in magazzino!");
        } else
            System.out.println("Opera non è presente da nessuna parte");
        return temp;
    }

    public ArtWork find(int codice) {
        ArtWork temp = null;
        for (ArtWork o : esposizione) {
            if (o.getCodiceIdentificativo() == codice) {
                temp = o;
                System.out.println("L'opera " + temp + " è in esposizione");
                break;
            }
        }
        for (ArtWork o : deposito) {
            if (o.getCodiceIdentificativo() == codice) {
                temp = o;
                System.out.println("L'opera " + temp + " è in magazzino");
                break;
            }
        }
        return temp;
    }

    public String stampaSala() {
        String sala = "";
        System.out.println("Nella sala è / sono presente/i: ");
        for (ArtWork o : esposizione) {
            System.out.println(o);
            sala += o;
        }
        return sala;
    }

    public String stampaDeposito() {
        String dep = "";
        System.out.println("Nel deposito è / sono presente/i: ");
        for (ArtWork o : deposito) {
            System.out.println(o);
            dep += o;
        }
        return dep;
    }

    public void autore(Author a) {
        System.out.println("Le opere di questo autore sono:");
        int count = 0;
        for (ArtWork o : esposizione) {
            if (o.author == a) {
                System.out.println(o);
                count++;
            }
        }
        for (ArtWork o : deposito) {
            if (o.author == a) {
                System.out.println(o);
                count++;
            }
        }
        if (count == 0) {
            try {
                throw new NotFound();
            } catch (NotFound e) {
                System.out.println("Autore non trovato!");
            }
        }
    }

    public void materiale(String material) {
        System.out.println("Le opere fatte di " + material + " sono: ");
        int count = 0;

        for (ArtWork o : esposizione) {
            if (o instanceof Statue) {
                Statue s = (Statue) o;
                if ((s.getMaterial().equals(material.toUpperCase()))) {
                    System.out.println(o);
                    count++;
                }
            }
        }
        for (ArtWork o : deposito) {
            if (o instanceof Statue) {
                Statue s = (Statue) o;
                if ((s.getMaterial().equals(material.toUpperCase()))) {
                    System.out.println(o);
                    count++;
                }
            }
        }
        if (count == 0) {
            try {
                throw new NotFound();
            } catch (NotFound e) {
                System.out.println("Opera non trovata!");
            }
        }
    }

    public void tecnica(String technique) {
        System.out.println("Le opere con questa tecnica sono:");
        int count = 0;

        for (ArtWork o : esposizione) {
            if (o instanceof Painting) {
                Painting q = (Painting) o;
                if ((q.getTechnique().equals(technique.toUpperCase()))) {
                    System.out.println(o);
                    count++;
                }
            }
        }
        for (ArtWork o : deposito) {
            if (o instanceof Painting) {
                Painting q = (Painting) o;
                if ((q.getTechnique().equals(technique.toUpperCase()))) {
                    System.out.println(o);
                    count++;
                }
            }
        }
        if (count == 0) {
            try {
                throw new NotFound();
            } catch (NotFound e) {
                System.out.println("Opera non trovata!");
            }
        }
    }

    public void spostaTutteStatue(TreeSet<Statue> set2) {
        for (ArtWork a : deposito) {
            if (a instanceof Statue) {
                set2.add((Statue) a);
            }
        }
        for (ArtWork a : esposizione) {
            if (a instanceof Statue) {
                set2.add((Statue) a);
            }
        }
        System.out.println("Tutte le statue sono state spostate in collezione");
    }

    public void spostaTuttiDipinti(TreeSet<Painting> set1) {
        for (ArtWork a : deposito) {
            if (a instanceof Painting) {
                set1.add((Painting) a);
            }
        }
        for (ArtWork a : esposizione) {
            if (a instanceof Painting) {
                set1.add((Painting) a);
            }
        }
        System.out.println("Tutti i dipinti sono stati spostati in collezione");
    }

    public TreeSet<Painting> sortTechnique(Comparator<Painting> comp) {
        TreeSet<Painting> a = new TreeSet<>(comp);
        spostaTuttiDipinti(a);
        collezioneDipinti = a;
        return collezioneDipinti;
    }

    public TreeSet<Painting> sortTitlePainting() {
        Comparator<Painting> comp = new Comparator<Painting>() {
            @Override
            public int compare(Painting o1, Painting o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        TreeSet<Painting> b = new TreeSet<>(comp);
        spostaTuttiDipinti(b);
        collezioneDipinti = b;
        return collezioneDipinti;
    }
    public TreeSet<Painting> sortAuthorNamePainting(){
        Comparator<Painting> comp = new Comparator<Painting>() {
            @Override
            public int compare(Painting o1, Painting o2) {
                return o1.author.getName().compareTo(o2.author.getName());
            }
        };
        TreeSet<Painting> g = new TreeSet<>(comp);
        spostaTuttiDipinti(g);
        collezioneDipinti = g;
        return collezioneDipinti;
    }
    public TreeSet<Painting> sortAuthorPainting(){
        Comparator<Painting> comp = new Comparator<Painting>() {
            @Override
            public int compare(Painting o1, Painting o2) {
                return o1.author.compareTo(o2.author);
            }
        };
        TreeSet<Painting> i = new TreeSet<>(comp);
        spostaTuttiDipinti(i);
        collezioneDipinti = i;
        return collezioneDipinti;
    }

    public TreeSet<Statue> sortMaterial(Comparator<Statue> comp) {
        TreeSet<Statue> c = new TreeSet<>(comp);
        spostaTutteStatue(c);
        collezioneStatue = c;
        return collezioneStatue;
    }

    public TreeSet<Statue> sortTitleStatue() {
        Comparator<Statue> comp = new Comparator<Statue>() {
            @Override
            public int compare(Statue o1, Statue o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        TreeSet<Statue> d = new TreeSet<>(comp);
        spostaTutteStatue(d);
        collezioneStatue = d;
        return collezioneStatue;
    }

    public TreeSet<Statue> sortHeight(){
        Comparator<Statue> comp1 = new Comparator<Statue>() {
            @Override
            public int compare(Statue s1, Statue s2) {
                return Double.compare(s1.height, s2.height);
            }
        };

        TreeSet<Statue> e = new TreeSet<>(comp1);
        spostaTutteStatue(e);
        collezioneStatue = e;
        return collezioneStatue;
    }
    public TreeSet<Statue> sortAuthorNameStatue(){
        Comparator<Statue> comp = new Comparator<Statue>() {
            @Override
            public int compare(Statue o1, Statue o2) {
                return o1.author.getName().compareTo(o2.author.getName());
            }
        };
        TreeSet<Statue> f = new TreeSet<>(comp);
        spostaTutteStatue(f);
        collezioneStatue = f;
        return collezioneStatue;
    }
    public TreeSet<Statue> sortAuthorStatue(){
        Comparator<Statue> comp = new Comparator<Statue>() {
            @Override
            public int compare(Statue o1, Statue o2) {
                return o1.author.compareTo(o2.author);
            }
        };
        TreeSet<Statue> h = new TreeSet<>(comp);
        spostaTutteStatue(h);
        collezioneStatue = h;
        return collezioneStatue;
    }

    public void addAuthor(Author a){
        artisti.add(a);
        System.out.println("Artista aggiunto nella collezione");
    }
    public void sortAuthors(){
        for (Author a : artisti) {
            System.out.println(a);
        }
    }
}
