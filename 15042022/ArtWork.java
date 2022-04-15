public class ArtWork{
    protected static int id = 0;
    private int codiceIdentificativo;
    protected String title;
    protected Author author;

    public ArtWork(String title, Author author) {
        this.codiceIdentificativo = ++id;
        this.title = title;
        this.author = author;
    }

    public int getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(int codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Opera: " +
                "codice = " + codiceIdentificativo +
                ", titolo ='" + title + '\'' +
                ", autore = " + author.toString();
    }
}
