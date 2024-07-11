package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    QuadrantArrangement()
                }
            }
        }
    }
}

@Composable
fun QuadrantArrangement(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Quadrant(
                title = stringResource(R.string.text_composable),
                text = stringResource(R.string.displays_text),
                bgColor = Color(0xFFEADDFF),
                modifier = modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.image_composable),
                text = stringResource(R.string.creates_a_composable),
                bgColor = Color(0xFFD0BCFF),
                modifier = modifier.weight(1f)
            )
        }

        Row(
            modifier = modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Quadrant(
                title = stringResource(R.string.row_composable),
                text = stringResource(R.string.horizontal_sequence),
                bgColor = Color(0xFFB69DF8),
                modifier = modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.column_composable),
                text = stringResource(R.string.layout_composable),
                bgColor = Color(0xFFF6EDFF),
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(title: String, text: String, bgColor: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp)

    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        QuadrantArrangement()
    }
}