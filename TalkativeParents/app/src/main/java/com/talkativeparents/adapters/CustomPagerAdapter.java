package com.talkativeparents.adapters;

/**
 * Created by Raghunandan on 12-02-2016.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.talkativeparents.R;

/**
 * Created by Raghunandan on 28-01-2016.
 */
public class CustomPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    String[] mResources = {
            "The world's first communication app dedicated to the parents of school going kids",
            "Parents. Get Involved and be a part of your child's classroom",
            "Connect effortlessly with other parents whose children share a classroom with your child",
            "Your personal contact information is secure and will not be shared with any other user",
            "Take Control of the safety and security of your child. welcome to the parental social network",

    };

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        TextView textView = (TextView) itemView.findViewById(R.id.textView);
        textView.setText(mResources[position]);
        /*ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        Glide.with(mContext).load(mResources[position]).centerCrop().into(imageView);*/

        //imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}