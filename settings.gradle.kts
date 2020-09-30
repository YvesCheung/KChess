rootProject.name = "kchess"

includeCommonProject(
    "algorithm",
    "algorithm-chinesechess",
    "algorithm-gobang",
    "cli-jvm"
)

fun includeCommonProject(vararg projectNames: String) {
    projectNames.forEach { name ->
        include(":$name")
        project(":$name").projectDir = file("Common/$name")
    }
}
