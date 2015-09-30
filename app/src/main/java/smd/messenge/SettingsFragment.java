package smd.messenge;


import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public	void onCreate(Bundle savedInstanceState)	{
        super.onCreate(savedInstanceState);
//	Load	the	preferences	from	an	XML	resource
        addPreferencesFromResource(R.xml.preferences);
    }

}
