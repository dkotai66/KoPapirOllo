package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    private AlertDialog.Builder  jatekEredmeny;

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
                    gepEredmeny.setText("Computer: "+String.valueOf(gep));
                    Toast.makeText(MainActivity.this, "A nyertes a gép!", Toast.LENGTH_SHORT).show();
                }
                else{
                    rock_ketto.setImageResource(R.drawable.scissors);
                    ember++;
                    emberEredmeny.setText("Ember: "+String.valueOf(ember));
                    Toast.makeText(MainActivity.this, "A nyertes az ember!", Toast.LENGTH_SHORT).show();
                }
                eredmeny();

            }
        });

        papirGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rock.setImageResource(R.drawable.paper);
                if(gepValasztas()==0){
                    rock_ketto.setImageResource(R.drawable.rock);
                    ember++;
                    emberEredmeny.setText("Ember: "+String.valueOf(ember));
                    Toast.makeText(MainActivity.this, "A nyertes az ember!", Toast.LENGTH_SHORT).show();
                }
                else if(gepValasztas()==1){
                    rock_ketto.setImageResource(R.drawable.paper);

                }
                else{
                    rock_ketto.setImageResource(R.drawable.scissors);
                    gep++;
                    gepEredmeny.setText("Computer: "+String.valueOf(gep));
                    Toast.makeText(MainActivity.this, "A nyertes a gép!", Toast.LENGTH_SHORT).show();
                }
                eredmeny();
            }
        });

        olloGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rock.setImageResource(R.drawable.scissors);
                if(gepValasztas()==0){
                    rock_ketto.setImageResource(R.drawable.rock);
                    gep++;
                    gepEredmeny.setText("Computer: "+String.valueOf(gep));
                    Toast.makeText(MainActivity.this, "A nyertes a gép!", Toast.LENGTH_SHORT).show();
                }
                else if(gepValasztas()==1){
                    rock_ketto.setImageResource(R.drawable.paper);
                    ember++;
                    emberEredmeny.setText("Ember: "+String.valueOf(ember));
                    Toast.makeText(MainActivity.this, "A nyertes az ember!", Toast.LENGTH_SHORT).show();

                }
                else{
                    rock_ketto.setImageResource(R.drawable.scissors);

                }
                eredmeny();
            }
        });

    }

    private int gepValasztas(){
        int rand=new Random().nextInt(3);
        return rand;


    }

    private void eredmeny(){
        if(ember==3 || gep==3){
            String result="";
            if (ember>gep)
                result="Győzelem";
            else
                result="Vereség";
            jatekEredmeny=new AlertDialog.Builder(MainActivity.this);
            jatekEredmeny.setCancelable(false)
                    .setTitle(result)
                    .setMessage("Új játék?")
                    .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ujJatek();
                        }
                    })
                    .show();
        }
    }

    private void ujJatek(){
        ember = 0;
        gep = 0;
        gepEredmeny.setText("Computer: 0");
        emberEredmeny.setText("Ember: ");
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