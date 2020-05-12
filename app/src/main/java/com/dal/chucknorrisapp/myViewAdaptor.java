/* Reference:
Create a List with RecyclerView:Android Developers.(n.d.).Retrieved December 1, 2019,
   from https://developer.android.com/guide/topics/ui/layout/recyclerview.

HathibelagalHathibelagal, A.(2015, March 23).Getting Started With RecyclerView and CardView on Android.
    Retrieved December 1, 2019, from
    https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465.
*/

package com.dal.chucknorrisapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myViewAdaptor extends RecyclerView.Adapter<myViewAdaptor.ViewHolder> {

    private ArrayList<card> cardArrayList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int location) {
        card c = cardArrayList.get(location);

        viewHolder.imageView.setImageResource(c.getNorrisImage());
        viewHolder.textView.setText(c.getJoke());
    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    public myViewAdaptor(ArrayList<card> cardList) {
        cardArrayList = cardList;
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.norrisImage);
            textView = itemView.findViewById(R.id.factsText);
        }
    }
}
