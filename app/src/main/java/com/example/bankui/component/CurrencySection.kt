package com.example.bankui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyFranc
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankui.data.Currency
import com.example.bankui.ui.theme.GreenStart

val currencyList = listOf(
    Currency(
        name = "USD",
        buy = 24.4f,
        sell = 25.9f,
        icon = Icons.Rounded.AttachMoney,
    ),
    Currency(
        name = "EUR",
        buy = 22.4f,
        sell = 28.0f,
        icon = Icons.Rounded.Euro,
    ),
    Currency(
        name = "YEN",
        buy = 20.4f,
        sell = 21.9f,
        icon = Icons.Rounded.CurrencyYen,
    ),
    Currency(
        name = "GBP",
        buy = 29.4f,
        sell = 35.9f,
        icon = Icons.Rounded.CurrencyPound,
    ),
    Currency(
        name = "XAF",
        buy = 09.4f,
        sell = 11.9f,
        icon = Icons.Rounded.CurrencyFranc,
    ),
)


@Composable
fun CurrencySection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ) {


        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize { initialValue, targetValue -> }
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        if (isVisible) {
                            iconState = Icons.Rounded.KeyboardArrowUp
                        } else {
                            iconState = Icons.Rounded.KeyboardArrowDown
                        }
                    }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = "Currencies",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )

                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .background(MaterialTheme.colorScheme.background)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {


                            Text(
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.width(width),
                                textAlign = TextAlign.End
                            )

                            Text(
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.width(width),
                                textAlign = TextAlign.End
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(currencyList.size) { index ->
                                CurrencyItem(index, width)
                            }
                        }
                    }
                }
            }
        }

    }

}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currencyList[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically) {


            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {

                Icon(
                    imageVector = currency.icon, contentDescription = currency.name,
                    modifier = Modifier.size(18.dp),
                    tint = Color.White
                )
            }

            Text(
                text = currency.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .width(width)
                    .padding(start = 10.dp),
                textAlign = TextAlign.End
            )
        }
        Text(
            text = "$ ${currency.buy}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
        )
        Text(
            text = "$ ${currency.sell}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
        )

    }
}


