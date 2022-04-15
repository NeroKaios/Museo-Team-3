import java.net.StandardSocketOptions;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Museum m1 = new Museum();

        Author a1 = new Author("Mario", "Rossi", "1900-03-02");
        Author a2 = new Author("Luigi", "Verdi", "1920-04-05");
        Author a3 = new Author("Giacomo", "Neri", "1940-06-07");

        Statue s1 = new Statue("Gesso", 3.20, "Il matto", a1);
        Statue s2 = new Statue("Marmo", 7.00, "Il pazzo", a2);
        Statue s3 = new Statue("Calce", 5.00, "Il folle", a3);

        Painting q1 = new Painting("Carbone", "Sadness", a1);
        Painting q2 = new Painting("Acquerello", "Happiness", a2);
        Painting q3 = new Painting("Olio", "Joy", a3);

        m1.checkArtWork(s1);
        m1.checkArtWork(s2);
        m1.checkArtWork(s3);

        m1.checkArtWork(q1);
        m1.checkArtWork(q2);
        m1.checkArtWork(q3);

        m1.addAuthor(a1);
        m1.addAuthor(a2);
        m1.addAuthor(a3);

        System.out.println("Cosa desidera visualizzare?");
        System.out.println("1: Statue");
        System.out.println("2: Quadri");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                System.out.println("Quale attributo desideri ordinare?");
                System.out.println("1: Materiale");
                System.out.println("2: Altezza");
                System.out.println("3: Titolo");
                System.out.println("4: Nome Autore");
                System.out.println("5: Data Autore");
                int choice2 = new Scanner(System.in).nextInt();
                switch (choice2) {
                    case 1:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice3 = new Scanner(System.in).nextInt();
                        switch (choice3) {
                            case 1: {
                                for (Statue s : m1.sortMaterial(Statue::compareTo)) {
                                    System.out.println(s);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortMaterial(Statue::compareTo);
                                TreeSet<Statue> temp = (TreeSet<Statue>) m1.collezioneStatue.descendingSet();
                                m1.spostaTutteStatue(temp);
                                for (Statue s : temp) {
                                    System.out.println(s);
                                }
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice4 = new Scanner(System.in).nextInt();
                        switch (choice4) {
                            case 1: {
                                for (Statue s : m1.sortHeight()) {
                                    System.out.println(s);
                                }
                                break;
                            }
                            case 2: {
                                TreeSet<Statue> temp = (TreeSet<Statue>) m1.sortHeight().descendingSet();
                                m1.spostaTutteStatue(temp);
                                for (Statue s : temp) {
                                    System.out.println(s);
                                }
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice5 = new Scanner(System.in).nextInt();
                        switch (choice5) {
                            case 1: {
                                for (Statue s : m1.sortTitleStatue()) {
                                    System.out.println(s);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortTitleStatue();
                                TreeSet<Statue> temp = (TreeSet<Statue>) m1.collezioneStatue.descendingSet();
                                m1.spostaTutteStatue(temp);
                                for (Statue s : temp) {
                                    System.out.println(s);
                                }
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice6 = new Scanner(System.in).nextInt();
                        switch (choice6) {
                            case 1: {
                                for (Statue s : m1.sortAuthorNameStatue()) {
                                    System.out.println(s);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortAuthorNameStatue();
                                TreeSet<Statue> temp = (TreeSet<Statue>) m1.collezioneStatue.descendingSet();
                                m1.spostaTutteStatue(temp);
                                for (Statue s : temp) {
                                    System.out.println(s);
                                }
                            }
                            break;
                        }
                        break;
                    case 5:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice11 = new Scanner(System.in).nextInt();
                        switch (choice11){
                            case 1: {
                                for (Statue s : m1.sortAuthorStatue()) {
                                    System.out.println(s);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortAuthorStatue();
                                TreeSet<Statue> temp = (TreeSet<Statue>) m1.collezioneStatue.descendingSet();
                                m1.spostaTutteStatue(temp);
                                for (Statue s : temp) {
                                    System.out.println(s);
                                }
                                break;
                            }
                        }
                }
                break;
            case 2:
                System.out.println("Quale attributo desideri ordinare?");
                System.out.println("1: Tecnica");
                System.out.println("2: Titolo");
                System.out.println("3: Nome Autore");
                System.out.println("4: Data Autore");
                int choice7 = new Scanner(System.in).nextInt();
                switch (choice7) {
                    case 1:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice8 = new Scanner(System.in).nextInt();
                        switch (choice8) {
                            case 1: {
                                for (Painting p : m1.sortTechnique(Painting::compareTo)) {
                                    System.out.println(p);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortTechnique(Painting::compareTo);
                                TreeSet<Painting> temp = (TreeSet<Painting>) m1.collezioneDipinti.descendingSet();
                                m1.spostaTuttiDipinti(temp);
                                for (Painting p : temp) {
                                    System.out.println(p);
                                }
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice9 = new Scanner(System.in).nextInt();
                        switch (choice9) {
                            case 1: {
                                for (Painting p : m1.sortTitlePainting()) {
                                    System.out.println(p);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortTitlePainting();
                                TreeSet<Painting> temp = (TreeSet<Painting>) m1.collezioneDipinti.descendingSet();
                                m1.spostaTuttiDipinti(temp);
                                for (Painting p : temp) {
                                    System.out.println(p);
                                }
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Come si desidera ordinare questo parametro?");
                        System.out.println("1: Ascendente");
                        System.out.println("2: Discendente");
                        int choice10 = new Scanner(System.in).nextInt();
                        switch (choice10) {
                            case 1: {

                                for (Painting p : m1.sortAuthorPainting()) {
                                    System.out.println(p);
                                }
                                break;
                            }
                            case 2: {
                                m1.sortAuthorPainting();
                                TreeSet<Painting> temp = (TreeSet<Painting>) m1.collezioneDipinti.descendingSet();
                                m1.spostaTuttiDipinti(temp);
                                for (Painting p : temp) {
                                    System.out.println(p);
                                    break;
                                }
                            }
                        }
                }
        }
    }
}
