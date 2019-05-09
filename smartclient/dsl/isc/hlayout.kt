package dsl.isc

fun hlayout(block: LayoutProperties.() -> Unit): isc.HLayout {
    val props = LayoutProperties().apply(block)
    return isc.HLayout.create(props, null)
}

