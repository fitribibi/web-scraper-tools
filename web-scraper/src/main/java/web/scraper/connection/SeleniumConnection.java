package web.scraper.connection;

import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConnection implements Connection<Document> {

  @Override
  public Document connect(String url) {
    return null;
  }

  @Override
  public Document connect(String url, Integer count, String pixel) {
    // initiate web driver
    System.setProperty("webdriver.chrome.driver", "chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    JavascriptExecutor executor = (JavascriptExecutor) driver;

    for (int i = 0; i < count; i++) {
      // scroll down the web page by x pixel
      executor.executeScript("window.scrollBy(0, " + pixel + ");");

      // make a time for load new elements
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // process the result as Jsoup Document
    String html = driver.getPageSource();
    Document document = Jsoup.parse(html);

    driver.close();

    return document;
  }
}
