package dsl.isc

@ISCDslMarker
data class ButtonProperties(
        var click: (() -> Unit)? = null,

        var width: String? = null,
        var height: String? = null,

        /**
         *  The title HTML to display in this button.
         *  @type {HTMLString}
         *  @default "Untitled Button"
         */
        var title: String = "Untitled Button",
        /**
         *  If set to true, if the StatefulCanvas.title of this button contains the
         *   specified Canvas.accessKey, when the title is displayed to the user
         *   it will be modified to include HTML to underline the accessKey.
         *   Note that this property may cause titles that include HTML (rather than simple strings)
         *   to be inappropriately modified, so should be disabled if your title string includes
         *   HTML characters.
         *  @type {boolean}
         *  @default null
         */
        var hiliteAccessKey: Boolean? = null,
        /**
         *  If true and the title is clipped, then a hover containing the full title of this button
         *   is enabled.
         *  @type {boolean}
         *  @default false
         */
        var showClippedTitleOnHover: Boolean = false,
        /**
         *  Optional icon to be shown with the button title text.
         *
         *   Specify as the partial URL to an image, relative to the imgDir of this component.
         *   A sprited image can be specified using the SCSpriteConfig format.
         *
         *   Note that the string "blank" is a valid setting for this attribute and will always
         *   result in the system blank image, with no state suffixes applied. Typically, this
         *   might be used when an iconStyle is also specified and the iconStyle renders the icon via
         *   a stateful background-image or other CSS approach.
         *  @type {SCImgURL}
         *  @default null
         */
        var icon: String? = null,
        /**
         *  Size in pixels of the icon image.
         *
         *   The StatefulCanvas.iconWidth and StatefulCanvas.iconHeight
         *   properties can be used to configure width and height separately.
         *
         *   Note: When configuring the properties of a StatefulCanvas (or derivative)
         *   AutoChild, it is best to set the iconWidth and iconHeight
         *   to the same value rather than setting an iconSize. This is because certain
         *   skins or customizations thereto might set the iconWidth and iconHeight,
         *   making the customization of the AutoChild's iconSize ineffective.
         *  @type {Integer}
         *  @default "16"
         */
        var iconSize: Number = 16,
        /**
         *  Width in pixels of the icon image.
         *
         *   If unset, defaults to StatefulCanvas.iconSize.
         *  @type {Integer}
         *  @default null
         */
        var iconWidth: Number? = null,
        /**
         *  Height in pixels of the icon image.
         *
         *   If unset, defaults to StatefulCanvas.iconSize.
         *  @type {Integer}
         *  @default null
         */
        var iconHeight: Number? = null,
        /**
         *  Base CSS style applied to the icon image. If set, as the StatefulCanvas changes
         *   StatefulCanvas.state and/or is StatefulCanvas.selected,
         *   suffixes will be appended to iconStyle to form the className set on the
         *   image element.
         *
         *   The following table lists out the standard set of suffixes which may be appended:
         *
         *   CSS Class AppliedDescription
         *   iconStyleDefault CSS style
         *   iconStyle+Selected
         *     Applied when StatefulCanvas.selected and StatefulCanvas.showSelectedIcon
         *     are true.
         *   iconStyle+Focused
         *     Applied when the component has keyboard focus, if
         *     StatefulCanvas.showFocusedIcon is true, and
         *     StatefulCanvas.showFocusedAsOver is not true.
         *   iconStyle+Over
         *     Applied when StatefulCanvas.showRollOverIcon is set to true and either
         *     the user rolls over the component or StatefulCanvas.showFocusedAsOver is true
         *     and the component has keyboard focus.
         *   iconStyle+Down
         *     Applied when the user presses the mouse button on the component if
         *       StatefulCanvas.showDownIcon is set to true
         *   iconStyle+Disabled
         *     Applied when the component is Canvas.disabled
         *      if StatefulCanvas.showDisabledIcon is true.
         *   Combined styles
         *   iconStyle+SelectedFocused
         *     Combined Selected and focused styling
         *   iconStyle+SelectedOver
         *     Combined Selected and rollOver styling
         *   iconStyle+FocusedOver
         *     Combined Focused and rollOver styling
         *   iconStyle+SelectedFocusedOver
         *     Combined Selected, Focused and rollOver styling
         *   iconStyle+SelectedDown
         *     Combined Selected and mouse-down styling
         *   iconStyle+FocusedDown
         *     Combined Focused and mouse-down styling
         *   iconStyle+SelectedFocusedDown
         *     Combined Selected, Focused and mouse-down styling
         *   iconStyle+SelectedDisabled
         *     Combined Selected and Disabled styling
         *
         *
         *   In addition, if StatefulCanvas.showRTLIcon is true, then in RTL mode, a final
         *   "RTL" suffix will be appended.
         *  @type {CSSStyleName}
         *  @default null
         */
        var iconStyle: String? = null,
        /**
         *  If this button is showing an icon should it appear to the left or right of the title?
         *   valid options are "left" and "right".
         *  @type {string}
         *  @default "left"
         */
        var iconOrientation: String = "left",
        /**
         *  If this button is showing an icon should it be right or left aligned?
         *  @type {string}
         *  @default null
         */
        var iconAlign: String? = null,
        /**
         *  Pixels between icon and title text.
         *  @type {Integer}
         *  @default "6"
         */
        var iconSpacing: Number = 6,
        /**
         *  If using an icon for this button, whether to switch the icon image if the button becomes
         *   disabled.
         *  @type {boolean}
         *  @default true
         */
        var showDisabledIcon: Boolean = true,
        /**
         *  If using an icon for this button, whether to switch the icon image on mouse rollover.
         *  @type {boolean}
         *  @default false
         */
        var showRollOverIcon: Boolean = false,
        /**
         *  Specifies the cursor to display when the mouse pointer is over the icon image.
         *  @type {Cursor}
         *  @default null
         */
        var iconCursor:
        /**
         *  Use the default arrow cursor for this browser/OS.
         *  Use the default cursor for this element type in this                browser/OS
         *  Use the wait cursor.
         *  Use the hand cursor.
         *  Use the "move" (crosshairs) cursor.
         *  Use the 'help' cursor.
         *  Use the 'text' (i-beam) cursor.
         *  Use the normal hand pointer that appears when you hover                over a link
         *  Use the 'crosshair' ( + ) cursor.
         *  Use the column resize cursor (horizontal double-tipped arrow)
         *  Use the row resize cursor (vertical double-tipped arrow)
         *  Use the "east resize" cursor.
         *  Use the "west resize" cursor.
         *  Use the "north resize" cursor.
         *  Use the "south resize" cursor.
         *  Use the "south-east resize" cursor.
         *  Use the "north-east resize" cursor.
         *  Use the "north-west resize" cursor.
         *  Use the "south-west resize" cursor.
         *  Use the "not-allowed" cursor.
         */
        String? /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = null,
        /**
         *  Specifies the cursor to display when the mouse pointer is over the icon image and this
         *   StatefulCanvas is Canvas.disabled.
         *
         *   If not set and the mouse pointer is over the icon image, Button.iconCursor
         *   will be used.
         *  @type {Cursor}
         *  @default null
         */
        var disabledIconCursor:
        /**
         *  Use the default arrow cursor for this browser/OS.
         *  Use the default cursor for this element type in this                browser/OS
         *  Use the wait cursor.
         *  Use the hand cursor.
         *  Use the "move" (crosshairs) cursor.
         *  Use the 'help' cursor.
         *  Use the 'text' (i-beam) cursor.
         *  Use the normal hand pointer that appears when you hover                over a link
         *  Use the 'crosshair' ( + ) cursor.
         *  Use the column resize cursor (horizontal double-tipped arrow)
         *  Use the row resize cursor (vertical double-tipped arrow)
         *  Use the "east resize" cursor.
         *  Use the "west resize" cursor.
         *  Use the "north resize" cursor.
         *  Use the "south resize" cursor.
         *  Use the "south-east resize" cursor.
         *  Use the "north-east resize" cursor.
         *  Use the "north-west resize" cursor.
         *  Use the "south-west resize" cursor.
         *  Use the "not-allowed" cursor.
         */
        String? /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = null,
        /**
         *  If using an icon for this button, whether to switch the icon image when the button
         *   receives focus.
         *
         *   If StatefulCanvas.showFocusedAsOver is true, the "Over" icon will be
         *   displayed when the canvas has focus, otherwise a separate "Focused" icon
         *   will be displayed
         *  @type {boolean}
         *  @default false
         */
        var showFocusedIcon: Boolean = false,
        /**
         *  If using an icon for this button, whether to switch the icon image when the mouse goes
         *   down on the button.
         *  @type {boolean}
         *  @default false
         */
        var showDownIcon: Boolean = false,
        /**
         *  If using an icon for this button, whether to switch the icon image when the button
         *   becomes selected.
         *  @type {boolean}
         *  @default false
         */
        var showSelectedIcon: Boolean = false,
        /**
         *  If true, ignore the specified size of this widget and always size just large
         *   enough to accommodate the title. If setWidth() is explicitly called on an
         *   autoFit:true button, autoFit will be reset to false.
         *
         *   Note that for StretchImgButton instances, autoFit will occur horizontally only, as
         *   unpredictable vertical sizing is likely to distort the media. If you do want vertical
         *   auto-fit, this can be achieved by simply setting a small height, and having
         *   overflow:"visible"
         *  @type {boolean}
         *  @default null
         */
        var autoFit: Boolean? = null,
        /**
         *  Base CSS style className applied to the component.
         *
         *   As the component changes StatefulCanvas.state and/or is selected,
         *   suffixes will be added to the base style. In some cases more than one suffix will
         *   be appended to reflect a combined state ("Selected" + "Disabled", for example).
         *
         *   See StatefulCanvas.getStateSuffix for a description of the default set
         *   of suffixes which may be applied to the baseStyle
         *  @type {CSSStyleName}
         *  @default "button"
         */
        var baseStyle: String? = "button",
        /**
         *  if defined, iconOnlyBaseStyle is used as the base CSS style className,
         *   instead of Button.baseStyle, if Button.canAdaptWidth is set and the title is not being
         *   shown.
         *  @type {CSSStyleName}
         *  @default null
         */
        var iconOnlyBaseStyle: String? = null,
        /**
         *  Whether this component is selected. For some components, selection affects appearance.
         *  @type {boolean}
         *  @default false
         */
        var selected: Boolean = false,
        /**
         *  String identifier for this canvas's mutually exclusive selection group.
         *  @type {string}
         *  @default null
         */
        var radioGroup: String? = null,
        /**
         *  Behavior on state changes -- BUTTON, RADIO or CHECKBOX
         *  @type {SelectionType}
         *  @default "button"
         */
        var actionType:
        /**
         *  object moves to "down" state temporarily (normal button)
         *  object remains in "down" state until clicked again (checkbox)
         *  object moves to "down" state, causing another object to go up (radio)
         */
        String /* button |  checkbox |  radio */ = "button",
        /**
         *  Current "state" of this widget. The state setting is automatically updated as the
         *   user interacts with the component (see StatefulCanvas.showRollOver,
         *   StatefulCanvas.showDown, StatefulCanvas.showDisabled).
         *
         *   StatefulCanvases will have a different appearance based
         *   on their current state.
         *   By default this is handled by changing the css className applied to
         *   the StatefulCanvas - see StatefulCanvas.baseStyle and
         *   StatefulCanvas.getStateSuffix for a description of how this is done.
         *
         *   For Img or StretchImg based subclasses of StatefulCanvas, the
         *   appearance may also be updated by changing the src of the rendered image. See
         *   Img.src and StretchImgButton.src for a description of how the URL
         *   is modified to reflect the state of the widget in this case.
         *  @type {State}
         *  @default ""
         */
        var state:
        /**
         *  state when mouse is not acting on this StatefulCanvas
         *  state when mouse is down
         *  state when mouse is over
         *  disabled
         */
        String /*  |  Down |  Over |  Disabled */ = "",
        /**
         *  Should we visibly change state when disabled?
         *  @type {boolean}
         *  @default true
         */
        var showDisabled: Boolean = true,
        /**
         *  Should we visibly change state when the mouse goes down in this object?
         *  @type {boolean}
         *  @default false
         */
        var showDown: Boolean = false,
        /**
         *  Should we visibly change state when the canvas receives focus? If
         *   StatefulCanvas.showFocusedAsOver is true, then "over"
         *   will be used to indicate focus. Otherwise a separate "focused" state
         *   will be used.
         *  @type {boolean}
         *  @default false
         */
        var showFocused: Boolean = false,
        /**
         *  Should we visibly change state when the mouse goes over this object?
         *  @type {boolean}
         *  @default false
         */
        var showRollOver: Boolean = false,
        /**
         *  Horizontal alignment of this component's title.
         *  @type {Alignment}
         *  @default "center"
         */
        var align:
        /**
         *  Center within container.
         *  Stick to left side of container.
         *  Stick to right side of container.
         */
        String /* center |  left |  right */ = "center",
        /**
         *  Vertical alignment of this component's title.
         *  @type {VerticalAlignment}
         *  @default "center"
         */
        var valign:
        /**
         *  At the top of the container
         *  Center within container.
         *  At the bottom of the container
         */
        String /* top |  center |  bottom */ = "center",
        /**
         *  A boolean indicating whether the button's title should word-wrap, if necessary.
         *  @type {boolean}
         *  @default false
         */
        var wrap: Boolean = false,
        /**
         *  If enabled, the button will collapse to show just its icon when showing the title would
         *   cause overflow of a containing Layout. While collapsed, the button will show its title
         *   on hover, unless an explicit hover has been specified such as by overriding
         *   Button.titleHoverHTML.
         *  @type {boolean}
         *  @default false
         */
        var canAdaptWidth: Boolean? = false,
        /**
         *  Clip the contents of the button if necessary.
         *  @type {Overflow}
         *  @default "hidden"
         */
        var overflow:
        /**
         *  Content that extends beyond the widget's width or height is               displayed.
         *                 Note: To have the content be sized only by the drawn size of
         *                 the content set the overflow to be Canvas.VISIBLE and specify
         *                 a small size, allowing the size to expand to the size required
         *                 by the content.
         *                 Leaving the width / height for the widget undefined will use the
         *                 default value of 100, and setting the size to zero may cause the
         *                 widget not to draw.
         *  Content that extends beyond the widget's width or height is               clipped (hidden).
         *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
         *                 area is clipped.
         *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
         *                 is clipped, and can be accessed via scrolling.
         *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
         *                 specific widget subclasses.
         *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
         *                 for specific widget subclasses.
         */
        String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = "hidden"
) : ClassProperties()

fun button(block: ButtonProperties.() -> Unit): isc.Button {
    val props = ButtonProperties().apply(block)
    return isc.Button.create(props, null)
}