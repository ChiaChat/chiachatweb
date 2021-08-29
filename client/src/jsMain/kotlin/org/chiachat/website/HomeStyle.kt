package org.chiachat.website

import org.jetbrains.compose.web.css.*

object HomeStyle : StyleSheet() {
    val container by style { // container is a class
        display(DisplayStyle.Flex)
        padding(14.px, 16.px)
        // custom property (or not supported out of a box)
        property("font-family", "Arial, Helvetica, sans-serif")
        textAlign("center")
        color(Color.limegreen)
    }
}
