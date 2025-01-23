package com.example.jsondemo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView tvJsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJsonData = findViewById(R.id.tvJsonData);

        // Contoh JSON dalam bentuk string
        String jsonString = "{ \"name\": \"Budi\", \"age\": 25, \"address\": { \"city\": \"Jakarta\", \"country\": \"Indonesia\" }, \"skills\": [\"Java\", \"Android\", \"Kotlin\"] }";

        try {
            // Parsing JSON string
            JSONObject jsonObject = new JSONObject(jsonString);

            // Mengambil data dari JSON
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            JSONObject address = jsonObject.getJSONObject("address");
            String city = address.getString("city");
            String country = address.getString("country");

            JSONArray skills = jsonObject.getJSONArray("skills");
            StringBuilder skillList = new StringBuilder();
            for (int i = 0; i < skills.length(); i++) {
                skillList.append(skills.getString(i)).append(", ");
            }

            // Menampilkan hasil parsing di TextView
            String result = "Name: " + name + "\nAge: " + age + "\nCity: " + city + 
                            "\nCountry: " + country + "\nSkills: " + skillList.toString();

            tvJsonData.setText(result);

        } catch (JSONException e) {
            e.printStackTrace();
            tvJsonData.setText("Error parsing JSON");
        }
    }
}
