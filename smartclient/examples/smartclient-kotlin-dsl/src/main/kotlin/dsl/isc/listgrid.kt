package dsl.isc

import isc.*

@ISCDslMarker
open class ListGridProperties : LayoutProperties(), DataBoundComponentProperties {
    /**
     *  The CSS style name applied to the DataBoundComponent.offlineMessage if displayed.
     *  @type {CSSStyleName}
     *  @default "offlineMessage"
     */
    open var offlineMessageStyle: String = "offlineMessage"
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from ListGrid.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     *
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only ListGrid.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = false
    /**
     *  Criteria to be used when ListGrid.autoFetchData is set.
     *
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = null
    /**
     *  Default background color to use when exporting data to Excel/OpenOffice format using
     *   ListGrid.exportData or
     *   ListGrid.exportClientData.
     *
     *   If unset (the default), cells that are not provided a background color by more specific APIs
     *   will be the default background color used by the spreadsheet program where they are viewed.
     *
     *   See exportBGColor for an overview.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportDefaultBGColor: String? = null
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, background color to use
     *   for even-numbered rows, to create a "banded" or "ledger" effect. Odd-numbered rows will
     *   use the ListGrid.exportDefaultBGColor.
     *
     *   See exportBGColor for an overview.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportAlternateRowBGColor: String? = null
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, causes the ListGrid.headerHeight and
     *   HeaderSpan.height to be applied to the corresponding cells in the
     *   spreadsheet.
     *  @type {boolean}
     *  @default false
     */
    open var exportHeaderHeights: Boolean = false
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, whether widths of fields should be replicated
     *   in the resulting spreadsheet.
     *
     *   Because Excel's unit of measurement for field widths is based on the default system font,
     *   there is no exact way to translate field widths in pixels to Excel column widths. The
     *   ListGrid.exportWidthScale property can be set to adjust scaling; it's default value errs on
     *   the side of making Excel's columns slightly wider than the ListGrid field's actual width to
     *   avoid clipping.
     *
     *   Note that you can switch off width export for individual fields with the
     *   ListGridField.exportFieldWidth flag.
     *  @type {boolean}
     *  @default false
     */
    open var exportFieldWidths: Boolean = false
    /**
     *  Scaling factor to translate from ListGrid field widths in pixels to Excel/OpenOffice units
     *   for field width, which are 1/256th of the width of the widest digit character in the default
     *   font for the spreadsheet. See ListGrid.exportFieldWidths for where this is used.
     *  @type {Float}
     *  @default "0.12"
     */
    open var exportWidthScale: Number = 0.12
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, whether titles in the
     *   ListGrid.header and ListGrid.headerSpans should be
     *   allowed to wrap.
     *
     *   Excel will wrap at the column boundary automatically; for explicit control over wrapping,
     *   insert "&lt;br&gt;" tags into your titles.
     *
     *   See also ListGrid.exportFieldWidths for replicating the widths of fields in the exported
     *   spreadsheet.
     *  @type {boolean}
     *  @default false
     */
    open var exportWrapHeaderTitles: Boolean = false
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, whether field
     *   ListGridField.align and
     *   ListGridField.cellAlign should be replicated in the resulting
     *   spreadsheet.
     *
     *   If this attribute is not set, cells will be assigned a default alignment by the spreadsheet,
     *   which is typically right-aligned for numeric and date values, and left-aligned for
     *   everything else (including dates and numbers that have been exported as strings, as would
     *   be the case, for example, if DSRequest.exportDatesAsFormattedString is set)
     *  @type {boolean}
     *  @default false
     */
    open var exportFieldAlignments: Boolean = false
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "GridEditProxy"
     */
    override var editProxyConstructor: String = "GridEditProxy"
    /**
     *  Default CSS class for the ListGrid as a whole.
     *  @type {CSSStyleName}
     *  @default "listGrid"
     */
    override var styleName: String = "listGrid"
    /**
     *  A list of ListGridRecord objects, specifying the data to be used to populate the
     *   ListGrid. In ListGrids, the data array specifies rows.
     *
     *   When using a DataSource, rather than directly providing data, you will
     *   typically call ListGrid.fetchData instead, which will automatically establish
     *   data as a ResultSet (see the ListGrid.fetchData docs for details).
     *
     *   If you call fetchData, any previously supplied data is
     *   discarded. Also, it is not necessary to call setData() after calling
     *   ListGrid.fetchData.
     *
     *   When calling setData(), direct changes
     *   to the list using Framework APIs such as List.add or
     *   List.remove will be automatically observed and the
     *   ListGrid will redraw in response. However, direct changes to individual Records will not
     *   be automatically observed and require calls to ListGrid.refreshCell or
     *   ListGrid.refreshRow to cause the ListGrid to visually update. Calling methods such as
     *   ListGrid.updateData, ListGrid.removeData or ListGrid.addData always causes
     *   automatic visual refresh.
     *
     *   Note that direct manipulation of the data object without using the List APIs (for
     *   example by directly assigning a new Record object to some index or calling non-Framework
     *   APIs such as pop(), shift(), etc.) will not be reflected in the grid automatically, but
     *   developers can call List.dataChanged directly to notify the grid of changes.
     *
     *  @type {Array<Partial<ListGridRecord>>}
     *  @default null
     */
    open var data: Array<dynamic>? = null
    /**
     *  Property name on a record that will be checked to determine whether a record is enabled.
     *
     *   Setting this property on a record will effect the visual style and interactivity of
     *   the record. If set to false the record (row in a ListGrid or
     *   TreeGrid) will not highlight when the mouse moves over it, nor will it respond to
     *   mouse clicks.
     *  @type {string}
     *  @default "enabled"
     */
    open var recordEnabledProperty: String = "enabled"
    /**
     *  Property name on a record that will be checked to determine whether a record can be
     *   expanded.
     *  @type {string}
     *  @default "canExpand"
     */
    open var canExpandRecordProperty: String = "canExpand"
    /**
     *  If set to false on a record and ListGrid.canRemoveRecords is
     *   true, removal of that record is disallowed in the UI. The icon in the remove field
     *   is not shown.
     *  @type {string}
     *  @default "_canRemove"
     */
    open var recordCanRemoveProperty: String = "_canRemove"
    /**
     *  If true, when folders are opened / closed children will be animated into view.
     *
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var animateFolders: Boolean = true
    /**
     *  If ListGrid.animateFolders is true for this grid, this number can be set to designate
     *   the maximum number of rows to animate at a time when opening / closing a folder.
     *
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {Integer}
     *  @default null
     */
    open var animateFolderMaxRows: Number? = null
    /**
     *  When animating folder opening / closing, if TreeGrid.animateFolderSpeed is not
     *   set, this property designates the duration of the animation in ms.
     *
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {number}
     *  @default "100"
     */
    open var animateFolderTime: Number = 100
    /**
     *  When animating folder opening / closing, this property designates the speed of the
     *   animation in pixels shown (or hidden) per second. Takes precedence over the
     *   TreeGrid.animateFolderTime property, which allows the developer to specify a
     *   duration for the animation rather than a speed.
     *
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {number}
     *  @default "3000"
     */
    open var animateFolderSpeed: Number = 3000
    /**
     *  When animating folder opening / closing, this property can be set to apply an
     *   animated acceleration effect. This allows the animation speed to be "weighted", for
     *   example expanding or collapsing at a faster rate toward the beginning of the animation
     *   than at the end.
     *
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateFolderEffect:
            /**
             *  - animation will speed up as time elapses
             *  - animation will slow down as time elapses
             *  - animation will speed up in the middle
             *  - no bias
             */
            String? /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = null
    /**
     *  An array of field objects, specifying the order, layout, formatting, and
     *   sorting behavior of each field in the listGrid object. In ListGrids, the fields
     *   array specifies columns. Each field in the fields array is a ListGridField object.
     *   Any listGrid that will display data should have at least one visible field.
     *
     *   If ListGrid.dataSource is also set, this value acts as a set of overrides as
     *   explained in DataBoundComponent.fields.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    override var fields: Array<dynamic>? = null
    /**
     *  An array of listGrid field configuration objects. When a listGrid is initialized, if this
     *   property is set and there is no value for the fields attribute, this.fields will
     *   be defaulted to a generated array of field objects duplicated from this array.
     *
     *   This property is useful for cases where a standard set of fields will be displayed
     *   in multiple listGrids - for example a subclass of ListGrid intended to display a particular
     *   type of data:
     *   In this example we would not assign a single ListGrid.fields array directly to the
     *   class via addProperties() as every generated instance of this class would
     *   then point to the same fields array object. This would cause unexpected behavior such as
     *   changes to the field order in one grid effecting other grids on the page.
     *   Instead we could use addProperties() on our new subclass to set
     *   defaultFields to a standard array of fields to display. Each generated instance
     *   of the subclass would then show up with default fields duplicated from this array.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    open var defaultFields: Array<dynamic>? = null
    /**
     *  The DataSource that this component should bind to for default fields and for performing
     *   DSRequest.
     *
     *   Can be specified as either a DataSource instance or the String ID of a DataSource.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = null
    /**
     *  If true, for fields where ListGridField.optionDataSource is specified,
     *   a valueMap will be automatically created by making a DataSource.fetchData call
     *   against the specified dataSource and extracting a valueMap from the returned records
     *   based on the displayField and valueField.
     *
     *   If set to false, valueMaps will not be automatically fetched. In this case, setting
     *   field.optionDataSource is effectively a shortcut for setting optionDataSource on
     *   the editor via ListGridField.editorProperties.
     *
     *   Can also be disabled on a per-field basis with ListGridField.autoFetchDisplayMap.
     *  @type {boolean}
     *  @default true
     */
    open var autoFetchDisplayMap: Boolean = true
    /**
     *  If a field has ListGridField.displayField specified and has no
     *   ListGridField.optionDataSource, this field will display the value from the
     *   displayField of each record by default (for more on this behavior
     *   see ListGridField.optionDataSource).
     *
     *   If such a field is editable, changing the edit value for the field on some record,
     *   without updating the edit value for the associated display field on the same record
     *   would mean the user would continue to see the unchanged display field value.
     *   Developers can resolve this situation by programmatically setting an edit value for
     *   the display field as well as the data field, or avoid it by specifying an optionDataSource
     *   and ensuring ListGrid.autoFetchDisplayMap is true, or setting an explicit valueMap
     *   for the field.
     *
     *   By default, when the edit value on a field with a specified displayField and
     *   no optionDataSource is set, we log a warning to notify the developer. This warning may
     *   be disabled by setting warnOnUnmappedValueFieldChange to false.
     *
     *   Note: There are actually a couple of cases in which the system will automatically
     *   derive a new display-field value and apply it to the record:
     *
     *  - If the edit value was changed by a user actually editing the record
     *   (rather than a programmatic call to setEditValue()), and the edit-item had
     *   a valueMap or optionDataSource set, we automatically pick up the display value from
     *   that item and store it as an edit-value for the displayField of the record
     *
     *  - If the listGrid has a loaded record in its data set whose valueField value matches
     *   the edit value for the valueField, we automatically apply the displayField value from that
     *   record as an edit value for the displayField on the newly edited record.
     *   In either case, the display value for the record is updated automatically
     *   (and the warning would not be logged).
     *  @type {boolean}
     *  @default true
     */
    open var warnOnUnmappedValueFieldChange: Boolean = true
    /**
     *  For grids with a specified ListGrid.dataSource, this property can be set to
     *   true to cause the grid directly update its local data set instead of
     *   performing an operation against it's configured DataSource.
     *
     *   When using this mode, data must be provided to the grid via ListGrid.setData,
     *   and must be provided as
     *   a simple Array of Records
     *   . Setting saveLocally is invalid if
     *   either ListGrid.fetchData is called or if a ResultSet is provided as the data
     *   model.
     *
     *   saveLocally mode includes changes made via
     *   ListGrid.canEdit, record removal via ListGrid.canRemoveRecords, as
     *   well as programmatic calls to ListGrid.updateData,
     *   ListGrid.addData and ListGrid.removeData. This
     *   also causes saves to be performed synchronously (unlike normal DataSource operations).
     *
     *   Note that using this mode also disables the automatic cache synchronization provided by
     *   the DataSource system - changes made to this grid are saved only to this grid's data
     *   set.
     *
     *   See also ListGrid.filterLocalData to allow filtering, such as filtering performed
     *   by the ListGrid.filterEditor, to also work only with the local data set.
     *
     *   If saveLocally is unset, and ListGrid.filterLocalData is true, the saveLocally behavior is
     *   enabled by default
     *  @type {boolean}
     *  @default null
     */
    open var saveLocally: Boolean? = null
    /**
     *  For editable grids with a specified ListGrid.dataSource, where
     *   ListGrid.saveLocally is false, this attribute may be used to specify standard
     *   DSRequest properties to apply to all save operations performed by this grid (whether
     *   triggered by user interaction, or explicit saveEdits or saveAllEdits call).
     *
     *   An example usage would be to customize the prompt displayed while saving is in progress
     *   if ListGrid.waitForSave is true.
     *
     *   Note that for more advanced customization of save operations,
     *   DataBoundComponent.addOperation and DataBoundComponent.updateOperation
     *   are available to developers, allowing specification of an explicit OperationBinding
     *   for the add / update operation performed on save.
     *  @type {DSRequest}
     *  @default null
     */
    open var saveRequestProperties: DSRequest? = null

