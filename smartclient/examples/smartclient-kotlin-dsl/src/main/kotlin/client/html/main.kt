package client.html

import history.History
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.Node
import kotlin.browser.document
import kotlin.browser.window

fun main(history: History<Any>) {
    setupRoutes(history)

    val app = document.create.div("app") {
        nav {
            ul {
                li {
                    a {
                        href = "#/"
                        +"HOME"
                    }
                }
                li {
                    a {
                        href = "#/books/"
                        +"Books"
                    }
                }
            }
        }
        main {
            id = "main"
        }
    }
    document.body!!.appendChild(app)

    switchModule(history)
}

fun switchModule(history: History<Any>) {
    println("Hash: ${history.location.hash}")
    val newModule: Node? = when(history.location.hash) {
        "#/" -> home()
        "#/books/" -> books()
        else -> {
            println("No matching route found...")
            null
        }
    }
    newModule?.let { replaceModule(it) }
}

fun replaceModule(newModule: Node){
    val main = document.getElementById("main")!!
    val firstChild = main.firstChild

    if(firstChild == null){
        main.appendChild(newModule)
    } else {
        main.replaceChild(newModule, firstChild)
    }
}

@JsName("author")
fun author() {
    println("author")
}

fun setupRoutes(history: History<Any>) {
    window.onhashchange = { event ->
        println("Hash: ${event.oldURL} => ${event.newURL}")
        if(event.oldURL != event.newURL) {
            switchModule(history)
        }
    }
}

fun home(): Node{
    return document.create.div {
        h1 {
            +"HOME"
        }
    }
}

fun books(): Node {
    println("Showing books")
    val books = document.create.div("app")
    val booksLayout: isc.HLayout = isc.HLayout.create(js("""
{ width: "100%"
, height: "100%"
, defaultLayoutAlign: "center"
}
    """), null)
    val title = isc.Label.create(js("""
{ contents: "Books"
, width: "100%"
}
    """), null)
    booksLayout.addMember(title, null)

    return books
}

fun viewBook(bookId: String) {
    println("viewBook: bookId is populated: $bookId")
}

