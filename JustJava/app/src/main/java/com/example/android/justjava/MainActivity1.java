/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity1 extends AppCompatActivity {


    int numberofcoffees=3;
    int cnt = 2;
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
        //String name = displayname(first, last);
        String name = extracttext();
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
        String message = name + quantitymessage + whippedcream + hascream + chocomessage + chocolate + quantitymessage + pricemessage + greetingmessage;
        displayMessage(name,  quantitymessage , pricemessage , greetingmessage, whippedcream, hascream, chocomessage, chocolate);
        //String email[] = {""};
        //composeEmail(email, "order summary", message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void increment(View view) {
        numberofcoffees += 1;

        if (numberofcoffees > 100) {
            numberofcoffees = 100;
        }
        displayquantity(numberofcoffees);
    }

    public void decrement(View view) {
        numberofcoffees -= 1;
        if (numberofcoffees < 1) {
            numberofcoffees = 1;
        }
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

    private String extracttext() {
        EditText text = (EditText)findViewById(R.id.name);
        return text.getText().toString();
    }

    public void composeEmail(String[] addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}