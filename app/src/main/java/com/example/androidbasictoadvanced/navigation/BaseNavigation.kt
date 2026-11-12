package com.example.androidbasictoadvanced.navigation

import android.net.Uri
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.androidbasictoadvanced.feature.aceleda.ScreenAceleda
import com.example.androidbasictoadvanced.feature.badge.ScreenBadge
import com.example.androidbasictoadvanced.feature.buttons.ScreenButtons
import com.example.androidbasictoadvanced.feature.buttonsheet.ScreenBottomSheet
import com.example.androidbasictoadvanced.feature.camera.ScreenCameraHardware
import com.example.androidbasictoadvanced.feature.camera.ScreenCameraPreview
import com.example.androidbasictoadvanced.feature.camera.ScreenImagePreview
import com.example.androidbasictoadvanced.feature.cards.ScreenCards
import com.example.androidbasictoadvanced.feature.checkBox.ScreenCheckBox2
import com.example.androidbasictoadvanced.feature.datepicker.ScreenDatePickerDialog
import com.example.androidbasictoadvanced.feature.datepicker.ScreenDatePickerWithRange
import com.example.androidbasictoadvanced.feature.dialog.ScreenDialog
import com.example.androidbasictoadvanced.feature.lazycolumn.ScreenLazyColumn
import com.example.androidbasictoadvanced.feature.mediapicker.ScreenPickerMultiPhotos
import com.example.androidbasictoadvanced.feature.mediapicker.ScreenPickerMultiVideos
import com.example.androidbasictoadvanced.feature.mediapicker.ScreenPickerPhotoAndVideo
import com.example.androidbasictoadvanced.feature.mediapicker.ScreenPickerSinglePhoto
import com.example.androidbasictoadvanced.feature.mediapicker.ScreenPickerSingleVideo
import com.example.androidbasictoadvanced.feature.menu.ScreenMenu
import com.example.androidbasictoadvanced.feature.navigationbar.ScreenBottomNavigationBar
import com.example.androidbasictoadvanced.feature.navigationdrawer.ScreenNavigationDrawer
import com.example.androidbasictoadvanced.feature.progressindicator.ScreenProgressIndicator
import com.example.androidbasictoadvanced.feature.radio.ScreenRadioButton2
import com.example.androidbasictoadvanced.feature.scaffold.ScreenScaffold
import com.example.androidbasictoadvanced.feature.slider.ScreenSlider
import com.example.androidbasictoadvanced.feature.snackbar.ScreenSnackBar
import com.example.androidbasictoadvanced.feature.spacer.ScreenSpacer
import com.example.androidbasictoadvanced.feature.switchcomponent.ScreenSwitchComponent
import com.example.androidbasictoadvanced.feature.tab.ScreenTab2
import com.example.androidbasictoadvanced.feature.textfield.ScreenTextField2
import com.example.androidbasictoadvanced.feature.timepicker.ScreenTimePicker
import com.example.androidbasictoadvanced.feature.toolbar.ScreenToolbar6
import com.example.androidbasictoadvanced.feature.tooltip.ScreenTooltip
import com.example.androidbasictoadvanced.feature.viewmodel.PostScreen
import com.example.androidbasictoadvanced.feature.viewmodel.PostVM
import com.example.androidbasictoadvanced.practice.screenUI.ScreenAppService
import com.example.androidbasictoadvanced.practice.screenUI.ScreenGrocery
import com.example.androidbasictoadvanced.practice.screenUI.ScreenKBPRASACBank
import com.example.androidbasictoadvanced.practice.screenUI.ScreenOrderFood
import com.example.androidbasictoadvanced.practice.screenUI.ScreenSpacerDemo
import com.example.androidbasictoadvanced.practice.screenUI.ScreenWingBank
import com.example.androidbasictoadvanced.testing.ScreenCollectAsState
import com.example.androidbasictoadvanced.testing.ScreenCollectAsStateWithLifeCycle

sealed interface Screen {
    data object Home : Screen
    data object Badge : Screen
    data object Buttons : Screen
    data object BottomSheet : Screen
    data object Cards : Screen
    data object Carousel : Screen
    data object CheckBox : Screen
    data object DatePicker : Screen
    data object DatePickerWithRange : Screen
    data object Dialog : Screen
    data object LazyRow : Screen
    data object LazyColumn : Screen
    data object Menu : Screen
    data object NavigationBar : Screen
    data object NavigationDrawer : Screen
    data object ProgressIndicator : Screen
    data object Radio : Screen
    data object Scaffold : Screen
    data object Slider : Screen
    data object Snackbar : Screen
    data object Spacer : Screen
    data object Switch : Screen
    data object Tab : Screen
    data object TextField : Screen
    data object TimePicker : Screen
    data object Toolbar : Screen
    data object Tooltip : Screen
    data object Aceleda : Screen
    data object Wing : Screen
    data object KBPrasac : Screen
    data object Service : Screen
    data object Messenger : Screen
    data object CollectAsState : Screen
    data object CollectAsStateWithLifecycle : Screen
    data object GetApi : Screen
    data object PickSinglePhoto : Screen
    data object PickMultiPhoto : Screen
    data object PickSingleVideo : Screen
    data object PickMultiVideos : Screen
    data object PickVideoAndPhoto : Screen
    data object Camera : Screen
    data object OpenCamera : Screen
    data class ImagePreview(
        val imageUri: Uri?
    ) : Screen

}

