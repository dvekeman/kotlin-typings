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
    // Important, not the difference between
    // title: nameTitle
    // defaultValue: "$defaultValue"
    //
    // Both will insert the `nameTitle` variable! The latter will only work with string constants though
    val form = isc.DynamicForm.create(js(
        """{
autoFocus: true,
numCols: 3,
items: [
    {
        type: "text",
        name: "you",
        title: nameTitle,
        selectOnFocus: true,
        wrapTitle: false,
        defaultValue: "$defaultValue"
    }, 
    {
        type: "button",
        title: buttonTitle,
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

// Note: Alternative way to deal with records:

//val dsTitleField: dynamic = object {}
//dsTitleField["name"] = "dsTitle"
//dsTitleField["title"] = "Select a DataSource"
//grid.setFields(arrayOf(dsTitleField))
//
//val dsAnimals: dynamic = object {}
//dsAnimals["dsTitle"] = "Animals"
//dsAnimals["dsName"] = "animals"
//
//val dsOffice: dynamic = object {}
//dsOffice["dsTitle"] = "Office Supplies"
//dsOffice["dsName"] = "supplyItem"
//
//val dsEmployees: dynamic = object {}
//dsEmployees["dsTitle"] = "Employees"
//dsEmployees["dsName"] = "employees"
//grid.setData(arrayOf(dsAnimals, dsOffice, dsEmployees))
