package org.chiachat.website.components.home

import org.jetbrains.compose.web.css.*

object HomeStyle : StyleSheet() {
    val container by style { // container is a class
        width(80.percent)
        property("margin", "0 auto")
        backgroundColor(Color.darkgray)
    }

    val logo by style {
        width(64.px)
        width(64.px)
    }
}
