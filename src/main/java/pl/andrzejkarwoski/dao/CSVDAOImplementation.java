package pl.andrzejkarwoski.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CSVDAOImplementation implements CSVDAO {

	private NamedParameterJdbcTemplate template;

	@Autowired
	CSVDAOImplementation(NamedParameterJdbcTemplate template) {
		this.template = template;
	}



	@Override
	public List<String> executeQuery(String query, String columnsNames, Map<String,Object> queryParameters) {
		Map<String, Object> parameterMap = getParameterMap(queryParameters);
		List<String> result = template.query(query,parameterMap, (resultSet, i) -> {
			StringBuilder sb = new StringBuilder();
			for(int counter = 1;counter<=resultSet.getMetaData().getColumnCount();counter++){
				sb.append(resultSet.getString(counter));
				if(counter == resultSet.getMetaData().getColumnCount()) break;
				sb.append(";");
			}
			return sb.toString();
		});
		result.add(0,columnsNames);
		return result;
	}

	private Map<String, Object> getParameterMap(Map<String,Object> queryParameters) { // jeżeli pusty ustawiam na %
		Map<String,Object> result = new HashMap<>();
		for(String s : queryParameters.keySet()){
			if(s.contains("Data")){
				if(!queryParameters.get(s).equals("")){
					result.put(s,"'" + queryParameters.get(s)+ "'");
				}
				else{
					result.put(s,"%");
				}
			}
			else{
				if(!queryParameters.get(s).equals("")){
					result.put(s,queryParameters.get(s));
				}
				else{
					result.put(s,"%");
				}
			}

		}
		return result;
	}
}
