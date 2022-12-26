package pages;

import com.thoughtworks.gauge.Step;
import driver.BaseTest;
import methods.Methods;
import org.openqa.selenium.By;

public class WelcomePage extends BaseTest {

    Methods method;

    public WelcomePage(){
        method = new Methods();
    }

    @Step("Uygulamanın açıldığı kontrol edilir.")
    public void uyulamaKontrol(){
        method.isElementVisibles(By.id("com.m.qr:id/skip_button"));
    }
    @Step("Karşılama ekranı 'Skip' seçeneği ile geçilir.")
    public void welcomeSkip(){
        method.click(By.id("com.m.qr:id/skip_button"));
        method.click(By.id("com.m.qr:id/onboarding_skip_button"));
        method.click(By.id("com.m.qr:id/push_consent_allow"));
    }

}
