
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MotivationScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(Color.White)) {
        Image(
            painter = painterResource("1.jpg"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "I am capable of achieving great things.",
            modifier = Modifier.align(Alignment.Center),
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )

        Row(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorite")
            }

            IconButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Filled.Refresh, contentDescription = "Randomize")
            }

            IconButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Filled.Share, contentDescription = "Share")
            }
        }
    }
}