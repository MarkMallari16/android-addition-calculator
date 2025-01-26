package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText firstNumber = findViewById(R.id.firstNumber);
        EditText secondNumber = findViewById(R.id.secondNumber);

        Button addBtn = findViewById(R.id.addBtn);
        TextView resutlText = findViewById(R.id.txtResult);

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String firstInput = firstNumber.getText().toString();
                String secondInput = secondNumber.getText().toString();

                if (firstInput.isEmpty() || secondInput.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter both numbers",Toast.LENGTH_LONG).show();
                }else{
                    int num1 = Integer.parseInt(firstInput);
                    int num2 = Integer.parseInt(secondInput);
                    int sum = num1 + num2;

                    resutlText.setText("Result: " + sum);
                    Toast.makeText(MainActivity.this,"Result " + sum,Toast.LENGTH_LONG).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}