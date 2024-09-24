package com.example.jetpackconstraintui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackconstraintui.ui.theme.JetpackConstraintUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackConstraintUITheme {
                ConstraintUI()
            }
        }
    }
}


@Preview
@Composable
fun ConstraintUI() {
    ConstraintLayout(Modifier.fillMaxSize().background(Color.White)) {

        val (one,two,three,four) = createRefs()

        Button( onClick = {},Modifier.constrainAs(one){
            top.linkTo(parent.top,25.dp)
            bottom.linkTo(parent.bottom,25.dp)
            start.linkTo(parent.start,25.dp)
            end.linkTo(parent.end,25.dp)
        }) {
            Text("first")
        }

        Button( onClick = {},Modifier.constrainAs(two){
            top.linkTo(parent.top,25.dp)
            start.linkTo(one.start,25.dp)
            end.linkTo(parent.end,65.dp)
            bottom.linkTo(parent.bottom,25.dp)
        }) {
            Text("Second")
        }

        Button( onClick = {},Modifier.constrainAs(three){
            top.linkTo(one.bottom,25.dp)
            start.linkTo(one.start)
            end.linkTo(one.end)
        }) {
            Text("Third")
        }


        Button( onClick = {},Modifier.constrainAs(four){
            top.linkTo(two.bottom,25.dp)
            start.linkTo(two.start)
            end.linkTo(two.end)
        }) {
            Text("Four")
        }



    }
}