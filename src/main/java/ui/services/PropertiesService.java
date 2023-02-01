package ui.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService{

    Properties p=new Properties();
    FileReader fileReader;
    public Properties getProperties(){
        {
            try {
                fileReader = new FileReader("src/main/resources/_testdata.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            p.load(fileReader);
        }catch (IOException e){
            e.printStackTrace();
        }
        return p;
    }
        }

