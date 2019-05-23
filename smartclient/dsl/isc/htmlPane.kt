package dsl.isc

fun htmlPane(block: CanvasProperties.() -> Unit): isc.HTMLPane {
    val props = CanvasProperties().apply(block)
    return isc.HTMLPane.create(props, null)
}

