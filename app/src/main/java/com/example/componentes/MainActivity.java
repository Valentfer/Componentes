package com.example.componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.componentes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String [] opciones = {"opcion 1", "opcion 2"};
//        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_spinner, R.layout.xml_spinner);
        adapter.setDropDownViewResource(R.layout.xml_spinner);
       binding.spinner.setAdapter(adapter);

        //binding.rG1.setOnCheckedChangeListener();
        binding.rB1.setOnClickListener(this);
        binding.rB2.setOnClickListener(this);
        binding.spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        if(binding.rB1.isChecked()){
            Toast.makeText(this, "opcion 1", Toast.LENGTH_SHORT).show();
        }else if(binding.rB2.isChecked()){
            Toast.makeText(this, "opcion 2", Toast.LENGTH_SHORT).show();
        }
    }

    public void check(View view){
        boolean marcado = ((CheckBox)view).isChecked();

     /*   if(binding.cB1.isChecked()){
            if(marcado){
                Toast.makeText(this, "check 1", Toast.LENGTH_SHORT).show();
            }
        }else if(binding.cB2.isChecked()){
            if(marcado){
                Toast.makeText(this, "check 2", Toast.LENGTH_SHORT).show();
            }
        }*/

        switch (view.getId()){
            case R.id.cB1:
                if(marcado) {
                    Toast.makeText(this, "check 1", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cB2:
                if(marcado) {
                    Toast.makeText(this, "check 2", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String Opcion = (String) adapterView.getItemPosition(i);
        if(Opcion.equals("Opcion 1")){
            Toast.makeText(this,"Pulsada opcion 1", Toast.LENGTH_SHORT).show();
        }else if(Opcion.equals("Opcion 2")){
            Toast.makeText(this,"Pulsada opcion 2", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}