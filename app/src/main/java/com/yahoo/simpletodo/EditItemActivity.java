package com.yahoo.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EditItemActivity extends Activity {

    // ListView lvItems;
    String receivedString;
    int receivedPosition;
    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item_activity);

        // lvItems = (ListView) findViewById(R.id.lvItems);
        receivedString = getIntent().getStringExtra("editItem");
        receivedPosition = getIntent().getIntExtra("position", -1);
        etText = (EditText) findViewById(R.id.etEditItem);

        etText.setText(receivedString);
        etText.setSelection(etText.getText().length());
        Toast.makeText(this, receivedString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setResultText(View view) {
        Intent result = new Intent();
        result.putExtra("editText", etText.getText().toString());
        result.putExtra("position", receivedPosition);

        setResult(RESULT_OK, result);
        finish();
    }
}
