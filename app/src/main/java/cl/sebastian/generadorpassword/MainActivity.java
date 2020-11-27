package cl.sebastian.generadorpassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cl.sebastian.generadorpassword.databinding.ActivityMainBinding;
import cl.sebastian.generadorpassword.model.Generator;
import cl.sebastian.generadorpassword.viewModel.MyViewModel;
/*
[x]definimos MVVM
[x]1. implementar  build grade
[x]2. crear Layout
[x]3. crear clase GENERATOR
[x]4. crear clase VIEW MODEL
[]5. Enlazar VIEW MODEL com MAIN ACTIVITY

*/

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);




        // Create an ArrayAdapter using the string array and a default spinner layout
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        //R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
       // spinner.setAdapter(adapter);

        ArrayAdapter<Integer> adapter= new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item);
        for (int i=0;i<20;i++){
            adapter.add(i);
            i=i+4;
        }
        binding.spinner.setAdapter(adapter);
        binding.spinner.getSelectedItem();

        binding.btmpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               myViewModel.generatePassword((Integer) binding.spinner.getSelectedItem());
            }
        });
        myViewModel.getNewPassword().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvResultado.setText(s);
            }
        });

    }
}