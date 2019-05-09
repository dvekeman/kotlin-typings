@file:JsModule("history")
@file:JsNonModule
package history

// import { History } from './index';
// import { getConfirmation } from './DOMUtils';
external class BrowserHistoryBuildOptions {
    var basename: String?
    var forceRefresh: Boolean?
    var getUserConfirmation: dynamic
    var keyLength: Number?
}
external fun createBrowserHistory(): History<Any> = definedExternally
external fun createBrowserHistory(options: BrowserHistoryBuildOptions?): History<Any> = definedExternally
