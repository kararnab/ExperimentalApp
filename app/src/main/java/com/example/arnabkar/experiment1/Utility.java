package com.example.arnabkar.experiment1;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Utility {

    /**
     * This method will open the default web browser in Android devices, if none found it will be reported to crashlytics
     * @param context The context to open the activity from, usually an activity context
     * @param url The url to open
     */
    static void openWebBrowser(Context context,String url){
        try {
            if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No application can handle this request."
                    + " Please install a web browser",  Toast.LENGTH_LONG).show();
            e.printStackTrace(); //todo: Its better to send such info to crashlytics
        }
    }

    /**
     *  Utility function to check for strong password, it will be replaced with Google oAuth as
     *  password rules are bad. They limit the number of potential passwords and removing
     *  password permutations that don't match your rules. This allows hackers to ensure their
     *  attacks do the same!
     * @param password The password
     * @return true if the password is strong, else false
     */
    @Deprecated
    boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        /*

        Explanation:
        ^                   # start-of-string
        (?=.*[0-9])         # a digit must occur at least once
        (?=.*[a-z])         # a lower case letter must occur at least once
        (?=.*[A-Z])         # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])    # a special character must occur at least once
        (?=\S+$)            # no whitespace allowed in the entire string
        .{8,}               # anything, at least eight places though
        $                   # end-of-string

         */
        return password.matches(passwordRegex);
    }

}
