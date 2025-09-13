package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import android.util.Log //используем это для логов
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //это самый старт
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: create executed ") //лог при старте?
        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show()
        enableEdgeToEdge()
        setContent {

            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(

                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onCreate: stop executed ")
        Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onCreate: start executed ")
        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onCreate: pause executed ")
        Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onCreate: resume executed ")
        Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onCreate: restart executed ")
        Toast.makeText(this, "restart", Toast.LENGTH_SHORT).show()
    }

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