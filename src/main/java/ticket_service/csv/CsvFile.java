package ticket_service.csv;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import ticket_service.model.Model;
import ticket_service.repository.Repository;

public class CsvFile<M extends Model> {

  public CsvFile(String path, Repository<M> repository, Class<M> bean) {
    this.path = path;
    this.repository = repository;
    this.bean = bean;
  }
  
  private final Class<M> bean;
  private final String path;
  private final Repository<M> repository;

  public String getPath() {
    return path;
  }

  public Repository<M> getRepository() {
    return repository;
  }

  public void write() {
    try {
      Writer writer = new FileWriter(path);

      StatefulBeanToCsv<M> csvWriter = new StatefulBeanToCsvBuilder<M>(writer)
        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
        .build();

      var models = repository.findAll();
      csvWriter.write(models);

      writer.close();
    } catch(Exception exception) {
      System.out.println("Error while trying to save models from CSV file");
      exception.printStackTrace();
    }
  }

  public void read() {
    try {
      var strategy = new ColumnPositionMappingStrategy<M>();
      strategy.setType(this.bean);
      var path = Paths.get(this.path);
      var reader = Files.newBufferedReader(path);
      var csvReader = new CsvToBeanBuilder<M>(reader)
        .withType(this.bean)
        .withMappingStrategy(strategy)
        .build();

      var list = csvReader.parse();
      repository.deleteAll();
      list.stream().forEach(model -> repository.insertOne(model));
      reader.close();
    } catch(Exception exception) {
      System.out.println("Error while trying to load models from CSV file");
      exception.printStackTrace();
    }
  }
}
