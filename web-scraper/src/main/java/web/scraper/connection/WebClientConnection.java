package web.scraper.connection;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;

public class WebClientConnection implements Connection<HtmlPage> {

  public HtmlPage connect(String url) {

    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    client.getOptions().setJavaScriptEnabled(false);

    HtmlPage page = null;

    try {
      page = client.getPage(url);
    } catch (IOException e) {
      e.printStackTrace();
    }

    client.getCurrentWindow().getJobManager().removeAllJobs();
    client.close();

    return page;
  }

  @Override
  public HtmlPage connect(String url, Integer count, String pixel) {
    return null;
  }

}
