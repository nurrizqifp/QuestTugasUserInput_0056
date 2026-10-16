package com.example.questtugasuserinput_0056

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.questtugasuserinput_0056.ui.screen.BiodataScreen
import com.example.questtugasuserinput_0056.ui.theme.QuestTugasUserInput_0056Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestTugasUserInput_0056Theme {
                BiodataScreen()
            }
        }
    }
}