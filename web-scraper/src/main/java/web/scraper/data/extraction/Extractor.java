package web.scraper.data.extraction;

import java.util.List;
import web.scraper.entity.Product;

public interface Extractor<A> {

  List<Product> extract(A input, int limit);

}
