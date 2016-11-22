package preslm.simplewebviewapp;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**Helper Class. General Helpers or Helper's Helpers go here.**/
public class helper_General extends AppCompatActivity {

    private static final String TAG = "GENERAL-DEBUG";
    public static String websiteURL = "";

    public static void storeURL(String URL_string) {
        //add these. webview won't load without "http://www."
        if (!URL_string.toLowerCase().contains("http://")){
            if (!URL_string.toLowerCase().contains("www.")) {
                URL_string = "www." + URL_string;
            }
            URL_string = "http://" + URL_string;
        }

        websiteURL = URL_string;
        Log.d("GENERAL: URL TO STORE: ", websiteURL);
    }
    public static String returnURL(){
        Log.d("GENERAL: URL TO LOAD: ", websiteURL);
        return websiteURL;
    }
}
