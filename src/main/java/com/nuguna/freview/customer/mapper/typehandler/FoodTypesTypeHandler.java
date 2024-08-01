package com.nuguna.freview.customer.mapper.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

// FoodTypes -> List<String>으로 변환하는 TypeHandler
public class FoodTypesTypeHandler extends BaseTypeHandler<List<String>> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter,
      JdbcType jdbcType) throws SQLException {
    throw new UnsupportedOperationException("Setting parameters is not supported");
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
    String foodTypesStr = rs.getString(columnName);
    return parseFoodTypes(foodTypesStr);
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String foodTypesStr = rs.getString(columnIndex);
    return parseFoodTypes(foodTypesStr);
  }

  @Override
  public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String foodTypesStr = cs.getString(columnIndex);
    return parseFoodTypes(foodTypesStr);
  }

  private List<String> parseFoodTypes(String foodTypesStr) {
    if (foodTypesStr == null || foodTypesStr.isEmpty()) {
      return Collections.emptyList(); // Return an empty list if no food types
    }
    return Arrays.stream(foodTypesStr.split(","))
        .map(String::trim)
        .collect(Collectors.toList());
  }
}