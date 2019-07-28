package pl.andrzejkarwoski.query;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public abstract class QueryLoader {

	public static List<Query> processFileWithJsons(String filename) throws FileNotFoundException {
		final Type REVIEW_TYPE = new TypeToken<List<Query>>() {}.getType();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filename));
		List<Query> data = gson.fromJson(reader, REVIEW_TYPE);
		return data;
	}

}
