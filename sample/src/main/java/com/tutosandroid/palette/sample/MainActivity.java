package com.tutosandroid.palette.sample;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

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

        String url = "http://i.ytimg.com/vi/aNHOfJCphwk/maxresdefault.jpg";

        //j'utilise picasso afin de récupérer l'image
        Picasso.with(this).load(url).fit().centerCrop().into(
                imageView,

                //j'écoute le chargement via picasso
                new Callback() {
                    @Override

                    //puis lorsque l'image a bien été chargée
                    public void onSuccess() {
                        //retrouver le bitmap téléchargé par Picasso
                        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

                        //demande à la palette de générer ses coleurs, de façon asynchrone
                        //afin de ne pas bloquer l'interface graphique
                        new Palette.Builder(bitmap).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                //lorsque la palette est générée, je l'utilise sur mes textViews
                                appliquerPalette(palette);
                            }
                        });
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    public void appliquerPalette(Palette palette) {

        {
            //je récupère le swatch Vibrant

            Palette.Swatch vibrant = palette.getVibrantSwatch();
            if (vibrant != null) { //il se peut que la palette ne génère pas tous les swatch

                //j'utilise getRgb() en tant que couleurs de fond te ma textView
                textVibrant.setBackgroundColor(vibrant.getRgb());

                //getBodyTextColor() est prévu pour être affiché dessus une vue en background getRgb()
                textVibrant.setTextColor(vibrant.getBodyTextColor());
            }
        }
        {
            Palette.Swatch vibrantDark = palette.getDarkVibrantSwatch();
            if (vibrantDark != null) {
                textVibrantDark.setBackgroundColor(vibrantDark.getRgb());
                textVibrantDark.setTextColor(vibrantDark.getBodyTextColor());
            }
        }
        {
            Palette.Swatch vibrantLight = palette.getLightVibrantSwatch();
            if (vibrantLight != null) {
                textVibrantLight.setBackgroundColor(vibrantLight.getRgb());
                textVibrantLight.setTextColor(vibrantLight.getBodyTextColor());
            }
        }

        {
            Palette.Swatch muted = palette.getMutedSwatch();
            if (muted != null) {
                textMuted.setBackgroundColor(muted.getRgb());
                textMuted.setTextColor(muted.getBodyTextColor());
            }
        }
        {
            Palette.Swatch mutedDark = palette.getDarkMutedSwatch();
            if (mutedDark != null) {
                textMutedDark.setBackgroundColor(mutedDark.getRgb());
                textMutedDark.setTextColor(mutedDark.getBodyTextColor());
            }
        }
        {
            Palette.Swatch lightMuted = palette.getLightMutedSwatch();
            if (lightMuted != null) {
                textMutedLight.setBackgroundColor(lightMuted.getRgb());
                textMutedLight.setTextColor(lightMuted.getBodyTextColor());
            }
        }
    }
}
