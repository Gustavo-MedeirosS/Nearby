package com.example.nearby.ui.screen.qrcode_scanner

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.nearby.MainActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun QRCodeScannerScreen(
    onCompletedScan: (String) -> Unit
) {
    val context = LocalContext.current

    val scanOptions = ScanOptions()
        .setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        .setPrompt("Leia o QR Code do cupom")
        .setCameraId(1)
        .setBeepEnabled(false)
        .setOrientationLocked(false)
        .setBarcodeImageEnabled(true)

    val barcodeLauncher = rememberLauncherForActivityResult(contract = ScanContract()) { result ->
        onCompletedScan(result.contents.orEmpty())
    }

    val cameraPermissionLaucnher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            if (!isGranted) {
                ActivityResultContracts.RequestPermission()
            } else {
                barcodeLauncher.launch(scanOptions)
            }
        }

    fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CAMERA
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            barcodeLauncher.launch(scanOptions)
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                context as MainActivity,
                android.Manifest.permission.CAMERA
            )
        ) {
            Toast.makeText(
                context,
                "Necessário permitir o acesso à câmera para continuar",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            cameraPermissionLaucnher.launch(android.Manifest.permission.CAMERA)
        }
    }

    LaunchedEffect(key1 = true) {
        checkCameraPermission()
    }

    Column(modifier = Modifier.fillMaxSize()) {}
}