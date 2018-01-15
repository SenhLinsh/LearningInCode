package com.linsh.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.linsh.code.text.spannable.LkCustomSpan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        LkCustomSpan lkCustomSpan = new LkCustomSpan();

        TextView textView = (TextView) view;
        SpannableString string = new SpannableString("Senh Linsh hehehe");
        string.setSpan(lkCustomSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(string);
        textView.setSelected(!textView.isSelected());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
