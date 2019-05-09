package dsl.isc

fun vlayout(block: LayoutProperties.() -> Unit): isc.VLayout {
    val props = LayoutProperties().apply(block)
    return isc.VLayout.create(props, null)
}

