package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button koGomb, papirGomb, olloGomb;
    private TextView tevalasztasod, gepvalasztasa, emberEredmeny, eredmenyText, gepEredmeny;
    private Toast toast;
    private int ember, gep;
    private ImageView rock, rock_ketto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        koGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rock.setImageResource(R.drawable.rock);
                if(gepValasztas()==0){
                    rock_ketto.setImageResource(R.drawable.rock);
                }
                else if(gepValasztas()==1){
                    rock_ketto.setImageResource(R.drawable.paper);
                    gep++;
                    gepEredmeny.setText("Computer: "+String.valueOf(gepEredmeny));
                    Toast.makeText(MainActivity.this, "A nyertes a gép!", Toast.LENGTH_SHORT).show();
                }
                else{
                    rock_ketto.setImageResource(R.drawable.scissors);
                    ember++;
                    emberEredmeny.setText("Ember: "+String.valueOf(emberEredmeny));
                    Toast.makeText(MainActivity.this, "A nyertes az ember!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        papirGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rock.setImageResource(R.drawable.paper);
                if(gepValasztas()==0){
                    rock_ketto.setImageResource(R.drawable.rock);
                }
                else if(gepValasztas()==1){
                    rock_ketto.setImageResource(R.drawable.paper);
                    gep++;
                    gepEredmeny.setText("Computer: "+String.valueOf(gepEredmeny));
                    Toast.makeText(MainActivity.this, "A nyertes a gép!", Toast.LENGTH_SHORT).show();
                }
                else{
                    rock_ketto.setImageResource(R.drawable.scissors);
                    ember++;
                    emberEredmeny.setText("Ember: "+String.valueOf(emberEredmeny));
                    Toast.makeText(MainActivity.this, "A nyertes az ember!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        olloGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rock.setImageResource(R.drawable.scissors);
                if(gepValasztas()==0){
                    rock_ketto.setImageResource(R.drawable.rock);
                }
                else if(gepValasztas()==1){
                    rock_ketto.setImageResource(R.drawable.paper);
                    gep++;
                    gepEredmeny.setText("Computer: "+String.valueOf(gepEredmeny));
                    Toast.makeText(MainActivity.this, "A nyertes a gép!", Toast.LENGTH_SHORT).show();
                }
                else{
                    rock_ketto.setImageResource(R.drawable.scissors);
                    ember++;
                    emberEredmeny.setText("Ember: "+String.valueOf(emberEredmeny));
                    Toast.makeText(MainActivity.this, "A nyertes az ember!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private int gepValasztas(){
        int rand=new Random().nextInt(3);
        return rand;


    }

    private void init(){
        ember = 0;
        gep = 0;
        rock = findViewById(R.id.rock);
        rock_ketto = findViewById(R.id.rock_ketto);
        koGomb = findViewById(R.id.koGomb);
        papirGomb = findViewById(R.id.papirGomb);
        olloGomb = findViewById(R.id.olloGomb);
        emberEredmeny = findViewById(R.id.emberEredmeny);
        gepEredmeny = findViewById(R.id.gepEredmeny);
    }
}