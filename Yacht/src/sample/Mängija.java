package sample;

public class Mängija {
    private String nimi;
    private int skoor;

    public String getNimi() {
        return nimi;
    }

    public int getSkoor() {return skoor;}

    public void liidaSkoor(int lisaskoor){skoor += lisaskoor;}

    public Mängija(String nimi) {
        this.nimi = nimi;
    }
}
