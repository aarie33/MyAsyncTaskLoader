package arie.myasynctaskloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {
    private ArrayList<WeatherItems> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context context;

    public WeatherAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void setData(ArrayList<WeatherItems> items){
        mData = items;
        notifyDataSetChanged();
    }
    public void addItem(final WeatherItems item) {
        mData.add(item);
        notifyDataSetChanged();
    }
    public void clearData(){
        mData.clear();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        if (mData == null) return 0;
        return mData.size();
    }

    @Override
    public WeatherItems getItem(int position) {
        return mData.get(position);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.weather_items, null);
            holder.textViewNamaKota= convertView.findViewById(R.id.textKota);
            holder.textViewTemperature = convertView.findViewById(R.id.textTemp);
            holder.textViewDescription = convertView.findViewById(R.id.textDesc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textViewNamaKota.setText(mData.get(i).getNama());
        holder.textViewTemperature.setText(mData.get(i).getTemperature());
        holder.textViewDescription.setText(mData.get(i).getDescription());
        return convertView;
    }
    private static class ViewHolder {
        TextView textViewNamaKota;
        TextView textViewTemperature;
        TextView textViewDescription;
    }
}
