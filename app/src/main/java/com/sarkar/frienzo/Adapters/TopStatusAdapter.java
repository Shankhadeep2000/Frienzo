package com.sarkar.frienzo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.sarkar.frienzo.Activities.MainActivity;
import com.sarkar.frienzo.Models.Status;
import com.sarkar.frienzo.Models.UserStatus;
import com.sarkar.frienzo.R;
import com.sarkar.frienzo.databinding.ItemStatusBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import omari.hamza.storyview.StoryView;
import omari.hamza.storyview.callback.StoryClickListeners;
import omari.hamza.storyview.model.MyStory;

public class TopStatusAdapter extends RecyclerView.Adapter<TopStatusAdapter.TopStatusViewHolder>  {

    Context context;
    ArrayList<UserStatus> userStatuses;

    public TopStatusAdapter(Context context, ArrayList<UserStatus> userStatuses) {
        this.context = context;
        this.userStatuses = userStatuses;
    }

    @NonNull
    @NotNull
    @Override
    public TopStatusAdapter.TopStatusViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.item_status, parent, false);
        return new TopStatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopStatusAdapter.TopStatusViewHolder holder, int position) {
        UserStatus userStatus = userStatuses.get(position);

        Status lastStatus = userStatus.getStatuses().get(userStatus.getStatuses().size() - 1);

        Glide.with(context).load(lastStatus.getImageUrl()).into(holder.binding.image);

        holder.binding.circularStatusView.setPortionsCount(userStatus.getStatuses().size());
        holder.binding.circularStatusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MyStory> myStories = new ArrayList<>();
                for(Status status : userStatus.getStatuses()) {
                    myStories.add(new MyStory(status.getImageUrl()));
                }
                new StoryView.Builder(((MainActivity)context).getSupportFragmentManager())
                        .setStoriesList(myStories) // Required
                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                        .setTitleText(userStatus.getName()) // Default is Hidden
                        .setSubtitleText("") // Default is Hidden
                        .setTitleLogoUrl(userStatus.getProfileImage()) // Default is Hidden
                        .setStoryClickListeners(new StoryClickListeners() {
                            @Override
                            public void onDescriptionClickListener(int position) {

                            }

                            @Override
                            public void onTitleIconClickListener(int position) {

                            }
                        }).build()
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userStatuses.size();
    }
    public class TopStatusViewHolder extends RecyclerView.ViewHolder {

        ItemStatusBinding binding;

        public TopStatusViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemStatusBinding.bind(itemView);
        }
    }
}
