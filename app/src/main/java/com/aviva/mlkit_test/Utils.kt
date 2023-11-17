package com.aviva.mlkit_test

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import androidx.core.content.ContextCompat


fun Context.isPermissonGranted(permission: String) : Boolean {
    return ContextCompat.checkSelfPermission(this,permission) ==
            PackageManager.PERMISSION_GRANTED
}

inline fun Context.cameraPermissionRequest(crossinline positive: () -> Unit){
    AlertDialog.Builder(this)
        .setTitle("Camera Permission Requiered")
        .setMessage("Without accessing the camera it is not possible to work")
        .setPositiveButton("Allow Camera") {dialog, which -> positive.invoke()}
        .setNegativeButton("Cancel") {dialog, which -> }
        .show()
}

fun Context.openPermissionSettings(){
    Intent(ACTION_APPLICATION_DETAILS_SETTINGS).also {
        val uri : Uri = Uri.fromParts("package", packageName, null)
        it.data = uri
        startActivity(it)
    }
}