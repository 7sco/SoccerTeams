package com.example.franciscoandrade.soccerteams.presentation.featureScrollView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.team.TeamProfile;

import com.example.franciscoandrade.soccerteams.presentation.PlayersListHead;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropTransformation;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private RecyclerView parentRecycler;
    private List<TeamProfile.Players> data = new ArrayList<>();
    PlayersListHead playersListHead= new PlayersListHead();
    String urlS= "https://www.Realmadrid.com";

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
        holder.name.setText(players.getName());
        String playerUrl = playersListHead.headList.get(players.getJerseyNumber());
        String url =urlS+playerUrl;
        Picasso.get()
            .load(url)
            .error(R.drawable.realmadridshield)
            .transform(new CropTransformation(300, 250, CropTransformation.GravityHorizontal.CENTER,
                CropTransformation.GravityVertical.TOP))
            .into(holder.image);
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
