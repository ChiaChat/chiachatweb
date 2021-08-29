package org.chiachat.website

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.selectors.className
import org.jetbrains.compose.web.renderComposable
import io.ktor.client.*
import io.ktor.client.engine.js.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.Image


fun main() {

    val client = HttpClient(Js)
    renderComposable(rootElementId = "root") {
        Style(HomeStyle)
        navBar(client)
    }
}

@Composable
fun navBar(client: HttpClient) = run {
    Div(
        attrs = {
            className("navigationBar")
        }
    ) {
        navButton("About Us", "test")
        imageButton("https://ipfs.io/ipfs/QmTZjgAYtWmK4b7xSg3gVz9DwCM18eVUmKRSU9priQx5v2?filename=ChiaChat_Icon_2.jpeg")
    }
}

@Composable
fun navButton(text: String, route: String){
    Button(attrs = {
    }){
        Text(text)
    }
}

@Composable
fun imageButton(src: String){
    Img(src){
        onClick {
            println("Test")
        }
    }
}