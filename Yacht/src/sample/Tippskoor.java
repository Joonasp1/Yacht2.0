package sample;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Tippskoor {

    private static final String failinimi = "võitjad.txt";
    // Selles failis hoitakse kõik mängude võitjate tippskoorid.

    private static boolean andmedEksisteerivad() {
        File fail = new File(failinimi);
        if (fail.exists()) {
            return true;
        }
        return false;
    }

    public static Map<String, Integer> loeAndmed() { // Loeb failist tippskooride andmed.
        Map<String, Integer> skoorid = new HashMap<>();

        if (!andmedEksisteerivad()) {
            return skoorid;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(failinimi)));

            String rida;
            while ((rida = br.readLine()) != null) {
                String[] andmed = rida.split(",");
                String nimi = andmed[0];
                int skoor = Integer.parseInt(andmed[1]);
                skoorid.put(nimi, skoor);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return skoorid;
    }

    public static String skoorid() {
        if (!andmedEksisteerivad()) {
            return "Tippskoore pole veel.";
        }

        Map<String, Integer> skoorid = loeAndmed();

        StringBuilder sõneEhitaja = new StringBuilder();

        for (Map.Entry<String, Integer> skoor : skoorid.entrySet()) {
            sõneEhitaja.append(skoor.getKey());
            sõneEhitaja.append(",");
            sõneEhitaja.append(skoor.getValue());
            sõneEhitaja.append("\n");
        }

        return sõneEhitaja.toString();
    }

    public static void kirjutaAndmed(String võitjanimi, int võitskoor) { // Kirjutab faili tippskooride andmed.

        Map<String, Integer> skoorid = loeAndmed();
        if (skoorid.containsKey(võitjanimi) && võitskoor <= skoorid.get(võitjanimi)) { // Kui nimi on failis olemas, siis jätkatakse ainult siis, kui tema skoor on suurem kui eelmine.
            return;
        }
        else {
            skoorid.put(võitjanimi, võitskoor);
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(failinimi)));

            for (Map.Entry<String, Integer> skoor : skoorid.entrySet()) {
                bw.write(skoor.getKey() + "," + skoor.getValue() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
