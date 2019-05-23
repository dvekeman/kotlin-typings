package client.smartclient

import dsl.isc.*
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p
import kotlinx.html.pre
import kotlinx.html.stream.appendHTML
import kotlin.browser.window

enum class NavigationItem(val title: String, val nav: String) {
    HOME("HOME", ""), NAV("NAV", "nav"), DSL("DSL", "dsl")
}

/**
 * Main entry point of the application which will draw a VLayout with 100% width & height.
 *
 * The first component in the layout is a simple menu bar hosting two buttons
 *
 * - HOME
 * - Nav
 * - DSL
 *
 * The second component, the `mainLayout`, will contain the content of the requested _modules_
 *
 * Switching between the modules is based on `window.location.hash` (see [switchModule] and [setupRoutes].
 *
 */
fun main() {
//    label {
//        height = "100%"
//        width = "100%"
//        contents = "Hello world"
//    }
    vlayout {
        width = "100%"
        height = "100%"
        margin = 10

        members =
                arrayOf(
                        createMainMenu(),
                        createMainLayout()
                )
    }
}

/**
 * Create a container for the main content. When switching between modules, the previous layout child will be removed
 * and the new one will be added. See [setupRoutes] and [switchModule]
 */
fun createMainLayout(): isc.Layout {
    val mainLayout = vlayout {
        width = "100%"
        height = "90%"
    }

    setupRoutes(mainLayout)
    switchModule(mainLayout)

    return mainLayout
}


/**
 * Create the main menu
 *
 * - HOME: Navigate to the root of the web application
 * - Nav: Open the Nav module
 * - DSL: Open the DSL module
 */
fun createMainMenu(): isc.Layout {
    return hlayout {
        width = "100%"
        height = "50px"

        members = arrayOf(
                hashActionButton(NavigationItem.HOME),
                hashActionButton(NavigationItem.NAV),
                hashActionButton(NavigationItem.DSL)
        )
    }
}

/**
 * Helper method to create a button which changes the [`window.location.hash`](https://developer.mozilla.org/en-US/docs/Web/API/Window/location)
 * upon click.
 *
 */
fun hashActionButton(item: NavigationItem): isc.Button {
    return button {
        title = item.title
        width = "100px"
        click = {
            val nav = "#/${item.nav}"
            window.location.hash = if (nav.endsWith("/", false)) nav else "$nav/"
        }
    }
}

/**
 * Change the module depending on the [`window.location.hash`](https://developer.mozilla.org/en-US/docs/Web/API/Window/location).
 *
 * If the hash cannot be matched, an alert popup will be shown to the user.
 */
fun switchModule(mainLayout: isc.Layout) {
    val newModule: (() -> isc.Canvas)? =
            when (window.location.hash) {
                "#/" -> {
                    { home() }
                }
                "#/nav/" -> {
                    { nav() }
                }
                "#/dsl/" -> {
                    { dsl() }
                }
                else -> {
                    window.alert("'${window.location.hash}' is not found.")
                    null
                }
            }
    newModule?.let { replaceModule(mainLayout, it) }
}

fun replaceModule(mainLayout: isc.Layout, newModule: () -> isc.Canvas) {
    val memberIterator: Iterator<isc.Canvas> = mainLayout.getMembers().iterator()
    while (memberIterator.hasNext()) {
        val member = memberIterator.next()
        member.clear()
        mainLayout.removeMember(member)

    }
    mainLayout.addMember(newModule(), null)

}

fun setupRoutes(mainLayout: isc.Layout) {
    window.onhashchange = { event ->
        println("Hash: ${event.oldURL} => ${event.newURL}")
        if (event.oldURL != event.newURL) {
            switchModule(mainLayout)
        }
    }
}

fun home(): isc.Canvas {
    return label {
        width = "100%"
        align = "left"
        valign = "top"
        styleName = "largeLabelFont"
        contents = buildString {
            appendHTML(false).div {
                h1 {
                    +"HOME"
                }
                p {
                    +"This is Kotlin DSL ..."
                    +"inside SmartClient DSL!"
                }
                pre {
                    +"""
label {                                     // <-- SmartClient DSL: isc.Label
    width = "100%"                          //
    align = "left"                          //
    valign = "top"                          //
    contents = buildString {                // <-- Kotlin StringBuilders `buildString`
        appendHTML(false).div {             // <-- Create a new `div` element (kotlinx.html)
            h1{                             // <-- Kotlin HTML DSL
                +"HOME"                     //
            }                               //
            p {                             //
                +"This is Kotlin DSL ...    //
                +"inside SmartClient DSL!"  //
            }                               //
        }                                   //
    }                                       //
}                                           //
                    """
                }
            }
        }
    }
}

fun nav(): isc.Canvas {
    return hlayout {
        width = "100%"
        members =
                arrayOf(
                        label {
                            width = "100%"
                            align = "left"
                            valign = "top"
                            styleName = "largeLabelFont"
                            contents = buildString {
                                appendHTML(false).div {
                                    h1 {
                                        +"Nav"
                                    }
                                    p {
                                        +"Switching is based on URL hash: /#/nav/"
                                    }
                                    pre {
                                        +"""
fun switchModule(mainLayout: isc.Layout) {
    val newModule: (() -> isc.Canvas)? =
            when (window.location.hash) {
                "#/" -> {
                    { home() }
                }
                "#/nav/" -> {
                    { nav() }
                }
                "#/dsl/" -> {
                    { dsl() }
                }
                else -> {
                    window.alert("\$\{window.location.hash} is not found.")
                    null
                }
            }
    newModule?.let { replaceModule(mainLayout, it) }
}                                        """
                                    }
                                }
                            }
                        }
                )
    }
}

fun dsl(): isc.Canvas {
    return hlayout {
        width = "100%"
        members =
                arrayOf(
                        label {
                            width = "100%"
                            align = "left"
                            valign = "top"
                            styleName = "largeLabelFont"
                            contents = buildString {
                                appendHTML(false).div {
                                    h1 {
                                        +"DSL"
                                    }
                                    p {
                                        +""
                                    }
                                    pre {
                                        +"""
package dsl.isc

/**
 * Supported properties
 * - contents
 * ```
 *  The contents of a canvas or label widget. Any HTML string is acceptable.
 *  @type {HTMLString}
 *  @default "&amp;nbsp;"
 * ```
 * @see CanvasProperties
 */
@ISCDslMarker
open class LabelProperties(
        var contents: String? = null
) : CanvasProperties()

/**
 * DSL to create a label.
 *
 * Example usage
 * ```
 * val title = label {
 *   contents = "Foo"
 * }
 * ```
 *
 * @see LabelProperties
 */
fun label(block: LabelProperties.() -> Unit): isc.Label {
    val props = LabelProperties().apply(block)
    return isc.Label.create(props, null)
}
                                        """
                                    }
                                }
                            }
                        }
                )
    }
}
