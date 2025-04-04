package propertyutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtility {
	
	static String path = System.getProperty("user.dir");;

	private static final String PROPERTY_FILE_PATH = path +"\\src\\main\\resources\\Testdata.properties"; // Or your properties file path
	private static final Map<String, String> propertyCache = new HashMap<>();

	public static String getreadproperty(String key) {
		if (propertyCache.containsKey(key)) {
			return propertyCache.get(key);
		}

		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream(PROPERTY_FILE_PATH)) {
			properties.load(fis);
			String value = properties.getProperty(key);
			if (value != null) {
				propertyCache.put(key, value); // Cache the property
				return value;
			} else {
				return null; // Key not found
			}
		} catch (IOException e) {
			e.printStackTrace(); // Handle exception appropriately
			return null;
		}
	}

	// Optional: Method to clear the cache if needed
	public static void clearCache() {
		propertyCache.clear();
	}
}
