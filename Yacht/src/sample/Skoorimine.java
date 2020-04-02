package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Skoorimine {

    private List<String> tingimused = new ArrayList<String>(Arrays.asList
            ("1. Ühed", "2. Kahed", "3. Kolmed", "4. Neljad", "5. Viied", "6. Kuued",
                    "7. Maja", "8. Nelik", "9. 1-2-3-4-5", "10. 2-3-4-5-6", "11. Täringute summa", "12. Yacht\n"));



    public void näitaTingimused(){
        for (String tingimus : tingimused){
            System.out.println(tingimus);
        }
    }

    public List<String> getTingimused(){return tingimused;}

    public int skoori(int valik, int[] täringud){
        int skoor = 0;
        int[] numbrid = new int[]{1,2,3,4,5,6};
        int[] sorttäring = täringud.clone();
        Arrays.sort(sorttäring);

        switch(valik){
            case 1:
                for (int num : täringud){
                    if(num == 1) skoor++;
                }
                tingimused.remove("1. Ühed");
                break;
            case 2:
                for (int num : täringud){
                    if(num == 2) skoor+= 2;
                }
                tingimused.remove("2. Kahed");
                break;
            case 3:
                for (int num : täringud){
                    if(num == 3) skoor+= 3;
                }
                tingimused.remove("3. Kolmed");
                break;
            case 4:
                for (int num : täringud){
                    if(num == 4) skoor+= 4;
                }
                tingimused.remove("4. Neljad");
                break;
            case 5:
                for (int num : täringud){
                    if(num == 5) skoor+= 5;
                }
                tingimused.remove("5. Viied");
                break;
            case 6:
                for (int num : täringud){
                    if(num == 6) skoor+= 6;
                }
                tingimused.remove("6. Kuued");
                break;
            case 7:
                int[] unique = IntStream.of(täringud).distinct().toArray();
                if(unique.length == 2){
                    int esimene = 0;
                    int teine = 0;
                    for(int num : täringud){
                        if (num == unique[0]) esimene++;
                        else teine++;
                    }
                    if((esimene == 3 && teine == 2) || (esimene == 2 && teine == 3)){
                        skoor += (esimene * unique[0]) + (teine * unique[1]);
                    }
                }
                tingimused.remove("7. Maja");
                break;
            case 8:
                for(int num : numbrid){
                    int mitu = 0;
                    for(int täring : täringud){
                        if(num == täring) mitu++;
                    }
                    if(mitu >= 4){
                        skoor += mitu * num;
                        break;
                    }
                }
                tingimused.remove("8. Nelik");
                break;
            case 9:
                if(sorttäring[0] == 1 && sorttäring[1] == 2 && sorttäring[2] == 3 && sorttäring[3] == 4 && sorttäring[4] == 5)
                    skoor += 30;
                tingimused.remove("9. 1-2-3-4-5");
                break;
            case 10:
                if(sorttäring[0] == 2 && sorttäring[1] == 3 && sorttäring[2] == 4 && sorttäring[3] == 5 && sorttäring[4] == 6)
                    skoor += 30;
                tingimused.remove("10. 2-3-4-5-6");
                break;
            case 11:
                for (int num:täringud)
                    skoor += num;
                tingimused.remove("11. Täringute summa");
                break;
            case 12:
                boolean sama = true;
                int num = täringud[0];
                for(int tar : täringud){
                    if(tar != num){
                        sama = false;
                        break;
                    }
                }
                if(sama) skoor += 50;
                tingimused.remove("12. Yacht\n");
                break;
        }

        return skoor;
    }
}
