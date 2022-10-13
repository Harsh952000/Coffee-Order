package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private int numberOfOrder;
    private int priceOfCoffee = 10;
    private int whipCream;
    private int choco;

    public void incrementOrder(View view) {
        if (numberOfOrder < 30)
            numberOfOrder++;

        else {
            Toast.makeText(this, "You cannot have more than thirty Coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        displayNumber(numberOfOrder);
    }

    public void decrementOrder(View view) {
        if (numberOfOrder > 0)
            numberOfOrder--;

        displayNumber(numberOfOrder);
    }

    private void displayNumber(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText(" " + number);
    }


    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.addName);
        String orderName;
       String message;
        orderName = name.getText().toString();


        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.checkBox);
        if (whippedCreamCheck.isChecked()) {
            whipCream = 2;
        } else {
            whipCream = 0;
        }
        CheckBox chocolateCheck = (CheckBox) findViewById(R.id.checkBox2);
        if (chocolateCheck.isChecked())
            choco = 2;
        else
            choco = 0;
        if (!whippedCreamCheck.isChecked() && !chocolateCheck.isChecked() && numberOfOrder != 0) {
            displayPrice("$0");
            Toast.makeText(this, "You have to select atleast one toppings", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (numberOfOrder != 0) {

                message = " Name :" + orderName + "\n Pay :" + numberOfOrder * (priceOfCoffee + whipCream + choco) + "$ " + "\n number of  coffee :" + numberOfOrder;
                displayPrice(message);
            } else {
                displayPrice("$0");
                Toast.makeText(this, "You cannot have less than one Coffee", Toast.LENGTH_SHORT).show();
            }
        }


    }


    private void displayPrice(String message) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("messag_e",message);
        startActivity(intent);

    }
}