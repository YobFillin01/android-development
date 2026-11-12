package com.example.androidbasictoadvanced.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Announcement
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.MenuOpen
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LinearScale
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SmartButton
import androidx.compose.material.icons.filled.Sms
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.VerticalAlignBottom
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material.icons.filled.ViewColumn
import androidx.compose.material.icons.filled.ViewWeek
import androidx.compose.material.icons.filled.Wifi
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
import com.example.androidbasictoadvanced.util.BaseUiState
import com.example.androidbasictoadvanced.util.LoadingUtil


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
    ComponentItem(
        "Date Picker with range",
        Screen.DatePickerWithRange,
        Icons.Default.CalendarMonth
    ),
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
    ComponentItem("Service", Screen.Service, Icons.Default.CleaningServices),
    ComponentItem("Messenger", Screen.Messenger, Icons.Default.Sms),
    ComponentItem("Collect As State", Screen.CollectAsState, Icons.Default.Info),
    ComponentItem("Collect As State With Lifecycle", Screen.CollectAsStateWithLifecycle, Icons.Default.Info),
    ComponentItem("Get API", Screen.GetApi, Icons.Default.Wifi),
    ComponentItem("Pick Single Photo", Screen.PickSinglePhoto, Icons.Default.PhoneAndroid),
    ComponentItem("Pick Multi Photos", Screen.PickMultiPhoto, Icons.Default.PhoneAndroid),
    ComponentItem("Pick Single Video", Screen.PickSingleVideo, Icons.Default.PhoneAndroid),
    ComponentItem("Pick Multi Videos", Screen.PickMultiVideos, Icons.Default.PhoneAndroid),
    ComponentItem("Pick Video and Photo", Screen.PickVideoAndPhoto, Icons.Default.PhoneAndroid),
    ComponentItem("Camera", Screen.Camera, Icons.Default.Camera),
)

@Composable
fun ScreenHome(
    onClickComponent: (Screen) -> Unit
) {

    val lifecycleOwner = LocalLifecycleOwner.current

    val homeVM: HomeVM = viewModel()

    val stateUiState by homeVM.stateUiState.collectAsStateWithLifecycle()


//    var triggerState by remember { mutableStateOf(false) }

//    LaunchedEffect(Unit) {
//        homeVM.fetchComponentList()
//    }

    LaunchedEffect(stateUiState) {
        when (val state = stateUiState) {
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }

            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
                println("====> Data: ${state.data}")
            }

            is BaseUiState.Failure -> {
                println("====> Code: ${state.code}")
                println("====> Message: ${state.message}")
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Exception -> {
                println("====> Throwable: ${state.throwable}")
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Empty -> {
                LoadingUtil.hideLoading()
            }

            else -> {}
        }
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

        when (stateUiState) {
            is BaseUiState.Success -> {

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
            else -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(vertical = 24.dp)
                        .fillMaxSize()
                ) {
                    items(100) {
                        Row {
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(32.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.LightGray.copy(alpha = 0.5f))
                            ) { }
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.LightGray.copy(alpha = 0.5f))
                            ) { }
                        }
                        HorizontalDivider()
                    }
                }
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