package com.k15t.collmex.examples;

import com.k15t.collmex.Collmex;
import com.k15t.collmex.angebot.Angebot;
import com.k15t.collmex.angebot.Position;

import java.io.IOException;


/**
 */
public class CreateAngebot {

    Collmex collmex = new Collmex("128733", "user", "pass", 1, true);


    public static void main(String[] args) throws IOException {

        CreateAngebot createAngebot = new CreateAngebot();
        createAngebot.run();
    }


    private void run() throws IOException {
        String produktnummer = "ACLX02000CU";
        String positionstext = "Aggrolinx, 666 User";


        Angebot angebot1 = Angebot.create(-1)
                .kundenNr(10000)
                .addPosition(
                        Position.create(10)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer(produktnummer)
                                .produktbeschreibung(positionstext)
                                .einzelpreis(111.20)
                                .menge(1.0)
                                .kosten(11.1)
                )
                .addPosition(
                        Position.create(20)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer("5")
                                .produktbeschreibung("1asdfasdf")
                                .einzelpreis(222.20)
                                .menge(1.0)
                                .kosten(22.2)
                )
                .addPosition(
                        Position.create(30)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer("5")
                                .produktbeschreibung("2asdfasdf")
                                .einzelpreis(333.20)
                                .positionsrabatt(50.0)
                                .menge(1.0)
                                .kosten(33.3)
        );
        Angebot angebot2 = Angebot.create(-2)
                .kundenNr(10000)
                .addPosition(
                        Position.create(10)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer(produktnummer)
                                .produktbeschreibung("second quote, pos 1")
                                .einzelpreis(111.20)
                                .menge(1.0)
                                .kosten(11.1)
                )
                .addPosition(
                        Position.create(20)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer("5")
                                .produktbeschreibung("second quote, pos 2")
                                .einzelpreis(222.20)
                                .menge(1.0)
                                .kosten(22.2)
                )
                .addPosition(
                        Position.create(30)
                                .positionstyp(Position.Typ.NORMAL_POSITION)
                                .produktnummer("5")
                                .produktbeschreibung("second quote, pos 3")
                                .einzelpreis(333.20)
                                .positionsrabatt(5.0)
                                .menge(1.0)
                                .kosten(33.3)
        );

        collmex.save(angebot1, angebot2);
    }

}
