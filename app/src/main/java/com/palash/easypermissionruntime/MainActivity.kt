package com.palash.easypermissionruntime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import android.Manifest
import android.widget.Toast

class MainActivity : AppCompatActivity() , EasyPermissions.PermissionCallbacks {

    private val REQUEST_CODE_PERMISSIONS = 100
    private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!hasPermissions()) {
            requestPermissions()
            Toast.makeText(this, "suny", Toast.LENGTH_SHORT).show()
        } else {
            // Permissions have already been granted
            // Proceed with your code that requires permissions
            Toast.makeText(this, "nanana", Toast.LENGTH_SHORT).show()
        }
    }

    private fun hasPermissions(): Boolean {
        Toast.makeText(this, "Permission not allowed", Toast.LENGTH_SHORT).show()
        return EasyPermissions.hasPermissions(this, *REQUIRED_PERMISSIONS)

    }

    private fun requestPermissions() {
        EasyPermissions.requestPermissions(
            this,
            "This app needs camera and storage permissions",
            REQUEST_CODE_PERMISSIONS,
            *REQUIRED_PERMISSIONS
        )
        Toast.makeText(this, "rrrrrrr", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
        Toast.makeText(this, "asassa", Toast.LENGTH_SHORT).show()
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        // Called when permissions are granted
        // Proceed with your code that requires permissions
        Toast.makeText(this, "Permission allowed", Toast.LENGTH_SHORT).show()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        // Called when permissions are denied
        Toast.makeText(this, "hahahaha", Toast.LENGTH_SHORT).show()
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            // Navigate user to app settings
            AppSettingsDialog.Builder(this).build().show()
            Toast.makeText(this, "DDDD", Toast.LENGTH_SHORT).show()
        }
    }
}