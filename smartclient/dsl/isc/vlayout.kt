package dsl.isc

fun vlayout(block: LayoutProperties.() -> Unit): isc.VLayout {
    val props = LayoutProperties().apply(block)
    props.vertical = true
    return isc.VLayout.create(props, null)
}

