package com.arun.myapp.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arun.myapp.MainActivity;
import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;

import com.arun.myapp.R;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class FacebookMain extends AppCompatActivity {

    Application application;
    CallbackManager callbackManager;
    LoginButton loginButton;
    private static final String EMAIL = "email";

    ImageView imageView;
    TextView txtUsername, txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_main);

        imageView = findViewById(R.id.imageView);
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);

        FacebookSdk.sdkInitialize(getApplicationContext());
        application = getApplication();
        AppEventsLogger.activateApp(application);

        callbackManager = CallbackManager.Factory.create();


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        checkLogStatus(accessToken);

        boolean loggedOut = AccessToken.getCurrentAccessToken() == null;

//         if (!loggedOut) {
//            Picasso.get().load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
//            Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());
//            txtUsername.setText(Profile.getCurrentProfile().getName());
//            txtEmail.setText(Profile.getCurrentProfile().getId());
//
//            //Using Graph API
//            //getUserProfile(AccessToken.getCurrentAccessToken());
//        }

        //getUserProfile(accessToken);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL,"public_profile"));
        // If you are using in a fragment, call loginButton.setFragment(this);


        /**for login custom button
         * LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
         *
         *for custom logout button
         *LoginManager.getInstance().logOut();
         */

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//
//                Picasso.get().load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
//                Log.d("TAG", "Username is: " + Profile.getCurrentProfile().getName());
//                txtUsername.setText(Profile.getCurrentProfile().getName());
//                txtEmail.setText(Profile.getCurrentProfile().getId());
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });



    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken==null){
                txtUsername.setText("");
                txtEmail.setText("");
                imageView.setImageResource(0);
                Toast.makeText(application, "User Logged Out", Toast.LENGTH_SHORT).show();
            }else getUserProfile(currentAccessToken);
        }
    };

    private void getUserProfile(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("TAG", object.toString());
                        try {
                            String first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String email = object.getString("email");
                            String id = object.getString("id");
                            String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";
                            String url =object.getJSONObject("picture").getJSONObject("data").getString("url");

                            txtUsername.setText("First Name: " + first_name + "\nLast Name: " + last_name);
                            txtEmail.setText(email);
                            //Picasso.get().load(image_url).into(imageView);
                            //Glide.with(FacebookMain.this).load(image_url).into(imageView);
                            Picasso.get().load(Profile.getCurrentProfile().getProfilePictureUri(200, 200)).into(imageView);
                            //Picasso.get().load(url).into(imageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }

    private void checkLogStatus(AccessToken accessToken){
        if(accessToken!=null) {
            getUserProfile(accessToken);
        }
    }

}