package dev.android.com.recyclerviewgettype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by user on 7/25/2016.
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_CHILD = 1;
    private static final int TYPE_HEADER = 2;
    private LayoutInflater inflater = null;
    private Context context = null;

    public RecyclerviewAdapter(Context context, List<String> names) {
        this.names = names;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    private List<String> names = null;


    class ViewHolderHeader extends RecyclerView.ViewHolder {
        TextView groupTV;

        public ViewHolderHeader(View itemView) {
            super(itemView);
            groupTV = (TextView) itemView.findViewById(R.id.headerTV);
        }
    }

    class ViewHolderChild extends RecyclerView.ViewHolder {
        TextView childTV;

        public ViewHolderChild(View itemView) {
            super(itemView);
            childTV = (TextView) itemView.findViewById(R.id.childTV);
        }
    }

    @Override
    public int getItemViewType(int position) {
        // here your custom logic to choose the view type
        return position == 0 ? TYPE_CHILD : TYPE_HEADER;
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPE_HEADER:
                itemView = inflater.inflate(R.layout.view_header, parent, false);
                holder = new ViewHolderHeader(itemView);
                break;
            case TYPE_CHILD:
                itemView = inflater.inflate(R.layout.view_child, parent, false);
                holder = new ViewHolderChild(itemView);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_CHILD:
                ViewHolderChild imageViewHolder = (ViewHolderChild) holder;
                imageViewHolder.childTV.setText(names.get(position));
                break;
            case TYPE_HEADER:
                ViewHolderHeader groupViewHolder = (ViewHolderHeader) holder;
                groupViewHolder.groupTV.setText(names.get(position));
                break;
        }
    }
}
