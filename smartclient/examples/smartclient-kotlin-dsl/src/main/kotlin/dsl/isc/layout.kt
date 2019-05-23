package dsl.isc

import isc.Canvas

@ISCDslMarker
open class LayoutProperties : CanvasProperties() {
    /**
     *  An array of canvases that will be contained within this layout. You can set the
     *   following properties on these canvases (in addition to the standard component
     *   properties):
     *
     *
     *  - Canvas.layoutAlign -- specifies the member's alignment along the
     *     breadth axis; valid values are "top", "center" and "bottom" for a horizontal layout
     *     and "left", "center" and "right" for a vertical layout (see
     *     Layout.defaultLayoutAlign for default implementation.)
     *
     *  - Canvas.showResizeBar -- set to true to show a resize bar
     *     (default is false)
     *
     *   Height and width settings found on members are interpreted by the Layout according to
     *   the Layout.vPolicy.
     *
     *   Note that it is valid to have null slots in the provided members Array,
     *   and the Layout will ignore those slots. This can be useful to keep code compact, for
     *   example, when constructing the members Array, you might use an expression
     *   that either returns a component or null depending on whether the component should be
     *   present. If the expression returns null, the null slot will be ignored by the Layout.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var members: Array<dynamic>? = null
    /**
     *  A Layout may overflow if it has one or more members with a fixed width or height, or that
     *   themselves overflow. For details on member sizing see LayoutPolicy.
     *
     *   Note that for overflow: "auto", "scroll", or "visible", members exceeding the Layout's
     *   specified breadth but falling short of its overflow breadth will keep the alignment set
     *   via Layout.defaultLayoutAlign or Canvas.layoutAlign.
     *  @type {Overflow}
     *  @default "visible"
     */
    override var overflow:
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
            String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = "visible"
    /**
     *  Orientation of this layout.
     *  @deprecated \* in favor of Layout.vertical, which, if specified takes precedence over this setting
     *  @type {Orientation}
     *  @default "horizontal"
     */
    open var orientation:
            /**
             *  members laid out vertically
             *  members laid out horizontally
             */
            String /* vertical |  horizontal */ = "horizontal"
    /**
     *  Should this layout appear with members stacked vertically or horizontally. Defaults to
     *   false if unspecified.
     *  @type {boolean}
     *  @default null
     */
    open var vertical: Boolean? = null
    /**
     *  Sizing policy applied to members on vertical axis
     *  @type {LayoutPolicy}
     *  @default "fill"
     */
    open var vPolicy:
            /**
             *  Layout does not try to size members on the axis at all, merely stacking them (length
             *   axis) and leaving them at default breadth.
             *  Layout sizes members so that they fill the specified size of the layout. The rules
             *   are:
             *
             *
             *  - Any component given an initial pixel size, programmatically resized to a specific
             *   pixel size, or drag resized by user action is left at that exact size
             *
             *  - Any component that Button.autoFit is given exactly the space it
             *   needs, never forced to take up more.
             *
             *  - All other components split the remaining space equally, or according to their
             *   relative percentages.
             *
             *  - Any component that declares a Canvas.minWidth or Canvas.minHeight
             *   will never be sized smaller than that size
             *
             *  - Any component that declares a Canvas.maxWidth or Canvas.maxHeight
             *   will never be sized larger than that size
             *
             *   In addition, components may declare that they have
             *   Canvas.canAdaptWidth, and may coordinate with the Layout to render
             *   at different sizes according to the amount of available space.
             */
            String /* none |  fill */ = "fill"
    /**
     *  Sizing policy applied to members on horizontal axis
     *  @type {LayoutPolicy}
     *  @default "fill"
     */
    open var hPolicy:
            /**
             *  Layout does not try to size members on the axis at all, merely stacking them (length
             *   axis) and leaving them at default breadth.
             *  Layout sizes members so that they fill the specified size of the layout. The rules
             *   are:
             *
             *
             *  - Any component given an initial pixel size, programmatically resized to a specific
             *   pixel size, or drag resized by user action is left at that exact size
             *
             *  - Any component that Button.autoFit is given exactly the space it
             *   needs, never forced to take up more.
             *
             *  - All other components split the remaining space equally, or according to their
             *   relative percentages.
             *
             *  - Any component that declares a Canvas.minWidth or Canvas.minHeight
             *   will never be sized smaller than that size
             *
             *  - Any component that declares a Canvas.maxWidth or Canvas.maxHeight
             *   will never be sized larger than that size
             *
             *   In addition, components may declare that they have
             *   Canvas.canAdaptWidth, and may coordinate with the Layout to render
             *   at different sizes according to the amount of available space.
             */
            String /* none |  fill */ = "fill"
    /**
     *  See Layout.minMemberLength.
     *  @deprecated \* use the more intuitively named Layout.minMemberLength
     *  @type {Integer}
     *  @default "1"
     */
    open var minMemberSize: Number = 1
    /**
     *  Minimum size, in pixels, below which flexible-sized members should never be shrunk, even
     *   if this requires the Layout to overflow. Note that this property only applies along
     *   the length axis of the Layout, and has no affect on breadth.
     *
     *   Does not apply to members given a fixed size in pixels - such members will never be
     *   shrunk below their specified size in general.
     *  @type {Integer}
     *  @default "1"
     */
    open var minMemberLength: Number = 1
    /**
     *  Set this property to cause the layout to assign the breadths of other members as if the
     *   available breadth is actually wide enough to accommodate the
     *   minBreadthMember (even though the Layout might not actually be that
     *   wide, and may overflow its assigned size along the breadth axis due to the breadth of the
     *   minBreadthMember.
     *
     *   Without this property set, members of a layout aren't ever expanded in breadth (by the
     *   layout) to fit an overflow of the layout along the breadth axis. Setting this property
     *   will make sure all members (other than the one specified) get expanded to fill the full
     *   visual breadth of the layout (assuming they are configured to use 100% layout breadth).
     *  @type {string | Integer | Canvas}
     *  @default null
     */
    open var minBreadthMember: dynamic = null
    /**
     *  Whether the layout policy is continuously enforced as new members are added or removed
     *   and as members are resized.
     *
     *   This setting implies that any member that resizes larger, or any added member, will take
     *   space from other members in order to allow the overall layout to stay the same size.
     *  @type {boolean}
     *  @default true
     */
    open var enforcePolicy: Boolean = true
    /**
     *  Specifies the default alignment for layout members on the breadth axis (horizontal axis
     *   for a VLayout, vertical axis for an HLayout). Can be overridden on a per-member basis
     *   by setting Canvas.layoutAlign.
     *
     *   If unset, default member layout alignment will be "top" for a horizontal layout, and
     *   "left" for a vertical layout, or "right" if in Page.isRTL mode.
     *
     *   When attempting to center components be sure that you have set a specific size on the
     *   component(s) involved. If components fill all available space in the layout, centering
     *   looks the same as not centering.
     *
     *   Similarly, if a component has no visible boundary (like a border), it can appear similar
     *   to when it's not centered if the component is larger than you expect - use the Watch tab
     *   in the Developer Console to see the component's extents visually.
     *  @type {Alignment | VerticalAlignment}
     *  @default null
     */
    open var defaultLayoutAlign: dynamic = null
    /**
     *  Alignment of all members in this Layout on the length axis (vertical for a VLayout,
     *   horizontal for an HLayout). Defaults to "top" for vertical Layouts, and "left" for
     *   horizontal Layouts.
     *
     *   Horizontal layouts should only be set to Alignment, and vertical layouts to
     *   VerticalAlignment, otherwise they will be considered invalid values, and assigning an
     *   invalid value here will log a warning to the Developer Console.
     *
     *   For alignment on the breadth axis, see Layout.defaultLayoutAlign and
     *   Canvas.layoutAlign.
     *
     *   When attempting to center components be sure that you have set a specific size on the
     *   component(s) involved. If components fill all available space in the layout, centering
     *   looks the same as not centering.
     *
     *   Similarly, if a component has no visible boundary (like a border), it can appear similar
     *   to when it's not centered if the component is larger than you expect - use the Watch tab
     *   in the Developer Console to see the component's extents visually.
     *  @type {Alignment | VerticalAlignment}
     *  @default null
     */
    open var align: dynamic = null
    /**
     *  Reverse the order of stacking for this Layout, so that the last member is shown first.
     *
     *   Requires a manual call to reflow() if changed on the fly.
     *
     *   In RTL mode, for horizontal Layouts the value of this flag will be flipped during
     *   initialization.
     *  @type {boolean}
     *  @default false
     */
    open var reverseOrder: Boolean = false
    /**
     *  If this widget has padding specified (as Canvas.padding or in the
     *   CSS style applied to this layout), should it show up as space outside the members,
     *   similar to layoutMargin?
     *
     *   If this setting is false, padding will not affect member positioning (as CSS padding
     *   normally does not affect absolutely positioned children). Leaving this setting true
     *   allows a designer to more effectively control layout purely from CSS.
     *
     *   Note that Layout.layoutMargin if specified, takes precedence over this value.
     *  @type {boolean}
     *  @default true
     */
    open var paddingAsLayoutMargin: Boolean = true
    /**
     *  Space outside of all members. This attribute, along with Layout.layoutLeftMargin
     *   and related properties do not have a true setter method.
     *
     *   It may be assigned directly at runtime. After setting the property,
     *   Layout.setLayoutMargin may be called with no arguments to reflow the layout.
     *
     *  @type {Integer}
     *  @default null
     */
    open var layoutMargin: Number? = null
    /**
     *  Space outside of all members, on the left-hand side. Defaults to Layout.layoutMargin.
     *
     *   Requires a manual call to setLayoutMargin() if changed on the fly.
     *  @type {Integer}
     *  @default null
     */
    open var layoutLeftMargin: Number? = null
    /**
     *  Space outside of all members, on the right-hand side. Defaults to Layout.layoutMargin.
     *
     *   Requires a manual call to setLayoutMargin() if changed on the fly.
     *  @type {Integer}
     *  @default null
     */
    open var layoutRightMargin: Number? = null
    /**
     *  Space outside of all members, on the top side. Defaults to Layout.layoutMargin.
     *
     *   Requires a manual call to setLayoutMargin() if changed on the fly.
     *  @type {Integer}
     *  @default null
     */
    open var layoutTopMargin: Number? = null
    /**
     *  Space outside of all members, on the bottom side. Defaults to Layout.layoutMargin.
     *
     *   Requires a manual call to setLayoutMargin() if changed on the fly.
     *  @type {Integer}
     *  @default null
     */
    open var layoutBottomMargin: Number? = null
    /**
     *  Space between each member of the layout.
     *
     *   Requires a manual call to reflow() if changed on the fly.
     *  @type {Integer}
     *  @default "0"
     */
    open var membersMargin: Number = 0
    /**
     *  Whether to leave a gap for a vertical scrollbar even when one is not actually present.
     *
     *   This setting avoids the layout resizing all members when the vertical scrollbar is
     *   introduced or removed, which can avoid unnecessary screen shifting and improve
     *   performance.
     *  @type {boolean}
     *  @default false
     */
    open var leaveScrollbarGap: Boolean = false
    /**
     *  Number of pixels by which each member should overlap the preceding member, used for
     *   creating an "stack of cards" appearance for the members of a Layout.
     *
     *   memberOverlap can be used in conjunction with Layout.stackZIndex to create
     *   a particular visual stacking order.
     *
     *   Note that overlap of individual members can be accomplished with a negative setting for
     *   Canvas.extraSpace.
     *  @type {PositiveInteger}
     *  @default "0"
     */
    open var memberOverlap: Number = 0
    /**
     *  Policy for whether resize bars are shown on members by default. Note that this setting
     *   changes the effect of Canvas.showResizeBar for members of this layout.
     *  @type {LayoutResizeBarPolicy}
     *  @default "marked"
     */
    open var defaultResizeBars:
            /**
             *  resize bars are only shown on members marked         Canvas.showResizeBar
             *  resize bars are shown on all resizable members that are not explicitly marked       showResizeBar:false, except the last member. Appropriate for a
             *         LayoutPolicy of "fill" (VLayout, HLayout) since the overall space will
             *         always be filled.
             *  resize bars are shown on all resizable members that are not explicitly marked       showResizeBar:false, including the last member. Can be appropriate for a
             *         LayoutPolicy of "none" (VStack, HStack) since the overall size of the
             *         layout is dictated by it's member's sizes.
             *  resize bars are not shown even if members are marked with         Canvas.showResizeBar
             */
            String /* marked |  middle |  all |  none */ = "marked"
    /**
     *  A MultiAutoChild created to resize members of this Layout.
     *
     *   A resize bar will be created for any member of this Layout that has
     *   Canvas.showResizeBar set to true. Resize bars will be
     *   instances of the class specified by Layout.resizeBarClass by default, and will
     *   automatically be sized to the member's breadth, and to the thickness specified by
     *   Layout.resizeBarSize.
     *
     *   To customize the appearance or behavior of resizeBars within some layout a custom
     *   resize bar class can be created by subclassing Splitbar or ImgSplitbar and
     *   setting Layout.resizeBarClass or resizeBarConstructor to this custom class.
     *
     *   Alternatively, resizeBarProperties may be specified. See autoChildUsage
     *   for more information.
     *
     *
     *
     *   The built-in Splitbar class supports drag resizing of its target member,
     *   and clicking on the bar with a mouse to collapse/uncollapse the target member.
     *  @type {Splitbar}
     *  @default "see below"
     */
    // open var resizeBar: Splitbar = definedExternally
    /**
     *  Default class to use for creating Layout.resizeBar. This may be
     *   overridden by resizeBarConstructor.
     *
     *   Classes that are valid by default are Splitbar, ImgSplitbar, and
     *   Snapbar.
     *  @type {string}
     *  @default "Splitbar"
     */
    open var resizeBarClass: String = "Splitbar"
    /**
     *  Thickness of the resizeBar in pixels.
     *  @type {Integer}
     *  @default "7"
     */
    open var resizeBarSize: Number = 7
    /**
     *  If true when members are added / removed, they should be animated as they are shown
     *   or hidden in position
     *  @type {boolean}
     *  @default null
     */
    open var animateMembers: Boolean? = null
    /**
     *  If specified this is the duration of show/hide animations when members are being shown
     *   or hidden due to being added / removed from this layout.
     *  @type {number}
     *  @default null
     */
    open var animateMemberTime: Number? = null
    /**
     *  Layouts provide a default implementation of a drag and drop interaction. If you set
     *   Canvas.canAcceptDrop:true and canDropComponents:true
     *   on a Layout, when a droppable Canvas (Canvas.canDrop is dragged over
     *   the layout, it will show a dropLine (a simple insertion line) at the drop location.
     *
     *   When the drop occurs, the dragTarget (obtained using
     *   EventHandler.getDragTarget) is added as a member of this layout at the location
     *   shown by the dropLine (calculated by Layout.getDropPosition). This default
     *   behavior allows either members or external components that have
     *   Canvas.canDragReposition (or Canvas.canDrag) and Canvas.canDrop set
     *   to true to be added to or reordered within the Layout.
     *
     *   You can control the thickness of the dropLine via Layout.dropLineThickness and
     *   you can customize the style using css styling in the skin file (look for .layoutDropLine
     *   in skin_styles.css for your skin).
     *
     *   If you want to dynamically create a component to be added to the Layout in response to a
     *   drop event you can do so as follows:
     *
     *   isc.VLayout.create({
     *    ...various layout properties...
     *    canDropComponents: true,
     *    drop : function () {
     *     // create the new component
     *     var newMember = isc.Canvas.create();
     *     // add to the layout at the current drop position
     *     // (the dropLine will be showing here)
     *     this.addMember(newMember, this.getDropPosition());
     *     // hide the dropLine that was automatically shown
     *     // by builtin SmartClient methods
     *     this.hideDropLine();
     *    }
     *   });
     *
     *   If you want to completely suppress the builtin drag and drop logic, but still receive drag
     *   and drop events for your own custom implementation, set Canvas.canAcceptDrop to
     *   true and canDropComponents to false on your Layout.
     *  @type {boolean}
     *  @default true
     */
    open var canDropComponents: Boolean = true
    /**
     *  Thickness, in pixels of the dropLine shown during drag and drop when
     *   Layout.canDropComponents is set to true. See the discussion in
     *   Layout for more info.
     *  @type {number}
     *  @default "2"
     */
    open var dropLineThickness: Number = 2
    /**
     *  Controls whether to show a drop-indicator during a drag and drop operation. Set to
     *   false if you either don't want to show drop-lines, or plan to create your own.
     *  @type {boolean}
     *  @default null
     */
    open var showDropLines: Boolean? = null
    /**
     *  If set to true, when a member is dragged out of layout, a visible placeholder canvas
     *   will be displayed in place of the dragged widget for the duration of the drag and drop
     *   interaction.
     *  @type {boolean}
     *  @default null
     */
    open var showDragPlaceHolder: Boolean? = null
    /**
     *  If Layout.showDragPlaceHolder is true, this
     *   properties object can be used to customize the appearance of the placeholder displayed
     *   when the user drags a widget out of this layout.
     *  @type {Canvas}
     *  @default null
     */
    open var placeHolderProperties: Canvas? = null
    /**
     *  For use in conjunction with Layout.memberOverlap, controls the z-stacking order of
     *   members.
     *
     *   If set to "lastOnTop", members stack from the first member at bottom to the last member
     *   at top. If set to "firstOnTop", members stack from the last member at bottom to the
     *   first member at top.
     *  @type {string}
     *  @default null
     */
    open var stackZIndex: String? = null
    /**
     *  If set, a Layout with breadthPolicy:"fill" will specially interpret a percentage breadth on
     *   a member as a percentage of available space excluding the Layout.layoutMargin. If false,
     *   percentages work exactly as for a non-member, with layoutMargins, if any, ignored.
     *  @type {boolean}
     *  @default true
     */
    open var managePercentBreadth: Boolean = true
    /**
     *  If Layout.showDragPlaceHolder is true, this
     *   defaults object determines the default appearance of the placeholder displayed
     *   when the user drags a widget out of this layout.
     *   Default value for this property sets the placeholder Canvas.styleName to
     *   "layoutPlaceHolder"
     *   To modify this object, use Class.changeDefaults
     *  @type {Canvas}
     *  @default null
     */
    open var placeHolderDefaults: Canvas? = null
    /**
     *  Line showed to mark the drop position when components are being dragged onto this Layout.
     *   A simple Canvas typically styled via CSS. The default dropLine.styleName is
     *   "layoutDropLine".
     *  @type {Canvas}
     *  @default null
     */
    open var dropLine: Canvas? = null
    /**
     *  Part of the automatedTesting system, strategy to use when generated
     *   locators for members from within this Layout's members array.
     *  @type {LocatorStrategy}
     *  @default null
     */
    open var locateMembersBy:
            /**
             *  Match by name if possible.
             *  Match by title if possible.
             *  Match by index
             */
            String? /* name |  title |  index */ = null
    /**
     *  LocatorTypeStrategy to use when finding members within this layout.
     *  @type {LocatorTypeStrategy}
     *  @default null
     */
    open var locateMembersType:
            /**
             *  Match by class if possible
             *  Ignore specific class and match by the SmartClient framework superclass.
             *  Ignore class altogether and attempt to match by role
             *  Don't attempt to compare type in any way
             */
            String? /* Class |  scClass |  role |  none */ = null
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "LayoutEditProxy"
     */
    override var editProxyConstructor: String = "LayoutEditProxy"
}

