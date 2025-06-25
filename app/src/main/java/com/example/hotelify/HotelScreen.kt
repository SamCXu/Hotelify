package com.example.hotelify

import android.R.attr.fontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HotelScreen() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Color.White)
        .padding(top = 20.dp))
    {
        // Hotel Image Section
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image),
                    contentDescription = "Hotel Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(400.dp) // Fixed width instead of max width
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Box(
                    modifier = Modifier
                        .width(400.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Black.copy(alpha = 0.4f)) // Adjust alpha for desired darkness
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    "Roy's Luxury Hotel",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wifi),
                        contentDescription = "Rating",
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        "Jakarta, Indonesia",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "$150 / night",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_wifi),
                    contentDescription = "Rating",
                    modifier = Modifier.size(18.dp)
                )
                Text(" 4.9 (10,853 Reviews)", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Facilities", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                FacilityItem("2 Beds", R.drawable.ic_wifi)
                FacilityItem("Wi-Fi", R.drawable.ic_wifi)
                FacilityItem("Breakfast", R.drawable.ic_wifi)
                FacilityItem("AC", R.drawable.ic_wifi)
                FacilityItem("Pool", R.drawable.ic_pool)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Check-in & Check-out", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Check-in\nFrom 2:00 PM", fontSize = 16.sp, color = Color.Gray)
                Text("Check-out\nUntil 11:00 AM", fontSize = 16.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Hotel Description", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(
                "If you want to live in a world full of luxuries, then Roy's Luxury Hotel is the perfect choice for you. Experience ultimate relaxation, top-notch services, and breathtaking views, all in one place.",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Read more",
                fontSize = 16.sp,
                color = Color(0xFF1D88FE),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    println("Text clicked!")
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D88FE))
        ) {
            Text("More Info", color = Color.White)
        }
    }
}

@Composable
private fun FacilityItem(name: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(65.dp) // Ensure consistent width for all items
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = name,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the text
        )
    }
}

