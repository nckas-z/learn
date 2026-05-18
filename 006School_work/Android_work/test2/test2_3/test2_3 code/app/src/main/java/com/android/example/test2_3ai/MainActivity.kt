package com.android.example.test2_3ai

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.example.test2_3ai.ui.theme.Test2_3AITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2_3AITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var modelName by remember { mutableStateOf("MobileNet") }
    var result by remember { mutableStateOf("Cat") }
    var confidence by remember { mutableStateOf("96.2%") }
    var inferenceTime by remember { mutableStateOf("28 ms") }

    Column(
        modifier=Modifier.fillMaxSize()
    ){

        //大图像
        CameraPreviewArea(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        ResultCard(
            modelName = modelName,
            result = result,
            confidence = confidence,
            inferenceTime = inferenceTime,
            modifier = Modifier.fillMaxWidth()
        )

        ButtonSection(onTakePhoto = {}, onPickAlbum = {}, onSwitchModel = {}, onClear = {},modifier = Modifier.fillMaxWidth())
    }
}



@Composable
fun CameraPreviewArea(modifier: Modifier){
    Box(
        modifier=modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = "相机预览区域", style = MaterialTheme.typography.headlineSmall)
    }
}



@Composable
fun ResultCard(
    modelName: String,
    result:String,
    confidence:String,
    inferenceTime:String,
    modifier: Modifier
){
    Card(
        modifier=modifier.padding(16.dp),
        shape = RoundedCornerShape(12.dp)
   ){
        Column(
            modifier= Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Model: $modelName",style = MaterialTheme.typography.bodyLarge)
            Text("Result: $result",style = MaterialTheme.typography.bodyLarge)
            Text("Confidence: $confidence",style = MaterialTheme.typography.bodyLarge)
            Text("Time: $inferenceTime",style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun ButtonSection(
    onTakePhoto:()->Unit,
    onPickAlbum: () -> Unit,
    onSwitchModel: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier

){
    Column(
        modifier=modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = onSwitchModel){
                Text("拍照识别")
            }
            Button(onClick = onSwitchModel){
                Text("相册导入")
            }
            }

        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = onSwitchModel){
                Text("切换模型")
            }
            Button(onClick = onSwitchModel){
                Text("清空结果")
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Test2_3AITheme {
        Greeting("Android")
    }
}





