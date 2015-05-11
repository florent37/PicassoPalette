package com.github.florent37.picassopalette.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//import com.github.florent37.picassopalette.PicassoPalette;


public class MainActivity extends ActionBarActivity {

    ImageView imageView;

    TextView textVibrant;
    TextView textVibrantLight;
    TextView textVibrantDark;
    TextView textMuted;
    TextView textMutedLight;
    TextView textMutedDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);

        textVibrant = (TextView) findViewById(R.id.textVibrant);
        textVibrantLight = (TextView) findViewById(R.id.textVibrantLight);
        textVibrantDark = (TextView) findViewById(R.id.textVibrantDark);
        textMuted = (TextView) findViewById(R.id.textMuted);
        textMutedLight = (TextView) findViewById(R.id.textMutedLight);
        textMutedDark = (TextView) findViewById(R.id.textMutedDark);

        String url = "http://fc05.deviantart.net/fs71/i/2011/105/c/0/nyan_cat_wallpaper_by_nyakiru-d3e1zfl.png";
        Picasso.with(this).load(url).fit().centerCrop().into(
                imageView,
                PicassoPalette.with(url, imageView)

                        .use(PicassoPalette.Profile.VIBRANT)
                            .intoBackground(textVibrant, PicassoPalette.Swatch.RGB)
                            .intoTextColor(textVibrant, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                        .use(PicassoPalette.Profile.VIBRANT_DARK)
                            .intoBackground(textVibrantDark, PicassoPalette.Swatch.RGB)
                            .intoTextColor(textVibrantDark, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                        .use(PicassoPalette.Profile.VIBRANT_LIGHT)
                            .intoBackground(textVibrantLight, PicassoPalette.Swatch.RGB)
                            .intoTextColor(textVibrantLight, PicassoPalette.Swatch.BODY_TEXT_COLOR)

                        .use(PicassoPalette.Profile.MUTED)
                            .intoBackground(textMuted, PicassoPalette.Swatch.RGB)
                            .intoTextColor(textMuted, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                        .use(PicassoPalette.Profile.MUTED_DARK)
                            .intoBackground(textMutedDark, PicassoPalette.Swatch.RGB)
                            .intoTextColor(textMutedDark, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                        .use(PicassoPalette.Profile.MUTED_LIGHT)
                            .intoBackground(textMutedLight, PicassoPalette.Swatch.RGB)
                            .intoTextColor(textMutedLight, PicassoPalette.Swatch.BODY_TEXT_COLOR)

                        .addCallBack(new PicassoPalette.CallBack() {
                            @Override
                            public void onPaletteLoaded(Palette palette) {
                                //specific task
                            }
                        })
        );
    }

}
