package web.scraper.data.store;

import java.io.Closeable;
import java.util.List;
import web.scraper.entity.Product;

public interface Datastore extends Closeable {

  void store(List<Product> products);

  void append(List<Product> products);

}
