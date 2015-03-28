package com.k15t.collmex;

import com.k15t.collmex.model.Angebot;

import java.io.IOException;


/**
 */
public class App {

    Collmex collmex = new Collmex("128733", "user", "pass", 1);


    public static void main(String[] args) throws IOException {

        App app = new App();
        app.run();
    }


    private void run() throws IOException {
        String produktnummer = "ACLX02000CU";
        String positionstext = "Aggrolinx, 666 User";

        Angebot angebot = collmex.neuesAngebot()
                .kundenNr(10000)
                .addPosition(
                        Angebot.neuePosition()
                                .positionstyp(Angebot.Position.Typ.NORMAL_POSITION)
                                .produktnummer(produktnummer)
                                .produktbeschreibung(positionstext)
                                .menge(1)
                );

        collmex.create(angebot);
    }

}
