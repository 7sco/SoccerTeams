package com.example.franciscoandrade.soccerteams.presentation.featureScrollView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.team.TeamProfile;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private RecyclerView parentRecycler;
    private List<TeamProfile.Players> data = new ArrayList<>();



    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        parentRecycler = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_player_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeamProfile.Players players=data.get(position);


        if (players.getName().toLowerCase().contains("keylo")){
            holder.image.setImageResource(R.drawable.keylor_head);
        }

        if (players.getName().toLowerCase().contains("carvajal,")){
            holder.image.setImageResource(R.drawable.catvajal_head);
        }

        if (players.getName().toLowerCase().contains("jesus")){
            holder.image.setImageResource(R.drawable.vallejo_head);
        }


        if (players.getName().toLowerCase().contains("sergio")){
            holder.image.setImageResource(R.drawable.ramos_head);
        }
        if (players.getName().toLowerCase().contains("raphael")){
            holder.image.setImageResource(R.drawable.varane_head);
        }
        if (players.getName().toLowerCase().contains("nacho")){
            holder.image.setImageResource(R.drawable.nacho_head);
        }

        if (players.getName().toLowerCase().contains("ronaldo")){
            holder.image.setImageResource(R.drawable.cristiano_head);
        }

        if (players.getName().toLowerCase().contains("toni")){
            holder.image.setImageResource(R.drawable.kross_head);
        }

        if (players.getName().toLowerCase().contains("karim")){
            holder.image.setImageResource(R.drawable.benzema_head);
        }
        if (players.getName().toLowerCase().contains("luka")){
            holder.image.setImageResource(R.drawable.modric_head);
        }

        if (players.getName().toLowerCase().contains("gareth")){
            holder.image.setImageResource(R.drawable.bale_head);
        }

        if (players.getName().toLowerCase().contains("marcelo")){
            holder.image.setImageResource(R.drawable.marcelo_head);
        }
        if (players.getName().toLowerCase().contains("kiko")){
            holder.image.setImageResource(R.drawable.casilla_head);
        }
        if (players.getName().toLowerCase().contains("casemiro")){
            holder.image.setImageResource(R.drawable.casemiro_head);
        }

        if (players.getName().toLowerCase().contains("theo")){
            holder.image.setImageResource(R.drawable.theo_head);
        }

        if (players.getName().toLowerCase().contains("lucas")){
            holder.image.setImageResource(R.drawable.lucas_head);
        }

        if (players.getName().toLowerCase().contains("marcos")){
            holder.image.setImageResource(R.drawable.llorente_head);
        }
        if (players.getName().toLowerCase().contains("achraf")){
            holder.image.setImageResource(R.drawable.achraf_head);
        }
        if (players.getName().toLowerCase().contains("marco")){
            holder.image.setImageResource(R.drawable.asensio_head);
        }
        if (players.getName().toLowerCase().contains("borja")){
            holder.image.setImageResource(R.drawable.mayoral_head);
        }
        if (players.getName().toLowerCase().contains("isco")){
            holder.image.setImageResource(R.drawable.isco_head);
        }
        if (players.getName().toLowerCase().contains("mateo")){
            holder.image.setImageResource(R.drawable.kovacic_head);
        }
        if (players.getName().toLowerCase().contains("dani")){
            holder.image.setImageResource(R.drawable.cevallos_head);
        }
        if (players.getName().toLowerCase().contains("zidane")){
            holder.image.setImageResource(R.drawable.zidane_head);
        }


        holder.name.setText(players.getName());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addMovies(List<TeamProfile.Players> rootObject) {
        data.addAll(rootObject);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.image_head)
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        public void showText() {
            int parentHeight = ((View) image.getParent()).getHeight();
            float scale = (parentHeight - name.getHeight()) / (float) image.getHeight();
            image.setPivotX(image.getWidth() * 0.5f);
            image.setPivotY(0);
            image.animate().scaleX(scale)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            name.setVisibility(View.VISIBLE);
                            //imageView.setColorFilter(Color.BLACK);
                        }
                    })
                    .scaleY(scale).setDuration(200)
                    .start();
        }

        public void hideText() {
            //imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.grayIconTint));
            name.setVisibility(View.INVISIBLE);
            name.animate().scaleX(1f).scaleY(1f)
                    .setDuration(200)
                    .start();
        }

        @Override
        public void onClick(View v) {
            parentRecycler.smoothScrollToPosition(getAdapterPosition());
        }
    }




}
