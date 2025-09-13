package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.myapplication.ui.theme.MyApplicationTheme
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: create executed")
        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show()
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        LifecycleStatus()
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop: stop executed")
        Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: start executed")
        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: pause executed")
        Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: resume executed")
        Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart: restart executed")
        Toast.makeText(this, "restart", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun LifecycleStatus() {
    var lifecycleState by remember { mutableStateOf("UNINITIALIZED") }
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycleState = when (event) {
                Lifecycle.Event.ON_CREATE -> "ON_CREATE"
                Lifecycle.Event.ON_START -> "ON_START"
                Lifecycle.Event.ON_RESUME -> "ON_RESUME"
                Lifecycle.Event.ON_PAUSE -> "ON_PAUSE"
                Lifecycle.Event.ON_STOP -> "ON_STOP"
                Lifecycle.Event.ON_DESTROY -> "ON_DESTROY"
                else -> event.toString()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Text(
        text = "Текущее состояние: $lifecycleState",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
