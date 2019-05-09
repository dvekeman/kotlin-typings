@file:JsModule("history")
@file:JsNonModule
package history

// import { History, Location, LocationState } from './index';
// import { getConfirmation } from './DOMUtils';
external interface MemoryHistoryBuildOptions {
    var getUserConfirmation: dynamic
    var initialEntries: Array<String>
    var initialIndex: Number
    var keyLength: Number
}
external interface MemoryHistory<HistoryLocationState> : History<HistoryLocationState> {
    var index: Number
    var entries: Array<Location<HistoryLocationState>>
    fun canGo (n: Number): Boolean
}
external fun createMemoryHistory(options: MemoryHistoryBuildOptions?): MemoryHistory<*> = definedExternally
