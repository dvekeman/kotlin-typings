@file:JsModule("history")
@file:JsNonModule
package history

// import { Path, Location, LocationDescriptorObject } from './index';
external fun addLeadingSlash(path: Path): Path = definedExternally

external fun stripLeadingSlash(path: Path): Path = definedExternally

external fun hasBasename(path: Path): Boolean = definedExternally

external fun stripBasename(path: Path, prefix: String): Path = definedExternally

external fun stripTrailingSlash(path: Path): Path = definedExternally

external fun parsePath(path: Path): Location<*> = definedExternally

external fun createPath(location: LocationDescriptorObject<*>): Path = definedExternally
