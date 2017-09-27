package ro.deutsche.mediastore.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.deutsche.mediastore.domain.Client;
import ro.deutsche.mediastore.domain.Product;
import ro.deutsche.mediastore.service.ClientService;

@Controller
public class WelcomeController {
	
	@Autowired
	ClientService clientService;
		
	@RequestMapping(value="/")
	public String welcome(Map<String, Object> model) {
		String report = getTXTReport();
		model.put("report", report);
		return "welcome";
	}

	public String getTXTReport() {
		String txtReport = clientService.getClientTxtReport();
		return txtReport;
	}

}
