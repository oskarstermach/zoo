package pl.ostermach.zoo;

import com.datastax.driver.core.Session;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationService applicationService = new ApplicationService();
        AppManager appManager = new AppManager(applicationService);
        appManager.controlApplicationFlow();
    }
}
