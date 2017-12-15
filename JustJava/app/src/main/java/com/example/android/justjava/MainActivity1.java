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
    String[] messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int x = numberofcoffees * 5;
        String one = "Amount due " + "$" + x;
        String two = "That would be " + "$" + x + " please";
        String three = "you owe " + x + "bucks, dude!";
        String four = x + "dollars for " + numberofcoffees + " cups of coffee. Pay up.";
        String five = "Total = " + "$" + x;
        messages = new String[]{one, two, three, four, five};
        displayquantity(numberofcoffees);
        displayMessage(messages[cnt-1]);
        if (cnt % 5 == 0) {
            cnt = 1;
        }
        else {
            cnt += 1;
        }
        //int price = calculateprice(115,12);
        //displayprice(price);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void increment(View view) {
        numberofcoffees += 1;
        displayquantity(numberofcoffees);
    }

    public void decrement(View view) {
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
}