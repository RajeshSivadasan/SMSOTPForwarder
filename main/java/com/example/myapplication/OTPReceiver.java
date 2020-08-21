package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OTPReceiver extends BroadcastReceiver {

    private static EditText editText_otp;


    public void setEditText_otp(EditText editText){
        OTPReceiver.editText_otp = editText;
    }

    @Override public void onReceive(Context context, Intent intent) {
//        Log.d("A", "onReceive: ");

        SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        String getOTP = "null";

        Pattern mPattern = Pattern.compile("(|^)\\d{6}");

        for (SmsMessage smsMessage : smsMessages){
            String message_body = smsMessage.getMessageBody();
            if(message_body!=null) {
                Matcher mMatcher = mPattern.matcher(message_body);
                if(mMatcher.find()) {
                    getOTP = mMatcher.group(0);
                }else {
                    //something went wrong
                     Log.e("Rajesh","Failed to extract the OTP!! ");
                }
            }
//            getOTP = message_body.split(":")[1];
            editText_otp.setText(getOTP);
        }


        new HttpRequestTask().execute(getOTP);

//        Log.e("Rajesh",getOTP);
////        Intent telegramIntent = new Intent( Intent.ACTION_VIEW);
//        Intent telegramIntent = new Intent( Intent.ACTION_SEND);
//            telegramIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        telegramIntent.setData(Uri.parse("http://telegram.me/+1373818799"));
//        final String appName = "org.telegram.messenger";
//        telegramIntent.setPackage(appName);
//        telegramIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
//        context.startActivity(telegramIntent);

//        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        //Add Telegram token (rajeshOtpBot)
//        String apiToken = "1373818799:AAE36lyw_BEWPqUvWCttIGSQZyVS9SUrpeA";

        //Add chatId otpGroup
//        String chatId = "-1001377777518";
//        String chatId = "1373818799";   //rajeshOtpBot
//        String chatId = "670221062";

//        urlString = String.format(urlString, apiToken, chatId, getOTP.trim());
//        Log.i("Rajesh", urlString);
//
//        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
//
//// prepare the Request
//        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, urlString, null,
//                new Response.Listener<JSONObject>()
//                {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // display response on Success
//                        Log.d("Response", response.toString());
//                    }
//                },
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("Error.Response", error.toString());
//                    }
//                }
//        );
//
//// add it to the RequestQueue
//        queue.add(getRequest);

    }

    private static class HttpRequestTask extends AsyncTask<String,Void, Integer> {

        @Override
        protected Integer doInBackground(String... getOTP) {
            String urlString = "https://k8lh02evc6.execute-api.ap-south-1.amazonaws.com/dev/otp?new_otp=" + getOTP[0];

            try {
                URL url = new URL(urlString);
                URLConnection conn = url.openConnection();
                Log.i("Rajesh", urlString);
                InputStream is = new BufferedInputStream(conn.getInputStream());
//            new BufferedInputStream(conn.getInputStream());
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

}