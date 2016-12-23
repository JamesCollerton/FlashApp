package com.flashapp.jamescollerton.flashapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * This class is used as a wrapper for creating alerts to the user.
 *
 * Created by JamesCollerton on 22/12/2016.
 */
public class AlertBox {

    /**
     * The constructor creates an alert dialog box and shows it.
     *
     * @param parentActivity The screen that called the alert dialog box
     * @param title Title to be displayed in the box
     * @param message Message to be displayed in the box
     * @param confirmText What we want to show as the "OK" text
     */
    public AlertBox(Activity parentActivity, String title, String message, String confirmText){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(parentActivity);

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(confirmText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Blank as we only want to close the box
            }
        });
        alertDialog.show();

    }

}
