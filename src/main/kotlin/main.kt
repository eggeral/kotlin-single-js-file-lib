import kotlin.browser.window

@JsName("aLibFunction")
fun aLibFunction() {
    println("aLibFunction called")
    val helloWorld = window.document.createElement("p")
    helloWorld.textContent = "Hello World"
    window.document.body?.appendChild(helloWorld)
}
