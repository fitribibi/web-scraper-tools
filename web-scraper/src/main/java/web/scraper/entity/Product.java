package web.scraper.entity;

public class Product {

  public String name;
  public String description;
  public String imageLink;
  public Float price;
  public Integer rating;
  public String merchantName;

  public Product() {
  }

  public Product(String name, String description, String imageLink, Float price,
      Integer rating, String merchantName) {
    this.name = name;
    this.description = description;
    this.imageLink = imageLink;
    this.price = price;
    this.rating = rating;
    this.merchantName = merchantName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }
}
