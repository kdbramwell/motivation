
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

private val photoUrls = listOf(
    "https://images.unsplash.com/photo-1686255865337-fba05bbe3098?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=987&q=80",
    "https://images.unsplash.com/photo-1686469797130-97ac2ae29c12?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=987&q=80",
    "https://images.unsplash.com/photo-1686850085303-63302b8b3625?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=987&q=80",
    "https://images.unsplash.com/photo-1686664219282-a1787f057706?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1035&q=80",
    "https://images.unsplash.com/photo-1685746631250-3af7218b51f0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1039&q=80",
    "https://images.unsplash.com/photo-1672243776895-7878f5180d25?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=987&q=80",
)

private val photoResources = listOf(
    "1.jpg",
    "2.jpg",
    "3.jpg",
    "4.jpg",
    "5.jpg",
    "6.jpg",
    "7.jpg",
    "8.jpg",
    "9.jpg",
    "10.jpg"
)

private val quotes = listOf(
    "I am capable of achieving great things.",
    "I embrace positivity and radiate joy.",
    "I am grateful for the opportunities that come my way.",
    "I am confident in my abilities and talents.",
    "I deserve love, happiness, and success.",
    "I am worthy of all the good things in life.",
    "I choose to let go of negativity and embrace positivity.",
    "I am surrounded by love and support.",
    "I have the power to create the life I desire.",
    "I am resilient and can overcome any challenge.",
    "I attract abundance and prosperity into my life.",
    "I am filled with confidence and self-belief.",
    "I am worthy of love and respect from myself and others.",
    "I am in control of my thoughts and emotions.",
    "I am grateful for my body and treat it with love and care.",
    "I am open to new possibilities and opportunities.",
    "I am blessed with unique gifts and talents.",
    "I am at peace with who I am and where I am in life.",
    "I choose to see the beauty and goodness in everything.",
    "I am capable of making a positive difference in the world."
)

interface MotivationQuote {
    val text: String
    val backgroundPhoto: String
    val isFavorite: Boolean
}

data class MotivationQuoteData(
    override val text: String = quotes.random(),
    override val backgroundPhoto: String = photoResources.random(),
    override val isFavorite: Boolean = false
) : MotivationQuote

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MotivationScreen(
    quote: MotivationQuote = MotivationQuoteData(),
    modifier: Modifier = Modifier,
    onFavoriteClick: (MotivationQuote) -> Unit = {},
    onShareClick: (MotivationQuote) -> Unit = {},
    onRandomClick: () -> Unit = {}
) {
    var motivationQuote by mutableStateOf(quote)

    Box(modifier.fillMaxSize().background(Color.White)) {
        Image(
            painter = painterResource(motivationQuote.backgroundPhoto),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = motivationQuote.text,
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
            IconButton(onClick = { onFavoriteClick(quote) }, modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorite")
            }

            IconButton(
                onClick = { motivationQuote = MotivationQuoteData() },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(Icons.Filled.Refresh, contentDescription = "Randomize")
            }

            IconButton(onClick = { onShareClick(quote) }, modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Filled.Share, contentDescription = "Share")
            }
        }
    }
}