package com.AutomatedBackup.java;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {

    private static final String APP_URL = "https://example.com"; // replace with your app URL
    private static final String REPORT_FILE = "health_report.txt";

    public static void main(String[] args) {
        String status = checkApplication(APP_URL);
        writeReport(APP_URL, status);
    }

   
    private static String checkApplication(String appUrl) {
        try {
            URL url = new URL(appUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); 
            connection.setReadTimeout(5000);
            connection.connect();

            int code = connection.getResponseCode();

            if (code == 200) {
                System.out.println("[UP] Application is functioning correctly: " + appUrl);
                return "UP";
            } else {
                System.out.println("[DOWN] Application returned status code " + code);
                return "DOWN";
            }

        } catch (IOException e) {
            System.out.println("[DOWN] Unable to reach the application: " + e.getMessage());
            return "DOWN";
        }
    }

 
    private static void writeReport(String appUrl, String status) {
        try (FileWriter fw = new FileWriter(REPORT_FILE, true)) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            fw.write(time + " - " + appUrl + " - Status: " + status + "\n");
            System.out.println("[*] Report updated: " + status);
        } catch (IOException e) {
            System.err.println("[!] Error writing report: " + e.getMessage());
        }
    }
}
