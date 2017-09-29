package com.k15t.collmex.angebot;

import com.k15t.collmex.Datensatz;
import com.k15t.collmex.Satzart;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;


public class Angebot extends Datensatz {

    private Integer angebotsnummer;
    private Integer angebotsart;
    private Integer firmaNr;
    private Integer kundenNr;
    private String kundeAnrede;
    private String kundeTitel;
    private String kundeVorname;
    private String kundeName;
    private String kundeFirma;
    private String kundeAbteilung;
    private String kundeStrasse;
    private String kundePLZ;
    private String kundeOrt;
    private String kundeLand;
    private String kundeTelefon;
    private String kundeTelefon2;
    private String kundeTelefax;
    private String kundeEMail;
    private String kundeKontonr;
    private String kundeBlz;
    private String kundeAbweichenderKontoinhaber;
    private String kundeIBAN;
    private String kundeBIC;
    private String kundeBank;
    private String kundeUStIdNr;
    private Integer kundePrivatperson;
    private DateTime angebotsdatum;
    private DateTime preisdatum;
    private Integer zahlungsbedingung;
    private String waehrungISOCodes;
    private Integer preisgruppe;
    private Integer rabattgruppe;
    private Integer schlussRabatt;
    private String rabattgrund;
    private String angebotstext;
    private String schlusstext;
    private String internesMemo;
    private Integer geloescht;
    private DateTime abgelehntam;
    private Integer sprache;
    private Integer bearbeiter;
    private Integer vermittler;
    private Double schlussRabatt2;
    private String schlussRabatt2Grund;
    private Integer status;
    private String reserviert;
    private Integer versandart;
    private Double versandkosten;
    private Double nachnahmegebuehr;
    private DateTime lieferLeistungsdatum;
    private String lieferbedingung;
    private String lieferbedingungZusatz;
    private String lieferAdrAnrede;
    private String lieferAdrTitel;
    private String lieferAdrVorname;
    private String lieferAdrName;
    private String lieferAdrFirma;
    private String lieferAdrAbteilung;
    private String lieferAdrStrasse;
    private String lieferAdrPLZ;
    private String lieferAdrOrt;
    private String lieferAdrLand;
    private String lieferAdrTelefon;
    private String lieferAdrTelefon2;
    private String lieferAdrTelefax;
    private String lieferAdrEMail;

    private List<Position> positionen = new ArrayList<Position>();


    public static Angebot create(Integer angebotsnummer) {
        return new Angebot(angebotsnummer);
    }


    private Angebot(Integer angebotsnummer) {
        super(Satzart.ANGEBOT);
        this.angebotsnummer = angebotsnummer;
    }


    public Angebot addPosition(Position position) {
        // TODO: Check duplicate position
        // validate that position.position() is not duplicate. If it is
        // duplicate, we should throw a CollmexDataException here.

        positionen.add(position);
        position.angebot = this;
        return this;
    }


    public List<Position> getPositionen() {
        return positionen;
    }


    @Override
    public void id(Integer id) {
        validate("angebotsnummer", Datentyp.I, 8, angebotsnummer);
        this.angebotsnummer = id;
    }


    @Override
    public Integer id() {
        return this.angebotsnummer;
    }


//    public Angebot angebotsnummer(Integer angebotsnummer) {
//        validate("angebotsnummer", Datentyp.I, 8, angebotsnummer);
//        this.angebotsnummer = angebotsnummer;
//        return this;
//    }


    /**
     * Angebotsnummer<br/>
     * Die Angebotsnummer identifiziert das Angebot eindeutig. Siehe auch <a href="/cgi-bin/cgi.exe?1005,1,help,
     * daten_importieren_nummernvergabe">Nummernvergabe</a>.
     */
    public Integer angebotsnummer() {
        return this.angebotsnummer;
    }


    /**
     * Angebotsart<br/>
     * Reserviert
     */
    public Integer angebotsart() {
        return this.angebotsart;
    }


    @Override
    public Angebot firmaNr(Integer firmaNr) {
        validate("firmaNr", Datentyp.C, 50, firmaNr);
        this.firmaNr = firmaNr;
        return this;
    }


