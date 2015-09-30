package smd.messenge;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Messages extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_messages, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i;
        switch	(id)	{
            case R.id.contacts_button:

                i	=	new	Intent(this,ContactList.class);
                startActivity(i);
                break;
            case	R.id.google_maps_button:

                i	=	new	Intent(this,GoogleMaps.class);
                startActivity(i);
                break;
            case    R.id.action_settings:
                i	=	new	Intent(this,SettingsActivity.class);
                startActivity(i);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void goToCompose(View view){
        Intent i	=	new	Intent(this,ComposeMessage.class);
        startActivityForResult(i, 1);
    }

}
