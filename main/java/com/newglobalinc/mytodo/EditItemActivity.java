package com.newglobalinc.mytodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemText = getIntent().getStringExtra("itemText");
        pos = getIntent().getIntExtra("position", 0);
        EditText etItem = (EditText) findViewById(R.id.etEditText);
        etItem.setText(itemText);
    }

    public void onSubmit(View v) {
        setResult(RESULT_CANCELED);
        this.finish();
    }

    public void onSaveItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etEditText);
        String itemText = etNewItem.getText().toString();
        Intent data = new Intent();
        data.putExtra("returnText", itemText);
        data.putExtra("position", pos);
        setResult(RESULT_OK, data);
        finish();
    }


}
