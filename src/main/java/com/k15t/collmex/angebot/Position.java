package com.k15t.collmex.angebot;

import com.k15t.collmex.Collmex;
import com.k15t.collmex.Datensatz;


public class Position {

    public interface Typ {

        Integer NORMAL_POSITION = 0;
        Integer SUMMEN_POSITION = 1;
        Integer TEXT_POSITION = 2;
        Integer KOSTENLOS = 3;
    }

    private Integer positionsnummer;
    private Integer positionstyp;
    private String produktnummer;
    private String produktbeschreibung;
    private String mengeneinheit;
    private Double menge;
    private Double einzelpreis;
    private Double preismenge;
    private Double positionsrabatt;
    private Double positionswert;
    private Integer produktart;
    private Integer steuerklassifikation;
    private Integer steuerauchimAusland;
    private Integer erloesart;
    private Integer summeueberPos;
    private Double umsatz;
    private Double kosten;
    private Double rohertrag;
    private Double marge;

    Angebot angebot;
    boolean needsScreenScraping;


    public static Position create(Integer positionsnummer) {
        return new Position(positionsnummer);
    }


    public Position(Integer positionsnummer) {
        this.positionsnummer = positionsnummer;
    }


//    public Position positionsnummer(Integer positionsnummer) {
//        Datensatz.validate("position", Datensatz.Datentyp.I, 8, positionsnummer);
//        this.positionsnummer = positionsnummer;
//        return this;
//    }


    /**
     * Position<br/>
     * Positionsnummer der Angebotsposition. Wenn nicht angegeben, wird die Positionsnummer automatisch fortlaufend vergeben.
     */
    public Integer positionsnummer() {
        return this.positionsnummer;
    }


    public Position positionstyp(Integer positionstyp) {
        Datensatz.validate("positionstyp", Datensatz.Datentyp.I, 8, positionstyp);
        this.positionstyp = positionstyp;
        return this;
    }


    /**
     * Positionstyp<br/>
     * 0 = Normalposition, 1 = Summenposition, 2 = Textposition, 3 = Kostenlos.
     */
    public Integer positionstyp() {
        return this.positionstyp;
    }


    public Position produktnummer(String produktnummer) {
        Datensatz.validate("produktnummer", Datensatz.Datentyp.C, 20, produktnummer);
        this.produktnummer = produktnummer;
        return this;
    }


    /**
     * Produktnummer<br/>
     * Falls nicht angegeben, muss die Produktbeschreibung gefüllt sein. Die Produktnummer muss in Collmex existieren.
     */
    public String produktnummer() {
        return this.produktnummer;
    }


    public Position produktbeschreibung(String produktbeschreibung) {
        Datensatz.validate("produktbeschreibung", Datensatz.Datentyp.C, 10000, produktbeschreibung);
        this.produktbeschreibung = produktbeschreibung;
        return this;
    }


    /**
     * Produktbeschreibung<br/>
     * Falls nicht angegeben, wird die Beschreibung aus dem Produkt übernommen.
     */
    public String produktbeschreibung() {
        return this.produktbeschreibung;
    }


    public Position mengeneinheit(String mengeneinheit) {
        Datensatz.validate("mengeneinheit", Datensatz.Datentyp.C, 3, mengeneinheit);
        this.mengeneinheit = mengeneinheit;
        return this;
    }


    /**
     * Mengeneinheit<br/>
     * ISO Codes. Falls nicht angegeben, wird die Mengeneinheit vom Produkt übernommen.
     */
    public String mengeneinheit() {
        return this.mengeneinheit;
    }


    public Position menge(Double menge) {
        Datensatz.validate("menge", Datensatz.Datentyp.N, 18, menge);
        this.menge = menge;
        return this;
    }


    /**
     * Menge<br/>
     * Auftragsmenge
     */
    public Double menge() {
        return this.menge;
    }


    public Position einzelpreis(Double einzelpreis) {
        Datensatz.validate("einzelpreis", Datensatz.Datentyp.M, 18, einzelpreis);
        this.einzelpreis = einzelpreis;
        return this;
    }


    /**
     * Einzelpreis<br/>
     * Falls nicht angegeben, wird der Preis über das Produkt bestimmt.
     */
    public Double einzelpreis() {
        return this.einzelpreis;
    }


    public Position preismenge(Double preismenge) {
        Datensatz.validate("preismenge", Datensatz.Datentyp.N, 18, preismenge);
        this.preismenge = preismenge;
        return this;
    }


    /**
     * Preismenge<br/>
     * Falls nicht angegeben, wird die Preismenge über das Produkt bestimmt bzw. auf 1 gesetzt.
     */
    public Double preismenge() {
        return this.preismenge;
    }


