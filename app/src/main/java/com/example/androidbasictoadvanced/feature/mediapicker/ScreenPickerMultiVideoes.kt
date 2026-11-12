package com.example.androidbasictoadvanced.feature.mediapicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@Composable
fun ScreenPickerMultiVideos(
    onBack: () -> Unit
) {

    var videoUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }
    val pickMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickMultipleVisualMedia())
        { uris ->
            videoUris = uris
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
                        text = "Screen Picker Multi Videos"
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
                    pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {

                Text(
                    text = "Pick multi videos"
                )

            }
        }

    ) { paddingValues ->

        if (videoUris.isEmpty()) {

            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),

                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "No videos selected"
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),

                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(videoUris) { uri ->

                    VideoPlayer(
                        videoUri = uri
                    )
                }
            }
        }


    }
}

@Composable
fun VideoPlayer(
    videoUri: Uri
) {

    val context = LocalContext.current

    val exoPlayer = remember(videoUri) {

        ExoPlayer.Builder(context)
            .build()
            .apply {

                setMediaItem(
                    MediaItem.fromUri(videoUri)
                )

                prepare()

                playWhenReady = false
            }
    }

    DisposableEffect(exoPlayer) {

        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(

        factory = {
            PlayerView(it).apply {
                player = exoPlayer
            }
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    )
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenPickerMultiVideosPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenPickerMultiVideos(
            onBack = {}
        )
    }
}