    /**
     * Firma Nr<br/>
     * Interne Nummer der Firma, wie unter Verwaltung → Firma anzeigen und ändern angezeigt.
     */
    public Integer firmaNr() {
        return firmaNr;
    }



    public Angebot kundenNr(Integer kundenNr) {
        validate("kundenNr", Datentyp.I, 8, kundenNr);
        this.kundenNr = kundenNr;
        return this;
    }


    /**
     * Kunden-Nr<br/>
     * Der Kunde muss in Collmex existieren.
     */
    public Integer kundenNr() {
        return this.kundenNr;
    }


    /**
     * Kunde-Anrede<br/>
     * Felder 7 - 27 ist die Kundenadresse. Nur für den Export. Die Felder werden beim Import ignoriert.
     */
    public String kundeAnrede() {
        return this.kundeAnrede;
    }


    /**
     * Kunde-Titel<br/>
     */
    public String kundeTitel() {
        return this.kundeTitel;
    }


    /**
     * Kunde-Vorname<br/>
     */
    public String kundeVorname() {
        return this.kundeVorname;
    }


    /**
     * Kunde-Name <br/>
     */
    public String kundeName() {
        return this.kundeName;
    }


    /**
     * Kunde-Firma <br/>
     */
    public String kundeFirma() {
        return this.kundeFirma;
    }


    /**
     * Kunde-Abteilung <br/>
     */
    public String kundeAbteilung() {
        return this.kundeAbteilung;
    }


    /**
     * Kunde-Strasse <br/>
     */
    public String kundeStrasse() {
        return this.kundeStrasse;
    }


    /**
     * Kunde-PLZ <br/>
     */
    public String kundePLZ() {
        return this.kundePLZ;
    }


    /**
     * Kunde-Ort <br/>
     */
    public String kundeOrt() {
        return this.kundeOrt;
    }


    /**
     * Kunde-Land<br/>
     * ISO Codes
     */
    public String kundeLand() {
        return this.kundeLand;
    }


    /**
     * Kunde-Telefon <br/>
     */
    public String kundeTelefon() {
        return this.kundeTelefon;
    }


    /**
     * Kunde-Telefon2 <br/>
     */
    public String kundeTelefon2() {
        return this.kundeTelefon2;
    }


    /**
     * Kunde-Telefax <br/>
     */
    public String kundeTelefax() {
        return this.kundeTelefax;
    }


    /**
     * Kunde-E-Mail <br/>
     */
    public String kundeEMail() {
        return this.kundeEMail;
    }


    /**
     * Kunde-Kontonr <br/>
     */
    public String kundeKontonr() {
        return this.kundeKontonr;
    }


    /**
     * Kunde-Blz <br/>
     */
    public String kundeBlz() {
        return this.kundeBlz;
    }


    /**
     * Kunde-Abweichender Kontoinhaber<br/>
     */
    public String kundeAbweichenderKontoinhaber() {
        return this.kundeAbweichenderKontoinhaber;
    }


    /**
     * Kunde-IBAN<br/>
     */
    public String kundeIBAN() {
        return this.kundeIBAN;
    }


    /**
     * Kunde-BIC<br/>
     */
    public String kundeBIC() {
        return this.kundeBIC;
    }


    /**
     * Kunde-Bank<br/>
     */
    public String kundeBank() {
        return this.kundeBank;
    }


    /**
     * Kunde-USt.IdNr<br/>
     */
    public String kundeUStIdNr() {
        return this.kundeUStIdNr;
    }


    /**
     * Kunde-Privatperson<br/>
     */
    public Integer kundePrivatperson() {
        return this.kundePrivatperson;
    }


    public Angebot angebotsdatum(DateTime angebotsdatum) {
        validate("angebotsdatum", Datentyp.D, 8, angebotsdatum);
        this.angebotsdatum = angebotsdatum;
        return this;
    }


    /**
     * Angebotsdatum<br/>
     * Falls nicht angegeben, wird das aktuelle Datum gesetzt.
     */
    public DateTime angebotsdatum() {
        return this.angebotsdatum;
    }


