package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventDetails;
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview;

import java.util.ArrayList;

public class ViewPagerAdapterGalleryViewEvents extends PagerAdapter {

    private Context context;
    private ArrayList<EventDetails.Alleventsdata.Gallerydata> sliderImg;


    public ViewPagerAdapterGalleryViewEvents(ArrayList<EventDetails.Alleventsdata.Gallerydata> sliderImg, Context context) {
        this.sliderImg = sliderImg;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderImg.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dialog_image_layout, null);
        PhotoView imageView = (PhotoView) view.findViewById(R.id.imageView2);
        Glide.with(context).load(sliderImg.get(position).getImages()).into(imageView);
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }


}
