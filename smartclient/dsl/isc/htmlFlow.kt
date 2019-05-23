package dsl.isc

fun htmlFlow(block: CanvasProperties.() -> Unit): isc.HTMLFlow {
    val props = CanvasProperties().apply(block)
    return isc.HTMLFlow.create(props, null)
}