    public Angebot preisdatum(DateTime preisdatum) {
        validate("preisdatum", Datentyp.D, 8, preisdatum);
        this.preisdatum = preisdatum;
        return this;
    }


    /**
     * Preisdatum<br/>
     * Falls nicht angegeben, wird das Angebotsdatum gesetzt.
     */
    public DateTime preisdatum() {
        return this.preisdatum;
    }


    public Angebot zahlungsbedingung(Integer zahlungsbedingung) {
        validate("zahlungsbedingung", Datentyp.I, 8, zahlungsbedingung);
        this.zahlungsbedingung = zahlungsbedingung;
        return this;
    }


    /**
     * Zahlungsbedingung<br/>
     * Als Zahl codiert, beginnend mit 0 für 30T ohne Abzug, wie im Programm unter "Einstellungen". Falls nicht angegeben, wird die
     * Zahlungsbedingung vom Kunden übernommen.
     */
    public Integer zahlungsbedingung() {
        return this.zahlungsbedingung;
    }


    public Angebot waehrungISOCodes(String waehrungISOCodes) {
        validate("waehrungISOCodes", Datentyp.C, 3, waehrungISOCodes);
        this.waehrungISOCodes = waehrungISOCodes;
        return this;
    }


    /**
     * Währung (ISO-Codes)<br/>
     * Falls nicht angegeben, wird die Währung vom Kunden übernommen.
     */
    public String waehrungISOCodes() {
        return this.waehrungISOCodes;
    }


    public Angebot preisgruppe(Integer preisgruppe) {
        validate("preisgruppe", Datentyp.I, 8, preisgruppe);
        this.preisgruppe = preisgruppe;
        return this;
    }


    /**
     * Preisgruppe<br/>
     * Interne Nummer der Preisgruppe, wie sie bei der Pflege der Preisgruppe in der ersten Spalte angezeigt wird. Falls nicht angegeben,
     * wird die Preisgruppe vom Kunden übernommen.
     */
    public Integer preisgruppe() {
        return this.preisgruppe;
    }


    public Angebot rabattgruppe(Integer rabattgruppe) {
        validate("rabattgruppe", Datentyp.I, 8, rabattgruppe);
        this.rabattgruppe = rabattgruppe;
        return this;
    }


    /**
     * Rabattgruppe<br/>
     * Interne Nummer der Rabattgruppe, wie sie bei der Pflege der Rabattgruppe in der ersten Spalte angezeigt wird. Falls nicht
     * angegeben, wird die Rabattgruppe vom Kunden übernommen.
     */
    public Integer rabattgruppe() {
        return this.rabattgruppe;
    }


    public Angebot schlussRabatt(Integer schlussRabatt) {
        validate("schlussRabatt", Datentyp.I, 8, schlussRabatt);
        this.schlussRabatt = schlussRabatt;
        return this;
    }


    /**
     * Schluss-Rabatt<br/>
     * Schluss-Rabatt in Prozent.
     */
    public Integer schlussRabatt() {
        return this.schlussRabatt;
    }


    public Angebot rabattgrund(String rabattgrund) {
        validate("rabattgrund", Datentyp.C, 255, rabattgrund);
        this.rabattgrund = rabattgrund;
        return this;
    }


    /**
     * Rabattgrund<br/>
     * Grund für den Rabatt.
     */
    public String rabattgrund() {
        return this.rabattgrund;
    }


    public Angebot angebotstext(String angebotstext) {
        validate("angebotstext", Datentyp.C, 1024, angebotstext);
        this.angebotstext = angebotstext;
        return this;
    }


    /**
     * Angebotstext<br/>
     * Falls (NULL), wird der Text aus den Standard-Textbausteinen ermittelt.
     */
    public String angebotstext() {
        return this.angebotstext;
    }


    public Angebot schlusstext(String schlusstext) {
        validate("schlusstext", Datentyp.C, 1024, schlusstext);
        this.schlusstext = schlusstext;
        return this;
    }


