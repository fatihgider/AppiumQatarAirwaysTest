package pages;

import com.thoughtworks.gauge.Step;
import driver.BaseTest;
import methods.Methods;
import org.openqa.selenium.By;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookPage extends BaseTest {
    Methods method;

    public BookPage(){
        method = new Methods();
    }

    @Step("Alt menüden 'Book' tabına geçiş yapılır.")
    public void bookTab(){
        method.click(By.id("com.m.qr:id/nav_menu_book"));
    }

    @Step("Seyehat tipi olarak 'One Way' seçilir.")
    public void oneWay(){
        method.click(By.xpath("//android.widget.LinearLayout[@content-desc='One-way']"));
    }

    @Step("Kalkış havaalanı olarak <x> seçilir.")
    public void fromBerlin(String x){
        method.click(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_holder_city_name_holder"));
        method.sendKeys(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext"),x);
        method.click(By.id("com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder"));
    }

    @Step("Varış havaalanı olarak <y> seçilir.")
    public void toIstanbul(String y){
        method.click(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view"));
        method.sendKeys(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext"),y);
        method.click(By.xpath("(//*[android.widget.TextView])[1]"));
    }

    @Step("(Bugünün tarihi + <z> gün) olarak bir gidiş tarihi seçilir.")
    public void departure(int z) throws InterruptedException {
        method.click(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder"));
        method.waitForSecods(2);
        method.SwipeUp();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
        LocalDateTime now = LocalDateTime.now().plusDays(z);
        String baslangicTarihi = dtf.format(now);
        String baslangicTarihPath = "//android.widget.TextView[@text="+baslangicTarihi+"]";
        method.click(By.xpath(baslangicTarihPath));
        method.click(By.id("com.m.qr:id/fragment_calendar_confirm_button"));
    }
    @Step("Arama butonuna tıklanır.")
    public void ucusAra(){
        method.click(By.id("com.m.qr:id/rvmp_booking_search_flights_button"));
    }
}