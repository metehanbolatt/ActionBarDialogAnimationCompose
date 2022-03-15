package com.metehanbolat.actionbardialoganimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.metehanbolat.actionbardialoganimationcompose.ui.theme.ActionBarDialogAnimationComposeTheme

class MainActivity : ComponentActivity() {

    private val isVisible = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActionBarDialogAnimationComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Actionbar Equivalent Banner",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Box {
                            AnimatedBanner(isVisible)

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Button(
                                    onClick = { isVisible.value = !isVisible.value },
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    Text(text = "Click Me!")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AnimatedBanner(isVisible: MutableState<Boolean>) {
    AnimatedVisibility(
        visible = isVisible.value,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Are you sure you want to delete item?",
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 12.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.End)
                ) {
                    TextButton(
                        onClick = { isVisible.value = false },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(text = "Yes")
                    }
                    TextButton(
                        onClick = { isVisible.value = false },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(text = "No")
                    }
                }
            }
        }
    }
}