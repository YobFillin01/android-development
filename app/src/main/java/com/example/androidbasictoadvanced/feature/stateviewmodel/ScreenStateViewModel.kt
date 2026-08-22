package com.example.androidbasictoadvanced.feature.stateviewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasictoadvanced.R
import com.example.androidbasictoadvanced.feature.model.UserModel
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenStateViewModel(
    onBack: () -> Unit,
    stateVM: StateVM = viewModel()
) {

    val userList by stateVM.userListUiState.collectAsStateWithLifecycle()
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var isShowedDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "State View Model",
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA47EDD),
                    titleContentColor = Color(0xFF34195D)
                ),

                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },

        floatingActionButton = {
            Button(
                onClick = {
                    isShowedDialog = true
                }
            ) {
                Text(
                    text = "Add"
                )
            }
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            items(userList.size) { index ->

                val user = userList[index]
                val (firstname, lastName) = user

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = "$firstname $lastName"
                    )

                    Button(
                        onClick = {
                            stateVM.delete(user)
                        },

                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "Delete"
                        )
                    }
                }

            }

        }

        if (isShowedDialog) {
            BasicAlertDialog(
                onDismissRequest = {},
            ) {

                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .background(
                            MaterialTheme.colorScheme.background,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    OutlinedTextField(
                        value = firstName,
                        onValueChange = { value ->
                            firstName = value
                        },
                        placeholder = {
                            Text("Enter your first name")
                        },
                        label = {
                            Text(
                                text = "First Name"
                            )
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = lastName,
                        onValueChange = { value ->
                            lastName = value
                        },
                        placeholder = {
                            Text("Enter your Last name")
                        },
                        label = {
                            Text(
                                text = "Last Name"
                            )
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        FilledTonalButton(
                            onClick = {
                                isShowedDialog = false
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = "Cancel"
                            )
                        }

                        Button(
                            onClick = {

                                stateVM.save(
                                    user = UserModel(
                                        firstName = firstName,
                                        lastName = lastName
                                    )
                                )

                                isShowedDialog = false
                            },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f),
                            enabled = firstName.isNotEmpty() && lastName.isNotEmpty()
                        ) {
                            Text(
                                text = "Add"
                            )
                        }
                    }

                }
            }
        }


    }

}

@Composable
@Preview(showBackground = true)
fun ScreenStateViewModelPreview() {
    AndroidBasicToAdvancedTheme {
        ScreenStateViewModel(
            onBack = {}
        )
    }
}