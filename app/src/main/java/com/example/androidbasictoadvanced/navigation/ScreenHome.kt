package com.example.androidbasictoadvanced.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.util.Loading
import com.example.androidbasictoadvanced.util.LoadingUtil
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


data class ComponentItem(
    val title: String,
    val screen: Screen,
    val icon: ImageVector
)

val componentsList = listOf(
    ComponentItem("Badge", Screen.Badge, Icons.Default.Badge),
    ComponentItem("Buttons", Screen.Buttons, Icons.Default.SmartButton),
    ComponentItem("Bottom Sheet", Screen.BottomSheet, Icons.Default.VerticalAlignBottom),
    ComponentItem("Cards", Screen.Cards, Icons.Default.CreditCard),
    ComponentItem("Carousel", Screen.Carousel, Icons.Default.ViewCarousel),
    ComponentItem("CheckBox", Screen.CheckBox, Icons.Default.CheckBox),
    ComponentItem("Date Picker", Screen.DatePicker, Icons.Default.DateRange),
    ComponentItem("Date Picker with range", Screen.DatePickerWithRange, Icons.Default.CalendarMonth),
    ComponentItem("Dialog", Screen.Dialog, Icons.Default.ChatBubble),
    ComponentItem("Lazy Row", Screen.LazyRow, Icons.Default.ViewWeek),
    ComponentItem("Lazy Column", Screen.LazyColumn, Icons.Default.ViewColumn),
    ComponentItem("Menu", Screen.Menu, Icons.Default.Menu),
    ComponentItem("Navigation Bar", Screen.NavigationBar, Icons.Default.CalendarToday),
    ComponentItem("Navigation Drawer", Screen.NavigationDrawer, Icons.AutoMirrored.Filled.MenuOpen),
    ComponentItem("Progress Indicator", Screen.ProgressIndicator, Icons.Default.Refresh),
    ComponentItem("Radio", Screen.Radio, Icons.Default.RadioButtonChecked),
    ComponentItem("Scaffold", Screen.Scaffold, Icons.Default.Layers),
    ComponentItem("Slider", Screen.Slider, Icons.Default.LinearScale),
    ComponentItem("Snackbar", Screen.Snackbar, Icons.AutoMirrored.Filled.Announcement),
    ComponentItem("Spacer", Screen.Spacer, Icons.Default.Height),
    ComponentItem("Switch", Screen.Switch, Icons.Default.ToggleOn),
    ComponentItem("Tab", Screen.Tab, Icons.Default.Tab),
    ComponentItem("TextField", Screen.TextField, Icons.Default.Edit),
    ComponentItem("Time Picker", Screen.TimePicker, Icons.Default.AccessTime),
    ComponentItem("Toolbar", Screen.Toolbar, Icons.Default.Build),
    ComponentItem("Tooltip", Screen.Tooltip, Icons.Default.Info),
    ComponentItem("Aceleda Bank", Screen.Aceleda, Icons.Default.PhoneAndroid),
    ComponentItem("Wing Bank", Screen.Wing, Icons.Default.PhoneAndroid),
    ComponentItem("KB Prasac Bank", Screen.KBPrasac, Icons.Default.PhoneAndroid),
)

@Composable
fun ScreenHome(
    onClickComponent: (Screen) -> Unit
) {

    val lifecycleOwner = LocalLifecycleOwner.current

    val homeVM: HomeVM = viewModel()

    val state by homeVM.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        homeVM.fetchComponentList()
    }

    LaunchedEffect(state) {
        LoadingUtil.showLoading()
        delay(1000.milliseconds)
        println("=====> $state")
        LoadingUtil.hideLoading()
    }


    // Test Compose Life cycle

    /**
     * Fetch data from a server
     * Read from a database
     * Delay for 3 seconds
     * Show a Snackbar
     * Navigate to another screen
     * Print logs
     */
    LaunchedEffect(Unit) {
        println("=====> LaunchedEffect")
    }

    DisposableEffect(key1 = lifecycleOwner) {

        val observer = LifecycleEventObserver { _, event ->

            when (event) {

                Lifecycle.Event.ON_CREATE -> {
                    println("=====> ON_CREATE")
                }

                Lifecycle.Event.ON_START -> {
                    println("=====> ON_START")
                }

                Lifecycle.Event.ON_RESUME -> {
                    println("=====> ON_RESUME")
                }

                Lifecycle.Event.ON_PAUSE -> {
                    println("=====> ON_PAUSE")
                }

                Lifecycle.Event.ON_STOP -> {
                    println("=====> ON_STOP")
                }

                Lifecycle.Event.ON_DESTROY -> {
                    println("=====> ON_DESTROY")
                }

                else -> {
                    // No action needed
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            println("=====> Observer Removed")
        }
    }


    Scaffold(

        topBar = {
            TopAppBar(

                title = {
                    Text(
                        text = "Master Android",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.img_my_picture),
                        contentDescription = "My picture",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                },

                actions = {
                    BadgedBox(
                        badge = {
                            Badge(
                                modifier = Modifier.size(8.dp)
                            )
                        }
                    ) {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_notification),
                                contentDescription = "Notifications",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            )
        }

    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(componentsList.size) { index ->

                val component = componentsList[index]

                ListItem(
                    leadingContent = {
                        Icon(
                            imageVector = component.icon,
                            contentDescription = null,
                            tint = Color(0xFFA47EDD)
                        )
                    },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    },
                    modifier = Modifier
                        .clickable {
                            onClickComponent(component.screen)
                        }
                ) {
                    Text(text = component.title)
                }

                HorizontalDivider()
            }
        }
    }
}

@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
@Composable
fun ScreenHomePreview() {
    AndroidBasicToAdvancedTheme {
        ScreenHome(
            onClickComponent = {}
        )
    }
}