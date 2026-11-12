package com.example.androidbasictoadvanced.feature.viewmodel

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.data.model.Post


@Suppress("ParamsComparedByRef")
@Composable
fun PostScreen(
    viewModel: PostVM,
    onBack: () -> Unit = {}
) {

    val posts by viewModel.posts

    var postId by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
//    var userId by remember { mutableStateOf("1") }


    Scaffold(

        topBar = {
            TopAppBar(

                title = {
                    Text(
                        text = "REST API Methods"
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),

                navigationIcon = {

                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {

                        Icon(
                            painter = painterResource(
                                R.drawable.ic_arrow_back
                            ),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {


            // POST ID

            OutlinedTextField(

                value = postId,

                onValueChange = { id ->
                    postId = id
                },

                label = {
                    Text("Post ID")
                },

                modifier = Modifier.fillMaxWidth()
            )


            // TITLE

            OutlinedTextField(

                value = title,

                onValueChange = { titles ->
                    title = titles
                },

                label = {
                    Text("Title")
                },

                modifier = Modifier.fillMaxWidth()
            )


            // BODY

            OutlinedTextField(

                value = body,

                onValueChange = {
                    body = it
                },

                label = {
                    Text("Body")
                },

                modifier = Modifier.fillMaxWidth()


            )


//             USER ID

//            OutlinedTextField(
//
//                value = userId,
//
//                onValueChange = {
//                    userId = it
//                },
//
//                label = {
//                    Text("User ID")
//                },
//
//                modifier = Modifier.fillMaxWidth(),
//
//                enabled = true
//            )


            // GET

//            Row(
//
//                modifier = Modifier.fillMaxWidth(),
//
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//
//                Button(
//
//                    onClick = {
//                        viewModel.fetchPosts()
//                    },
//
//                    modifier = Modifier.weight(1f)
//                ) {
//                    Text("GET All")
//                }
//
//
//                Button(
//
//                    onClick = {
//
//                        val id = postId.toIntOrNull()
//
//                        if (id != null) {
//                            viewModel.fetchPost(id)
//                        }
//
//                    },
//
//                    modifier = Modifier.weight(1f)
//                ) {
//
//                    Text("GET One")
//                }
//            }


            // POST

            Button(

                onClick = {

                    val id = postId.toIntOrNull()

                    if (id != null) {

                        viewModel.createPost(
                            title = title,
                            body = body,
                            postId = id
                        )
                    }

                    title = ""
                    body = ""
                    postId = ""
                },

                modifier = Modifier.fillMaxWidth(),

                border = BorderStroke(width = 1.dp, color = Color(0xFFF200FF)),

                shape = RoundedCornerShape(24.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF200FF).copy(alpha = 0.2f),
                    contentColor = Color.Black
                )
            ) {

                Text("Create")
            }


            // PUT

            Button(

                onClick = {

                    val id = postId.toIntOrNull()
//                    val user = userId.toIntOrNull()

                    if (id != null) {

                        viewModel.updatePost(
                            postId = id,
                            title = title,
                            body = body,
//                            userId = user
                        )

                    }
                    title = ""
                    body = ""
                    postId = ""

                },

                modifier = Modifier.fillMaxWidth(),

                border = BorderStroke(width = 1.dp, color = Color.Green),

                shape = RoundedCornerShape(24.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green.copy(alpha = 0.2f),
                    contentColor = Color.Black
                )
            ) {

                Text("PUT - Replace")
            }


            // PATCH

            Button(

                onClick = {

                    val id = postId.toIntOrNull()

                    if (id != null) {

                        viewModel.patchPost(
                            postId = id,
                            title = title
                        )
                    }

                    title = ""
                    postId = ""

                },

                modifier = Modifier
                    .fillMaxWidth(),

                border = BorderStroke(width = 1.dp, color = Color.Blue),

                shape = RoundedCornerShape(24.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue.copy(alpha = 0.2f),
                    contentColor = Color.Black
                )
            ) {

                Text("PATCH - Update Title")
            }


            // DELETE

            OutlinedButton(

                onClick = {

                    val id = postId.toIntOrNull()

                    if (id != null) {

                        viewModel.deletePost(id)
                    }

                    postId = ""

                },

                modifier = Modifier.fillMaxWidth(),

                border = BorderStroke(width = 1.dp, color = Color.Red),

                shape = RoundedCornerShape(24.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red.copy(alpha = 0.2f),
                    contentColor = Color.Black
                )
            ) {

                Text("DELETE")

            }
            // DISPLAY POSTS

            if (posts.isEmpty()) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),

                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }

            } else {

                LazyColumn(

                    modifier = Modifier.weight(1f),

                    contentPadding = PaddingValues(
                        vertical = 8.dp
                    ),

                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(posts) { post ->

                        PostCard(post)
                    }
                }
            }
        }
    }
}


@Composable
fun PostCard(post: Post) {

    ElevatedCard(

        modifier = Modifier.fillMaxWidth(),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(

            modifier = Modifier.padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = "Post #${post.id}",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = post.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = post.body,
                color = Color.Gray
            )
        }
    }
}

