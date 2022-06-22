package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity {

    private static final String TAG = "AddItemActivity";

    private EditText name;
    private EditText price;
    private Button addButton;
    private TextView currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_add_item);
        super.onCreate(savedInstanceState);
        setTitle(R.string.add_new_item_name);
        //setContentView(R.layout.activity_add_item);

        name  = findViewById(R.id.operation);
        price = findViewById(R.id.amount);
        addButton = findViewById(R.id.add_button);
        currency = findViewById(R.id.currency);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addButton.setEnabled((!TextUtils.isEmpty(name.getText().toString()) & !TextUtils.isEmpty(price.getText().toString())));
                Log.i(TAG, "afterTextChanged: " + s);
            }
        };

        TextWatcher amountWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "beforeTextChanged: price.length() = " + price.getText().toString().length());
                int textCurrencyColor = R.color.black;
                if (price.getText().toString().length() == 0){
                    textCurrencyColor = R.color.gray;
                }
                currency.setTextColor(textCurrencyColor);
            }
        };

        name.addTextChangedListener(textWatcher);
        price.addTextChangedListener(amountWatcher);
        price.addTextChangedListener(textWatcher);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String itemName = name.getText().toString();
                String itemPrice = price.getText().toString();
            }
        });
    }
}