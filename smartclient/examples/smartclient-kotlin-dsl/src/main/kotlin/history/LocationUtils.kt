@file:JsModule("history")
@file:JsNonModule
package history

// import { Path, LocationState, LocationKey, Location, LocationDescriptor } from './index';
external fun locationsAreEqual(lv: LocationDescriptor, rv: LocationDescriptor): Boolean = definedExternally

external fun createLocation(path: LocationDescriptor, state: LocationState?, key: LocationKey?, currentLocation: Location<*>?): Location<*> = definedExternally
