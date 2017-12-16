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
import android.widget.CheckBox;
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
    int price;
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
        boolean hascream = haswhippedcream();
        boolean chocolate = havechocolate();
        if (hascream && chocolate) {
            price = calculateprice(numberofcoffees, 5 + 2);
        }
        else if (hascream || chocolate) {
            price = calculateprice(numberofcoffees, 5 + 1);
        }
        else {
            price = calculateprice(numberofcoffees, 5);
        }
        String pricemessage = "\nTotal: $" + price;
        String quantitymessage = "\nQuantity: " + numberofcoffees;
        String greetingmessage = "\nThank you!";
        String whippedcream = "\nAdded Whipped cream ? ";
        String chocomessage = "\nAdd Chocolate? ";
        displayMessage(name,  quantitymessage , pricemessage , greetingmessage, whippedcream, hascream, chocomessage, chocolate);

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
    private void displayMessage(String name, String quantity, String price, String greet, String cream, boolean hascream, String addchoco, boolean choco) {
        String message = name + cream + hascream + addchoco + choco + quantity + price + greet;
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

    private boolean haswhippedcream() {
        CheckBox hasTakenwhipped = (CheckBox)findViewById(R.id.checkbox_whipped_cream);
        return hasTakenwhipped.isChecked();
    }

    private boolean havechocolate() {
        CheckBox havechoc = (CheckBox)findViewById(R.id.checkbox_chocolate);
        return havechoc.isChecked();
    }
}