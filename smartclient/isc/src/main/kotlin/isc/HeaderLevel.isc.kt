@file:JsQualifier("isc")
package isc

/**
 *  Defines one level of headers shown above the event area in a Timeline.
 */
open external class HeaderLevel {
    /**
     *  Unit of time shown at this level of header.
     *  @type {TimeUnit}
     *  @default null
     */
    open var unit: 
                   /**
                    *  a millisecond time-unit
                    *  a second time-unit
                    *  a minute time-unit
                    *  an hour time-unit
                    *  a day time-unit
                    *  a week time-unit
                    *  a month time-unit
                    *  a quarter (3 month) time-unit
                    *  a year time-unit
                    */
                   String /* millisecond |  second |  minute |  hour |  day |  week |  month |  quarter |  year */ = definedExternally
    /**
     *  If set, the width for each of the spans in this headerLevel. Note that this setting only
     *   has an effect on the innermost headerLevel.
     *  @type {Integer}
     *  @default null
     */
    open var headerWidth: Number = definedExternally
    /**
     *  Optional sparse array of titles for the spans on this headerLevel. If a given span in this
     *   headerLevel has a corresponding entry in this array, it will be used as the span's title.
     * 
     *   If not specified, default titles are generated (eg "Q1" for unit "quarter") and then passed
     *   into the HeaderLevel.titleFormatter, if one has been installed,
     *   for further customization.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var titles: Array<dynamic> = definedExternally
    /**
     *   An optional function for providing formatted HTML for the title of a given span in this
     *   HeaderLevel. If unset, Timelines use the HeaderLevel.titles, if one is
     *   set, or generate default titles based on the unit-type and date-range.
     * 
     *   Note that this method will not run for spans in this headerLevel that have a non-null entry
     *   in the HeaderLevel.titles array.
     * 
     * 
     *  @param {HeaderLevel} a reference to this headerLevel
     *  @param {Date} the start of the date-range covered by this span in this level
     *  @param {Date} the end of the date-range covered by this span in this level - may be            null
     *  @param {string} the default title as generated by the Timeline
     *  @param {Calendar} a reference to the Calendar or Timeline
     */
    open fun titleFormatter(headerLevel: HeaderLevel, startDate: Date, endDate: Date, defaultValue: String, viewer: Calendar): String = definedExternally
}