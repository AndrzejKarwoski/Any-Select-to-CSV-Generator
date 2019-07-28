package pl.andrzejkarwoski.model;

import java.util.Map;

public class Parameters {
	private Map<String,Object> queryParameters;
	private String queryName;

	public Map<String, Object> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(Map<String, Object> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
}
