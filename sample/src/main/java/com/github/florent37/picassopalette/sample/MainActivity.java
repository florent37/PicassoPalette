package com.github.florent37.picassopalette.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

//import com.github.florent37.picassopalette.PicassoPalette;
import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;


public class MainActivity extends ActionBarActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.texte);

        String url = "http://www.gizmodo.fr/wp-content/uploads/2013/07/Dark-Vador.jpg";
        Picasso.with(this).load(url).fit().centerCrop().into(
                imageView,
                PicassoPalette.with(imageView)
                        .use(PicassoPalette.Profile.MUTED_DARK)
                        .intoBackground(textView,PicassoPalette.Swatch.RGB)
                        .intoTextColor(textView,PicassoPalette.Swatch.BODY_TEXT_COLOR)
        );
    }

}
