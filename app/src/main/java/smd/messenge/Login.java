package smd.messenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CheckBox;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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


    public void createAccount(View view){
        Intent intent2	=	new	Intent(this,Messages.class);
        startActivity(intent2);

    }

    public void createAccountButton(View view) {
        EditText	toEditText	=	(EditText)	findViewById(R.id.usernameEntry);
        String	username =	toEditText.getText().toString();
        EditText	toEditText2	=	(EditText)	findViewById(R.id.passwordEntry);
        String	password =	toEditText2.getText().toString();


        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        String savedUsername	=	sharedPref.getString("usernameKey", "none");



        if (savedUsername.equalsIgnoreCase("none")) {
            Toast.makeText(getApplicationContext(), "New account created", Toast.LENGTH_LONG).show();
            sharedPref.edit().putString("usernameKey", username).apply();
            sharedPref.edit().putString("passwordKey", password).apply();
            Intent intent3	=	new	Intent(this,Messages.class);
            startActivity(intent3);
            boolean newUser = true;
        }
        else {
            Toast.makeText(getApplicationContext(), "An account has already been created", Toast.LENGTH_LONG).show();
        }

    }

    public void loginButton(View view){
        EditText	toEditText	=	(EditText)	findViewById(R.id.usernameEntry);
        String	username =	toEditText.getText().toString();

        EditText	toEditText2	=	(EditText)	findViewById(R.id.passwordEntry);
        String	password =	toEditText2.getText().toString();

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        String savedUsername	=	sharedPref.getString("usernameKey", "none");
        String savedPassword	=	sharedPref.getString("passwordKey", "none");

        if (savedUsername.equalsIgnoreCase(username)&&(savedPassword.equalsIgnoreCase(password))){
            Intent intent2	=	new	Intent(this,Messages.class);
            startActivity(intent2);
        }
        else {
            Toast.makeText(getApplicationContext(), "Incorrect username/password combination", Toast.LENGTH_LONG).show();
        }
    }
    public void checkBoxChecked(View view){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean checked = ((CheckBox) view).isChecked();

        if (checked)
            sharedPref.edit().putBoolean("stayLoggedIn", true).apply();
        else
            sharedPref.edit().putBoolean("stayLoggedIn", false).apply();
    }



    }

