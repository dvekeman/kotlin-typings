package dsl.isc

open class HTMLPaneProperties: HTMLFlowProperties()


fun htmlPane(block: HTMLPaneProperties.() -> Unit): isc.HTMLPane {
    val props = HTMLPaneProperties().apply(block)
    return isc.HTMLPane.create(props, null)
}

