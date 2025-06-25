package com.example.hotelify

import android.R.attr.fontWeight
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HotelDetailScreen() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .background(Color.White))
    {
        // Hotel Image Section
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_image),
                    contentDescription = "Hotel Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(Color.Black.copy(alpha = 0.4f)) // Adjust alpha for desired darkness
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(18.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    "Roy's Luxury Hotel",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Somewhere, TX",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    "Your Stay: Nov 5 - Nov 12",
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "2 Guests ・ 1 Bedroom ・ 1 Bed ・ 1 Bath",
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                    textAlign = TextAlign.Center
                )
            }
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .height(130.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    FacilityItem("2 Beds", R.drawable.ic_wifi)
                    FacilityItem("Wi-Fi", R.drawable.ic_wifi)
                    FacilityItem("Breakfast", R.drawable.ic_wifi)
                    FacilityItem("Pool", R.drawable.ic_pool)
                }
                Box(modifier = Modifier.padding(vertical = 30.dp)) {
                    Column {
                        Text(
                            "30°",
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                            textAlign = TextAlign.End
                        )
                        Text(
                            "Temperature",
                            fontSize = 14.sp,
                            color = Color.Black,
                            modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Calculate the center of the canvas
                val canvasWidth = size.width
                val canvasHeight = size.height

                // Calculate start and end points for the centered line
                val start = Offset(0f, canvasHeight / 2f) // Start from left center
                val end = Offset(canvasWidth, canvasHeight / 2f) // End at right center

                // Draw the line
                drawLine(
                    color = Color(0xFFF4F4F3),  // Line color
                    start = start,        // Start point
                    end = end,            // End point
                    strokeWidth = 5f      // Line width
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(242.dp)
                    .height(110.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF4F4F3)) // Color the entire Box
            ) {
                Column {
                    Text(
                        text = "House rules",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 14.dp
                        ) // Center the text inside the Box
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(modifier = Modifier.padding(start = 16.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wifi),
                            contentDescription = "clock",
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "  Earliest check-in time: 14:00",
                            fontSize = 14.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(modifier = Modifier.padding(start = 16.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wifi),
                            contentDescription = "clock",
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "  Earliest check-in time: 12:00",
                            fontSize = 14.sp,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Room 123, 4th FL, Building A, Heavens Hotel, 10-1...",
                fontSize = 14.9.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth(), // Ensures the text takes up the full width
                textAlign = TextAlign.Start
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
            ) {
                CustomButton("Check In", R.drawable.ic_wifi, onClick = {
                    println("lol")
                })
                CustomButton("Check Out", R.drawable.ic_wifi, onClick = {
                    println("lol")
                })
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
            ) {
                CustomButton("Room Key", R.drawable.ic_wifi, onClick = {
                    println("lol")
                })
                CustomButton("Call Concierge", R.drawable.ic_wifi, onClick = {
                    println("lol")
                })
            }
        }
    }
}

@Composable
private fun FacilityItem(name: String, iconRes: Int) {
    Row {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = name,
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = "  $name",
            fontSize = 14.sp,
        )
    }
}

@Composable
fun CustomButton( label: String, iconResId: Int, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color(0xFF1D88FE)
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.5.dp, Color(0xFF1D88FE)),
        modifier = Modifier
            .width(180.dp)
            .height(55.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),  // Make the Row fill the button width
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center  // Center content horizontally
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = label,
                modifier = Modifier.size(20.dp)
            )
            Text(
                "  $label",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1D88FE)
            )
        }
    }

}


