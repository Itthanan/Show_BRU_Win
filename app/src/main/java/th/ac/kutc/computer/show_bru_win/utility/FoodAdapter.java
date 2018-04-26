package th.ac.kutc.computer.show_bru_win.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import th.ac.kutc.computer.show_bru_win.R;

public class FoodAdapter extends BaseAdapter{

    private Context context;
    private String[] imageStrings, fooodStrings, priceStrings, detailStrings;

    public FoodAdapter(Context context,
                       String[] imageStrings,
                       String[] fooodStrings,
                       String[] priceStrings,
                       String[] detailStrings) {
        this.context = context;
        this.imageStrings = imageStrings;
        this.fooodStrings = fooodStrings;
        this.priceStrings = priceStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return fooodStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_food, parent, false);

        TextView foodTextView = view.findViewById(R.id.txtFood);
        TextView priceTextView = view.findViewById(R.id.txtPrice);
        TextView detealTextView = view.findViewById(R.id.txtDetail);
        ImageView imageView = view.findViewById(R.id.imvFood);

        foodTextView.setText(fooodStrings[position]);
        priceTextView.setText(priceStrings[position]);
        detealTextView.setText(detailStrings[position]);

        Picasso.get().load(imageStrings[position]).into(imageView);


        return view;
    }
}
