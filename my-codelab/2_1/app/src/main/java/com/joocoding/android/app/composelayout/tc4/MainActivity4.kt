package com.joocoding.android.app.composelayout.tc4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joocoding.android.app.composelayout.ui.theme.ComposeLyaoutTheme

private val TAG = "MainActivity4"
class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLyaoutTheme {
                ComposeLyaoutTheme {
                    Text("Hi there!", Modifier.firstBaselineToTop2(32.dp))
                }
            }
        }
    }
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable :Placeable = measurable.measure(constraints) //182, 62

        // Check the composable has a first baseline
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline] //49

        // Height of the composable with padding - first baseline
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline //32 - 49 = -17
        val height = placeable.height + placeableY //62 + -17 = 45
        layout(placeable.width, height) {
            // Where the composable gets placed
            placeable.placeRelative(0, placeableY)
        }
    }
)

fun Modifier.firstBaselineToTop2(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable :Placeable = measurable.measure(constraints)

        // Check the composable has a first baseline
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]
        Log.i(TAG, "firstBaselineToTop2: $firstBaseline, ${placeable.width}, ${placeable.height}") //49 182 62
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline //94-49 = 35
        val height = placeable.height + placeableY // 62+35 = 97
        Log.i(TAG, "firstBaselineToTop2: $placeableY, $height")//35 97

        layout(placeable.width, height) { //182, 97
            // Where the composable gets placed
            placeable.placeRelative(0, placeableY) //35
        }
    }
)

@Preview
@Composable
fun TextWithPaddingToBaseLinePreview(){
    ComposeLyaoutTheme{
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeLyaoutTheme {
        Text("Hi there!", Modifier.firstBaselineToTop2(32.dp))
    }
}

