package AskomdchTesting;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddProductToCart {

    @Test
    public void TestProductPurchase(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://askomdch.com/");
        page.locator("//a[@class='wp-block-button__link']").click();
        page.locator("//a[@aria-label='Add “Anchor Bracelet” to your cart']").click();
        page.locator("//a[@title='View cart']").click();
        page.waitForTimeout(3000);
        String text = page.locator("//a[normalize-space()='Anchor Bracelet']").textContent();
        System.out.print(text);
        assertEquals(text, "Anchor Bracelet");

    }
}
