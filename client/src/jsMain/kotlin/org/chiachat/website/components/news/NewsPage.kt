package org.chiachat.website.components.news

import androidx.compose.runtime.Composable
import org.chiachat.website.components.home.navBar
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun newsPage() {
    navBar()
    Div()
    Text("News")
}
