package com.example.basicsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicsjetpackcompose.ui.theme.BasicsJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                MyScreen()
            }
        }
    }
}
@Composable
fun MyApp(content :@Composable ()-> Unit)
{
    BasicsJetPackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
@Composable
fun MyScreen( names: List<String> = listOf("Android","There"))
{
    Column {
       for(name in names)
       {
           Greeting(name)
           Divider()
       }
        Counter()
    }
}
@Composable
fun Counter()
{
    val counter :Int  by remember {
        mutableStateOf(0)
    }
    Button(onClick = { navigateToNextScreen() }) {
        Text(text = "I have been clicked $counter times!")
    }

}

fun navigateToNextScreen() {

}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Cyan)
    {
        Text(text = "Hello $name!",modifier= Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MyApp {
      MyScreen()
  }
}