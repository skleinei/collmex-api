package com.k15t.collmex;

import com.k15t.collmex.model.Angebot;

import java.io.IOException;


/**
 */
public class App {

    Collmex collmex = new Collmex("128733", "stefan", "stefan", 1);


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
                                .einzelpreis(111.20F)
                                .menge(1)
                )
                .addPosition(
                        Angebot.neuePosition()
                                .positionstyp(Angebot.Position.Typ.NORMAL_POSITION)
                                .produktnummer("5")
                                .produktbeschreibung("1asdfasdf")
                                .einzelpreis(333.20F)
                                .menge(1)
                )
                .addPosition(
                        Angebot.neuePosition()
                                .positionstyp(Angebot.Position.Typ.NORMAL_POSITION)
                                .produktnummer("5")
                                .produktbeschreibung("2asdfasdf")
                                .einzelpreis(333.20F)
                                .menge(3)
                );

        collmex.create(angebot);
    }

}
