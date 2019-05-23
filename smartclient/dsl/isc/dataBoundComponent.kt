package dsl.isc

import isc.HiliteEditor
import isc.MultiSortDialog
import isc.Window

@ISCDslMarker
interface DataBoundComponentProperties {
    var deepCloneOnEdit: Boolean?
    var deepCloneNonFieldValuesOnEdit: Boolean?
    var dataSource: dynamic
    var dataFetchMode:
            /**
             *  All records that match the current filter are fetched. Sorting is        performed on the client.
             *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
             *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
             */
            String /* basic |  paged |  local */
    var dataPageSize: Number?
    var dataFetchDelay: Number
    var fields: Array<dynamic>?
    var useAllDataSourceFields: Boolean?
    var showHiddenFields: Boolean
    var showDetailFields: Boolean
    var showComplexFields: Boolean
    var fetchOperation: String?
    var updateOperation: String?
    var addOperation: String?
    var removeOperation: String?
    var exportFields: Array<dynamic>?
    var exportAll: Boolean
    var exportIncludeSummaries: Boolean
    var dragRecategorize:
            /**
             *  recategorize is always applied
             *  recategorize if normal checks pass
             *  never recategorize
             */
            String /* always |  checked |  never */
    var preventDuplicates: Boolean?
    var duplicateDragMessage: String
    var showOfflineMessage: Boolean
    var offlineMessage: String
    var offlineSaveMessage: String
    var addDropValues: Boolean
    var dropValues: dynamic
    var dataArity: String
    var progressiveLoading: Boolean?
    var canEditFieldAttribute: String
    var useFlatFields: Boolean?
    var canChangeNonFieldValues: Boolean
    var autoFetchData: Boolean
    var initialCriteria: dynamic
    var implicitCriteria: dynamic
    var canEditHilites: Boolean
    var hilites: Array<dynamic>?
    var hiliteIcons: Array<dynamic>
    var hiliteIconPosition:
            /**
             *  icon will be placed before the normal cell contents
             *  icon will be placed after the normal cell contents
             *  icon will be shown instead of the normal cell contents
             */
            String /* before |  after |  replace */
    var hiliteIconSize: Number
    var hiliteIconWidth: Number?
    var hiliteIconHeight: Number?
    var hiliteIconLeftPadding: Number
    var hiliteIconRightPadding: Number
    var hiliteProperty: String
    var hiliteState: String?
    var fieldNamingStrategy:
            /**
             *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
             *  generates a UUID for all generated field names
             */
            String /* simple |  uuid */
    var editHilitesText: String
    var editHilitesDialogTitle: String
    var fieldEditorWindowTitle: String
    var fieldEditorWindow: Window?
    var hiliteEditor: HiliteEditor?
    var dragDataAction:
            /**
             *  Don't do anything, resulting in the same data being in both lists.
             *  Copy the data leaving the original in our list.
             *  Remove the data from this list so it can be moved into the other list.
             */
            String /* none |  copy |  move */
    var dragTrackerStyle: String
    var badFormulaResultValue: String
    var missingSummaryFieldValue: String
    var canAddFormulaFields: Boolean
    var addFormulaFieldText: String
    var editFormulaFieldText: String
    var removeFormulaFieldText: String
    var canAddSummaryFields: Boolean
    var addSummaryFieldText: String
    var editSummaryFieldText: String
    var removeSummaryFieldText: String
    var includeHilitesInSummaryFields: Boolean
    var titleField: String?
    var iconField: String?
    var infoField: String?
    var dataField: String?
    var descriptionField: String?
    var emptyExportMessage: String
    var multiSortDialogProperties: MultiSortDialog?
    var multiSortDialogDefaults: MultiSortDialog?
    var unknownErrorMessage: String
    var noErrorDetailsMessage: String

}