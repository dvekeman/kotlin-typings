package client

import history.History
import history.Location
import history.createBrowserHistory
import kotlin.browser.window

enum class AppType {
    HTML, SMARTCLIENT
}

/**
 * The main entry point.
 * This function is called by default if `main = "call"` in compileKotlin2Js (see build.gradle.kts)
 */
fun main() {

    val appType: AppType = AppType.SMARTCLIENT

    val history = setupHistory()

    when(appType){
        AppType.HTML -> client.html.main(history)
        AppType.SMARTCLIENT -> client.smartclient.main()
    }

}

fun setupHistory(): History<Any> {
    // val history: History<Any> = createBrowserHistory(options = BrowserHistoryBuildOptions())
    val history: History<Any> = createBrowserHistory()

    // Listen for changes to the current location.
    val unlisten = history.listen { location: Location<*>, action: String ->
        // location is an object like window.location
        console.log(action, location.pathname/*, location.state*/)
    }

    // Deregister the listener upon `unload`
    window.addEventListener("unload", {
        unlisten()
    })


    return history
}

