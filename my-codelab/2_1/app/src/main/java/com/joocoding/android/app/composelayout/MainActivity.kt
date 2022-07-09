package com.joocoding.android.app.composelayout
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joocoding.android.app.composelayout.ui.theme.ComposeLyaoutTheme

class SpacingModifier(val space: Dp) : Modifier.Element

fun Modifier.innerSpacing(space: Dp) = this.then(SpacingModifier(space))

//custom modifire
//https://fvilarino.medium.com/creating-a-custom-modifier-attribute-on-jetpack-compose-f100c6bcb987
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PhotographerCard()
        }
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    ComposeLyaoutTheme {
        Row(
            modifier
                .innerSpacing(30.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable(onClick = { /* Ignoring onClick */ })

      ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                //Image goes here
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Alfred Sisley", fontWeight = FontWeight.Bold)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("3 minuted ago", style = MaterialTheme.typography.body2)

                }
            }
        }

    }
}

@Composable
fun slot(){
    ComposeLyaoutTheme {
        TopAppBar(
            title = {
                Text(text = "Page title", maxLines = 2)
            },
            navigationIcon = {
                //Icon(myNavIcon)
            }
        )
    }
}
@Preview(name ="my_test")
@Composable
fun MyTestPreview(){
    ComposeLyaoutTheme {
        slot()
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLyaoutTheme {
        PhotographerCard()
    }
}