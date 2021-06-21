package com.example.a1palindrom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Click(View view) {

        EditText Etekst = (EditText) findViewById(R.id.editText);
        String tekst = Etekst.getText().toString();

        //filtrowanie
        String nowytekst = tekst.toLowerCase().replaceAll("[^a-zA-Z]","");

        TextView tekstNowy = (TextView) findViewById(R.id.textView2);
        tekstNowy.setText("Tekst przefiltrowany:\n"+ nowytekst);

        Integer dlugosc = nowytekst.length();
        String wynik = "brak danych";

        Integer palin = 0;
        int poz = (dlugosc - 1);
        for (int i = 0; i < dlugosc/2; i++) {
            if (nowytekst.charAt(i) != nowytekst.charAt(poz)) {
                palin = 1;
                break;
            }
            poz--;
        }

        if (palin == 1)
            wynik = "To nie jest palindrom";
        else
            wynik = "To jest palindrom";

        //Wyswietla wynik
        TextView litery = (TextView) findViewById(R.id.textView);
        litery.setText("Ilosc liter = "+dlugosc.toString());
        Toast toast = Toast.makeText(getApplicationContext(), wynik, Toast.LENGTH_SHORT);
        toast.setMargin(50, 50);
        toast.show();
    }

}
