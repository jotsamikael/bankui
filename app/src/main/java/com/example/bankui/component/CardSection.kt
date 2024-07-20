package com.example.bankui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankui.R
import com.example.bankui.data.Card
import com.example.bankui.ui.theme.PurpleEnd
import com.example.bankui.ui.theme.PurpleStart


val cards = listOf(
    Card(
        cardType = "MASTER CARD",
        accountType = "Saving",
        cardNumber = "4094 6003 5673 8937",
        cardHolderName = "JOTSA MIKAEL",
        balance = 980000.0,
        color = getGradient(PurpleStart, PurpleEnd),

        )
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardSection() {

    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPadding = 0.dp
    if (index == cards.size - 1) {
        lastItemPadding = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.accountType == "MASTER CARD") {
        var image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPadding)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = image,
                contentDescription = card.cardHolderName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardHolderName,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${card.balance}",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}