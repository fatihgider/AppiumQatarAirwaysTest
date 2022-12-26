package pages;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class TripSummaryPage {
    Methods method;

    public TripSummaryPage(){
        method = new Methods();
    }

    @Step("Uçuş seçim ekranındaki uçuş saati ile uçuş detayları ekranındaki uçuş saati değeri aynı mı kontrol edilir.")
    public void compareTimes(){
        FlightsPage flightsPage = new FlightsPage();
        String flightsPageSaat = flightsPage.ucusSaati;

        String summaryPageSaat = method.findElement(By.id("com.m.qr:id/from_time")).getText();

        Assert.assertFalse("Saatler Eşit Değil!",summaryPageSaat==flightsPageSaat);
    }

}
