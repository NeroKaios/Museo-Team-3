import java.time.LocalDate;

public class Author implements Comparable<Author>{
    protected String name;
    protected String surname;
    protected LocalDate birth;

    public Author(String name, String surname, String birth) {
        this.name = name;
        this.surname = surname;
        this.birth = LocalDate.parse(birth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return " nome = '" + getName() + '\'' +
                ", cognome = '" + getSurname() + '\'' +
                " data di nascita = " + birth.toString();
    }

    @Override
    public int compareTo(Author a) {
        return this.birth.compareTo(a.birth);
    }
}
