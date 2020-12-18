package com.morganstanley;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;

public class AndroidToast extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("show".equals(action)) {
            show(args.getString(0), callbackContext);
            return true;
        }
        return false;
    }

    private void show(String message, CallbackContext callbackContext) {
        if (message == null || message.length() == 0) {
            callbackContext.error("Error occurred: missing message");
            return;
        }

        Toast.makeText(webView.getContext(), message, Toast.LENGTH_LONG).show();
        callbackContext.success(message);
    }
} 