    /**
     *  If ListGrid.saveLocally is specified, but this grid is bound to a DataSource which
     *   includes remote field validators, by default edits will be saved synchronously and
     *   these validators will not be executed.
     *   Set this property to true to ensure these remote validators are called when
     *   saving edits in saveLocally mode. Note that since these remote validators need to run on
     *   the server, saving with this property set is asynchronous, even though the data that
     *   ultimately gets updated is already present on the client.
     *  @type {boolean}
     *  @default null
     */
    open var useRemoteValidators: Boolean? = null
    /**
     *  If true, the set of fields given by the "default binding" (see
     *   DataBoundComponent.fields) is used, with any fields specified in
     *   component.fields acting as overrides that can suppress or modify the
     *   display of individual fields, without having to list the entire set of fields that
     *   should be shown.
     *
     *   If component.fields contains fields that are not found in the DataSource,
     *   they will be shown after the most recently referred to DataSource field. If the new
     *   fields appear first, they will be shown first.
     *
     *   ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component
     *   fields and DataSource fields, and how they interact for validation.
     *
     *   This setting may be cleared if a FieldPicker is used to edit the component's field
     *   order.
     *  @type {boolean}
     *  @default null
     */
    override var useAllDataSourceFields: Boolean? = null
    /**
     *  Whether to include fields marked detail:true from this component's
     *   DataSource.
     *
     *   When this property is true, the ListGrid will include all
     *   detail fields unless fields have been specifically declared using the
     *   ListGrid.fields array.
     *
     *   Any field which has been included directly in the fields array will be
     *   included regardless of the fields detail attribute.
     *
     *   Detail fields included will initially be hidden but the user may show these fields via
     *   the default header context menu (ListGrid.showHeaderContextMenu).
     *
     *   The field's visibility can also be overridden programatically using the standard
     *   ListGrid.showField, ListGrid.hideField and ListGridField.showIf
     *   APIs, for example, set showIf:"true" to show a detail field initially.
     *
     *   Setting this property to false will completely exclude all detail fields from the list
     *   grid's fields array, such that they cannot be shown by the user or programmatically.
     *  @type {boolean}
     *  @default true
     */
    override var showDetailFields: Boolean = true
    /**
     *  Best field to use for a user-visible title for an individual record from this grid.
     *   If ListGrid.dataSource is non null, this property may be specified on the
     *   dataSource instead.
     *
     *   If not explicitly set, titleField looks for fields named "title", "name", and "id"
     *   in that order. If a field exists with one of those names, it becomes the titleField.
     *   If not, then the first field is designated as the titleField.
     *  @type {string}
     *  @default "see below"
     */
    override var titleField: String? = null
    /**
     *  For databound ListGrids, this attribute can be used to customize the ResultSet
     *   object created for this grid when data is fetched
     *  @type {ResultSet}
     *  @default null
     */
    open var dataProperties: ResultSet? = null
    /**
     *  When grouped, a copy of the original ungrouped data.
     *  @type {object}
     *  @default null
     */
    open var originalData: dynamic = null
    /**
     *  The data tree that results from a call to ListGrid.groupBy.
     *   This will be a ResultTree if ListGrid.dataSource is
     *   present, otherwise it will be a Tree.
     *  @type {Tree}
     *  @default null
     */
    open var groupTree: Tree? = null
    /**
     *  Describes the default state of ListGrid groups when groupBy is called.
     *
     *   Possible values are:
     *
     *
     *  - "all": open all groups
     *
     *  - "first": open the first group
     *
     *  - "none": start with all groups closed
     *
     *  - Array of group values that should be opened
     *
     *  @type {GroupStartOpen | Array<any>}
     *  @default "first"
     */
    open var groupStartOpen: dynamic = "first"
    /**
     *  Can a group be collapsed/expanded? When true a collapse/expand icon is shown
     *   (ListGrid.groupIcon) and the user can collapse or expand the group by
     *   clicking either the row as a whole or the opener icon (see ListGrid.collapseGroupOnRowClick);
     *
     *   When false the group icon is not shown and clicking on the row does
     *   not change group state. Additionally GroupStartOpen is
     *   initialized to "all".
     *  @type {boolean}
     *  @default true
     */
    open var canCollapseGroup: Boolean = true
    /**
     *  If ListGrid.canCollapseGroup is true, will a click anywhere on the group row
     *   toggle the group's expanded state? If false, the user must click the
     *   ListGrid.groupIcon directly to toggle the group.
     *  @type {boolean}
     *  @default true
     */
    open var collapseGroupOnRowClick: Boolean = true
    /**
     *  When a list grid is ListGrid.groupBy, each group shows
     *   under an auto generated header node. By default the title of the group will be
     *   shown, with a hanging indent in this node, and will span all columns in the grid.
     *   Setting this property causes the titles of auto-generated group nodes to appear as
     *   though they were values of the designated field instead of spanning all columns
     *   and record values in the designated groupTitleField will appear indented under
     *   the group title in a manner similar to how a TreeGrid shows a Tree.
     *
     *   Note if ListGrid.showGroupSummaryInHeader is true, the header nodes will not show
     *   a single spanning title value by default - instead they will show the summary values for
     *   each field. In this case, if groupTitleField is unset, a
     *   ListGrid.showGroupTitleColumn can be automatically generated to
     *   show the title for each group.
     *  @type {string}
     *  @default null
     */
    open var groupTitleField: String? = null
    /**
     *  If this grid is ListGrid.groupBy and ListGrid.showGroupSummaryInHeader
     *   is true, instead of group header nodes showing up with a single cell value spanning the full
     *   set of columns, summaries for each field will show up in the appropriate columns of the
     *   header node.
     *
     *   In this case there are 2 options for where the group title will show up. Developers may
     *   specify an existing field to put the title values into via ListGrid.groupTitleField.
     *   If no groupTitleField is specified, this property may be set to true
     *   which causes a groupTitleColumn to be automatically generated.
     *   Each group header will show the group title in this column (records within the group will
     *   not show a value for this column). The column appears in the leftmost position within the
     *   grid (unless ListGrid.showRowNumbers is true, in which case this column shows up
     *   in the second-leftmost position), and by default will auto-fit to its data.
     *
     *   To customize this field, developers may modify
     *   ListGrid.groupTitleColumnProperties
     *   or
     *   ListGrid.groupTitleColumnDefaults at the class level.
     *  @type {boolean}
     *  @default true
     */
    open var showGroupTitleColumn: Boolean = true
    /**
     *  Custom properties for the automatically generated groupTitleColumn.
     *
     *   See ListGrid.showGroupTitleColumn for an overview of the groupTitleColumn.
     *  @type {ListGridField}
     *  @default null
     */
    open var groupTitleColumnProperties: ListGridField? = null
    /**
     *  Default properties for the automatically generated groupTitleColumn.
     *   Default object includes properties to enable autoFitWidth to group title values.
     *
     *   To modify the behavior or appearance of this column, developers may set
     *   ListGrid.groupTitleColumnProperties at the instance level, or override this
     *   object at the class level. If overriding this object, we recommend using
     *   Class.changeDefaults rather than replacing this object entirely.
     *
     *   See ListGrid.showGroupTitleColumn for an overview of the groupTitleColumn.
     *  @type {ListGridField}
     *  @default "object"
     */
    //open var groupTitleColumnDefaults: ListGridField = "object"
    /**
     *  If this grid is ListGrid.groupBy, and ListGrid.showGroupSummary
     *   is true, setting this property causes field summary values for each group to be displayed
     *   directly in the group header node, rather than showing up at the bottom of each
     *   expanded group.
     *
     *   Note that this means the group header node will be showing multiple field values
     *   rather than the default display of a single cell spanning all columns containing the
     *   group title. Developers may specify an explicit ListGrid.groupTitleField, or
     *   rely on the automatically generated ListGrid.showGroupTitleColumn
     *   to have group titles be visible as well as the summary values.
     *
     *   Also note that multi-line group summaries are not supported when showing
     *   the group summary in the group header. If multiple
     *   ListGridField.summaryFunction are defined for some field
     *   only the first will be displayed when this property is set to true.
     *  @type {boolean}
     *  @default false
     */
    open var showGroupSummaryInHeader: Boolean = false
    /**
     *  Should group summaries be visible when the group is collapsed?
     *
     *   This property only applies to ListGrid.groupBy grids showing
     *   ListGrid.showGroupSummary. When set to true, the
     *   group summary row(s) for each group will show up under the group header nodes when
     *   the group is collapsed, or at then end of the grouped set of data if the group
     *   is expanded.
     *
     *   This property has no effect if ListGrid.showGroupSummaryInHeader is true.
     *  @type {boolean}
     *  @default false
     */
    open var showCollapsedGroupSummary: Boolean = false
    /**
     *  The CSS style that ListGrid.groupBy rows will have.
     *
     *   Note that this is not a ListGrid.getBaseStyle, so, if this
     *   property is set, group nodes will not show stateful styling
     *   (different styles for ListGrid.showRollOver,
     *   ListGrid.alternateRecordStyles, etc). To enable stateful styling for
     *   groupNodes, set this property to null and specify a
     *   ListGrid.groupNodeBaseStyle
     *  @type {string}
     *  @default "groupNode"
     */
    open var groupNodeStyle: String = "groupNode"
    /**
     *  ListGrid.getBaseStyle for ListGrid.groupBy rows.
     *
     *   Note that this property has no effect if ListGrid.groupNodeStyle is
     *   non null.
     *  @type {string}
     *  @default null
     */
    open var groupNodeBaseStyle: String? = null
    /**
     *  The URL of the base icon for the group icons in this listGrid. Default value may
     *   be overridden by the skinning.
     *  @type {SCImgURL}
     *  @default "[SKINIMG]/TreeGrid/opener.gif"
     */
    open var groupIcon: String = "[SKINIMG]/TreeGrid/opener.gif"
    /**
     *  Default width and height of group icons for this ListGrid.
     *  @type {number}
     *  @default "16"
     */
    open var groupIconSize: Number = 16
    /**
     *  Default number of pixels by which to indent subgroups relative to parent group.
     *  @type {number}
     *  @default "20"
     */
    open var groupIndentSize: Number = 20
    /**
     *  Default number of pixels by which to indent all groups.
     *  @type {number}
     *  @default "10"
     */
    open var groupLeadingIndent: Number = 10
    /**
     *  If false, grouping via context menu will be disabled.
     *  @type {boolean}
     *  @default true
     */
    open var canGroupBy: Boolean = true
    /**
     *  Maximum number of records to which a groupBy can be applied. If there are more records,
     *   grouping will not be available via the default header context menu, and calls to
     *   ListGrid.groupBy will be ignored.
     *
     *   The maximum exists because ListGrid grouping is performed in-browser, hence requires loading of
     *   all records that match the current filter criteria before records can be grouped. The default
     *   maximum represents a number of records which are safe to load in legacy browsers such as Internet
     *   Explorer 8 (modern browsers can handle far more), and is also a good upper limit from the
     *   perspective of loading data from a database.
     *
     *   Going beyond this limit can cause "script running slowly" errors from legacy browsers (as well as
     *   high database load). To build an interface for grouping that handles arbitrary data volume, use
     *   a TreeGrid with TreeGrid.loadDataOnDemand with server-side grouping code.
     *  @type {Integer}
     *  @default "1000"
     */
    open var groupByMaxRecords: Number = 1000
    /**
     *  When grouping is requested with this number of records or more, an asynchronous approach is
     *   used to avoid the browser showing a "script is running slowly.." message prompting the
     *   user to stop execution of JavaScript.
     *
     *   Note that ListGrid.groupByMaxRecords must be set at least as high as ListGrid.groupByAsyncThreshold
     *   or asynchronous grouping will never be used.
     *
     *   During async grouping, interactivity is blocked and the ListGrid.asynchGroupingPrompt is shown
     *   to the user, then hidden when grouping completes; ListGrid.groupByComplete then fires.
     *
     *   Note that this async processing covers grouping only - it does not cover whole grid or
     *   per-group summaries, client-side sort or filter, or other operations that may cause the browser
     *   to show the "script is running slowly" prompt when working with very large sets of records in a
     *   grid.
     *
     *   At this time, there is no generally effective way to avoid this warning dialog appearing with very
     *   large datasets in Microsoft's Internet Explorer (IE). IE's severely flawed detection algorithm for
     *   runaway scripts has been shown to interrupt computations after only 0.2 seconds elapsed time
     *   even if the computation would have finished in 0.3 seconds. Optimizations that reduce
     *   execution time can sometimes trigger the "script running slowly" dialog sooner. Since not
     *   every operation can reasonably be made asynchronous, the current recommendation is to avoid
     *   working with overly large datasets until the affected versions of IE are obsoleted.
     *  @type {Integer}
     *  @default "50"
     */
    open var groupByAsyncThreshold: Number = 50
    /**
     *  If set to false, do not show the ListGrid.asynchGroupingPrompt dialog during
     *   ListGrid.groupByAsyncThreshold.
     *  @type {boolean}
     *  @default null
     */
    open var showAsynchGroupingPrompt: Boolean? = null
    /**
     *  The prompt to display while interactivity is blocked during ListGrid.groupByAsyncThreshold.
     *  @type {HTMLString}
     *  @default "${loadingImage}&amp;nbsp;Grouping data..."
     */
    open var asynchGroupingPrompt: String = "\${loadingImage}&amp;nbsp;Grouping data..."
    /**
     *  True if this listGrid is grouped, false otherwise
     *  @type {boolean}
     *  @default false
     */
    open var isGrouped: Boolean = false
    /**
     *  Default alias to use for groups with no value
     *  @type {string}
     *  @default '-none-'
     */
    open var nullGroupTitle: String = "-none-"
    /**
     *  List of fields to group grid records. If only a single field is used, that field
     *   may be specified as a string. After initialization, use ListGrid.groupBy
     *   to update the grouping field list, instead of modifying groupByField directly.
     *  @type {string | Array<Partial<string>>}
     *  @default "see below"
     */
    open var groupByField: dynamic = "see below"
    /**
     *  Default width and height of value icons for this ListGrid.
     *   Can be overridden at the listGrid level via explicit ListGrid.valueIconWidth and
     *   ListGrid.valueIconHeight, or at the field level via ListGridField.valueIconSize,
     *   ListGridField.valueIconWidth and {ListGridField.valueIconHeight}
     *  @type {number}
     *  @default "16"
     */
    open var valueIconSize: Number = 16
    /**
     *  Width for value icons for this listGrid.
     *   Overrides ListGrid.valueIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    open var valueIconWidth: Number? = null
    /**
     *  Height for value icons for this listGrid.
     *   Overrides ListGrid.valueIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    open var valueIconHeight: Number? = null
    /**
     *  How much padding should there be on the left of valueIcons by default
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    open var valueIconLeftPadding: Number = 2
    /**
     *  How much padding should there be on the right of valueIcons by default
     *  @type {number}
     *  @default "2"
     */
    open var valueIconRightPadding: Number = 2
    /**
     *  Specifies a list of icons that can be used in DataBoundComponent.editHilites.
     *
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, the hilite editing interface shown when DataBoundComponent.editHilites is called
     *   will offer the user a drop down for picking one of these icons when defining either a
     *   simple or advanced hilite rule.
     *
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. DataBoundComponent.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *   This can also be overridden at the field level.
     *  @type {Array<Partial<string>>}
     *  @default "["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]"
     */
    override var hiliteIcons: Array<dynamic> = arrayOf("[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png")
    /**
     *  When ListGrid.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition. Can be overridden at the
     *   field level.
     *  @type {HiliteIconPosition}
     *  @default "before"
     */
    override var hiliteIconPosition:
            /**
             *  icon will be placed before the normal cell contents
             *  icon will be placed after the normal cell contents
             *  icon will be shown instead of the normal cell contents
             */
            String /* before |  after |  replace */ = "before"
    /**
     *  Default width and height of ListGrid.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   ListGrid.hiliteIconWidth and
     *   ListGrid.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = 12
    /**
     *  Width for hilite icons for this component.
     *   Overrides ListGrid.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number? = null
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides ListGrid.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number? = null
    /**
     *  How much padding should there be on the left of ListGrid.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = 2
    /**
     *  How much padding should there be on the right of ListGrid.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = 2
    /**
     *  Default size of thumbnails shown for fieldTypes image and imageFile. Overrideable on a
     *   per-field basis via ListGridField.imageSize or
     *   ListGridField.imageWidth/ListGridField.imageHeight
     *  @type {number}
     *  @default "16"
     */
    open var imageSize: Number = 16
    /**
     *  Header spans are a second level of headers that appear above the normal ListGrid headers,
     *   spanning one or more listGrid fields in a manner similar to a column-spanning cell in an
     *   HTML table.
     *
     *   A header span can be created by simply naming the fields the header should span. The
     *   example below creates a headerSpan that spans the first two fields of the ListGrid.
     *
     *
     *    isc.ListGrid.create({
     *      headerHeight:40,
     *      fields : [
     *        { name:"field1" },
     *        { name:"field2" },
     *        { name:"field3" }
     *      ],
     *      headerSpans : [
     *        {
     *          fields: ["field1", "field2"],
     *          title: "Field 1 and 2"
     *        }
     *      ]
     *    });
     *
     *
     *
     *   Header spans can be nested, allowing fields to be grouped by multiple levels of
     *   granularity. See HeaderSpan.spans for further information on nesting spans.
     *
     *   Header spans will automatically react to resizing of the headers they span, and will be
     *   hidden automatically when all of the spanned fields are hidden.
     *
     *   Header spans appear in the ListGrid.header area of the ListGrid, sharing space
     *   with the existing headers, so it's typical to set ListGrid.headerHeight to
     *   approximately double its normal height when using headerSpans, or if using nested header
     *   spans, the default header height multiplied by the number of levels of header spans to be
     *   shown.
     *
     *   See HeaderSpan for many properties that allow the control of the appearance of
     *   headerSpans.
     *
     *   Note that headerSpans are created via the AutoChild pattern, hence
     *   you can change the SmartClient component being used, or any of its properties.
     *
     *
     *   Neither headerSpans themselves nor the fields within them may be drag reordered, but other
     *   unspanned headers may be.
     *
     *   A span can only span adjacent fields - if a span is defined and the spanned fields don't
     *   sit next to each other in the specified fields array, the fields array will be automatically
     *   reordered to match the order specified in the span's HeaderSpan.fields array.
     *
     *   Note that headerSpans primarily provide a visual cue for grouping multiple headers
     *   together. If you have an OLAP, data "cube" or multi-dimensional data model, the
     *   CubeGrid component is the right choice.
     *  @type {Array<Partial<HeaderSpan>>}
     *  @default null
     */
    open var headerSpans: Array<dynamic>? = null
    /**
     *  Default height for a ListGrid.headerSpans with no height specified.
     *
     *   If headerSpanHeight is not specified (the default), headerSpans will be 1/2
     *   of ListGrid.headerHeight.
     *  @type {Integer}
     *  @default null
     */
    open var headerSpanHeight: Number? = null
    /**
     *  Default alignment for ListGrid.headerSpans with no
     *   HeaderSpan.valign specified.
     *  @type {string}
     *  @default "center"
     */
    open var headerSpanVAlign: String = "center"
    /**
     *  When ListGrid.headerSpans are in use, this property sets the default
     *   vertical alignment for for fields which do not have a headerSpan.
     *  @type {string}
     *  @default null
     */
    open var unspannedHeaderVAlign: String? = null
    /**
     *  SCClassName to use for headerSpans. Typically a Button or
     *   StretchImgButton subclass.
     *
     *   If unset, headerSpans will be created using the ListGrid.headerButtonConstructor.
     *  @type {SCClassName}
     *  @default null
     */
    open var headerSpanConstructor: String? = null
    /**
     *  ListGrid.headerSpans are created via the AutoChild pattern, hence
     *   headerSpanConstructor, headerSpanDefaults and
     *   headerSpanProperties are valid.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var headerSpan: StatefulCanvas? = null
    /**
     *  When ListGrid.headerSpans are in use, whether to show a hierarchical column picker
     *   that includes both headerSpans and normal headers, with normal headers indented under
     *   headerSpans similarly to how a TreeGrid displays a Tree.
     *
     *   If showTreeColumnPicker is false, no column picker will be shown on the
     *   headerSpan itself, and the column picker for a clicked on a normal field header will include
     *   only normal fields.
     *  @type {boolean}
     *  @default true
     */
    open var showTreeColumnPicker: Boolean = true
    /**
     *  Button.baseStyle to apply to the field header buttons for
     *   this ListGrid when showing header spans.
     *   Note that, depending on the ListGrid.headerButtonConstructor of the header
     *   buttons, you may also need to set ListGrid.headerTitleStyle.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var spannedHeaderBaseStyle: String? = null
    /**
     *  If a page is rendered in Page.isRTL, should
     *   cell alignments specified ListGridField.cellAlign be reversed (so
     *   an align:"right" field will have content aligned on the left and
     *   vice versa)?
     *
     *   This is true by default to match user expectation that text flows from
     *   start-to end and is aligned with the start of text flow (left in LTR mode,
     *   right in RTL mode) by default. May be set to false to have the specified
     *   alignments be taken literally in RTL mode.
     *  @type {boolean}
     *  @default true
     */
    open var reverseRTLAlign: Boolean = true
    /**
     *  If this property is true, any mouse click outside of the open cell editors
     *     will end editing mode, hiding the cell editors and saving any changes to those
     *     cell values.
     *  @type {boolean}
     *  @default null
     */
    open var modalEditing: Boolean? = null
    /**
     *  If we're showing the filterEditor (ListGrid.showFilterEditor is true), and we're
     *   re-filtering on every keypress (ListGrid.filterOnKeypress is true), this
     *   property is the delay in milliseconds between the user changing the filter and the
     *   filter request being kicked off. If multiple changes are made to the filter
     *   within this fetch delay, only the most recent will actually cause a re-filter
     *  @type {number}
     *  @default "300"
     */
    open var fetchDelay: Number = 300
    /**
     *  Since ListGrid.body is configured with overflow: auto by default, no overflow
     *   is expected for the ListGrid itself so by default it has overflow: hidden.
     *  @type {Overflow}
     *  @default "hidden"
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
            String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = "hidden"
    /**
     *  Minimum height for the entire list (smaller than this doesn't tend to work very well).
     *   If not set, this value will be defaulted when Canvas.draw is called to something
     *   reasonable based on whether we're showing the ListGrid.showFilterEditor,
     *   ListGrid.showHeader, ListGrid.showGridSummary, and/or the
     *   ListGrid.showEmptyMessage.
     *
     *   Note that any top or bottom CSS padding specified by ListGrid.emptyMessageStyle will be
     *   taken into account, increasing minHeight so that the empty message can be
     *   shown without overflow.
     *  @type {number}
     *  @default "varies"
     */
    override var minHeight: Number? = 14
    /**
     *  Whether all rows should be drawn all at once, or only rows visible in the viewport.
     *
     *   Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling.
     *   With a very large number of rows, showAllRows will become too slow.
     *
     *   See also ListGrid.drawAheadRatio and ListGrid.drawAllMaxCells.
     *  @type {boolean}
     *  @default false
     */
    open var showAllRecords: Boolean = false
    /**
     *  Whether all columns should be drawn all at once, or only columns visible in the viewport.
     *
     *   Drawing all columns causes longer initial rendering time, but allows smoother horizontal
     *   scrolling. With a very large number of columns, showAllColumns will become too slow.
     *  @type {boolean}
     *  @default false
     */
    open var showAllColumns: Boolean = false
    /**
     *  If drawing all rows would cause less than drawAllMaxCells cells to be rendered,
     *   the full dataset will instead be drawn even if ListGrid.showAllRecords
     *   is false and the viewport size and ListGrid.drawAheadRatio setting would normally have caused
     *   incremental rendering to be used.
     *
     *   The drawAllMaxCells setting prevents incremental rendering from being used in
     *   situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200
     *   cells) which happens to be in a grid with a viewport showing only 20 or so rows.
     *   Incremental rendering causes a brief "flash" during scrolling as the visible portion of the
     *   dataset is redrawn, and a better scrolling experience can be obtained in this situation by
     *   drawing the entire dataset up front, which in this example would have negligible effect on
     *   initial draw time.
     *
     *   drawAllMaxCells:0 disables this features. You may want to disable this feature
     *   if performance is an issue and:
     *
     *
     *  - you are very frequently redraw a grid
     *
     *  - you do a lot of computation when rendering each cell (eg formulas)
     *
     *  - you are showing many grids on one screen and the user won't scroll most of them
     *
     *  @type {Integer}
     *  @default "250"
     */
    open var drawAllMaxCells: Number = 250
    /**
     *  How far should we render rows ahead of the currently visible area? This is expressed as a
     *   ratio from viewport size to rendered area size.
     *
     *   Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs
     *   initial render time and render time when scrolling by large amounts.
     *
     *   NOTE: Only applies when showAllRows is false.
     *  @type {Float}
     *  @default "2.0"
     */
    open var drawAheadRatio: Number = 2.0
    /**
     *  Alternative to ListGrid.drawAheadRatio, to be used when the user
     *   is rapidly changing the grids viewport (for example drag scrolling through the grid).
     *   If unspecified ListGrid.drawAheadRatio will be used in all cases
     *  @type {Float}
     *  @default "2.0"
     */
    open var quickDrawAheadRatio: Number = 2.0
    /**
     *  If true, if the user clicks on the scroll buttons at the end of the track or clicks once on
     *   the scroll track, there will be an instant redraw of the grid content so that the user
     *   doesn't see any blank space. For drag scrolling or other types of scrolling, the
     *   ListGrid.scrollRedrawDelay applies.
     *  @type {boolean}
     *  @default true
     */
    open var instantScrollTrackRedraw: Boolean = true
    /**
     *  While drag scrolling in an incrementally rendered grid, time in milliseconds to wait
     *   before redrawing, after the last mouse movement by the user. This delay may be
     *   separately customized for mouse-wheel scrolling via ListGrid.scrollWheelRedrawDelay.
     *
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     *
     *   NOTE: In Browser.isTouch,
     *   GridRenderer.touchScrollRedrawDelay is used instead.
     *  @type {Integer}
     *  @default "0"
     */
    open var scrollRedrawDelay: Number = 0
    /**
     *  Like ListGrid.scrollRedrawDelay, but applies when the component is being
     *   drag-scrolled (via a scrollbar). This value is typically set higher than ListGrid.scrollRedrawDelay
     *   to avoid too many concurrent fetches to the server for ResultSet-backed components
     *   since it's quite easy to induce such a case with a scrollbar and a grid bound to a large databaset.
     *  @type {Integer}
     *  @default "75"
     */
    open var dragScrollRedrawDelay: Number = 75
    /**
     *  While scrolling an incrementally rendered grid, using the mouseWheel, time in
     *   milliseconds to wait before redrawing, after the last mouseWheel movement by the user.
     *   If not specified ListGrid.scrollRedrawDelay will be used as a default for both
     *   drag scrolling and mouseWheel scrolling.
     *
     *   Note that if specified, this value will typically be larger than
     *   ListGrid.scrollRedrawDelay. From experimentation, the default setting of
     *   250 is typically enough time for a user to rapidly scroll through a
     *   grid (rotating the scroll wheel with repeated flicks), without redrawing between
     *   rotations, but this will differ depending on how long the redraw takes. A larger
     *   delay may be warranted for grids with large numbers of columns, heavy custom
     *   formatting, etc.
     *
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     *  @type {Integer}
     *  @default "0"
     */
    open var scrollWheelRedrawDelay: Number = 0
    /**
     *  While scrolling an incrementally rendered grid, using the inertial scrolling, time in
     *   milliseconds to wait before redrawing, after the last touchScroll by the user.
     *   If not specified ListGrid.scrollRedrawDelay will be used as a default for both
     *   drag scrolling and touch scrolling.
     *
     *   Note that if specified, this value will typically be larger than
     *   ListGrid.scrollRedrawDelay.
     *
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     *  @type {Integer}
     *  @default "0"
     */
    open var touchScrollRedrawDelay: Number = 0
    /**
     *  When incremental rendering is switched on and there are variable record heights, the virtual
     *   scrolling mechanism manages the differences in scroll height calculations due to the
     *   unknown sizes of un-rendered rows to make the scrollbar and viewport appear correctly.
     *
     *   When the virtualScrolling system is active, the last scroll position
     *   scrolls the last record to the top of the viewport, leaving blank space underneath.
     *   This is a necessary and unavoidable consequence of mapping the position of the scrollbar
     *   thumb to an unknown amount of remaining space without being able to know the total
     *   scrollable area in advance (since record heights vary).
     *
     *   virtualScrolling is switched on automatically when ListGrid.fixedRecordHeights is false and
     *   also when
     *   using the ListGrid.showRecordComponents, as
     *   recordComponents expand the rows that contain them. This flag should be manually enabled
     *   when calling ListGrid.addEmbeddedComponent if embedded components can
     *   cause record sizes to expand beyond specified cellHeight.
     *
     *   virtualScrolling is also automatically enabled when ListGrid.canExpandRecords is true
     *   to handle the fact that expanded rows may render at variable heights.
     *  @type {boolean}
     *  @default null
     */
    open var virtualScrolling: Boolean? = null
    /**
     *  When using ListGrid.dataFetchMode, how many records to fetch at a time. If set to
     *   a positive integer, dataPageSize will override the default
     *   ResultSet.resultSize for ResultSets automatically created when you call
     *   ListGrid.fetchData (and similarly for the ResultTree.resultSize of
     *   ResultTrees). Leaving dataPageSize at its default means to just use the default page
     *   size of the data container.
     *
     *   Note that regardless of the dataPageSize setting, a component will always fetch
     *   all of data that it needs to draw. Settings such as
     *   ListGrid.showAllRecords,
     *   ListGrid.drawAllMaxCells and
     *   ListGrid.drawAheadRatio can cause more rows than the configured
     *   dataPageSize to be fetched.
     *  @type {Integer}
     *  @default null
     */
    override var dataPageSize: Number? = null
    /**
     *  How to fetch and manage records retrieve from the server. See FetchMode.
     *
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchMode applies.
     *  @type {FetchMode}
     *  @default "paged"
     */
    override var dataFetchMode:
            /**
             *  All records that match the current filter are fetched. Sorting is        performed on the client.
             *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
             *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
             */
            String /* basic |  paged |  local */ = "paged"
    /**
     *  Delay in milliseconds before fetching data.
     *
     *   Note: the floor value for this attribute is 1. If you set this value to zero, it will
     *   be defaulted to 1 for you instead.
     *  @type {Integer}
     *  @default "1"
     */
    override var dataFetchDelay: Number = 1
    /**
     *  GridRenderer used to render the dataset.
     *
     *   Note that this is a multi-instance component when there are frozen fields because in
     *   addition to the primary body AutoChild, a "frozen body" AutoChild is created to render
     *   the frozen portion of the dataset.
     *  @type {GridRenderer}
     *  @default null
     */
    open var body: GridRenderer? = null
    /**
     *  Overflow setting for the "body", that is, the area of the grid where data values are
     *   rendered.
     *
     *   This is a very advanced setting which is typically only changed by subclasses
     *   of ListGrid which never show a header. To achieve auto-fitting, instead use properties
     *   such as ListGrid.autoFitData, ListGrid.autoFitFieldWidths and
     *   ListGrid.fixedRecordHeights.
     *  @type {Overflow}
     *  @default "auto"
     */
    open var bodyOverflow:
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
            String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = "auto"
    /**
     *  Background color applied to the ListGrid body (that is, the area of the grid where
     *   data values are rendered).
     *   Note that this will typically not be visible to the user unless there are few enough
     *   rows that there is visible space in the body below the last row. To style data cells,
     *   override ListGrid.baseStyle instead.
     *  @type {string}
     *  @default "white"
     */
    open var bodyBackgroundColor: String = "white"
    /**
     *  CSS style used for the body of this grid. If applying a background-color to the body
     *   via a CSS style applied using this property, be sure to set
     *   ListGrid.bodyBackgroundColor to null.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var bodyStyleName: String? = null
    /**
     *  The value to display for cells whose value is null or the empty string after applying
     *   ListGrid.formatCellValue and valueMap (if any).
     *
     *   This is the grid-wide attribute. You may also set the emptyCellValue on a per-field basis.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var emptyCellValue: String = "&amp;nbsp;"
    /**
     *  The minimum height of each row in pixels.
     *  @type {number}
     *  @default "20"
     */
    open var minimumCellHeight: Number = 20
    /**
     *  The default height of each row in pixels.
     *  @type {number}
     *  @default "20"
     */
    open var cellHeight: Number = 20
    /**
     *  If ListGrid.baseStyle is unset, base style will be derived from
     *   ListGrid.normalBaseStyle if this grid has fixed row heights and
     *   the specified ListGrid.cellHeight matches this value. Otherwise
     *   ListGrid.tallBaseStyle will be used.
     *  @type {number}
     *  @default "20"
     */
    open var normalCellHeight: Number = 20
    /**
     *  Should we vertically clip cell contents, or allow rows to expand vertically to show all
     *   contents?
     *
     *   If we allow rows to expand, the row height as derived from
     *   GridRenderer.getRowHeight or the
     *   default ListGrid.cellHeight is treated as a minimum.
     *
     *   Setting fixedRecordHeights to false enables the ListGrid.virtualScrolling
     *   system.
     *
     *   NOTE:
     *
     *  - Setting fixedRecordHeights to false for CubeGrid is not supported, though a
     *   similar option for the row headers is available as CubeGrid.autoSizeHeaders.
     *
     *  - By default, for performance reasons, clipping is not enforced for
     *   some kinds of content (such as images) on all browsers. Set
     *   ListGrid.enforceVClipping to enforce clipping for
     *   all types of content on all browsers.
     *
     *  @type {boolean}
     *  @default true
     */
    open var fixedRecordHeights: Boolean = true
    /**
     *  For performance reasons, even when ListGrid.fixedRecordHeights is set, vertical clipping
     *   is not enforced by default for some kinds of content (such as images) on all browsers.
     *   Set ListGrid.enforceVClipping to enforce clipping for all types of
     *   content on all browsers.
     *
     *   This additional setting is likely to be phased out as browsers improve.
     *  @type {boolean}
     *  @default false
     */
    open var enforceVClipping: Boolean = false
    /**
     *  Should we horizontally clip cell contents, or allow columns to expand horizontally to
     *   show all contents?
     *
     *   If we allow columns to expand, the column width is treated as a minimum.
     *
     *   NOTE: the header does not automatically respond to expanded field widths.
     *   If your grid is showing a header we'd recommend developers consider
     *   setting ListGrid.autoFitFieldWidths rather than using this attribute.
     *  @type {boolean}
     *  @default true
     */
    open var fixedFieldWidths: Boolean = true
    /**
     *  Should this ListGrid automatically expand to accommodate the size of records and fields?
     *
     *   Valid settings are
     *
     *  - "vertical": expand vertically to accommodate records.
     *
     *  - "horizontal": expand horizontally to accommodate fields.
     *
     *  - "both": expand horizontally and vertically to accommodate content.
     *
     *   How far the ListGrid will expand may be limited via the following properties:
     *   ListGrid.autoFitMaxHeight, ListGrid.autoFitMaxRecords,
     *   ListGrid.autoFitMaxWidth, ListGrid.autoFitMaxColumns.
     *
     *   Note that this property causes the grid as a whole to expand to fit records or fields.
     *   To have the fields or records themselves expand to fit cell contents, see
     *   ListGrid.autoFitFieldWidths and ListGrid.fixedRecordHeights.
     *  @type {Autofit}
     *  @default null
     */
    open var autoFitData:
            /**
             *  expand vertically to accommodate records.
             *  expand horizontally to accommodate fields.
             *  expand horizontally and vertically to accommodate content.
             */
            String? /* vertical |  horizontal |  both */ = null
    /**
     *  If ListGrid.autoFitData is set to "vertical" or "both" this
     *   property provides an upper limit on how far the ListGrid will expand vertically to accommodate
     *   its content. If content exceeds this height, scrollbars will be introduced as usual.
     *   In addition to this property, ListGrid.autoFitMaxRecords allows you to limit vertical
     *   expansion based on the number of rows to be rendered.
     *  @type {Integer}
     *  @default null
     */
    open var autoFitMaxHeight: Number? = null
    /**
     *  If ListGrid.autoFitData is set to "vertical" or "both" this
     *   property provides the maximum number of records for which the ListGrid will expand. If more
     *   records are present, scrolling will be introduced to reach them as normal.
     *   If unset, by default the ListGrid will expand to accommodate as many records as are present.
     *  @type {Integer}
     *  @default "50"
     */
    open var autoFitMaxRecords: Number? = 50
    /**
     *  If ListGrid.autoFitData is set to "vertical" or "both",
     *   setting this property will cause the ListGrid body to size large enough to accomodate
     *   the actual data and also leave this many extra rows' worth of blank space below the last
     *   record. If a maximum size is specified via ListGrid.autoFitMaxHeight or
     *   ListGrid.autoFitMaxRecords, it will still be respected. Once the data set
     *   is large enough to fill or exceed that space, this property no longer has an effect.
     *  @type {Integer}
     *  @default null
     */
    open var autoFitExtraRecords: Number? = null
    /**
     *  If ListGrid.autoFitData is set to "horizontal" or "both"
     *   this property provides an upper limit on how far the ListGrid will expand horizontally to
     *   accommodate its content. Value may be specified as a numeric pixel value or
     *   a percentage value.
     *
     *   If content exceeds this width, scrollbars will be introduced as usual.
     *   In addition to this property, ListGrid.autoFitMaxColumns allows you to limit
     *   horizontal expansion based on the number of columns to be rendered.
     *  @type {Integer | string}
     *  @default null
     */
    open var autoFitMaxWidth: dynamic = null
    /**
     *  If ListGrid.autoFitData is set to "horizontal" or "both"
     *   this property provides the maximum number of columns for which the ListGrid will expand.
     *   If more columns are present, scrolling will be introduced to reach them as normal.
     *   If unset the ListGrid will expand to accommodate as many columns as are defined for the
     *   grid.
     *  @type {Integer}
     *  @default "50"
     */
    open var autoFitMaxColumns: Number = 50
    /**
     *  Can the user perform one-time autofit for specific columns in this grid?
     *
     *   If set to true, the default header menu will include options to auto fit
     *   ListGrid.autoFitAllText such that they fit their
     *   content or titles as specified via ListGridField.autoFitWidthApproach.
     *   Autofitting of individual fields via a
     *   ListGrid.autoFitFieldText, or the
     *   ListGrid.headerAutoFitEvent will also be enabled when this
     *   property is set unless ListGridField.canAutoFitWidth is explicitly set to false
     *
     *   Note that the ability to perform one-time autofitting of fields via this
     *   subsystem is separate from the programmatic autofit behavior enabled
     *   via ListGrid.autoFitFieldWidths.
     *
     *   This subsystem is requires canResizeFields be enabled and will be disabled if
     *   that property is set to false
     *  @type {boolean}
     *  @default true
     */
    open var canAutoFitFields: Boolean = true
    /**
     *  Event on a ListGrid header that triggers auto fitting to data and/or title.
     *
     *   Note that if sorting is enabled for the field and the headerAutoFitEvent is "click", both
     *   sorting and autofit occur on a click.
     *
     *   Only has an impact when ListGrid.canAutoFitFields or
     *   ListGridField.canAutoFitWidth is set to true.
     *  @type {AutoFitEvent}
     *  @default "doubleClick"
     */
    open var headerAutoFitEvent:
            /**
             *  React to a double click on the listGrid header.
             *  React to a click on the listGrid header.
             *  No event will trigger auto-fit.
             */
            String /* doubleClick |  click |  none */ = "doubleClick"
    /**
     *  Should ListGrid fields autofit their widths to titles or content?
     *   This property may be overridden on a per-field basis via ListGridField.autoFitWidth.
     *   Developers may wish to consider disabling autoFit for fields known to have
     *   exceptionally long content as this can lead to large horizontal scrollbars and unwieldy UI.
     *
     *   The ListGrid.autoFitWidthApproach controls whether fitting is to values, titles
     *   or both. This property may also be overridden on a per field basis.
     *
     *   If ListGridField.width is also set on the field, it will be taken as a minimum width.
     *   ListGrid.minFieldWidth will also be respected.
     *
     *   By default, the entire available width of the grid will still be used, by allocating any "extra"
     *   space to specific columns - see ListGrid.autoFitFieldsFillViewport for details on
     *   controlling this behavior.
     *
     *   When this feature is enabled, autofitting is active on an ongoing basis.
     *   Autofitting will be performed:
     *
     *
     *  - whenever the dataset is completely changed or rows are added or removed
     *
     *  - whenever a field which is autofitting is changed
     *
     *  - on a manual call to ListGrid.autoFitField or
     *      ListGrid.autoFitFields
     *
     *   Auto-fitting behavior continues until the user resizes the field manually, at which
     *   point it stops. The user can also perform a one-time auto-fit of fields via
     *   the header context menu if ListGrid.canAutoFitFields is enabled.
     *
     *   When autofitting to column values, ListGrid.getDefaultFieldWidth will be
     *   called to determine the space required for a field's values. This method
     *   uses values from the rendered set of rows to calculate the required column width, which means the
     *   field width may still be smaller than values from non-rendered rows. See
     *   ListGrid.showAllRecords and ListGrid.drawAheadRatio) to control incremental
     *   rendering of rows.
     *
     *   Note that for icon type fields, the ListGrid.autoFitIconFields
     *   property setting may turn on auto-fit-width behavior for specific fields by default,
     *   even if autoFitFieldWidths is false for the grid as a whole.
     *
     *   Using this feature has a performance penalty roughly comparable to always rendering
     *   one additional field per field where autofitting is enabled. Specifically, enabling it
     *   for all fields would be comparable to both doubling the number of fields
     *   and disabling ListGrid.showAllColumns.
     *   In a grid where only half the fields are normally visible and hence only half are
     *   normally rendered, this would be roughly 4 times slower overall.
     *
     *   This performance penalty is a result of ListGrid.getDefaultFieldWidth having to
     *   render out the data set offscreen and measure the rendered content - it does not apply
     *   for cases where this method can return a simple fixed values (as with icon fields).
     *
     *   Which fields are currently autofitting is saved as part of the
     *   ListGrid.getViewState of the ListGrid.
     *  @type {boolean}
     *  @default null
     */
    open var autoFitFieldWidths: Boolean? = null
    /**
     *  If this listGrid has specified ListGrid.headerSpans, setting this
     *   attribute to true will cause spans to expand to accommodate long titles if necessary.
     *  @type {boolean}
     *  @default false
     */
    open var autoSizeHeaderSpans: Boolean = false
    /**
     *  If ListGrid.autoFitFieldWidths is enabled and the calculated field sizes
     *   are wide enough that horizontal scrolling would be introduced, this attribute may be
     *   set to an array of fieldNames, causing those fields to be clipped rather than
     *   forcing horizontal scrollbars to appear.
     *
     *   Note: If any ListGridField.frozen are included in this list they
     *   will not be clipped.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var autoFitClipFields: Array<dynamic>? = null
    /**
     *  If ListGrid.autoFitFieldWidths is enabled, and extra space is available after
     *   autofitting all fields, should the grid automatically expand one field to fill the extra
     *   space.
     *
     *   When enabled, the field to expand may be specified via ListGrid.autoFitExpandField.
     *
     *   Note this logic will not expand a ListGridField.frozen.
     *  @type {boolean}
     *  @default true
     */
    open var autoFitFieldsFillViewport: Boolean = true
    /**
     *  The field to expand if ListGrid.autoFitFieldWidths and
     *   ListGrid.autoFitFieldsFillViewport are enabled and
     *   auto-fitting will not fill all available horizontal space.
     *
     *   If unset, will default to the text field with the longest
     *   DataSourceField.length if length is set, otherwise, the first text
     *   field with no width specified.
     *
     *   Note that expanding ListGridField.frozen is not supported.
     *  @type {string}
     *  @default null
     */
    open var autoFitExpandField: String? = null
    /**
     *  When a user requests column autofitting via the
     *   ListGrid.getHeaderContextMenuItems or via a
     *   ListGrid.headerAutoFitEvent, what autofit approach is used.
     *  @type {AutoFitWidthApproach}
     *  @default "value"
     */
    open var autoFitWidthApproach:
            /**
             *  Size field to fit to the data value(s) contained in the field.
             *  Size field to fit the field title
             *  Size field to fit either the field title or the data values in the field (whichever requires more space).
             */
            String /* value |  title |  both */ = "value"
    /**
     *  SmartClient listGrids have special logic to automatically size fields that
     *   are displayed as an icon - that is fields with
     *   ListGridFieldType, fields displaying only
     *   ListGridField.showValueIconOnly, and boolean fields (which
     *   are rendered as a checkmark type icon by default.
     *
     *   This attribute controls this behavior - governing whether icon fields should
     *   be sized to fit their content (icon), title, or whether to disable this
     *   behavior. Setting this value to "title" or "iconWidth"
     *   will cause ListGridField.autoFitWidth to be enabled by default for all
     *   icon fields with the ListGridField.autoFitWidthApproach set to
     *   "value" or "both" as appropriate. Note that the
     *   width required for the icons is calculated by ListGrid.getDefaultFieldWidth
     *   which performs a simple calculation based on the specified icon width for these
     *   types of fields.
     *
     *   This setting governs default behavior for icon fields - for specific fields within
     *   a grid, this default behavior can be overridden by setting an explicit
     *   ListGridField.width or
     *   explicitly enabling ListGridField.autoFitWidth and setting
     *   ListGridField.autoFitWidthApproach on the field in question.
     *  @type {AutoFitIconFieldType}
     *  @default "title"
     */
    open var autoFitIconFields:
            /**
             *  Apply no special sizing to icon fields - treat them like any other  field in the grid
             *  size the field to accommodate the width of the icon
             *  size the field to accommodate the title (or the width of the icon if  it exceeds the width of the title.
             */
            String /* none |  iconWidth |  title */ = "title"
    /**
     *  Should listGrids automatically size date fields to fit their values or titles?
     *   If set to "value", fields of type date will be rendered at the
     *   size specified by ListGrid.defaultDateFieldWidth,
     *   (or ListGrid.defaultEditableDateFieldWidth for editable fields). This static
     *   value is appropriate for dates rendered with the standard short-date formatter.
     *   If set to "title" or "both", the drawn width of the title
     *   will be taken into account when sizing the column.
     *
     *   This is achieved by enabling ListGridField.autoFitWidth
     *   on date fields when this property is set to anything other than "none",
     *   setting the ListGridField.autoFitWidthApproach to the value specified here
     *   and having logic in ListGrid.getDefaultFieldWidth pick up the
     *   ListGrid.defaultDateFieldWidth or ListGrid.defaultEditableDateFieldWidth
     *   if appropriate.
     *  @type {AutoFitWidthApproach}
     *  @default "value"
     */
    open var autoFitDateFields:
            /**
             *  Size field to fit to the data value(s) contained in the field.
             *  Size field to fit the field title
             *  Size field to fit either the field title or the data values in the field (whichever requires more space).
             */
            String /* value |  title |  both */ = "value"
    /**
     *  Default width for date type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultDateFieldWidth: Number = 60
    /**
     *  Default width for editable date type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultEditableDateFieldWidth: Number = 94
    /**
     *  Default width for datetime type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultDateTimeFieldWidth: Number = 92
    /**
     *  Default width for editable datetime type fields. See ListGrid.autoFitDateFields
     *   for details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultEditableDateTimeFieldWidth: Number = 130
    /**
     *  Should listGrids automatically size time fields to fit their values or titles?
     *   If set to "value", fields of type time will be rendered at the
     *   size specified by ListGrid.defaultTimeFieldWidth. This static
     *   value is appropriate for dates rendered with the standard time formatter.
     *   If set to "title" or "both", the drawn width of the title
     *   will be taken into account when sizing the column.
     *
     *   This is achieved by enabling ListGridField.autoFitWidth
     *   on date fields when this property is set to anything other than "none",
     *   setting the ListGridField.autoFitWidthApproach to the value specified here
     *   and having logic in ListGrid.getDefaultFieldWidth pick up the
     *   ListGrid.defaultTimeFieldWidth if appropriate.
     *  @type {AutoFitWidthApproach}
     *  @default "value"
     */
    open var autoFitTimeFields:
            /**
             *  Size field to fit to the data value(s) contained in the field.
             *  Size field to fit the field title
             *  Size field to fit either the field title or the data values in the field (whichever requires more space).
             */
            String /* value |  title |  both */ = "value"
    /**
     *  Default width for time type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultTimeFieldWidth: Number = 65
    /**
     *  Whether to leave a gap for the vertical scrollbar, even when it's not present.
     *
     *   Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields
     *   will be resized to fit the smaller body area if possible, in order to avoid horizontal
     *   scrolling also being required.
     *  @type {boolean}
     *  @default true
     */
    override var leaveScrollbarGap: Boolean = true
    /**
     *  Should content within cells be allowed to wrap?
     *
     *   Even if content is allowed to wrap, if ListGrid.fixedRecordHeights is set, the content
     *   will be clipped off at the cell boundary. Either set a larger, fixed ListGrid.cellHeight
     *   to reveal more content, or set ListGrid.fixedRecordHeights to false to allow auto-sizing.
     *  @type {boolean}
     *  @default false
     */
    open var wrapCells: Boolean = false
    /**
     *  If true and a cell's value is clipped, then a hover containing the full cell value is
     *   enabled.
     *
     *   Note that standard cell hovers override clipped value hovers. Thus, to enable clipped value
     *   hovers, ListGrid.canHover must be unset or null and the corresponding field must have
     *   ListGridField.showHover unset or null as well.
     *  @type {boolean}
     *  @default null
     */
    open var showClippedValuesOnHover: Boolean? = null
    /**
     *  The amount of empty space, in pixels, surrounding each value in its cell.
     *  @type {number}
     *  @default "2"
     */
    open var cellPadding: Number = 2
    /**
     *  How should Date type values be displayed in this ListGrid by default?
     *
     *   This property specifies the default DateDisplayFormat to apply to Date values
     *   displayed in this grid for all fields except those of ListGridField.type
     *   (See also ListGrid.timeFormatter).
     *   If ListGrid.datetimeFormatter is specified, that will be applied by default
     *   to fields of type "datetime".
     *
     *   Note that if ListGridField.dateFormatter or ListGridField.timeFormatter are
     *   specified those properties will take precedence over the component level settings.
     *
     *   If unset, date values will be formatted according to the system wide
     *   DateUtil.setShortDisplayFormat or
     *   DateUtil.setShortDatetimeDisplayFormat for
     *   datetime type fields.
     *
     *   If this field is editable the dateFormatter will also be passed to the editor created
     *   to edit this field as DateItem.dateFormatter.
     *   In this case you may also need to set ListGrid.dateInputFormat.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateFormatter:
            /**
             *  Default native browser 'toString()' implementation. May vary by browser.
             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
             *   Example: Friday, November 04, 2005 11:03:00 AM
             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
             *
             *
             *   Note: In addition to these standard formats, custom formatting can be set by passing
             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
             *   function will then be executed whenever the appropriate formatter method is called [eg
             *   Date.toNormalDate], in the scope of the date instance in question.
             *
             *   Custom formatting can also be applied by passing a FormatString instead of a
             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
             *   the FormatString docs for details.
             */
            String? /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = null
    /**
     *  Display format to use for fields specified as type 'datetime'. Default is to use the
     *   system-wide default date time format, configured via
     *   DateUtil.setShortDatetimeDisplayFormat. Specify any
     *   valid DateDisplayFormat to change the display format for datetimes used by this grid.
     *
     *   May be specified as a function. If specified as a function, this function will be executed in the scope of the Date
     *   and should return the formatted string.
     *
     *
     *   May also be specified at the field level via
     *   ListGridField.dateFormatter
     *
     *   If this field is editable the dateFormatter will also be passed to the editor created
     *   to edit this field as DateItem.dateFormatter.
     *   In this case you may also need to set ListGrid.dateInputFormat.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var datetimeFormatter:
            /**
             *  Default native browser 'toString()' implementation. May vary by browser.
             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
             *   Example: Friday, November 04, 2005 11:03:00 AM
             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
             *
             *
             *   Note: In addition to these standard formats, custom formatting can be set by passing
             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
             *   function will then be executed whenever the appropriate formatter method is called [eg
             *   Date.toNormalDate], in the scope of the date instance in question.
             *
             *   Custom formatting can also be applied by passing a FormatString instead of a
             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
             *   the FormatString docs for details.
             */
            String? /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = null
    /**
     *  If this is an editable listGrid, this property will specify the
     *   DateItem.inputFormat applied to editors for fields of type
     *   "date". May be overridden per field via ListGridField.inputFormat.
     *  @type {DateInputFormat}
     *  @default null
     */
    open var dateInputFormat: String? = null
    /**
     *  Display format to use for fields specified as type 'time'. May also be specified at
     *   the field level via ListGridField.timeFormatter.
     *   If unset, time fields will be formatted based on the system wide
     *   Time.shortDisplayFormat.
     *   If this field is editable, the timeFormatter will also be passed to the editor
     *   created to edit any time type fields as TimeItem.timeFormatter
     *  @type {TimeDisplayFormat}
     *  @default "toShortPaddedTime"
     */
    open var timeFormatter:
            /**
             *  String will display with seconds and am/pm indicator:[H]H:MM:SS am|pm.
             *   Example: 3:25:15 pm
             *  String will display with seconds in 24 hour time: [H]H:MM:SS.
             *   Example: 15:25:15
             *  String will display with seconds, with a 2 digit hour and am/pm indicator:
             *   HH:MM:SS am|pm
             *   Example: 03:25:15 pm
             *  String will display with seconds, with a 2 digit hour in 24 hour format:
             *   HH:MM:SS
             *   Examples: 15:25:15, 03:16:45
             *  String will have no seconds and be in 12 hour format:[H]H:MM am|pm
             *   Example: 3:25 pm
             *  String will have no seconds and be in 24 hour format: [H]H:MM
             *   Example:15:25
             *  String will have no seconds and will display a 2 digit hour, in 12 hour clock format:
             *   HH:MM am|pm
             *   Example: 03:25 pm
             *  String will have no seconds and will display with a 2 digit hour in 24 hour clock format:
             *   HH:MM
             *   Examples: 15:25, 03:16
             */
            String /* toTime |  to24HourTime |  toPaddedTime |  toPadded24HourTime |  toShortTime |  toShort24HourTime |  toShortPaddedTime |  toShortPadded24HourTime */ = "toShortPaddedTime"
    /**
     *  Property name on a record that will hold the link text for that record.
     *
     *   This property is configurable to avoid possible collision with data values in the
     *   record.
     *
     *   Use ListGridField.linkTextProperty if you have more than one link field and
     *  @type {string}
     *  @default "linkText"
     */
    open var linkTextProperty: String = "linkText"
    /**
     *  Note: This property only has an effect in Internet Explorer
     *
     *   Advanced property to improve performance for dynamic styling of gridRenderer cells in
     *   Internet Explorer, at the expense of slightly slower initial drawing, and some
     *   limitations on supported styling options.
     *
     *   fastCellUpdates speeds up the dynamic styling system used by rollovers,
     *   selections, and custom styling that calls GridRenderer.refreshCellStyle, at
     *   the cost of slightly slower draw() and redraw() times.
     *
     *   Notes:
     *
     *
     *  - When this property is set, ListGrid cells may be styled using the
     *     ListGrid.tallBaseStyle. See ListGrid.getBaseStyle for
     *     more information.
     *
     *  - If any cell styles specify a a background image URL, the URL will be resolved relative
     *     to the page location rather than the location of the CSS stylesheet. This means cell
     *     styles with a background URL should either supply a fully qualified path, or the
     *     background image media should be made available at a second location for IE.
     *
     *  - fastCellUpdates will not work if the styles involved are in an external stylesheet loaded
     *     from a remote host. Either the stylesheet containing cell styles needs to be loaded
     *     from the same host as the main page, or the cell styles need to be inlined in the html
     *     of the bootstrap page.
     *
     *  - fastCellUpdates will not work if the css styles for cells are defined in
     *     a .css file loaded via @import. Instead the .css
     *     file should be loaded via a &lt;link ...&gt; tag.
     *
     *  @type {boolean}
     *  @default true
     */
    open var fastCellUpdates: Boolean = true
    /**
     *  GridRenderer.baseStyle for this listGrid.
     *   If this property is unset, base style may be derived from ListGrid.normalBaseStyle
     *   or ListGrid.tallBaseStyle as described in
     *   ListGrid.getBaseStyle.
     *
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseStyle: String? = null
    /**
     *  "Normal" baseStyle for this listGrid. Only applies if ListGrid.baseStyle is
     *   set to null.
     *
     *   If baseStyle is unset, this
     *   property will be used as a base cell style if the grid is showing fixed height rows, and
     *   the specified cellHeight matches ListGrid.normalCellHeight (and in Internet Explorer,
     *   ListGrid.fastCellUpdates is false). Otherwise ListGrid.tallBaseStyle will
     *   be used.
     *
     *   Having separate styles defined for fixed vs. variable height rows allows the developer
     *   to specify css which is designed to render at a specific height (typically using
     *   background images, which won't scale), without breaking support for styling rows
     *   of variable height.
     *
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "cell"
     */
    open var normalBaseStyle: String = "cell"
    /**
     *  "Tall" baseStyle for this listGrid. Only applies if ListGrid.baseStyle is
     *   set to null.
     *
     *   If baseStyle is unset, this
     *   property will be used as a base cell style unless the grid is showing fixed height
     *   rows with a specified cellHeight that matches ListGrid.normalCellHeight, in
     *   which case ListGrid.normalBaseStyle will be used. Note that in Internet Explorer
     *   if ListGrid.fastCellUpdates is true, tallBaseStyle will also be
     *   used even if the cellHeight matches the specified normalCellHeight for the
     *   grid.
     *
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "cell"
     */
    open var tallBaseStyle: String = "cell"
    /**
     *  A base name for the CSS class applied to cells when editing has failed.
     *   If this listGrid is editable, this style will be applied to any edited cells for which
     *   validation failed.
     *   As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",
     *   or "Disabled" appended to it according to the state of the cell.
     *   If null, cells for which editing has failed will be rendered using the normal base style
     *   classNames, but with custom CSSText applied as derived from this.editFailedCSSText
     *  @type {CSSStyleName}
     *  @default null
     */
    open var editFailedBaseStyle: String? = null
    /**
     *  Custom CSS text to be applied to cells when editing has failed.
     *   If this listGrid is editable, this css text will be applied to any edited cells for which
     *   validation failed, on top of the base style for the cell.
     *   For further customization of styling for cells that failed editing validation, use
     *   this.editFailedBaseStyle instead.
     *  @type {string}
     *  @default "color:red;border:1px solid red;"
     */
    open var editFailedCSSText: String = "color:red;border:1px solid red;"
    /**
     *  A base name for the CSS class applied to cells containing pending (unsaved) edits
     *   As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",
     *   or "Disabled" appended to it according to the state of the cell.
     *
     *   If this property is null (the default setting), cells with pending edits will pick up
     *   custom css text to be applied on top of the normal base style from
     *   this.editPendingCSSText.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var editPendingBaseStyle: String? = null
    /**
     *  Custom CSS text to be applied to cells with pending edits that have not yet been
     *   submitted.
     *   For further customization of styling for cells with pending edits use
     *   this.editPendingBaseStyle instead.
     *  @type {string}
     *  @default "color:#0066CC;"
     */
    open var editPendingCSSText: String = "color:#0066CC;"
    /**
     *  Denotes the name of a property that can be set on records to display a custom style.
     *   For example if this property is set to "customStyle", setting
     *   record.customStyle to a css styleName will cause the record in question to
     *   render out with that styling applied to it. Note that this will be a static
     *   style - it will not be modified as the state of the record (selected / over etc) changes.
     *  @type {string}
     *  @default "customStyle"
     */
    open var recordCustomStyleProperty: String = "customStyle"
    /**
     *  This attribute allows custom base styles to be displayed on a per-record basis.
     *   To specify a custom base-style for some record set
     *   record[listGrid.recordBaseStyleProperty] to the desired base style name -
     *   for example if recordBaseStyleProperty is "_baseStyle", set
     *   record._baseStyle to the custom base style name.
     *  @type {string}
     *  @default "_baseStyle"
     */
    open var recordBaseStyleProperty: String = "_baseStyle"
    /**
     *  If this listGrid contains any frozen fields, this property can be used to apply a custom
     *   baseStyle to all cells in those frozen fields. If unset, the standard base style will be
     *   used for both frozen and unfrozen cells.
     *  @type {string}
     *  @default null
     */
    open var frozenBaseStyle: String? = null
    /**
     *  If this list grid is showing any ListGridField.frozen fields, and a horizontal
     *   scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap
     *   be left visible below the frozen columns?
     *   Note that if set to true any backgroundColor or border applied to the ListGrid
     *   will show up below the bottom row of the frozen column(s).
     *  @type {boolean}
     *  @default false
     */
    open var shrinkForFreeze: Boolean = false
    /**
     *  Whether alternating rows (or blocks of rows, depending
     *   on GridRenderer.alternateRowFrequency) should be drawn in alternating styles,
     *   in order to create a "ledger" effect for easier reading.
     *
     *   If enabled, the cell style for alternate rows will have the
     *   GridRenderer.alternateRowSuffix appended to it.
     *   See also GridRenderer.alternateColumnStyles.
     *  @type {boolean}
     *  @default false
     */
    open var alternateRecordStyles: Boolean = false
    /**
     *  Suffix to append to GridRenderer.alternateRowStyles.
     *   Note that if GridRenderer.alternateColumnStyles is enabled, cells which fall
     *   into both an alternate row and column will have both suffixes appended - for
     *   example "cellDarkAltCol".
     *  @type {string}
     *  @default "Dark"
     */
    open var alternateRecordSuffix: String = "Dark"
    /**
     *  The number of consecutive rows to draw in the same style before alternating, when
     *   GridRenderer.alternateRowStyles is true.
     *  @type {number}
     *  @default "1"
     */
    open var alternateRecordFrequency: Number = 1
    /**
     *  Whether alternating columns (or blocks of columns, depending
     *   on GridRenderer.alternateColumnFrequency) should be drawn in alternating styles,
     *   in order to create a vertical "ledger" effect for easier reading.
     *
     *   If enabled, the cell style for alternate rows will have the
     *   GridRenderer.alternateColumnSuffix appended to it.
     *   See also GridRenderer.alternateRowStyles.
     *  @type {boolean}
     *  @default false
     */
    open var alternateFieldStyles: Boolean = false
    /**
     *  Suffix to append to GridRenderer.alternateColumnStyles.
     *   Note that if GridRenderer.alternateRowStyles is enabled, cells which fall
     *   into both an alternate row and column will have both suffixes appended - for
     *   example "cellDarkAltCol".
     *  @type {string}
     *  @default "AltCol"
     */
    open var alternateFieldSuffix: String = "AltCol"
    /**
     *  The number of consecutive columns to draw in the same style before alternating, when
     *   GridRenderer.alternateColumnStyles is true.
     *  @type {number}
     *  @default "1"
     */
    open var alternateFieldFrequency: Number = 1
    /**
     *  Optional css style to apply to the body if ListGrid.alternateRecordStyles is true
     *   for this grid. If unset ListGrid.bodyStyleName will be used to style the body
     *   regardless of the ListGrid.alternateRecordStyles setting.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var alternateBodyStyleName: String? = null
    /**
     *  When assembling a value for a ListGrid.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     *
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     *  @type {boolean}
     *  @default true
     */
    override var includeHilitesInSummaryFields: Boolean = true
    /**
     *  Determines whether hiliting for any field in this grid is shown in a group summary.
     *   This setting affects all fields of the grid.
     *
     *   To suppress hilites for a specific field see ListGridField.showHilitesInGroupSummary.
     *
     *   Hiliting in summary fields (columns) can be enabled by setting
     *   ListGrid.includeHilitesInSummaryFields to true.
     *  @type {boolean}
     *  @default true
     */
    open var showHilitesInGroupSummary: Boolean = true
    /**
     *  If set, end users can create advanced hiliting rules that will use the
     *   Hilite.replacementValue feature to cause values in hilited cells
     *   to be replaced with a user-entered value. For example, a user could create a hilite rule
     *   that replaces numeric values ranging from 0.5 to 1.0 with the text "LOW".
     *
     *   Specifically, when the "Add Advanced Rule" button is pressed and
     *   hiliteCanReplaceValue is true, the user will see a text entry field titled
     *   "Replace value with" (ListGrid.hiliteReplaceValueFieldTitle) and if they enter a value, that
     *   value will appear in the grid cell in lieu of the cell's original value.
     *  @type {boolean}
     *  @default null
     */
    open var hiliteCanReplaceValue: Boolean? = null
    /**
     *  Title used for the text box shown when ListGrid.hiliteCanReplaceValue is set.
     *  @type {string}
     *  @default "Replace value with"
     */
    open var hiliteReplaceValueFieldTitle: String = "Replace value with"
    /**
     *  If set to true, custom HTML applied as part of hiliting will be applied after
     *   ListGrid.formatCellValue for each cell. If false, hilite
     *   HTML will be applied before formatting.
     *
     *   This applies to the following hilite properties:
     *
     *
     *  - Hilite.replacementValue
     *
     *  - Hilite.htmlBefore
     *
     *  - Hilite.htmlAfter
     *
     *  - Hilite.htmlValue
     *
     *
     *   May be overridden per field via ListGridField.hiliteHTMLAfterFormat
     *  @type {boolean}
     *  @default true
     */
    open var hiliteHTMLAfterFormat: Boolean = true
    /**
     *  Should the "Selected" style be applied to selected records?
     *  @type {boolean}
     *  @default true
     */
    open var showSelectedStyle: Boolean = true
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits space,
     *   the cell will respond to a click event.
     *  @type {boolean}
     *  @default true
     */
    open var generateClickOnSpace: Boolean = true
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits Enter,
     *   the cell will respond to a click event.
     *  @type {boolean}
     *  @default false
     */
    open var generateClickOnEnter: Boolean = false
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits Space,
     *   the cell will respond to a double click event.
     *  @type {boolean}
     *  @default false
     */
    open var generateDoubleClickOnSpace: Boolean = false
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits Enter,
     *   the cell will respond to a double click event.
     *  @type {boolean}
     *  @default true
     */
    open var generateDoubleClickOnEnter: Boolean = true
    /**
     *  Action to perform when the listGrid has keyboard focus (but not editing focus) and a user
     *   presses the up or down arrow key. Possible values are:
     *
     *
     *  - "select" : select the next row in the list (calls recordClick handler)
     *
     *  - "focus" : move focus to the next row in the list without changing the selection
     *
     *  - "activate" : select and activate the next row in the list (calls
     *   recordDoubleClick handler)
     *
     *  - "none" : no action
     *
     *  - null : if ListGrid.selectionAppearance is "checkbox", behaves as if set
     *   to "focus"; otherwise, behaves as if set to "select"
     *
     *  @type {string}
     *  @default null
     */
    open var arrowKeyAction: String? = null
    /**
     *  When the grid body gets keyboard focus, should we highlight the current focus row,
     *   using the rollover cell style?
     *
     *   This property may be explicitly set to control this behavior independently of
     *   ListGrid.showRollOver.
     *   Otherwise (if this property is null), we will show the roll-over styling for the
     *   keyboard focus row if ListGrid.showRollOver is true.
     *  @type {boolean}
     *  @default null
     */
    open var hiliteRowOnFocus: Boolean? = null
    /**
     *  When enabled, ListGrid.createRecordComponent will be called when saved rows are being
     *   rendered, and any returned component will be displayed embedded within the row or cell.
     *
     *   recordComponents are not created for newly added rows which have not yet been saved.
     *   See the unsavedRecords for more
     *   information.
     *
     *   Depending on the ListGrid.showRecordComponentsByCell setting,
     *   createRecordComponent() will be called either once per row, or once for
     *   every cell.
     *
     *   Depending on ListGrid.recordComponentPosition, components can either be placed underneath
     *   normal record or cell content ("expand" setting) or placed so that they overlap normal
     *   cell content ("within" setting). For the "within" setting, the default is to fill the
     *   row or cell, but the component can specify percent size or even use
     *   Canvas.snapTo to place itself within the row or cell.
     *
     *   The "expand" setting is incompatible with ListGrid.canFreezeFields
     *   unless all recordComponents are the same height and they are present
     *   in every row, in which case the fixed height of all recordComponents can be
     *   set via ListGrid.recordComponentHeight to re-enable frozen fields.
     *
     *   Using recordComponents potentially means creating one component for every
     *   visible grid row or cell and so can impact performance. Before using this subsystem:
     *
     *
     *  - consider using ListGridField.valueIcons (possibly with a specified
     *     ListGridField.valueIconClick handler) for icons based on field values
     *     which may be displayed alone in the cell or alongside standard content
     *     (see ListGridField.showValueIconOnly);
     *
     *  - for clickable icons representing actions that can be taken on a record, also
     *     consider using ListGridFieldType, or
     *     multiple such fields
     *
     *  - for controls that only need to appear on rollover, consider
     *     ListGrid.showRollOverCanvas
     *
     *  - if you are trying to customize the editor for a field, you can provide a custom
     *     control via ListGridField.editorType, and FormItem.icons are a common
     *     way to add clickable buttons. You can also
     *     ListGrid.getEditorType. These options are
     *     usually better that using recordComponents as custom editors, since
     *     you won't have to manage issues like making the recordComponent appear
     *     only when editing, having changes affect editing,
     *     triggering saves and handling validation errors, etc.
     *
     *
     *   See RecordComponentPoolingMode for an overview of how best to optimize use of
     *   recordComponents for different data sets.
     *
     *   Regardless of the pooling mode, you can explicitly refresh record components via
     *   ListGrid.invalidateRecordComponents and
     *   ListGrid.refreshRecordComponent.
     *
     *   Interaction with ListGrid.autoFitFieldWidths: per-cell record
     *   components are not taken into account when determining the size for column auto fit.
     *   The default ListGrid.getDefaultFieldWidth implementation looks at cell content
     *   only. We typically recommend that, for fields showing record-components,
     *   ListGridField.autoFitWidth and ListGridField.canAutoFitWidth be disabled, or if
     *   the record components are of a predictable size, a ListGridField.defaultWidth
     *   be specified.
     *   This is particularly pertinent where ListGrid.recordComponentPosition
     *   is set to "within", in which case cells' content is often empty or completely covered
     *   by record-components.
     *  @type {boolean}
     *  @default null
     */
    open var showRecordComponents: Boolean? = null
    /**
     *  if ListGrid.showRecordComponents is true, how should the component appear within
     *   the cell. Valid options are
     *
     *  - "within": the component will be rendered inside the record / cell.
     *   Canvas.snapTo may be set to specify where the component should render within
     *   the row or cell, and Canvas.snapOffsetTop / Canvas.snapOffsetLeft may
     *   be set to indent recordComponents within their parent cells.
     *   Note that if unset, the component will show up at the top/left edge
     *   for components embedded within an entire row, or for per-cell components, cell
     *   align and valign will be respected. Note also that, when rendering components "within"
     *   cells, specified component heights will be respected and will change the height of the
     *   row. However, if you want components to completely fill a cell at it's default height,
     *   set height: "100%" or rows will render at the default height of the component.
     *
     *  - "expand": the component will be written into the cell below the
     *   normal cell content, causing the cell to expand vertically to accommodate it.
     *
     *  - null: If this attribute is unset, we will default to showing
     *   recordComponents with position "within" if
     *   ListGrid.showRecordComponentsByCell is true, otherwise using "expand"
     *   logic.
     *
     *  @type {EmbeddedPosition}
     *  @default null
     */
    open var recordComponentPosition:
            /**
             *  component should be placed underneath normal record or cell content,    expanding the records. Expanding records can result in variable height rows,
             *      in which case ListGrid.virtualScrolling should be
             *      enabled.
             *  component should be placed within the normal area of the record or cell.    Percentage sizes will be treated as percentages of the record and
             *      Canvas.snapTo positioning settings are also allowed and refer to the
             *      rectangle of the record or cell. Note that for components embedded within cells,
             *      cell align and vAlign will be used if snapTo is unset (so top / left alignment
             *      of cell content will map to snapTo of "TL", etc).
             */
            String? /* expand |  within */ = null
    /**
     *  If true, shows ListGrid.showRecordComponents in cells, rather
     *   than just in records.
     *  @type {boolean}
     *  @default null
     */
    open var showRecordComponentsByCell: Boolean? = null
    /**
     *  The method of RecordComponentPoolingMode to employ for
     *   ListGrid.showRecordComponents.
     *
     *   The default mode is "viewport", which means that recordComponents are destroyed as soon
     *   their record is no longer being rendered (scrolled out of the viewport, eliminated by
     *   search criteria, etc).
     *
     *   For a large or dynamic data set where the components shown on different rows are
     *   similar, switch to "recycle" mode, which pools recordComponents by detaching them from
     *   records that are not visible and re-using them in other records. In this mode, you
     *   should implement ListGrid.updateRecordComponent to apply any changes to make reused
     *   components applicable to the new record they appear in, if necessary. For example, if
     *   you have several controls in your recordComponents, and not all of the
     *   controls apply to every record, your updateRecordComponent() implementation
     *   could simply hide or disable inapplicable controls, and this would be much faster than
     *   creating a whole new set of controls every time a given record is scrolled into view.
     *
     *   If you are using ListGrid.showRecordComponentsByCell, and you
     *   have components of different types in different columns and still want to take
     *   advantage of component recycling, you can set ListGrid.poolComponentsPerColumn to
     *   ensure that components intended for one column are not recycled for use in another
     *   column that should have a different component.
     *
     *   Note that, if different records have distinctly different components embedded
     *   in them, or multiple columns in each record embed different components, you should
     *   leave the recordComponentPoolingMode at "viewport" if your dataset is very large or
     *   use "data" otherwise.
     *  @type {RecordComponentPoolingMode}
     *  @default "viewport"
     */
    open var recordComponentPoolingMode:
            /**
             *  components are destroyed when the record is not being rendered. Best    for large datasets where embedded components differ greatly per record.
             *  components are Canvas.clear when not in the viewport, but    stay with a record until the record is dropped from cache. Best for guaranteed
             *      small datasets.
             *  components are pooled and will be passed to    ListGrid.updateRecordComponent with the
             *      recordChanged parameter set to true. Best for large datasets where
             *      embedded components are uniform across different records and can be efficiently
             *      reconfigured to work with a new record
             */
            String /* viewport |  data |  recycle */ = "viewPort"
    /**
     *  Should recycled ListGrid.showRecordComponents, be pooled
     *   per column or per record. Only applies if ListGrid.showRecordComponentsByCell is true.
     *
     *   When ListGrid.recordComponentPoolingMode is "recycle" and you have components of
     *   different types in different columns, set this property to true to ensure that
     *   components intended for one column are not recycled for use in another column that
     *   should have a different component.
     *
     *   If no components applicable to a particular column are available in the pool, the system
     *   calls ListGrid.createRecordComponent.
     *  @type {boolean}
     *  @default true
     */
    open var poolComponentsPerColumn: Boolean = true
    /**
     *  Should we show different styling for the cell the mouse is over?
     *
     *   If true, the cell style will have the suffix "Over" appended.
     *
     *   Can be overridden on a per-record basis via ListGridRecord.showRollOver.
     *  @type {boolean}
     *  @default true
     */
    open var showRollOver: Boolean = true
    /**
     *  Are rollovers cell-level or row-level?
     *  @type {boolean}
     *  @default null
     */
    open var useCellRollOvers: Boolean? = null
    /**
     *  When enabled, when the mouse moves over a row or cell (depending on
     *   ListGrid.useCellRollOvers), an arbitrary Canvas can be shown layered on top of the row or
     *   cell (the ListGrid.rollOverCanvas), layered underneath the row or cell (the
     *   ListGrid.rollUnderCanvas), or both.
     *
     *   This can be used to dynamically show controls or informational displays only on
     *   rollover. For example, controls to delete a row might appear only on rollover so they
     *   do not clutter the static display, or a "rollUnder" Canvas could be used to display
     *   additional information that can appear behind normal cell values (like displaying
     *   percent complete via as a bar of color that appears behind text values).
     *
     *   Canvas.snapTo can be used to place the
     *   rollOver/rollUnderCanvas. With useCellRollOvers, positioning is relative
     *   to the cell, for row-level rollOver, position is relative to the portion of the
     *   row that is scrolled into view (this implies a row-level rollOver/UnderCanvas can never
     *   be placed horizontally scrolled out of view, but this is possible for a cell-level
     *   rollOver).
     *
     *   snapTo positioning makes it easy to do something like place a button at the
     *   right edge of the grid, next to the scrollbar: just set snapTo:"R" on the
     *   rollOverCanvas.
     *
     *   The rollOver/rollUnder Canvas can be a single static component (the same for all
     *   cells/rows) configured via the AutoChild system, or can instead be provided
     *   dynamically by implementing ListGrid.getRollOverCanvas and/or ListGrid.getRollUnderCanvas.
     *
     *   The rollOver/rollUnder canvas will be automatically added to the grid's
     *   ListGrid.body as an
     *   ListGrid.addEmbeddedComponent.
     *   For grids with ListGridField.frozen, the behavior is as follows:
     *
     *  - If ListGrid.useCellRollOvers is false (the default), embedded components
     *    will be added to both the body and the frozen body
     *
     *  - Otherwise the component will be added to whichever body contains the cell the
     *    user is currently over
     *   The rollOver/rollUnder canvas added to the frozen body will be created by calling
     *   the ListGrid.getFrozenRollOverCanvas or ListGrid.getFrozenRollUnderCanvas methods.
     *   The default implementation for these methods matches their equivalents for non-frozen
     *   rollOver / rollUnder canvases - it will use the autoChild subsystem to create a
     *   canvas from the ListGrid.rollOverCanvas autoChild configuration.
     *
     *   showRollOverCanvas has no effect if ListGrid.showRollOver is false.
     *
     *   See also ListGrid.showSelectedRollOverCanvas.
     *  @type {boolean}
     *  @default null
     */
    open var showRollOverCanvas: Boolean? = null
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showRollOver
     *   is true and ListGrid.showRollOverCanvas is
     *   true or for selected records, if
     *   ListGrid.showSelectedRollOverCanvas
     *   is true. This component will be created and displayed above the current rollOver
     *   row or cell.
     *
     *   Note that if this grid has frozen fields, the AutoChild subsystem will use the
     *   rollOverCanvas configuration settings to create the ListGrid.frozenRollOverCanvas
     *   (displayed in the frozen listGrid body).
     *
     *   The rollOverCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var rollOverCanvas: Canvas? = null
    /**
     *  Automatically generated canvas embedded in the grid's frozen body if
     *   ListGrid.showRollOver
     *   is true and ListGrid.showRollOverCanvas is
     *   true or for selected records, if
     *   ListGrid.showSelectedRollOverCanvas
     *   is true. This component will be created and displayed above the current rollOver
     *   row or cell in the frozen body.
     *
     *   The frozenRollOverCanvas will be created using the AutoChild subsystem, and
     *   will derive its configuration from the ListGrid.rollOverCanvas
     *   autoChild properties ("rollOverCanvasProperties", et al).
     *
     *   The frozenRollOverCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var frozenRollOverCanvas: Canvas? = null
    /**
     *  If roll overs are enabled, should the ListGrid.rollUnderCanvas
     *   be displayed?
     *
     *   Use of the showRollUnderCanvas is enabled if ListGrid.showRollOver
     *   is true, and either ListGrid.showRollOverCanvas
     *   is true and showRollUnderCanvas is unset, or showRollUnderCanvas
     *   is explicitly set to true.
     *
     *   See also ListGrid.showSelectedRollUnderCanvas.
     *  @type {boolean}
     *  @default null
     */
    open var showRollUnderCanvas: Boolean? = null
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showRollOver
     *   is true, and either ListGrid.showRollOverCanvas
     *   is true and ListGrid.showRollUnderCanvas is
     *   unset, or showRollUnderCanvas is explicitly set to true.
     *   This component will be created and displayed behind the current rollOver row or cell in the
     *   page's z-order, meaning that it will only be visible if the cell styling is transparent.
     *
     *   Note that if this grid has frozen fields, the AutoChild subsystem will use the
     *   rollUnderCanvas configuration settings to create the ListGrid.frozenRollUnderCanvas
     *   (displayed in the frozen listGrid body).
     *
     *   The rollUnderCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var rollUnderCanvas: Canvas? = null
    /**
     *  Automatically generated canvas embedded in the grid's frozen body as a
     *   ListGrid.rollUnderCanvas.
     *   This component will be created and displayed above the current rollOver
     *   row or cell in the frozen body.
     *
     *   The frozenRollUnderCanvas will be created using the AutoChild subsystem, and
     *   will derive its configuration from the ListGrid.rollUnderCanvas
     *   autoChild properties ("rollUnderCanvasProperties", et al).
     *
     *   The frozenRollUnderCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var frozenRollUnderCanvas: Canvas? = null
    /**
     *  This setting causes the ListGrid.rollOverCanvas to be
     *   displayed when the user rolls over selected records in the grid (but not when
     *   rolling over other records). This can be useful to display a "Selected Over"
     *   appearance which can't be easily achieved via standard cell styling.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedRollOverCanvas: Boolean = false
    /**
     *  This setting causes the ListGrid.rollUnderCanvas to be
     *   displayed when the user rolls over selected records in the grid (but not when
     *   rolling over other records). This can be useful to display a "Selected Over"
     *   appearance which can't be easily achieved via standard cell styling.
     *
     *   As with ListGrid.showRollUnderCanvas, if this property is unset, but
     *   the related ListGrid.showSelectedRollOverCanvas property is true, both the
     *   the roll under and roll under canvases will be displayed as the user rolls
     *   over selected records.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedRollUnderCanvas: Boolean = false
    /**
     *  This setting causes the ListGrid.rollOverCanvas to be
     *   sized to cover the normal row and the expansion layout. Otherwise the
     *   rollOverCanvas is only shown for the un-expanded part of the row.
     *  @type {boolean}
     *  @default null
     */
    open var showRollOverInExpansion: Boolean? = null
    /**
     *  If the ListGrid.rollOverCanvas is enabled, setting this property
     *   to true ensures that when the rollOverCanvas is displayed it
     *   is animated into view via Canvas.animateShow. Note that the animation effect
     *   may be customized via Canvas.animateShowEffect, Canvas.animateShowTime and
     *   Canvas.animateShowAcceleration set in rollOverCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateRollOver: Boolean = false
    /**
     *  If the ListGrid.rollUnderCanvas is enabled, setting this property
     *   to true ensures that when the rollUnderCanvas is displayed it
     *   is animated into view via Canvas.animateShow. Note that the animation effect
     *   may be customized via Canvas.animateShowEffect, Canvas.animateShowTime and
     *   Canvas.animateShowAcceleration set in rollUnderCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateRollUnder: Boolean = false
    /**
     *  If true this grid will create and show per-row backgroundComponents
     *   as detailed ListGrid.backgroundComponent.
     *  @type {boolean}
     *  @default false
     */
    open var showBackgroundComponents: Boolean = false
    /**
     *  Has no effect unless ListGrid.showBackgroundComponents is true.
     *
     *   Canvas created and embedded in the body behind a given record.  When
     *   ListGridRecord.backgroundComponent is set, this autoChild canvas
     *   will be constructed (if listGridRecord.backgroundComponent is not already a Canvas) and
     *   its properties combined with those of listGridRecord.backgroundComponent and then
     *   displayed behind a specific record in the page's z-order, meaning
     *   it will only be visible if the cell styling is transparent.
     *  @type {Canvas}
     *  @default null
     */
    open var backgroundComponent: Canvas? = null
    /**
     *  If true, cellHover and rowHover events will fire and then a hover will be shown (if not
     *   canceled) when the user leaves the mouse over a row / cell unless the corresponding field has
     *   ListGridField.showHover set to false. If unset or null, the hover will be
     *   shown if the corresponding field has showHover:true. If false, then hovers are disabled.
     *
     *   Note that standard hovers override ListGrid.showClippedValuesOnHover. Thus,
     *   to enable clipped value hovers, canHover must be unset or null and the corresponding field
     *   must have showHover unset or null as well.
     *  @type {boolean}
     *  @default null
     */
    override var canHover: Boolean? = null
    /**
     *  If true, and canHover is also true, when the user hovers over a cell, hover text will pop up
     *   next to the mouse. The contents of the hover is determined by ListGrid.cellHoverHTML.
     *  @type {boolean}
     *  @default true
     */
    override var showHover: Boolean = true
    /**
     *  If true and a header button's title is clipped, then a hover containing the full field
     *   title is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var showClippedHeaderTitlesOnHover: Boolean = true
    /**
     *  Style to apply to hovers shown over this grid.
     *  @type {CSSStyleName}
     *  @default "gridHover"
     */
    override var hoverStyle: String? = "gridHover"
    /**
     *  The selection associated with the ListGrid.
     *  @deprecated \* in favor of ListGrid.selectionManager
     *  @type {Selection | CellSelection}
     *  @default null
     */
    open var selection: dynamic = null
    /**
     *  The selection associated with the ListGrid.
     *  @type {Selection | CellSelection}
     *  @default null
     */
    open var selectionManager: dynamic = null
    /**
     *  How selection of rows should be presented to the user.
     *
     *   For selectionAppearance:"checkbox" with multiple selection
     *   allowed, you would typically use ListGrid.selectionType:"simple" (the default). Because
     *   selectionType and selectionAppearance are unrelated,
     *   the combination of selectionAppearance:"checkbox" and
     *   selectionType:"multiple" results in a grid where multiple selection can
     *   only be achieved via shift-click or ctrl-click.
     *
     *   If using "checkbox" for a ListGrid, see also
     *   ListGrid.checkboxField for customization APIs.
     *
     *   If using "checkbox" for a TreeGrid, an extra icon,
     *   TreeGrid.getExtraIcon is not supported. Additionally only
     *   ListGrid.selectionType:"simple" and "single" are supported.
     *   You can also toggle the display of a disabled checkbox on a treeGrid, displayed
     *   when the node can't be selected, via TreeGrid.showDisabledSelectionCheckbox.
     *
     *   Note that the default behavior when you enable checkbox selection is to continue to show
     *   the selected style. This can be changed by setting ListGrid.showSelectedStyle to false.
     *  @type {SelectionAppearance}
     *  @default "rowStyle"
     */
    open var selectionAppearance:
            /**
             *  selected rows should be shown with different appearance - see          ListGrid.getCellStyle and optionally
             *            ListGrid.selectionCanvas.
             *  an extra, non-data column should be automatically added to the ListGrid,          showing checkboxes that can be toggled to select rows.
             *            See ListGrid.getCheckboxField.
             */
            String /* rowStyle |  checkbox */ = "rowStyle"
    /**
     *  Controls whether a checkbox for selecting all records appears in the header with
     *   ListGrid.selectionAppearance set to "checkbox"
     *  @type {boolean}
     *  @default null
     */
    open var canSelectAll: Boolean? = null
    /**
     *  Should partial selection of all records be shown in header with a special icon?
     *   The partial icon will show in the header when ListGrid.canSelectAll is
     *   enabled and at least one record is selected but all records are not selected.
     *   To only show all selected and none selected states, set this attribute to false.
     *  @type {boolean}
     *  @default null
     */
    open var showHeaderPartialSelection: Boolean? = null
    /**
     *  Controls whether a checkbox for selecting ListGrid.groupBy appears
     *   in the group node if SelectionAppearance is set to "checkbox"
     *  @type {boolean}
     *  @default false
     */
    open var canSelectGroups: Boolean = false
    /**
     *  Should partially selected parents (in a Tree data set) be shown with special icon?
     *   This has an impact in grouped grids where ListGrid.canSelectGroups is true. The
     *   partial icon will show up for the group header node when a group is partially
     *   selected.
     *  @type {boolean}
     *  @default false
     */
    open var showPartialSelection: Boolean = false
    /**
     *  Defines a listGrid's clickable-selection behavior.
     *
     *   The default selection appearance is governed by ListGrid.selectionAppearance: if
     *   selectionAppearance is "checkbox", this will be "simple", otherwise, this will be
     *   "multiple".
     *  @type {SelectionStyle}
     *  @default null
     */
    open var selectionType:
            /**
             *  don't select at all
             *  select only one item at a time
             *  select one or more items
             *  select one or more items as a toggle      so you don't need to hold down control keys to select
             *                   more than one object
             */
            String? /* none |  single |  multiple |  simple */ = null
    /**
     *  If specified, the selection object for this list will use this property to mark records
     *   as selected. In other words, if this attribute were set to "isSelected"
     *   any records in the listGrid data where "isSelected" is true
     *   will show up as selected in the grid. Similarly if records are selected within the grid
     *   after the grid has been created, this property will be set to true on the selected
     *   records.
     *  @type {string}
     *  @default null
     */
    open var selectionProperty: String? = null
    /**
     *  If true, when an update operation occurs on a selected record in a
     *   ListGrid.dataSource listGrid, ensure the updated record is
     *   re-selected when the operation completes.
     *   The ListGrid.reselectOnUpdateNotifications attributes governs whether
     *   ListGrid.selectionUpdated and ListGrid.selectionChanged will fire
     *   when this occurs.
     *  @type {boolean}
     *  @default true
     */
    open var reselectOnUpdate: Boolean = true
    /**
     *  if ListGrid.reselectOnUpdate is true, this property governs what
     *   selection changed notifications should be triggered when a selected record
     *   is edited then automatically reselected when the edited data is merged into
     *   the data set.
     *  @type {SelectionNotificationType}
     *  @default "selectionChanged"
     */
    open var reselectOnUpdateNotifications:
            /**
             *  No selection change notification should fire
             *  ListGrid.selectionChanged should fire but ListGrid.selectionUpdated should not fire.
             *  ListGrid.selectionChanged and ListGrid.selectionUpdated should both fire.
             */
            String /* none |  selectionChanged |  selectionUpdated */ = "selectionChanged"
    /**
     *  If set to false on a record, selection of that record is disallowed.
     *  @type {string}
     *  @default "canSelect"
     */
    open var recordCanSelectProperty: String = "canSelect"
    /**
     *  Enables cell-level selection behavior as well as
     *   ListGrid.useCellRollOvers.
     *
     *   To query and manipulate cell-level selections, use ListGrid.getCellSelection to retrieve
     *   the CellSelection.
     *
     *   Note that the ListGrid has a data model of one Record per row, unlike the
     *   CubeGrid which supports one CellRecord per cell. For this reason
     *   record-oriented APIs that act on the selection will act on entire Records that have
     *   any selected cells (examples include drag and drop and transferSelectedData()).
     *
     *   More generally, canSelectCells is primarily intended to enable developers
     *   to build Excel-like interactions on local datasets, by using ListGrid.setData plus
     *   ListGrid.saveLocally:true rather than record-oriented DataSources and data binding.
     *
     *   The following keyboard selection behaviors are enabled with this property in
     *   addition to standard single-selection Arrow Key navigation:
     *
     *   SHIFT +    [Arrow Key]: begin or continue incremental selection
     *
     *   SHIFT + CTRL + [Arrow Key]: incremental selection to the end of row or column
     *
     *   CTRL + A: select all cells (enabled only with ListGrid.canSelectAll)
     *
     *   Incremental selection allows selection of rows and columns of cells via keyboard
     *   or mouse provided the shift key is down. Behavior is designed to match Excel.
     *   Thus, if a previous selection has begun, cells will be selected from that origin.
     *
     *   Users may also navigate through cells using the Tab and Shift+Tab
     *   keypresses if ListGrid.navigateOnTab is true. When a user tabs to the
     *   end of the row, the ListGrid.rowEndEditAction is used to determine whether
     *   to shift selection to the next row, return to the beginning of the same row, or
     *   simply move on through the page's tab order.
     *  @type {boolean}
     *  @default false
     */
    open var canSelectCells: Boolean = false
    /**
     *  If ListGrid.canSelectCells is true, this property allows the user
     *   to navigate through the cells of a grid using Tab and Shift+Tab keypresses.
     *   When a user tabs to the
     *   end of the row, the ListGrid.rowEndEditAction is used to determine whether
     *   to shift selection to the next row, return to the beginning of the same row, or
     *   simply move on through the page's tab order.
     *  @type {boolean}
     *  @default true
     */
    open var navigateOnTab: Boolean = true
    /**
     *  Enables copy/paste shortcuts, provided ListGrid.canSelectCells is true
     *
     *   The default setting of true means that the value of ListGrid.canSelectCells
     *   determines whether copy/paste shortcuts are enabled. Setting this property to
     *   false disables said shortcuts unconditionally.
     *
     *   Copying is done via copying to a SmartClient-wide "clipboard" - not the OS-level
     *   clipboard, which is inaccessible on some browsers - via the methods
     *   ListGrid.getSelectedCellData and ListGrid.applyCellData. To copy data to and
     *   from applications outside of the browser, use the technique shown in the
     *   ${isc.DocUtils.linkForExampleId('gridToExcel', 'Grid to Excel')} and
     *   ${isc.DocUtils.linkForExampleId('excelToGrid', 'Excel to Grid')} samples.
     *
     *   The following shortcuts are available:
     *
     *   CTRL + D: copy cell values from top row of selected cells down to all rows
     *
     *   CTRL + R: copy cell values from left column of selected cells right to all columns
     *
     *   CTRL + C: copy selected cell values into shared clipboard
     *
     *   CTRL + V: paste from shared clipboard into current selection
     *  @type {boolean}
     *  @default true
     */
    open var useCopyPasteShortcuts: Boolean = true
    /**
     *  Name of a CSS Style to use as the ListGrid.baseStyle for a cell that
     *   is currently a selection origin for shifted incremental cell selection.
     *   Only has an effect if ListGrid.canSelectCells is true.
     *
     *  @type {CSSStyleName}
     *  @default null
     */
    open var originBaseStyle: String? = null
    /**
     *  If this property is true, users can drag the mouse to select several rows or cells.
     *   This is mutually exclusive with rearranging rows or cells by dragging.
     *
     *   NOTE: If canDragSelect is initially enabled or might be
     *   dynamically enabled after the grid is created, it may be desirable to disable
     *   Canvas.useTouchScrolling so that touch-dragging records/cells
     *   selects them rather than starting a scroll. If Canvas.disableTouchScrollingForDrag
     *   is set to true, then touch scrolling will be disabled automatically.
     *   However, for accessibility reasons, it is recommended to
     *   leave touch scrolling enabled and provide an alternative set of controls that can be
     *   used to perform drag-selection.
     *  @type {boolean}
     *  @default false
     */
    open var canDragSelect: Boolean = false
    /**
     *  If this property is true, users can drag the mouse to select text within grid rows,
     *   ready to be cliped to clipboard.
     *   This is mutually exclusive with
     *   ListGrid.canReorderRecords, and with
     *   ListGrid.canDragSelect.
     *
     *   To enable selecting cell text on click, see ListGrid.selectCellTextOnClick.
     *  @type {boolean}
     *  @default false
     */
    open var canDragSelectText: Boolean = false
    /**
     *  If set to false, dropping over an empty part of the grid body is disallowed and the
     *   no-drop indicator is displayed.
     *  @type {boolean}
     *  @default true
     */
    open var canDropInEmptyArea: Boolean = true
    /**
     *  If ListGrid.selectionType is set to
     *   "single",
     *
     *   setting this property to true means selection will be displayed to the
     *   user with the ListGrid.selectionCanvas and/or
     *   ListGrid.selectionUnderCanvas rather than with CSS styling.
     *
     *   If showSelectionCanvas is set to true, then the
     *   selectionUnderCanvas will automatically be enabled unless
     *   ListGrid.showSelectionUnderCanvas is set to false.
     *
     *   NOTE: It is recommended to use the selectionUnderCanvas rather than the
     *   selectionCanvas if possible because the selectionCanvas is
     *   stacked on top of the selected record and this may interfere with event handling in rare
     *   cases. If no interactive components are shown in the selectionCanvas and it
     *   simply provides custom styling, then the selectionUnderCanvas should be used
     *   instead.
     *
     *   With ListGrid.canFreezeFields, the selectionCanvas
     *   is displayed only over the non-frozen fields of the selected row.
     *  @type {boolean}
     *  @default null
     */
    open var showSelectionCanvas: Boolean? = null
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showSelectionCanvas
     *   is true and the ListGrid.selectionType is
     *   "single".
     *
     *   This component will be created and displayed above the selected record whenever the
     *   selection changes.
     *
     *   NOTE: It is recommended to use the ListGrid.selectionUnderCanvas
     *   rather than the selectionCanvas if possible because the selectionCanvas
     *   is stacked on top of the selected record and this may interfere with event handling in rare
     *   cases. If no interactive components are shown in the selectionCanvas and it
     *   simply provides custom styling, then the selectionUnderCanvas should be used
     *   instead.
     *
     *   The selectionCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the currently selected record in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var selectionCanvas: Canvas? = null
    /**
     *  If ListGrid.selectionType is set to
     *   "single",
     *
     *   and either ListGrid.showSelectionCanvas is true and
     *   showSelectionUnderCanvas is unset, or showSelectionUnderCanvas
     *   is explicitly set to true, then selection will be displayed to the
     *   user with the ListGrid.selectionCanvas and/or
     *   ListGrid.selectionUnderCanvas rather than with CSS styling.
     *   Setting showSelectionUnderCanvas to false will disable
     *   the use of the selectionUnderCanvas.
     *
     *   With ListGrid.canFreezeFields, the selectionUnderCanvas
     *   is displayed only behind the non-frozen fields of the selected row.
     *  @type {boolean}
     *  @default null
     */
    open var showSelectionUnderCanvas: Boolean? = null
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showSelectionCanvas
     *   is true and ListGrid.showSelectionUnderCanvas
     *   is unset, or showSelectionUnderCanvas is explicitly set to true,
     *   and the ListGrid.selectionType is
     *   "single".
     *
     *   This component will be created and displayed behind the selected record whenever the
     *   selection changes.
     *
     *   The selectionUnderCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the currently selected record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var selectionUnderCanvas: Canvas? = null
    /**
     *  If the ListGrid.selectionCanvas is enabled, setting
     *   this property to true ensures that when the selectionCanvas
     *   is displayed it is animated into view via Canvas.animateShow. Note that the
     *   animation effect may be customized via Canvas.animateShowEffect,
     *   Canvas.animateShowTime and Canvas.animateShowAcceleration set in
     *   selectionCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateSelection: Boolean = false
    /**
     *  If the ListGrid.selectionUnderCanvas is enabled, setting
     *   this property to true ensures that when the selectionUnderCanvas
     *   is displayed it is animated into view via Canvas.animateShow. Note that the
     *   animation effect may be customized via Canvas.animateShowEffect,
     *   Canvas.animateShowTime and Canvas.animateShowAcceleration set in
     *   selectionUnderCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateSelectionUnder: Boolean = false
    /**
     *  Returns the specially generated checkbox field used when SelectionAppearance is
     *   "checkbox". Created via the AutoChild pattern so that
     *   checkboxFieldDefaults and checkboxFieldProperties are available
     *   for skinning purposes. Note that ListGridField.shouldPrint is false
     *   for the checkboxField by default - if you want this column to show up in the grid's print
     *   view, use checkboxFieldProperties to set this property to true.
     *
     *   This field will render an icon to indicate the selected state of each row, which, when
     *   clicked will toggle the selection state. The icon src may be configured using
     *   ListGrid.checkboxFieldTrueImage and ListGrid.checkboxFieldFalseImage, as
     *   well as ListGrid.checkboxFieldImageWidth and ListGrid.checkboxFieldImageHeight.
     *
     *   The checkboxField can be detected by calling ListGrid.isCheckboxField on any
     *   ListGridField object.
     *  @type {ListGridField}
     *  @default null
     */
    open var checkboxField: ListGridField? = null
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   determines the image to display in the checkbox field for a selected row.
     *   If unset, the ListGrid.booleanTrueImage will be used. Note that the special
     *   value "blank" means that no image will be shown.
     *  @type {SCImgURL}
     *  @default null
     */
    open var checkboxFieldTrueImage: String? = null
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   determines the image to display in the checkbox field for an unselected row.
     *   If unset, the ListGrid.booleanFalseImage will be used. Note that the special
     *   value "blank" means that no image will be shown.
     *  @type {SCImgURL}
     *  @default null
     */
    open var checkboxFieldFalseImage: String? = null
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   determines the image to display in the checkbox field for a partially selected row.
     *   If unset, the ListGrid.booleanPartialImage will be used. Note that the special
     *   value "blank" means that no image will be shown.
     *  @type {SCImgURL}
     *  @default null
     */
    open var checkboxFieldPartialImage: String? = null
    /**
     *  If set, the ListGrid.checkboxFieldTrueImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckboxFieldTrueImage: String? = null
    /**
     *  If set, the ListGrid.checkboxFieldFalseImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckboxFieldFalseImage: String? = null
    /**
     *  If set, the ListGrid.checkboxFieldPartialImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckboxFieldPartialImage: String? = null
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   may be set to govern the width of the checkbox image displayed to indicate whether a row is
     *   selected. If unset, the checkboxField image will be sized to match the
     *   ListGrid.booleanImageWidth for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var checkboxFieldImageWidth: Number? = null
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   may be set to govern the height of the checkbox image displayed to indicate whether a row is
     *   selected. If unset, the checkboxField image will be sized to match the
     *   ListGrid.booleanImageHeight for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var checkboxFieldImageHeight: Number? = null
    /**
     *  Indicates whether the text of the emptyMessage property should be displayed if no data is
     *   available.
     *  @type {boolean}
     *  @default true
     */
    open var showEmptyMessage: Boolean = true
    /**
     *  The string to display in the body of a listGrid with an empty data array, if
     *   showEmptyMessage is true.
     *  @type {HTMLString}
     *  @default "No items to show."
     */
    open var emptyMessage: String = "No items to show."
    /**
     *  The CSS style name applied to the ListGrid.emptyMessage if displayed.
     *  @type {CSSStyleName}
     *  @default "emptyMessage"
     */
    open var emptyMessageStyle: String = "emptyMessage"
    /**
     *  The prompt to show when the mouse hovers over the Filter button in the FilterEditor.
     *  @type {string}
     *  @default "Filter"
     */
    open var filterButtonPrompt: String = "Filter"
    /**
     *  The string to display in the body of a listGrid while data is being loaded.
     *   Use "&#36;{loadingImage}" to include Canvas.loadingImageSrc.
     *  @type {HTMLString}
     *  @default "${loadingImage}&amp;nbsp;Loading data..."
     */
    open var loadingDataMessage: String = "\${loadingImage}&amp;nbsp;Loading data..."
    /**
     *  The CSS style name applied to the loadingDataMessage string if displayed.
     *  @type {CSSStyleName}
     *  @default "loadingDataMessage"
     */
    open var loadingDataMessageStyle: String = "loadingDataMessage"
    /**
     *  If you have a databound listGrid and you scroll out of the currently loaded dataset, by
     *   default you will see blank rows until the server returns the data for those rows. The
     *   loadingMessage attribute allows you to specify arbitrary html that will be shown in each
     *   such "blank" record while the data for that record is loading.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var loadingMessage: String = "&amp;nbsp;"
    /**
     *  If record[this.singleCellValueProperty] is set for some record, the
     *   record will be displayed as a single cell spanning every column in the grid, with
     *   contents set to the value of record[this.singleCellValueProperty].
     *  @type {string}
     *  @default "singleCellValue"
     */
    open var singleCellValueProperty: String = "singleCellValue"
    /**
     *  If record[this.isSeparatorProperty] is set for some record, the
     *   record will be displayed as a simple separator row.
     *  @type {string}
     *  @default "isSeparator"
     */
    open var isSeparatorProperty: String = "isSeparator"
    /**
     *  Should this listGrid display a filter row. If true, this ListGrid
     *   will be drawn with a single editable row, (separate from the body) with a filter button.
     *
     *   Values entered into this row are used as filter criteria to filter this List's data on
     *   enter-keypress or filter button click. ListGrid.autoFetchTextMatchStyle determines
     *   the textMatchStyle for the request passed to ListGrid.fetchData.
     *
     *   The default FormItem.operator for an item in the filterEditor can
     *   be set via ListGridField.filterOperator.  When field.filterOperator
     *   has been set calls to retrieve the criteria from the grid return AdvancedCriteria.
     *   See also ListGrid.allowFilterOperators for a UI that allows end users to change the search
     *   operator on the fly
     *
     *   Note that if ListGrid.filterData or ListGrid.fetchData is called
     *   directly while the filter editor is showing, the filter editor values will be updated to
     *   reflect the new set of criteria. If you wish to retain the user entered filter criteria
     *   and modify a subset of field values programmatically, this can be achieved by
     *   copying the existing set of criteria and adding other changes - something
     *   like this:
     *
     *
     *    var newCriteria = myListGrid.getFilterEditorCriteria();
     *    isc.DataSource.combineCriteria(newCriteria, {
     *     field1:"new value1",
     *     field2:"new value2"
     *    });
     *    myListGrid.setCriteria(newCriteria);
     *
     *
     *
     *   In this example code we're using ListGrid.getFilterEditorCriteria rather than
     *   ListGrid.getCriteria - this ensures that if the user has typed a new value into
     *   the filter editor, but not yet clicked the filter button, we pick up the value the user
     *   entered. This sample code uses DataSource.combineCriteria to combine the
     *   existing filterEditorCriteria with some new custom criteria. This technique is
     *   applicable to both simple and advanced criteria.
     *
     *   If you call filterData() and pass in criteria for dataSource
     *   fields that are not present in the ListGrid, these criteria will continue to be applied
     *   along with the user-visible criteria.
     *
     *   filterEditor and advanced criteria: If a developer calls filterData()
     *   on a ListGrid and passes in AdvancedCriteria, expected behavior of the filter
     *   editor becomes ambiguous, since AdvancedCriteria has far more complex filter
     *   expression support than the ordinary filterEditor can represent.
     *
     *   Default behavior for AdvancedCriteria will combine the AdvancedCriteria with the values
     *   in the filter editor as follows:
     *
     *
     *  - If the top level criteria has operator of type "and":
     *   Each field in the top level
     *   criteria array for which a 'canFilter' true field is shown in the listGrid will show up
     *   if the specified operator matches the default filter behavior
     *   (based on the ListGrid.autoFetchTextMatchStyle).
     *   If the user enters values in the filter editor, these will be combined with the
     *   existing AdvancedCriteria by either replacing or adding field level criteria at the top
     *   level.
     *
     *  - If the top level criteria is a single field-criteria:
     *   If the field shows up in the listGrid and is canFilter:true, it will be displayed to
     *   the user (if the operator matches the default filter behavior for the field).
     *   If the user enters new filter criteria in the filterEditor, they will be combined with
     *   this existing criterion via a top level "and" operator, or if the user modifies the
     *   field for which the criterion already existed, it will be replaced.
     *
     *  - Otherwise, if there are multiple top level criteria combined with an "or" operator,
     *   these will not be shown in the filter editor. Any filter parameters the user enters will
     *   be added to the existing criteria via an additional top level "and" operator, meaning
     *   the user will essentially filter a subset of the existing criteria
     *
     *  @type {boolean}
     *  @default false
     */
    open var showFilterEditor: Boolean = false
    /**
     *  If ListGrid.showFilterEditor is set to true, the filterEditor
     *   is automatically created as an AutoChild.
     *   Developers may customize the AutoChild using ListGrid.filterEditorProperties.
     *  @type {RecordEditor}
     *  @default null
     */
    open var filterEditor: RecordEditor? = null
    /**
     *  Properties to apply to the automatically generated ListGrid.filterEditor
     *   if ListGrid.showFilterEditor is true.
     *  @type {RecordEditor}
     *  @default null
     */
    open var filterEditorProperties: RecordEditor? = null
    /**
     *  If ListGrid.showFilterEditor is true, this attribute may be used to customize the
     *   filter button shown to the right of the filterEditor row.
     *  @type {Button}
     *  @default null
     */
    open var filterButtonProperties: Button? = null
    /**
     *  Height for the filterEditor, if shown.
     *  @type {number}
     *  @default "22"
     */
    open var filterEditorHeight: Number = 22
    /**
     *  When this grid is initially filtered via ListGrid.autoFetchData, or filtered by the user
     *   via the ListGrid.showFilterEditor, this attribute can be used to set the
     *   textMatchStyle on the dsRequest passed to fetchData().
     *
     *   To use a mixture of textMatchStyles, set an appropriate
     *   FormItem.operator on a field's
     *   ListGridField.filterEditorProperties.
     *  @type {TextMatchStyle}
     *  @default "substring"
     */
    open var autoFetchTextMatchStyle:
            /**
             *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
             *  case-sensitive exact match ("foo" matches only "foo")
             *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
             *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
             *   textMatchStyle behavior is consistent across the client and all three of the built-in
             *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
             *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
             *   are described below
             *
             *  - textMatchStyle can be disabled for any individual field with the
             *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
             *   across client and server implementations, with the proviso that case-sensitive behavior
             *   is inherently inconsistent in the server-side implementations (see below for a more
             *   detailed discussion of this)
             *
             *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
             *   fields on update and remove operations, unless
             *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
             *   or remove operation - which is constrained by a unique primaryKey value or combination, to
             *   affect only a single data row - will use an equality match on all primaryKey fields. This
             *   is desirable because it makes index usage more likely. Note that this means the key values
             *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
             *   this change will have no effect because most databases do not by default allow primaryKey
             *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
             *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
             *   However, if you are using a database hat allows key values that differ only in case, and you
             *   need to support this for some reason, you can switch the framework back to the previous
             *   behavior by setting property allow.case.sensitive.pks to true in
             *   your server.properties file. Note, we do not recommend this; in fact, we do
             *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
             *   always recommend the use of automatically incrementing numeric sequence keys.
             *
             *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
             *   DataSourceField.type. Such fields are always checked for equality. If
             *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
             *
             *  - Critiera values for temporal fields must be real dates (Javascript Date
             *   objects on the client, instances of java.util.Date on the server). Attempting
             *   to match against a string or any other type of value will result in an "always fails"
             *   clause being generated. This behavior is how the client code has always worked, but is a
             *   change for the server-side DataSources, in the interests of consistency. The previous
             *   behavior was:
             *
             *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
             *    if that value was an appropriately-formatted string, that attempt might have
             *    worked, but it would be database-specific. If you have an application that depends on
             *    this old behavior, you can switch it back on by adding the following to your
             *    server.properties file:
             *    sql.temporal.fields.require.date.criteria: false
             *
             *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
             *    results in the opposite behavior (there is an implied "always succeeds" clause, because
             *    the clause is not present in the query at all). If you have an application that depends on
             *    this old behavior, you can switch it back on by adding the following to your
             *    server.properties file:
             *    jpa.temporal.fields.require.date.criteria: false or
             *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
             *
             *
             *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
             *   DataSourceField.includeFrom declarations or entity relations in
             *   Hibernate or JPA. Again, such comparisons are always for equality
             *
             *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
             *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
             *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
             *   criteria value of 10 (the actual number) is supplied
             *
             *  - This is a change in behavior for the server-side DataSource implementations, in the
             *    interests of consistency with the client behavior. Previously, all three of the built-in
             *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
             *    criteria value's type. If you have an application that depends on this old behavior,
             *    you can switch it back on by adding the following to your server.properties
             *    file: sql.substring.numeric.criteria: true or
             *    hibernate.substring.numeric.criteria: true or
             *    jpa.substring.numeric.criteria: true, as appropriate
             *
             *
             *  - "exactCase" matching cannot be made consistent across all database providers because
             *   each database has its own idea of whether case-sensitive matching should be the default,
             *   and how to switch it on and off (if that is even possible)
             *
             *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
             *    case-sensitive collation when the database is created (there are more fine-grained
             *    options, but we do not recommend them because of the scope for further inconsistency,
             *    where "exactCase" works correctly on table A but not on table B). See
             *    MSDN for details
             *
             *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
             *    see here
             *
             *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
             *    case-sensitive matching in SQL, we work around it for that database, but only in
             *    SQL DataSources
             *
             *
             *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
             *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
             *   control of the SQL that the database executes, we are constrained by what the ORM will
             *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
             *   case-insensitivity in the SQL DataSource
             *
             */
            String /* exact |  exactCase |  substring |  startsWith */ = "substring"
    /**
     *  Causes a menu item titled ListGrid.filterUsingText to appear in the
     *   ListGrid.showHeaderContextMenu that allows the end user to pick an advanced
     *   OperatorId to use for this field.
     *
     *   Once an operator has been chosen, the active operator is indicated by an
     *   ListGrid.operatorIcon placed within the field (you can alternatively cause the
     *   icon to ListGrid.alwaysShowOperatorIcon). The operatorIcon
     *   shows the same textual representation of the search operator as is used by the
     *   FormItem.allowExpressions feature. Clicking on the icon provides a second way to
     *   modify the search operator.
     *
     *   This feature is enabled by default if DataSource.supportsAdvancedCriteria is true,
     *   for all fields where it is normally possible to filter by typing in a search string. This
     *   excludes field types such as "date" or "boolean" which show specialized filter controls.
     *   Use ListGridField.allowFilterOperators to disable this interface for individual
     *   fields, or set DataSourceField.canFilter to false to disallow filtering entirely for
     *   a field.
     *
     *   Note that this feature is similar to ListGrid.allowFilterExpressions, which allows
     *   the end users to directly type in characters such as "&gt;" to control filtering.
     *   allowFilterOperators is easier to use and more discoverable than
     *   allowFilterExpressions, and also avoids the drawback where special characters
     *   like "&gt;" cannot be used in filter values. However, allowFilterExpressions
     *   allows users to make use of certain operators that allowFilterOperators does
     *   not support, such as using the "betweenInclusive" operator by typing "5...10".
     *
     *   When both allowfilterExpressions and allowFilterOperators are set,
     *   filter expressions entered in to the edit-area are parsed and the operator automatically
     *   applied to the ListGrid.operatorIcon.
     *  @type {boolean}
     *  @default null
     */
    open var allowFilterOperators: Boolean? = null
    /**
     *  When ListGrid.allowFilterOperators is enabled, whether to show the ListGrid.operatorIcon for all
     *   filterable fields, or only for fields where the user has explicitly chosen a search operator
     *   different from the default operator for the field.
     *
     *   The default operator for a field is determined by ListGrid.autoFetchTextMatchStyle or by
     *   setting ListGridField.filterOperator for a specific field.
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowOperatorIcon: Boolean? = null
    /**
     *  Inline icon shown inside ListGrid.showFilterEditor fields when
     *   ListGrid.allowFilterOperators is enabled.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var operatorIcon: FormItemIcon? = null
    /**
     *  Text for the menu item shown in the ListGrid.showHeaderContextMenu when
     *   ListGrid.allowFilterOperators is enabled.
     *  @type {string}
     *  @default "Filter using"
     */
    open var filterUsingText: String = "Filter using"
    /**
     *  Text to show after the name of the default filterOperator in the
     *   ListGrid.showHeaderContextMenu when ListGrid.allowFilterOperators is enabled.
     *  @type {string}
     *  @default "(default)"
     */
    open var defaultFilterOperatorSuffix: String = "(default)"
    /**
     *  Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for
     *     individual fields.
     *     If 'canEdit' is false at the listGrid level, fields can never be edited - in this case
     *     the canEdit property on individual fields will be ignored.
     *     If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to
     *     false at the field level will prevent the field from being edited inline.
     *     If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field
     *     level enables the field to be edited inline.
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean? = null
    /**
     *  Property name on a record that should be checked to determine whether the record may be
     *   edited.
     *
     *   This property is configurable to avoid possible collision with data values in record.
     *   With the default setting of "_canEdit", a record can be set non-editable by ensuring
     *   record._canEdit == false.
     *
     *   For controlling editability for the entire grid or for a field, set grid.canEdit or
     *   field.canEdit.
     *  @type {string}
     *  @default "_canEdit"
     */
    open var recordEditProperty: String = "_canEdit"
    /**
     *  When this attribute is set, editors will be rendered into every row of the grid rather than
     *   showing up in a single record at a time.
     *   This attribute is only valid when ListGrid.editByCell is false
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowEditors: Boolean? = null
    /**
     *  Determines whether when the user edits a cell in this listGrid the entire row becomes
     *   editable, or just the cell that received the edit event.
     *
     *   No effect if this.canEdit is false or null.
     *  @type {boolean}
     *  @default null
     */
    open var editByCell: Boolean? = null
    /**
     *  Whether edits should be saved whenever the user moves between cells in the current edit
     *   row.
     *
     *   If unset, defaults to ListGrid.editByCell.
     *
     *   To avoid automatic saving entirely, set ListGrid.autoSaveEdits:false.
     *  @type {boolean}
     *  @default null
     */
    open var saveByCell: Boolean? = null
    /**
     *  Whether client-side validation checks should be performed when the user moves between
     *   cells in the current edit row. If unset, defaults to ListGrid.editByCell.
     *
     *   Note that validation always occurs when a row is to be saved, so setting
     *   ListGrid.saveByCell:true forces validation on cell transitions. To completely disable
     *   automatic validation, set ListGrid.neverValidate:true.
     *  @type {boolean}
     *  @default null
     */
    open var validateByCell: Boolean? = null
    /**
     *  If true, validation will be performed on each edited cell when each editor's
     *   "change" handler is fired.
     *  @type {boolean}
     *  @default null
     */
    open var validateOnChange: Boolean? = null
    /**
     *  If true, validation will not occur as a result of cell editing for this grid.
     *  @type {boolean}
     *  @default null
     */
    open var neverValidate: Boolean? = null
    /**
     *  If set, provide UI for the user to remove records from the grid as an additional field
     *   showing the ListGrid.removeIcon, which, when clicked, will call
     *   ListGrid.removeRecordClick which removes the row from the data set (or if
     *   ListGrid.deferRemoval is true changes the ListGrid.markRecordRemoved status
     *   for the record). Individual records can be marked to prevent removal - see
     *   ListGrid.recordCanRemoveProperty.
     *
     *   To add a confirmation dialog before a record is removed, set
     *   ListGrid.warnOnRemoval.
     *
     *   If deferring removal, the record will appear marked with the ListGrid.removedCSSText
     *   until the removal is committed via a call to ListGrid.saveEdits.
     *   Otherwise, the record will disappear from view. If ListGrid.animateRemoveRecord
     *   is true, the removed record will appear to shrink out of view when it is removed.
     *
     *   By default the field will display the ListGrid.removeIcon next to each record, and
     *   will be rendered as the rightmost column. Two mechanisms exist to further modify this field:
     *
     *
     *  - To change the position of the remove-field, include an explicitly specified field with
     *     the attribute ListGridField.isRemoveField set. This will then
     *     be used as the remove field instead of adding a field to the beginning of the set of
     *     columns.
     *
     *  - Additional direct configuration of the remove field may be achieved by modifying
     *     ListGrid.removeFieldProperties.
     *
     *   If ListGrid.deferRemoval is true, when a record is marked as removed, the the icon will
     *   change to display the ListGrid.unremoveIcon for this row. Clicking on this icon
     *   will call ListGrid.unmarkRecordRemoved to mark the record as no longer pending
     *   deletion.
     *  @type {boolean}
     *  @default false
     */
    open var canRemoveRecords: Boolean = false
    /**
     *  If ListGrid.canRemoveRecords is true, when the user clicks the remove icon
     *   for some record, should we show a warning message
     *   (defined as ListGrid.warnOnRemovalMessage) and allow the user to cancel removal?
     *  @type {boolean}
     *  @default false
     */
    open var warnOnRemoval: Boolean = false
    /**
     *  Warning message to show the user on a click on the 'remove' icon
     *   if ListGrid.canRemoveRecords is true and
     *   ListGrid.warnOnRemoval is true.
     *  @type {string}
     *  @default "Are you sure you want to delete this record?"
     */
    open var warnOnRemovalMessage: String = "Are you sure you want to delete this record?"
    /**
     *  Custom CSS text to be applied to records that have been
     *   ListGrid.markRecordRemoved.
     *
     *   This CSS text will be applied on top of standard disabled styling for the cell.
     *  @type {string}
     *  @default "text-decoration:line-through;"
     */
    open var removedCSSText: String = "text-decoration:line-through;"
    /**
     *  When enabled, the field shown by ListGrid.canRemoveRecords causes records to be
     *   marked for future removal via ListGrid.markRecordRemoved instead of immediately being
     *   removed.
     *
     *   When a record has been marked for removal, an icon in the
     *   canRemoveRecords field allowing it to be unmarked will be displayed.
     *
     *   If not explicitly specified by this property, removal of records will be deferred if
     *   ListGrid.autoSaveEdits is false for the grid.
     *  @type {boolean}
     *  @default null
     */
    open var deferRemoval: Boolean? = null
    /**
     *  When ListGrid.canRemoveRecords is enabled, default icon to show in
     *   the auto-generated field that allows removing records.
     *  @type {SCImgURL}
     *  @default "[SKIN]/actions/remove.png"
     */
    open var removeIcon: String = "[SKIN]/actions/remove.png"
    /**
     *  When ListGrid.canRemoveRecords is enabled, this icon will be shown in the
     *   auto generated field fro removing records if the record has been marked as removed via
     *   ListGrid.markRecordRemoved. At this point, clicking on the icon will
     *   unmark the record as removed.
     *  @type {SCImgURL}
     *  @default "[SKIN]/actions/undo.png"
     */
    open var unremoveIcon: String = "[SKIN]/actions/undo.png"
    /**
     *  Default width and height of ListGrid.removeIcon for this ListGrid.
     *  @type {number}
     *  @default "16"
     */
    open var removeIconSize: Number = 16
    /**
     *  When ListGrid.canRemoveRecords is enabled, should records be animated out of view
     *   when they are removed by the user?
     *  @type {boolean}
     *  @default true
     */
    open var animateRemoveRecord: Boolean = true
    /**
     *  When animating record removal
     *   ListGrid.animateRemoveRecord, if
     *   ListGrid.animateRemoveSpeed is not
     *   set, this property designates the duration of the animation in ms.
     *  @type {number}
     *  @default "100"
     */
    open var animateRemoveTime: Number = 100
    /**
     *  When ListGrid.animateRemoveRecord, this property
     *   designates the speed of the animation in pixels per second. Takes precedence over the
     *   ListGrid.animateRemoveTime property, which allows the developer to specify a
     *   duration for the animation rather than a speed.
     *  @type {number}
     *  @default "200"
     */
    open var animateRemoveSpeed: Number = 200
    /**
     *  The title to use for the ListGrid.removeFieldDefaults.
     *
     *   By default this title is not displayed in the remove column header button as the
     *   ListGrid.removeFieldDefaults sets ListGridField.showTitle to false.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var removeFieldTitle: String = "&amp;nbsp;"
    /**
     *  Default configuration properties for the "remove field"
     *   displayed when ListGrid.canRemoveRecords is enabled.
     *   Class.changeDefaults should be used when modifying this object.
     *
     *   The default configuration includes a ListGridField.recordClick handler which
     *   calls ListGrid.removeData to actually perform the data removal.
     *  @type {ListGridField}
     *  @default "{...}"
     */
    // open var removeFieldDefaults: ListGridField = definedExternally
    /**
     *  Configuration properties for the "remove field" displayed when
     *   ListGrid.canRemoveRecords is enabled.
     *   These configuration settings will be overlaid
     *   on top of the ListGrid.removeFieldDefaults.
     *  @type {ListGridField}
     *  @default null
     */
    open var removeFieldProperties: ListGridField? = null
    /**
     *  If we're showing the filterEditor (this.showFilterEditor is true), this property
     *   determines whether this list should be filtered every time the user puts focus in
     *   a different field in the filter editor.
     *  @type {boolean}
     *  @default null
     */
    open var filterByCell: Boolean? = null
    /**
     *  If we're showing the filterEditor (this.showFilterEditor is true), this property
     *   determines whether this list should be filtered every time the user modifies the value
     *   in a field of the filter-editor. Can also be set at the field level.
     *  @type {boolean}
     *  @default null
     */
    open var filterOnKeypress: Boolean? = null
    /**
     *  If this is an editable listGrid, this property determines whether the user will be
     *   able to dismiss the edit form, or navigate to another cell while the save is in
     *   process (before the asynchronous server response returns).
     *  @type {boolean}
     *  @default false
     */
    open var waitForSave: Boolean = false
    /**
     *  If this is an editable listGrid, this property determines how failure to save due to
     *   validation errors should be displayed to the user.
     *
     *   If this property is true, when validation errors occur the errors will be displayed
     *   to the user in an alert, and focus will be returned to the first cell to fail validation.
     *
     *   If false, the cells that failed validation will be silently styled with the
     *   editFailedBaseStyle.
     *
     *   Note: stopOnErrors being set to true implies that 'waitForSave' is also true.
     *   We will not dismiss the editor until save has completed if stopOnErrors is true.
     *  @type {boolean}
     *  @default false
     */
    open var stopOnErrors: Boolean = false
    /**
     *  If this ListGrid is editable, should edits be saved out when the user finishes editing
     *   a row (or a cell if ListGrid.saveByCell is true).
     *
     *   The default of true indicates that edits will be
     *   ListGrid.saveByCell as the
     *   user navigates through the grid and/or ${isc.DocUtils.linkForRef('type:EnterKeyEditAction','hits \'Enter\'')} to end
     *   editing. See the editing overview for details.
     *
     *   Setting autoSaveEdits false creates a "mass update" / "mass delete"
     *   interaction where edits will be retained for all edited cells (across rows if
     *   appropriate) until ListGrid.saveEdits is called to save a particular row, or
     *   ListGrid.saveAllEdits is called to save all changes in a batch.
     *
     *   Note: when ListGrid.groupByField is enabled, or when
     *   working with hierarchical data in a TreeGrid, users have the option to hide
     *   records from view by collapsing the parent folder or group. This, in conjunction with
     *   autoSaveEdits being set to false can lead to a case where
     *   a user is unable to save edits due to validation errors on hidden rows. Therefore we
     *   recommend developers consider having validators in place such that errors are caught
     *   and displayed to the user on change or editor exit rather than being caught only when
     *   saving is attempted. If it's not possible for all validation to be performed immediately
     *   on row exit, we recommend that a different UI design be used that does not involve
     *   autoSaveEdits being set to false.
     *  @type {boolean}
     *  @default true
     */
    open var autoSaveEdits: Boolean = true
    /**
     *  If this grid is editable, and an edit has caused validation failure for some cell,
     *   should we show an icon to indicate validation failure?
     *  @type {boolean}
     *  @default true
     */
    open var showErrorIcons: Boolean = true
    /**
     *  Height of the error icon, if we're showing icons when validation errors occur.
     *  @type {Integer}
     *  @default "16"
     */
    open var errorIconHeight: Number = 16
    /**
     *  Height of the error icon, if we're showing icons when validation errors occur.
     *  @type {Integer}
     *  @default "16"
     */
    open var errorIconWidth: Number = 16
    /**
     *  Src of the image to show as an error icon, if we're showing icons when validation
     *     errors occur.
     *  @type {SCImgURL}
     *  @default "[SKIN]/ListGrid/validation_error_icon.png"
     */
    open var errorIconSrc: String = "[SKIN]/ListGrid/validation_error_icon.png"
    /**
     *  If this is an editable listGrid, when the user attempts to cancel an edit, should we
     *   display a confirmation prompt before discarding the edited values for the record?
     *  @type {boolean}
     *  @default false
     */
    open var confirmCancelEditing: Boolean = false
    /**
     *  If this is an editable listGrid, and this.confirmCancelEditing is true
     *   this property is used as the message to display in the confirmation dismissal prompt.
     *  @type {string}
     *  @default "Cancelling this edit will discard unsaved changes for this record. Continue?"
     */
    open var cancelEditingConfirmationMessage: String = "Cancelling this edit will discard unsaved changes for this record. Continue?"
    /**
     *  For editable listGrids, outstanding unsaved edits when the user performs a new filter
     *   or sort will be discarded. This flag determines whether we should display a confirmation
     *   dialog with options to save or discard the edits, or cancel the action in this case.
     *  @type {boolean}
     *  @default true
     */
    open var confirmDiscardEdits: Boolean = true
    /**
     *  For editable listGrids, outstanding unsaved edits when the user performs a new filter
     *   or sort will be discarded by default. This flag determines whether we should save such
     *   edits automatically in this case. See also ListGrid.confirmDiscardEdits, which
     *   allows the user to choose whether to save or discard the unsaved edits.
     *  @type {boolean}
     *  @default false
     */
    open var autoConfirmSaveEdits: Boolean = false
    /**
     *  If this.confirmDiscardEdits is true, this property can be used to customize the
     *   error message string displayed to the user in a dialog with options to
     *   cancel the action, or save or discard pending edits in response to sort/filter actions
     *   that would otherwise drop unsaved edit values.
     *  @type {string}
     *  @default "This action will discard unsaved changes for this list."
     */
    open var confirmDiscardEditsMessage: String = "This action will discard unsaved changes for this list."
    /**
     *  If ListGrid.confirmDiscardEdits is true this is the title for the save button
     *   appearing in the lost edits confirmation dialog. Override this for localization if necessary.
     *  @type {string}
     *  @default "Save"
     */
    open var discardEditsSaveButtonTitle: String = "Save"
    /**
     *  If the user is editing a record in this listGrid, and attempts to navigate to a field
     *   beyond the end of the row, via tab (or shift-tab off the first editable field), this
     *   property determines what action to take:
     *
     *  - "next": start editing the next (or previous) record in the list
     *
     *  - "same": put focus back into the first editable field of the same record.
     *
     *  - "done": hide the editor
     *
     *  - "stop": leave focus in the cell being edited
     *
     *  - "none": no action
     *
     *  @type {RowEndEditAction}
     *  @default null
     */
    open var rowEndEditAction:
            /**
             *  navigate to the first editable cell in the same record
             *  navigate to the first editable cell in the next record
             *  complete the edit.
             *  Leave focus in the cell being edited (take no action)
             *  take no action
             */
            String? /* same |  next |  done |  stop |  none */ = null
    /**
     *  If the user is editing the last record in this listGrid, and attempts to navigate
     *   beyond the last row either by tabbing off the last editable field, or using the down
     *   arrow key, this property determines what action to take:
     *
     *  - "next": start editing a new record at the end of the list.
     *
     *  - "done": hide the editor
     *
     *  - "stop": leave focus in the cell being edited
     *
     *  - "none": no action
     *
     *
     *   See the editing and also the
     *   unsavedRecords for context about how newly
     *   added records behave.
     *  @type {RowEndEditAction}
     *  @default null
     */
    open var listEndEditAction:
            /**
             *  navigate to the first editable cell in the same record
             *  navigate to the first editable cell in the next record
             *  complete the edit.
             *  Leave focus in the cell being edited (take no action)
             *  take no action
             */
            String? /* same |  next |  done |  stop |  none */ = null
    /**
     *  What to do when a user hits enter while editing a cell:
     *
     *
     *  - "nextCell": start editing the next editable cell in this record (or the first
     *     editable cell in the next record if focus is in the last editable cell in the row)
     *
     *  - "nextRow": start editing the same field in the next row (skipping any rows where
     *     that would be a non-editable cell.
     *
     *  - "nextRowStart": start editing the first editable cell in the next row.
     *
     *  - "done": hide the editor (editing is complete)
     *
     *   Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
     *  @type {EnterKeyEditAction}
     *  @default "done"
     */
    open var enterKeyEditAction:
            /**
             *  end editing (will save edit values if ListGrid.autoSaveEdits is true).
             *  edit the next editable cell in the record
             *  edit the same field in the next editable record
             *  edit the first editable cell in next editable record
             */
            String /* done |  nextCell |  nextRow |  nextRowStart */ = "done"
    /**
     *  What to do when a user hits escape while editing a cell:
     *
     *  - "cancel": close the editor and discard the current set of edit values
     *
     *  - "done": just close the editor (the edit is complete, but the edited values are retained).
     *
     *   Note that if ListGrid.autoSaveEdits is true, this may cause a save of the current edit values
     *  @type {EscapeKeyEditAction}
     *  @default "cancel"
     */
    open var escapeKeyEditAction:
            /**
             *  cancels the current edit and discards edit values
             *  end editing (will save edit values if ListGrid.autoSaveEdits is true).
             *  exit the editor (edit values will be left intact but not saved).
             *  do nothing special when the Escape key is pressed (ie, just ignore it)
             */
            String /* cancel |  done |  exit |  ignore */ = "cancel"
    /**
     *  Event that will trigger inline editing, see ListGridEditEvent for options.
     *
     *   Note this setting has no effect unless ListGrid.canEdit has been set to enable editing.
     *
     *   See also ListGrid.editOnFocus and ListGrid.startEditing.
     *  @type {ListGridEditEvent}
     *  @default "doubleClick"
     */
    open var editEvent:
            /**
             *  A single mouse click triggers inline editing
             *  A double click triggers inline editing
             *  No mouse event will trigger editing. Editing must be           programmatically started via ListGrid.startEditing
             *             (perhaps from an external button) or may be triggered by
             *             keyboard navigation if ListGrid.editOnFocus is set.
             */
            String /* click |  doubleClick |  none */ = "doubleClick"
    /**
     *  Should we start editing when this widget receives focus (if this ListGrid supports
     *   editing)?
     *
     *   Note that this property being set to true will cause editing to occur on a single
     *   click, even if ListGrid.editEvent is "doubleClick", because single clicking
     *   the grid will place keyboard focus there automatically.
     *
     *   If this property is set together with ListGrid.listEndEditAction being set to "next",
     *   users can create a new edit row in an empty grid by simply tabbing into the grid.
     *  @type {boolean}
     *  @default null
     */
    open var editOnFocus: Boolean? = null
    /**
     *  Should we start editing when the widget has focus and the user presses the "f2" key
     *   (if this ListGrid supports editing)?
     *
     *   Note that if ListGrid.editEvent is set to "click" or
     *   "doubleClick", the Space or Enter key may
     *   also be used to start editing, depending on the value for ListGrid.generateClickOnSpace,
     *   ListGrid.generateDoubleClickOnSpace, ListGrid.generateClickOnEnter and
     *   ListGrid.generateDoubleClickOnEnter.
     *
     *   If ListGrid.canEdit is false, or ListGrid.editEvent is set to "none" this
     *   property has no effect.
     *  @type {boolean}
     *  @default true
     */
    open var editOnF2Keypress: Boolean = true
    /**
     *  When the user starts editing a row, should the row also be selected?
     *
     *   See ListGrid.editSelectionType for how edit-selection behaves.
     *  @type {boolean}
     *  @default true
     */
    open var selectOnEdit: Boolean = true
    /**
     *  If ListGrid.selectOnEdit is true, what should be the edit-selection behavior
     *   be?
     *
     *   Default setting of "single" will cause the edit row to be automatically
     *   selected and any other selection in the grid to be dropped.
     *   If set to "multiple", selection will be additive (as a record goes
     *   into edit mode, it is selected in addition to any pre-existant selection).
     *
     *   If set to null behavior is as follows:
     *
     *  - For grids with ListGrid.selectionType set to
     *   "simple" edit rows will be selected additively - this is the same
     *   behavior as if the editSelectionType was "multiple"
     *
     *  - Otherwise edit rows will be selected singly - this is the same behavior as
     *   if the editSelectionType was "single"
     *
     *  @type {SelectionStyle}
     *  @default "single"
     */
    open var editSelectionType:
            /**
             *  don't select at all
             *  select only one item at a time
             *  select one or more items
             *  select one or more items as a toggle      so you don't need to hold down control keys to select
             *                   more than one object
             */
            String /* none |  single |  multiple |  simple */ = "single"
    /**
     *  In a ListGrid that has a DataSource and has filter criteria that include values for
     *   fields declared as FieldType in the DataSource, by default a newly
     *   edited row will use those filter criteria as initial values.
     *
     *   For example, if a ListGrid is showing all Accounts that have status:"Active" and a new row
     *   is created, the new row will default to status:"Active" unless this flag is set to false.
     *  @type {boolean}
     *  @default true
     */
    open var enumCriteriaAsInitialValues: Boolean = true
    /**
     *  Whether to do inline autoComplete in text fields during inline editing
     *   Overridden by ListGridField.autoComplete if specified.
     *   If unset picks up the default from the appropriate editor class (subclass of FormItem).
     *  @type {AutoComplete}
     *  @default null
     */
    open var autoComplete:
            /**
             *  Disable browser autoComplete. Note that some browsers will disregard  this setting and still perform native autoComplete for certain items - typically
             *    only for log in / password forms. See the discussion FormItem.autoComplete.
             *  Allow native browser autoComplete.
             */
            String? /* none |  native */ = null
    /**
     *  When the length of the field specified by DataSourceField.length exceeds this
     *   value, the ListGrid shows an edit field of type ListGrid.longTextEditorType
     *   rather than the standard text field when the field enters inline edit mode.
     *  @type {Integer}
     *  @default "255"
     */
    open var longTextEditorThreshold: Number = 255
    /**
     *  When the length of the field specified by DataSourceField.length exceeds
     *   this.longTextEditorThreshold show an edit field of this type
     *   rather than the standard text field when the field enters inline edit mode.
     *  @type {string}
     *  @default "PopUpTextAreaItem"
     */
    open var longTextEditorType: String = "PopUpTextAreaItem"
    /**
     *  A Toolbar used to manager the headers shown for each column of the grid.
     *  @type {Layout}
     *  @default null
     */
    open var header: Layout? = null
    /**
     *  The context menu displayed for column headers.
     *  @type {Canvas}
     *  @default null
     */
    open var headerContextMenu: Canvas? = null
    /**
     *  The menu displayed when a cell is right clicked on.
     *  @type {Layout}
     *  @default null
     */
    open var cellContextMenu: Layout? = null
    /**
     *  The menu displayed when a cell is right clicked on.
     *  @type {Layout}
     *  @default null
     */
    open var spanContextMenu: Layout? = null
    /**
     *  Should the header be included in the tab-order for the page? If not explicitly specified,
     *   the header will be included in the tab order for the page if
     *   isc.setScreenReaderMode
     *
     *   is called.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToHeader: Boolean? = null
    /**
     *  The height of this listGrid's header, in pixels.
     *  @type {number}
     *  @default "22"
     */
    open var headerHeight: Number = 22
    /**
     *  Minimum size, in pixels, for ListGrid headers.
     *  @type {Integer}
     *  @default "15"
     */
    open var minFieldWidth: Number = 15
    /**
     *  Should we show the header for this ListGrid?
     *  @type {boolean}
     *  @default true
     */
    open var showHeader: Boolean = true
    /**
     *  Set the CSS style used for the header as a whole.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerBarStyle: String? = null
    /**
     *  BackgroundColor for the header toolbar. Typically this is set to match the color
     *   of the header buttons.
     *  @type {CSSColor}
     *  @default "#CCCCCC"
     */
    open var headerBackgroundColor: String = "#CCCCCC"
    /**
     *  Should the header show a drop-shadow?
     *   Shadow will be applied to the header, or for a grid with frozen columns, the
     *   header layout.
     *
     *   Header shadow will only be displayed if Canvas.useCSSShadow are
     *   being used.
     *  @type {boolean}
     *  @default false
     */
    open var showHeaderShadow: Boolean = false
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowVOffset for
     *   the header shadow
     *  @type {number}
     *  @default "1"
     */
    open var headerShadowVOffset: Number = 1
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowHOffset for
     *   the header shadow
     *  @type {number}
     *  @default "0"
     */
    open var headerShadowHOffset: Number = 0
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowSoftness for
     *   the header shadow
     *  @type {number}
     *  @default "1"
     */
    open var headerShadowSoftness: Number = 1
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowColor for
     *   the header shadow.
     *  @type {CSSColor}
     *  @default null
     */
    open var headerShadowColor: String? = null
    /**
     *  Widget class for this ListGrid's header buttons. If unset, constructor will be
     *   picked up directly from the standard Toolbar button constructor.
     *  @type {Class}
     *  @default null
     */
    open var headerButtonConstructor: Class? = null
    /**
     *  Button.baseStyle to apply to the buttons in the header, and the sorter, for
     *   this ListGrid.
     *   Note that, depending on the ListGrid.headerButtonConstructor of the header
     *   buttons, you may also need to set ListGrid.headerTitleStyle.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerBaseStyle: String? = null
    /**
     *  StretchImgButton.titleStyle to apply to the buttons in the header, and the sorter,
     *   for this ListGrid.
     *   Note that this will typically only have an effect if
     *   ListGrid.headerButtonConstructor is set to StretchImgButton or a subclass
     *   thereof.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerTitleStyle: String? = null
    /**
     *  If this listGrid contains any frozen fields, this property can be used to apply a custom
     *   headerBaseStyle to the frozen set of fields. If unset, the standard headerBaseStyle
     *   will be used for both frozen and unfrozen cells.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var frozenHeaderBaseStyle: String? = null
    /**
     *  If this listGrid contains any frozen fields, this property can be used to apply a custom
     *   headerTitleStyle to the frozen set of fields. If unset, the standard headerTitleStyle
     *   will be used for both frozen and unfrozen cells.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var frozenHeaderTitleStyle: String? = null
    /**
     *  Defaults to apply to all header buttons. To modify this object,
     *   use Class.changeDefaults
     *   rather than replacing with an entirely new object.
     *  @type {Button}
     *  @default "{...}"
     */
    // open var headerButtonDefaults: Button =
    /**
     *  Properties to apply to all header buttons.
     *   Overrides defaults applied via ListGrid.headerButtonDefaults.
     *  @type {Button}
     *  @default null
     */
    //open var headerButtonProperties: Button = definedExternally
    /**
     *  Whether the ListGrid should manage the clipping of titles of header buttons, showing
     *   ellipses if the title is clipped, and potentially showing the full title
     *   on ListGrid.showClippedHeaderTitlesOnHover.
     *
     *   In some cases this may be preferable to the button component's default clipping behavior
     *   because if a ListGrid.showSortArrow or sort numeral is displayed for
     *   a header, then the button's default clipping behavior may clip the sort arrow/numeral
     *   whereas ListGrid-managed title clipping utilizes special HTML which keeps the sort
     *   arrow/numeral visible.
     *
     *   This feature is automatically enabled if supported by the browser. The only supported
     *   use of this attribute is to disable the feature by setting clipHeaderTitles
     *   to false.
     *
     *   Note that this feature is incompatible with ListGridField.wrap, and will
     *   automatically be disabled for wrapping fields.
     *  @type {boolean}
     *  @default "varies"
     */
    // open var clipHeaderTitles: Boolean =
    /**
     *  If ListGridField.wrap is not explicitly set, should fields wrap? If autofitting,
     *   see the docs on that property for the details of how the minimum width for a field is
     *   determined.
     *  @type {boolean}
     *  @default null
     */
    open var wrapHeaderTitles: Boolean? = null
    /**
     *  If HeaderSpan.wrap is not explicitly set, should fields wrap? If autofitting,
     *   see the docs on that property for the details of how the minimum width for a field is
     *   determined.
     *  @type {boolean}
     *  @default null
     */
    open var wrapHeaderSpanTitles: Boolean? = null
    /**
     *  Widget class for the corner sort button, if showing. This button displays the current
     *   sort direction of the primary sort field (either the only sorted field or the first in a
     *   ListGrid.canMultiSort grid) and reverses the direction of that field
     *   when clicked. For consistent appearance, this
     *   is usually set to match ListGrid.headerButtonConstructor
     *  @type {Class}
     *  @default "Button"
     */
    open var sorterConstructor: Class = isc.Button.create(null, null)
    /**
     *  The title for the corner sort button. The title will only
     *   Class.changeDefaults rather than replacing with an
     *   entirely new object.
     *  @type {string}
     *  @default "corner menu"
     */
    open var sorterButtonTitle: String = "corner menu"
    /**
     *  Defaults to apply to the corner sort button. To modify this object, use
     *   Class.changeDefaults rather than replacing with an
     *   entirely new object.
     *  @type {object}
     *  @default "{...}"
     */
    //open var sorterDefaults: dynamic = definedExternally
    /**
     *  Properties to apply to the sorter button. Overrides defaults applied via
     *   ListGrid.sorterDefaults.
     *  @type {Button}
     *  @default null
     */
    open var sorterProperties: Button? = null
    /**
     *  If set, whenever grouping is performed by an end user or by a programmatic call to
     *   ListGrid.groupBy, data is implicitly sorted by all of the grouped columns, in the order
     *   they were passed to groupBy. Any user-configured sorting is applied after sorting by
     *   grouped columns.
     *
     *   Sorting by grouped fields will be in ascending or descending order according to whether
     *   the grid is currently sorted (by any field) in ascending or descending order, defaulting
     *   to ascending if the grid is not sorted. Implicit sorting by group can be forced to be
     *   always ascending or always descending by setting ListGrid.groupSortDirection.
     *
     *   The sorting is "implicit" in the sense that the sorting is not shown in the ListGrid
     *   headers, and not shown in the MultiSortDialog if enabled. An end user cannot
     *   currently remove the implicit sorting themselves (except by removing the grouping),
     *   though it is possible to override it by providing an explicit sort on the group's column.
     *   Clicking on the grouped field's header reveals the usual sort indicators with all
     *   the same semantics.
     *
     *   The correct way to remove implicit sorting programmatically is to call
     *   ListGrid.setSortByGroupFirst.
     *
     *   Programmatic calls to ListGrid.getSort will not include the implicit sort in
     *   the list of return sort specifiers, and calls to ListGrid.setSort will implicitly add
     *   the sorting by grouped columns before the specified sort.
     *
     *   Note that directly calling ResultSet.getSort() will include the implicit sort
     *   information.
     *  @type {boolean}
     *  @default null
     */
    open var sortByGroupFirst: Boolean? = null
    /**
     *  When ListGrid.sortByGroupFirst is active, the sorting direction applied for implicit
     *   sorting by the field(s) used for grouping. Default of null means that sort direction
     *   is based on the current direction of user-configured sort, or is "ascending" if the
     *   user has not sorted the data.
     *  @type {SortDirection}
     *  @default null
     */
    open var groupSortDirection:
            /**
             *  Sort in ascending order (eg: A-Z, larger items later in the list)
             *  Sort in descending order (eg: Z-A, larger items earlier in the list)
             */
            String? /* ascending |  descending */ = null
    /**
     *  For any fields of FieldType, should sorting be performed
     *   against the fileName of the value for the field? For SmartClient server backed
     *   dataSources, this is applied to the record automatically as described in the
     *   binaryFields overview.
     *
     *   If set to false, binary fields will be sorted against the record value for the
     *   field in question. Client-side sorting does not support this, so developers who
     *   actually want to support a sort against the binary itself would typically set
     *   ResultSet.useClientSorting to false on the ListGrid.dataProperties block for
     *   this grid.
     *
     *   Note that this setting will have no effect if DataSourceField.sortByField is
     *   specified
     *  @type {boolean}
     *  @default true
     */
    open var sortBinaryByFileName: Boolean = true
    /**
     *  Enables or disables interactive sorting behavior for this listGrid. Does not
     *   affect sorting by direct calls to the ListGrid.sort or
     *   ListGrid.setSort methods.
     *  @type {boolean}
     *  @default true
     */
    open var canSort: Boolean = true
    /**
     *  If true, show the field-header for the sorted field (or the first field in a
     *   ListGrid.canMultiSort grid) in the selected state.
     *  @type {boolean}
     *  @default true
     */
    open var selectHeaderOnSort: Boolean = true
    /**
     *  Specifies the number of the field by which to sort this listGrid. Column numbers
     *   start at 0 for the left-most column.
     *  @deprecated \* as of version 7.0 in favor of ListGrid.sortField
     *  @type {number}
     *  @default null
     */
    open var sortFieldNum: Number? = null
    /**
     *  Specifies the field by which this grid should be initially sorted. Can be set to either a
     *   ListGridField.name or the index of the field in the fields Array.
     *
     *   ListGrids also support being initialized with multiple-field sort via
     *   ListGrid.initialSort. If initialSort is specified, it will be used in preference
     *   to this property.
     *
     *   To sort the grid after it has been initialized, use ListGrid.sort or
     *   ListGrid.setSort. Details about the current sort of a live grid can be
     *   retrieved by calling ListGrid.getSortField or ListGrid.getSort
     *  @type {string | Integer}
     *  @default null
     */
    open var sortField: dynamic = null
    /**
     *  Sorting direction of this ListGrid. If specified when the ListGrid is initialized,
     *   this property will be the default sorting direction for the ListGrid.sortField.
     *   May be overridden by specifying ListGridField.sortDirection.
     *
     *   After initialization, this property will be updated on ListGrid.sort or
     *   ListGrid.setSort to reflect the current sort direction of the grid. When
     *   this grid is sorted by multiple fields, the grid's sortDirection reflects the
     *   sort direction of the primary sort field.
     *  @type {SortDirection}
     *  @default "ascending"
     */
    open var sortDirection:
            /**
             *  Sort in ascending order (eg: A-Z, larger items later in the list)
             *  Sort in descending order (eg: Z-A, larger items earlier in the list)
             */
            String /* ascending |  descending */ = "ascending"
    /**
     *  Indicates whether a sorting arrow should appear for the listGrid, and its
     *   location. See SortArrow for details.
     *
     *   Clicking the sort arrow reverses the direction of sorting for the current sort
     *   column (if any), or sorts the listGrid by its first sortable column. The arrow
     *   image on the button indicates the current direction of sorting.
     *   If undefined, the sort arrow will show up in the sorted field, and the
     *   corner sort button will be displayed if a vertical scrollbar is being displayed
     *  @type {SortArrow}
     *  @default null
     */
    open var showSortArrow:
            /**
             *  Don't show a sort arrow at all.
             *  Display sort arrow in the upper-right corner (above the scrollbar) only.
             *  Display sort arrow above each field header only.
             *  Display sort arrow above each field header AND in corner above scrollbar.BOTH:"both", // NOTE: Canvas establishes this constant
             */
            String? /* none |  corner |  field |  both */ = null
    /**
     *  When ListGrid.leaveHeaderMenuButtonSpace is true, configures the amount of space beyond the
     *   ListGrid.headerMenuButtonWidth on the right side of a ListGrid header button (left for
     *   Page.isRTL) to reserve for the sort arrow if sorting is active for
     *   that field and the arrow will be shown. May be increased for more separation between
     *   the sort arrow and the title text, at the expense of a reduced space for the title text.
     *
     *   This value may need to be customized in your skin or if ListGrid.sortAscendingImage or
     *   ListGrid.sortDescendingImage are changed.
     *  @type {Integer}
     *  @default "7"
     */
    open var sortArrowMenuButtonSpaceOffset: Number = 7
    /**
     *  When ListGrid.leaveHeaderMenuButtonSpace is true, configures the amount of space beyond the
     *   ListGrid.headerMenuButtonWidth on the right side of a ListGrid header button (left for
     *   Page.isRTL) to reserve for the sort numeral if
     *   ListGrid.canMultiSort is active for that field and the numeral will be shown.
     *   May be increased for more separation between the title text and the sort arrow when
     *   multi-sorting.
     *
     *   Note that larger values may required if 10 or more fields are sorted at once, as the
     *   numeral will occupy more space. This value may need to be customized in your skin or if
     *   ListGrid.sortAscendingImage or ListGrid.sortDescendingImage are changed.
     *  @type {Integer}
     *  @default "9"
     */
    open var sortNumeralMenuButtonSpaceOffset: Number = 9
    /**
     *  Indicates whether the field picker item and submenu should be present in the header
     *   context menu. This menu allows the user to hide visible fields and show hidden fields.
     *
     *   By default only fields explicitly included in the ListGrid.fields array will
     *   be available in this menu, unless ListGrid.canPickOmittedFields is set to true for
     *   a databound grid.
     *
     *   A specific field can be omitted from the column picker via ListGridField.canHide.
     *  @type {boolean}
     *  @default true
     */
    open var canPickFields: Boolean = true
    /**
     *  If this grid has a specified ListGrid.dataSource, and
     *   ListGrid.useAllDataSourceFields is false, setting this property to true
     *   will cause all dataSource fields not included in the specified set of fields to
     *   show up in the ListGrid.canPickFields.
     *
     *   Has no effect if ListGrid.fields is unset (as in this case all dataSource fields
     *   will be displayed by default), or if ListGrid.canPickFields is false.
     *  @type {boolean}
     *  @default false
     */
    open var canPickOmittedFields: Boolean = false
    /**
     *  Whether an interface should be shown to allow user is allowed to dynamically "freeze" or
     *   "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults
     *   to true unless:
     *
     *  - ListGrid.fixedRecordHeights is false
     *
     *  - ListGrid.bodyOverflow is "visible"
     *
     *  - ListGrid.autoFitData is set to "horizontal" or
     *   "both"
     *
     *  - Any field has overflow set to "visible"
     *
     *   Note that the canFreezeFields setting enables or disables the user
     *   interface for freezing and unfreezing fields only. Fields can be programmatically
     *   frozen via setting ListGridField.frozen to true when the grid is
     *   created, or dynamically frozen and unfrozen via ListGrid.freezeField and
     *   ListGrid.unfreezeField.
     *  @type {boolean}
     *  @default null
     */
    open var canFreezeFields: Boolean? = null
    /**
     *  If the result of a formula evaluation is invalid (specifically, if isNaN(result)==true),
     *   badFormulaResultValue is displayed instead. The default value is ".".
     *  @type {string}
     *  @default "."
     */
    override var badFormulaResultValue: String = "."
    /**
     *  If a summary format string contains an invalid field reference, replace the reference
     *   with the missingSummaryFieldValue. The default value is "-".
     *  @type {string}
     *  @default "-"
     */
    override var missingSummaryFieldValue: String = "-"
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   field based on values present in other fields, using the FormulaBuilder.
     *
     *   User-added formula fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddFormulaFields: Boolean = false
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   text field that can contain both user-defined text and the formatted values present in other
     *   fields, using the SummaryBuilder.
     *
     *   User-added summary fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddSummaryFields: Boolean = false
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define
     *   grid hilites using the HiliteEditor.
     *
     *   User-added hilites can be persisted via DataBoundComponent.getHiliteState and
     *   DataBoundComponent.setHiliteState.
     *  @type {boolean}
     *  @default false
     */
    override var canEditHilites: Boolean = false
    /**
     *  Whether to show a context menu with standard items for all context clicks on rows in the
     *   body.
     *  @type {boolean}
     *  @default false
     */
    open var showCellContextMenus: Boolean = false
    /**
     *  Whether to show a context menu on the header with standard items for showing and hiding
     *   fields. Not supported for CubeGrid.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderContextMenu: Boolean = true
    /**
     *  If set to true and ListGrid.showHeaderContextMenu is true, the
     *   ListGrid.headerMenuButton will be displayed when the user rolls
     *   over the header buttons in this grid. Not supported for CubeGrid.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderMenuButton: Boolean = true
    /**
     *  If ListGrid.showHeaderMenuButton is true, when auto-fitting fields to
     *   the title width via ListGrid.autoFitFieldWidths or ListGridField.autoFitWidth,
     *   should the button be sized such that there is enough space for the header menu button to
     *   show without covering the field title?
     *
     *   May be explicitly specified at the ListGridField.leaveHeaderMenuButtonSpace
     *   or at the ListGrid.leaveHeaderMenuButtonSpace. If not explicitly
     *   specified space will be left for fields with
     *   ListGridField.align set to "left" or "right", but not for
     *   fields with align set to "center".
     *  @type {boolean}
     *  @default null
     */
    open var leaveHeaderMenuButtonSpace: Boolean? = null
    /**
     *  Constructor for the ListGrid.headerMenuButton. If unset a standard "Button" will
     *   be rendered out. Note that this property may be overridden by different skins.
     *  @type {string}
     *  @default null
     */
    open var headerMenuButtonConstructor: String? = null
    /**
     *  If ListGrid.showHeaderMenuButton is true, when the user rolls over the header buttons in this
     *   grid the headerMenuButton will be shown over the header button in question. When clicked
     *   this button will display the standard header context menu (see
     *   ListGrid.displayHeaderContextMenu).
     *
     *   headerMenuButton exist to customize the appearance of the
     *   headerMenuButton. Also see the AutoChild documentation for information on how
     *   to make free-form modifications to autoChild widgets
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var headerMenuButton: StatefulCanvas? = null
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the icon shown on the
     *   auto-generated headerMenuButton
     *  @type {URL}
     *  @default "[SKIN]/ListGrid/headerMenuButton_icon.gif"
     */
    open var headerMenuButtonIcon: String = "[SKIN]/ListGrid/headerMenuButton_icon.gif"
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the width of the icon
     *   shown on the auto-generated headerMenuButton
     *  @type {number}
     *  @default "7"
     */
    open var headerMenuButtonIconWidth: Number = 7
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the height of the icon
     *   shown on the auto-generated headerMenuButton
     *  @type {number}
     *  @default "7"
     */
    open var headerMenuButtonIconHeight: Number = 7
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the width of the
     *   auto-generated headerMenuButton
     *  @type {number}
     *  @default "16"
     */
    open var headerMenuButtonWidth: Number = 16
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the height of the
     *   auto-generated headerMenuButton
     *  @type {any}
     *  @default "100%"
     */
    open var headerMenuButtonHeight: dynamic = "100%"
    /**
     *  Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     *
     *   NOTE: If canDragRecordsOut is initially enabled or might be
     *   dynamically enabled after the grid is created, it may be desirable to disable
     *   Canvas.useTouchScrolling so that touch-dragging a record starts
     *   a drag operation rather than a scroll. If Canvas.disableTouchScrollingForDrag
     *   is set to true, then touch scrolling will be disabled automatically. However,
     *   for accessibility reasons, it is recommended to leave touch
     *   scrolling enabled and provide an alternative set of controls that can be used to perform
     *   drag and drop of records out of the grid.
     *  @type {boolean}
     *  @default false
     */
    open var canDragRecordsOut: Boolean = false
    /**
     *  Indicates whether records can be dropped into this listGrid.
     *  @type {boolean}
     *  @default false
     */
    open var canAcceptDroppedRecords: Boolean = false
    /**
     *  Indicates whether records can be reordered by dragging within this ListGrid.
     *
     *   NOTE: If canReorderRecords is initially enabled or might be
     *   ListGrid.setCanReorderRecords after the grid is created,
     *   it may be desirable to disable Canvas.useTouchScrolling
     *   so that touch-dragging a record starts a reorder operation rather than a scroll. If
     *   Canvas.disableTouchScrollingForDrag is set to true, then touch
     *   scrolling will be disabled automatically. However, for accessibility
     *   reasons, it is recommended to leave touch scrolling enabled and provide an alternative
     *   set of controls that can be used to perform drag-reordering of records.
     *  @type {boolean}
     *  @default false
     */
    open var canReorderRecords: Boolean = false
    /**
     *  Indicates whether fields in this listGrid can be reordered by dragging and
     *   dropping header fields.
     *  @type {boolean}
     *  @default true
     */
    open var canReorderFields: Boolean = true
    /**
     *  Indicates whether fields in this listGrid can be resized by dragging header
     *   fields.
     *  @type {boolean}
     *  @default true
     */
    open var canResizeFields: Boolean = true
    /**
     *  When records are being dragged from within a ListGrid, what sort of drag-tracker
     *   should be displayed?
     *   Note that if multiple records are being dragged the displayed tracker will be
     *   based on the first selected record.
     *  @type {DragTrackerMode}
     *  @default "icon"
     */
    open var dragTrackerMode:
            /**
             *  Don't display a drag tracker at all
             *  Display an icon to represent the record(s) being dragged. Icon src is       derived from ListGrid.getDragTrackerIcon
             *  Display a title for the record being dragged. Title derived from       ListGrid.getDragTrackerTitle
             *  Display the entire record being dragged
             */
            String /* none |  icon |  title |  record */ = "icon"
    /**
     *  If true, the grid contents are redrawn in real time as fields are resized.
     *   This can be slow with a large grid and/or on some platforms. By default, this is enabled
     *   in modern desktop browsers. This is automatically switched off in mobile browsers.
     *  @type {boolean}
     *  @default "see below"
     */
//    open var resizeFieldsInRealTime: Boolean = "see below"
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
     *  @type {DragDataAction}
     *  @default "move"
     */
    override var dragDataAction:
            /**
             *  Don't do anything, resulting in the same data being in both lists.
             *  Copy the data leaving the original in our list.
             *  Remove the data from this list so it can be moved into the other list.
             */
            String /* none |  copy |  move */ = "move"
    /**
     *  Where do 'skin' images (those provided with the class) live?
     *  @type {SCImgURL}
     *  @default "images/ListGrid/"
     */
    override var skinImgDir: String = "images/ListGrid/"
    /**
     *  Image to show when sorting ascending. See ImgProperties for format.
     *  @type {ImgProperties}
     *  @default "{...}"
     */
    // open var sortAscendingImage: ImgProperties = definedExternally
    /**
     *  Image to show when sorting descending. See ImgProperties for format.
     *  @type {ImgProperties}
     *  @default "{...}"
     */
    // open var sortDescendingImage: ImgProperties = definedExternally
    /**
     *  Default image to use for the dragTracker when things are dragged within or out of this
     *   list. See ImgProperties for format.
     *  @type {ImgProperties}
     *  @default "{...}"
     */
    // open var trackerImage: ImgProperties = definedExternally
    /**
     *  An optional CSS style to apply to the checkbox image. If supplied, and the checkbox is
     *   enabled, the base style is suffixed with "True", "False", or "Partial" if the checkbox
     *   is selected, unselected, or partially selected; if the checkbox is disabled, the suffix
     *   is "TrueDisabled", "FalseDisabled", or "PartialDisabled".
     *
     *   NOTE: This attribute is not supported by TreeGrid.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var booleanBaseStyle: String? = null
    /**
     *  If set, the ListGrid.booleanBaseStyle to use when printing.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printBooleanBaseStyle: String? = null
    /**
     *  Image to display for a true value in a boolean field. The special value "blank" means
     *   that no image will be shown.
     *
     *   To turn this off explicitly set ListGridField.suppressValueIcon to true.
     *
     *   If this, ListGrid.booleanFalseImage and ListGrid.booleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.checkedImage.
     *
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   ListGrid.booleanBaseStyle property to provide a "boolean true" appearance.
     *  @type {SCImgURL}
     *  @default null
     */
    open var booleanTrueImage: String? = null
    /**
     *  Image to display for a false value in a boolean field. Default null value
     *   or the special value "blank" means no image will be displayed.
     *
     *   To turn this off explicitly set ListGridField.suppressValueIcon to true
     *
     *   If this, ListGrid.booleanTrueImage and ListGrid.booleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.uncheckedImage.
     *
     *
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   ListGrid.booleanBaseStyle property to provide a "boolean false" appearance.
     *  @type {SCImgURL}
     *  @default null
     */
    open var booleanFalseImage: String? = null
    /**
     *  Image to display for a partially true value in a boolean field (typically selection).
     *   The special value "blank" means that no image will be shown.
     *
     *   To turn this off explicitly set ListGridField.suppressValueIcon to true.
     *
     *   If this, ListGrid.booleanTrueImage and ListGrid.booleanFalseImage
     *   are unset, this will be set to the default CheckboxItem.partialSelectedImage.
     *
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   ListGrid.booleanBaseStyle property to provide a "boolean true" appearance.
     *  @type {SCImgURL}
     *  @default null
     */
    open var booleanPartialImage: String? = null
    /**
     *  If set, the ListGrid.booleanTrueImage to use when printing.
     *
     *   If this, ListGrid.printBooleanFalseImage and ListGrid.printBooleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.printCheckedImage.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printBooleanTrueImage: String? = null
    /**
     *  If set, the ListGrid.booleanFalseImage to use when printing.
     *
     *   If this, ListGrid.printBooleanTrueImage and ListGrid.printBooleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.printUncheckedImage.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printBooleanFalseImage: String? = null
    /**
     *  If set, the ListGrid.booleanPartialImage to use when printing.
     *
     *   If this, ListGrid.printBooleanTrueImage and ListGrid.printBooleanFalseImage
     *   are unset, this will be set to the default CheckboxItem.printPartialSelectedImage.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printBooleanPartialImage: String? = null
    /**
     *  Width for the ListGrid.booleanTrueImage, ListGrid.booleanFalseImage
     *   and ListGrid.booleanPartialImage.
     *   Note: If ListGrid.booleanTrueImage is unset, the CheckboxItem.checkedImage
     *   will be used to indicate a true value in a boolean field. In this case this property is
     *   ignored in favor of CheckboxItem.valueIconWidth.
     *  @type {number}
     *  @default "16"
     */
    open var booleanImageWidth: Number = 16
    /**
     *  Height for the ListGrid.booleanTrueImage, ListGrid.booleanFalseImage
     *   and ListGrid.booleanPartialImage.
     *   Note: If ListGrid.booleanTrueImage is unset, the CheckboxItem.checkedImage
     *   will be used to indicate a true value in a boolean field. In this case this property is
     *   ignored in favor of CheckboxItem.valueIconHeight.
     *  @type {number}
     *  @default "16"
     */
    open var booleanImageHeight: Number = 16
    /**
     *  When set to true, shows the ListGrid.dragHandleField on initial draw.
     *  @type {boolean}
     *  @default null
     */
    open var showInitialDragHandles: Boolean? = null
    /**
     *  The title to use for the ListGrid.dragHandleField.
     *
     *   By default this title is not displayed in the drag column header button as the
     *   autochild defaults for the field set ListGridField.showTitle to
     *   false.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var dragHandleFieldTitle: String = "&amp;nbsp;"
    /**
     *  Default icon to show in the ListGrid.dragHandleField..
     *  @type {SCImgURL}
     *  @default "[SKIN]/actions/drag.png"
     */
    open var dragHandleIcon: String = "[SKIN]/actions/drag.png"
    /**
     *  Default width and height of ListGrid.dragHandleIcon for this ListGrid.
     *  @type {number}
     *  @default "16"
     */
    open var dragHandleIconSize: Number = 16
    /**
     *  An automatically generated field that can be dragged to drag the current selection
     *   (where otherwise the grid itself might be scrolled). Visibility is controlled by
     *   ListGrid.showInitialDragHandles, ListGrid.showDragHandles, and ListGrid.hideDragHandles.
     *  @type {ListGridField}
     *  @default null
     */
    open var dragHandleField: ListGridField? = null
    /**
     *  When set to true, shows an additional field at the beginning of the field-list
     *   (respecting RTL) that displays the current rowNum for each record.
     *  @type {boolean}
     *  @default null
     */
    open var showRowNumbers: Boolean? = null
    /**
     *  The CSS Style name for the ListGrid.rowNumberField.
     *  @type {CSSStyleName}
     *  @default "specialCol"
     */
    open var rowNumberStyle: String = "specialCol"
    /**
     *  If ListGrid.showRowNumbers is true, should we apply the ListGrid.rowNumberStyle to
     *   the ListGrid.rowNumberField
     *  @type {boolean}
     *  @default true
     */
    open var applyRowNumberStyle: Boolean = true
    /**
     *  The number to start the row-count from - default value is 1.
     *  @type {number}
     *  @default "1"
     */
    open var rowNumberStart: Number = 1
    /**
     *  An automatically generated field that displays the current row number when
     *   ListGrid.showRowNumbers is true.
     *  @type {ListGridField}
     *  @default null
     */
    open var rowNumberField: ListGridField? = null
    /**
     *  Dictates whether the data in this grid should be exported raw by
     *   ListGrid.exportClientData. If set to true,
     *   data will not be processed by field-formatters during exports.
     *   Decreases the time taken for large exports. This property can also be set at the
     *   ListGridField.exportRawValues.
     *  @type {boolean}
     *  @default null
     */
    open var exportRawValues: Boolean? = null
    /**
     *  The method of RecordComponentPoolingMode to employ for
     *   ListGrid.canExpandRecords.
     *
     *   The default mode is "destroy", which means that automatically created expansionComponents
     *   are destroyed when rows are collapsed.
     *  @type {ExpansionComponentPoolingMode}
     *  @default "destroy"
     */
    open var expansionComponentPoolingMode:
            /**
             *  auto-created, built-in components are destroyed when record are    ListGrid.collapseRecord.
             *  all expansion components are deparented from the grid when a record is    ListGrid.collapseRecord but are not destroyed. It is the responsibility
             *      of the developer to handle component destruction
             */
            String /* destroy |  none */ = "destroy"
    /**
     *  When set to true, shows an additional field at the beginning of the field-list
     *   (respecting RTL) to allow users to expand and collapse individual records.
     *   See ListGrid.expandRecord and ListGrid.expansionMode for details
     *   on record expansion.
     *
     *   ListGrid.virtualScrolling is automatically enabled when canExpandRecords is
     *   set to true.
     *
     *   Note that expanded records are not currently supported in conjunction
     *   with ListGridField.frozen.
     *  @type {boolean}
     *  @default false
     */
    open var canExpandRecords: Boolean = false
    /**
     *  When ListGrid.canExpandRecords is true, this property indicates whether multiple
     *   records can be expanded simultaneously. If set to false, expanding a record will
     *   automatically collapse any record which is already expanded. The default value is
     *   true.
     *  @type {boolean}
     *  @default true
     */
    open var canExpandMultipleRecords: Boolean = true
    /**
     *  When ListGrid.canExpandRecords and ListGrid.canExpandMultipleRecords are
     *   both true, this property dictates the number of
     *   records which can be expanded simultaneously. If the expanded record count hits the
     *   value of this property, further attempts to expand records will result in a popup
     *   warning (see ListGrid.maxExpandedRecordsPrompt) and expansion will be cancelled.
     *
     *   The default value is null, meaning there is no limit on the number of expanded records.
     *  @type {Integer}
     *  @default null
     */
    open var maxExpandedRecords: Number? = null
    /**
     *  This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed. Note that the local variable count will be
     *   available and set to this.maxExpandedRecords. The string will be executed in the scope of the
     *   ListGrid so this may also be used to determine other information about this grid.
     *
     *   Default value returns
     *
     *   This grid is limited to [ListGrid.maxExpandedRecords] simultaneously
     *   expanded records. Please collapse some expanded records and retry.
     *
     *  @type {HTMLString}
     *  @default "This grid is limited to ${count} simultaneously expanded records.  Please collapse some expanded records and retry."
     */
    open var maxExpandedRecordsPrompt: String = "This grid is limited to \${count} simultaneously expanded records.  Please collapse some expanded records and retry."
    /**
     *  The field whose contents to show in the expanded portion of a record when
     *   ListGrid.canExpandRecords is true and
     *   ExpansionMode is detailField.
     *  @type {string}
     *  @default null
     */
    open var detailField: String? = null
    /**
     *  The ExpansionMode for records in this grid.
     *   Default null value means no expansion.
     *  @type {ExpansionMode}
     *  @default null
     */
    open var expansionMode:
            /**
             *  Show a single field's value in an HTMLFlow. Field   to use is ListGrid.detailField.
             *  Show a DetailViewer displaying those fields from the   record which are not already displayed in the grid.
             *  Show a separate ListGrid containing related-records.   See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for
             *     more information.
             *  Show a DynamicForm to edit those fields from the   record which are not already present in the grid. If the record is collapsed with
             *     unsaved changes and ListGrid.expansionEditorShowSaveDialog is not set, Edits
             *     will be saved automatically, or stored as editing if
             *     ListGrid.autoSaveEdits is false. Otherwise, a confirmation dialog is
             *     displayed. Can optionally show a
             *     ListGrid.showExpansionEditorSaveButton and
             *     ListGrid.expansionEditorCollapseOnSave when save is pressed.
             *     If a record fails validation on save and the field in question is not visible in
             *     the grid, the record is automatically expanded and validated to show the errors.
             *  Show a DetailViewer displaying those fields   from the record not already displayed in the grid, together with a separate
             *     ListGrid containing related-records.
             */
            String? /* detailField |  details |  related |  editor |  detailRelated */ = null
    /**
     *  The field providing the facility to expand and collapse rows.
     *  @type {ListGridField}
     *  @default null
     */
    open var expansionField: ListGridField? = null
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   determines the image to display in the expansion field for expanded rows.
     *   If unset, the ListGrid.booleanTrueImage will be used.
     *  @type {SCImgURL}
     *  @default null
     */
    open var expansionFieldTrueImage: String? = null
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   determines the image to display in the expansion field for collapsed rows.
     *   If unset, the ListGrid.booleanFalseImage will be used.
     *  @type {SCImgURL}
     *  @default null
     */
    open var expansionFieldFalseImage: String? = null
    /**
     *  Should a "_selected" suffix be added to the
     *   ListGrid.expansionFieldTrueImage
     *   and ListGrid.expansionFieldFalseImage image URLs for
     *   selected rows?
     *
     *   This allows developers to provide separate expansion field media for selected
     *   rows, in case the selected row style does not contrast well with the standard
     *   expansion field image media.
     *
     *   If both this property and attr:ListGrid.expansionFieldImageShowRTL are true, and
     *   the grid is in RTL mode, both suffixes will be applied to selected rows'
     *   expansion field image (combined as "selected_rtl")
     *  @type {boolean}
     *  @default false
     */
    open var expansionFieldImageShowSelected: Boolean = false
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   may be set to govern the width of the expansion image displayed to indicate whether a row
     *   is expanded. If unset, the expansionField image will be sized to match the
     *   ListGrid.booleanImageWidth for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var expansionFieldImageWidth: Number? = null
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   may be set to govern the height of the expansion image displayed to indicate whether a
     *   row is expanded. If unset, the expansionField image will be sized to match the
     *   ListGrid.booleanImageHeight for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var expansionFieldImageHeight: Number? = null
    /**
     *  Automatically generated HTMLFlow for displaying the contents of
     *   ListGrid.detailField in a record's expanded section when
     *   ExpansionMode is detailField.
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionDetailFieldProperties and
     *   listGrid.expansionDetailFieldDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {HTMLFlow}
     *  @default null
     */
    open var expansionDetailField: HTMLFlow? = null
    /**
     *  Automatically generated DetailViewer for displaying the details of a record
     *   in its expanded section when
     *   ExpansionMode is details. Note that
     *   only those fields
     *   which do not already appear in the grid are displayed in the expanded section.
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionDetailsProperties and
     *   listGrid.expansionDetailsDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {DetailViewer}
     *  @default null
     */
    open var expansionDetails: DetailViewer? = null
    /**
     *  Automatically generated ListGrid for displaying data related to a record
     *   in its expanded section when
     *   ExpansionMode is related.
     *   The DataSource containing the related data is provided by
     *   ListGrid.getRelatedDataSource which, by default,
     *   returns the DataSource referred to in ListGridRecord.detailDS.
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionRelatedProperties and
     *   listGrid.expansionRelatedDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {ListGrid}
     *  @default null
     */
    open var expansionRelated: ListGrid? = null
    /**
     *  Automatically generated DynamicForm for editing the details of a record
     *   in its expanded section when
     *   ExpansionMode is editor. Note that only
     *   those fields which do not already appear in the grid will appear in the expanded section.
     *
     *   According to the value of ListGrid.showExpansionEditorSaveButton, a save button is shown
     *   beneath the editor. You can save the values in the editor by clicking this button
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionEditorProperties and
     *   listGrid.expansionEditorDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {DynamicForm}
     *  @default null
     */
    open var expansionEditor: DynamicForm? = null
    /**
     *  When ListGrid.canExpandRecords is true and
     *   ListGrid.expansionMode is editor, whether a dialog should be
     *   displayed when an expanded row is collapsed while it's nested editor has changed values.
     *  @type {boolean}
     *  @default null
     */
    open var expansionEditorShowSaveDialog: Boolean? = null
    /**
     *  When ListGrid.canExpandRecords is true and
     *   ListGrid.expansionMode is editor, the prompt to display
     *   in a dialog when an expanded row is collapsed while it's nested editor has changed values.
     *  @type {string}
     *  @default "You have unsaved changes - do you want to save them now?"
     */
    open var expansionEditorSaveDialogPrompt: String = "You have unsaved changes - do you want to save them now?"
    /**
     *  When ExpansionMode is editor, should the row be collapsed following a
     *   save initiated by the expansion-component's ListGrid.expansionEditorSaveButton.
     *  @type {boolean}
     *  @default true
     */
    open var expansionEditorCollapseOnSave: Boolean = true
    /**
     *  When ExpansionMode is editor, should a Save button be shown below the
     *   the expanded editor?
     *
     *   Note that if an expanded-row containing an editor is collapsed while changes are
     *   outstanding, changes will be either be automatically updated to the grid, or will first
     *   show a confirmation dialog, according to the value of
     *   ListGrid.expansionEditorShowSaveDialog.
     *  @type {boolean}
     *  @default true
     */
    open var showExpansionEditorSaveButton: Boolean = true
    /**
     *  Automatically generated IButton for saving the values in the expanded
     *   portion of a ListGrid row.
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionEditorSaveButtonProperties and
     *   listGrid.expansionEditorSaveButtonDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {IButton}
     *  @default null
     */
    open var expansionEditorSaveButton: IButton? = null
    /**
     *  The title for the ListGrid.expansionEditorSaveButton.
     *  @type {string}
     *  @default "Save"
     */
    open var expansionEditorSaveButtonTitle: String = "Save"
    /**
     *  Automatically generated HLayout appearing in a record's expanded section
     *   when ExpansionMode is detailRelated.
     *   This component contains two other autoChild components,
     *   a DetailViewer for viewing fields from the record which are not already
     *   present in the grid and a separate embedded ListGrid for displaying other
     *   data related to this record via record.detailDS. See ListGrid.expansionDetails
     *   and ListGrid.expansionRelated for more information.
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionDetailRelatedProperties and
     *   listGrid.expansionDetailRelatedDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {HLayout}
     *  @default null
     */
    open var expansionDetailRelated: HLayout? = null
    /**
     *  Automatically generated VLayout which fills a record's expanded section
     *   and contains other builtin ExpansionMode. You can also
     *   override ListGrid.getExpansionComponent to provide
     *   components of your own specification.
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionLayoutProperties and
     *   listGrid.expansionLayoutDefaults.
     *
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {VLayout}
     *  @default null
     */
    open var expansionLayout: VLayout? = null
    /**
     *  If ListGrid.canExpandRecords is true and ExpansionMode
     *   is "related", this property specifies the dataSource for the
     *   related records grid to be shown embedded in expanded records.
     *
     *   This property may also be specified on a per-record basis - see
     *   ListGrid.recordDetailDSProperty
     *  @type {string}
     *  @default null
     */
    open var detailDS: String? = null
    /**
     *  The name of the ListGridRecord property that specifies the DataSource to use when
     *   ExpansionMode is "related". The default is
     *   ListGridRecord.detailDS. Note that you can set the ListGrid.detailDS at the
     *   grid level instead if the same dataSource is to be used for all records.
     *  @type {string}
     *  @default "detailDS"
     */
    open var recordDetailDSProperty: String = "detailDS"
    /**
     *  For ExpansionMode that show another grid or tree, what the
     *   child's expansionMode should be.
     *   Default value null means no further expansion.
     *  @type {ExpansionMode}
     *  @default null
     */
    open var childExpansionMode:
            /**
             *  Show a single field's value in an HTMLFlow. Field   to use is ListGrid.detailField.
             *  Show a DetailViewer displaying those fields from the   record which are not already displayed in the grid.
             *  Show a separate ListGrid containing related-records.   See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for
             *     more information.
             *  Show a DynamicForm to edit those fields from the   record which are not already present in the grid. If the record is collapsed with
             *     unsaved changes and ListGrid.expansionEditorShowSaveDialog is not set, Edits
             *     will be saved automatically, or stored as editing if
             *     ListGrid.autoSaveEdits is false. Otherwise, a confirmation dialog is
             *     displayed. Can optionally show a
             *     ListGrid.showExpansionEditorSaveButton and
             *     ListGrid.expansionEditorCollapseOnSave when save is pressed.
             *     If a record fails validation on save and the field in question is not visible in
             *     the grid, the record is automatically expanded and validated to show the errors.
             *  Show a DetailViewer displaying those fields   from the record not already displayed in the grid, together with a separate
             *     ListGrid containing related-records.
             */
            String? /* detailField |  details |  related |  editor |  detailRelated */ = null
    /**
     *  For ExpansionMode that show another grid or tree, is that
     *   component editable?
     *   The default value for this property is false.
     *  @type {boolean}
     *  @default null
     */
    open var expansionCanEdit: Boolean? = null
    /**
     *  Causes filtering to be performed against the local data set, even when a
     *   ListGrid.dataSource is provided.
     *
     *   When using this mode, data must be provided to the grid via ListGrid.setData,
     *   and must be provided as
     *   a simple Array of Records
     *   .
     *
     *   Note that a ListGrid.dataSource must be provided for filtering to occur
     *   even when filtering locally.
     *
     *   If this property is set to true, the supplied data is applied as the
     *   ResultSet.allRows of a ResultSet, which is then
     *   filtered according to the specified criteria, and the results displayed. If false, a
     *   normal databound fetch will occur, retrieving records that match the specified criteria
     *   from this component's ListGrid.dataSource.
     *
     *   filterLocalData includes both calls to ListGrid.fetchData and
     *   ListGrid.filterData as well as automatic filtering when the
     *   ListGrid.filterEditor is enabled.
     *
     *   If this property is not explicitly set, default behavior will filter against the
     *   dataSource unless the grid has a specified DataPath, in which case
     *   filtering will occur locally.
     *
     *   See also ListGrid.saveLocally to cause saves to ignore the DataSource and affect
     *   the local data set only.
     *  @type {boolean}
     *  @default null
     */
    open var filterLocalData: Boolean? = null
    /**
     *  If ListGrid.canAcceptDroppedRecords is true for this listGrid, this property governs
     *   whether the user can drop between, or over records within the grid.
     *   This controls what RecordDropPosition is passed to the ListGrid.recordDrop
     *   event handler.
     *  @type {RecordDropAppearance}
     *  @default "between"
     */
    open var recordDropAppearance:
            /**
             *  When the user drops onto a record, dropPosition will always be "over"
             *  When the user drops onto a record, dropPosition will be either  "before" or "after" depending on whether the mouse was over the top or bottom of
             *    the target record
             *  When the user drops onto a record, if the drop occurs centered over the  record, the dropPosition will be reported as "over", otherwise it will be
             *    "before" or "after" depending on whether the mouse was over the top or bottom of the
             *    target record.
             *  No dropPosition will be reported
             */
            String /* over |  between |  both |  body */ = "between"
    /**
     *  If a user is editing a ListGrid.canEdit listGrid, and they hide
     *   a field while the editor is showing, should we discard any edits in the edit row for
     *   the field being hidden?
     *
     *   Default behavior is to discard the edits - set this flag to false to preserve edits
     *  @type {boolean}
     *  @default true
     */
    open var discardEditsOnHideField: Boolean = true
    /**
     *  Initial ListGridFieldState for the grid.
     *
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, fieldState is not needed because viewState
     *   includes it as well. If both are provided, fieldState has priority for
     *   field state.
     *
     *
     *   To retrieve current state call ListGrid.getFieldState.
     *
     *  @type {ListGridFieldState}
     *  @default null
     */
    open var fieldState: String? = null
    /**
     *  How much horizontal space should the ListGrid.getCheckboxField leave
     *   around the checkbox icon when ListGrid.selectionAppearance is set to
     *   "checkbox"?
     *
     *   The automatically generated checkbox field will be sized to the width of the
     *   checkbox icon (specified via ListGrid.checkboxFieldImageWidth or
     *   ListGrid.booleanImageWidth) plus this value.
     *  @type {Integer}
     *  @default "15"
     */
    open var checkboxFieldHSpace: Number = 15
    /**
     *  Returns a snapshot of the current selection within this listGrid as
     *   a ListGridSelectedState object.
     *   This object can be passed to ListGrid.setSelectedState to reset this grid's selection
     *   the current state (assuming the same data is present in the grid).
     *  @type {ListGridSelectedState}
     *  @default null
     */
    open var selectedState: String? = null
    /**
     *  Initial sort state for the grid.
     *
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, sortState is not needed because viewState
     *   includes it as well. If both are provided, sortState has priority for
     *   sort state.
     *
     *
     *   To retrieve current state call ListGrid.getSortState.
     *
     *  @type {ListGridSortState}
     *  @default null
     */
    open var sortState: String? = null
    /**
     *  Initial group state for the grid.
     *
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, groupState is not needed because viewState
     *   includes it as well. If both are provided, groupState has priority for
     *   group state.
     *
     *
     *   To retrieve current state call ListGrid.getGroupState.
     *
     *  @type {ListGridGroupState}
     *  @default null
     */
    open var groupState: String? = null
    /**
     *  Initial ListGridViewState for the grid.
     *
     *   Since view state contains field state it is not necessary
     *   to set ListGrid.fieldState when also setting viewState.
     *   If both are provided, fieldState has priority for field state.
     *
     *
     *   To retrieve current state call ListGrid.getViewState.
     *
     *  @type {ListGridViewState}
     *  @default null
     */
    open var viewState: String? = null
    /**
     *  Array of components that make up this grid. This array controls which standard and/or custom
     *   parts will be displayed within this ListGrid.
     *
     *   ListGrid is a subclass of VLayout and consists of a number of member components. The
     *   standard set of members are automatically generated by the grid, and include (for example)
     *   the header (a Toolbar of buttons for each field) and the body
     *   (a GridRenderer displaying the actual data contained in the grid).
     *   The default value of gridComponents is an Array of ListGridComponents listing
     *   the standard components in their default order:
     *
     *
     *    gridComponents : ["filterEditor", "header",
     *             "body", "summaryRow"]
     *
     *
     *
     *
     *   You can override gridComponents to change the order of standard components.
     *   You can also omit standard components this way, although it more efficient to
     *   use the related "show" property if available (eg ListGrid.showFilterEditor). Note that
     *   this array must contain an entry for the "body" - listGrids with no body showing
     *   are unsupported.
     *   Advanced note: The live components generated for each of these standard
     *   ListGridComponent types may differ across different listGrids. For example if this
     *   grid has any ListGridField.frozen, the "body" entry will actually
     *   be created as an HLayout containing two GridRenderers (one for frozen fields,
     *   and one for unfrozen fields). This is really an implementation detail - the "body" entry
     *   in the gridComponents array simply specifies where the UI for the body should render within
     *   the ListGrid layout.
     *
     *   By embedding a Canvas directly in this list you can add arbitrary additional components to the
     *   listGrid as members, and have them be displayed alongside the standard automatically generated
     *   parts of the ListGrid.
     *
     *   Note that having added controls to gridComponents, you can still call APIs directly on
     *   those controls to change their appearance, and you can also show() and hide() them if
     *   they should not be shown in some circumstances.
     *
     *   Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *  @type {Array<Partial<ListGridComponent>> | Array<Partial<any>>}
     *  @default "(see below)"
     */
    //open var gridComponents: Array<dynamic> = ???
    /**
     *  If this property is set to true, header buttons for either ListGrid.fields or
     *   ListGrid.headerSpans will automatically expand to accommodate their
     *   titles vertically. This means if you have a "tall" title - typically a long string where
     *   ListGridField.wrap is set to true such that you end up with several lines of text -
     *   the button will render large enough to accommodate it. If necessary this will cause the
     *   header for the grid as a whole to expand beyond the specified ListGrid.headerHeight.
     *
     *   Note that you need not set HeaderSpan.height or ListGrid.headerSpanHeight if you set
     *   this property, but if you do, they will be used as minimum values.
     *  @type {boolean}
     *  @default null
     */
    open var autoFitHeaderHeights: Boolean? = null
    /**
     *  When using ListGrid.autoFitFieldWidths, padding in pixels left on each side of fields that
     *   show images.
     *  @type {Integer}
     *  @default "2"
     */
    open var iconPadding: Number = 2
    /**
     *  If ListGridField.userFormula is set for some field, and this grid is showing
     *   ListGrid.showGroupSummary or a
     *   ListGrid.showGridSummary, this property determines what field value
     *   should be present in those summary rows. Should the field apply the user-formula to the
     *   calculated summary row, or should it apply a standard grid or group summary to the
     *   user-formula values displayed in the grid?
     *
     *   May be overridden at the field level via ListGridField.applyAfterSummary
     *  @type {boolean}
     *  @default false
     */
    open var applyFormulaAfterSummary: Boolean = false
    /**
     *  Should cells in this grid be allowed to span multiple rows?
     *   If set to true, the ListGrid.getRowSpan method will be
     *   called for every cell when rendering out the listGrid to determine how many
     *   rows the cell should span.
     *
     *   See ListGrid.getRowSpan for more details
     *  @type {boolean}
     *  @default false
     */
    open var allowRowSpanning: Boolean = false
    /**
     *  Enables various styling behaviors that potentially make sense when ListGrid.getRowSpan has
     *   been overridden to introduce spanning cells, and spanning is largest on the left and
     *   smaller as cells go to the right. Specifically:
     *
     *
     *  - computes ListGrid.alternateRecordStyles based on the span of the
     *     cell in the left-most column
     *
     *  - enables ListGrid.canSelectCells, including
     *     ListGrid.useCellRollOvers styling
     *
     *  - enables row-span-sensitive cell selection. See also RowSpanSelectionMode
     *     for available behaviors
     *
     *
     *   Because this setting enables ListGrid.canSelectCells, it is incompatible with any APIs
     *   that expect a record-oriented data model.
     *
     *   Because this setting only makes sense when row spanning decreases from the first column
     *   to the last, it has unspecified behavior with ListGrid.canReorderFields.
     *  @type {boolean}
     *  @default null
     */
    open var useRowSpanStyling: Boolean? = null
    /**
     *  Chooses the selection mode when ListGrid.useRowSpanStyling is enabled. See
     *   RowSpanSelectionMode.
     *  @type {RowSpanSelectionMode}
     *  @default "forward"
     */
    open var rowSpanSelectionMode:
            /**
             *  when a cell is clicked on, select any cells in subsequent columns which         are at least partially spanned by the clicked cell
             *  when a cell is clicked on, selects any cells in any other columns which         are at least partially spanned by the clicked cell
             *  behaves like "forward", except as though the cell in the first column          was clicked instead. If the largest row spans are in the first
             *            column and all cells in subsequent columns do not extend out of the
             *            first cell's span, this creates a row-like selection model where the
             *            span of the left-most cell defines the "row" of cells being selected.
             */
            String /* forward |  both |  outerSpan */ = "forward"
    /**
     *  If ListGrid.allowRowSpanning is enabled, this property may be used to specify
     *   editing behavior for cells that span multiple rows.
     *  @type {RowSpanEditMode}
     *  @default "first"
     */
    open var rowSpanEditMode:
            /**
             *  This setting assumes that only the field-value for the first record spanned by this cell is significant. In this case the editor will only show for this
             *   cell if the user is editing the first spanned record. If the user initialized the edit
             *   on another spanned row, the editor will not show for this field.
             *  This setting assumes that each row's values are logically separate, so if a cell spans multiple rows, and a user initializes an edit on some cell in the
             *   second spanned row, the spanning cell will show an editor containing the value for
             *   the second spanned row. This may differ from the value displayed when not
             *   in edit mode (which is derived from the first spanned row by default). This setting may
             *   be useful for developers who which to implement their own logic on how to handle
             *   spanning cell display values and/or edit values (for example by using custom
             *   ListGridField.formatCellValue and applying custom logic to handle
             *   editing on ListGridField.editorEnter and ListGridField.editorExit).
             */
            String /* first |  each */ = "first"
    /**
     *  If ListGrid.showRecordComponents is true, this attribute may be used to
     *   specify a standard height for record components.
     *   If specified every row in the grid will be sized tall enough to accommodate a recordComponent
     *   of this size.
     *
     *   Note that if this property is unset, the grid will not be able to know row heights in
     *   advance, and ListGridField.frozen are not currently supported in
     *   this case. If you are putting a recordComponent in every row, and they all have a consistent
     *   height, set recordComponentHeight and you will then be able to use frozen fields
     *   and avoid the whitespace side-effect of virtual scrolling by setting
     *   ListGrid.virtualScrolling:false.
     *
     *   Similarly, if your recordComponents are never tall enough that they will expand the row
     *   beyond the ListGrid.cellHeight, set ListGrid.virtualScrolling:false to avoid the whitespace
     *   side-effect of ListGrid.virtualScrolling and to allow
     *   ListGridField.frozen to be used. In this mode, you can have
     *   recordComponents on some rows but not others, and recordComponents of different heights, so
     *   long as no recordComponent ever causes a row to grow beyond ListGrid.cellHeight (which would
     *   happen if the recordComponents height + 2\*ListGrid.cellPadding is larger than
     *   ListGrid.cellHeight).
     *  @type {Integer}
     *  @default null
     */
    open var recordComponentHeight: Number? = null
    /**
     *  Whether cell contents should wrap during printing. Equivalent to Autofit, but
     *   specific to printed output.
     *  @type {boolean}
     *  @default true
     */
    open var printAutoFit: Boolean = true
    /**
     *  Whether cell contents should wrap during printing. Equivalent to ListGrid.wrapCells, but
     *   specific to printed output.
     *  @type {boolean}
     *  @default true
     */
    open var printWrapCells: Boolean = true
    /**
     *  Style for header cells in printed output. Defaults to ListGrid.headerBaseStyle if null.
     *  @type {CSSStyleName}
     *  @default "printHeader"
     */
    open var printHeaderStyle: String = "printHeader"
    /**
     *  Style for non-header cells in printed output. Defaults to ListGrid.baseStyle if null.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printBaseStyle: String? = null
    /**
     *  Advanced property - when generating printHTML for a large ListGrid, rows are printed in
     *   batches in order to avoid triggering a native "script is running slowly" browser dialog.
     *
     *   For grids with exceptional numbers of columns or complex formatting logic, this number
     *   might need to be adjusted downward.
     *  @type {Integer}
     *  @default "100"
     */
    open var printMaxRows: Number = 100
    /**
     *  When set to true and canHover is also true, shows a widget hovering at the mouse point.
     *
     *   A number of builtin modes are provided - see HoverMode.
     *
     *   Also supported at the ListGridField.showHoverComponents.
     *  @type {boolean}
     *  @default false
     */
    override var showHoverComponents: Boolean = false
    /**
     *  When ListGrid.showHoverComponents is true, the builtin mode
     *   to use when automatically creating a hover component for rows in this grid.
     *
     *   A number of builtin modes are provided - see HoverMode. You can also override
     *   ListGrid.getCellHoverComponent to provide a custom hover
     *   widget - in that case, this attribute is ignored.
     *  @type {HoverMode}
     *  @default null
     */
    open var hoverMode:
            /**
             *  Show a single field's value in an HTMLFlow. Field   to use is ListGrid.detailField.
             *  Show a DetailViewer displaying those fields from the   record which are not already displayed in the grid.
             *  Show a separate ListGrid containing related-records.   See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for
             *     more information.
             *  Show a DetailViewer displaying those fields   from the record not already displayed in the grid, together with a separate
             *     ListGrid containing related-records.
             */
            String? /* detailField |  details |  related |  detailRelated */ = null
    /**
     *  When set to false, clicking a record's ListGrid.expansionField will
     *   not add the record to the current selection.
     *  @type {boolean}
     *  @default true
     */
    open var selectOnExpandRecord: Boolean = true
    /**
     *  If this property is set to true, clicking on a cell will natively select the
     *   cell's content, ready to be copied to the browser clipboard.
     *
     *   For control of this behavior at the field level,
     *   ListGridField.selectCellTextOnClick may be used. These properties interact
     *   as follows:
     *
     *   listGrid.selectCellTextOnClick value
     *   listGridField.selectCellTextOnClick value
     *   Behavior
     *
     *   true
     *     unset or true
     *       Cell contents will be natively selected on click.
     *
     *     false
     *       Cell contents will not be natively selected on click.
     *
     *
     *   unset
     *     true
     *       Cell contents will be natively selected on click.
     *
     *     unset or false
     *       Cell contents will not be natively selected on click.
     *
     *   false
     *     true, false or unset
     *       Cell contents will not be natively selected on click.
     *
     *
     *   This is related to the ListGrid.canDragSelectText attribute which enables
     *   native text selection of grid content by standard browser interactions (drag
     *   selecting or double-click selecting).
     *
     *   Note that developers may also be interested in the related formItem properties
     *   FormItem.selectOnClick and FormItem.selectOnFocus.
     *  @type {boolean}
     *  @default false
     */
    open var selectCellTextOnClick: Boolean = false
    /**
     *  When scrollToCell is called, this is used as defaults if xPosition weren't explicitly passed
     *   into the method.
     *  @type {Alignment}
     *  @default "center"
     */
    open var scrollToCellXPosition:
            /**
             *  Center within container.
             *  Stick to left side of container.
             *  Stick to right side of container.
             */
            String /* center |  left |  right */ = "center"
    /**
     *  When scrollToCell is called, this is used as defaults if yPosition weren't explicitly passed
     *   into the method.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    open var scrollToCellYPosition:
            /**
             *  At the top of the container
             *  Center within container.
             *  At the bottom of the container
             */
            String /* top |  center |  bottom */ = "center"
    /**
     *  If the listGrid is empty, should the user be able to put focus into the grid body by tabbing
     *   to it?
     *
     *   Note that if ListGrid.editOnFocus is true for this grid and ListGrid.listEndEditAction is set to next,
     *   having this property set to true will allow users to automatically create a new edit row by
     *   simply tabbing into the grid.
     *  @type {boolean}
     *  @default true
     */
    open var canFocusInEmptyGrid: Boolean = true
    /**
     *  Should this ListGrid show a summary row beneath the last record of the grid. This summary
     *   row will contain per-field summary information. See ListGridField.showGridSummary and
     *   ListGrid.getGridSummaryFunction for details on how the summary value to be displayed
     *   for each column will be calculated.
     *
     *   Note that the ListGrid.summaryRow will be created to actually
     *   display the summary row.
     *  @type {boolean}
     *  @default false
     */
    open var showGridSummary: Boolean = false
    /**
     *  Value to display to the user if showing summary values (through ListGrid.showGridSummary,
     *   ListGrid.showGroupSummary or ListGridFieldType), and
     *   the summary function returns "null" (implying it was unable to calculate a
     *   valid summary value). This property will only be used in the default formatting behavior. If
     *   an explicit formatter has been specified - via ListGrid.formatCellValue or
     *   ListGridField.formatGridSummary, for example - this property has
     *   no effect.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var invalidSummaryValue: String = "&amp;nbsp;"
    /**
     *  Property name on a record that will be checked to determine whether a record should
     *   be included when calculating totals for the ListGrid.showGridSummary.
     *  @type {string}
     *  @default "includeInSummary"
     */
    open var includeInSummaryProperty: String = "includeInSummary"
    /**
     *  If ListGrid.showGridSummary is true, this attribute will be set to true on the
     *   record object representing the grid summary row.
     *  @type {string}
     *  @default "isGridSummary"
     */
    open var gridSummaryRecordProperty: String = "isGridSummary"
    /**
     *  If ListGrid.showGroupSummary is true, this attribute will be set to true on each
     *   record object representing a group-level summary row.
     *  @type {string}
     *  @default "isGroupSummary"
     */
    open var groupSummaryRecordProperty: String = "isGroupSummary"
    /**
     *  If ListGrid.showGridSummary is true, by default summary values are calculated on the
     *   client based on the current data-set for the grid (see ListGrid.getGridSummary and
     *   ListGrid.getGridSummaryFunction).
     *
     *   In some cases however it may make sense to calculate summary values on the server and retrieve
     *   them via a dataSource fetch. If set, this property specifies a dataSource to fetch against for
     *   the summary row. The dataSource should return a single record with summary data for each
     *   field for which summary data should be shown. Note that specifying this property completely
     *   bypasses the standard client-side grid summary calculation logic.
     *
     *   The fetch may be further customized via ListGrid.summaryRowCriteria and
     *   ListGrid.summaryRowFetchRequestProperties
     *  @type {DataSource}
     *  @default null
     */
    open var summaryRowDataSource: DataSource? = null
    /**
     *  If ListGrid.showGridSummary is true, and a ListGrid.summaryRowDataSource is specified
     *   this property may be used to specify fetch criteria to apply when retrieving summary data
     *   to show in the summary row. If unset, and any filter criteria have been specified for the
     *   grid, they will be used.
     *  @type {Criteria}
     *  @default null
     */
    open var summaryRowCriteria: dynamic = null
    /**
     *  If ListGrid.showGridSummary is true, and a ListGrid.summaryRowDataSource is specified
     *   this property may be used to customize the fetch request used when retrieving summary data
     *   to show in the summary row. An example use case might be specifying a
     *   DSRequest.operationId to perform a custom fetch operation which retrieved only summary
     *   values based on criteria.
     *  @type {DSRequest}
     *  @default null
     */
    open var summaryRowFetchRequestProperties: DSRequest? = null
    /**
     *  If showing any record summary fields (IE: fields of ListGridFieldType),
     *   this attribute specifies a custom base style to apply to cells in the summary field
     *  @type {CSSStyleName}
     *  @default "recordSummaryCell"
     */
    open var recordSummaryBaseStyle: String = "recordSummaryCell"
    /**
     *  Automatically generated ListGrid for displaying grid summary information (see
     *   ListGrid.showGridSummary).
     *
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.summaryRowProperties and listGrid.summaryRowDefaults
     *  @type {ListGrid}
     *  @default null
     */
    open var summaryRow: ListGrid? = null
    /**
     *  Default height for the ListGrid.summaryRow. Note that this
     *   height is a minimum - the summary row has ListGrid.autoFitData set to "vertical" so
     *   if multiple rows are visible in the grid summary, the summaryRow component
     *   will expand to accommodate them.
     *  @type {Integer}
     *  @default "20"
     */
    open var summaryRowHeight: Number = 20
    /**
     *  ListGrid.baseStyle for the ListGrid.summaryRow
     *  @type {CSSStyleName}
     *  @default "gridSummaryCell"
     */
    open var summaryRowStyle: String = "gridSummaryCell"
    /**
     *  If true, causes the ListGrid.summaryRow component to be hidden if it has
     *   no data after summaries have been recalculated
     *  @type {boolean}
     *  @default null
     */
    open var hideEmptySummaryRow: Boolean? = null
    /**
     *  Default OperatorId to use for text-based fields in this grid's
     *   ListGrid.filterEditor, when producing AdvancedCriteria.
     *   When ListGrid.allowFilterExpressions or
     *   ListGrid.allowFilterOperators are enabled for the grid,
     *   the default is DataSource.translatePatternOperators. Otherwise,
     *   the default is "iContains".
     *
     *   Does not apply to special fields where exact match is obviously the right default
     *   setting, such as fields of type:"enum", or fields with a
     *   FormItem.valueMap or FormItem.optionDataSource.
     *  @type {OperatorId}
     *  @default null
     */
    open var defaultFilterOperator:
            /**
             *  exactly equal to
             *  not equal to
             *  exactly equal to, if case is disregarded
             *  not equal to, if case is disregarded
             *  Greater than
             *  Less than
             *  Greater than or equal to
             *  Less than or equal to
             *  Contains as sub-string (match case)
             *  Starts with (match case)
             *  Ends with (match case)
             *  Contains as sub-string (case insensitive)
             *  Starts with (case insensitive)
             *  Ends with (case insensitive)
             *  Does not contain as sub-string (match case)
             *  Does not start with (match case)
             *  Does not end with (match case)
             *  Does not contain as sub-string (case insensitive)
             *  Does not start with (case insensitive)
             *  Does not end with (case insensitive)
             *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
             *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
             *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
             *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
             *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
             *      for more information on available patterns)
             *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
             *      for more information on available patterns)
             *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
             *      for more information on available patterns)
             *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
             *      DataSource.translatePatternOperators for more information on available patterns)
             *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
             *      DataSource.translatePatternOperators for more information on available patterns)
             *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
             *      DataSource.translatePatternOperators for more information on available patterns)
             *  Regular expression match
             *  Regular expression match (case insensitive)
             *  value is either null or the empty string. For numeric fields it behaves as isNull
             *  value is neither null nor the empty string ("")
             *  value is null
             *  value is non-null. Note empty string ("") is non-null
             *  value is in a set of values. Specify criterion.value as an Array
             *  value is not in a set of values. Specify criterion.value as an Array
             *  matches another field (match case, specify fieldName as criterion.value)
             *  does not match another field (match case, specify fieldName as criterion.value)
             *  matches another field (case insensitive, specify fieldName as criterion.value)
             *  does not match another field (case insensitive, specify fieldName as criterion.value)
             *  Greater than another field (specify fieldName as criterion.value)
             *  Less than another field (specify fieldName as criterion.value)
             *  Greater than or equal to another field    (specify fieldName as criterion.value)
             *  Less than or equal to another field    (specify fieldName as criterion.value)
             *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
             *  Starts with (match case) another field value    (specify fieldName as criterion.value)
             *  Ends with (match case) another field value    (specify fieldName as criterion.value)
             *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
             *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
             *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
             *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
             *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
             *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
             *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
             *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
             *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
             *  all subcriteria (criterion.criteria) are true
             *  all subcriteria (criterion.criteria) are false
             *  at least one subcriteria (criterion.criteria) is true
             *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
             *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
             */
            String? /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */ = null
    /**
     *  For use with ListGrid.showFilterEditor:true, allows simple search expressions to be entered
     *   into filter fields, as though DynamicForm.allowExpressions were true.
     *
     *   This attribute can also be set at the ListGridField.allowFilterExpressions.
     *  @type {boolean}
     *  @default null
     */
    open var allowFilterExpressions: Boolean? = null
    /**
     *  If this component is bound to a dataSource, this attribute may be specified to customize
     *   what fields from the dataSource may be edited by default. For example the SearchForm
     *   class has this attribute set to "canFilter" which allows search forms to edit
     *   dataSource fields marked as canEdit:false (but not those marked as
     *   canFilter:false).
     *
     *   Note that if canEdit is explicitly specified on a field in
     *   the DataBoundComponent.fields array, that property will be respected in preference to
     *   the canEditAttribute value. (See FormItem.canEdit, ListGridField.canEdit).
     *   Also note that individual dataBoundComponents may have additional logic around whether a field
     *   can be edited - for example ListGrid.canEditCell may be overridden.
     *  @type {string}
     *  @default "canEdit"
     */
    override var canEditFieldAttribute: String = "canEdit"
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = "gridDragTracker"
    /**
     *  When isc.setScreenReaderMode is enabled,
     *   this invisible separator string is written out between each cell value. This
     *   string will be picked up by screen readers allowing them to more obviously identify
     *   to the user the different cell values as the contents of a row are read aloud. The
     *   ListGrid.screenReaderRowSeparator string if any will
     *   be written out after the last cell in a row to separate the last cell's value from
     *   the screen reader's announcement of the row's number and total number of rows in the grid
     *   (such as "3 of 20").
     *
     *   This attribute may be set to null to disable the feature.
     *
     *   Note that screen readers vary widely on which punctuation symbols are read aloud, and
     *   sometimes it depends on the context of the punctuation. However, the widely-used JAWS, NVDA,
     *   and VoiceOver screen readers all read the forward slash '/' as "slash".
     *   See Why Donâ€™t Screen Readers Always Read Whatâ€™s on the Screen? Part 1: Punctuation and Typographic Symbols
     *   for a table of findings on which punctuation symbols are read aloud by JAWS, NVDA,
     *   and VoiceOver.
     *  @type {HTMLString}
     *  @default "/"
     */
    open var screenReaderCellSeparator: String = "/"
    /**
     *  When isc.setScreenReaderMode is enabled,
     *   this invisible string will be written out after the last cell in a row. This
     *   string will be picked up by screen readers allowing them to more obviously identify
     *   to the user the end of the row's contents and the screen reader's announcement of the row's
     *   number and total number of rows in the grid (such as "3 of 20").
     *
     *   This attribute may be set to null to disable writing out an invisible string at the
     *   end of each row.
     *
     *   Note that screen readers vary widely on which punctuation symbols are read aloud, and
     *   sometimes it depends on the context of the punctuation. However, the widely-used JAWS, NVDA,
     *   and VoiceOver screen readers all pause briefly for a comma ',' that is within text.
     *   See Why Donâ€™t Screen Readers Always Read Whatâ€™s on the Screen? Part 1: Punctuation and Typographic Symbols
     *   for a table of findings on which punctuation symbols are read aloud by JAWS, NVDA,
     *   and VoiceOver.
     *  @type {HTMLString}
     *  @default ","
     */
    open var screenReaderRowSeparator: String = ","
    /**
     *  If this grid has specified ListGrid.headerSpans, should field titles be
     *   prefixed with the titles of the headerSpans in which they are contained when
     *   using the FormulaBuilder or SummaryBuilder.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderSpanTitlesInFormulaBuilder: Boolean = true
    /**
     *  If this grid has specified ListGrid.headerSpans, and
     *   ListGrid.showHeaderSpanTitlesInFormulaBuilder is true,
     *   this string will be inserted between the headerSpan title(s) and the field title in the
     *   field chooser grid in the FormulaBuilder and SummaryBuilder.
     *  @type {string}
     *  @default " - "
     */
    open var formulaBuilderSpanTitleSeparator: String = " - "
    /**
     *  If this grid has specified ListGrid.headerSpans, should field titles be
     *   prefixed with the titles of the headerSpans in which they are contained when
     *   using the MultiSortDialog.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderSpanTitlesInSortEditor: Boolean = true
    /**
     *  If this grid has specified ListGrid.headerSpans, and
     *   ListGrid.showHeaderSpanTitlesInSortEditor is true, this
     *   string will be inserted between the headerSpan title(s) and the field title in the field
     *   chooser grid on the MultiSortDialog
     *  @type {string}
     *  @default " - "
     */
    open var sortEditorSpanTitleSeparator: String = " - "
    /**
     *  If this grid has specified ListGrid.headerSpans, should field titles be
     *   prefixed with the titles of the headerSpans in which they are contained when
     *   using the DataBoundComponent.editHilites.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderSpanTitlesInHiliteEditor: Boolean = true
    /**
     *  If this grid has specified ListGrid.headerSpans, and
     *   ListGrid.showHeaderSpanTitlesInHiliteEditor is true, this string will be inserted
     *   between the headerSpan title and the field title in the hiliteEditor field chooser
     *   grid.
     *  @type {string}
     *  @default " - "
     */
    open var hiliteEditorSpanTitleSeparator: String = " - "
    /**
     *  This property may be set to customize the css style for the
     *   hover shown on ListGrid.headerHover.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerHoverStyle: String? = null
    /**
     *  This property may be set to customize the alignment for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Alignment}
     *  @default null
     */
    open var headerHoverAlign:
            /**
             *  Center within container.
             *  Stick to left side of container.
             *  Stick to right side of container.
             */
            String? /* center |  left |  right */ = null
    /**
     *  This property may be set to customize the vertical alignment for the
     *   hover shown on ListGrid.headerHover.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var headerHoverVAlign:
            /**
             *  At the top of the container
             *  Center within container.
             *  At the bottom of the container
             */
            String? /* top |  center |  bottom */ = null
    /**
     *  This property may be set to customize the opacity for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverOpacity: Number? = null
    /**
     *  Optional default height for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverHeight: Number? = null
    /**
     *  Optional default width for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverWidth: Number? = null
    /**
     *  This property may be set to customize the wrap attribute for the
     *   hover shown on ListGrid.headerHover.
     *  @type {boolean}
     *  @default null
     */
    open var headerHoverWrap: Boolean? = null
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to freeze fields on the right of the scrollable body.
     *  @type {string}
     *  @default "Freeze on right"
     */
    open var freezeOnRightText: String = "Freeze on right"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to freeze fields on the left of the scrollable body.
     *  @type {string}
     *  @default "Freeze on left"
     */
    open var freezeOnLeftText: String = "Freeze on left"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to sort a field in ascending order.
     *  @type {string}
     *  @default "Sort Ascending"
     */
    open var sortFieldAscendingText: String = "Sort Ascending"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to sort a field in descending order.
     *  @type {string}
     *  @default "Sort Descending"
     */
    open var sortFieldDescendingText: String = "Sort Descending"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to clear an existing sort on this field.
     *  @type {string}
     *  @default "Clear Sort"
     */
    open var clearSortFieldText: String = "Clear Sort"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to clear any existing sort on all fields. This
     *   menu-item is displayed only in the context menu for the sorter button.
     *  @type {string}
     *  @default "Clear All Sorting"
     */
    open var clearAllSortingText: String = "Clear All Sorting"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and a ListGrid.showFilterEditor is visible, this
     *   attribute will be shown as the menu item title to clear any existing filter. This
     *   menu-item is displayed only in the context menu for the sorter button.
     *  @type {string}
     *  @default "Clear Filter"
     */
    open var clearFilterText: String = "Clear Filter"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and multi-sorting is enabled, this attribute is used as the title for a menu item that opens
     *   a MultiSortDialog to configure the sort-specification for this grid. This
     *   menu-item is displayed only in the context menu for the sorter button.
     *  @type {string}
     *  @default "Configure Sort..."
     */
    open var configureSortText: String = "Configure Sort..."
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and multi-grouping is enabled, this attribute is used as the title for a menu item that opens
     *   a MultiGroupDialog to configure the grouping for this grid.
     *  @type {string}
     *  @default "Configure Grouping..."
     */
    open var configureGroupingText: String = "Configure Grouping..."
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and user-driven auto fit of fields is enabled via ListGridField.canAutoFitWidth or
     *   ListGrid.canAutoFitFields, this attribute will be shown as the menu
     *   item title for an item to perform a one-time autoFit of the field to its title or content
     *   via a call to ListGrid.autoFitField.
     *  @type {string}
     *  @default "Auto Fit"
     */
    open var autoFitFieldText: String = "Auto Fit"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and ListGrid.canAutoFitFields is true, this attribute will be shown as the menu
     *   item title for an item to perform a one-time autoFit of all visible fields via
     *   the ListGrid.autoFitField method.
     *  @type {string}
     *  @default "Auto Fit All Columns"
     */
    open var autoFitAllText: String = "Auto Fit All Columns"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, and
     *   ListGrid.canPickFields is true, this
     *   attribute will be shown as the title for the menu item which contains a submenu with items
     *   allowing the user to show and hide fields in the grid.
     *  @type {string}
     *  @default "Columns"
     */
    open var fieldVisibilitySubmenuTitle: String = "Columns"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to freeze a currently unfrozen field.
     *
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed, with title available as a variable containing
     *   the field title.
     *
     *   Default value returns "Freeze " + the field's summary title.
     *  @type {HTMLString}
     *  @default "Freeze ${title}"
     */
    open var freezeFieldText: String = "Freeze \${title}"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to unfreeze a currently frozen field.
     *
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed, with title available as a variable containing
     *   the field title.
     *
     *   Default value returns "Unfreeze " + the field's summary title.
     *  @type {HTMLString}
     *  @default "Unfreeze ${title}"
     */
    open var unfreezeFieldText: String = "Unfreeze \${title}"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canGroupBy is true, this string will be shown as the
     *   title for the menu item to toggle the group by setting for a field.
     *
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed, with title available as a variable containing
     *   the field title.
     *
     *   Default value returns "Group by " + the field's summary title.
     *  @type {HTMLString}
     *  @default "Group by ${title}"
     */
    open var groupByText: String = "Group by \${title}"
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, and
     *   ListGrid.isGrouped is true, this
     *   attribute will be shown as the title for the menu item to ungroup the grid.
     *  @type {string}
     *  @default "Ungroup"
     */
    open var ungroupText: String = "Ungroup"
    /**
     *  When true, indicates that this ListGrid supports sorting on multiple fields. Note that even
     *   when set to true, multi-field sorting may not be available if the grid is databound and the
     *   ${isc.DocUtils.linkForRef('attr:DataSource.canMultiSort','DataSource doesn\'t support multi-sort')}, or if sorting for a
     *   field is ListGridField.canSortClientOnly but not all data is available.
     *  @type {boolean}
     *  @default true
     */
    open var canMultiSort: Boolean = true
    /**
     *  Class level defaults to apply to the MultiSortDialog which gets automatically
     *   generated when DataBoundComponent.askForSort is called.
     *
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogDefaults: MultiSortDialog? = null
    /**
     *  Properties to apply to the MultiSortDialog which gets automatically generated
     *   when DataBoundComponent.askForSort is called.
     *
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogProperties: MultiSortDialog? = null
    /**
     *  When true, indicates that this ListGrid supports grouping on multiple fields.
     *  @type {boolean}
     *  @default false
     */
    open var canMultiGroup: Boolean? = false
    /**
     *  An array of SortSpecifier objects used to set up the initial sort configuration for
     *   this grid. If specified, this will be used instead of any ListGrid.sortField specified.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var initialSort: Array<dynamic>? = null
    /**
     *  When multiple fields are sorted, the Style to apply to the numeral that appears after the
     *   sort-arrows in the header-buttons of sorted fields.
     *  @type {CSSStyleName}
     *  @default "sortNumeral"
     */
    open var sortNumeralStyle: String = "sortNumeral"
    /**
     *  When multiple fields are sorted, set this to false to hide the sort-numeral
     *   displayed by default after the sort-arrows in the header-buttons of sorted fields.
     *  @type {boolean}
     *  @default null
     */
    open var showSortNumerals: Boolean? = null
    /**
     *  Name of the SmartClient Class to be used when creating charts. Must support the
     *   Chart interface.
     *  @type {string}
     *  @default "FacetChart"
     */
    open var chartConstructor: String = "FacetChart"
    /**
     *  Default type of chart to plot.
     *  @type {ChartType}
     *  @default "Column"
     */
    open var chartType:
            /**
             *  Values represented by area, with stacked values representing multiple          facet values. This is equivalent to ChartType "Line" with stacking enabled.
             *  Values represented by vertical columns. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
             *           3 facets.
             *  Values represented by horizontal bars. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
             *           3 facets.
             *  Values represented by a lines between data points, or stacked areas for         multiple facets.
             *  Values represented on a circular background by a line around the center, or         stacked areas for multiple facets
             *  Circular chart with wedges representing values. Multiple or stacked pies         for multiple facets.
             *  Like a pie chart with a central hole. Multiple or stacked doughnuts for         multiple facets.
             *  A chart with two continuous numeric axes and up to one discrete facet.
             *  A chart with two continuous numeric axes and up to one discrete facet         that also displays values from a third continuous, numeric domain
             *           represented as the sizes of the data point shapes.
             *  Like a column chart, except instead of showing stacked or clustered values         for each position on the horizontal axis, the data values are used together
             *           with the associated FacetChart.endValueMetric values to show a series
             *           of line segments.
             */
            String /* Area |  Column |  Bar |  Line |  Radar |  Pie |  Doughnut |  Scatter |  Bubble |  Histogram */ = "Column"
    /**
     *  If this is ListGrid.groupBy and has
     *   frozenFields, should the group title show in the
     *   frozen or unfrozen body?
     *
     *   Setting this property to false will cause the group title to show in the
     *   unfrozen body in this case, meaning it will appear to the right of the frozen fields,
     *   and scroll horizontally as the user scrolls the unfrozen fields.
     *   This can be useful for grids where there isn't
     *   enough available space to show the group title text in the frozen body.
     *
     *   Note that if ListGrid.groupTitleField is explicitly set, or
     *   ListGrid.showGroupSummaryInHeader is true, this property has no
     *   effect. In this case rather than the group title showing in a single cell spanning
     *   multiple other fields, it will be rendered into a specific column.
     *  @type {boolean}
     *  @default true
     */
    open var showGroupTitleInFrozenBody: Boolean = true
    /**
     *  If this listGrid supports ListGrid.canGroupBy, setting this property will cause
     *   the grid to render an extra row at the end of each group when grouped, containing summary
     *   information for the fields.
     *   Summary information will be calculated by the ListGridField.getGroupSummary method
     *   if specified, otherwise via the specified ListGridField.summaryFunction.
     *  @type {boolean}
     *  @default false
     */
    open var showGroupSummary: Boolean = false
    /**
     *  If this grid is ListGrid.groupByField, and
     *   ListGrid.showGroupSummary is true, this attribute may be set to an array of
     *   groupBy field names for which group summaries should appear.
     *
     *   This is particularly useful for listGrids grouped by more than one field as it allows developers
     *   to display the group summary for a particular nested group without showing a summary for every
     *   level of the tree.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var groupByFieldSummaries: Array<dynamic>? = null
    /**
     *  ListGridRecord.customStyle for the group-level summary row displayed when
     *   ListGrid.showGroupSummary is true.
     *  @type {CSSStyleName}
     *  @default "gridSummaryCell"
     */
    open var groupSummaryStyle: String = "gridSummaryCell"
    /**
     *  Class-level defaults to apply to the MultiGroupDialog which gets automatically
     *   generated when ListGrid.configureGrouping is called.
     *  @type {MultiGroupDialog}
     *  @default null
     */
    open var multiGroupDialogDefaults: MultiGroupDialog? = null
    /**
     *  Properties to apply to the MultiGroupDialog which gets automatically
     *   generated when ListGrid.configureGrouping is called.
     *  @type {MultiGroupDialog}
     *  @default null
     */
    open var multiGroupDialogProperties: MultiGroupDialog? = null
    /**
     *  If set to true, an advanced field picker based on the FieldPicker will be shown instead
     *   of the column picker submenu if there are more fields in the grid than
     *   ListGrid.advancedFieldPickerThreshold.
     *
     *   When there are large numbers of available fields, the FieldPicker-based interface is more
     *   usable for both defining visible fields and defining field order.
     *  @type {boolean}
     *  @default false
     */
    open var useAdvancedFieldPicker: Boolean = false
    /**
     *  If set to true, the ListGrid.useAdvancedFieldPicker provides
     *   an interface allowing users to modify fields' titles.
     *
     *   Note that when enabled, the ListGrid.getFieldState for this component
     *   will include field titles.
     *  @type {boolean}
     *  @default false
     */
    open var canEditTitles: Boolean = false
    /**
     *  Instance of FieldPickerWindow used if ListGrid.useAdvancedFieldPicker is set.
     *  @type {FieldPickerWindow}
     *  @default null
     */
    open var fieldPickerWindow: FieldPickerWindow? = null
    /**
     *  Names of properties on ListGridField for which the FieldPicker should
     *   show an editing interface, for convenience.
     *
     *   For example, specify ["frozen", "decimalPrecision"] to allow end users to modify
     *   ListGridField.frozen and ListGridField.decimalPrecision respectively.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var fieldPickerFieldProperties: Array<dynamic>? = null
    /**
     *  When ListGrid.useAdvancedFieldPicker is set, total number of available fields that must be
     *   present in the grid before the advanced field picker interface is used instead of the normal
     *   columns submenu.
     *
     *   Set to 0 to have the advanced picker always used (when useAdvancedFieldPicker is true).
     *  @type {Integer}
     *  @default "25"
     */
    open var advancedFieldPickerThreshold: Number = 25
    /**
     *  When set to false, sample values of the FieldPicker are never shown. This property applies to the entire FieldPicker.
     *  @type {boolean}
     *  @default true
     */
    open var fieldPickerShowSampleValues: Boolean = true
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator for a cell in this grid, how should the row be identified?
     *
     *   Note that getLocator() will actually store all available information about the row in
     *   the generated string -- this attribute effects how a stored string will be parsed only.
     *
     *   Valid options area:
     *
     *
     *  - "primaryKey" Only applies to databound grids: If the cell in question has
     *   a primary key cell value, use it to identify cells in autoTest locator strings.
     *
     *  - "titleField" If the cell in question has a value for the
     *   ListGrid.getTitleField, use it to identify cells in autoTest
     *   locator strings
     *
     *  - "targetCellValue" Identify rows by storing the cell value for the target
     *   row / field in autoTest locator strings
     *
     *  - "index"The rowNum will be used to identify the row.
     *
     *   If unset, default behavior is to identify by primary key (if available), otherwise by
     *   titleField (if available), otherwise by cell value (if available), and lastly by index.
     *  @type {string}
     *  @default null
     */
    open var locateRowsBy: String? = null
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator for a cell in this grid, how should the column be identified?
     *
     *   Note that getLocator() will actually store all available information about the column in
     *   the generated string -- this attribute effects how a stored string will be parsed only.
     *
     *   Valid options area:
     *
     *
     *  - "fieldName" Attempt to identify by fieldName.
     *
     *  - "index" Attempt to identify by colNum (index in the fields array).
     *
     *   If unset, default behavior is to identify by fieldName (if available), otherwise by index.
     *  @type {string}
     *  @default null
     */
    open var locateColumnsBy: String? = null
    /**
     *  Before we start editing values in this DataBoundComponent, should we perform a deep clone
     *   of the underlying values. See DataSource.deepCloneOnEdit for details of what this means.
     *
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     *
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneOnEdit: Boolean? = null
    /**
     *  When editing values in this DataBoundComponent, should we perform a deep clone of values
     *   that are not associated with a field (ie, attributes on the record that do not map to a
     *   component field either directly by name, or by FormItem.dataPath. If this value is
     *   not explicitly set, it defaults to the value of
     *   DataSource.deepCloneNonFieldValuesOnEdit if there is a dataSource, or to the value
     *   of the static DataSource.deepCloneNonFieldValuesOnEdit if there is no
     *   dataSource.
     *
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneNonFieldValuesOnEdit: Boolean? = null
    /**
     *  Whether to show fields marked hidden:true when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     *
     *   The hidden property is used on DataSource fields to mark fields that are
     *   never of meaning to an end user.
     *  @type {boolean}
     *  @default false
     */
    override var showHiddenFields: Boolean = false
    /**
     *  Whether to show fields of non-atomic types when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     *
     *   If true, the component will show fields that declare a complex type, for example, a
     *   field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
     *   DataSource that declares the fields of a shipping address (city, street name, etc).
     *
     *   Such fields may need custom formatters or editors in order to create a usable interface,
     *   for example, an Address field in a ListGrid might use a custom formatter to combine the
     *   relevant fields of an address into one column, and might use a pop-up dialog for
     *   editing.
     *  @type {boolean}
     *  @default true
     */
    override var showComplexFields: Boolean = true
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    override var fetchOperation: String? = null
    /**
     *  DSRequest.operationId this component should use when performing update operations.
     *  @type {string}
     *  @default null
     */
    override var updateOperation: String? = null
    /**
     *  DSRequest.operationId this component should use when performing add operations.
     *  @type {string}
     *  @default null
     */
    override var addOperation: String? = null
    /**
     *  DSRequest.operationId this component should use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    override var removeOperation: String? = null
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     *
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from this component, sorted as they appear.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var exportFields: Array<dynamic>? = null
    /**
     *  Setting exportAll to true prevents the component from passing it's list of fields to the
     *   export call. The result is the export of all visible fields from DataSource.fields.
     *
     *   If exportAll is false, an export operation will first consider
     *   DataBoundComponent.exportFields, if it's set, and fall back on all visible fields from
     *   DataSource.fields otherwise.
     *  @type {boolean}
     *  @default false
     */
    override var exportAll: Boolean = false
    /**
     *  If Summary rows exist for this component, whether to include them when exporting client data.
     *  @type {boolean}
     *  @default true
     */
    override var exportIncludeSummaries: Boolean = true
    /**
     *  Flag controlling when to recategorize records being dropped on a databound
     *   component from another databound component.
     *  @type {RecategorizeMode}
     *  @default "checked"
     */
    override var dragRecategorize:
            /**
             *  recategorize is always applied
             *  recategorize if normal checks pass
             *  never recategorize
             */
            String /* always |  checked |  never */ = "checked"
    /**
     *  If set, detect and prevent duplicate records from being transferred to this component, either via
     *   drag and drop or via DataBoundComponent.transferSelectedData. When a duplicate transfer is detected,
     *   a dialog will appear showing the DataBoundComponent.duplicateDragMessage.
     *
     *   If the component either does not have a DataSource or has a DataSource with no
     *   DataSourceField.primaryKey declared, duplicate checking is off by
     *   default. If duplicate checking is enabled, it looks for an existing record in the dataset
     *   that has all of the properties of the dragged record, and considers that a duplicate.
     *
     *   For DragDataAction:"copy" where the target DataSource is related to the source
     *   DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
     *   criteria, already has a record whose value for the foreignKey field matches the
     *   primaryKey of the record being transferred.
     *
     *   For example, consider dragging "employees" to "teams", where "teams" has a field
     *   "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
     *   grid has search criteria causing it to show all the members of one team. A duplicate -
     *   adding an employee to the same team twice - is when the target grid's dataset contains an
     *   record with "employeeId" matching the "id" field of the dropped employee.
     *  @type {boolean}
     *  @default null
     */
    override var preventDuplicates: Boolean? = null
    /**
     *  Message to show when a user attempts to transfer duplicate records into this component, and
     *   DataBoundComponent.preventDuplicates is enabled.
     *
     *   If set to null, duplicates will not be reported and the dragged duplicates will not be
     *   saved.
     *  @type {string}
     *  @default "Duplicates not allowed"
     */
    override var duplicateDragMessage: String = "Duplicates not allowed"
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data is
     *   available because we do not have a suitable offline cache
     *  @type {boolean}
     *  @default true
     */
    override var showOfflineMessage: Boolean = true
    /**
     *  Message to display when this DataBoundComponent attempts to load data that is not available
     *   because the browser is currently offline. Depending on the component, the message is either
     *   displayed in the component's body, or in a pop-up warning dialog.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    override var offlineMessage: String = "This data not available while offline"
    /**
     *  Message to display when this DataBoundComponent attempts to save data while the application
     *   is offline.
     *  @type {string}
     *  @default "Data cannot be saved because you are not online"
     */
    override var offlineSaveMessage: String = "Data cannot be saved because you are not online"
    /**
     *  Indicates whether to add "drop values" to items dropped on this component, if both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key. "Drop values" are
     *       properties of the dropped item that you wish to change (and persist) as a
     *       result of the item being dropped on this grid.
     *
     *       If this value is true and this component is databound, DataBoundComponent.getDropValues will
     *       be called for every databound item dropped on this grid, and an update performed
     *       on the item
     *  @type {boolean}
     *  @default true
     */
    override var addDropValues: Boolean = true
    /**
     *  When an item is dropped on this component, and DataBoundComponent.addDropValues is true and both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key, this object
     *       provides the "drop values" that SmartClient will apply to the dropped object
     *       before updating it.
     *
     *       If this property is not defined, SmartClient defaults to returning the selection
     *       criteria currently in place for this component. Thus, any databound items (for example,
     *       rows from other grids bound to the same DataSource) dropped on the grid will,
     *       by default, be subjected to an update that makes them conform to the grid's
     *       current filter criteria.
     *  @type {object}
     *  @default null
     */
    override var dropValues: dynamic = null
    /**
     *  Does this component represent singular or multiple "records" objects?
     *   Options are "multiple" or "single", or "either"
     *  @type {string}
     *  @default "multiple"
     */
    override var dataArity: String = "multiple"
    /**
     *  Indicates whether or not this component will load its data
     *   DataSource.progressiveLoading.
     *  @type {boolean}
     *  @default null
     */
    override var progressiveLoading: Boolean? = null
    /**
     *  The useFlatFields flag causes all simple type fields anywhere in a nested
     *   set of DataSources to be exposed as a flat list for form binding.
     *
     *   useFlatFields is typically used with imported metadata, such as
     *   XMLTools.loadXMLSchema from a
     *   XMLTools.loadWSDL, as a means of eliminating levels of XML
     *   nesting that aren't meaningful in a user interface, without the cumbersome and fragile
     *   process of mapping form fields to XML structures.
     *
     *   For example, having called WebService.getInputDS to retrieve the input message
     *   schema for a web service operation whose input message looks like this:
     *
     *   &lt;FindServices&gt;
     *     &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *     &lt;Options&gt;
     *       &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *     &lt;/Options&gt;
     *     &lt;IncludeInSearch&gt;
     *       &lt;serviceName&gt;true&lt;/serviceName&gt;
     *       &lt;documentation&gt;true&lt;/documentation&gt;
     *       &lt;keywords&gt;true&lt;/keywords&gt;
     *     &lt;/IncludeInSearch&gt;
     *   &lt;/FindServices&gt;
     *
     *   Setting useFlatFields on a DynamicForm that is bound to this input
     *   message schema would result in 5 FormItem reflecting the 5 simple type
     *   fields in the message.
     *
     *   For this form, the result of DynamicForm.getValues might look
     *   like:
     *
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   When contacting a WebService, these values can be automatically
     *   mapped to the structure of the input message for a web service operation by setting
     *   WSRequest.useFlatFields (for use with WebService.callOperation) or by setting
     *   DSRequest.useFlatFields (for use with a DataSource that is
     *   wsdlBinding via
     *   OperationBinding.wsOperation).
     *
     *   Using these two facilities in conjunction (component.useFlatFields and
     *   request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
     *   presentation and when providing the data for XML messages.
     *
     *   You can also set OperationBinding.useFlatFields to automatically enable
     *   "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
     *   particular operationType.
     *
     *   Note that useFlatFields is not generally recommended for use with structures
     *   where multiple simple type fields exist with the same name, however if used with such a
     *   structure, the first field to use a given name wins. "first" means the first field
     *   encountered in a depth first search. "wins" means only the first field will be present as a
     *   field when data binding.
     *  @type {boolean}
     *  @default null
     */
    override var useFlatFields: Boolean? = null
    /**
     *  If this attribute is set to false, any attributes in the component's values object that do
     *   not map to a DataSourceField or FormItem will not
     *   be tracked when checking for changes. You should only set this flag to false if you know
     *   that your code does not store additional, non-field values in the component's data, or if
     *   you do store such values, but you don't care that they are not checked for changes.
     *   This flag is primarily provided to avoid performance issues in cases where developers are
     *   storing large numbers of extra attributes in component data; generally speaking, you should
     *   only consider setting it to false if you have a use case like this.
     *
     *   Note, even with this flag set to false, these extra values will still be managed and stored
     *   by SmartClient; they just will not be checked when the component's values are inspected to
     *   see if they have changed. This may lead to methods like ListGrid.rowHasChanges
     *   returning false when you are expecting it to return true. In this case, either switch this
     *   flag back to true (or just do not set it false), or provide a field definition for the
     *   affected attribute(s).
     *  @type {boolean}
     *  @default true
     */
    override var canChangeNonFieldValues: Boolean = true
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any criteria
     *   provided via DataBoundComponent.initialCriteria, method:DataBoundComponent.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    override var implicitCriteria: dynamic = null
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic>? = null
    /**
     *  Marker that can be set on a record to flag that record as hilited. Should be set to a value
     *   that matches Hilite.id for a hilite defined on this component.
     *  @type {string}
     *  @default "_hilite"
     */
    override var hiliteProperty: String = "_hilite"
    /**
     *  Initial hilite state for the grid.
     *
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, hiliteState is not needed because viewState
     *   includes it as well. If both are provided, hiliteState has priority for
     *   hilite state.
     *
     *
     *   To retrieve current state call DataBoundComponent.getHiliteState.
     *
     *  @type {string}
     *  @default null
     */
    override var hiliteState: String? = null
    /**
     *  The strategy to use when generating names for new fields in this component. The default
     *   strategy, "simple", combines the field-type with an index maintained by field-type and
     *   component instance. For example, "formulaField1".
     *  @type {FieldNamingStrategy}
     *  @default "simple"
     */
    override var fieldNamingStrategy:
            /**
             *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
             *  generates a UUID for all generated field names
             */
            String /* simple |  uuid */ = "simple"
    /**
     *  Text for a menu item allowing users to edit grid highlights.
     *  @type {string}
     *  @default "Edit Highlights..."
     */
    override var editHilitesText: String = "Edit Highlights"
    /**
     *  The title for the DataBoundComponent.editHilites dialog.
     *  @type {string}
     *  @default "Edit Highlights"
     */
    override var editHilitesDialogTitle: String = "Edit Highlights"
    /**
     *  The title for the DataBoundComponent.fieldEditorWindow used to edit calculated
     *   fields.
     *
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code whenever the message is displayed.
     *
     *   Two dynamic variables are available - "builderType", either Formula or Summary, and
     *   "fieldTitle", which is the title of the calculated field being edited.
     *  @type {HTMLString}
     *  @default "${builderType} Editor [${fieldTitle}]"
     */
    override var fieldEditorWindowTitle: String = "\${builderType} Editor [\${fieldTitle}]"
    /**
     *  The Window used to edit calculated fields for this component.
     *  @type {Window}
     *  @default null
     */
    override var fieldEditorWindow: Window? = null
    /**
     *  This component's HiliteEditor instance used to allow the user to create, modify, or delete
     *   hilites.
     *
     *   The following autoChildUsage apply:
     *
     *
     *  - DataBoundComponent.hiliteIcons for HiliteEditor.hiliteIcons
     *
     *  @type {HiliteEditor}
     *  @default null
     */
    override var hiliteEditor: HiliteEditor? = null
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add formula column..."
     */
    override var addFormulaFieldText: String = "Add formula column..."
    /**
     *  Text for a menu item allowing users to edit a formula field
     *  @type {string}
     *  @default "Edit formula..."
     */
    override var editFormulaFieldText: String = "Edit formula..."
    /**
     *  Text for a menu item allowing users to remove a formula field
     *  @type {string}
     *  @default "Remove formula"
     */
    override var removeFormulaFieldText: String = "Remove formula"
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add summary column..."
     */
    override var addSummaryFieldText: String = "Add summary column..."
    /**
     *  Text for a menu item allowing users to edit the formatter for a field
     *  @type {string}
     *  @default "Edit summary format..."
     */
    override var editSummaryFieldText: String = "Edit summary format..."
    /**
     *  Text for a menu item allowing users to remove a summary field
     *  @type {string}
     *  @default "Remove summary format..."
     */
    override var removeSummaryFieldText: String = "Remove summary format..."
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     *
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var iconField: String? = null
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     *
     *   This attribute has the same function as DataSource.infoField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var infoField: String? = null
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     *
     *   This attribute has the same function as DataSource.dataField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var dataField: String? = null
    /**
     *  Name of the field that has a long description of the record, or has the primary text data
     *   value for a record that represents an email message, SMS, log or similar.
     *
     *   This attribute has the same function as DataSource.descriptionField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var descriptionField: String? = null
    /**
     *  The message to display to the user if an export of a DataBoundComponent's data is attempted
     *   while the DataBoundComponent's data is null or an empty list.
     *  @type {string}
     *  @default "You are attempting to export an empty dataset"
     */
    override var emptyExportMessage: String = "You are attempting to export an empty dataset"
    /**
     *  For databound components that support editing, the error message for a failed validator
     *   that does not specify its own errorMessage.
     *  @type {HTMLString}
     *  @default "Invalid value"
     */
    override var unknownErrorMessage: String = "Invalid value"
    /**
     *  A message to display to the user if server-side validation fails with an error but the
     *   server did not provide an error message
     *  @type {string}
     *  @default "Error during validation; no error details were provided"
     */
    override var noErrorDetailsMessage: String = "Error during validation; no error details were provided"
}
