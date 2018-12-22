package org.fbertos.persistence.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaticController {
	 @GetMapping(value="/static/index")
	 public @ResponseBody String get() throws IOException {
		 File file = ResourceUtils.getFile("classpath:templates/index.html");
		 InputStream in = new FileInputStream(file);
		 BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 StringBuilder sb = new StringBuilder();
		 String line;
		 
		 while ((line = br.readLine()) != null) {
			 sb.append(line);
			 sb.append("\n");
		 }
		 
		 in.close();
		 
		 return sb.toString();
	 }
}
