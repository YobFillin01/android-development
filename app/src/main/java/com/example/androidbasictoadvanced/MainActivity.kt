package com.example.androidbasictoadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.androidbasictoadvanced.feature.buttons.ScreenSegmentButtonWithSingleChoice
import com.example.androidbasictoadvanced.feature.datepicker.ScreenDatePickerDialog
import com.example.androidbasictoadvanced.feature.datepicker.ScreenDatePickerWithRange
import com.example.androidbasictoadvanced.feature.dialog.FullScreenDialog
import com.example.androidbasictoadvanced.feature.dialog.ScreenDialog
import com.example.androidbasictoadvanced.feature.menu.ScreenMenu
import com.example.androidbasictoadvanced.feature.navigationbar.ScreenBottomNavigationBar
import com.example.androidbasictoadvanced.feature.navigationdrawer.ScreenNavigationDrawer
import com.example.androidbasictoadvanced.feature.progressindicator.ScreenProgressIndicator
import com.example.androidbasictoadvanced.feature.timepicker.ScreenTimePicker
import com.example.androidbasictoadvanced.navigation.BaseNavigation
import com.example.androidbasictoadvanced.practice.screenUI.ScreenABABank
import com.example.androidbasictoadvanced.practice.screenUI.ScreenCoffeeShop
import com.example.androidbasictoadvanced.practice.screenUI.ScreenGrocery
import com.example.androidbasictoadvanced.practice.screenUI.ScreenKBPRASACBank
import com.example.androidbasictoadvanced.practice.screenUI.ScreenOrderFood2
import com.example.androidbasictoadvanced.practice.screenUI.ScreenWingBank
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicToAdvancedTheme {

                BaseNavigation()

                //ScreenButtons()
                //ScreenSegmentButtonWithSingleChoice()

//                HomeScreen Bank
//                ScreenABABank()
//                ScreenKBPRASACBank()
//                ScreenWingBank()
//                ScreenDatePickerDialog()
//                ScreenDatePickerWithRange()
//                ScreenTimePicker()
//                ScreenGrocery()
//                ScreenDialog()
//                ScreenProgressIndicator()
//                ScreenCoffeeShop()
//                FullScreenDialog()
//                ScreenOrderFood2()
//                ScreenMenu()
//                ScreenBottomNavigationBar {  }
//                ScreenNavigationDrawer {  }
            }
        }
    }
}