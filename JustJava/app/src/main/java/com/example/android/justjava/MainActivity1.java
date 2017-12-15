/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity1 extends AppCompatActivity {


    int numberofcoffees=3;
    int cnt = 1;
    String first = "Abhishek";
    String last = "Raj";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String name = displayname(first, last);
        displayquantity(numberofcoffees);
        int price = calculateprice(numberofcoffees, 5);
        String pricemessage = "\nTotal: $" + price;
        String quantitymessage = "\nQuantity: " + numberofcoffees;
        String greetingmessage = "\nThank you!";
        displayMessage(name + quantitymessage + pricemessage + greetingmessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void increment(View view) {
        numberofcoffees += 1;
        displayquantity(numberofcoffees);
    }

    private void decrement(View view) {
        numberofcoffees -= 1;
        displayquantity(numberofcoffees);
    }
    private void displayquantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayprice(int number) {
        TextView priceTextView = (TextView)findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextview = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextview.setText(message);
    }
    private int calculateprice(int numberofcoffees, int pricepercup) {
        int price = numberofcoffees * pricepercup;
        return price;
    }

    private String displayname(String first, String last) {
        return "Name: " + first + " " + last;
    }
}