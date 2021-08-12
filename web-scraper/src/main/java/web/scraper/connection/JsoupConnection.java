package web.scraper.connection;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupConnection implements Connection<Document> {

  @Override
  public Document connect(String url) {
    try {
      Document document = Jsoup.connect(url).get();
      return document;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Document connect(String url, Integer count, String pixel) {
    return null;
  }

}
