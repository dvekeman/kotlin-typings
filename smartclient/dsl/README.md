# Kotlin SmartClient DSL

[ ![Download](https://api.bintray.com/packages/dvekeman/kotlin-typings/kotlin-smartclient-dsl/images/download.svg) ](https://bintray.com/dvekeman/kotlin-typings/kotlin-smartclient-dsl/_latestVersion)

This library provides a DSL for the [SmartClient](https://www.smartclient.com) JS library.
There is another library which provides the wrapper itself (kotlin-smartclient)

*WARNING*: This is currently **experimental** and no maintenance is yet foreseen.

## Publish process

First update the version number if needed (in two places): 

- build.gradle (at the bottom)
- package.json

```
./gradlew -i clean build bintrayUpload
```