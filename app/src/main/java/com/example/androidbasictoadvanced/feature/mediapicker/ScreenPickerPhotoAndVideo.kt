package com.example.androidbasictoadvanced.feature.mediapicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.AsyncImage
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip


@Composable
fun ScreenPickerPhotoAndVideo(
    onBack: () -> Unit
) {

    // Store selected photos and videos
    var mediaUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }

    // Photo and Video Picker
    val pickMedia = rememberLauncherForActivityResult(
        ActivityResultContracts.PickMultipleVisualMedia()
    ) { uris ->

        mediaUris = uris

        if (uris.isEmpty()) {
            return@rememberLauncherForActivityResult
        }

        for (uri in uris) {
            Log.d("MediaPicker", "=====> $uri")
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
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = "More",
                            tint = Color(0xFF34195D)
                        )
                    }
                },

                title = {
                    Text(
                        text = "Picker Photo & Video"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                )
            )
        },

        bottomBar = {
            Button(
                onClick = {

                    // Allow user to pick both photos and videos
                    pickMedia.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageAndVideo
                        )
                    )

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Text(
                    text = "Pick Photo & Video"
                )
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {

            items(mediaUris) { uri ->

                val context = LocalContext.current

                // Get MIME type of selected file
                val mimeType = remember(uri) {
                    context.contentResolver.getType(uri)
                }

                // Check if selected file is a video
                val isVideo = mimeType?.startsWith("video") == true

                if (isVideo) {

                    // =========================
                    // VIDEO
                    // =========================

                    val exoPlayer = remember(uri) {

                        ExoPlayer.Builder(context)
                            .build()
                            .apply {

                                setMediaItem(
                                    MediaItem.fromUri(uri)
                                )

                                prepare()

                                // Do not automatically play
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
                            .height(250.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )

                } else {

                    // =========================
                    // PHOTO
                    // =========================

                    AsyncImage(
                        model = uri,
                        contentDescription = "Selected photo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
@Preview(name = "Phone", device = Devices.PIXEL_9_PRO, showSystemUi = true)
fun ScreenPickerPhotoAndVideoPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenPickerPhotoAndVideo(
            onBack = {}
        )
    }
}