    public Position positionsrabatt(Double positionsrabatt) {
        Datensatz.validate("positionsrabatt", Datensatz.Datentyp.M, 18, positionsrabatt);
        this.positionsrabatt = positionsrabatt;
        return this;
    }


    /**
     * Positionsrabatt<br/>
     * Positionsrabatt in Prozent mit zwei Nachkommastellen.
     */
    public Double positionsrabatt() {
        return this.positionsrabatt;
    }


    /**
     * Positionswert<br/>
     * Nur für Export. Beim Import wird der Positionswert automatisch aus Preis und Rabatt berechnet.
     */
    public Double positionswert() {
        return this.positionswert;
    }


    public Position produktart(Integer produktart) {
        Datensatz.validate("produktart", Datensatz.Datentyp.I, 18, produktart);
        this.produktart = produktart;
        return this;
    }


    /**
     * Produktart<br/>
     * Wird beim Import nur verwendet, wenn kein Produkt gesetzt ist. 0 = Ware, 1 = Dienstleistung, 2 = Mitgliedsbeitrag (nur Collmex
     * Verein), 3 = Baudienstleistung
     */
    public Integer produktart() {
        return this.produktart;
    }


    public Position steuerklassifikation(Integer steuerklassifikation) {
        Datensatz.validate("steuerklassifikation", Datensatz.Datentyp.I, 8, steuerklassifikation);
        this.steuerklassifikation = steuerklassifikation;
        return this;
    }


    /**
     * Steuerklassifikation<br/>
     * Wird beim Import nur verwendet, wenn kein Produkt gesetzt ist. Andernfalls wird die Steuerklassifikation aus dem Produkt ermittelt
     * . 0 = voller Steuersatz, 1 = halber Steuersatz, 2 = steuerfrei.
     */
    public Integer steuerklassifikation() {
        return this.steuerklassifikation;
    }


    public Position steuerauchimAusland(Integer steuerauchimAusland) {
        Datensatz.validate("steuerauchimAusland", Datensatz.Datentyp.I, 8, steuerauchimAusland);
        this.steuerauchimAusland = steuerauchimAusland;
        return this;
    }


    /**
     * Steuer auch im Ausland<br/>
     * Optional. Wird beim Import nur verwendet, wenn kein Produkt gesetzt ist und die Produktart eine Dienstleistung ist. 0 = Sonstige
     * Leistung ist im Inland nicht steuerbar bei Leistungsort im Ausland, 1 = Sonstige Leistung ist im Inland steuerbar auch bei
     * Leistungsort im Ausland.
     */
    public Integer steuerauchimAusland() {
        return this.steuerauchimAusland;
    }


    /**
     * Erlösart<br/>
     * Nur für Export. 0 = voller Steuersatz<br>1 = halber Steuersatz<br>2 = steuerfreies Produkt<br>10 = Export<br>11 =
     * innergemeinschaftliche Lieferung<br>12 = Nicht steuerbare Umsätze<br>13 = Generell steuerbefreit (z.B. Kleinunternehmer)<br>14 =
     * Leistungsempfänger ist steuerpflichtig
     */
    public Integer erloesart() {
        return this.erloesart;
    }


    public Position summeueberPos(Integer summeueberPos) {
        Datensatz.validate("summeueberPos", Datensatz.Datentyp.I, 8, summeueberPos);
        this.summeueberPos = summeueberPos;
        return this;
    }


    /**
     * Summe über Pos.<br/>
     * Nur bei Summenpositionen: Die Positionsnummer der ersten Position der Summe.
     */
    public Integer summeueberPos() {
        return this.summeueberPos;
    }


    /**
     * Umsatz<br/>
     * Nur für Export. Netto-Umsatz der Position in Firmenwährung
     */
    public Double umsatz() {
        return this.umsatz;
    }


    /**
     * Setting kosten is not supported by the Collmex API. If you set this
     * value, we will try to set kosten via screen-scraping, which may not
     * be as stable as the API.
     * <p/>
     * <b>Note:</b> You have to switch on the extended via
     * {@link Collmex#Collmex(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Boolean)}
     * to enable screen-scraping.
     */
    public Position kosten(Double kosten) {
        this.needsScreenScraping = true;
        Datensatz.validate("kosten", Datensatz.Datentyp.M, 18, kosten);
        this.kosten = kosten;
        return this;
    }


    /**
     * Kosten<br/>
     * Nur für Export. Produktkosten
     */
    public Double kosten() {
        return this.kosten;
    }


    /**
     * Rohertrag<br/>
     * Nur für Export. Umsatz abzüglich der Kosten
     */
    public Double rohertrag() {
        return this.rohertrag;
    }


    /**
     * Marge<br/>
     * Nur für Export. Die Marge der Position in Prozent
     */
    public Double marge() {
        return this.marge;
    }

}
