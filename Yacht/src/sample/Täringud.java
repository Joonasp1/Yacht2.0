package sample;

public class Täringud {
    private int[] täringud = new int[5];
    private int kordus = 0;

    private static final int maxKordusteArv = 2; // Mitu korda saab uuesti veeretada peale esialgset veeretust.

    public int[] getTäringuVäärtused() {
        return täringud;
    }

    public int getKordus(){return kordus;}

    public void setKordus(int kordus){this.kordus = kordus;}

    public void lisaKordus() {
        kordus++;
    }

    public boolean võibUuestiVeeretada() {
        if (kordus > maxKordusteArv) {
            return false;
        }
        return true;
    }

    public int[] veereta(){
        for (int i = 0; i < täringud.length; i++) {
            int arv = (int)(Math.round(Math.random()*5+1));
            täringud[i] = arv;
        }
        return täringud;
    }

    public int[] veereta(int[] täringud, String[] uuesti){
        for (String num : uuesti){
            täringud[Integer.parseInt(num) - 1] = (int)(Math.round(Math.random()*5+1));
        }
        return täringud;
    }
}
