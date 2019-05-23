package dsl.isc

open class HTMLFlowProperties: CanvasProperties()

fun htmlFlow(block: HTMLFlowProperties.() -> Unit): isc.HTMLFlow {
    val props = HTMLFlowProperties().apply(block)
    return isc.HTMLFlow.create(props, null)
}

