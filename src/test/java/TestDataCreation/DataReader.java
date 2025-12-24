package TestDataCreation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> readData() throws IOException  {
	
		//Covert the data from json to string
		
		String convertedJson = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\TestDataCreation\\testData.json")
				,StandardCharsets.UTF_8);
	
		
		//Conver the string to hashmap usign jackson databinder
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.convertValue
				(convertedJson,new TypeReference <List<HashMap<String, String>>>(){});
		return data;
		
		
		
		


		
	}

}
