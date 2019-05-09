@file:JsModule("history")
@file:JsNonModule
package history

external interface History<HistoryLocationState/* extends dynamic*/> {
    var length: Number
    var action: Action
    var location: Location<HistoryLocationState>
    fun push (path: String, state: HistoryLocationState?): Unit
    fun push (location: LocationDescriptorObject<HistoryLocationState>): Unit
    fun replace (path: String, state: HistoryLocationState?): Unit
    fun replace (location: LocationDescriptorObject<HistoryLocationState>): Unit
    fun go (n: Number): Unit
    fun goBack (): Unit
    fun goForward (): Unit
    fun block (prompt: dynamic): () -> Unit
    fun listen (listener: ((location: Location<*>, action: Action) -> Unit)): () -> Unit
    fun createHref (location: LocationDescriptorObject<HistoryLocationState>): String
}
external interface Location<S /*extends dynamic*/> {
    var pathname: String
    var search: String
    var state: S
    var hash: String
    var key: String
}
external interface LocationDescriptorObject<S /*extends dynamic*/> {
    var pathname: String
    var search: String
    var state: S
    var hash: String
    var key: String
}
//package History

// import { default as createBrowserHistory } from "./createBrowserHistory";
// import { default as createHashHistory } from "./createHashHistory";
// import { default as createMemoryHistory } from "./createMemoryHistory";
// import { createLocation, locationsAreEqual } from "./LocationUtils";
// import { parsePath, createPath } from "./PathUtils";
external interface Module {
    var createBrowserHistory: dynamic
    var createHashHistory: dynamic
    var createMemoryHistory: dynamic
    var createLocation: dynamic
    var locationsAreEqual: dynamic
    var parsePath: dynamic
    var createPath: dynamic
}
// export * from "./createBrowserHistory";
// export * from "./createHashHistory";
// export * from "./createMemoryHistory";
// export { createLocation, locationsAreEqual } from "./LocationUtils";
// export { parsePath, createPath } from "./PathUtils";
// export { createBrowserHistory, createHashHistory, createMemoryHistory };