    /**
     * Schlusstext<br/>
     * Falls (NULL), wird der Text aus den Standard-Textbausteinen ermittelt.
     */
    public String schlusstext() {
        return this.schlusstext;
    }


    public Angebot internesMemo(String internesMemo) {
        validate("internesMemo", Datentyp.C, 1024, internesMemo);
        this.internesMemo = internesMemo;
        return this;
    }


    /**
     * Internes Memo<br/>
     */
    public String internesMemo() {
        return this.internesMemo;
    }


    public Angebot geloescht(Integer geloescht) {
        validate("geloescht", Datentyp.I, 8, geloescht);
        this.geloescht = geloescht;
        return this;
    }


    /**
     * Gelöscht<br/>
     * 0 = nicht gelöscht, 1 = gelöscht.
     */
    public Integer geloescht() {
        return this.geloescht;
    }


    public Angebot abgelehntam(DateTime abgelehntam) {
        validate("abgelehntam", Datentyp.D, 8, abgelehntam);
        this.abgelehntam = abgelehntam;
        return this;
    }


    /**
     * Abgelehnt am<br/>
     * Optional.
     */
    public DateTime abgelehntam() {
        return this.abgelehntam;
    }


    public Angebot sprache(Integer sprache) {
        validate("sprache", Datentyp.I, 8, sprache);
        this.sprache = sprache;
        return this;
    }


    /**
     * Sprache<br/>
     * 0 = Deutsch, 1 = Englisch.
     */
    public Integer sprache() {
        return this.sprache;
    }


    public Angebot bearbeiter(Integer bearbeiter) {
        validate("bearbeiter", Datentyp.I, 8, bearbeiter);
        this.bearbeiter = bearbeiter;
        return this;
    }


    /**
     * Bearbeiter<br/>
     * Mitarbeiternummer des Bearbeiters. Falls nicht angegeben, wird der Bearbeiter automatisch bestimmt.
     */
    public Integer bearbeiter() {
        return this.bearbeiter;
    }


    public Angebot vermittler(Integer vermittler) {
        validate("vermittler", Datentyp.I, 8, vermittler);
        this.vermittler = vermittler;
        return this;
    }


    /**
     * Vermittler<br/>
     * Mitarbeiter Nummer des Vermittlers für die Provisionsabrechnung.
     */
    public Integer vermittler() {
        return this.vermittler;
    }


    public Angebot schlussRabatt2(Double schlussRabatt2) {
        validate("schlussRabatt2", Datentyp.M, 18, schlussRabatt2);
        this.schlussRabatt2 = schlussRabatt2;
        return this;
    }


    /**
     * Schluss-Rabatt-2<br/>
     * Schluss-Rabatt als Betrag
     */
    public Double schlussRabatt2() {
        return this.schlussRabatt2;
    }


    public Angebot schlussRabatt2Grund(String schlussRabatt2Grund) {
        validate("schlussRabatt2Grund", Datentyp.C, 20, schlussRabatt2Grund);
        this.schlussRabatt2Grund = schlussRabatt2Grund;
        return this;
    }


    /**
     * Schluss-Rabatt-2-Grund<br/>
     * Grund für den Rabatt
     */
    public String schlussRabatt2Grund() {
        return this.schlussRabatt2Grund;
    }


    /**
     * Status<br/>
     * Nur für Export. 0 = Neu, 10 = Offen, 20 = Erledigt, 30 = Abgelehnt, 40 = Gelöscht
     */
    public Integer status() {
        return this.status;
    }


    /**
     * Reserviert<br/>
     * Bitte leer lassen
     */
    public String reserviert() {
        return this.reserviert;
    }


    public Angebot versandart(Integer versandart) {
        validate("versandart", Datentyp.I, 8, versandart);
        this.versandart = versandart;
        return this;
    }


    /**
     * Versandart<br/>
     * Interne Nummer der Versandart, wie sie bei der Pflege der Versandart angezeigt wird. Falls nicht angegeben, wird die Versandart
     * automatisch bestimmt über die Versandgruppen der im Auftrag enthaltenen Produkte (nur Collmex pro).
     */
    public Integer versandart() {
        return this.versandart;
    }


