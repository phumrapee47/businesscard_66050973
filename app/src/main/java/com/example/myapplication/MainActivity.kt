package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3D3D3))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Main business card container
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.Red),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Image
                Image(
                    painter = painterResource(id = R.drawable.profile), // ใส่รูปโปรไฟล์ใน drawable
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(top = 24.dp),
                    contentScale = ContentScale.Crop
                )

                // Name
                Text(
                    text = "Phumrapee Kaewmanee",
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 16.dp)
                )

                // Title
                Text(
                    text = "Mobile Developer",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Contact information card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.Red),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column {
                // Phone
                ContactInfoRow(
                    iconContent = {
                        Image(
                            painter = painterResource(id = R.drawable.phone_call),
                            contentDescription = "Phone Call Icon",
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.Fit
                        )
                    },
                    text = "+66 92 768 3886"
                )

                // Social
                ContactInfoRow(
                    iconContent = {
                        Image(
                            painter = painterResource(id = R.drawable.social),
                            contentDescription = "Social Icon",
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.Fit
                        )
                    },
                    text = "phumrapee kaewmanee"
                )

                // Email
                ContactInfoRow(
                    iconContent = {
                        Image(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Email Icon",
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.Fit
                        )
                    },
                    text = "66050973@kmitl.ac.th"
                )
            }
        }
    }
}

@Composable
fun ContactInfoRow(
    iconContent: @Composable () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.LightGray)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(32.dp),
            contentAlignment = Alignment.Center
        ) {
            iconContent()
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFE6E6FA))
                .border(1.dp, Color(0xFF9370DB))
                .padding(8.dp)
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}

@Composable
fun BusinessCardTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}
