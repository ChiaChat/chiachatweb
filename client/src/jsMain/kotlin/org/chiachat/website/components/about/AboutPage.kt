package org.chiachat.website.components.about

import androidx.compose.runtime.Composable
import org.chiachat.website.components.home.navBar
import org.chiachat.website.data.Person
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun aboutPage() {
    navBar()
    Div()
    landing()
    Div()
}

@Composable
fun landing() {
    Text("Meet the team")
    Div()
    team()
}

@Composable
fun team() {
    Div {
        Person.values().map { personCard(it) }
    }
}

@Composable
fun personCard(person: Person) {
    Text(person.fullName)
    Div()
    imageButton(person.image, person.link)
    Div()
}

@Composable
fun imageButton(image: String, navLink: String) {
    A(navLink) {
        Img(
            src = image,
            attrs = {
                style {
                    width(64.px)
                    height(64.px)
                }
            }
        )
    }
}
