//Jerry Henry
//10/23/2019

package com.example.newsailingadventures;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView reservation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reservation = findViewById(R.id.txtReservation);

       Button button =findViewById(R.id.btnDate);
       button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           new DatePickerDialog(MainActivity.this, dateSetListener,
                   calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                   calendar.get(Calendar.DAY_OF_MONTH)).show();
       }
    });
    }
    Calendar calendar = Calendar.getInstance();
       final DateFormat txtDate =DateFormat.getDateInstance();
       DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               calendar.set(Calendar.YEAR, year);
               calendar.set(Calendar.MONTH, month);
               calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
               reservation.setText("Your reservation is set for "
                       + txtDate.format(calendar.getTime()));
           }
       };
    }