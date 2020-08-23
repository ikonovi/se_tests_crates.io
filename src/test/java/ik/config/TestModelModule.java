package ik.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import ik.se.crates.pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestModelModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties props = new Properties();
        String filePath = System.getProperty("tests.properties","src/test/resources/tests.properties");
        try {
            props.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Names.bindProperties(binder(), props);

        binder().requestStaticInjection(TestModels.class);
    }
}
