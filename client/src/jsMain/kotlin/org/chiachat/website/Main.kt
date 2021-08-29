package org.chiachat.website

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.BrowserRouter
import app.softwork.routingcompose.NavLink
import org.jetbrains.compose.web.css.selectors.className
import org.jetbrains.compose.web.renderComposable
import io.ktor.client.*
import io.ktor.client.engine.js.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Inline
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*


fun main() {
    renderComposable(rootElementId = "root") {
        mainPage()
    }
}

@Composable
fun mainPage(){
    BrowserRouter(initRoute = "/") {
        route("news"){
            noMatch {
                Text("news")
            }
        }
        route("roadmap"){
            noMatch {
                Text("roadmap")
            }
        }
        route("community"){
            noMatch {
                Text("community")
            }
        }
        route("about"){
            noMatch {
                Text("about")
            }
        }
        noMatch {
            homePage()
        }
    }
}

@Composable
fun homePage() {
    navBar()
    Div {  }
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
    Div(
        attrs = {
            className("navigationBar")
            style {
                overflow("hidden")
                width(auto)
                display(Inline)
            }
        }
    ) {
        for(i in 0 until links.size / 2) {
            val link = links[i]
            navButton(link, "/" + link.lowercase())
        }
        imageButton("https://ipfs.io/ipfs/QmTZjgAYtWmK4b7xSg3gVz9DwCM18eVUmKRSU9priQx5v2?filename=ChiaChat_Icon_2.jpeg")
        for(i in links.size / 2 until links.size ) {
            val link = links[i]
            navButton(link, "/" + link.lowercase())
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
    NavLink("/about") {
        Img(src = src, attrs = {
            attr("href", "about")
            style {
                width(64.px)
                width(64.px)
            }
        })
    }
}