@Composable
fun BaseNavigation() {

    val backStack = remember {
        mutableStateListOf<Screen>(Screen.Home)
    }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { -it })
        },
        popTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(initialOffsetX = { -it }) togetherWith
                    slideOutHorizontally(targetOffsetX = { it })
        },
        entryProvider = { key ->

            when (key) {

                Screen.Home -> NavEntry(key) {
                    ScreenHome(
                        onClickComponent = { screen ->
                            backStack.add(screen)
                        }
                    )
                }

                Screen.Badge -> NavEntry(key) {
                    ScreenBadge(
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Buttons -> NavEntry(key) {
                    ScreenButtons(
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.ProgressIndicator -> NavEntry(key) {
                    ScreenProgressIndicator(
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.BottomSheet -> NavEntry(key) {
                    ScreenBottomSheet (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Cards -> NavEntry(key) {
                    ScreenCards (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Carousel -> NavEntry(key) {
                    ScreenOrderFood (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.CheckBox -> NavEntry(key) {
                    ScreenCheckBox2  (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.DatePicker -> NavEntry(key) {
                    ScreenDatePickerDialog  (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.DatePickerWithRange -> NavEntry(key) {
                    ScreenDatePickerWithRange   (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Dialog -> NavEntry(key) {
                    ScreenDialog (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.LazyRow -> NavEntry(key) {
                    ScreenGrocery  (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.LazyColumn -> NavEntry(key) {
                    ScreenLazyColumn (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Menu -> NavEntry(key) {
                    ScreenMenu (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.NavigationBar -> NavEntry(key) {
                    ScreenBottomNavigationBar (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.NavigationDrawer -> NavEntry(key) {
                    ScreenNavigationDrawer (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Radio -> NavEntry(key) {
                    ScreenRadioButton2 (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Scaffold -> NavEntry(key) {
                    ScreenScaffold (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Slider -> NavEntry(key) {
                    ScreenSlider (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Snackbar -> NavEntry(key) {
                    ScreenSnackBar (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Spacer -> NavEntry(key) {
                    ScreenSpacer (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Switch -> NavEntry(key) {
                    ScreenSwitchComponent (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Tab -> NavEntry(key) {
                    ScreenTab2 (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.TextField -> NavEntry(key) {
                    ScreenTextField2 (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.TimePicker -> NavEntry(key) {
                    ScreenTimePicker (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Toolbar -> NavEntry(key) {
                    ScreenToolbar6 (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Tooltip -> NavEntry(key) {
                    ScreenTooltip (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Aceleda -> NavEntry(key) {
                    ScreenAceleda  (
                        onBack = {
                            backStack.removeLastOrNull()
                        },

                        onNavigateToQrCode = {}
                    )
                }

                Screen.Wing -> NavEntry(key) {
                    ScreenWingBank (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.KBPrasac -> NavEntry(key) {
                    ScreenKBPRASACBank (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Service -> NavEntry(key) {
                    ScreenAppService (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Messenger -> NavEntry(key) {
                    ScreenSpacerDemo (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.CollectAsState -> NavEntry(key) {
                    ScreenCollectAsState()
                }

                Screen.CollectAsStateWithLifecycle -> NavEntry(key) {
                    ScreenCollectAsStateWithLifeCycle()
                }

                Screen.GetApi -> NavEntry(key) {
                    PostScreen (
                        viewModel = PostVM(),
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                Screen.PickSinglePhoto -> NavEntry(key) {
                    ScreenPickerSinglePhoto (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                Screen.PickMultiPhoto -> NavEntry(key) {
                    ScreenPickerMultiPhotos (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                Screen.PickSingleVideo -> NavEntry(key) {
                    ScreenPickerSingleVideo (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.PickMultiVideos -> NavEntry(key) {
                    ScreenPickerMultiVideos (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.PickVideoAndPhoto -> NavEntry(key) {
                    ScreenPickerPhotoAndVideo (
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

                Screen.Camera -> NavEntry(key) {
                    ScreenCameraHardware (
                        onBack = {
                            backStack.removeLastOrNull()
                        },

                        onOpenCamera = {
                            backStack.add(Screen.OpenCamera)
                        }
                    )
                }

                Screen.OpenCamera -> NavEntry(key) {
                    ScreenCameraPreview(
                        onBack = {
                            backStack.removeLastOrNull()
                        },

                        onPreview = { uri ->
                            backStack.add(Screen.ImagePreview(uri))
                        }
                    )
                }

                is Screen.ImagePreview -> NavEntry(key) {
                    ScreenImagePreview(
                        imageUri = key.imageUri,
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }

            }
        }
    )
}