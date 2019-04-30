package client

/**
 * The main entry point.
 * This function is called by default if `main = "call"` in compileKotlin2Js (see build.gradle.kts)
 */
fun main() {

    // Some variables which can be interpolated in the code string.
    val nameTitle = "Enter your name"
    val defaultValue = "my friend"
    val buttonTitle = "Hello"

    // Typed DynamicForm: the example below shows setting properties in two ways
    // - Using (untyped) dynamic JavaScript code ({ autoFocus: true, ... })
    // - Using typed properties on the DynamicForm object (`form.autoFocus = true`)
    val form = isc.DynamicForm.create(js(
        """{
autoFocus: true,
numCols: 3,
items: [
    {
        type: "text",
        name: "you",
        title: "$nameTitle",
        selectOnFocus: true,
        wrapTitle: false,
        defaultValue: "$defaultValue"
    }, 
    {
        type: "button",
        title: "$buttonTitle",
        width: 80,
        startRow: false,
        icon: "message.png",
        click: "isc.say('Hello ' + form.getValue('you') + '!')"
    }
]
        }"""
    ), null)
    form.autoFocus = true
    form.numCols = 3

}