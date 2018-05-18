package android.com.suchylascommuneguide;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SportsCustomAdapter {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTitle1;
        TextView descriptionSports1;

        ImageView pictureSports1;
        TextView descriptionSports2;


        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_menu_4, parent, false));
            nameTitle1 = itemView.findViewById(R.id.nameTitle1);
            descriptionSports1 = itemView.findViewById(R.id.descriptionSports1);
            pictureSports1 = itemView.findViewById(R.id.pictureSports1);
            descriptionSports2 = itemView.findViewById(R.id.descriptionSports2);
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 2;
        private final String[] mNameTitle1;
        private final String[] mDescriptionSports1;
        private final Drawable[] mPictureSports1;
        private final String[] mDescriptionSports2;


        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mNameTitle1 = resources.getStringArray(R.array.titles_sports);
            mDescriptionSports1 = resources.getStringArray(R.array.descriptions_sports1);

            TypedArray a = resources.obtainTypedArray(R.array.sports_pictures1);
            mPictureSports1 = new Drawable[a.length()];
            for (int i = 0; i < mPictureSports1.length; i++) {
                mPictureSports1[i] = a.getDrawable(i);
            }
            a.recycle();
            mDescriptionSports2 = resources.getStringArray(R.array.descriptions_sports2);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.nameTitle1.setText(mNameTitle1[position % mNameTitle1.length]);
            holder.descriptionSports1.setText(mDescriptionSports1[position % mDescriptionSports1.length]);
            holder.pictureSports1.setImageDrawable(mPictureSports1[position % mPictureSports1.length]);
            holder.descriptionSports2.setText(mDescriptionSports2[position % mDescriptionSports2.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
