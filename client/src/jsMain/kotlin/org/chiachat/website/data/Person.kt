package org.chiachat.website.data

enum class Person(
    val fullName: String,
    val title: String,
    val description: String,
    val image: String,
    val link: String,
) {
    ANDREW(
        fullName = "Andrew Bueide",
        title = "Co-Founder",
        description = """
            As an experienced Kotlin Multiplatform Fullstack Developer, I'm looking forward to using my skills to 
            improve the tooling & user experience in the Chia ecosystem.
        """.trimIndent(),
        image = "images/team/andrew.jpg",
        link = "https://www.linkedin.com/in/andrewbueide/"
    ),
    MITCH(
        fullName = "Mitchell Clark",
        title = "Co-Founder & Chialisp Developer",
        description = "Placeholder",
        image = "images/team/mitch.jpg",
        link = "https://www.linkedin.com/in/cmitchellclark/"
    )
}
