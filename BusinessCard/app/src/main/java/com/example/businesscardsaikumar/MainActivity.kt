package com.example.businesscardsaikumar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardsaikumar.ui.theme.BusinessCardSaikumarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardSaikumarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFF8E1) // Background color
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
            .background(Color(0xFFFFF8E1)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top section
        LogoAndTitleSection()

        Spacer(modifier = Modifier.height(160.dp))

        // Bottom section
        ContactInfoSection()
    }
}

@Composable
fun LogoAndTitleSection() {
    val image = painterResource(R.drawable.android_logo)

    Image(
        painter = image,
        contentDescription = stringResource(R.string.logo_description),
        modifier = Modifier
            .size(120.dp)
            .padding(8.dp),
        contentScale = ContentScale.Fit
    )

    Text(
        text = stringResource(R.string.full_name),
        fontSize = 36.sp,
        color = Color.Black
    )

    Text(
        text = stringResource(R.string.title),
        color = Color(0xFF006D3B),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}

@Composable
fun ContactInfoSection() {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        ContactRow(icon = Icons.Default.Phone, info = stringResource(R.string.phone_number))
        ContactRow(icon = Icons.Default.Share, info = stringResource(R.string.social_handle))
        ContactRow(icon = Icons.Default.Email, info = stringResource(R.string.email))
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .padding(start = 60.dp, end = 60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = info,
            color = Color.Black,
            fontSize = 14.sp,
            maxLines = 1,                // keep it to a single line
            softWrap = false,            // prevent wrapping
            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis, // add "..." if too long
            modifier = Modifier.weight(1f)
        )
    }
}
