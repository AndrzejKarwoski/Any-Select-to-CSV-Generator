package pl.andrzejkarwoski.query;

import java.util.List;

public class Query {
	private String queryName;
	private String queryText;
	private String columnNames;
	private List<String> queryParameters;

	public List<String> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(List<String> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String columnNames) {
		this.columnNames = columnNames;
	}
}
