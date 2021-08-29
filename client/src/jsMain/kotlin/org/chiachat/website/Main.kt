package org.chiachat.website

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.BrowserRouter
import org.chiachat.website.components.about.aboutPage
import org.chiachat.website.components.community.communityPage
import org.jetbrains.compose.web.renderComposable
import org.chiachat.website.components.home.homePage
import org.chiachat.website.components.news.newsPage
import org.chiachat.website.components.roadmap.roadmapPage
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
                newsPage()
            }
        }
        route("roadmap"){
            noMatch {
                roadmapPage()
            }
        }
        route("community"){
            noMatch {
                communityPage()
            }
        }
        route("about"){
            noMatch {
                aboutPage()
            }
        }
        noMatch {
            homePage()
        }
    }
}

