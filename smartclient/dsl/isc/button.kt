package dsl.isc

@ISCDslMarker
open class ButtonProperties(
        var title: String? = null,

        var click: (() -> Unit)? = null
) : CanvasProperties()

fun button(block: ButtonProperties.() -> Unit): isc.Button {
    val props = ButtonProperties().apply(block)
    return isc.Button.create(props, null)
}