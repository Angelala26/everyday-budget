package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Income extends AppCompatActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;

    //TODO: show income on line after entered and leave space to enter more incomes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        //connect EditTexts
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_expense_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);

        //create new TextView for later
        final TextView incomeDisplay = new TextView(this);


        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //convert to string or double
                String income = enterIncomeEditText.getText().toString();
                String incomeName = enterIncomeNamesEditText.getText().toString();
                Double incomeDouble = Double.valueOf(income);

                //TODO: Transfer this info to line in scroll view showing incomes
                //create TextView after clicking
                incomeDisplay.setLayoutParams(new RelativeLayout.LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                incomeDisplay.setText(income + "   " + incomeName);
            }
        });

    }
}
