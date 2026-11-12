package com.example.androidbasictoadvanced.vetexpress

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocationAlt
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.FrontHand
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Motorcycle
import androidx.compose.material.icons.filled.Outbox
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.QrCodeScanner
import com.example.androidbasictoadvanced.R


val bottomList = listOf(
    BottomModel(Icons.Filled.Home, Icons.Outlined.Home, "Home"),
    BottomModel(Icons.Filled.Outbox, Icons.Outlined.Outbox, "History"),
    BottomModel(Icons.Filled.QrCodeScanner, Icons.Outlined.QrCodeScanner),
    BottomModel(Icons.Filled.People, Icons.Outlined.People, "Members"),
    BottomModel(Icons.Filled.LocationOn, Icons.Outlined.LocationOn, "Location")
)
val boxesList1 = listOf(
    Boxes(R.drawable.img_vet_express, "VET Ticket"),
    Boxes(R.drawable.img_vet_express, "Air Bus Ticket"),
    Boxes(R.drawable.img_vet_express, "Boat Ticket"),
)

val boxesList2 = listOf(
    Boxes(R.drawable.img_vet_express, "Power Station"),
    Boxes(R.drawable.img_vet_express, "Rent Car Service"),
    Boxes(R.drawable.img_vet_express, "V-Buy"),
)

val serviceList = listOf(
    Service(Icons.Filled.FrontHand, "Self Service"),
    Service(Icons.Filled.Motorcycle, "Delivery"),
    Service(Icons.Filled.AddLocationAlt, "Chinese Address"),
    Service(Icons.Filled.DirectionsCar, "Travel Package"),
    Service(Icons.Filled.AirplanemodeActive, "Aviation"),
    Service(Icons.Filled.FoodBank, "V-Market"),
)

val accommodationList = listOf(
    Accommodation(R.drawable.img_pnhum_kulen, "Apikjun", "$100 ~ $474"),
    Accommodation(R.drawable.img_pnhum_kulen, "Camping Park Resort", "$70 ~ $189"),
    Accommodation(R.drawable.img_pnhum_kulen, "Eden Beach", "$89 ~ $189"),
    Accommodation(R.drawable.img_pnhum_kulen, "Koh Sdach Resort", "$84 ~ $174"),
    Accommodation(R.drawable.img_pnhum_kulen, "Mad Monkey Koh Sdach", "$9 ~ $39"),
    Accommodation(R.drawable.img_pnhum_kulen, "One Beach Resort", "$60 ~ $195"),
    Accommodation(R.drawable.img_pnhum_kulen, "Phnom Penh Smile...", "$58 ~ $105"),
    Accommodation(R.drawable.img_pnhum_kulen, "Pidoma Resort", "$39 ~ $198"),
    Accommodation(R.drawable.img_pnhum_kulen, "Romdoul Kirirom", "$105 ~ $205"),
    Accommodation(R.drawable.img_pnhum_kulen, "Sara Resort", "$59 ~ $219"),
)