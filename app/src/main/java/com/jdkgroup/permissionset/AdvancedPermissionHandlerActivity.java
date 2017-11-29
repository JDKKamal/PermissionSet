package com.jdkgroup.permissionset;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.Toast;

import com.jdkgroup.customview.advancedpermissionshandler.PermissionHandlerActivity;

public class AdvancedPermissionHandlerActivity extends PermissionHandlerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_permission_handler);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> askForPermission(new String[]{Manifest.permission.SEND_SMS, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.USE_SIP, Manifest.permission.GET_ACCOUNTS}, false, new PermissionCallBack() {
            @Override
            public void onPermissionsGranted() {
                Toast.makeText(AdvancedPermissionHandlerActivity.this, "onPermissionsGranted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionsDenied(String[] permissions) {
                for (int i = 0; i < permissions.length; i++) {
                    System.out.println("Tag" + permissions[i]);
                }
                Toast.makeText(AdvancedPermissionHandlerActivity.this, "onPermissionsDenied ", Toast.LENGTH_SHORT).show();
            }


        }));
    }
}
