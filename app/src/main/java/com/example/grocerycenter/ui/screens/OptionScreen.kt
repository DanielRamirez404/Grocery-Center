package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.grocerycenter.R
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun Option(
  title: String,
  subtitle: String,
  iconId: Int? = null,
  modifier: Modifier = Modifier
    .background(color = Color(0xFFF7f7f0))
    .clickable {

    }
) {
  Column (
    modifier = modifier
      .padding(start = Padding.medium + Padding.small, top = Padding.medium, bottom = Padding.medium)
      .fillMaxWidth()
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = modifier
    ) {
      if (iconId != null) {
        Icon(
          painter = painterResource(id = iconId),
          contentDescription = null,
          tint = Color.DarkGray.copy(alpha = 0.5f),
          modifier = modifier
            .padding(end = Padding.small)
            .height(20.dp)
        )
      }
      Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
        color = Color.DarkGray.copy(alpha = 0.5f),
        modifier = modifier
      )
    }
    Text(
      text = subtitle,
      style = MaterialTheme.typography.bodySmall,
      fontWeight = FontWeight.SemiBold,
      color = Color.DarkGray.copy(alpha = 0.3f),
      modifier = modifier
    )
  }
  Divider(color = Color.DarkGray.copy(alpha = 0.25f), thickness = 1.dp)
}

@Composable
fun OptionsScreen() {
  Column(

  ) {
    Divider(color = Color.DarkGray.copy(alpha = 0.25f), thickness = 1.dp)
    Option(
      title = "Language",
      subtitle = "English",
      iconId = R.drawable.globe_solid
    )
    Option(
      title = "Info",
      subtitle = "About the app",
      iconId = R.drawable.circle_info_solid
    )
  }

}