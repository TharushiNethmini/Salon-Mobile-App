package com.example.spakler.adapter_class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.spakler.R;


public class OnboardSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public OnboardSliderAdapter(Context context) {
        this.context = context;
    }

    //arrays for to load the images to slider
    public int[] slider_images = {
            R.drawable.logo,
            R.drawable.saloan3,
            R.drawable.saloan2,
    };

    public String[] slider_headings = {
            "",
            "Adorable Haircuts",
            "Easy  Appointment",
    };

    public String[] slider_des = {
            "Hi Beautiful !\n We are so excited to \nhave you in \nSALON SPARKLE . . . ",
            "The right hairstyle can make a plain woman beautiful \nAND\n a beautiful woman unforgettable.",
            "If you make more appointments with quality people,\n you will have less disappointments with \nnon-quality people.",
    };

    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout_view, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView headingText = (TextView) view.findViewById(R.id.heading_text);
        TextView desText = (TextView) view.findViewById(R.id.description_text);

        imageView.setImageResource(slider_images[position]);
        headingText.setText(slider_headings[position]);
        desText.setText(slider_des[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
