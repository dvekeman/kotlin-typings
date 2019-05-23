package dsl.isc

import isc.Map

@ISCDslMarker
open class ClassProperties {
    /**
     *  Controls whether arguments passed to Class.create are assumed to be
     *   Objects containing properties that should be added to the newly created instance. This
     *   behavior is how create() works with almost all SmartClient widgets and
     *   other components, allowing the convenient shorthand of setting a batch of properties via
     *   an ObjectLiteral passed to create().
     *
     *   The setting defaults to true if unset. To disable this behavior for a custom class,
     *   such that create() works more like typical constructors found in Java and
     *   other languages, use:
     *
     *     isc.[i]ClassName[/i].addProperties({ addPropertiesOnCreate:false })
     *
     *
     *   Note that it is not valid to disable this behavior for any subclass of Canvas
     *   (Canvas relies on this property).
     *
     *   Regardless of the setting for addPropertiesOnCreate, all arguments passed to
     *   Class.create are still passed on to Class.init.
     *  @type {boolean}
     *  @default undefined
     */
    open var addPropertiesOnCreate: Boolean? = null
    /**
     *  Canvas.ID of the component that manages "rule context" for which
     *   this class participates. A non-Canvas class can only use the ruleScope
     *   for supporting Class.dynamicProperties. Unlike Canvas.ruleScope
     *   ruleScope on a standalone class must be explicitly specified.
     *  @type {string}
     *  @default null
     */
    open var ruleScope: String? = null
    /**
     *  Object mapping dynamic property names to the source - a DataPath,
     *   UserSummary or UserFormula. This is a declarative
     *   alternative to calling Class.addDynamicProperty for each property.
     *
     *   See Class.addDynamicProperty for details on using dynamic properties.
     *
     *
     *   In JavaScript dynamicProperties can be declaratively initialized as follows:
     *
     *   dynamicProperties: {
     *     propName1 : "a/b/c",
     *     propName2 : { formula: .. formula definition .. }
     *     propName3 : { textFormula: .. summary definition .. }
     *   }
     *
     *
     *
     *   In ComponentXML dynamicProperties can be intialized as:
     *
     *   &lt;dynamicProperties&gt;
     *     &lt;property name="propName" dataPath="a/b/c"/&gt;
     *     &lt;property name="propName2"&gt;
     *       &lt;formula&gt;
     *         &lt;UserFormula ... &gt;
     *       &lt;/formula&gt;
     *     &lt;/property&gt;
     *     &lt;property name="propName3"&gt;
     *       &lt;textFormula&gt;
     *         &lt;UserSummary ... &gt;
     *       &lt;/textFormula&gt;
     *     &lt;/property&gt;
     *   &lt;/dynamicProperties&gt;
     *
     *  @type {Map<any>}
     *  @default null
     */
    open var dynamicProperties: Map<dynamic>? = null

}