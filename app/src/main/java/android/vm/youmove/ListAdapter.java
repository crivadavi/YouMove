package android.vm.youmove;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Davide on 27/01/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<ElementList> dataSet = new ArrayList<>();

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ListViewHolder holder = new ListViewHolder(v);

        return holder ;
    }

    @Override
    public void onBindViewHolder(ListAdapter.ListViewHolder holder, int position) {
        ElementList currentElementList = dataSet.get(position);

        holder.itemNameTv.setText(currentElementList.getNome());
        holder.itemDescTv.setText(currentElementList.getDescrizione());
    }

    public void setData(ArrayList<ElementList> elements){
        dataSet = elements;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    protected class ListViewHolder extends RecyclerView.ViewHolder {

        TextView itemNameTv;
        TextView itemDescTv;

        public ListViewHolder(final View v) {
            super(v);
            itemNameTv = (TextView) v.findViewById(R.id.item_name);
            itemDescTv = (TextView) v.findViewById(R.id.item_desc);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //crea una barra nera in basso che suggerisce l'elemento che è stato selezionato
                    Toast.makeText(v.getContext(), "Nome Studente: " + dataSet.get(getAdapterPosition()).getNome(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
