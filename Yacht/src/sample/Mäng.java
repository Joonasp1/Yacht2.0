package sample;

public class Mäng {
    private Mängija[] mängijad;
    private Täringud täringud = new Täringud();
    private String valik;
    private Skoorimine skoor = new Skoorimine();
    private int tingumusvalik;

    private int hetkeMängijaIndeks;

    public void alusta() {//Mängu alustamine
        
    }

    public void järgmine() {//Meetod valib uueks käiguks uue mängija
        hetkeMängijaIndeks++;

        if (hetkeMängijaIndeks >= mängijad.length) {
            hetkeMängijaIndeks = 0;
        }

        käik(mängijad[hetkeMängijaIndeks]);
    }

    public void käik(Mängija mängija) {
        /*
        System.out.println(mängija.getNimi() + " käik");
        valik = "";

        System.out.println("Valige skoorimistingimus:");
        skoor.näitaTingimused();
        tingumusvalik = scanner.nextInt();

        while (täringud.getKordus() < 3 && !valik.equals("ei")){ //Tsüklist väljutakse, kui veeretatud on 3 korda või kui kasutaja sisestab "ei"
            if(valik.equals("")) täringud.veereta();
            else täringud.veereta(täringud.getTäringud(), valik);
            täringud.setKordus(täringud.getKordus() + 1);
            System.out.println(täringud.toString());
            if(täringud.getKordus()< 3){
                System.out.println("Valige täringud mida uuesti veeretada (1-5 ja eraldage komadega). Kirjuta \"ei\" kui ei soovi veeretada");
                valik = scanner.next();
            }
        }

        mängija.liidaSkoor(skoor.skoori(tingumusvalik,täringud.getTäringud()));
        System.out.println(mängija.getNimi() + " Skoor on: " + mängija.getSkoor());
        täringud.setKordus(0);
        if(skoor.getTingimused().isEmpty()) kokkuvõte(mängijad);
        else järgmine();
         */
    }

    public void kokkuvõte() {//Teeb kokkuvõtte mängust ja annab teada, kes võitis
        System.out.println("Mängijate tulemused:");
        int võitskoor = -1;
        String võitjanimi = "";
        for (Mängija mängija : mängijad){
            if(võitskoor < mängija.getSkoor()){
                võitjanimi = mängija.getNimi();
                võitskoor = mängija.getSkoor();
            }
            //System.out.println(mängija.getNimi() + ": " + mängija.getSkoor());
        }
        //System.out.println("Võitja on " + võitjanimi + " punktisummaga " + võitskoor);
    }
}