    public Angebot versandkosten(Double versandkosten) {
        validate("versandkosten", Datentyp.M, 18, versandkosten);
        this.versandkosten = versandkosten;
        return this;
    }


    /**
     * Versandkosten<br/>
     * Falls nicht angegeben, werden die Versandkosten automatisch über die Versandart bestimmt.
     */
    public Double versandkosten() {
        return this.versandkosten;
    }


    public Angebot nachnahmegebuehr(Double nachnahmegebuehr) {
        validate("nachnahmegebuehr", Datentyp.M, 18, nachnahmegebuehr);
        this.nachnahmegebuehr = nachnahmegebuehr;
        return this;
    }


    /**
     * Nachnahmegebühr<br/>
     * Falls nicht angegeben, wird die Nachnahmegebühr automatisch über die Versandart bestimmt.
     */
    public Double nachnahmegebuehr() {
        return this.nachnahmegebuehr;
    }


    public Angebot lieferLeistungsdatum(DateTime lieferLeistungsdatum) {
        validate("lieferLeistungsdatum", Datentyp.D, 8, lieferLeistungsdatum);
        this.lieferLeistungsdatum = lieferLeistungsdatum;
        return this;
    }


    /**
     * Liefer/Leistungsdatum<br/>
     * Optional.
     */
    public DateTime lieferLeistungsdatum() {
        return this.lieferLeistungsdatum;
    }


    public Angebot lieferbedingung(String lieferbedingung) {
        validate("lieferbedingung", Datentyp.C, 3, lieferbedingung);
        this.lieferbedingung = lieferbedingung;
        return this;
    }


    /**
     * Lieferbedingung <br/>
     * International genormte INCOTERMS. Falls nicht angegeben, wird die Lieferbedingung aus der Versandart übernommen.
     */
    public String lieferbedingung() {
        return this.lieferbedingung;
    }


    public Angebot lieferbedingungZusatz(String lieferbedingungZusatz) {
        validate("lieferbedingungZusatz", Datentyp.C, 40, lieferbedingungZusatz);
        this.lieferbedingungZusatz = lieferbedingungZusatz;
        return this;
    }


    /**
     * Lieferbedingung Zusatz<br/>
     * Ort der Lieferbedingung
     */
    public String lieferbedingungZusatz() {
        return this.lieferbedingungZusatz;
    }


    public Angebot lieferAdrAnrede(String lieferAdrAnrede) {
        validate("lieferAdrAnrede", Datentyp.C, 10, lieferAdrAnrede);
        this.lieferAdrAnrede = lieferAdrAnrede;
        return this;
    }


    /**
     * LieferAdr-Anrede<br/>
     * Felder 55 - 68: Optional. Abweichende Lieferadresse.
     */
    public String lieferAdrAnrede() {
        return this.lieferAdrAnrede;
    }


    public Angebot lieferAdrTitel(String lieferAdrTitel) {
        validate("lieferAdrTitel", Datentyp.C, 10, lieferAdrTitel);
        this.lieferAdrTitel = lieferAdrTitel;
        return this;
    }


    /**
     * LieferAdr-Titel<br/>
     */
    public String lieferAdrTitel() {
        return this.lieferAdrTitel;
    }


    public Angebot lieferAdrVorname(String lieferAdrVorname) {
        validate("lieferAdrVorname", Datentyp.C, 40, lieferAdrVorname);
        this.lieferAdrVorname = lieferAdrVorname;
        return this;
    }


    /**
     * LieferAdr-Vorname<br/>
     */
    public String lieferAdrVorname() {
        return this.lieferAdrVorname;
    }


    public Angebot lieferAdrName(String lieferAdrName) {
        validate("lieferAdrName", Datentyp.C, 40, lieferAdrName);
        this.lieferAdrName = lieferAdrName;
        return this;
    }


    /**
     * LieferAdr-Name <br/>
     */
    public String lieferAdrName() {
        return this.lieferAdrName;
    }


