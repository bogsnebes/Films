package com.bogsnebes.mtstetajava.ui.movie_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bogsnebes.mtstetajava.R;
import com.bogsnebes.mtstetajava.data.dto.MovieDto;
import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private final Context context;
    private final List<MovieDto> listItems;

    public MoviesAdapter(Context context, List<MovieDto> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ViewHolder(inflater.inflate(R.layout.item_movie, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        holder.bind(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title = itemView.findViewById(R.id.tvMovieTitle);
        private final TextView description = itemView.findViewById(R.id.tvMovieDescription);
        private final TextView age = itemView.findViewById(R.id.tvAge);
        private final ImageView image = itemView.findViewById(R.id.ivMovie);
        private final List<ImageView> stars = Arrays.asList(
                itemView.findViewById(R.id.star_1),
                itemView.findViewById(R.id.ivStar_2),
                itemView.findViewById(R.id.ivStar_3),
                itemView.findViewById(R.id.ivStar_4),
                itemView.findViewById(R.id.ivStar_5)
        );

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        void bind(MovieDto listItem) {
            title.setText(listItem.title);
            description.setText(listItem.description);
            if (listItem.ageRestriction) {
                age.setText("18+");
            } else {
                age.setText("0+");
            }
            Glide.with(itemView).load(listItem.imageUrl).into(image);

            for (int i = 0; i < Math.round(listItem.rateScore); i++) {
                Glide.with(itemView).load(R.drawable.ic_fill_star).into(stars.get(i));
            }
            for (int i = Math.round(listItem.rateScore); i < 5; i++) {
                Glide.with(itemView).load(R.drawable.ic_empty_star).into(stars.get(i));
            }
        }
    }
}
