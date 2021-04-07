package com.zedan.acare.supervisor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.firebase.FirebaseNetworkException;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.extension.ViewExtension;

public final class ErrorView extends FrameLayout {
    private AppCompatImageView imageError;
    private TextView messageText;
    private Button retryBtn;

    public ErrorView(Context context) {
        super(context);
        init(context);
    }

    public ErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        View inflate = LayoutInflater.from(context).inflate(R.layout.error_view, this, true);
        this.imageError = inflate.findViewById(R.id.image_error);
        this.messageText = inflate.findViewById(R.id.error_message);
        this.retryBtn = inflate.findViewById(R.id.retry_btn);
    }


    public final void error(Throwable throwable, RetryListener retry) {
        setRetry(retry);
        setStatus(throwable);
    }

    public final void setStatus(@Nullable Throwable throwable) {
        if (throwable == null)
            setVisibility(View.GONE);
        else {
            setTextError(throwable);
            setVisibility(View.VISIBLE);
        }
    }

    public final void setRetry(RetryListener retry) {
        this.retryBtn.setOnClickListener(v -> retry.onRetry());
    }

    private void setTextError(Throwable throwable) {
        if (throwable instanceof FirebaseNetworkException) {
            this.imageError.setImageResource(R.drawable.ic_no_connection);
            this.messageText.setText(getContext().getString(R.string.error_connection));

            ViewExtension.show(this.messageText);
            return;
        }
        ViewExtension.hide(this.messageText);
        this.imageError.setImageResource(R.drawable.ic_no_connection);
    }

}
