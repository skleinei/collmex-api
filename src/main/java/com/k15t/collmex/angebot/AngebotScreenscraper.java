package com.k15t.collmex.angebot;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.k15t.collmex.Collmex;
import com.k15t.collmex.Screenscraper;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;


public class AngebotScreenscraper implements Screenscraper {

    private final Angebot angebot;
    private final Collmex collmex;
    private final WebClient webClient;


    public AngebotScreenscraper(Angebot angebot, Collmex collmex) {
        this.angebot = angebot;
        this.collmex = collmex;
        this.webClient = new WebClient();
    }


    public void start() {
        try {
            login(collmex);

            for (Position position : angebot.getPositionen()) {
                if (position.needsScreenScraping) {
                    updatePosition(collmex, position);
                }
            }

            webClient.closeAllWindows();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updatePosition(Collmex collmex, Position position) throws IOException {
        Integer angebotsnummer = position.angebot.angebotsnummer();
        Integer positionsnummer = position.positionsnummer();
        String kostenAsString = NumberFormat.getInstance(Locale.GERMAN).format(position.kosten());

        final HtmlPage positionPage = webClient.getPage(collmex.getBaseUrl() + ",99999,qochitem," + angebotsnummer + "," + positionsnummer);
        HtmlForm form2 = positionPage.getFormByName("form1");
        form2.getInputByName("rohertrag_5_kondition").setValueAttribute(kostenAsString);
        form2.getInputByName("neue_preise").click();
    }


    private void login(Collmex collmex) throws IOException {
        final HtmlPage loginPage = webClient.getPage(collmex.getBaseUrl() + ",0,login");
        HtmlForm form1 = loginPage.getFormByName("form1");
        form1.getInputByName("group_benutzerId").setValueAttribute(collmex.getUser());
        form1.getInputByName("group_kennwort").setValueAttribute(collmex.getPassword());
        form1.getInputByName("logon").click();
    }

}
