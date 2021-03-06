package com.example.userapplication.UI.mainview.activity;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.List;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.userapplication.R;
        import com.example.userapplication.UI.mainview.data.Selldata;

public class SellAdapter extends RecyclerView.Adapter<SellAdapter.SellViewHolder> {

    private List<Selldata> list=new ArrayList<>();

    public SellAdapter(List<Selldata> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SellAdapter.SellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(R.layout.selldata_layout,parent,false);
        SellAdapter.SellViewHolder viewHolder = new SellAdapter.SellViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SellViewHolder holder, int position) {
        holder.textView_date.setText(list.get(position).getOrderedDate());
        holder.textView_number.setText(String.valueOf(list.get(position).getOrderNum()));
        holder.textView_price.setText(String.valueOf(list.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return (list!=null ? list.size() : 0);
    }

    public class SellViewHolder extends RecyclerView.ViewHolder {
        TextView textView_number;
        TextView textView_price;
        TextView textView_date;

        public SellViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView_date=itemView.findViewById(R.id.textview_date);
            this.textView_number=itemView.findViewById(R.id.textview_number);
            this.textView_price=itemView.findViewById(R.id.textview_price);
        }
    }
}
