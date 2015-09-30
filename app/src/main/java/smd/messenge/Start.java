package smd.messenge;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class Start extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this,R.xml.preferences,	false);
        SharedPreferences	sharedPref	=	PreferenceManager.getDefaultSharedPreferences(this);
        Boolean stayLoggedIn	=	sharedPref.getBoolean("stayLoggedIn", false);



        if(stayLoggedIn) {
            Intent intent2 = new Intent(this, Messages.class);
            startActivity(intent2);
        }
        else {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
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


}
