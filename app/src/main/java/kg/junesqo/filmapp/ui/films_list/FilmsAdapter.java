package kg.junesqo.filmapp.ui.films_list;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kg.junesqo.filmapp.R;
import kg.junesqo.filmapp.data.models.Film;
import kg.junesqo.filmapp.databinding.ItemFilmBinding;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmViewHolder> {


    private List<Film> films = new ArrayList<>();

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(films.get(position));
        Bundle bundle = new Bundle();
        bundle.putString("filmId", films.get(position).getId());
        holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_filmsFragment_to_filmDetailFragment, bundle));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putString("filmId", films.get(position).getId());
//                Navigation.createNavigateOnClickListener(R.id.action_filmsFragment_to_filmDetailFragment, bundle);
//                Log.e("FilmAdapter", films.get(position).getId());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected class FilmViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public FilmViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());
            Glide.with(binding.ivBanner).load(film.getMovieBanner()).into(binding.ivBanner);
        }
    }
}
