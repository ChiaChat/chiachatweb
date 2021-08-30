package org.chiachat.website.components.roadmap

import androidx.compose.runtime.Composable
import org.chiachat.website.components.home.navBar
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun roadmapPage() {
    RoadmapStyle.container
    navBar()
    Div()
    Text("Roadmap")
}
