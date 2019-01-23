package com.karltech.android.everydaybudget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Income extends MainActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;

    //TODO: show income on line after entered and leave space to enter more incomes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this takes everything from MainActivity, so create a implement thing that is empty apart
        //from the navigation thing and make every
        //activity implement it instead
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_income, null, false);
        mDrawerLayout.addView(contentView, 0);

        //connect EditTexts
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_expense_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);

        //create new TextView for later
        final TextView incomeDisplay = new TextView(this);

/*
//getting null pointer exception with this because there is no string or double still?
        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //convert to string or double
                String income = enterIncomeEditText.getText().toString();
                String incomeName = enterIncomeNamesEditText.getText().toString();
                Double incomeDouble = Double.valueOf(income);

                //TODO: Transfer this info to line in scroll view showing incomes
                //create TextView after clicking
                incomeDisplay.setLayoutParams(new RelativeLayout.LayoutParams
                        (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                incomeDisplay.setText(incomeDouble + "   " + incomeName);
            }
        });
*/
    }
}
