package com.example.mnpapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mnpapp.ui.theme.MNPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MNPAppTheme {

                var name by remember {
                    mutableStateOf("")
                }

                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        OutlinedTextField(value = name, onValueChange = { text ->
                            name = text
                        })

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(onClick = {
                            if(name.isNotEmpty() && name.isNotBlank()) {
                                names = names + name
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }
                    LazyColumn{
                        items(names){  currentName ->
                            Text(text = currentName)
                        }
                    }

                }
            }
        }
    }
}
