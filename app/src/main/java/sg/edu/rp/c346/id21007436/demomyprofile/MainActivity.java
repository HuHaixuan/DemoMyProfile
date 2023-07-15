package sg.edu.rp.c346.id21007436.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();

        SharedPreferences prefsName = getPreferences(MODE_PRIVATE);
        SharedPreferences prefsGPA = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEditName = prefsName.edit();
        SharedPreferences.Editor prefEditGPA = prefsGPA.edit();

        prefEditName.putString("name", strName);
        prefEditGPA.putString("GPA", strGPA);

        prefEditName.commit();
        prefEditGPA.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String msgName = prefs.getString("name", "");
        String msgGPA = prefs.getString("GPA", "");

        etName.setText(msgName);
        etGPA.setText(msgGPA);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);


    }
}