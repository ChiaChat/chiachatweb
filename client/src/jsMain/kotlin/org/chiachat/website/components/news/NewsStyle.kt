package org.chiachat.website.components.news

import org.jetbrains.compose.web.css.*

object NewsStyle : StyleSheet() {
    init {
        ".logo" style {
            width(64.px)
            width(64.px)
        }
    }
    val container by style { // container is a class
        display(DisplayStyle.Flex)
        padding(14.px, 16.px)
        // custom property (or not supported out of a box)
        property("font-family", "Arial, Helvetica, sans-serif")
        textAlign("center")
        color(Color.limegreen)
    }

    val logo by style {
        width(64.px)
        width(64.px)
    }
}
