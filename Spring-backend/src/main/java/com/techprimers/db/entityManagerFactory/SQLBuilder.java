package com.techprimers.db.entityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author duongnt
 */
public class SQLBuilder {


  public static final String SQL_MR_MAINTENANCE_MNGT = "maintenanceMNGT";


  @Autowired
  static ResourceLoader resourceLoader;

  public static String getSqlQueryById(String module, String queryId) {
    InputStream inputStream = null;
    try {
      String filePath = "sql" + File.separator + module + File.separator + queryId + ".sql";
//      log.info("SQL file path:" + filePath);
      Resource resource = new ClassPathResource(filePath);
      inputStream = resource.getInputStream();
      if (inputStream != null) {
        return new String(inputStream.readAllBytes());
      }
    } catch (IOException e) {
//      log.error(e.getMessage(), e);
      return null;
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
//          log.error(e.getMessage(), e);
        }
      }
    }
    return null;
  }

  public static String getSQLPagination(String sql){
    sql = "\n SELECT * FROM ( SELECT a.*, rownum indexRow FROM ( "
        + "\n SELECT * FROM ( "
        + sql
        + "\n )) a"
        + "\n WHERE rownum < :indexEnd + 1) WHERE indexRow > :indextStart ";
    return sql;
  }

}
