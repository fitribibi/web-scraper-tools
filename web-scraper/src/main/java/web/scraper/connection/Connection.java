package web.scraper.connection;

public interface Connection<A> {

  A connect(String url);

  A connect(String url, Integer count, String pixel);

}
