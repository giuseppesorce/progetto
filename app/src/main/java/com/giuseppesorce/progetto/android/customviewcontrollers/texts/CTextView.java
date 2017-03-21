package com.giuseppesorce.progetto.android.customviewcontrollers.texts;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.giuseppesorce.progetto.R;


/**
 * @author Giuseppe Sorce
 */
public class CTextView extends AppCompatTextView {

    protected String font = "";

    public CTextView(Context context) {
        super(context);
    }

    public CTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            TypedArray styles_array = context.obtainStyledAttributes(attrs,
                    R.styleable.CTextView);
            try {
                font = styles_array.getString(R.styleable.CTextView_font);
            } finally {
                styles_array.recycle();
            }
        }
        setFont();

    }


    public CTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            TypedArray styles_array = context.obtainStyledAttributes(attrs,
                    R.styleable.CTextView);
            try {
                font = styles_array.getString(R.styleable.CTextView_font);
            } finally {
                styles_array.recycle();
            }
        }
        setFont();

    }


    /**
     * Set custom font
     *
     * @param f type font
     */
    @SuppressWarnings("SameParameterValue")
    public void setFont(String f) {
        font = f;
        setFont();
    }

    protected void setFont() {

        if (!(font != null && font.length() > 0)) {
            font = "roboto";
        }
        switch (font) {



            case "roboto":
                UtilFont.setTypeface(this, "Roboto-Regular.ttf");
                break;
            case "blackitalic":
                UtilFont.setTypeface(this, "Roboto-BlackItalic.ttf");
                break;
            case "bold":
                UtilFont.setTypeface(this, "Roboto-Bold.ttf");
                break;
            case "bolditalic":
                UtilFont.setTypeface(this, "Roboto-BoldItalic.ttf");
                break;
            case "light":
                UtilFont.setTypeface(this, "Roboto-Light.ttf");
                break;
            case "lightitalic":
                UtilFont.setTypeface(this, "Roboto-LightItalic.ttf");
                break;
            case "medium":
                UtilFont.setTypeface(this, "Roboto-Medium.ttf");
                break;
            case "mediumitalic":
                UtilFont.setTypeface(this, "Roboto-MediumItalic.ttf");
                break;
            case "thin":
                UtilFont.setTypeface(this, "Roboto-Thin.ttf");
                break;
            case "thinitalic":
                UtilFont.setTypeface(this, "Roboto-ThinItalic.ttf");
                break;
        }

    }

    /**
     * Change font and style programmatically
     *
     * @param fontchange type font
     * @param style bold,italic
     */
    public void changeFontStyle(String fontchange, int style) {

        if (fontchange.length() > 0) {
            font = fontchange;
        }
        Typeface typeFace = UtilFont.getTypeFace(getContext(), font);
        if(typeFace !=null) {
            this.setTypeface(UtilFont.getTypeFace(getContext(), font),
                    style >= 0 ? style : typeFace.getStyle());
        }

    }
}
