@file:JsModule("history")
@file:JsNonModule
package history

// declare global {
external interface EventTarget {
}
external interface EventListener {
}
external interface EventListenerObject {
}
// }
// export const isExtraneousPopstateEvent: boolean;
external fun addEventListener(node: EventTarget, event: String, listener: dynamic): Unit = definedExternally

external fun removeEventListener(node: EventTarget, event: String, listener: dynamic): Unit = definedExternally

external fun getConfirmation(message: String, callback: ((result: Boolean) -> Unit)): Unit = definedExternally

external fun supportsHistory(): Boolean = definedExternally

external fun supportsGoWithoutReloadUsingHash(): Boolean = definedExternally
