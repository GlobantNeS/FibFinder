package co.mobilemakers.fibfinder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    FibFinder finder = new FibFinder();
    Toolbar tbar;
    Button button;
    EditText valueField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbar = (Toolbar) findViewById(R.id.toolbar);
        button = (Button) findViewById(R.id.button);
        valueField = (EditText) findViewById(R.id.value);


        setSupportActionBar(tbar);
        finder.initialize();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = getString(R.string.no_value);
                String value = valueField.getText().toString();
                if (value != null && !value.isEmpty()) {
                    try {
                        int i = Integer.parseInt(value);
                        output = finder.checkValue(i);
                    } catch (NumberFormatException ex) {
                        output = getString(R.string.invalid_input);
                    }
                }

                Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();
            }
        });
    }
}
