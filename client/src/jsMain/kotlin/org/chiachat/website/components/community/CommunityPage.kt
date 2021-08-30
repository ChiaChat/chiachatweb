package org.chiachat.website.components.community

import androidx.compose.runtime.Composable
import org.chiachat.website.components.home.navBar
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun communityPage() {
    navBar()
    Div()
    Text("Community")
}
