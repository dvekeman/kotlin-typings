package history

typealias Action = String /* PUSH |  POP |  REPLACE */
typealias UnregisterCallback = (() -> Unit)
typealias HistoryLocationState = Any
typealias LocationDescriptor = Any
typealias LocationKey = String
typealias LocationListener = ((location: Location<*>, action: Action) -> Unit)
typealias LocationState = Any
typealias Path = String
typealias Pathname = String
typealias Search = String
typealias TransitionHook = ((location: Location<*>, callback: ((result: dynamic) -> Unit)) -> dynamic)
typealias TransitionPromptHook = ((location: Location<*>, action: Action) -> dynamic)
typealias Hash = String
typealias Href = String
typealias HashType = String /* hashbang |  noslash |  slash */
typealias PromptFunction = ((location: Location<*>, action: Action) -> dynamic)
typealias Prompt = Any
