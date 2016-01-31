ExpandableTextView [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ExpandableTextView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1203)
===================

ExpandableTextView is an Android library that allows developers to easily create an TextView
which can expand/collapse just like the Google Play's app description.
Feel free to use it all you want in your Android apps provided that you cite this project.

<img src="/art/readme_demo.gif?raw=true" width=360 height=640 alt="Quick Demo">

Requirements
-------------
API Level 8 (Froyo) and above.

Setup
------
The library is pushed to Maven Central as an AAR, 
so you just need to add the followings to your ***build.gradle*** file:

```groovy

dependencies {
    compile 'com.ms-square:expandableTextView:0.1.4'
}

```

Usage
------
Using the library is really simple, just look at the source code of the [provided sample][1].
(Look at the SampleTextListAdapter.java for the use within a ListView)

The important thing to note is that the view Ids for TextView and ImageButton must be set to
"@id/expandable_text" and "@id/expand_collapse" respectively for this library to work.

Also, you can optionally set the following attributes in your layout xml file to customize the behavior
of the ExpandableTextView.

 * `maxCollapsedLines` (defaults to 8)
 The maximum number of text lines allowed to be shown when the TextView gets collapsed

 * `animDuration` (defaults to 300ms)
 Duration of the Animation for the expansion/collapse

 * `animAlphaStart` (defaults to 0.7f)
 Alpha value of the TextView when the animation starts
 (NOTE)
 Set this value to 1 if you want to disable the alpha animation.

 * `expandDrawable`
 Customize a drawable set to ImageButton to expand the TextView

 * `collapseDrawable`
 Customize a drawable set to ImageButton to collapse the TextView

```xml
  <!-- sample xml -->
  <com.ms.square.android.expandabletextview.ExpandableTextView
      xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:expandableTextView="http://schemas.android.com/apk/res-auto"
      android:id="@+id/expand_text_view"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      expandableTextView:maxCollapsedLines="4"
      expandableTextView:animDuration="200">
      <TextView
          android:id="@id/expandable_text"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_marginLeft="10dp"
          android:layout_marginRight="10dp"
          android:textSize="16sp"
          android:textColor="#666666" />
      <ImageButton
          android:id="@id/expand_collapse"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:padding="16dp"
          android:layout_gravity="right|bottom"
          android:background="@android:color/transparent"/>
  </com.ms.square.android.expandabletextview.ExpandableTextView>
```

```java
// sample code snippet to set the text content on the ExpandableTextView
ExpandableTextView expTv1 = (ExpandableTextView) rootView.findViewById(R.id.sample1)
                    .findViewById(R.id.expand_text_view);
                    
// IMPORTANT - call setText on the ExpandableTextView to set the text content to display
expTv1.setText(getString(R.string.dummy_text1));
```

License
----------

    Copyright 2014 Manabu Shimobe

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: https://github.com/Manabu-GT/ExpandableTextView/tree/master/sample
