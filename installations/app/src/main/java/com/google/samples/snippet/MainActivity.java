package com.google.samples.snippet;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.InstallationTokenResult;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logInstallationAuthToken();
    }

    private void logInstallationAuthToken() {
        // [START get_installation_token]
        FirebaseInstallations.getInstance().getToken(/* forceRefresh */true)
                .addOnCompleteListener(new OnCompleteListener<InstallationTokenResult>() {
            @Override
            public void onComplete(@NonNull Task<InstallationTokenResult> task) {
                if (task.isComplete() && task.getResult() != null) {
                    Log.d("Installations", "Installation auth token: " + task.getResult().getToken());
                }
            }
        });
        // [END get_installation_token]
    }

    private void logInstallationID() {
        // [START get_installation_id]
        FirebaseInstallations.getInstance().getId()
                .addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (task.isComplete()) {
                    Log.d("Installations", "Installation ID: " + task.getResult());
                }
            }
        });
        // [END get_installation_id]
    }
}
