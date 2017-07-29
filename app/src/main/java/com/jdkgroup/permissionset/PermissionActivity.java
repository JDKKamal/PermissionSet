package com.jdkgroup.permissionset;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class PermissionActivity extends AppCompatActivity implements OnRequestPermissionsResultCallback, PermissionResultCallback {

    AppCompatButton btnAppCheckPermission;
    ArrayList<String> permissions = new ArrayList<>();

    PermissionUtils permissionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        permissionUtils = new PermissionUtils(PermissionActivity.this);

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        btnAppCheckPermission = (AppCompatButton) findViewById(R.id.btnAppCheckPermission);
        btnAppCheckPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionUtils.check_permission(permissions, "Explain here why the app needs permissions", 1);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // redirects to utils
        permissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    // Callback functions
    @Override
    public void PermissionGranted(int request_code) {
        Log.i("PERMISSION", "GRANTED");
    }

    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {
        Log.i("PERMISSION PARTIALLY", "GRANTED");
    }

    @Override
    public void PermissionDenied(int request_code) {
        Log.i("PERMISSION", "DENIED");
    }

    @Override
    public void NeverAskAgain(int request_code) {
        Log.i("PERMISSION", "NEVER ASK AGAIN");
    }
}
