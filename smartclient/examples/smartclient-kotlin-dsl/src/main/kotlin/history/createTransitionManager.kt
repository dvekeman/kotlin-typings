@file:JsModule("history")
@file:JsNonModule
package history

// import { Location, Action, LocationListener, UnregisterCallback } from './index';
// import { getConfirmation } from './DOMUtils';
external interface TransitionManager {
    fun setPrompt (nextPrompt: Prompt?): UnregisterCallback
    fun appendListener (listener: LocationListener): UnregisterCallback
    fun notifyListeners (location: Location<*>, action: Action): Unit
    fun confirmTransitionTo (location: Location<*>, action: Action, getUserConfirmation: dynamic, callback: ((result: Boolean) -> Unit)): Unit
}
external fun createTransitionManager(): TransitionManager = definedExternally
