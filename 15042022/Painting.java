public class Painting extends ArtWork implements Comparable<Painting>{

    protected Technique technique;

    public enum Technique{
        OLIO, ACQUERELLO, CARBONE
    }

    public Painting(String technique, String title, Author author){
        super(title, author);
        this.technique = Technique.valueOf(technique.toUpperCase());
    }

    public String getTechnique() {
        return technique.name();
    }

    public void setTechnique(String technique) {
        this.technique = Technique.valueOf(technique.toUpperCase());
    }

    @Override
    public String toString() {
        return "Quadro " + super.toString() +
                "tecnica = ' " + technique + '\'' + '\n';
    }

    @Override
    public int compareTo(Painting p) {
        return this.technique.name().compareTo(p.technique.name());
    }
}
