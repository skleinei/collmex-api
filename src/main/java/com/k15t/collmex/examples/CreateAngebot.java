package com.k15t.collmex.examples;

import com.k15t.collmex.Collmex;
import com.k15t.collmex.angebot.Angebot;
import com.k15t.collmex.angebot.Position;

import java.io.IOException;


/**
 */
public class CreateAngebot {

    Collmex collmex = new Collmex("145955", "api23", "123123", 1);


    public static void main(String[] args) throws IOException {

        CreateAngebot createAngebot = new CreateAngebot();
        createAngebot.run();
    }


    private void run() throws IOException {
        String produktnummer = "PROD0001";
        String positionstext = "AggroX, 666 User";


        Angebot angebot1 = Angebot.create(-1)
                .kundenNr(10000)
                .addPosition(
                        Position.create(10)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer(produktnummer)
//                                .produktbeschreibung(positionstext)
                                .einzelpreis(111.20)
                                .menge(1.0)
                                .kostenManuell(11.1)
                )
                .addPosition(
                        Position.create(20)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer(produktnummer)
                                .produktbeschreibung("1asdfasdf")
                                .einzelpreis(222.20)
                                .menge(1.0)
                                .kostenManuell(22.2)
                )
                .addPosition(
                        Position.create(30)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer(produktnummer)
                                .produktbeschreibung("2asdfasdf")
                                .einzelpreis(333.20)
                                .positionsrabatt(50.0)
                                .menge(1.0)
                                .kostenManuell(33.3)
        );


        collmex.save(angebot1);

//        Angebot angebot2 = Angebot.create(-2)
//                .kundenNr(10000)
//                .addPosition(
//                        Position.create(10)
//                                .positionstyp(Position.Typ.NORMAL_POSITION)
//                                .produktnummer(produktnummer)
//                                .produktbeschreibung("second quote, pos 1")
//                                .einzelpreis(111.20)
//                                .menge(1.0)
//                                .kostenManuell(11.1)
//                )
//                .addPosition(
//                        Position.create(20)
//                                .positionstyp(Position.Typ.NORMAL_POSITION)
//                                .produktnummer(produktnummer)
//                                .produktbeschreibung("second quote, pos 2")
//                                .einzelpreis(222.20)
//                                .menge(1.0)
//                                .kostenManuell(22.2)
//                )
//                .addPosition(
//                        Position.create(30)
//                                .positionstyp(Position.Typ.NORMAL_POSITION)
//                                .produktnummer(produktnummer)
//                                .produktbeschreibung("second quote, pos 3")
//                                .einzelpreis(333.20)
//                                .positionsrabatt(5.0)
//                                .menge(1.0)
//                                .kostenManuell(33.3)
//        );
//
//        collmex.save(angebot1, angebot2);
    }

}
