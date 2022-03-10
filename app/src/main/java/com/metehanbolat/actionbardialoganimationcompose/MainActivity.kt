package com.metehanbolat.actionbardialoganimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.metehanbolat.actionbardialoganimationcompose.ui.theme.ActionBarDialogAnimationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActionBarDialogAnimationComposeTheme {

            }
        }
    }
}
