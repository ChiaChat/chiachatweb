package org.chiachat.website.components.home

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.NavLink
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.selectors.className
import org.jetbrains.compose.web.dom.*


@Composable
fun homePage() {
    HomeStyle.container
    navBar()
    Div()
    landing()
}

@Composable
fun landing() {
    Text("Welcome to ChiaChat!")
}

@Composable
fun navBar() {
    val links = listOf("News", "Roadmap", "Community", "About")
    Style(HomeStyle)
    Ul(
        attrs = {
            className("navigationBar")
            style {
                overflow("hidden")
                width(auto)
                display(DisplayStyle.Inline)
            }
        }
    ) {
        for(i in 0 until links.size / 2) {
            val link = links[i]
            Li {
                navButton(link, "/" + link.lowercase())
            }
        }
        Li {
            imageButton("images/cc_icon_trans.png")
        }
        for(i in links.size / 2 until links.size ) {
            val link = links[i]
            Li {
                navButton(link, "/" + link.lowercase())
            }
        }
    }
}

@Composable
fun navButton(text: String, route: String){
    NavLink(route) {
        Text(text)
    }
}

@Composable
fun imageButton(src: String){
    NavLink("/") {
        Img(src = src, attrs = { classes(HomeStyle.logo)})
    }
}