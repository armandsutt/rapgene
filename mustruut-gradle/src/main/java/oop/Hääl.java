/*package oop;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.List;
import java.util.Locale;

public class Hääl {
    private Esinejad esinejateNimed;

    public Hääl(Esinejad esinejateNimed){
        this.esinejateNimed = esinejateNimed;
    }

    public void teeHäält() {
        try {
            System.setProperty("freetts.voices",  "com.sun.speech.freetts.en.us.cmu_us_kal." +
                            "KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech." +
                    "freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer synteesija = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));

            List<String> mdea = esinejateNimed.getEsinejad();
            synteesija.allocate();
            synteesija.resume();
            synteesija.speakPlainText("Lavale astuvad", null);
            synteesija.waitEngineState(Synthesizer.QUEUE_EMPTY);

            for (String nimi : mdea) {
                synteesija.resume();
                synteesija.speakPlainText(nimi, null);
                synteesija.waitEngineState(Synthesizer.QUEUE_EMPTY);
            }
            synteesija.deallocate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/