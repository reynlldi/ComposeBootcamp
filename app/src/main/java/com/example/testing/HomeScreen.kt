package com.example.testing

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Slider
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // snackBar
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Home Screen")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "icon menu"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notification"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "favorite"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        val result = snackBarHostState.showSnackbar(
                            message = "Hallo semuanya!",
                            actionLabel = "Undo",
                            duration = SnackbarDuration.Short
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {}
                            SnackbarResult.Dismissed -> {}
                        }
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "icon add")
            }
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "icon edit")
                    }
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        HomeScreenContent(modifier = Modifier.padding(paddingValues))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    // expand text
    var expanded by remember { mutableStateOf(false) }

    // dialog alert
    var showDialog by remember { mutableStateOf(false) }

    // modal bottom sheet
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    // slider
    var slider by remember { mutableFloatStateOf(0f) }
    var sliderRange by remember { mutableStateOf(0f..100f) }

    // switch button
    var switch by remember { mutableStateOf(false) }

    // Checkbox
    var checked by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.albert),
                    contentDescription = "foto albert einstein",
                    modifier = Modifier
                        .border(2.dp, Color.Blue, CircleShape)
                        .size(60.dp)
                        .clip(CircleShape)
                        .clickable {
                            expanded = !expanded
                        }
                        .alpha(0.9f),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "icon check",
                    modifier = Modifier.align(Alignment.BottomEnd),
                    tint = Color.Blue
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Albert Einstein")
                Text(
                    text = "2 Years Ago",
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 8.sp
                )
                if (expanded) {
                    Text(text = "Pernah tinggal di batam")
                }
            }
        }

        // alert dialog
        Button(
            onClick = { showDialog = true },
            shape = CircleShape
        ) {
            Text(text = "Alert Dialog")
        }
        if (showDialog) {
            ExampleDialog(
                onCancel = { showDialog = false },
                onConfirm = { showDialog = false },
                onDismiss = { showDialog = false }
            )
        }

        // button bottom sheet
        FilledTonalButton(onClick = { showBottomSheet = true }) {
            Text(text = "Show Bottom Modal Sheet")
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            ) {
                Text(
                    text = "ini Bottom modal sheet",
                    modifier = Modifier.padding(bottom = 80.dp)
                )
            }
        }

        // card
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            Text(
                text = "Ini card default",
                modifier = Modifier.padding(8.dp)
            )
        }

        OutlinedCard(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            Text(
                text = "Ini card outlined",
                modifier = Modifier.padding(8.dp)
            )
        }

        // slider biasa
        Slider(
            value = slider,
            onValueChange = { slider = it },
            steps = 20, // kasih gapnya
            valueRange = 0f..100f
        )

        // slider range
        RangeSlider(
            value = sliderRange,
            onValueChange = { sliderRange = it },
            steps = 20, // kasih gapnya
            valueRange = 0f..100f
        )

        // loading circle
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary
        )

        // loading horizontal
        LinearProgressIndicator()

        // switch button
        Switch(
            checked = switch,
            onCheckedChange = {
                switch = it
            },
            thumbContent = {
                if (switch) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "icon check")
                }
            }
        )

        // Divider (garis)
        Divider(
            thickness = 2.dp
        )

        // Checkbox
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        // badge
        BadgedBox(
            badge = {
                Badge()
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email"
            )
        }
    }
}

@Composable
fun ExampleDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    AlertDialog(
        icon = {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "icon delete")
        },
        title = { Text(text = "HAPUS") },
        text = { Text(text = "Apakah yakin mau hapus data?") },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Hapus")
            }
        },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text(text = "Batal")
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}