@file:JsModule("history")
@file:JsNonModule
package history

// import { History } from './index';
// import { getConfirmation } from './DOMUtils';
external interface HashHistoryBuildOptions {
    var basename: String
    var hashType: HashType
    var getUserConfirmation: dynamic
}
external fun createHashHistory(options: HashHistoryBuildOptions?): History<*> = definedExternally
