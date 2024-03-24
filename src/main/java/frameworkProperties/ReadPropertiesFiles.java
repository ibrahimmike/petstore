package frameworkProperties;

import frameworkconstants.Constants;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertiesFiles {

   private static Properties properties = new Properties();

   private static Map<String, String > configParam = new HashMap<>();

   private static String configPath = Constants.getConfigurationsPath();


    static{
        try{
            FileInputStream reader = new FileInputStream(configPath);
            properties.load(reader);

            for(Map.Entry prop : properties.entrySet()){
                if(System.getProperties().stringPropertyNames().contains(prop.getKey())){
                    properties.setProperty(prop.getKey().toString(), System.getProperty(prop.getKey().toString()));
                }

            }
//            if (System.getProperties().stringPropertyNames().contains(key)){
//                System.out.println("I am activate the system found contains key :"+ key);
//
//            }

            properties.entrySet().forEach(
                    entry->configParam.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim()));



        }catch (Exception e){
            throw  new RuntimeException("The file is not found");
        }
    }
    public static String getPropertyValue(String key){
        String value = null;
        if( Objects.nonNull(configParam.get(key))){
          if (System.getProperties().stringPropertyNames().contains(key)){

                System.out.println("I am activate the system found contains key :"+ key);
                properties.setProperty(key, System.getProperty(key));
                configParam.entrySet();
            }
            value = configParam.get(key);

            System.out.println("property key "+ key + "property value "+value);
        }else{
            throw new RuntimeException("The value of the " + key + " does not exit in the configparams file");
        }
        return value;
    }





}
