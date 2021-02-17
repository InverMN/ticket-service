package ticket_service.csv;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import ticket_service.model.ObjectId;

public class ObjectIdConverter extends AbstractBeanField {
  @Override
  protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    var objectId = new ObjectId(value);
    return objectId;
  }
}