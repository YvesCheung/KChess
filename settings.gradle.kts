rootProject.name = "KChess"

includeCommonProject(
    "algorithm",
    "algorithm-chinesechess",
    "cli-jvm"
)

fun includeCommonProject(vararg projectNames: String) {
    projectNames.forEach { name ->
        include(":$name")
        project(":$name").projectDir = file("Common/$name")
    }
}

