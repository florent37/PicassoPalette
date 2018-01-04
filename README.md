PicassoPalette
=======


<a href="https://goo.gl/WXW8Dc">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>


[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-PicassoPalette%20-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1825)

![Alt sample](https://raw.githubusercontent.com/florent37/PicassoPalette/master/screenshot/nyancat_small_2.png)

# Download

<a href='https://ko-fi.com/A160LCC' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi1.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

In your module [![Download](https://api.bintray.com/packages/florent37/maven/PicassoPalette/images/download.svg)](https://bintray.com/florent37/maven/PicassoPalette/_latestVersion)
```groovy
compile 'com.github.florent37:picassopalette:2.0.0'
compile 'com.squareup.picasso:picasso:2.5.2'
```

# Sample

```java
Picasso.with(this).load(url.toString()).into(imageView,
         PicassoPalette.with(url.toString(), imageView)
               .use(PicassoPalette.Profile.MUTED_DARK)
                   .intoBackground(textView)
                   .intoTextColor(textView)

               .use(PicassoPalette.Profile.VIBRANT)
                    .intoBackground(titleView, PicassoPalette.Swatch.RGB)
                    .intoTextColor(titleView, PicassoPalette.Swatch.BODY_TEXT_COLOR)
         );
```

## Initialisation

First, init PicassoPalette with an **Url** and an **ImageView**

```java
PicassoPalette.with(url.toString(), imageView)
```

## Palettes

You can successively use following palettes :

- Palette.VIBRANT
- Palette.VIBRANT_DARK
- Palette.VIBRANT_LIGHT
- Palette.MUTED
- Palette.MUTED_DARK
- Palette.MUTED_LIGHT

```java
.use(PicassoPalette.Profile.MUTED_DARK)
```

**Each time you call "use" the next modification will follow this Profile**

```java
.use(PicassoPalette.Profile.MUTED_DARK)
    //next operations will use Profile.MUTED_DARK
.use(PicassoPalette.Profile.VIBRANT)
    //next operations will use Profile.VIBRANT
```

## Swatches

With the following Swatchs

- RGB
- TITLE_TEXT_COLOR
- BODY_TEXT_COLOR

## Targets

Into Backgrounds

```java
.intoBackground(view)
.intoBackground(view,Swatch.RGB)
```

And TextView Color

```java
.intoTextColor(textView)
.intoTextColor(textView,Swatch.TITLE_TEXT_COLOR)
```

# CallBack

Or simply return into CallBack

```java
.intoCallBack(
    new PicassoPalette.CallBack() {
          @Override
          public void onPaletteLoaded(Palette palette) {
              //specific task
          }
    })
```


# TODO

# Community

Looking for contributors, feel free to fork !

# Dependencies

- Picasso from Square : [http://square.github.io/picasso/][picasso]

# Credits

Author: Florent Champigny www.florentchampigny.com/


<a href="https://goo.gl/WXW8Dc">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/in/florentchampigny">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>

# License

    Copyright 2015 florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[snap]: https://oss.sonatype.org/content/repositories/snapshots/
[picasso]: http://square.github.io/picasso/
