package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Income extends AppCompatActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        //connect EditTexts
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_expense_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);

        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //convert to string or double
                String income = enterIncomeEditText.getText().toString();
                String incomeName = enterIncomeNamesEditText.getText().toString();            }
        });

    }
}
