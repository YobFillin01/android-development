package com.example.androidbasictoadvanced.feature.mediapicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenPickerMultiPhotos(
    onBack:() -> Unit
) {

    val (imageUris, setImageUris) = remember { mutableStateOf<List<Uri?>>(emptyList()) }
    // Registers a photo picker activity launcher in single-select mode.
    val pickMedia = rememberLauncherForActivityResult(
        PickMultipleVisualMedia(5)) { uris ->
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (uris.isNotEmpty()) {
                print(" =====> Selected URI: $uris")
                setImageUris(uris)
            } else {
                print(" =====> No media selected")
            }
        }


    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color(0xFF34195D)
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = "more vert",
                            tint = Color(0xFF34195D)
                        )
                    }
                },

                title = {
                    Text(
                        text = "Screen Picker Multi Photos"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                )
        },

        bottomBar = {
            Button(
                onClick = {
                    // Launch the photo picker and let the user choose only images.
                    pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {

                Text(
                    text = "Pick multi photos"
                )

            }
        }

    ) {paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if (imageUris.isNotEmpty()) {

                items(imageUris.size) { index->

                    val mediaUri = imageUris[index]

                    Box(
                        modifier = Modifier
                            .size(256.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!imageUris.isEmpty()) {
                            AsyncImage(
                                model = mediaUri,
                                contentDescription = "Select Image"
                            )
                        }
                    }
                }
            }

        }

    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenPickerMultiPhotosPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenPickerMultiPhotos (
            onBack = {}
        )
    }
}