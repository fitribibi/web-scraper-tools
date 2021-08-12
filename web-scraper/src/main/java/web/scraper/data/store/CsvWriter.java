package web.scraper.data.store;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import web.scraper.entity.Product;

public class CsvWriter implements Datastore {

  File file = null;

  @Override
  public void store(List<Product> products) {
    // create new file
    file = new File("top-100-mobile-phone.csv");

    // create csv schema based on Product DTO
    CsvSchema schema = CsvSchema.builder().setUseHeader(true)
        .addColumn("name")
        .addColumn("description")
        .addColumn("imageLink")
        .addColumn("price")
        .addColumn("rating")
        .addColumn("merchantName")
        .build();

    CsvMapper mapper = new CsvMapper();
    ObjectWriter writer = mapper.writerFor(Product.class).with(schema);
    try {
      writer.writeValues(file).writeAll(products);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void append(List<Product> products) {
    // create csv schema based on Product DTO
    CsvSchema schema = CsvSchema.builder().setUseHeader(false)
        .addColumn("name")
        .addColumn("description")
        .addColumn("imageLink")
        .addColumn("price")
        .addColumn("rating")
        .addColumn("merchantName")
        .build();

    CsvMapper mapper = new CsvMapper();
    ObjectWriter writer = mapper.writerFor(Product.class).with(schema);

    try {
      OutputStream outputStream = new FileOutputStream(file, true);
      writer.writeValues(outputStream).writeAll(products);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void close() throws IOException {

  }
}
