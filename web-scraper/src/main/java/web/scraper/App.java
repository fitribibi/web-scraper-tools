package web.scraper;

import java.util.List;
import web.scraper.connection.SeleniumConnection;
import web.scraper.data.extraction.TokopediaExtractor;
import web.scraper.data.store.CsvWriter;
import web.scraper.entity.Product;

public class App {

  public static void main(String[] args) {
    // Run web scraping using Selenium and Jsoup
    // and then store the result as csv file
    SeleniumConnection sc = new SeleniumConnection();
    TokopediaExtractor te = new TokopediaExtractor();
    CsvWriter cw = new CsvWriter();

    // amount of product items to fetch
    int totalProductItem = 100;

    // limiting data extraction based on totalProductItem
    int limit = 0;

    // count extracted data
    int counter = 0;

    // Because of in one web page contain 60 product items so it needs 2 times iteration to get top 100 products
    for (int i = 0; i < 2; i++) {
      // Define url to scrape
      // Here is Tokopedia (e-commerce) url for retrieving mobile phone product that sorted by review
      String url = "https://www.tokopedia.com/p/handphone-tablet/handphone?ob=5&page=" + (i + 1);

      // connect to targeted url and extract data
      // for Tokopedia's site case, it needs to scroll down by 266 pixel for 15 times to load complete product items
      List<Product> products = te.extract(sc.connect(url, 15, "266"), limit);

      counter += products.size();
      limit = totalProductItem - counter > 60 ? 0 : totalProductItem - counter;

      if ( i > 0 ) {
        cw.append(products);
      } else {
        cw.store(products);
      }
    }
  }

}
