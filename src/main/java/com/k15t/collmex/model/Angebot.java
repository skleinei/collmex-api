package com.k15t.collmex.model;


import com.k15t.collmex.Collmex;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;


public class Angebot extends Datensatz {

    private static final String _ = ";";
    private static final String SATZART = "CMXQTN";
    private Integer angebotsnummer;
    private final Integer firmaNr;
    private Integer kundenNr;
    private DateTime angebotsdatum;
    private DateTime preisdatum;
    private Integer zahlungsbedingung;
    private String waehrung;

    public List<Position> positionen = new ArrayList<Position>();


    public Angebot(Collmex collmex) {
        firmaNr = collmex.getFirmaNr();
    }


    public Angebot angebotsnummer(Integer angebotsnummer) {
        this.angebotsnummer = angebotsnummer;
        return this;
    }


    public Angebot kundenNr(Integer kundenNr) {
        this.kundenNr = kundenNr;
        return this;
    }


    public Angebot angebotsdatum(DateTime angebotsdatum) {
        this.angebotsdatum = angebotsdatum;
        return this;
    }


    public Angebot preisdatum(DateTime preisdatum) {
        this.preisdatum = preisdatum;
        return this;
    }


    public Angebot zahlungsbedingung(Integer zahlungsbedingung) {
        this.zahlungsbedingung = zahlungsbedingung;
        return this;
    }


    public Angebot waehrung(String waehrung) {
        this.waehrung = waehrung;
        return this;
    }


