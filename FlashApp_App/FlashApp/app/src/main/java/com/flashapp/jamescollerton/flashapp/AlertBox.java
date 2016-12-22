package com.flashapp.jamescollerton.flashapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by JamesCollerton on 22/12/2016.
 */
public class AlertBox {

    public AlertBox(Activity parentActivity, String title, String message, String confirmText){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(parentActivity);

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(confirmText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // FIRE ZE MISSILES!
            }
        });
        alertDialog.show();

    }

}
