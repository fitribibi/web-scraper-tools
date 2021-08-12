package web.scraper.data.extraction;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import web.scraper.entity.Product;

public class TokopediaExtractor implements Extractor<Document> {

  @Override
  public List<Product> extract(Document input, int limit) {
    // get all product item elements that specified by CSS class name
    Elements elements = input.getElementsByClass("css-bk6tzz e1nlzfl3");
    List<Product> products = new ArrayList<>();
    for (Element element : elements) {
      // filter non-Ad product item
      if (element.getElementsByClass("css-1f8sh1y").isEmpty()) {
        String name = element.getElementsByClass("css-1bjwylw").text();
        String description = element.getElementsByClass("css-1bjwylw").text();

        Element imageClass = element.getElementsByClass("css-jo3xxj").first();
        Element image = imageClass.selectFirst("img");
        String imageLink = image.absUrl("src");

        String rawPrice = element.getElementsByClass("css-o5uqvq").text();
        String numericPrice = rawPrice.replaceAll("[^0-9,]", "");
        Float price = Float.parseFloat(numericPrice.replaceAll(",", "."));

        Element ratingClass = element.getElementsByClass("css-153qjw7").first();
        Elements ratingImages = ratingClass.getElementsByClass("css-177n1u3");
        Integer rating = ratingImages.size();

        Element merchantClass = element.getElementsByClass("css-vbihp9").first();
        Elements merchantSpan = merchantClass.select("span");
        String merchantName = merchantSpan.get(1).text();

        products.add(new Product(name, description, imageLink, price, rating, merchantName));

        if (limit > 0) {
          if (products.size() == limit) {
            break;
          }
        }
      }
    }
    return products;
  }
}
