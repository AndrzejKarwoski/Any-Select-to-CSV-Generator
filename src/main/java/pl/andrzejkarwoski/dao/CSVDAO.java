package pl.andrzejkarwoski.dao;


import java.util.List;
import java.util.Map;

public interface CSVDAO {

	List<String> executeQuery(String query, String columnsNames, Map<String, Object> queryParameters);
}
