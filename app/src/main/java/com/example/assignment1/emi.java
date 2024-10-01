package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class emi extends AppCompatActivity {
    // creating Edittexts for user to input values for period,interest, and principal
    public EditText period;
    public EditText interest;
    public EditText principal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the layout for the emi-application page
        setContentView(R.layout.emi);
        EdgeToEdge.enable(this);
        //refrencing by IDs for each of the inputs and result
        TextView result = findViewById(R.id.textView);
        period = (EditText)findViewById(R.id.period);
        principal = (EditText)findViewById(R.id.principal);
        interest = (EditText)findViewById(R.id.interest);
Button emi_button = findViewById(R.id.button);
// setting a listener to the emi button
emi_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try{
            // retriving input from user
            double principal_value = Double.parseDouble(principal.getText().toString());
            int period_value = Integer.parseInt(period.getText().toString()) *12;
            double interest_value = Double.parseDouble(interest.getText().toString())/100/12;
            double emi_value =formula(period_value,interest_value,principal_value);
            result.setText(String.format("$%.2f",emi_value));

            //if in put is invalid, display it
        } catch (NumberFormatException e) {
            result.setText("invalid input");

        }

    }
});
}
    // this is the formula used to obtain the result of the emi calculation
    public double formula(int period, double interest, double principal) {
        double result = (principal * interest * Math.pow(1 + interest, period)) /
                (Math.pow(1 + interest, period) - 1);

return result;


}}
