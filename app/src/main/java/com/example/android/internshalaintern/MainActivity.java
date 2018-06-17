package com.example.android.internshalaintern;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private int RC_SIGN_IN = 1;
    private Boolean userSignedIn = false;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    FragmentManager fragmentManager;
    DashboardFragment dashboardFragment;
    AvailableWorkshopFragment availableWorkshopFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // FireBase Log-In Initializations
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //user signed in
                    //onSignedInInitialise();
                    Toast.makeText(MainActivity.this,"Logged_IN", Toast.LENGTH_SHORT).show();
                }
                else{
                    //user signed out
                    //onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()
                                    ))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

        dashboardFragment = new DashboardFragment();
        availableWorkshopFragment = new AvailableWorkshopFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.mainFullContainer, dashboardFragment)
                .commit();


    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.Dashboard:
//                startDashboard();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.CourseAvailable:
                //open the Available course page
                fragmentManager.beginTransaction()
                        .remove(dashboardFragment)
                        .commit();
                fragmentManager.beginTransaction()
                        .add(R.id.mainFullContainer,availableWorkshopFragment )
                        .commit();
//                startAvailableCourse();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {

            if (resultCode == RESULT_OK) {
                userSignedIn = true;
                Toast.makeText(this, "Sign In successful", Toast.LENGTH_SHORT).show();
                //open Dashboard Screen
//                startDashboard();
            }
            else if (resultCode == RESULT_CANCELED) {
                userSignedIn = false;
                Toast.makeText(this, "Sign In Cancelled", Toast.LENGTH_SHORT).show();
                finish();
                //
//              startAvailableCourse();
                //open Available Workshop screen
            }
        }
    }
}
