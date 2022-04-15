public class Statue extends ArtWork implements Comparable<Statue>{

    public enum Material{
        GESSO, CALCE, MARMO
    }

    private Material material;
    protected double height;


    public Statue(String material, double height, String title, Author author) {
        super(title,author);
        this.material = Material.valueOf(material.toUpperCase());
        this.height = height;

    }

    public String getMaterial() {
        return material.name();
    }

    public void setMaterial(String material) {
        this.material=Material.valueOf(material.toUpperCase());
    }

    @Override
    public String toString() {
        return "Statua " + super.toString() + ", "  +
                "materiale = '" + material + " " + '\'' +
                ", altezza = " + height + " metri" + '\n';
    }

    @Override
    public int compareTo(Statue s) {
        return this.material.name().compareTo(s.material.name());
    }
}
