package pl.andrzejkarwoski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.andrzejkarwoski.Utils.ResponseContent;
import pl.andrzejkarwoski.model.Parameters;
import pl.andrzejkarwoski.service.QueryService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class GeneratorController {

	QueryService queryService;

	@Autowired
	GeneratorController(QueryService queryService) {
		this.queryService = queryService;
	}

	@ResponseBody
	@RequestMapping(name = "/get", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> get(HttpServletResponse response, @RequestBody Parameters parameters) throws IOException {
		return this.createResponseForm(queryService.processQuery(parameters));
	}

	private ResponseEntity<InputStreamResource> createResponseForm(ResponseContent responseContent){
		return ResponseEntity
				.ok()
				.header("Content-Type", "text/plain; charset=utf-8")
				.header("Content-Disposition", "attachment; filename=generate.csv")
				.header("Access-Control-Expose-Headers", "Content-Disposition")
				.body(new InputStreamResource(new ByteArrayInputStream(responseContent.getContent())));
	}
}

