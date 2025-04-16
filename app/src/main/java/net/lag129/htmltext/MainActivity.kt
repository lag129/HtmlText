package net.lag129.htmltext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.lag129.htmltext.ui.theme.MastodonTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MastodonTextTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    SelectionContainer {
        Column(
            modifier = modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val text = """
                <p>これは段落（pタグ）です。</p>
                <p>これは<a href="https://www.example.com">リンク</a>です。</p>
                <p>リストの例</p>
                <ul>
                    <li>りんご</li>
                    <li>ばなな</li>
                    <li>みかん</li>
                </ul>
                <p>番号付きリスト</p>
                <ol>
                    <li>ステップ1</li>
                    <li>ステップ2</li>
                    <li>ステップ3</li>
                </ol>
            """.trimIndent()
            HtmlText(text)
        }
    }
}
