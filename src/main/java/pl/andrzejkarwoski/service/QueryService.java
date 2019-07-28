package pl.andrzejkarwoski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.andrzejkarwoski.Utils.ResponseContent;
import pl.andrzejkarwoski.dao.CSVDAOImplementation;
import pl.andrzejkarwoski.model.Parameters;
import pl.andrzejkarwoski.query.Query;
import pl.andrzejkarwoski.query.QueryLoader;

import java.util.List;

@Service
public class QueryService {

	CSVDAOImplementation csvdaoImplementation;

	@Autowired
	QueryService(CSVDAOImplementation csvdaoImplementation) {
		this.csvdaoImplementation = csvdaoImplementation;
	}

	public Query getQuery(String queryName){
		try {
			List<Query> queries = QueryLoader.processFileWithJsons("src/main/resources/query.json");
			for(Query query : queries){
				if(query.getQueryName().equals(queryName)) return query;
			}
			throw new Exception("Query with the given name was not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResponseContent processQuery(Parameters parameters){
		Query query = getQuery(parameters.getQueryName());
		List<String> list =  csvdaoImplementation.executeQuery(query.getQueryText(),query.getColumnNames(),parameters.getQueryParameters());
		return new ResponseContent(list);
	}
}
