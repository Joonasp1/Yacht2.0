package sample;

public class Täringud {
    private int[] täringud = new int[5];
    private int kordus = 0;

    public int[] getTäringud() {
        return täringud;
    }

    public int getKordus(){return kordus;}

    public void setKordus(int kordus){this.kordus = kordus;}

    public int[] veereta(){
        for (int i = 0; i < täringud.length; i++) {
            int arv = (int)(Math.round(Math.random()*5+1));
            täringud[i] = arv;
        }
        return täringud;
    }

    public int[] veereta(int[] täringud, int[] uuesti){
        for (int num : uuesti){
            täringud[num - 1] = (int)(Math.round(Math.random()*5+1));
        }
        return täringud;
    }
}
