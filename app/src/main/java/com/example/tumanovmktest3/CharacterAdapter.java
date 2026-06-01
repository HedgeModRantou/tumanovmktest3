package com.example.tumanovmktest3;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<CharacterModel> characters;

    public CharacterAdapter(List<CharacterModel> characters) {
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CharacterModel character = characters.get(position);
        holder.nameTextView.setText(character.getName());
        holder.pathTextView.setText("Путь: " + character.getPath());

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(character.getColor());
        holder.pathIcon.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pathIcon;
        TextView nameTextView;
        TextView pathTextView;

        ViewHolder(View view) {
            super(view);
            pathIcon = view.findViewById(R.id.pathIcon);
            nameTextView = view.findViewById(R.id.characterName);
            pathTextView = view.findViewById(R.id.characterPath);
        }
    }
}