    public Angebot lieferAdrFirma(String lieferAdrFirma) {
        validate("lieferAdrFirma", Datentyp.C, 80, lieferAdrFirma);
        this.lieferAdrFirma = lieferAdrFirma;
        return this;
    }


    /**
     * LieferAdr-Firma <br/>
     */
    public String lieferAdrFirma() {
        return this.lieferAdrFirma;
    }


    public Angebot lieferAdrAbteilung(String lieferAdrAbteilung) {
        validate("lieferAdrAbteilung", Datentyp.C, 80, lieferAdrAbteilung);
        this.lieferAdrAbteilung = lieferAdrAbteilung;
        return this;
    }


    /**
     * LieferAdr-Abteilung <br/>
     */
    public String lieferAdrAbteilung() {
        return this.lieferAdrAbteilung;
    }


    public Angebot lieferAdrStrasse(String lieferAdrStrasse) {
        validate("lieferAdrStrasse", Datentyp.C, 80, lieferAdrStrasse);
        this.lieferAdrStrasse = lieferAdrStrasse;
        return this;
    }


    /**
     * LieferAdr-Strasse <br/>
     */
    public String lieferAdrStrasse() {
        return this.lieferAdrStrasse;
    }


    public Angebot lieferAdrPLZ(String lieferAdrPLZ) {
        validate("lieferAdrPLZ", Datentyp.C, 10, lieferAdrPLZ);
        this.lieferAdrPLZ = lieferAdrPLZ;
        return this;
    }


    /**
     * LieferAdr-PLZ <br/>
     */
    public String lieferAdrPLZ() {
        return this.lieferAdrPLZ;
    }


    public Angebot lieferAdrOrt(String lieferAdrOrt) {
        validate("lieferAdrOrt", Datentyp.C, 20, lieferAdrOrt);
        this.lieferAdrOrt = lieferAdrOrt;
        return this;
    }


    /**
     * LieferAdr-Ort <br/>
     */
    public String lieferAdrOrt() {
        return this.lieferAdrOrt;
    }


    public Angebot lieferAdrLand(String lieferAdrLand) {
        validate("lieferAdrLand", Datentyp.C, 2, lieferAdrLand);
        this.lieferAdrLand = lieferAdrLand;
        return this;
    }


    /**
     * LieferAdr-Land<br/>
     * ISO Codes
     */
    public String lieferAdrLand() {
        return this.lieferAdrLand;
    }


    public Angebot lieferAdrTelefon(String lieferAdrTelefon) {
        validate("lieferAdrTelefon", Datentyp.C, 20, lieferAdrTelefon);
        this.lieferAdrTelefon = lieferAdrTelefon;
        return this;
    }


    /**
     * LieferAdr-Telefon <br/>
     */
    public String lieferAdrTelefon() {
        return this.lieferAdrTelefon;
    }


    public Angebot lieferAdrTelefon2(String lieferAdrTelefon2) {
        validate("lieferAdrTelefon2", Datentyp.C, 20, lieferAdrTelefon2);
        this.lieferAdrTelefon2 = lieferAdrTelefon2;
        return this;
    }


    /**
     * LieferAdr-Telefon2 <br/>
     */
    public String lieferAdrTelefon2() {
        return this.lieferAdrTelefon2;
    }


    public Angebot lieferAdrTelefax(String lieferAdrTelefax) {
        validate("lieferAdrTelefax", Datentyp.C, 20, lieferAdrTelefax);
        this.lieferAdrTelefax = lieferAdrTelefax;
        return this;
    }


    /**
     * LieferAdr-Telefax <br/>
     */
    public String lieferAdrTelefax() {
        return this.lieferAdrTelefax;
    }


    public Angebot lieferAdrEMail(String lieferAdrEMail) {
        validate("lieferAdrEMail", Datentyp.C, 50, lieferAdrEMail);
        this.lieferAdrEMail = lieferAdrEMail;
        return this;
    }


    /**
     * LieferAdr-E-Mail <br/>
     */
    public String lieferAdrEMail() {
        return this.lieferAdrEMail;
    }


