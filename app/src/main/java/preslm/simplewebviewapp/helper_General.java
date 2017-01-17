package preslm.simplewebviewapp;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class helper_General extends AppCompatActivity {

    public static String websiteURL = "";

    public static void storeURL(String URL_string) {
        if (URL_string.toLowerCase().contains("localhost")) {
            URL_string = "file:///storage/emulated/0/websiteTest/index.html";
        }
        else if (URL_string.toLowerCase().contains("my website")){
            URL_string = "http://www.pricee.stu.cofc.edu/";
        }
        else {
            //webView won't load without "http://www." and ".com"
            if (!URL_string.toLowerCase().contains(".com")) {
                URL_string = URL_string + ".com";
            }
            if (!URL_string.toLowerCase().contains("www.")) {
                URL_string = "www." + URL_string;
            }
            if (!URL_string.toLowerCase().contains("http://")) {
                URL_string = "http://" + URL_string;
            }
        }
        websiteURL = URL_string;
        Log.d("GENERAL: URL TO STORE: ", websiteURL);
    }
    public static String returnURL(){
        Log.d("GENERAL: URL TO LOAD: ", websiteURL);
        return websiteURL;
    }
}