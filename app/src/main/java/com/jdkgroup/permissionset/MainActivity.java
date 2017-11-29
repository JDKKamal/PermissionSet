package com.jdkgroup.permissionset;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.CAMERA)
                .subscribe(permission -> {
                    if (permission.granted) {
                        Toast.makeText(MainActivity.this, "onPermissionsGranted", Toast.LENGTH_SHORT).show();
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        Toast.makeText(MainActivity.this, "Denied permission without ask never again", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
