package com.aviva.mlkit_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private val cameraPermission = android.Manifest.permission.CAMERA

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if (isGranted){
            //Start Scanner
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun requestCameraAndStrartScanner(){
        if(isPermissonGranted(cameraPermission)){
            // Start Scanner
        } else {
            requestCameraPermission()
        }
    }

    private fun requestCameraPermission(){
        when {

            /**
             *  shouldShowRequestPermissionRationale
             *  Es una función en Android que forma parte del sistema de gestión de permisos.
             *  Se utiliza para determinar si se debe mostrar una explicación al usuario
             *  sobre por qué se necesita un permiso especifico.
             */

            shouldShowRequestPermissionRationale(cameraPermission) ->{
                cameraPermissionRequest {
                    openPermissionSettings()
                }
            }
            else -> {
                requestPermissionLauncher.launch(cameraPermission)
            }
        }
    }
}