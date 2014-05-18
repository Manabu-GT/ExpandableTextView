ExpandableTextView
===================

ExpandableTextView is an Android library that allows developers to easily create an TextView
which can expand/collapse just like the Google Play's app description.
Feel free to use it all you want in your Android apps provided that you cite this project.

<img src="https://raw.github.com/Manabu-GT/ExpandableTextView/master/art/readme_demo.gif" width=346 height=588 alt="Quick Demo">

Setup
------
You just need to add the followings to your ***build.gradle*** file:

```
repositories {
    maven { url 'http://Manabu-GT.github.com/ExpandableTextView/mvn-repo' }
}
```

```
dependencies {
    compile 'com.ms.square:expandabletextview:0.1.0'
}
```

Usage
------
Using the library is really simple, just look at the source code of the [provided sample][1].

Also, you can optionally set the following attributes in your layout xml file to customize the behavior
of the ExpandableTextView.

 * `maxCollapsedLines` (defaults to 8)
 The maximum number of text lines allowed to be shown when the TextView gets collapsed

 * `animDuration` (defaults to 300ms)
 Duration of the Animation for the expansion/collapse

 * `animAlphaStart` (defaults to 0.7f)
 Alpha value of the TextView when the animation starts

 * `expandDrawable`
 Customize a drawable set to ImageButton to expand the TextView

 * `collapseDrawable`
 Customize a drawable set to ImageButton to collapse the TextView

```sample xml
  <com.ms.square.android.expandabletextview.ExpandableTextView
      xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:expandableTextView="http://schemas.android.com/apk/res-auto"
      android:id="@+id/expand_text_view"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="vertical"
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
          android:layout_margin="16dp"
          android:layout_gravity="right|bottom"
          android:background="@android:color/transparent"/>
  </com.ms.square.android.expandabletextview.ExpandableTextView>
```

License
--------

```
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
```

[1]: https://github.com/Manabu-GT/ExpandableTextView/tree/master/sample