package oop;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Esinejad {

    public String nimi;
    public List<String> eesliide;
    public List<String> vastused;
    public List<String> suurSõna;
    public List<String> esinejad;

    public Esinejad(List<String> eesliide, List<String> vastused, List<String> suurSõna) {
        this.eesliide = eesliide;
        this.vastused = vastused;
        this.suurSõna = suurSõna;
        List<String> esinejadtemp = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            nimi = "";
            nimi += eesliide.get((int) (Math.random() * eesliide.size())) + vastused.get((int) (Math.random() * vastused.size())) + " " + suurSõna.get((int)
                    (Math.random() * suurSõna.size()));
            esinejadtemp.add(nimi);
        }
        this.esinejad = esinejadtemp;
    }

    public void väljastaEsinejad(){
        for (String esineja : esinejad){
            System.out.println(esineja);
        }
    }

    public List<String> getEsinejad() {
        return esinejad;
    }
}
