package dsl.isc

import isc.Canvas

@ISCDslMarker
open class StatefulCanvasProperties: CanvasProperties() {

    /**
     *  The title HTML to display in this button.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String? = null
    /**
     *  Should horizontal alignment-related attributes StatefulCanvas.align and StatefulCanvas.iconOrientation
     *   be mirrored in RTL mode? This is the default behavior unless ignoreRTL is set to true.
     *  @type {boolean}
     *  @default false
     */
    open var ignoreRTL: Boolean = false
    /**
     *  Whether this widget needs to redraw to reflect state change
     *  @type {boolean}
     *  @default false
     */
    open var redrawOnStateChange: Boolean = false
    /**
     *  Whether this component is selected. For some components, selection affects appearance.
     *  @type {boolean}
     *  @default false
     */
    open var selected: Boolean = false
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
    open var state:
            /**
             *  state when mouse is not acting on this StatefulCanvas
             *  state when mouse is down
             *  state when mouse is over
             *  disabled
             */
            String /*  |  Down |  Over |  Disabled */ = ""
    /**
     *  Should we visibly change state when the mouse goes over this object?
     *  @type {boolean}
     *  @default false
     */
    open var showRollOver: Boolean = false
    /**
     *  Should we visibly change state when the canvas receives focus? Note that by default the
     *   over state is used to indicate focus.
     *  @deprecated \* as of SmartClient version 6.1 in favor of StatefulCanvas.showFocused
     *  @type {boolean}
     *  @default false
     */
    open var showFocus: Boolean = false
    /**
     *  Should we visibly change state when the canvas receives focus? If
     *   StatefulCanvas.showFocusedAsOver is true, then "over"
     *   will be used to indicate focus. Otherwise a separate "focused" state
     *   will be used.
     *  @type {boolean}
     *  @default false
     */
    open var showFocused: Boolean = false
    /**
     *  If StatefulCanvas.showFocused is true for this widget, should the
     *   "over" state be used to indicate the widget as focused. If set to false,
     *   a separate "focused" state will be used.
     *  @type {boolean}
     *  @default true
     */
    open var showFocusedAsOver: Boolean = true
    /**
     *  Should we visibly change state when the mouse goes down in this object?
     *  @type {boolean}
     *  @default false
     */
    open var showDown: Boolean = false
    /**
     *  Should we visibly change state when disabled?
     *  @type {boolean}
     *  @default true
     */
    open var showDisabled: Boolean = true
    /**
     *  Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *  @type {SelectionType}
     *  @default "button"
     */
    open var actionType:
            /**
             *  object moves to "down" state temporarily (normal button)
             *  object remains in "down" state until clicked again (checkbox)
             *  object moves to "down" state, causing another object to go up (radio)
             */
            String /* button |  checkbox |  radio */ = "button"
    /**
     *  String identifier for this canvas's mutually exclusive selection group.
     *  @type {string}
     *  @default null
     */
    open var radioGroup: String? = null
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
     *  @default null
     */
    open var baseStyle: String? = null
    /**
     *  Horizontal alignment of this component's title.
     *  @type {Alignment}
     *  @default "center"
     */
    open var align:
            /**
             *  Center within container.
             *  Stick to left side of container.
             *  Stick to right side of container.
             */
            String /* center |  left |  right */ = "center"
    /**
     *  Vertical alignment of this component's title.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    open var valign:
            /**
             *  At the top of the container
             *  Center within container.
             *  At the bottom of the container
             */
            String /* top |  center |  bottom */ = "center"
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
    open var autoFit: Boolean? = null
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
    open var icon: String? = null
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
    open var iconSize: Number = 16
    /**
     *  Width in pixels of the icon image.
     *
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    open var iconWidth: Number? = null
    /**
     *  Height in pixels of the icon image.
     *
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    open var iconHeight: Number? = null
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
    open var iconStyle: String? = null
    /**
     *  If this button is showing an icon should it appear to the left or right of the title?
     *   valid options are "left" and "right".
     *  @type {string}
     *  @default "left"
     */
    open var iconOrientation: String = "left"
    /**
     *  Pixels between icon and title text.
     *  @type {Integer}
     *  @default "6"
     */
    open var iconSpacing: Number = 6
    /**
     *  If using an icon for this button, whether to switch the icon image if the button becomes
     *   disabled.
     *  @type {boolean}
     *  @default true
     */
    open var showDisabledIcon: Boolean = true
    /**
     *  If using an icon for this button, whether to switch the icon image on mouse rollover.
     *  @type {boolean}
     *  @default false
     */
    open var showRollOverIcon: Boolean = false
    /**
     *  If using an icon for this button, whether to switch the icon image when the mouse goes
     *   down on the button.
     *  @type {boolean}
     *  @default false
     */
    open var showDownIcon: Boolean = false
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   becomes selected.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedIcon: Boolean = false
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
    open var showFocusedIcon: Boolean = false
    /**
     *  Is Page.isRTL media available for the icon? If true, then in RTL mode, the
     *   image's src will have "_rtl" inserted immediately before the file extension. For example,
     *   if StatefulCanvas.icon is "myIcon.png" and showRTLIcon is true, then in RTL mode, the image's
     *   src will be set to "myIcon_rtl.png".
     *  @type {boolean}
     *  @default false
     */
    open var showRTLIcon: Boolean = false
    /**
     *  When this property is set to true, this widget will create and show the
     *   StatefulCanvas.overCanvas on user rollover.
     *  @type {boolean}
     *  @default false
     */
    open var showOverCanvas: Boolean = false
    /**
     *  Auto generated child widget to be shown when the user rolls over this canvas if
     *   StatefulCanvas.showOverCanvas is true. See documentation for AutoChild
     *   for information on how to customize this canvas.
     *  @type {Canvas}
     *  @default null
     */
    open var overCanvas: Canvas? = null
    /**
     *  Constructor class name for this widget's StatefulCanvas.overCanvas
     *  @type {string}
     *  @default "Canvas"
     */
    open var overCanvasConstructor: String = "Canvas"
    /**
     *  Default properties for this widgets StatefulCanvas.overCanvas. To modify
     *   these defaults, use Class.changeDefaults
     *  @type {Canvas}
     *  @default "{ ... }"
     */
    // open var overCanvasDefaults: Canvas = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "StatefulCanvasEditProxy"
     */
    override var editProxyConstructor: String = "StatefulCanvasEditProxy"
}