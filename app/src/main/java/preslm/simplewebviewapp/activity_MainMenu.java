package preslm.simplewebviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_menu);

        Button goToWebsite = (Button) findViewById(R.id.goToWebsite);
        final EditText urlToStore = (EditText) findViewById(R.id.editTextURL);

        assert goToWebsite != null;
        goToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert urlToStore != null;
                helper_General.storeURL(urlToStore.getText().toString());
                Intent intent = new Intent(activity_MainMenu.this, activity_webViewPage.class);
                startActivity(intent);
                finish();
            }
        });
    }

}