package com.example.phonedialerapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phonedialerapp.data.DataSource
import com.example.phonedialerapp.ui.theme.PhoneDialerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhoneDialerAppTheme {
                DialAppPage()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialAppPage(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val homeNumber = "+201123456678"
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp),
                    ) {
                        Text("Contacts App")
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_home_24),
                            contentDescription = "Home",
                            modifier = Modifier
                                .size(28.dp)
                                .clickable {
                                    val callIntent =
                                        Intent(Intent.ACTION_DIAL, Uri.parse("tel:$homeNumber"))
                                    context.startActivity(callIntent)
                                }
                        )
                    }
                },

                )
        },
    )
    { innerPadding ->
        ContactList(innerPadding, context)
    }
}

@Composable
fun ContactList(scaffoldPadding: PaddingValues, context: Context, modifier: Modifier = Modifier) {
    var contacts = DataSource().getContactsData()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp),
        modifier = modifier.padding(scaffoldPadding)
    ) {
        items(contacts) { contact ->
            SingleContact(contact.image, contact.name, contact.number, context)
        }
    }
}

@Composable
fun SingleContact(image: Int, name: String, number: String, context: Context, modifier: Modifier = Modifier) {
    Column(modifier = modifier.clickable {
        val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        context.startActivity(callIntent)
    }) {
        Image(painter = painterResource(id = image), contentDescription = name)
        Surface(
            color = Color.LightGray,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = name, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                SelectionContainer {
                    Text(text = number)
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun DialAppPagePreview() {
    DialAppPage()
}


