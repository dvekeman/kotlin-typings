package dsl.isc

import isc.*

@ISCDslMarker
data class CanvasProperties(

        /**
         *  If this canvas is being displayed in a CanvasItem, this property will be set
         *   to point at the item. Otherwise this property will be null.
         *  @type {CanvasItem}
         *  @default null
         */
        var canvasItem: isc.CanvasItem? = null,
        /**
         *  Default total duration of animations. Can be overridden by setting animation times for
         *   specific animations, or by passing a duration parameter into the appropriate
         *   animate...() method.
         *  @type {number}
         *  @default "300"
         */
        var animateTime: Number = 300,
        /**
         *  Default acceleration effect to apply to all animations on this Canvas.
         *   Can be overridden by setting animationAcceleration for specific animations or by passing
         *   an acceleration function directly into the appropriate method.
         *  @type {AnimationAcceleration}
         *  @default "smoothEnd"
         */
        var animateAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = "smoothEnd",
        /**
         *  Default animation effect to use if Canvas.animateShow is called without an
         *   explicit effect parameter
         *  @type {AnimateShowEffectId | AnimateShowEffect}
         *  @default "wipe"
         */
        var animateShowEffect: dynamic = "wipe",
        /**
         *  Default animation effect to use if Canvas.animateHide is called without an
         *   explicit effect parameter
         *  @type {AnimateShowEffectId | AnimateShowEffect}
         *  @default "wipe"
         */
        var animateHideEffect: dynamic = "wipe",
        /**
         *  Default time for performing an animated move. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateMoveTime: Number? = null,
        /**
         *  Default time for performing an animated resize. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateResizeTime: Number? = null,
        /**
         *  Default time for performing an animated setRect. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateRectTime: Number? = null,
        /**
         *  Default time for performing an animated fade. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateFadeTime: Number? = null,
        /**
         *  Default time for performing an animated scroll. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateScrollTime: Number? = null,
        /**
         *  Default time for performing an animated show. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateShowTime: Number? = null,
        /**
         *  Default time for performing an animated hide. If unset, this.animateTime
         *   will be used by default instead
         *  @type {number}
         *  @default null
         */
        var animateHideTime: Number? = null,
        /**
         *  Default acceleration effect for performing an animated move. If unset,
         *   this.animateAcceleration will be used by default instead
         *  @type {AnimationAcceleration}
         *  @default null
         */
        var animateMoveAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null,
        /**
         *  Default acceleration function for performing an animated resize. If unset,
         *   this.animateAcceleration will be used by default instead
         *  @type {AnimationAcceleration}
         *  @default null
         */
        var animateResizeAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null,
        /**
         *  Default acceleration function for performing an animated move and resize. If unset,
         *   this.animateAcceleration will be used by default instead
         *  @type {AnimationAcceleration}
         *  @default null
         */
        var animateRectAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null,
        /**
         *  Default acceleration function for performing an animated scroll. If unset,
         *   this.animateAcceleration will be used by default instead
         *  @type {AnimationAcceleration}
         *  @default null
         */
        var animateScrollAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null,
        /**
         *  Default acceleration function for performing an animated show. If unset,
         *   this.animateAcceleration will be used by default instead
         *  @type {AnimationAcceleration}
         *  @default null
         */
        var animateShowAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null,
        /**
         *  Default acceleration function for performing an animated hide. If unset,
         *   this.animateAcceleration will be used by default instead
         *  @type {AnimationAcceleration}
         *  @default null
         */
        var animateHideAcceleration:
        /**
         *  - animation will speed up as time elapses
         *  - animation will slow down as time elapses
         *  - animation will speed up in the middle
         *  - no bias
         */
        String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null,
        /**
         *  When this Canvas is included as a member in a Layout, layoutAlign controls alignment on the
         *   breadth axis of the layout. Default is "left" for a VLayout, "top" for an HLayout.
         *  @type {Alignment | VerticalAlignment}
         *  @default null
         */
        var layoutAlign: dynamic = null,
        /**
         *  When this Canvas is included as a member in a Layout, whether a resizeBar should be shown
         *   after this member in the layout, to allow it to be resized.
         *
         *   Whether a resizeBar is actually shown also depends on the
         *   Layout.defaultResizeBars attribute of the layout, and whether this
         *   Canvas is the last layout member.
         *
         *   By default the resize bar acts on the Canvas that it is declared on. If you want the resize
         *   bar to instead act on the next member of the Layout (e.g. to collapse down or to the right),
         *   set Canvas.resizeBarTarget as well.
         *  @type {boolean}
         *  @default false
         */
        var showResizeBar: Boolean = false,
        /**
         *  When this Canvas is included as a member in a Layout, and Canvas.showResizeBar is set to
         *   true so that a resizeBar is created, resizeBarTarget:"next" can be
         *   set to indicate that the resizeBar should resize the next member of the layout rather than
         *   this one. For resizeBars that support hiding their target member when clicked on,
         *   resizeBarTarget:"next" also means that the next member will be the one hidden.
         *
         *   This is typically used to create a 3-way split pane, where left and right-hand sections can
         *   be resized or hidden to allow a center section to expand.
         *
         *   NOTE: as with any Layout, to ensure all available space is used, one or more members
         *   must maintain a flexible size (eg 75%, or \*). In a two pane Layout with a normal resize
         *   bar, to fill all space after a user resizes, the member on the right should have
         *   flexible size. With resizeBarTarget:"next", the member on the left should have
         *   flexible size.
         *  @type {string}
         *  @default null
         */
        var resizeBarTarget: String? = null,
        /**
         *  When this Canvas is included as a member in a Layout, extra blank space that should be left
         *   after this member in a Layout.
         *  @type {PositiveInteger}
         *  @default "0"
         */
        var extraSpace: Number = 0,
        /**
         *  Configures where the Opacity filter is used for IE6-8.
         *
         *   With the default of null, opacity filters are used unless
         *   Canvas.neverUseFilters has been set. When set explicitly to true,
         *   opacity filters are used even if neverUseFilters is true.
         *
         *   See IEFilters for background.
         *  @type {boolean}
         *  @default null
         */
        var useOpacityFilter: Boolean? = null,
        /**
         *  Global identifier for referring to a widget in JavaScript. The ID property is optional if
         *   you do not need to refer to the widget from JavaScript, or can refer to it indirectly
         *   (for example, by storing the reference returned by Class.create).
         *
         *   An internal, unique ID will automatically be created upon instantiation for any canvas
         *   where one is not provided.
         *
         *   The ID property should be unique in the global scope. If window[ID]
         *   is already assigned to something else a warning will be logged using the developer console,
         *   and the existing reference will be replaced, calling Canvas.destroy on the
         *   previous object if it is a SmartClient Class instance.
         *
         *   Automatically generated IDs will be unique as long as the canvases they refer to remain
         *   active - once a canvas with an automatically generated ID has been destroyed, its ID may be
         *   reused for the next canvas created with no explicitly specified ID.
         *  @type {GlobalId}
         *  @default null
         */
        var ID: String? = null,
        /**
         *  If true, this canvas will draw itself immediately after it is created.
         *
         *   Note that you should turn this OFF for any canvases that are provided as children
         *   of other canvases, or they will draw initially, then be clear()ed and drawn again when
         *   added as children, causing a large performance penalty.
         *
         *   For example, the following code is incorrect and will cause extra draw()s:
         *
         *
         *     isc.Layout.create({
         *       members : [
         *         isc.ListGrid.create()
         *       ]
         *     });
         *
         *   It should instead be:
         *
         *     isc.Layout.create({
         *       members : [
         *         isc.ListGrid.create({ autoDraw: false })
         *       ]
         *     });
         *
         *   In order to avoid unwanted autoDrawing systematically, it is recommend that you call
         *   isc.setAutoDraw immediately after SmartClient is loaded
         *   and before any components are created, then set autoDraw:true or call
         *   draw() explicitly to draw components.
         *
         *   Otherwise, if the global setting for autoDraw remains true, you must set
         *   autoDraw:false, as shown above, on every component in your application that
         *   should not immediately draw: all Canvas children, Layout members, Window items, Tab
         *   panes, etc, however deeply nested. Forgetting to set autoDraw:false will result in one
         *   more clear()s - these are reported on the Results tab of the
         *   debugging, and can be tracked to individual components by
         *   using the "clears" log category in the Developer Console.
         *  @type {boolean}
         *  @default true
         */
        var autoDraw: Boolean = true,
        /**
         *  This Canvas's immediate parent, if any.
         *
         *   Can be initialized, but any subsequent manipulation should be via
         *   Canvas.addChild and Canvas.removeChild calls
         *   on the parent.
         *  @deprecated \* As of Smartclient version 9.1, deprecated in favor of Canvas.parentCanvas       and Canvas.getParentCanvas
         *  @type {Canvas}
         *  @default null
         */
        var parentElement: Canvas? = null,
        /**
         *  This Canvas's immediate parent, if any.
         *
         *   Can be initialized, but any subsequent manipulation should be via
         *   Canvas.addChild and Canvas.removeChild calls
         *   on the parent. The parent Canvas should be fetched using
         *   Canvas.getParentCanvas.
         *  @type {Canvas}
         *  @default null
         */
        var parentCanvas: Canvas? = null,
        /**
         *  The top-most Canvas (i.e., not a child of any other Canvas), if any, in this widget's
         *   containment hierarchy.
         *  @type {Canvas}
         *  @default null
         */
        var topElement: Canvas? = null,
        /**
         *  This Canvas's "master" (the Canvas to which it was added as a peer), if any.
         *  @deprecated \* In favor or Canvas.getMasterCanvas as of SmartClient release 9.1
         *  @type {Canvas}
         *  @default null
         */
        var masterElement: Canvas? = null,
        /**
         *  Array of all Canvii that are immediate children of this Canvas.
         *
         *   Use Canvas.addChild and Canvas.removeChild to add and remove children after a Canvas
         *   has been created/drawn.
         *  @type {Array<Partial<Canvas>>}
         *  @default null
         */
        var children: Array<dynamic>? = null,
        /**
         *  Array of all Canvii that are peers of this Canvas.
         *
         *   Use Canvas.addPeer and Canvas.removePeer to add and remove peers after a Canvas
         *   has been created/drawn.
         *  @type {Array<Partial<Canvas>>}
         *  @default null
         */
        var peers: Array<dynamic>? = null,
        /**
         *  This initialization property allows developers to create a canvas using the
         *   Class.addAutoChild method, and have it added as a child to some other
         *   component. This property may be set to the childName of another
         *   already-created auto-child, or "none" to cause the component to be
         *   created without being added as a child to any other widget.
         *   If unset, the canvas will be added as a child to the component on which
         *   addAutoChild(...) was called.
         *
         *   See autoChildren for an overview of the autoChild subsystem.
         *  @type {string}
         *  @default null
         */
        var autoParent: String? = null,
        /**
         *  If specified as a pointer to an HTML element present in the DOM, this canvas will be
         *   rendered inside that element on Canvas.draw.
         *
         *   NOTES:
         *   This feature is intended for temporary integration with legacy page architectures only;
         *   the native browser's reaction to DOM insertion is unspecified and unsupported. For
         *   consistent cross-browser layout and positioning semantics, use Canvas parents
         *   (especially Layouts) and use absolute positioning at top level.
         *
         *   Persistence of htmlElement: If Canvas.htmlPosition is set to "replace"
         *   the htmlElement will be removed from the DOM when the canvas is drawn - therefore the
         *   htmlElement attribute will be cleared at this time.
         *   Otherwise if a Canvas is clear()d and then draw()n again it will
         *   be rendered inside the same htmlElement.
         *   If a Canvas is added as a child to Canvas parent, its htmlElement will be dropped.
         *
         *   Canvas.position should typically be set to "relative" if the widget
         *   is to be rendered inline within a standard page.
         *  @type {DOMElement}
         *  @default null
         */
        var htmlElement: DOMElement? = null,
        /**
         *  If Canvas.htmlElement is specified, this attribute specifies the position where
         *   the canvas should be inserted relative to the htmlElement in the DOM.
         *  @type {DrawPosition}
         *  @default "afterBegin"
         */
        var htmlPosition:
        /**
         *  insert before the target element
         *  insert as the target element's first child
         *  insert as the target element's last child
         *  insert after the target element
         *  replace the target element
         */
        String /* beforeBegin |  afterBegin |  beforeEnd |  afterEnd |  replace */ = "afterBegin",
        /**
         *  If Canvas.htmlElement is specified, should this canvas initially be drawn
         *   at the same dimensions as the htmlElement?
         *   Note: setting this property will not force the canvas to resize if the element
         *   subsequently resizes (for example due to page reflow).
         *  @type {boolean}
         *  @default null
         */
        var matchElement: Boolean? = null,
        /**
         *  Absolute or relative, corresponding to the "absolute" (with respect to parent) or
         *   "relative" (with respect to document flow) values for the CSS position attribute.
         *
         *   Setting position:"relative" enables SmartClient components to be embedded
         *   directly into the native HTML flow of a page, causing the component to be rendered
         *   within an existing DOM structure.
         *   This attribute should only be set to "relative" on a top level component
         *   (a component with no Canvas.getParentCanvas).
         *
         *   There are 2 ways to embed relatively positioned canvases in the DOM - by default the
         *   component will be written out inline when it gets Canvas.draw. For example
         *   to embed a canvas in an HTML table you could use this code:
         *
         *   &lt;table&gt;
         *    &lt;tr&gt;
         *     &lt;td&gt;
         *      &lt;script&gt;
         *       isc.Canvas.create({autoDraw:true, backgroundColor:"red", position:"relative"});
         *      &lt;/script&gt;
         *     &lt;td&gt;
         *    &lt;/tr&gt;
         *   &lt;/table&gt;
         *
         *   Alternatively you can make use of the Canvas.htmlElement attribute.
         *
         *   Relative positioning is intended as a short-term integration scenario while incrementally
         *   upgrading existing applications.
         *   Note that relative positioning is not used to manage layout within SmartClient components -
         *   instead the Layout class would typically be used.
         *   For best consistency and flexibility across browsers, all SmartClient layout managers
         *   use absolute positioning.
         *
         *   For canvases with a specified Canvas.htmlElement, this attribute defaults to
         *   "relative". In all other cases the default value will be
         *   "absolute".
         *  @type {Positioning}
         *  @default null
         */
        var position:
        /**
         *  The canvas is absolutely positioned with respect to its                 parent.
         *  The canvas is relatively positioned according to the                 document flow.
         */
        String? /* absolute |  relative */ = null,
        /**
         *  Number of pixels the left side of the widget is offset to the right from its default
         *   drawing context (either its parent's topleft corner, or the document flow, depending on
         *   the value of the Canvas.position property).
         *
         *   Can also be set as a percentage, specified as a String ending in '%', eg, "50%". In
         *   this case the top coordinate is considered as a percentage of the specified width of
         *   the Canvas.getParentCanvas.
         *  @type {number | string}
         *  @default "0"
         */
        var left: dynamic = 0,
        /**
         *  Number of pixels the top of the widget is offset down from its default drawing context
         *   (either its parent's top-left corner, or the document flow, depending on the value of
         *   the Canvas.position property).
         *
         *   Can also be set as a percentage, specified as a String ending in '%', eg, "50%". In
         *   this case the top coordinate is considered as a percentage of the specified height of
         *   the Canvas.getParentCanvas.
         *  @type {number | string}
         *  @default "0"
         */
        var top: dynamic = 0,
        /**
         *  If set, overrides the global Canvas.defaultPageSpace.
         *  @type {Integer}
         *  @default null
         */
        var leavePageSpace: Number? = null,
        /**
         *  Size for this component's horizontal dimension.
         *
         *   Can be a number of pixels, or a percentage like "50%". Percentage sizes are resolved to
         *   pixel values as follows:
         *
         *
         *  - If a canvas has a specified Canvas.percentSource, sizing will be
         *     a percentage of the size of that widget (see also Canvas.percentBox).
         *
         *  - Otherwise, if a canvas has a Canvas.getMasterCanvas, and
         *     Canvas.snapTo is set for the widget, sizing will be a percentage of
         *     the size of that widget (see also Canvas.percentBox).
         *
         *  - Otherwise if this is a child of some other canvas, percentages will be based on the
         *     inner size of the Canvas.getParentCanvas's viewport.
         *
         *  - Otherwise, for top level widgets, sizing is calculated as a percentage of page size.
         *
         *   Note that if a Canvas.maxWidth or Canvas.minWidth are specified
         *   (or Canvas.maxHeight / Canvas.minHeight for heights), these
         *   properties act as explicit pixel limits on the canvas' size. For example, a canvas
         *   with Canvas.maxWidth set to 500, and width specified as
         *   "100%" will not render larger than 500 pixels in width even if there is more
         *   space available in the parent canvas or percentSource.
         *
         *   Layout may specially interpret percentage sizes on their children,
         *   and also allow "\*" as a size.
         *
         *   Note that if Canvas.overflow is set to "visible", this size is a
         *   minimum, and the component may overflow to show all content and/or children.
         *
         *   If trying to establish a default width for a custom component, set
         *   Canvas.defaultWidth instead.
         *  @type {number | string}
         *  @default null
         */
        var width: dynamic = null,
        /**
         *  Size for this component's vertical dimension.
         *
         *   Can be a number of pixels, or a percentage like "50%". See documentation for
         *   Canvas.width for details on how percentage values are resolved actual size.
         *
         *   Note that if Canvas.overflow is set to "visible", this size is a
         *   minimum, and the component may overflow to show all content and/or children.
         *
         *   If trying to establish a default height for a custom component, set
         *   Canvas.defaultHeight instead.
         *  @type {number | string}
         *  @default null
         */
        var height: dynamic = null,
        /**
         *  For custom components, establishes a default width for the component.
         *
         *   For a component that should potentially be sized automatically by a Layout, set this
         *   property rather than Canvas.width directly, because Layouts regard a width setting as
         *   an explicit size that shouldn't be changed.
         *  @type {Integer}
         *  @default "100"
         */
        var defaultWidth: Number = 100,
        /**
         *  For custom components, establishes a default height for the component.
         *
         *   For a component that should potentially be sized automatically by a Layout, set this
         *   property rather than Canvas.height directly, because Layouts regard a height setting as
         *   an explicit size that shouldn't be changed.
         *  @type {Integer}
         *  @default "100"
         */
        var defaultHeight: Number = 100,
        /**
         *  Minimum width available to this Canvas.
         *
         *   The minWidth and Canvas.minHeight settings apply to:
         *
         *
         *  - For a canvas being managed as a member of a Layout, the minimum size the
         *     layout should apply to the canvas.
         *
         *  - For a canvas with a width or height specified as a percent value, a minimum
         *     numeric pixel value to limit how large the canvas is sized.
         *
         *  - determining size for a Canvas in a CanvasItem (minHeight only)
         *
         *  - end user Canvas.canDragResize
         *
         *  - minimum size when using Overflow "visible" outside of a Layout - minimum
         *     size will be the greater of this setting or the minimum size needed to make all
         *     content visible
         *
         *
         *   Minimum sizes do not apply in various other circumstances where sizes are being
         *   determined, such as ListGrid.showRecordComponents.
         *
         *   See also Layout.minMemberLength as a way of establishing minimum sizes along
         *   the length axis for all members of a Layout with a single setting.
         *  @type {number}
         *  @default null
         */
        var minWidth: Number? = null,
        /**
         *  Minimum height available to this Canvas. See Canvas.minWidth for details of behavior.
         *  @type {number}
         *  @default null
         */
        var minHeight: Number? = null,
        /**
         *  Maximum width available to this Canvas.
         *
         *   The maxWidth and Canvas.maxHeight settings apply to:
         *
         *
         *  - For a canvas being managed as a member of a Layout, the maximum size the
         *     layout should apply to the canvas.
         *
         *  - For a canvas with a width or height specified as a percent value, a maximum
         *     numeric pixel value to limit how large the canvas is sized.
         *
         *  - determining size for a Canvas in a CanvasItem (maxHeight only)
         *
         *  - end user Canvas.canDragResize
         *
         *   Maximum sizes do not apply in various other circumstances where sizes are being
         *   determined, such as ListGrid.showRecordComponents.
         *  @type {number}
         *  @default "10000"
         */
        var maxWidth: Number = 10000,
        /**
         *  Maximum height available to this Canvas. See Canvas.maxWidth for details of behavior.
         *  @type {number}
         *  @default "10000"
         */
        var maxHeight: Number = 10000,
        /**
         *  Minimum width that this Canvas can be resized to by a user. Actual limit will be maximum
         *   of dragMinWidth and Canvas.minWidth.
         *
         *   Note that a Canvas with overflow:"visible" has an implicit minimize size based on it's
         *   contents.
         *
         *   Note that dragMinWidth affects only user-initiated drag resizes. To set
         *   the minimum width of a Canvas embedded in a Layout, you can set +{minWidth}, or
         *   Layout.minMemberLength to constrain the minimum size along the length axis of all
         *   members of the Layout.
         *  @type {number}
         *  @default "10"
         */
        var dragMinWidth: Number = 10,
        /**
         *  Minimum height that this Canvas can be resized to by a user. See Canvas.dragMinWidth
         *   for details of behavior.
         *  @type {number}
         *  @default "10"
         */
        var dragMinHeight: Number = 10,
        /**
         *  Maximum width that this Canvas can be resized to by a user. Actual limit will be minimum
         *   of dragMaxWidth and Canvas.maxWidth.
         *  @type {number}
         *  @default "10000"
         */
        var dragMaxWidth: Number = 10000,
        /**
         *  Sets maximum height that this Canvas can be resized to by a user. Actual limit will be
         *   minimum of dragMaxHeight and Canvas.maxHeight.
         *  @type {number}
         *  @default "10000"
         */
        var dragMaxHeight: Number = 10000,
        /**
         *  This is an advanced setting. If set to true, when a widget is
         *   Canvas.hide, the widget's handle will be resized such that
         *   it takes up no space, in addition to having its css visibility
         *   property set to "hidden".
         *
         *   In addition to preventing the size of this widget from impacting the
         *   Canvas.getScrollWidth of any parent widget while hidden, this
         *   setting works around a native bug observed in Internet Explorer 10, whereby
         *   an &lt;IFRAME&gt; element with visibility set to hidden can
         *   cause rendering problems, if the HTML loaded by the &lt;IFRAME&gt;
         *   contains a &lt;frameset&gt;. In this case the browser may
         *   refuse to draw other elements at the same coordinates with a lower z-index than
         *   the hidden frame. Setting this property to true works around
         *   this problem for cases where an &lt;IFRAME&gt; containing a
         *   &lt;frameset will be rendered out, for example in an
         *   HTMLFlow with contentsType set to "page".
         *  @type {boolean}
         *  @default false
         */
        var shrinkElementOnHide: Boolean = false,
        /**
         *  If set to true, the widget's parent (if any) will automatically be shown whenever the
         *     widget is shown.
         *  @type {boolean}
         *  @default false
         */
        var autoShowParent: Boolean = false,
        /**
         *  Controls widget visibility when the widget is initialized. See Visibility type for
         *     details.
         *  @type {Visibility}
         *  @default "inherit"
         */
        var visibility:
        /**
         *  The widget visibility will match that of its parent                 (usually visible).
         *  The widget will always be visible whether its parent is                 or not.
         *  The widget will always be hidden even when its parent is                 visible.
         */
        String /* inherit |  visible |  hidden */ = "inherit",
        /**
         *  When this widget is hidden (see Canvas.visibility and Canvas.hide),
         *   should display:none be applied to the Canvas.getOuterElement?
         *
         *   This setting is not supported for general use, but in certain cases, it has been shown
         *   that display:none is a work-around for browser bugs involving burn-through of iframes or
         *   plugins, where the content of the iframe or plugin may still be visible despite the
         *   containing widget being hidden.
         *  @type {boolean}
         *  @default false
         */
        var hideUsingDisplayNone: Boolean = false,
        /**
         *  Whether native drag selection of contained text is allowed within this Canvas.
         *
         *   Note that setting this property to false will not avoid text selection
         *   which is initiated outside this Canvas from continuing into this Canvas, even if text
         *   selection began in another Canvas.
         *  @type {boolean}
         *  @default false
         */
        var canSelectText: Boolean = false,
        /**
         *  The CSS class applied to this widget as a whole.
         *  @deprecated \* In favor or Canvas.styleName as of SmartClient release 5.5
         *  @type {CSSStyleName}
         *  @default "normal"
         */
        var className: String = "normal",
        /**
         *  The CSS class applied to this widget as a whole.
         *  @type {CSSStyleName}
         *  @default "normal"
         */
        var styleName: String = "normal",
        /**
         *  The contents of a canvas or label widget. Any HTML string is acceptable.
         *  @type {HTMLString}
         *  @default "&amp;nbsp;"
         */
        var contents: String = "&amp;nbsp;",
        /**
         *  Dynamic contents allows the contents string to be treated as a simple, but powerful
         *   template. When this attribute is set to true, expressions of the form &#36;{arbitrary JS
         *   here} are replaced by the result of the evaluation of the JS code inside the curly
         *   brackets. This evaluation happens at draw time. If you want to trigger a re-evaluation
         *   of the expressions in the contents string you can call markForRedraw() on the canvas.
         *
         *   You can use this feature to build some simple custom components. For example, let's say
         *   you want to show the value of a Slider in a Canvas somewhere on the screen. You can do
         *   this by observing the valueChanged() method on the slider and calling setContents() on
         *   your canvas with the new string or you can set the contents of the canvas to something
         *   like:
         *
         *   "The slider value is &#36;{sliderInstance.getValue()}."
         *
         *   Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider
         *   and call canvas.markForRedraw() in that observation. This approach is cleaner than
         *   setContents() when the Canvas is aggregating several values or dynamic expressions.
         *   Like so:
         *
         *
         *   Slider.create({
         *     ID: "mySlider"
         *   });
         *
         *   Canvas.create({
         *     ID: "myCanvas",
         *     dynamicContents: true,
         *     contents: "The slider value is &#36;{mySlider.getValue()}."
         *   });
         *
         *   myCanvas.observe(mySlider, "valueChanged",
         *           "observer.markForRedraw()");
         *
         *   You can embed an arbitrary number of dynamic expressions in the contents string. The
         *   search and replace is optimized for speed.
         *
         *   If an error occurs during the evaluation of one of the expressions, a warning is logged
         *   to the ISC Developer Console and the error string is embedded in place of the expected
         *   value in the Canvas.
         *
         *   The value of a function is its return value. The value of any variable is the same as
         *   that returned by its toString() representation.
         *
         *   Inside the evaluation contentext, this points to the canvas instance that
         *   has the dynamicContents string as its contents - in other words the canvas instance on
         *   which the template is declared.
         *  @type {boolean}
         *  @default false
         */
        var dynamicContents: Boolean = false,
        /**
         *  An optional map of name:value parameters that will be available within the scope of the
         *   dynamicContents evaluation. For example - if you have e.g:
         *
         *   Canvas.create({
         *    dynamicContents: true,
         *    dynamicContentsVars: {
         *      name: "Bob"
         *    },
         *    contents: "hello &#36;{name}"
         *   });
         *
         *   The above will create a canvas with contents hello Bob. You can add, remove, and
         *   change values in the dynamicContentsVars object literal, just call
         *   markForRedraw() on the canvas to have the dynamicContents template re-evaluated.
         *
         *   Note that this is always available inside a dynamic contents string and points to
         *   the canvas instance containing the dynamic contents.
         *
         *   Used only if Canvas.dynamicContents : true has been set.
         *  @type {ValueMap}
         *  @default null
         */
        var dynamicContentsVars: dynamic = null,
        /**
         *  Set the CSS Margin, in pixels, for this component. Margin provides blank space outside
         *   of the border.
         *
         *   This property sets the same thickness of margin on every side. Differing per-side
         *   margins can be set in a CSS style and applied via Canvas.styleName.
         *
         *   Note that the specified size of the widget will be the size including the margin
         *   thickness on each side.
         *  @type {number}
         *  @default null
         */
        var margin: Number? = null,
        /**
         *  Set the CSS padding of this component, in pixels. Padding provides space between the
         *   border and the component's contents.
         *
         *   This property sets the same thickness of padding on every side. Differing per-side
         *   padding can be set in a CSS style and applied via Canvas.styleName.
         *
         *   Note that CSS padding does not affect the placement of Canvas.children. To
         *   provide a blank area around children, either use Canvas.margin or use
         *   a Layout as the parent instead, and use properties such as
         *   Layout.layoutMargin to create blank space.
         *  @type {number}
         *  @default null
         */
        var padding: Number? = null,
        /**
         *  Set the CSS border of this component, as a CSS string including border-width,
         *   border-style, and/or color (eg "2px solid blue").
         *
         *   This property applies the same border to all four sides of this component. Different
         *   per-side borders can be set in a CSS style and applied via Canvas.styleName.
         *
         *   If Canvas.isGroup is set to true then border is derived from the
         *   Canvas.groupBorderCSS attribute, not from the explicit border property.
         *  @type {string}
         *  @default null
         */
        var border: String? = null,
        /**
         *  The background color for this widget. It corresponds to the CSS background-color
         *   attribute. You can set this property to an RGB value (e.g. #22AAFF) or a named color
         *   (e.g. red) from a list of browser supported color names.
         *  @type {CSSColor}
         *  @default null
         */
        var backgroundColor: String? = null,
        /**
         *  URL for a background image for this widget (corresponding to the CSS "background-image"
         *   attribute).
         *  @type {SCImgURL}
         *  @default null
         */
        var backgroundImage: String? = null,
        /**
         *  Specifies how the background image should be tiled if this widget
         *   is larger than the image. It corresponds to the CSS background-repeat
         *   attribute.
         *
         *   The default of null means no background-repeat CSS will be
         *   written out. See BackgroundRepeat type for details on other settings.
         *
         *   NOTE: this setting directly sets the CSS property background-repeat but
         *   does not attempt to work around various known bugs with this setting, or lack of support
         *   in IE6. If you need to apply CSS-based workarounds for browser limitations with
         *   this setting, it's best to do so via setting Canvas.styleName.
         *  @type {BackgroundRepeat}
         *  @default null
         */
        var backgroundRepeat:
        /**
         *  Tile the background image horizontally and vertically.
         *  Don't tile the background image at all.
         *  Repeat the background image horizontally but not vertically.
         *  Repeat the background image vertically but not horizontally.
         */
        String? /* repeat |  no-repeat |  repeat-x |  repeat-y */ = null,
        /**
         *  Specifies how the background image should be positioned on the widget.
         *     It corresponds to the CSS background-position attribute. If unset,
         *     no background-position attribute is specified if a background image is
         *     specified.
         *  @type {string}
         *  @default null
         */
        var backgroundPosition: String? = null,
        /**
         *  Default directory for app-specific images, relative to the Page-wide
         *   Page.getAppImgDir.
         *  @type {URL}
         *  @default ""
         */
        var appImgDir: String = "",
        /**
         *  Default directory for skin images (those defined by the class), relative to the
         *   Page-wide Page.getSkinDir.
         *  @type {SCImgURL}
         *  @default "images/"
         */
        var skinImgDir: String = "images/",
        /**
         *  Specifies the cursor image to display when the mouse pointer is
         *     over this widget. It corresponds to the CSS cursor attribute. See Cursor type for
         *     different cursors.
         *
         *     See also Canvas.disabledCursor and Canvas.noDropCursor.
         *  @type {Cursor}
         *  @default "default"
         */
        var cursor:
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
        String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = "default",
        /**
         *  Specifies the cursor image to display when the mouse pointer is
         *     over this widget if this widget is disabled. It corresponds to the CSS cursor
         *     attribute. See Cursor type for different cursors.
         *  @type {Cursor}
         *  @default "default"
         */
        var disabledCursor:
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
        String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = "default",
        /**
         *  Specifies the cursor image to display when the user drags a droppable canvas
         *     over this if it is not a valid drop target for the event and
         *     EventHandler.showNoDropIndicator is true.
         *  @type {Cursor}
         *  @default "not-allowed"
         */
        var noDropCursor:
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
        String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = "not-allowed",
        /**
         *  Renders the widget to be partly transparent. A widget's opacity property may
         *     be set to any number between 0 (transparent) to 100 (opaque).
         *     Null means don't specify opacity directly, 100 is fully opaque.
         *     Note that heavy use of opacity may have a performance impact on some older
         *     browsers.
         *
         *     In older versions of Internet Explorer (Pre IE9 / HTML5), opacity is achieved
         *     through proprietary filters. If
         *     Canvas.neverUseFilters within this application
         *     developers must set Canvas.useOpacityFilter to true for specific components
         *     on which opacity support is required.
         *
         *     Also note that opacity is incompatible
         *     with Canvas.useBackMask.
         *  @type {number}
         *  @default null
         */
        var opacity: Number? = null,
        /**
         *  Controls what happens when the drawn size of the content of a Canvas is either
         *       greater or smaller than the specified size of the Canvas. Similar to the CSS
         *       property overflow, but consistent across browsers. See Overflow type for
         *       details.
         *  @type {Overflow}
         *  @default "visible"
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
        String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = "visible",
        /**
         *  Indicates that this component is able to render itself at multiple possible sizes, in order
         *   to fit into less space when very little space is available, or to display more information
         *   or provide more immediate access to functionality when more space is available.
         *
         *   Unlike simply indicating a flexible size via width:"\*", setting canAdaptWidth
         *   indicates that a component has 2 (or more) different ways of rendering itself with different
         *   discrete sizes, but does not have the ability to use every additional available pixel.
         *
         *   For example, a menu embedded in a toolbar might show as only a fixed-size icon which reveals
         *   menu options when clicked, or if enough space is available, could show all of the menu
         *   options directly in the toolbar. In this example, the menu should either be allocated just
         *   enough space for an icon, or enough space for all options to appear inline; any other
         *   amount of space being allocated is just a waste.
         *
         *   When a component with canAdaptWidth is part of a Layout, Canvas.adaptWidthBy
         *   will be called every time component sizes are being calculated, passing a positive or
         *   negative pixel value:
         *
         *
         *  - a positive pixel value indicates a surplus - all other component's minimum sizes
         *     can be accommodated, including any Canvas.minWidth declared on the
         *     canAdaptWidth component itself
         *
         *  - a negative pixel value indicates that the containing layout is going to be
         *     forced to Overflow (introduce scrollbars, clip content, etc) unless some
         *     component or set of components gives up at least this many pixels
         *
         *
         *   If a non-zero value is returned from adaptWidthBy, this means that the
         *   component is willing to shrink or expand by that many pixels. Returning 0 means that the
         *   component is unable to reduce size further, or for a surplus, cannot make good use of the
         *   surplus space.
         *
         *
         *  - A call to Canvas.adaptWidthBy may surrender as many pixels as desired
         *   (as long as the widget won't drop below its minimum allowed width), no matter whether a
         *   positive (surplus) or negative (overflow) pixel value is supplied, but
         *
         *  - A call to Canvas.adaptWidthBy may not increase its size by more than the number of
         *   offered pixels - so if an overflow is present, it may not increase its size at all.
         *
         *
         *   Note that when the initial width is specified as a stretch size (e.g. "\*"), then after
         *   Canvas.adaptWidthBy is called, the Framework will stretch (but not shrink) the
         *   member like any other stretch-size Layout member, but the unadaptedWidth
         *   argument will always reflect the unstretched width requested by the previous call to
         *   Canvas.adaptWidthBy. This behavior may be disabled by specifying the initial
         *   width as a number, or leaving it unspecified.
         *
         *   Behavior is slightly different for overflow: "visible" members - in this case the
         *   unadaptedWidth passed in will reflect the current visible width of the
         *   member, rather than the last width requested by the previous call to
         *   Canvas.adaptWidthBy or the specified width (on the first call). However, note that the
         *   visible length will match your requested width unless the member is actually overflowed.
         *   Stretch sizing is not supported for adaptive-width members with overflow: "visible".
         *
         *   Caution: you must either determine the current size of the canvas by maintaining your own
         *   internal state, or use the unadaptedWidth parameter passed to
         *   Canvas.adaptWidthBy. You must not call Canvas.getWidth or Canvas.getVisibleWidth
         *   on the canvas itself inside Canvas.adaptWidthBy as the size is in the processing of
         *   being determined, but you may draw children or call Canvas.getVisibleWidth on them, as
         *   we guarantee that the adaptive-width canvas is drawn before the first call to
         *   Canvas.adaptWidthBy. An example of drawing children in Canvas.adaptWidthBy to
         *   compute overall width may be seen in the
         *   ${isc.DocUtils.linkForExampleId('inlinedMenuMobileSample', 'Inlined Menu Mobile Sample')}.
         *
         *   Note that reasonable settings for Canvas.minWidth should be applied to all other
         *   flexible-sized members of a layout where a canAdaptWidth component appears,
         *   because when too little space is available, a canAdaptWidth component will
         *   absorb all available space until minimums for other components are hit (or the
         *   canAdaptWidth component reaches its maximum size). If more than one
         *   canAdaptWidth component is present, Canvas.adaptiveWidthPriority to give priority
         *   to a particular component when allocating space.
         *
         *   All of the above behaviors are exactly the same for height, using
         *   Canvas.canAdaptHeight and Canvas.adaptHeightBy.
         *  @type {boolean}
         *  @default null
         */
        var canAdaptWidth: Boolean? = null,
        /**
         *  See Canvas.canAdaptWidth.
         *  @type {boolean}
         *  @default null
         */
        var canAdaptHeight: Boolean? = null,
        /**
         *  If multiple widgets in the same Layout have Canvas.canAdaptWidth,
         *   adaptiveWidthPriority can be set to indicate which of the components should be
         *   given priority access to space.
         *
         *   The widget with the highest priority setting will be offered surplus space first, and asked
         *   to give up space last. Lack of a priority setting is treated as zero. Any adaptive widgets
         *   with the same priority setting will be asked to give up or release space according to their
         *   order in Layout.members.
         *  @type {Integer}
         *  @default null
         */
        var adaptiveWidthPriority: Number? = null,
        /**
         *  See Canvas.adaptiveWidthPriority.
         *  @type {Integer}
         *  @default null
         */
        var adaptiveHeightPriority: Number? = null,
        /**
         *  Whether to use the browser's native scrollbars or SmartClient-based scrollbars.
         *
         *   SmartClient-based scrollbars are skinnable, giving you complete control over look and
         *   feel. SmartClient-based scrollbars also enable some interactions not possible with
         *   native scrollbars, such as ListGrid.fixedRecordHeights
         *   in grids in combination with ListGrid.dataPageSize.
         *
         *   Native browser scrollbars are slightly faster simply because there are less SmartClient
         *   components that need to be created, drawn and updated. Each visible SmartClient-based
         *   scrollbar on the screen has roughly the impact of two StretchImgButtons.
         *
         *   SmartClient is always aware of the size of the scrollbar, regardless of whether native
         *   or custom scrollbars are used, and regardless of what operating system and/or operating
         *   system "theme" or "skin" is in use. This means SmartClient will correctly report the
         *   Canvas.getViewportHeight, that is, the interior area of the
         *   widget excluding space taken by scrollbars, which is key for exactly filling a component
         *   with content without creating unnecessary scrolling.
         *
         *   The showCustomScrollbars setting is typically overridden in load_skin.js in
         *   order to change the default for all SmartClient components at once.
         *   This may be achieved via the static Canvas.setShowCustomScrollbars method or
         *   via a simple addProperties block, like so:
         *
         *     isc.Canvas.addProperties({ showCustomScrollbars:false });
         *
         *
         *   On Browser.isTouch, custom scrollbars are disabled in favor of enabling
         *   native touch scrolling if available. However, custom scrollbars and native touch
         *   scrolling can be enabled for the component by setting Canvas.alwaysShowScrollbars
         *   to true.
         *  @type {boolean}
         *  @default true
         */
        var showCustomScrollbars: Boolean = true,
        /**
         *  Whether this canvas should receive eventHandling from its scrollbars,
         *   which are Canvas.peers. Normally, a canvas only gets bubbled events from
         *   its Canvas.children.
         *
         *   Note that this property only has an impact if Canvas.showCustomScrollbars is true.
         *  @type {boolean}
         *  @default true
         */
        var receiveScrollbarEvents: Boolean = true,
        /**
         *  On Browser.isTouch that support native touch scrolling, if
         *   Canvas.showCustomScrollbars is true and touch
         *   scrolling has not been disabled by the Canvas.useTouchScrolling and/or
         *   Canvas.disableTouchScrollingForDrag settings, should custom scrollbars and
         *   native touch scrolling be enabled for this component? If false or unset,
         *   then only native touch scrolling will be enabled. If true, then both scrolling
         *   mechanisms will be enabled.
         *
         *   NOTE: Because native touch scrolling (also called momentum scrolling)
         *   is computationally intensive, some mobile browsers implement an optimization where the state
         *   of the DOM for the element being scrolled will be frozen or partially frozen during
         *   the scroll animation. This results in a delay between when the scroll position reaches
         *   a certain point in the animation and when the positions of the custom scrollbar thumbs
         *   are updated to reflect that scroll position.
         *  @type {boolean}
         *  @default null
         */
        var alwaysShowScrollbars: Boolean? = null,
        /**
         *  On Browser.isTouch, if this Canvas can be scrolled,
         *   should touch-dragging the content area result in scrolling? Set to false
         *   if touch-dragging should not cause scrolling. Note that setting to false
         *   enables the use of Canvas.showCustomScrollbars on touch devices.
         *
         *   useTouchScrolling can default to false if
         *   Canvas.disableTouchScrollingForDrag is true
         *   and various built-in drag operations are enabled that normally interfere with touch scrolling
         *   (e.g. ListGrid.canDragSelect and ListGrid.canReorderRecords).
         *
         *   When touch scrolling is disabled, it can be difficult to interact with parts of the
         *   custom scrollbars at their default size of 16 pixels. In touch browsers, any touch 8px
         *   before the thumb of a Scrollbar will be mapped to the thumb, but
         *   the other parts of the scrollbar do not have a similar tolerance applied. The width of
         *   the custom scrollbars can be increased by setting the Canvas.scrollbarSize to a
         *   larger value, but note that when skinning, changing the
         *   scrollbarSize may cause tiling of certain images and backgrounds that make
         *   up the custom scrollbar. This can be fixed for a component by creating it with
         *   Canvas.scrollbarConstructor set to "Scrollbar"&mdash;a basic scrollbar class that
         *   does not employ spriting.
         *  @type {boolean}
         *  @default null
         */
        var useTouchScrolling: Boolean? = null,
        /**
         *  Disables Canvas.useTouchScrolling whenever a built-in drag operation has been enabled which is
         *   known to be non-functional if touch scrolling is enabled. Default behavior is to leave touch
         *   scrolling enabled even if it makes other enabled drag operations non-functional, since any
         *   accessibility application must provide an alternative way to perform
         *   drag and drop operations anyway.
         *
         *   disableTouchScrollingForDrag exists so that applications can change the default
         *   setting on a per-component basis (via
         *   Class.changeDefaults),
         *   in order to make a system-wide or
         *   per-component-type decision about whether to favor touch scrolling vs retaining the ability to
         *   drag and drop via finger drags, instead of having to set useTouchScrolling on each
         *   individual instance.
         *
         *   See the mobileDevelopment for more background
         *   information.
         *  @type {boolean}
         *  @default null
         */
        var disableTouchScrollingForDrag: Boolean? = null,
        /**
         *  How thick should we make the scrollbars for this canvas. This only applies if
         *   Canvas.showCustomScrollbars is true.
         *
         *   NOTE: When skinning, changing the
         *   scrollbarSize may cause tiling of certain images and backgrounds that make
         *   up the custom scrollbar. This can be fixed for a component by creating it with
         *   Canvas.scrollbarConstructor set to "Scrollbar"&mdash;a basic scrollbar class
         *   that does not employ spriting.
         *  @type {number}
         *  @default "16"
         */
        var scrollbarSize: Number = 16,
        /**
         *  The class that will be used to create custom scrollbars for this component. Set this
         *   attribute to a Scrollbar subclass with e.g. a different skinImgDir, to customize scrollbar
         *   appearance for this component only.
         *
         *   When skinning and supported by the skin, the default
         *   scrollbarConstructor is changed to a different scrollbar class which handles
         *   scrollbar spriting. Spriting of the scrollbars of an individual component can therefore
         *   be disabled by creating the component with scrollbarConstructor set to the
         *   "Scrollbar" class. "Scrollbar" is a basic scrollbar class that does not employ spriting.
         *  @type {string}
         *  @default "Scrollbar"
         */
        var scrollbarConstructor: String = "Scrollbar",
        /**
         *  If set to true, the widget will be disabled. A widget is only considered enabled
         *   if it is individually enabled and all parents above it in the containment hierarchy
         *   are enabled. This allows you to enable or disable all components of a complex
         *   nested widget by enabling or disabling the top-level parent only.
         *  @type {boolean}
         *  @default false
         */
        var disabled: Boolean = false,
        /**
         *  If set to true, this widget will be enabled, if set to false, or null, this
         *   widget will be disabled.
         *  @deprecated \* As of SmartClient version 5.5 this property has been deprecated. The  Canvas.disabled property will be used to govern enabled/disabled state instead
         *   if this.enabled has not been changed from its default value.
         *  @type {boolean}
         *  @default "unset"
         */
        var enabled: Boolean = false,
        /**
         *  Criteria to be evaluated to determine whether this Canvas should be visible. Re-evaluated
         *   whenever data in the Canvas.ruleScope changes.
         *
         *   A basic criteria uses textMatchStyle:"exact". When specified in
         *   componentXML this property allows
         *   xmlCriteriaShorthand for defining criteria.
         *  @type {AdvancedCriteria}
         *  @default null
         */
        var visibleWhen: AdvancedCriteria? = null,
        /**
         *  Criteria to be evaluated to determine whether this Canvas should be enabled. Re-evaluated
         *   whenever data in the Canvas.ruleScope changes.
         *
         *   A basic criteria uses textMatchStyle:"exact". When specified in
         *   componentXML this property allows
         *   xmlCriteriaShorthand for defining criteria.
         *  @type {AdvancedCriteria}
         *  @default null
         */
        var enableWhen: AdvancedCriteria? = null,
        /**
         *  Should this element be redrawn in response to a resize?
         *
         *   Should be set to true for components whose Canvas.getInnerHTML will not
         *   automatically reflow to fit the component's new size.
         *  @type {boolean}
         *  @default null
         */
        var redrawOnResize: Boolean? = null,
        /**
         *  Can this widget be allowed to become the target of keyboard events?
         *
         *   If canFocus is unset (the default), only scrollable widgets with visible scrollbars are
         *   focusable, to allow for keyboard scrolling.
         *
         *   A widget normally receives focus by being clicked on or tabbed to.
         *  @type {boolean}
         *  @default null
         */
        var canFocus: Boolean? = null,
        /**
         *  If specified this governs the tabIndex of the widget in the page's tab order.
         *   Setting this value to -1 will ensure the canvas does not show up
         *   in the page's tab order, though if Canvas.canFocus is true, the user
         *   may still give it keyboard focus by clicking on the widget directly.
         *
         *   By default SmartClient auto-assigns tab-indices, ensuring focusable widgets
         *   are reachable by tabbing in an intuitive order based on widget hierarchy and
         *   draw order. Specifying an explicit tab index means a widget will not participate
         *   in this automatic tab position allocation and is typically not recommended except
         *   for very simple cases.
         *
         *   For more information on automatic tab index assignment, including recommended
         *   approaches for customizing tab order assignation, see the tabOrderOverview.
         *   Developers may call Canvas.clearExplicitTabIndex to clear any explicitly
         *   assigned tab index, and have the widget participate in automatic tab position allocation.
         *
         *   canvas.tabIndex cannot be set to greater than
         *   Canvas.TAB_INDEX_FLOOR - as we reserve the values above this range for
         *   auto-assigned tab-indices.
         *  @type {number}
         *  @default null
         */
        var tabIndex: Number? = null,
        /**
         *  If specified this governs the HTML accessKey for the widget.
         *
         *   This should be set to a character - when a user hits the html accessKey modifier for
         *   the browser, plus this character, focus will be given to the widget in question.
         *   The accessKey modifier can vary by browser and platform.
         *
         *   The following list of default behavior is for reference only, developers should also
         *   consult browser documentation for additional information.
         *
         *
         *  - Internet Explorer (all platforms): Alt + accessKey
         *
         *  - Mozilla Firefox (Windows, Unix): Alt+Shift + accessKey
         *
         *  - Mozilla Firefox (Mac): Ctrl+Opt + accessKey
         *
         *  - Chrome and Safari (Windows, Unix): Alt + accessKey
         *
         *  - Chrome and Safari (Mac): Ctrl+Opt + accessKey
         *
         *  @type {string}
         *  @default null
         */
        var accessKey: String? = null,
        /**
         *  Context menu to show for this object, an instance of the Menu widget.
         *
         *   Note: if Canvas.destroy is called on a canvas, any specified context menu is
         *   not automatically destroyed as well. This is in contrast to MenuButtons which
         *   automatically destroy their specified MenuButton.menu by default. The behavior
         *   is intentional as context menus are commonly reused across components.
         *  @type {Menu}
         *  @default null
         */
        var contextMenu: Menu? = null,
        /**
         *  Default class used to construct menus created by this component, including context menus.
         *  @type {SCClassName}
         *  @default "Menu"
         */
        var menuConstructor: String = "Menu",
        /**
         *  Prompt displayed in hover canvas if Canvas.showHover is true.
         *  @type {HTMLString}
         *  @default null
         */
        var prompt: String? = null,
        /**
         *  If set, native HTML5 drag and drop will be used for all drags initiated on this widget
         *   (on browsers where this is supported).
         *
         *   When using native HTML5 drags, the same series of events fires as for a normal drag
         *   (Canvas.dragStart, Canvas.dropMove, etc.), and the Canvas.dragType / Canvas.dropTypes
         *   system works. Canvas.dragAppearance is not supported; however,
         *   basic customization of the browser's tracker image is supported in certain browsers via
         *   the EventHandler.setDragTrackerImage API.
         *
         *   The primary difference with a native drag is that it can be cross-frame; that is, the
         *   user can drag out of the current browser window and drop into a different window or tab.
         *
         *   To provide information that will be available to a foreign frame, use
         *   EventHandler.setNativeDragData. This API must be called when the Canvas.dragStart
         *   event fires, and will not work if called at any other time.
         *
         *   However, due to browser bugs and/or browser-imposed limitations, the information provided to
         *   setNativeDragData cannot be accessed in the foreign frame until the actual drop
         *   occurs (mouse button released). This means drop eligibility cannot be determined dynamically
         *   based on the dragged data; instead, eligibility can only be determined based on the
         *   Canvas.dragType / Canvas.dropTypes system. For this reason, a Canvas.dragType must
         *   be set on the source of a drag.
         *
         *   NOTE: Although Internet Explorer 10+ and Edge support a subset of the
         *   HTML5 drag and drop standard,
         *   native drag and drop is disabled in IE and Edge because cross-window drags&mdash;the
         *   primary purpose of this API&mdash;are not possible.
         *  @type {boolean}
         *  @default null
         */
        var useNativeDrag: Boolean? = null,
        /**
         *  Indicates whether this widget can initiate custom drag-and-drop operations (other than
         *   reposition or resize). Normally Canvas.canDragReposition or Canvas.canDragResize would
         *   be used instead of this property.
         *
         *   Note: this property may be manipulated by higher-level dragging semantics.
         *
         *   If Canvas.useNativeDrag is true and this widget has been drawn, then this widget must be
         *   Canvas.redraw in order for a change of the value of this attribute to take effect.
         *  @type {boolean}
         *  @default false
         */
        var canDrag: Boolean = false,
        /**
         *  Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
         *  @type {number}
         *  @default "5"
         */
        var dragStartDistance: Number = 5,
        /**
         *  If this Canvas is canAcceptDrop:true, when the user drags a droppable widget over
         *     an edge of the widget, should we scroll to show the rest of the widget's content?
         *     Returned from canvas.shouldDragScroll() if there are scrollbars.
         *  @type {boolean}
         *  @default true
         */
        var canDragScroll: Boolean = true,
        /**
         *  If this widget supports drag-scrolling, This property specifies how many ms the
         *     user must hover over the drag-scroll threshold before scrolling begins.
         *  @type {number}
         *  @default "100"
         */
        var dragScrollDelay: Number = 100,
        /**
         *  This indicates how the system will test for droppable targets: either by intersection
         *   with the mouse or intersection with the rectangle of the dragMoveTarget.
         *  @type {DragIntersectStyle}
         *  @default "mouse"
         */
        var dragIntersectStyle:
        /**
         *  Look for drop targets that are under the current mouse cursor position.
         *  Look for drop targets by intersection of the entire rect of the drag        target with the droppable target.
         */
        String /* mouse |  rect */ = "mouse",
        /**
         *  Indicates whether this widget can be moved by a user of your application by simply
         *     dragging with the mouse.
         *  @type {boolean}
         *  @default false
         */
        var canDragReposition: Boolean = false,
        /**
         *  Cursor to switch to if the mouse is over a widget that is drag repositionable.
         *  @type {Cursor}
         *  @default "move"
         */
        var dragRepositionCursor:
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
        String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = "move",
        /**
         *  Indicates whether this widget can be resized by dragging on the edges and/or corners of
         *     the widget with the mouse.
         *  @type {boolean}
         *  @default false
         */
        var canDragResize: Boolean = false,
        /**
         *  If Canvas.canDragResize is true, this property specifies the conditions for when
         *   proportional resizing is used. The default is "none"
         *
         *   , which means that proportional resizing is disabled.
         *  @type {ProportionalResizeMode}
         *  @default "none"
         */
        var proportionalResizing:
        /**
         *  proportional resizing is never used
         *  proportional resizing is always used
         *  proportional resize is off by default, but holding down one of the Canvas.proportionalResizeModifiers turns proportional resize on for a given
         *   resize interaction
         *  proportional resize is on by default, but holding down one of the Canvas.proportionalResizeModifiers turns proportional resize off for a given
         *   resize interaction
         */
        String /* none |  always |  modifier |  modifierOff */ = "none",
        /**
         *  If Canvas.proportionalResizing is set to "modifier"
         *
         *   or "modifierOff"
         *
         *   then proportional resizing of the widget is activated or deactivated, respectively,
         *   whenever at least one key in this set of modifier keys is pressed.
         *
         *   The keys allowed in this set are: "Alt", "Ctrl", and "Shift". If this set
         *   of keys is empty then proportional resizing is always used if
         *   proportionalResizing is "modifier"
         *   and is never used if
         *   proportionalResizing is "modifierOff"
         *   .
         *  @type {Array<Partial<KeyName>>}
         *  @default "["Shift"]"
         */
        var proportionalResizeModifiers: Array<dynamic> = arrayOf("Shift"),
        /**
         *  When drag resizing is enabled via Canvas.canDragResize, restricts resizes to only
         *   certain edges or corners.
         *
         *   The default of null indicates the widget can be resized from any corner or edge (if
         *   canDragResize is true).
         *
         *   To restrict resizing to only certain corners, set resizeFrom to an Array of
         *   EdgeNames.
         *  @type {Array<Partial<EdgeName>>}
         *  @default null
         */
        var resizeFrom: Array<dynamic>? = null,
        /**
         *  This flag controls whether we register the component as a maskable item with the
         *   EventHandler. If enabled, a backmask will be automatically created for the
         *   dragMoveTarget on the fly to avoid burnthrough e.g. by plugins or frames.
         *
         *   Note that this property will be defaulted to false unless the canvas contains an
         *   IFrame, in which case it will be defaulted to true.
         *
         *   The Canvas.dragMaskType property controls what kind of mask is used in case
         *   useDragMask is enabled.
         *  @type {boolean}
         *  @default null
         */
        var useDragMask: Boolean? = null,
        /**
         *  This property controls what kind of mask is used in case Canvas.useDragMask is
         *   enabled.
         *  @type {DragMaskType}
         *  @default "div"
         */
        var dragMaskType:
        /**
         *  creates an element with ordinary HTML content that will block events
         *  creates an iframe with empty content
         *  hides the contents of this widget temporarily
         *  no mask
         */
        String /* div |  iframe |  hide |  none */ = "div",
        /**
         *  Will this Canvas fire hover events when the user hovers over it, or one of its children?
         *  @type {boolean}
         *  @default null
         */
        var canHover: Boolean? = null,
        /**
         *  If this.canHover is true, how long should the mouse be kept over this
         *   widget before the hover event is fired
         *  @type {number}
         *  @default "300"
         */
        var hoverDelay: Number = 300,
        /**
         *  If this.canHover is true, should we show the global hover canvas by default
         *   when the user hovers over this canvas?
         *  @type {boolean}
         *  @default true
         */
        var showHover: Boolean = true,
        /**
         *  If Canvas.showHover is true, this property can be used to customize
         *   the width of the hover canvas shown. See also Canvas.hoverAutoFitWidth and
         *   Canvas.hoverAutoFitMaxWidth.
         *  @type {Integer}
         *  @default "1"
         */
        var hoverWidth: Number = 1,
        /**
         *  if Canvas.showHover is true, this property will cause the specified
         *   Canvas.hoverWidth to be treated as a minimum width for the hover. If the
         *   hover content string exceeds this, the hover will expand to accomodate it
         *   up to Canvas.hoverAutoFitMaxWidth (without the text wrapping).
         *
         *   Using this settings differs from simply disabling wrapping via
         *   Canvas.hoverWrap as the content will wrap if the
         *   Canvas.hoverAutoFitMaxWidth is exceeded.
         *  @type {boolean}
         *  @default true
         */
        var hoverAutoFitWidth: Boolean = true,
        /**
         *  Maximum auto-fit width for a hover if Canvas.hoverAutoFitWidth is
         *   enabled. May be specified as a pixel value, or a percentage of page width.
         *  @type {number | string}
         *  @default "100"
         */
        var hoverAutoFitMaxWidth: dynamic = 100,
        /**
         *  If this.showHover is true, this property can be used to customize the
         *   height of the hover canvas shown.
         *  @type {Integer}
         *  @default null
         */
        var hoverHeight: Number? = null,
        /**
         *  If this.showHover is true, this property can be used to customize the
         *   alignment of content in the hover canvas.
         *  @type {Alignment}
         *  @default null
         */
        var hoverAlign:
        /**
         *  Center within container.
         *  Stick to left side of container.
         *  Stick to right side of container.
         */
        String? /* center |  left |  right */ = null,
        /**
         *  If this.showHover is true, this property can be used to customize the
         *   vertical alignment of content in the hover canvas.
         *  @type {VerticalAlignment}
         *  @default null
         */
        var hoverVAlign:
        /**
         *  At the top of the container
         *  Center within container.
         *  At the bottom of the container
         */
        String? /* top |  center |  bottom */ = null,
        /**
         *  If this.showHover is true, this property can be used to customize the
         *   whether content in the hover canvas is displayed in a single line, or wraps.
         *
         *   Note that if developers wish to have hovers expand horizontally to fit their
         *   text without wrapping \*up to some maximum\*, and then wrap rather than exceeding
         *   that maximum, the Canvas.hoverAutoFitWidth and Canvas.hoverAutoFitMaxWidth attributes
         *   may be used instead of simply setting hoverWrap to false.
         *  @type {boolean}
         *  @default null
         */
        var hoverWrap: Boolean? = null,
        /**
         *  If this.showHover is true, this property can be used to specify the
         *   css style to apply to the hover canvas.
         *  @type {CSSStyleName}
         *  @default null
         */
        var hoverStyle: String? = null,
        /**
         *  If this.showHover is true, should the hover canvas be shown with opacity
         *   other than 100?
         *  @type {number}
         *  @default null
         */
        var hoverOpacity: Number? = null,
        /**
         *  If this.showHover is true, should this widget's hover canvas be moved with
         *   the mouse while visible?
         *  @type {boolean}
         *  @default null
         */
        var hoverMoveWithMouse: Boolean? = null,
        /**
         *  If this.showHover is true and Canvas.getHoverComponent is implemented, should
         *   the hoverCanvas returned from it be automatically destroyed when it is hidden?
         *
         *   The default of null indicates that the component will be automatically
         *   destroyed. Set to false to prevent this.
         *  @type {boolean}
         *  @default null
         */
        var hoverAutoDestroy: Boolean? = null,
        /**
         *  How far into the edge of an object do we consider the "edge" for drag resize purposes?
         *  @type {number}
         *  @default "5"
         */
        var edgeMarginSize: Number = 5,
        /**
         *  If the widget has drag resize configured on one or more of it's edges, and the
         *   edgeMarginSize is large enough that the remaining space is less than
         *   minNonEdgeSize, the edgeMarginSize will be reduced such that the non-edge
         *   part of the widget is at least 1/3 of the total space (with two draggable edges) or half
         *   of it (with one draggable edge).
         *  @type {Integer}
         *  @default "0"
         */
        var minNonEdgeSize: Number = 0,
        /**
         *  Cursor to use when over each edge of a Canvas that is drag resizable.
         *
         *   To disable drag resize cursors, set the edgeCursorMap property to null.
         *  @type {object}
         *  @default "{...}"
         */
        // var edgeCursorMap: dynamic = definedExternally,
        /**
         *  Constrains drag-resizing and drag-repositioning of this canvas to either the rect of its
         *   parent (if set to true) or an arbitrary rect based on its parent (if set to a
         *   [Left,Top,Width,Height] rect array). In the latter mode you may use negative offsets
         *   for left/top and a width/height greater than the visible or scroll width of the parent
         *   to allow positioning beyond the confines of the parent.
         *
         *   If this canvas has no parent, constrains dragging to within the browser window.
         *
         *   Affects target and outline dragAppearance, not tracker.
         *
         *   Note: keepInParentRect affects only user drag interactions, not programmatic moves.
         *
         *   Example use cases:
         *   keepInParentRect: true - confine to parent
         *   keepInParentRect: [0, 0, 500, 500] - confine to top left 500x500 region within parent
         *   keepInParentRect: [0, 0, 10000, 10000] - in combination with
         *   overflow: "auto", confine to parent, but allow moving off the right and bottom of the
         *   parent to force scrolling (and hence enlarge the scrollWidth of the parent).
         *  @type {boolean | Array<Partial<Integer>>}
         *  @default null
         */
        var keepInParentRect: dynamic = null,
        /**
         *  Visual appearance to show when the object is being dragged. May be overridden for
         *   dragResize or dragReposition events via Canvas.dragResizeAppearance
         *   and Canvas.dragRepositionAppearance.
         *  @type {DragAppearance}
         *  @default "outline"
         */
        var dragAppearance:
        /**
         *  No default drag appearance is indicated. Your custom dragging routines should
         *     implement some behavior that indicates that the user is in a dragging situation,
         *     and where the mouse is.
         *  A "drag tracker" object is automatically shown and moved around with the
         *     mouse. This is generally set to an icon that represents what is being dragged. The
         *     default tracker is a 10 pixel black square, but you can customize this icon. This
         *     dragAppearance is not recommended for use with drag resizing or drag moving.
         *  The target object is actually moved, resized, etc. in real time. This is
         *     recommended for drag repositioning, but not for drag resizing of complex objects.
         *  An outline the size of the target object is moved, resized, etc. with the
         *     mouse. This is recommended for drag resizing, especially for objects that take a
         *     significant amount of time to draw.
         */
        String /* none |  tracker |  target |  outline */ = "outline",
        /**
         *  If Canvas.canDragResize is true, this attributes specifies the visual appearance
         *   to show during drag resize. If unset Canvas.dragAppearance will be used.
         *  @type {DragAppearance}
         *  @default null
         */
        var dragResizeAppearance:
        /**
         *  No default drag appearance is indicated. Your custom dragging routines should
         *     implement some behavior that indicates that the user is in a dragging situation,
         *     and where the mouse is.
         *  A "drag tracker" object is automatically shown and moved around with the
         *     mouse. This is generally set to an icon that represents what is being dragged. The
         *     default tracker is a 10 pixel black square, but you can customize this icon. This
         *     dragAppearance is not recommended for use with drag resizing or drag moving.
         *  The target object is actually moved, resized, etc. in real time. This is
         *     recommended for drag repositioning, but not for drag resizing of complex objects.
         *  An outline the size of the target object is moved, resized, etc. with the
         *     mouse. This is recommended for drag resizing, especially for objects that take a
         *     significant amount of time to draw.
         */
        String? /* none |  tracker |  target |  outline */ = null,
        /**
         *  If Canvas.canDragReposition is true, this attributes specifies the visual appearance
         *   to show during drag reposition. If unset Canvas.dragAppearance will be used.
         *  @type {DragAppearance}
         *  @default null
         */
        var dragRepositionAppearance:
        /**
         *  No default drag appearance is indicated. Your custom dragging routines should
         *     implement some behavior that indicates that the user is in a dragging situation,
         *     and where the mouse is.
         *  A "drag tracker" object is automatically shown and moved around with the
         *     mouse. This is generally set to an icon that represents what is being dragged. The
         *     default tracker is a 10 pixel black square, but you can customize this icon. This
         *     dragAppearance is not recommended for use with drag resizing or drag moving.
         *  The target object is actually moved, resized, etc. in real time. This is
         *     recommended for drag repositioning, but not for drag resizing of complex objects.
         *  An outline the size of the target object is moved, resized, etc. with the
         *     mouse. This is recommended for drag resizing, especially for objects that take a
         *     significant amount of time to draw.
         */
        String? /* none |  tracker |  target |  outline */ = null,
        /**
         *  Sets a dragType for this widget used, to be compared to
         *   Canvas.dropTypes on possible drop target widgets. See
         *   Canvas.dropTypes for a full explanation.
         *  @type {string}
         *  @default null
         */
        var dragType: String? = null,
        /**
         *  When a drag and drop interaction occurs, if a Canvas.dragType is
         *   configured on the source widget, it is compared to the dropTypes configured
         *   on the target widget, and a drop is only allowed if the dragType is listed
         *   in the target widget's dropTypes array.
         *
         *   The default setting means any dragType is eligible for dropping on this
         *   widget, including no dragType setting.
         *
         *   See also Canvas.willAcceptDrop for dynamic determination of drop eligibility.
         *  @type {Array<Partial<string>> | string}
         *  @default "\*\*anything\*\*"
         */
        var dropTypes: dynamic = "\\*\\*anything\\*\\*",
        /**
         *  A different widget that should be actually dragged when dragging initiates on this
         *   widget. One example of this is to have a child widget that drags its parent, as with a
         *   drag box. Because the parent automatically repositions its children, setting the drag
         *   target of the child to the parent and then dragging the child will result in both
         *   widgets being moved.
         *   Valid dragTarget values are:
         *   - null (default) [this widget is its own drag target]
         *   - another widget, or widget ID
         *   - "parent" drag target is this widget's
         *    Canvas.getParentCanvas
         *   - "top" drag target is this widget's
         *    Canvas.topElement
         *  @type {Canvas | string}
         *  @default null
         */
        var dragTarget: dynamic = null,
        /**
         *  When this widget is dragged, if its dragAppearance is "target", should
         *   we show a shadow behind the canvas during the drag.
         *  @type {boolean}
         *  @default null
         */
        var showDragShadow: Boolean? = null,
        /**
         *  If this widget has dragAppearance "target", this value specifies the
         *   opacity to render the target while it is being dragged. A null value implies we do
         *   not modify the opacity.
         *  @type {Integer}
         *  @default null
         */
        var dragOpacity: Number? = null,
        /**
         *  Indicates that this object can be dropped on top of other widgets. Only valid if
         *   canDrag or canDragReposition is true.
         *  @type {boolean}
         *  @default false
         */
        var canDrop: Boolean = false,
        /**
         *  Indicates that this object can receive dropped widgets (i.e. other widgets can be
         *   dropped on top of it).
         *  @type {boolean}
         *  @default false
         */
        var canAcceptDrop: Boolean = false,
        /**
         *  When explicitly set to false, disallows drop before this member in the Layout.
         *  @type {boolean}
         *  @default null
         */
        var canDropBefore: Boolean? = null,
        /**
         *  Amount of time (in milliseconds) before mouseStillDown events start to be fired
         *   repeatedly for this canvas. See Canvas.mouseStillDown for details.
         *  @type {Integer}
         *  @default "400"
         */
        var mouseStillDownInitialDelay: Number = 400,
        /**
         *  Amount of time (in milliseconds) between repeated 'mouseStillDown' events for this
         *   canvas. See Canvas.mouseStillDown for details.
         *  @type {Integer}
         *  @default "100"
         */
        var mouseStillDownDelay: Number = 100,
        /**
         *  Amount of time (in milliseconds) between which two clicks are considered a single click
         *  @type {Integer}
         *  @default "250"
         */
        var doubleClickDelay: Number = 250,
        /**
         *  If true, this canvas will receive all mouse-clicks as single Canvas.click
         *   events rather than as Canvas.doubleClick events.
         *  @type {boolean}
         *  @default null
         */
        var noDoubleClicks: Boolean? = null,
        /**
         *  In earlier versions of Internet Explorer (pre IE9), a native limitation
         *   exists whereby if HTML elements are
         *   overlapping on the page, certain elements can appear to "burn through"
         *   elements in the same position with a higher z-index.
         *   Specific cases in which this have been observed include Applets,
         *   &lt;IFRAME&gt; elements, and for
         *   older versions of IE, native &lt;SELECT&gt; items.
         *
         *   The backMask is a workaround for this issue. If useBackMask is
         *   set to true, the component will render an empty &lt;IFRAME&gt; element
         *   behind the canvas, which prevents this effect in all known cases.
         *
         *   Has no effect in other browsers.
         *  @type {boolean}
         *  @default false
         */
        var useBackMask: Boolean = false,
        /**
         *  If this canvas has its size specified as a percentage, this property allows the user to
         *   explicitly designate another canvas upon which sizing will be based.
         *
         *   If unset percentage sizing is based on
         *   - the Canvas.getMasterCanvas if there is one and
         *    Canvas.snapTo is set,
         *   - otherwise on the amount of space available in this widget's parent canvas, if this is
         *    a child of some other widget
         *   - otherwise the page size.
         *  @type {Canvas}
         *  @default null
         */
        var percentSource: Canvas? = null,
        /**
         *  Governs the model to be used when sizing canvases with percentage width or height, or
         *   positioning widgets with a specified Canvas.snapTo.
         *
         *   Only affects widgets with a a specified Canvas.percentSource, or
         *   widgets that have Canvas.snapTo set and are peers of some
         *   Canvas.getMasterCanvas.
         *
         *   Determines whether the coordinates used for sizing (for percentage sized widgets) and
         *   positioning (if snapTo is set) should be relative to the visible size or the
         *   viewport size of the percentSource or Canvas.getMasterCanvas widget.
         *  @type {PercentBoxModel}
         *  @default "visible"
         */
        var percentBox:
        /**
         *  use coordinates relative to the {Canvas.getVisibleHeight,visibleHeight} and width of the other canvas
         *  use coordinates relative to the {Canvas.getViewportHeight,viewportHeight} and width of the other canvas
         */
        String /* visible |  viewport */ = "visible",
        /**
         *  Position this widget such that it is aligned with ("snapped to") an edge of its
         *   Canvas.getMasterCanvas (if specified), or its
         *   Canvas.getParentCanvas.
         *
         *   Note that this property also impacts the sizing of this widget. If this widgets size
         *   is specified as a percent value, and has no explicit
         *   Canvas.percentSource, sizing will be calculated based on the size of the
         *   Canvas.getMasterCanvas when snapTo is set.
         *
         *   Possible values: BR, BL, TR, TL, R, L, B, T, C where B=Bottom, T=Top, L=Left, R=right
         *   and C=center
         *
         *   Standard snapTo behavior will attach the outer edge of the widget to the parent or master
         *   element - for example setting snapTo to "B" would align the
         *   bottom edge of this component with the bottom edge of the master or parent element
         *   (and center this component horizontally over its master or parent element).
         *   Canvas.snapEdge can be specified to change this behavior allowing the developer
         *   to, for example, align the top edge of this component with the bottom edge of its
         *   Canvas.getMasterCanvas.
         *
         *   Canvas.snapOffsetLeft and Canvas.snapOffsetTop may also be specified to
         *   offset the element from exact snapTo alignment.
         *  @type {string}
         *  @default null
         */
        var snapTo: String? = null,
        /**
         *  If Canvas.snapTo is defined to this widget, this property can be used to
         *   define which edge of this widget should be snapped to an edge of the master or parent
         *   element.
         *
         *   If unspecified the, default snapTo behavior is set up to align the "snapTo" edge of this
         *   widget with the snapTo edge of the master or parent.
         *  @type {string}
         *  @default null
         */
        var snapEdge: String? = null,
        /**
         *  If Canvas.snapTo is defined for this widget, this property can be used to
         *   specify an offset in px or percentage for the left coordinate of this widget.
         *
         *   For example if snapTo is specified as "L" and
         *   snapOffsetLeft is set to 6, this widget will be rendered 6px inside the left
         *   edge of its parent or master element. Alternatively if snapTo was set
         *   to "R", a snapOffsetLeft value of -6 would cause the
         *   component to be rendered 6px inside the right edge of its parent or Canvas.getMasterCanvas.
         *  @type {Integer}
         *  @default null
         */
        var snapOffsetLeft: Number? = null,
        /**
         *  If Canvas.snapTo is defined for this widget, this property can be used to
         *   specify an offset in px or percentage for the top coordinate of this widget.
         *
         *   For example if snapTo is specified as "T" and
         *   snapOffsetTop is set to 6, this widget will be rendered 6px below the top
         *   edge of its parent or master element. . Alternatively if snapTo was set
         *   to "B", a snapOffsetTop value of -6 would cause the
         *   component to be rendered 6px inside the bottom edge of its parent or Canvas.getMasterCanvas.
         *  @type {Integer}
         *  @default null
         */
        var snapOffsetTop: Number? = null,
        /**
         *  Causes this canvas to snap to its parent's grid when dragging.
         *  @type {boolean}
         *  @default null
         */
        var snapToGrid: Boolean? = null,
        /**
         *  Causes this canvas to snap to its parent's grid when resizing.
         *   Note that this value defaults to the Canvas's
         *   Canvas.snapToGrid value if undefined.
         *  @type {boolean}
         *  @default null
         */
        var snapResizeToGrid: Boolean? = null,
        /**
         *  If true, causes this canvas's children to snap to its grid when dragging.
         *   This behavior can be overridden on a per-child basis by setting the
         *   Canvas.snapToGrid value on the child.
         *  @type {boolean}
         *  @default null
         */
        var childrenSnapToGrid: Boolean? = null,
        /**
         *  If true, causes this canvas's children to snap to its grid when resizing.
         *   This behavior can be overridden on a per-child basis by setting the
         *   Canvas.snapToGrid or
         *   Canvas.snapResizeToGrid value on the child.
         *  @type {boolean}
         *  @default null
         */
        var childrenSnapResizeToGrid: Boolean? = null,
        /**
         *  The horizontal grid size to use, in pixels, when snap-to-grid is enabled.
         *  @type {number}
         *  @default "20"
         */
        var snapHGap: Number = 20,
        /**
         *  The vertical grid size to use, in pixels, when snap-to-grid is enabled.
         *  @type {number}
         *  @default "20"
         */
        var snapVGap: Number = 20,
        /**
         *  The horizontal snap direction.
         *   Set this value to "before" to snap to the nearest gridpoint to the left;
         *   set it to "after" to snap to the nearest gridpoint to the right; and set
         *   it to "nearest" to snap to the nearest gridpoint in either direction.
         *  @type {string}
         *  @default "after"
         */
        var snapHDirection: String = "after",
        /**
         *  The vertical snap direction.
         *   Set this value to "before" to snap to the nearest gridpoint above;
         *   set it to "after" to snap to the nearest gridpoint below; and set
         *   it to "nearest" to snap to the nearest gridpoint in either direction.
         *  @type {string}
         *  @default "after"
         */
        var snapVDirection: String = "after",
        /**
         *  Describes which axes to apply snap-to-grid to.
         *   Valid values are "horizontal", "vertical" or "both".
         *  @type {string}
         *  @default "both"
         */
        var snapAxis: String = "both",
        /**
         *  When this canvas is dropped onto an object supporting snap-to-grid, should it snap
         *   to the grid (true, the default) or just drop wherever the mouse is (false).
         *  @type {boolean}
         *  @default true
         */
        var snapOnDrop: Boolean = true,
        /**
         *  Should this canvas print its children absolutely positioned when generating
         *   Canvas.getPrintHTML.
         *
         *   By default explicitly specified absolute positioning and sizing is ignored when generating
         *   print HTML. This is done intentionally: there is no way for the framework to predict how
         *   explicit sizes will translate to a the printed page and if HTML for printing includes
         *   the same absolute positioning and sizing as is displayed within an application it is very
         *   common to encounter undesirable effects, such as seeing tables get broken over several
         *   pages horizontally when there is enough room to print them on a single page of paper.
         *
         *   In some cases, however, a developer may wish to have explicit sizing and positioning
         *   respected within the print-view.
         *   Setting this attribute to true will cause this to occur.
         *  @type {boolean}
         *  @default false
         */
        var printChildrenAbsolutelyPositioned: Boolean = false,
        /**
         *  This boolean flag will be set to true by framework logic while generating print HTML
         *   for this widget as a result to a call to Canvas.showPrintPreview
         *   (or just Canvas.getPrintHTML). Note that this flag is set recursively as
         *   parent widgets generate print HTML for their children.
         *
         *   This is a read-only property and should not be modified by application code.
         *  @type {boolean}
         *  @default false
         */
        var isPrinting: Boolean = false,
        /**
         *  Whether this canvas should be included in a printable view.
         *
         *   Default is to:
         *
         *
         *  - omit all peers (edges generated by showEdges:true, etc)
         *
         *  - omit anything considered a "control", such as a button or menu (see
         *   PrintProperties.omitControls)
         *
         *  - include everything else not marked shouldPrint:false
         *
         *  @type {boolean}
         *  @default null
         */
        var shouldPrint: Boolean? = null,
        /**
         *  Is it possible that a call to Canvas.redraw on this widget will change its
         *   size?
         *
         *   Used by framework layout code when determining whether a component which has been
         *   Canvas.markForRedraw needs an immediate redraw to determine
         *   its drawn size.
         *
         *   If unset, default behavior assumes any component with overflow set to "visible"
         *   may change size on redraw, and any component with overflow set to "hidden", "scroll",
         *   or "auto" will not. This property overrides that behavior, and may be used to indicate
         *   that some component with non visible overflow can change size on redraw.
         *   An example use case would be a custom component with an override to explicitly
         *   resize the component as part of the redraw() flow.
         *  @type {boolean}
         *  @default null
         */
        var sizeMayChangeOnRedraw: Boolean? = null,
        /**
         *  If this property is set to true, the Canvas.destroy method
         *   has been called on this canvas. This implies the canvas is no longer valid. Its ID has been
         *   removed from global scope, and calling standard canvas APIs on it is likely to result in
         *   errors.
         *  @type {boolean}
         *  @default null
         */
        var destroyed: Boolean? = null,
        /**
         *  This property is set to true when the Canvas.destroy method is called on a widget.
         *   If this property is true, but Canvas.destroyed is not, this indicates the canvas is
         *   in the process of being destroyed.
         *  @type {boolean}
         *  @default null
         */
        var destroying: Boolean? = null,
        /**
         *  Automatically generated mask canvas displayed when Canvas.showComponentMask is called.
         *  @type {Canvas}
         *  @default null
         */
        var componentMask: Canvas? = null,
        /**
         *  Defaults for the Canvas.componentMask autoChild.
         *   Default properties include Canvas.backgroundColor being set to "black" and
         *   Canvas.opacity being set to 20.
         *  @type {Canvas}
         *  @default "{...}"
         */
        // var componentMaskDefaults: Canvas = definedExternally,
        /**
         *  The minimum speed in pixels per second that must be reached for momentum scrolling to kick in.
         *   This setting only applies to touch-enabled devices.
         *  @type {Double}
         *  @default "200"
         */
        var momentumScrollMinSpeed: Number = 200,
        /**
         *  Should canvases with no Canvas.getParentCanvas be moved to
         *   the end of the TabIndexManager tree on draw()?
         *
         *   If set to false, the tab-position will not be modified on draw.
         *
         *   This property is useful for cases where the tab position of a widget will be managed
         *   by some explicit tabIndex management code.
         *  @type {boolean}
         *  @default true
         */
        var updateTabPositionOnDraw: Boolean = true,
        /**
         *  Should canvases with a Canvas.getParentCanvas be added to
         *   the TabIndexManager under the parent as described in Canvas.updateChildTabPositions and
         *   Canvas.updateChildTabPosition?
         *
         *   If set to false, the tab-position will not be modified on parent change.
         *
         *   This property is useful for cases where the tab position of a widget will be managed
         *   by something other than the parent canvas, for example for
         *   CanvasItem.canvas.
         *  @type {boolean}
         *  @default true
         */
        var updateTabPositionOnReparent: Boolean = true,
        /**
         *  When set to true, shows a widget hovering at the mouse point instead of the builtin
         *   hover label. Override Canvas.getHoverComponent to provide the
         *   Canvas to show as the hoverComponent.
         *  @type {boolean}
         *  @default false
         */
        var showHoverComponents: Boolean = false,
        /**
         *  Whether to show a snap grid for this Canvas. Note that the grid is only shown
         *   when either Canvas.childrenSnapToGrid or Canvas.childrenSnapResizeToGrid
         *   is true.
         *
         *   Grid is based on Canvas.snapHGap and Canvas.snapVGap properties.
         *  @type {boolean}
         *  @default null
         */
        var showSnapGrid: Boolean? = null,
        /**
         *  If enabled while Canvas.childrenSnapToGrid is enabled, children dragged within this Canvas
         *   will also snap to positions where their edges or center lines would be aligned with the
         *   edges or centers of other components, and lines will be shown to point out the possible
         *   alignment (with appearance controlled by Canvas.snapAlignCenterLineStyle and
         *   Canvas.snapAlignEdgeLineStyle respectively.
         *
         *   By default, edge- or center-snapping is enabled for all components, but the set of eligible
         *   components can be explicitly set via Canvas.snapAlignCandidates.
         *
         *   See also Canvas.childrenSnapCenterAlign and Canvas.childrenSnapEdgeAlign for enabling or
         *   disabling center alignment or edge alignment individually.
         *  @type {boolean}
         *  @default null
         */
        var childrenSnapAlign: Boolean? = null,
        /**
         *  Flag to disable snapping to alignment when children of this Canvas are resized
         *  @type {boolean}
         *  @default null
         */
        var childrenResizeSnapAlign: Boolean? = null,
        /**
         *  See Canvas.childrenSnapAlign. This setting enables or disables snapping on center
         *   alignment only.
         *  @type {boolean}
         *  @default null
         */
        var childrenSnapCenterAlign: Boolean? = null,
        /**
         *  See Canvas.childrenSnapAlign. This setting enables or disables snapping on edge
         *   alignment only.
         *  @type {boolean}
         *  @default null
         */
        var childrenSnapEdgeAlign: Boolean? = null,
        /**
         *  Flag to disable snapping to alignment when this Canvas is dragged when
         *   Canvas.childrenSnapAlign is enabled on this Canvas' parent.
         *
         *   To control snapping to align for the children dragged within this Canvas, see
         *   Canvas.childrenSnapAlign instead.
         *  @type {boolean}
         *  @default null
         */
        var snapToAlign: Boolean? = null,
        /**
         *  Flag to disable snapping to alignment when this Canvas is resized.
         *
         *   To control snapping to align for the children resized within this Canvas, see
         *   Canvas.childrenResizeSnapAlign instead.
         *  @type {boolean}
         *  @default null
         */
        var snapResizeToAlign: Boolean? = null,
        /**
         *  Flag to disable snapping to center alignment when this Canvas is dragged when
         *   Canvas.childrenSnapAlign is enabled on this Canvas' parent.
         *  @type {boolean}
         *  @default null
         */
        var snapToCenterAlign: Boolean? = null,
        /**
         *  Flag to disable snapping to edge alignment when this Canvas is dragged when
         *   Canvas.childrenSnapAlign is enabled on this Canvas' parent.
         *  @type {boolean}
         *  @default null
         */
        var snapToEdgeAlign: Boolean? = null,
        /**
         *  Flag to disable snapping to alignment against this Canvas when other Canvases
         *   dragged into the same parent when Canvas.childrenSnapAlign is enabled on this
         *   Canvas' parent.
         *  @type {boolean}
         *  @default null
         */
        var isSnapAlignCandidate: Boolean? = null,
        /**
         *  When Canvas.childrenSnapAlign is enabled, list of candidates to check for alignment.
         *
         *   If a list of snapAlignCandidates is never provided, the default is to use all
         *   children that are not explicitly excluded via Canvas.isSnapAlignCandidate, including
         *   automatically adding newly added children as candidates, and ignoring children that have
         *   been removed. Use Canvas.addSnapAlignCandidate and Canvas.removeSnapAlignCandidate to add
         *   and remove special candidates while retaining all children as default candidates.
         *
         *   Possible candidates which are not drawn or are hidden are automatically ignored.
         *  @type {Array<Partial<Canvas>>}
         *  @default null
         */
        var snapAlignCandidates: Array<dynamic>? = null,
        /**
         *  CSS border declaration used for the line shown to indicate snapping to a center line when
         *   Canvas.childrenSnapAlign is set.
         *  @type {string}
         *  @default "1px solid blue"
         */
        var snapAlignCenterLineStyle: String = "1px solid blue",
        /**
         *  CSS border declaration used for the line shown to indicate snapping to a edge line when
         *   Canvas.childrenSnapAlign is set.
         *  @type {string}
         *  @default "1px solid #555555"
         */
        var snapAlignEdgeLineStyle: String = "1px solid #555555",
        /**
         *  Whether an EdgedCanvas should be used to show image-based edges around this
         *   component.
         *  @type {boolean}
         *  @default false
         */
        var showEdges: Boolean = false,
        /**
         *  Size in pixels for corners and edges
         *  @type {number}
         *  @default "10"
         */
        var edgeSize: Number = 10,
        /**
         *  Amount the contained Canvas should be offset. Defaults to edgeSize; set to less than
         *   edgeSize to allow the contained Canvas to overlap the edge and corner media.
         *  @type {number}
         *  @default null
         */
        var edgeOffset: Number? = null,
        /**
         *  Base name of images for edges. Extensions for each corner or edge piece will be added
         *   to this image URL, before the extension. For example, with the default base name of
         *   "edge.gif", the top-left corner image will be "edge_TL.gif".
         *
         *   The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R",
         *   "_center".
         *  @type {SCImgURL}
         *  @default "[SKIN]edge.gif"
         */
        var edgeImage: String = "[SKIN]edge.gif",
        /**
         *  Array of side names ("T", "B", "L", "R") specifying which sides of the decorated
         *   component should show edges. For example:
         *     customEdges : ["T", "B"]
         *
         *   .. would show edges only on the top and bottom of a component.
         *
         *   The default of null means edges will be shown on all sides.
         *  @type {Array<Partial<string>>}
         *  @default null
         */
        var customEdges: Array<dynamic>? = null,
        /**
         *  Background color for the EdgedCanvas created to decorate this component. This can be used
         *   to provide an underlying "tint" color for translucent edge media
         *  @type {CSSColor}
         *  @default null
         */
        var edgeBackgroundColor: String? = null,
        /**
         *  Opacity of the edges. Defaults to matching this.opacity.
         *   if Canvas.setOpacity is called on a Canvas where edgeOpacity is set,
         *   edgeOpacity will be considered a percentage of the parent's opacity (so 50% opaque parent plus
         *   edgeOpacity 50 means 25% opaque edges)
         *  @type {Integer}
         *  @default null
         */
        var edgeOpacity: Number? = null,
        /**
         *  Whether to show media in the center section, that is, behind the decorated Canvas.
         *  @type {boolean}
         *  @default false
         */
        var edgeShowCenter: Boolean = false,
        /**
         *  Background color for the center section only. Can be used as a surrogate background
         *   color for the decorated Canvas, if the Canvas is set to partially overlap the edges and
         *   hence can't show a background color itself without occluding media.
         *  @type {CSSColor}
         *  @default null
         */
        var edgeCenterBackgroundColor: String? = null,
        /**
         *  Whether to show a drop shadow for this Canvas.
         *
         *   Shadows may be rendered using Canvas.useCSSShadow or via images.
         *   The appearance of shadows can be customized via
         *   Canvas.shadowColor (for css-based shadows) or Canvas.shadowImage
         *   (for image based shadows), Canvas.shadowDepth,
         *   Canvas.shadowOffset and Canvas.shadowSoftness.
         *
         *   When Canvas.useCSSShadow is false, developers should be aware that the drop shadow
         *   is rendered as a Canvas.peers and is drawn outside the specified
         *   width and height of the widget meaning a widget with shadows
         *   takes up a little more space than it otherwise would. A full screen canvas with showShadow set
         *   to true as this would be likely to cause browser scrollbars to appear - developers can handle
         *   this by either setting this property to false on full-screen widgets, or by setting
         *   overflow to "hidden" on the &lt;body&gt; element if browser-level scrolling is
         *   never intended to occur.
         *  @type {boolean}
         *  @default false
         */
        var showShadow: Boolean = false,
        /**
         *  Depth of the shadow, or the virtual height above the page of the widget throwing the shadow.
         *
         *   This is a single parameter that can be used to control both shadowSoftness and
         *   shadowOffset.
         *  @type {number}
         *  @default "4"
         */
        var shadowDepth: Number = 4,
        /**
         *  Offset of the shadow. Defaults to half of shadowDepth if unset.
         *
         *   Because of the blurred edges, a shadow is larger than the originating component by
         *   2xsoftness. An shadowOffset of 0 means that the shadow will extend around the
         *   originating component equally in all directions.
         *
         *   If Canvas.useCSSShadow are being used, separate vertical and
         *   horizontal offsets may be specified via Canvas.shadowHOffset and
         *   Canvas.shadowVOffset.
         *  @type {number}
         *  @default null
         */
        var shadowOffset: Number? = null,
        /**
         *  Horizontal offset for the Canvas.showShadow. Takes precedence over
         *   Canvas.shadowOffset if set. Has no effect if Canvas.useCSSShadow
         *   are not being used for this canvas.
         *  @type {number}
         *  @default null
         */
        var shadowHOffset: Number? = null,
        /**
         *  Vertical offset for the Canvas.showShadow. Takes precedence over
         *   Canvas.shadowOffset if set. Has no effect if Canvas.useCSSShadow
         *   are not being used for this canvas.
         *  @type {number}
         *  @default null
         */
        var shadowVOffset: Number? = null,
        /**
         *  Softness, or degree of blurring, of the shadow.
         *
         *   A shadow with softness:x is 2x pixels larger in each direction than the element
         *   throwing the shadow, and the media for each edge should be x pixels wide/tall.
         *
         *   Defaults to shadowDepth if unset.
         *  @type {number}
         *  @default null
         */
        var shadowSoftness: Number? = null,
        /**
         *  If Canvas.useCSSShadow is false, (or for browsers that do not support
         *   css3), this property supplies the base name of the series of images for the sides,
         *   corners, and center of the shadow.
         *
         *   The actual image names fetched for the dropShadow combine the segment name and the
         *   shadowDepth setting. For example, given "ds.png" as the base name, a depth of
         *   4, and the top-left segment of the shadow, we'd use "ds4_TL.png".
         *
         *   The names for segments are the same as those given for controlling resizable edges; see
         *   Canvas.resizeFrom. The center segment has the name "center". The center segment is
         *   the only segment that doesn't include the depth in the URL, so the final image name for the
         *   center given a baseName of "ds.png" would be just "ds_center.png".
         *  @type {SCImgURL}
         *  @default "[SKIN]ds.png"
         */
        var shadowImage: String = "[SKIN]ds.png",
        /**
         *  If Canvas.showShadow is true, should we use the css box-shadow property
         *   (where supported) to achieve the shadow?
         *
         *   Set this property to false to switch to a media-based approach, achieved by
         *   rendering the Canvas.shadowImage in an automatically generated peer.
         *   This approach is also used regardless of this property value in older browsers
         *   where the css box-shadow property isn't supported.
         *
         *   See also Canvas.shadowColor, Canvas.shadowDepth,
         *   Canvas.shadowOffset, Canvas.shadowSoftness and Canvas.shadowSpread
         *  @type {boolean}
         *  @default true
         */
        var useCSSShadow: Boolean = true,
        /**
         *  Color for the css-based drop shadow shown if Canvas.useCSSShadow is true
         *   and Canvas.showShadow is true.
         *
         *   Has no effect if we are not using css-based shadows - in that case, use
         *   Canvas.shadowImage instead.
         *  @type {CSSColor}
         *  @default "#AAAAAA"
         */
        var shadowColor: String = "#AAAAAA",
        /**
         *  Explicit spread for the css-based drop shadow shown if Canvas.useCSSShadow is true
         *   and Canvas.showShadow is true. This property governs how much larger than the
         *   widget the shadow will appear. A negative value (coupled with an explicit offset) will
         *   result in a smaller shadow.
         *
         *   Has no effect if we are not using css-based shadows - in that case, use
         *   Canvas.shadowImage instead.
         *  @type {Integer}
         *  @default null
         */
        var shadowSpread: Number? = null,
        /**
         *  Should a grouping frame be shown around this canvas.
         *  @type {boolean}
         *  @default false
         */
        var isGroup: Boolean = false,
        /**
         *  Sets the style for the grouping frame around the canvas. Only necessary when Canvas.isGroup
         *   is set to true.
         *  @type {string}
         *  @default "2px solid black"
         */
        var groupBorderCSS: String = "2px solid black",
        /**
         *  Sets the style for the grouping label. Only necessary when Canvas.isGroup
         *   is set to true.
         *
         *   Note that Canvas.groupLabelBackgroundColor overrides any background-color of this style.
         *  @type {CSSStyleName}
         *  @default "groupLabel"
         */
        var groupLabelStyleName: String = "groupLabel",
        /**
         *  If set, the background color of the grouping label. Only applicable when Canvas.isGroup
         *   is set to true.
         *
         *   This corresponds to the CSS background-color property on the grouping label. You can set this
         *   property to an RGB value (e.g. #22AAFF) or a named color (e.g. red) from a list of browser supported
         *   color names.
         *
         *  @type {CSSColor}
         *  @default null
         */
        var groupLabelBackgroundColor: String? = null,
        /**
         *  The title/label for the grouping. Only applicable when Canvas.isGroup is set to true.
         *  @type {HTMLString}
         *  @default null
         */
        var groupTitle: String? = null,
        /**
         *  Canvas.ID of the component that gathers the context for evaluation of criteria-based
         *   rules specified by properties such as FormItem.visibleWhen.
         *
         *   If not specified, this component will search through it's Canvas.parentCanvas chain until it
         *   either reaches the top or reaches a parent marked Canvas.isRuleScope. Determination of the
         *   ruleScope happens when the component is first drawn.
         *
         *   The component designated as the ruleScope manages a nested data structure called
         *   the "rule context" which contains information from all DataBoundComponents that are
         *   registered with the ruleScope. By specifying Criterion.fieldName as a
         *   DataPath, AdvancedCriteria defined in properties such as
         *   FormItem.visibleWhen can access any part of the rule context.
         *
         *   By default, the rule context contains data as follows:
         *
         *
         *  - any DataBoundComponent that has a DataSource contributes the values of the
         *    selected record or record being edited under the ID of the DataSource. For any collision
         *    an editable display (such as a form or editable grid) wins over a static display (such as
         *    a non-editable grid with a selection.)
         *
         *  - any ListGrid or other component that manages a selection and has been assigned an explicit
         *    Canvas.ID will contribute the values of the selected record under
         *    &lt;componentId&gt;.selectedRecord, and also contributes 3 flags for checking
         *    for selection: anySelected, multiSelected,
         *    numSelected.
         *
         *  - any DynamicForm or other component that edits values and has been assigned an explicit
         *    Canvas.ID contributes its current values under
         *    &lt;componentId&gt;.values, and contributes a flag hasChanges.
         *
         *  - any DynamicForm or ListGrid that has been assigned an explicit Canvas.ID
         *    contributes a value &lt;componentId&gt;.focusField. When present the value
         *    indicates the component has focus along with the name of the field that has focus. Its absense
         *    indicates the component does not have focus at all.
         *
         *  - any ListGrid that has been assigned an explicit Canvas.ID contributes a flag
         *    isGrouped under &lt;componentId&gt;.
         *
         *   For example, given a screen where:
         *
         *
         *  - a ListGrid with ID "itemGrid" and DynamicForm with ID "itemForm" are both bound to the
         *    supplyItem sample DataSource
         *
         *  - the ListGrid has a single selection, and the record selected in the ListGrid is being
         *    edited in the form, and has been changed
         *
         *   The default rule context available from Canvas.getRuleContext, expressed as JSON, would be:
         *
         *   {
         *   supplyItem : {
         *     itemID : "654321",
         *     itemName : "Sewing Machine",
         *     price : 5.50, // note: user change
         *     ..other properties..
         *   },
         *   itemForm.values : {
         *     itemID : "654321",
         *     itemName : "Sewing Machine",
         *     price : 5.50, // note: user change
         *     ..other properties..
         *   },
         *   itemForm.focusField : "itemName",
         *   itemForm.hasChanges : true,
         *   itemGrid.selectedRecord : {
         *     itemID : "654321",
         *     itemName : "Sewing Machine",
         *     price : 3.50, // note: old price
         *     ..other properties..
         *   },
         *   itemGrid.anySelected : true,
         *   itemGrid.multiSelected : false,
         *   itemGrid.numSelected : 1,
         *   itemGrid.isGrouped : false
         *   }
         *
         *   In addition, an application can put custom data into the ruleScope via Canvas.provideRuleContext.
         *  @type {string}
         *  @default null
         */
        // var ruleScope: String? = null,
        /**
         *  Marks this Canvas as the Canvas.ruleScope that will be discovered by any contained
         *   DataBoundComponents which do not specify an explicit ruleScope.
         *  @type {boolean}
         *  @default null
         */
        var isRuleScope: Boolean? = null,
        /**
         *  ValuesManager for managing values displayed in this component.
         *   If specified at initialization time, this component will be added to the valuesManager via
         *   ValuesManager.addMember.
         *
         *   ValuesManagers allow different fields of a single object to be displayed or edited
         *   across multiple UI components. Given a single values object, a valuesManager will handle
         *   determining the appropriate field values for its member components and displaying them /
         *   responding to edits if the components support this.
         *
         *   Data may be derived simply from the specified fieldNames within the member components, or for
         *   complex nested data structures can be specified by both component and field-level
         *   DataPath.
         *
         *   Note that components may be automatically bound to an existing valuesManager attached to a
         *   parent component if dataPath is specified. See Canvas.dataPath for more information.
         *   Also note that if a databound component has a specified dataSource and dataPath but no specified
         *   valuesManager object one will be automatically generated as part of the databinding process
         *  @type {ValuesManager | GlobalId}
         *  @default null
         */
        var valuesManager: dynamic = null,
        /**
         *  A dataPath may be specified on any canvas. This provides a straightforward way to display or
         *   edit complex nested data.
         *
         *   For components which support displaying or editing data values, (such as DynamicForm or
         *   ListGrid components), the dataPath may be set to specify how the components data is
         *   accessed. In this case the dataPath essentially specifies a nested object to edit - typically
         *   a path to a field value within a dataSource record. Note that a ValuesManager will be required
         *   to handle connecting the dataBoundcomponent to the appropriate sub object. This may be explicitly
         *   specified on the component, or a parent of the component, or automatically generated
         *   if a DataSource is specified on either the component or a parent thereof.
         *
         *   To provide a simple example - if a complex object existed with the following format:
         *
         *   { companyName:"Some Company",
         *    address:{  street:"123 Main Street", city:"New York", state:"NY" }
         *   }
         *
         *   a developer could specify a DynamicForm instance with 'dataPath' set to "address" to edit
         *   the nested address object:
         *
         *   isc.ValuesManager.create({
         *     ID:'vm',
         *     values: { companyName:"Some Company",
         *         address:{  street:"123 Main Street", city:"New York", state:"NY" }
         *     }
         *   });
         *
         *   isc.DynamicForm.create({
         *     valuesManager:"vm",
         *     dataPath:"address",
         *     items:[{name:"street"}, {name:"city"}, {name:"state"}]
         *   });
         *
         *   If a component is specified with a dataPath attribute but does not have an
         *   explicitly specified valuesManager, it will check its parent element chain for a specified
         *   valuesManager and automatically bind to that. This simplifies binding multiple components used
         *   to view or edit a nested data structure as the valuesManager needs only be defined once at a
         *   reasonably high level component. Here's an example of this approach:
         *
         *   isc.ValuesManager.create({
         *     ID:'vm',
         *     values: { companyName:"Some Company",
         *         address:{  street:"123 Main Street", city:"New York", state:"NY" }
         *     }
         *   });
         *
         *   isc.Layout.create({
         *     valuesManager:vm,
         *     members:[
         *       isc.DynamicForm.create({
         *         dataPath:"/",
         *         items:[{name:"companyName"}]
         *       }),
         *       isc.DynamicForm.create({
         *         dataPath:"address",
         *         items:[{name:"street"}, {name:"city"}, {name:"state"}]
         *       })
         *     ]
         *   });
         *
         *   Note that in this case the valuesManager is specified on a Layout, which has no 'values'
         *   management behavior of its own, but contains items with a specified dataPath which do. In this
         *   example you'd see 2 forms allowing editing of the nested data structure.
         *
         *   dataPaths from multiple nested components may also be combined. For example:
         *
         *   isc.ValuesManager.create({
         *     ID:'vm',
         *     values: { companyName:"Some Company",
         *         address:{  street:"123 Main Street", city:"New York", state:"NY" }
         *         parentCompany:{
         *           companyName:"Some Corporation",
         *           address:{  street:"1 High Street", city:"New York", state:"NY" }
         *         }
         *     }
         *   });
         *
         *   isc.Layout.create({
         *     valuesManager:vm,
         *     members:[
         *       isc.DynamicForm.create({
         *         dataPath:"/",
         *         items:[{name:"companyName"}]
         *       }),
         *       isc.DynamicForm.create({
         *         dataPath:"address",
         *         items:[{name:"street"}, {name:"city"}, {name:"state"}]
         *       }),
         *       isc.Layout.create({
         *         dataPath:"parentCompany",
         *         members:[
         *           isc.DynamicForm.create({
         *             dataPath:"/",
         *             items:[{name:"companyName", type:"staticText"}]
         *           }),
         *           isc.DetailViewer.create({
         *             dataPath:"address",
         *             fields:[{name:"street", name:"city", name:"state"}]
         *           })
         *         ]
         *       })
         *     ]
         *   });
         *
         *   In this example the detailViewer will display data from the parentCompany.address
         *   object within the base record.
         *
         *   Note that if a component has a specified dataSource and shows child components with a
         *   specified dataPath, there is no need to explicitly declare a valuesManager at all. If a component
         *   with a dataPath has a dataSource, or an ancestor with a dataSource specified, it will, a
         *   valuesManager will automatically be generated on the higher level component (and be available as
         *   component.valuesManager).
         *  @type {DataPath}
         *  @default null
         */
        var dataPath: String? = null,
        /**
         *  Strategy to use when locating children in this canvas from an autoTest locator string.
         *  @type {LocatorStrategy}
         *  @default null
         */
        var locateChildrenBy:
        /**
         *  Match by name if possible.
         *  Match by title if possible.
         *  Match by index
         */
        String? /* name |  title |  index */ = null,
        /**
         *  LocatorTypeStrategy to use when finding children within this canvas.
         *  @type {LocatorTypeStrategy}
         *  @default null
         */
        var locateChildrenType:
        /**
         *  Match by class if possible
         *  Ignore specific class and match by the SmartClient framework superclass.
         *  Ignore class altogether and attempt to match by role
         *  Don't attempt to compare type in any way
         */
        String? /* Class |  scClass |  role |  none */ = null,
        /**
         *  Strategy to use when locating peers of this canvas from an autoTest locator string.
         *  @type {LocatorStrategy}
         *  @default null
         */
        var locatePeersBy:
        /**
         *  Match by name if possible.
         *  Match by title if possible.
         *  Match by index
         */
        String? /* name |  title |  index */ = null,
        /**
         *  LocatorTypeStrategy to use when finding peers of this canvas.
         *  @type {LocatorTypeStrategy}
         *  @default null
         */
        var locatePeersType:
        /**
         *  Match by class if possible
         *  Ignore specific class and match by the SmartClient framework superclass.
         *  Ignore class altogether and attempt to match by role
         *  Don't attempt to compare type in any way
         */
        String? /* Class |  scClass |  role |  none */ = null,
        /**
         *  When nodes are added to an EditContext, should they be masked by setting
         *   EditProxy.useEditMask true if not explicitly set?
         *  @deprecated \* As of SmartClient version 10.0, deprecated in favor of EditProxy.autoMaskChildren
         *  @type {boolean}
         *  @default null
         */
        var autoMaskComponents: Boolean? = null,
        /**
         *  An EditProxy controls the behaviors of a component when it is placed into
         *   devTools.
         *
         *   The editProxy AutoChild is created when a component is first placed into
         *   edit mode via Canvas.setEditMode.
         *
         *   editProxy properties can be supplied on a PaletteNode or
         *   EditNode as PaletteNode.editProxyProperties, but must
         *   be provided before the component is first placed into edit mode.
         *
         *   Most editable components use a custom EditProxy. See the documentation for
         *   each class' Canvas.editProxyConstructor to determine
         *   the class.
         *  @type {EditProxy}
         *  @default null
         */
        var editProxy: EditProxy? = null,
        /**
         *  Default class used to construct the EditProxy for this component
         *   when the component is Canvas.setEditMode.
         *  @type {SCClassName}
         *  @default "CanvasEditProxy"
         */
        var editProxyConstructor: String = "CanvasEditProxy",
        /**
         *  The component's EditNode for a component that has been created by a
         *   Palette from a PaletteNode.
         *  @type {EditNode}
         *  @default null
         */
        var editNode: isc.EditNode? = null,
        /**
         *  ARIA role of this component. Usually does not need to be manually set - see
         *   accessibility.
         *  @type {string}
         *  @default null
         */
        var ariaRole: String? = null,
        /**
         *  ARIA state mappings for this component. Usually this does not need to be manually
         *   set - see accessibility.
         *
         *   This attribute should be set to a mapping of aria state-names to values - for example
         *   to have the "aria-haspopup" property be present with a value "true", you'd specify:
         *
         *   { haspopup : true }
         *
         *  @type {object}
         *  @default null
         */
        var ariaState: dynamic = null
) : ClassProperties()

fun canvas(block: CanvasProperties.() -> Unit): isc.Canvas {
    val props = CanvasProperties().apply(block)
    return isc.Canvas.create(props, null)
}

