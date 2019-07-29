package lab.project.outliers.util;

import java.util.HashMap;
import java.util.Map;

public class MyUtil {
	
	public static HashMap<String, Object> mapToHashMap(Map<String, Object> source) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("left", source.get("left"));
		result.put("top", source.get("top"));
		result.put("right", source.get("right"));
		result.put("bottom", source.get("bottom"));
		
		return result;
	}
	
}
