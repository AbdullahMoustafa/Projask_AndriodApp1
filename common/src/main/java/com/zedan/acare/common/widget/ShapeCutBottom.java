package com.zedan.acare.common.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;

import androidx.annotation.Nullable;

public final class ShapeCutBottom extends Shape {

    private final Paint paint = new Paint();
    private final Path path = new Path();

    public ShapeCutBottom(int color) {
        this.paint.setColor(color);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void onResize(float width, float height) {
        super.onResize(width, height);
        float section = height / ((float) 4);
        this.path.reset();
        this.path.moveTo(0.0f, 0.0f);
        this.path.lineTo(width, 0.0f);
        this.path.lineTo(width, height - section);
        this.path.lineTo(width / ((float) 2), height);
        this.path.lineTo(0.0f, height - section);
        this.path.close();
    }

    public void draw(@Nullable Canvas canvas, @Nullable Paint paint2) {
        if (canvas != null) {
            canvas.drawPath(this.path, this.paint);
        }
    }
}

