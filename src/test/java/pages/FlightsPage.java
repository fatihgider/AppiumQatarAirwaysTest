package pages;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import methods.Methods;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;

public class FlightsPage {
    Methods method;
    String ucusSaati = "";

    public FlightsPage(){
        method = new Methods();

    }


    @Step("Uçuş seçim ekranının geldiği kontrol edilir.")
    public void ucusPageKontrol(){
        method.isElementVisibles(By.id("com.m.qr:id/rvmp_fragment_search_result_list"));
    }
    @Step("Rastgele bir uçuş seçilir.")
    public void ucusSec(){
        MobileElement ucuslar = method.findElement(By.id("com.m.qr:id/rvmp_fragment_search_result_list"));
        List<MobileElement> e = ucuslar.findElements(By.id("com.m.qr:id/rvmp_item_search_result_root_view"));
        Random r=new Random();
        ucusSaati = method.findElement(By.id("com.m.qr:id/rvmp_departure_time")).getText();
        e.get(r.nextInt(4)).click();
    }

    @Step("Economy class seçeneğine tıklanır.")
    public void detaylaraGit(){
        method.click(By.id("com.m.qr:id/rvmp_activity_flight_details_select_button"));
    }

}