    @Override
    public String toCsv() {
        String csv = "";

        for (Position position : positionen) {
            csv += toCsvField("Satzart", Datentyp.I, satzart());
            csv += toCsvField("Angebotsnummer", Datentyp.I, angebotsnummer());
            csv += toCsvField("Position", Datentyp.I, position.positionsnummer());
            csv += toCsvField("Angebotsart", Datentyp.I, angebotsart());
            csv += toCsvField("Firma Nr", Datentyp.I, firmaNr());
            csv += toCsvField("Kunden-Nr", Datentyp.I, kundenNr());
            csv += toCsvField("Kunde-Anrede", Datentyp.C, kundeAnrede());
            csv += toCsvField("Kunde-Titel", Datentyp.C, kundeTitel());
            csv += toCsvField("Kunde-Vorname", Datentyp.C, kundeVorname());
            csv += toCsvField("Kunde-Name ", Datentyp.C, kundeName());
            csv += toCsvField("Kunde-Firma ", Datentyp.C, kundeFirma());
            csv += toCsvField("Kunde-Abteilung ", Datentyp.C, kundeAbteilung());
            csv += toCsvField("Kunde-Strasse ", Datentyp.C, kundeStrasse());
            csv += toCsvField("Kunde-PLZ ", Datentyp.C, kundePLZ());
            csv += toCsvField("Kunde-Ort ", Datentyp.C, kundeOrt());
            csv += toCsvField("Kunde-Land", Datentyp.C, kundeLand());
            csv += toCsvField("Kunde-Telefon ", Datentyp.C, kundeTelefon());
            csv += toCsvField("Kunde-Telefon2 ", Datentyp.C, kundeTelefon2());
            csv += toCsvField("Kunde-Telefax ", Datentyp.C, kundeTelefax());
            csv += toCsvField("Kunde-E-Mail ", Datentyp.C, kundeEMail());
            csv += toCsvField("Kunde-Kontonr ", Datentyp.C, kundeKontonr());
            csv += toCsvField("Kunde-Blz ", Datentyp.C, kundeBlz());
            csv += toCsvField("Kunde-Abweichender Kontoinhaber", Datentyp.C, kundeAbweichenderKontoinhaber());
            csv += toCsvField("Kunde-IBAN", Datentyp.C, kundeIBAN());
            csv += toCsvField("Kunde-BIC", Datentyp.C, kundeBIC());
            csv += toCsvField("Kunde-Bank", Datentyp.C, kundeBank());
            csv += toCsvField("Kunde-USt.IdNr", Datentyp.C, kundeUStIdNr());
            csv += toCsvField("Kunde-Privatperson", Datentyp.I, kundePrivatperson());
            csv += toCsvField("Angebotsdatum", Datentyp.D, angebotsdatum());
            csv += toCsvField("Preisdatum", Datentyp.D, preisdatum());
            csv += toCsvField("Zahlungsbedingung", Datentyp.I, zahlungsbedingung());
            csv += toCsvField("Währung (ISO-Codes)", Datentyp.C, waehrungISOCodes());
            csv += toCsvField("Preisgruppe", Datentyp.I, preisgruppe());
            csv += toCsvField("Rabattgruppe", Datentyp.I, rabattgruppe());
            csv += toCsvField("Schluss-Rabatt", Datentyp.I, schlussRabatt());
            csv += toCsvField("Rabattgrund", Datentyp.C, rabattgrund());
            csv += toCsvField("Angebotstext", Datentyp.C, angebotstext());
            csv += toCsvField("Schlusstext", Datentyp.C, schlusstext());
            csv += toCsvField("Internes Memo", Datentyp.C, internesMemo());
            csv += toCsvField("Gelöscht", Datentyp.I, geloescht());
            csv += toCsvField("Abgelehnt am", Datentyp.D, abgelehntam());
            csv += toCsvField("Sprache", Datentyp.I, sprache());
            csv += toCsvField("Bearbeiter", Datentyp.I, bearbeiter());
            csv += toCsvField("Vermittler", Datentyp.I, vermittler());
            csv += toCsvField("Schluss-Rabatt-2", Datentyp.M, schlussRabatt2());
            csv += toCsvField("Schluss-Rabatt-2-Grund", Datentyp.C, schlussRabatt2Grund());
            csv += toCsvField("Status", Datentyp.I, status());
            csv += toCsvField("Reserviert", Datentyp.C, reserviert());
            csv += toCsvField("Versandart", Datentyp.I, versandart());
            csv += toCsvField("Versandkosten", Datentyp.M, versandkosten());
            csv += toCsvField("Nachnahmegebühr", Datentyp.M, nachnahmegebuehr());
            csv += toCsvField("Liefer/Leistungsdatum", Datentyp.D, lieferLeistungsdatum());
            csv += toCsvField("Lieferbedingung ", Datentyp.C, lieferbedingung());
            csv += toCsvField("Lieferbedingung Zusatz", Datentyp.C, lieferbedingungZusatz());
            csv += toCsvField("LieferAdr-Anrede", Datentyp.C, lieferAdrAnrede());
            csv += toCsvField("LieferAdr-Titel", Datentyp.C, lieferAdrTitel());
            csv += toCsvField("LieferAdr-Vorname", Datentyp.C, lieferAdrVorname());
            csv += toCsvField("LieferAdr-Name ", Datentyp.C, lieferAdrName());
            csv += toCsvField("LieferAdr-Firma ", Datentyp.C, lieferAdrFirma());
            csv += toCsvField("LieferAdr-Abteilung ", Datentyp.C, lieferAdrAbteilung());
            csv += toCsvField("LieferAdr-Strasse ", Datentyp.C, lieferAdrStrasse());
            csv += toCsvField("LieferAdr-PLZ ", Datentyp.C, lieferAdrPLZ());
            csv += toCsvField("LieferAdr-Ort ", Datentyp.C, lieferAdrOrt());
            csv += toCsvField("LieferAdr-Land", Datentyp.C, lieferAdrLand());
            csv += toCsvField("LieferAdr-Telefon ", Datentyp.C, lieferAdrTelefon());
            csv += toCsvField("LieferAdr-Telefon2 ", Datentyp.C, lieferAdrTelefon2());
            csv += toCsvField("LieferAdr-Telefax ", Datentyp.C, lieferAdrTelefax());
            csv += toCsvField("LieferAdr-E-Mail ", Datentyp.C, lieferAdrEMail());
            csv += toCsvField("Positionstyp", Datentyp.I, position.positionstyp());
            csv += toCsvField("Produktnummer", Datentyp.C, position.produktnummer());
            csv += toCsvField("Produktbeschreibung", Datentyp.C, position.produktbeschreibung());
            csv += toCsvField("Mengeneinheit", Datentyp.C, position.mengeneinheit());
            csv += toCsvField("Menge", Datentyp.N, position.menge());
            csv += toCsvField("Einzelpreis", Datentyp.M, position.einzelpreis());
            csv += toCsvField("Preismenge", Datentyp.N, position.preismenge());
            csv += toCsvField("Positionsrabatt", Datentyp.M, position.positionsrabatt());
            csv += toCsvField("Positionswert", Datentyp.M, position.positionswert());
            csv += toCsvField("Produktart", Datentyp.I, position.produktart());
            csv += toCsvField("Steuerklassifikation", Datentyp.I, position.steuerklassifikation());
            csv += toCsvField("Steuer auch im Ausland", Datentyp.I, position.steuerauchimAusland());
            csv += toCsvField("Erlösart", Datentyp.I, position.erloesart());
            csv += toCsvField("Summe über Pos.", Datentyp.I, position.summeueberPos());
            csv += toCsvField("Umsatz", Datentyp.M, position.umsatz());
            csv += toCsvField("Kosten", Datentyp.M, position.kosten());
            csv += toCsvField("Rohertrag", Datentyp.M, position.rohertrag());
            csv += toCsvField("Marge", Datentyp.M, position.marge());
            csv += toCsvField("Kosten Manuell", Datentyp.M, position.kostenManuell());
            csv += "\n";
        }

        return csv;
    }

}
