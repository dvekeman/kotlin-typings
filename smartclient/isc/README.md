# Kotlin SmartClient Wrapper

[ ![Download](https://api.bintray.com/packages/dvekeman/kotlin-typings/kotlin-smartclient/images/download.svg) ](https://bintray.com/dvekeman/kotlin-typings/kotlin-smartclient/_latestVersion)

This library provides a wrapper around the [SmartClient](https://www.smartclient.com) JS library.

*WARNING*: This is currently **experimental** and no maintenance is yet foreseen.

## Publish process

First update the version number if needed (in two places): 

- build.gradle (at the bottom)
- package.json

```
./gradlew -i clean build bintrayUpload
```