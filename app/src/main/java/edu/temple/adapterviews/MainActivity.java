package edu.temple.adapterviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    Spinner spinner;

    EditText itemEditText;
    Button addItemButton;

    TextView textView;

    int[] desertImagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        itemEditText = findViewById(R.id.itemEditText);
        addItemButton = findViewById(R.id.addButton);

        textView = findViewById(R.id.displayTextView);

        ArrayList desertsArray = new ArrayList<String>();
        desertsArray.add("Atacama");
        desertsArray.add("Gobi");
        desertsArray.add("Mohave");
        desertsArray.add("Patagonian");
        desertsArray.add("Sahara");


        ArrayList locationArray = new ArrayList<String>();
        locationArray.add("Peru");
        locationArray.add("Mongolia");
        locationArray.add("America");
        locationArray.add("Argentina");
        locationArray.add("Sudan");

        desertImagesArray = new int[]{R.drawable.atacama, R.drawable.gobi, R.drawable.mohave, R.drawable.patagonian, R.drawable.sahara};

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, desertsArray);

        DesertAdapter adapter = new DesertAdapter(this, desertsArray, locationArray);


        listView.setAdapter(adapter);
        spinner.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showPicture(position);
                textView.setText(((Pair)parent.getItemAtPosition(position)).first.toString());
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();
                showPicture(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Item Unselected", Toast.LENGTH_SHORT).show();
            }
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEditText.getText().toString();
                desertsArray.add(0, item);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void showPicture (int position) {
        imageView.setImageResource(desertImagesArray[position]);
    }
}