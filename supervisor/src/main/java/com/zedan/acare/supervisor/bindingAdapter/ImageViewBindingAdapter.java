package com.zedan.acare.supervisor.bindingAdapter;

import android.graphics.BitmapFactory;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.zedan.acare.supervisor.R;

import java.io.File;

public final class ImageViewBindingAdapter {

    @BindingAdapter("load")
    public static void loadImage(ImageView imageView, @Nullable String url){
        Glide
                .with(imageView)
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("loadProfile")
    public static void loadImageProfile(ImageView imageView, @Nullable String url){
        Glide
                .with(imageView)
                .load(url)
                .placeholder(R.drawable.ic_user)
                .error(R.drawable.ic_user)
                .into(imageView);
    }

    @BindingAdapter("setImageBitmap")
    public static void setImageBitmap(ImageView imageView, @Nullable File file){
        if (file == null)
            return;
        imageView.clearColorFilter();
        imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
    }


}
