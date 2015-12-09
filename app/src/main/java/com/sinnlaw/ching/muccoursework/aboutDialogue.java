package com.sinnlaw.ching.muccoursework;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by ching on 2015/12/01.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class aboutDialogue extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder mcAboutDialog = new AlertDialog.Builder(getActivity());
        mcAboutDialog.setMessage("This app will tell user the address of the resturant that user have choose by using the Google map")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        mcAboutDialog.setTitle("About");
        mcAboutDialog.setIcon(R.drawable.ic_menu_action_about);
        // Create the AlertDialog object and return it
        return mcAboutDialog.create();
    }

}
