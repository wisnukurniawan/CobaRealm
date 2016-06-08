package com.wisnu.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisnu.myapplication.R;
import com.wisnu.myapplication.model.User;
import com.wisnu.myapplication.realm.RealmController;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by private on 05/06/2016.
 */
public class UsersAdapter extends RealmRecyclerViewAdapater<User> {
    final Context context;
    private Realm realm;

    public UsersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {

        realm = RealmController.getInstance().getRealm();
        final User user = getItem(position);
        final CardViewHolder holder = (CardViewHolder) viewHolder;

        holder.textNama.setText(user.getNama());
        holder.textNoHp.setText(user.getNoHp());
        holder.textDaerah.setText(user.getDaerah());
        holder.textKeahlian.setText(user.getAhli());
        holder.textNoHp.setText(user.getNoHp());
    }

    @Override
    public int getItemCount() {
        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public CardView card;
        public TextView textNama;
        public TextView textKeahlian;
        public TextView textDaerah;
        public TextView textNoHp;
        public CardViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.card_tukang);
            textNama = (TextView) itemView.findViewById(R.id.nama_tukang);
            textKeahlian = (TextView) itemView.findViewById(R.id.keahlian);
            textDaerah = (TextView) itemView.findViewById(R.id.daerah);
            textNoHp = (TextView) itemView.findViewById(R.id.no_tlp);
        }
    }
}
