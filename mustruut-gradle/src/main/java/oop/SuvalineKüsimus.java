package oop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SuvalineKüsimus extends Küsimused{

    public SuvalineKüsimus(Küsimused küsimused) {
        super(küsimused.getKüsimused());
    }

    public String SuvalineKüsimusmeetod(){
        return küsimused.get((int)(Math.random()*küsimused.size()));
    }

    public List<String> Tsükkel(){
        List<String> õigedKüsimused = new ArrayList<>();
        while (true) {
            for (int i = 0; i <= 5; i++) {
                õigedKüsimused.add(SuvalineKüsimusmeetod());
            }

            Set<String> hulk = new HashSet<String>();
            for (String küsimus : õigedKüsimused){
                hulk.add(küsimus);
            }

            if (hulk.size()!=õigedKüsimused.size()){
                õigedKüsimused.clear();
                hulk.clear();
            }

            else {
                break;
            }
        }
        return õigedKüsimused;
    }
}
