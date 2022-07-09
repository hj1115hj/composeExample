package com.joocoding.android.app.composelayout.tc5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.joocoding.android.app.composelayout.ui.theme.ComposeLyaoutTheme
import androidx.compose.material.Button as Button

class MainActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLyaoutTheme {

            }
        }
    }
}

@Composable
fun ConstraintLayoutContent(){
    ConstraintLayout{
        //레퍼런스 가져오기
        val (button, text) = createRefs()

        Button(
            onClick = {},
            //button 레퍼런스를 Botton에 할당 할당
            modifier = Modifier.constrainAs(button){
                top.linkTo(parent.top, margin =16.dp)
            }
        ){
            Text("Button")
        }

        Text("Text", Modifier.constrainAs(text){
            top.linkTo(button.bottom, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
    }
}
@Composable
fun ConstraintLayoutContent2(){
    ConstraintLayout{
        //레퍼런스 가져오기
        val (button1, button2, text) = createRefs()

        Button(
            onClick = {},
            //button 레퍼런스를 Botton에 할당 할당
            modifier = Modifier.constrainAs(button1){
                top.linkTo(parent.top, margin =16.dp)
            }
        ){
            Text("Button 1")
        }

        Text("Text", Modifier.constrainAs(text){
            top.linkTo(button1.bottom, margin = 16.dp)
            //Text와 연결된 button1의 수직선을 Text를 중앙으로 button1.start 기준에 배치한다
            this.centerAround(button1.start)
        })
        //button1과 text 의 요소중 가장 끝쪽에 있는 요소를 barrier로 만든다.
        val barrier = createEndBarrier(button1,text)
        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button2){
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ){
            Text("Button 2")
        }
    }
}

@Composable
fun ConstraintLayoutContent3(){
    ConstraintLayout{
        val text = createRef()
        //ConstraintLayout 시작부터 특정 offset의 가이드 라인을 맞춘다
        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text("This is a very very very very very very very very very long text",
        Modifier.constrainAs(text){
            //start.linkTo(guideline.start)
            //end.linkTo(parent.end)
            linkTo(start = guideline, end = parent.end)
            //width = Dimension.preferredWrapContent //레이아웃이 이 측정기준의 제약 조건이 적용되는 랩 콘텐츠입니다.
            //width = Dimension.wrapContent //제약 조건을 허용하지 않는 wrapContent
            width = Dimension.preferredWrapContent.atLeast(100.dp)
        }
        )
    }
}

@Composable
fun ConstraintLayoutContent4(){

    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp)
        } else {
            decoupledConstraints(margin = 32.dp)
        }
        ConstraintLayout(constraints){
            Button(
                onClick = {},
                modifier = Modifier.layoutId("button")
            ){
                Text("Button")
            }
            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp) : ConstraintSet {
    return ConstraintSet{
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button){
            top.linkTo(parent.top , margin= margin)
        }
        constrain(text){
            top.linkTo(button.bottom, margin= margin)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeLyaoutTheme {
        ConstraintLayoutContent4()
    }
}