package ticket_service.csv;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class ZoneDateTimeConverter extends AbstractBeanField {
  @Override
  protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    var formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
    return ZonedDateTime.parse(value, formatter);
  }
}