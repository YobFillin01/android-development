package com.example.androidbasictoadvanced.feature.menu



import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.ui.theme.Purple40


data class MenuItemModel(
    val text: String,
    val onClick: () -> Unit,
    val leadingIcon: Int? = null,
    val trailingIcon: Int? = null,
    val enabled: Boolean = true,
    val backgroundColor: Color? = null
)

val itemList1 = listOf(
    MenuItemModel(
        text = "Open",
        onClick = { println("You clicked open") },
        leadingIcon = R.drawable.ic_open,
    ),

    MenuItemModel(
        text = "Make a copy",
        onClick = { println("You clicked Make a copy") },
        leadingIcon = R.drawable.ic_share,
    ),

    MenuItemModel(
        text = "Create",
        onClick = { println("You clicked Create") },
        leadingIcon = R.drawable.ic_create,
        trailingIcon = R.drawable.ic_arrow_right
    ),

    MenuItemModel(
        text = "Offline mode",
        onClick = { println("You clicked Offline mode") },
        leadingIcon = R.drawable.ic_offline_mode,
    ),

    MenuItemModel(
        text = "Share",
        onClick = { println("You clicked Share") },
        leadingIcon = R.drawable.ic_share,
        trailingIcon = R.drawable.ic_arrow_right,
        backgroundColor = Purple40
    ),

    MenuItemModel(
        text = "Download",
        onClick = { println("You clicked Download") },
        leadingIcon = R.drawable.ic_download,
        trailingIcon = R.drawable.ic_arrow_right
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMenu(
    onBack: () -> Unit
) {

    val context = LocalContext.current

    var expand by remember { mutableStateOf(false) }

    val items = itemList1

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Screen Menu"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {

                            expand = true

                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = "More vert",
                            tint = Color(0xFF34195D)
                        )
                    }

                    DropdownMenu(
                        expanded = expand,

                        onDismissRequest = {
                            expand = false
                        },

                    ) {

                        items.forEach { item ->

                            DropdownMenuItem(

                                modifier = Modifier
                                    .background(
                                        color = item.backgroundColor ?: MaterialTheme.colorScheme.background
                                    ),

                                text = {
                                    Text(
                                        text = item.text
                                    )
                                },
                                onClick = {
                                    item.onClick.invoke()
                                    expand = false

                                    val toast = Toast.makeText(context, "You click ${item.text}",Toast.LENGTH_SHORT)
                                    toast.show()
                                },

                                leadingIcon = {
                                    if (item.leadingIcon != null) {
                                        Icon(
                                            painter = painterResource(item.leadingIcon),
                                            contentDescription = null
                                        )
                                    }
                                },

                                trailingIcon = {
                                    if (item.trailingIcon != null) {
                                        Icon(
                                            painter = painterResource(item.trailingIcon),
                                            contentDescription = null
                                        )
                                    }
                                },

                                interactionSource = remember { MutableInteractionSource() }
                            )
                        }
                    }
                }
            )
        }

    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenMenuPreview() {
    AndroidBasicToAdvancedTheme() {
        ScreenMenu {}
    }
}