package com.github.florent37.picassopalette;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.v4.util.Pair;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by florentchampigny on 08/05/15.
 */
public class PicassoPalette extends BitmapPalette implements Target, Callback {

    protected Callback callback;
    private ImageView imageView;

    protected PicassoPalette() {
    }

    public static PicassoPalette with(String url, ImageView imageView) {
        PicassoPalette picassoPalette = new PicassoPalette();
        picassoPalette.url = url;
        picassoPalette.imageView = imageView;
        return picassoPalette;
    }

    public PicassoPalette use(@Profile.PaletteProfile int paletteProfile) {
        super.use(paletteProfile);
        return this;
    }

    public PicassoPalette intoBackground(View view) {
        return this.intoBackground(view, Swatch.RGB);
    }

    public PicassoPalette intoBackground(View view, @Swatch.PaletteSwatch int paletteSwatch) {
        super.intoBackground(view, paletteSwatch);
        return this;
    }

    public PicassoPalette intoTextColor(TextView textView) {
        return this.intoTextColor(textView, Swatch.TITLE_TEXT_COLOR);
    }

    public PicassoPalette intoTextColor(TextView textView, @Swatch.PaletteSwatch int paletteSwatch) {
        super.intoTextColor(textView, paletteSwatch);
        return this;
    }

    public PicassoPalette setGlideListener(Callback callback) {
        this.callback = callback;
        return this;
    }

    public PicassoPalette intoCallBack(PicassoPalette.CallBack callBack) {
        super.intoCallBack(callBack);
        return this;
    }

    //region Picasso.TARGET

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        start(bitmap);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }

    @Override
    public void onSuccess() {
        if(this.callback != null)
            this.callback.onSuccess();
        Bitmap bitmap = ((BitmapDrawable) this.imageView.getDrawable()).getBitmap();
        onBitmapLoaded(bitmap, null);
    }

    @Override
    public void onError() {
        if(this.callback != null)
            this.callback.onError();
    }

    //endregion

}
