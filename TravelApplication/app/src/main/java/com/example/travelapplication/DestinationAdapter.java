package com.example.travelapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DestinationAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Destination> arrayList;

    public DestinationAdapter(Context context, int layout, List<Destination> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size(); //tra ve so luong item
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        Destination destination = arrayList.get(i);//tra ve vi tri arraylist

        //anh xa
        TextView tvName = view.findViewById(R.id.textviewName);
        TextView tvNameProvince = view.findViewById(R.id.textviewNameProvince);
        TextView tvPrice = view.findViewById(R.id.textviewPrice);
        ImageView ivPicture = view.findViewById(R.id.imageViewPicture);

        tvName.setText(destination.getName());
        tvNameProvince.setText(destination.getNameProvince());
        tvPrice.setText(destination.getPrice());
        ivPicture.setImageResource(destination.getPicture());
        return view;
    }
}