    @Override
    public String toCsv() {

        String csv = "";
        int pos = 0;

        for (Position position : positionen) {
            pos++;

            csv += field("Satzart", Typ.C, null, SATZART);
            csv += field("Angebotsnummer", Typ.I, 8, angebotsnummer);
            csv += field("Position", Typ.I, 8, pos);
            csv += field("Angebotsart", Typ.I, 8);
            csv += field("Firma Nr", Typ.I, 8, firmaNr);
            csv += field("Kunden-Nr", Typ.I, 8, kundenNr);
            csv += field("Kunde-Anrede", Typ.C, 10);
            csv += field("Kunde-Titel", Typ.C, 10);
            csv += field("Kunde-Vorname", Typ.C, 40);
            csv += field("Kunde-Name ", Typ.C, 40);
            csv += field("Kunde-Firma ", Typ.C, 80);
            csv += field("Kunde-Abteilung ", Typ.C, 80);
            csv += field("Kunde-Strasse ", Typ.C, 80);
            csv += field("Kunde-PLZ ", Typ.C, 10);
            csv += field("Kunde-Ort ", Typ.C, 20);
            csv += field("Kunde-Land", Typ.C, 2);
            csv += field("Kunde-Telefon ", Typ.C, 20);
            csv += field("Kunde-Telefon2 ", Typ.C, 20);
            csv += field("Kunde-Telefax ", Typ.C, 20);
            csv += field("Kunde-E-Mail ", Typ.C, 50);
            csv += field("Kunde-Kontonr ", Typ.C, 20);
            csv += field("Kunde-Blz ", Typ.C, 20);
            csv += field("Kunde-Abweichender Kontoinhaber", Typ.C, 40);
            csv += field("Kunde-IBAN", Typ.C, 20);
            csv += field("Kunde-BIC", Typ.C, 20);
            csv += field("Kunde-Bank", Typ.C, 20);
            csv += field("Kunde-USt.IdNr", Typ.C, 20);
            csv += field("Kunde-Privatperson", Typ.I, 8);
            csv += field("Angebotsdatum", Typ.D, 8, angebotsdatum);
            csv += field("Preisdatum", Typ.D, 8, preisdatum);
            csv += field("Zahlungsbedingung", Typ.I, 8, zahlungsbedingung);
            csv += field("Währung (ISO-Codes)", Typ.C, 3, waehrung);
            csv += field("Preisgruppe", Typ.I, 8);
            csv += field("Rabattgruppe", Typ.I, 8);
            csv += field("Schluss-Rabatt", Typ.I, 8);
            csv += field("Rabattgrund", Typ.C, 255);
            csv += field("Angebotstext", Typ.C, 1024);
            csv += field("Schlusstext", Typ.C, 1024);
            csv += field("Internes Memo", Typ.C, 1024);
            csv += field("Gelöscht", Typ.I, 8);
            csv += field("Abgelehnt am", Typ.D, 8);
            csv += field("Sprache", Typ.I, 8);
            csv += field("Bearbeiter", Typ.I, 8);
            csv += field("Vermittler", Typ.I, 8);
            csv += field("Schluss-Rabatt-2", Typ.M, 18);
            csv += field("Schluss-Rabatt-2-Grund", Typ.C, 20);
            csv += field("Status", Typ.I, 8);
            csv += field("Reserviert", Typ.C, 8);
            csv += field("Versandart", Typ.I, 8);
            csv += field("Versandkosten", Typ.M, 18);
            csv += field("Nachnahmegebühr", Typ.M, 18);
            csv += field("Liefer/Leistungsdatum", Typ.D, 8);
            csv += field("Lieferbedingung ", Typ.C, 3);
            csv += field("Lieferbedingung Zusatz", Typ.C, 40);
            csv += field("LieferAdr-Anrede", Typ.C, 10);
            csv += field("LieferAdr-Titel", Typ.C, 10);
            csv += field("LieferAdr-Vorname", Typ.C, 40);
            csv += field("LieferAdr-Name ", Typ.C, 40);
            csv += field("LieferAdr-Firma ", Typ.C, 80);
            csv += field("LieferAdr-Abteilung ", Typ.C, 80);
            csv += field("LieferAdr-Strasse ", Typ.C, 80);
            csv += field("LieferAdr-PLZ ", Typ.C, 10);
            csv += field("LieferAdr-Ort ", Typ.C, 20);
            csv += field("LieferAdr-Land", Typ.C, 2);
            csv += field("LieferAdr-Telefon ", Typ.C, 20);
            csv += field("LieferAdr-Telefon2 ", Typ.C, 20);
            csv += field("LieferAdr-Telefax ", Typ.C, 20);
            csv += field("LieferAdr-E-Mail ", Typ.C, 50);
            csv += field("Positionstyp", Typ.I, 8, position.positionstyp);
            csv += field("Produktnummer", Typ.C, 20, position.produktnummer);
            csv += field("Produktbeschreibung", Typ.C, 10000, position.produktbeschreibung);
            csv += field("Mengeneinheit", Typ.C, 3);
            csv += field("Menge", Typ.N, 18, position.menge);
            csv += field("Einzelpreis", Typ.M, 18, position.einzelpreis);
            csv += field("Preismenge", Typ.N, 18);
            csv += field("Positionsrabatt", Typ.M, 18, position.positionsRabatt);
            csv += field("Positionswert", Typ.M, 18);
            csv += field("Produktart", Typ.I, 18);
            csv += field("Steuerklassifikation", Typ.I, 8);
            csv += field("Steuer auch im Ausland", Typ.I, 8);
            csv += field("Erlösart", Typ.I, 8);
            csv += field("Summe über Pos.", Typ.I, 8);
            csv += field("Umsatz", Typ.M, 18);
            csv += field("Kosten", Typ.M, 18);
            csv += field("Rohertrag", Typ.M, 18);
            csv += field("Marge", Typ.M, 18);
        }

        return csv;
    }


    public Angebot addPosition(Position position) {
        positionen.add(position);
        return this;
    }


    public static Position neuePosition() {
        return new Position();
    }


    public static class Position {

        public interface Typ {

            public static final Integer NORMAL_POSITION = 0;
            public static final Integer SUMMEN_POSITION = 1;
            public static final Integer TEXT_POSITION = 2;
            public static final Integer KOSTENLOS = 3;
        }

        private Integer positionstyp = Typ.NORMAL_POSITION;
        private String produktnummer;
        private String produktbeschreibung;
        private Integer menge;
        private Float einzelpreis;
        private Float positionsRabatt;


        public Position positionstyp(Integer positionstyp) {
            this.positionstyp = positionstyp;
            return this;
        }


        public Position produktnummer(String produktnummer) {
            this.produktnummer = produktnummer;
            return this;
        }


        public Position produktbeschreibung(String produktbeschreibung) {
            this.produktbeschreibung = produktbeschreibung;
            return this;
        }


        public Position menge(Integer menge) {
            this.menge = menge;
            return this;
        }


        public Position einzelpreis(Float einzelpreis) {
            this.einzelpreis = einzelpreis * 100;
            return this;
        }


        public Position positionsrabatt(Float positionsrabatt) {
            this.positionsRabatt = positionsrabatt;
            return this;
        }

    }

}
