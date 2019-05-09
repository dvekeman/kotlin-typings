package dsl.isc

/**
 * Supported properties
 * - contents
 * ```
 *  The contents of a canvas or label widget. Any HTML string is acceptable.
 *  @type {HTMLString}
 *  @default "&amp;nbsp;"
 * ```
 * @see CanvasProperties
 */
@ISCDslMarker
open class LabelProperties(
        var contents: String? = null
) : CanvasProperties()

/**
 * DSL to create a label.
 *
 * Example usage
 * ```
 * val title = label {
 *   contents = "Books"
 * }
 * ```
 *
 * @see LabelProperties
 */
fun label(block: LabelProperties.() -> Unit): isc.Label {
    val props = LabelProperties().apply(block)
    return isc.Label.create(props, null)
}