package com.sinnlaw.ching.muccoursework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.drive.internal.SetResourceParentsRequest;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button restBtn;
    FragmentManager fmaboutDialogue;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        //Setup Button
        restBtn = (Button) findViewById(R.id.restButton);
        restBtn.setOnClickListener(this);

        //Setup FragmentManager
        fmaboutDialogue = this.getFragmentManager();

    }

    @Override
    public void onClick(View view)
    {

        Intent restaurant_Screen = new Intent(getApplicationContext(), RestScreen.class);
        startActivity(restaurant_Screen);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mBio:
                Intent bioDraw = new Intent(this, bioActivity.class);
                this.startActivity(bioDraw);
                return true;
            case R.id.mQuit:
                finish();
                return true;
            case R.id.mAbout:
                DialogFragment aboutDlg = new aboutDialogue();
                aboutDlg.show(fmaboutDialogue, "mc_About_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
