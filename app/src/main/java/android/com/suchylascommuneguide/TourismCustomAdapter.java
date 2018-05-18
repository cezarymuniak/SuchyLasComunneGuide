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

public class TourismCustomAdapter {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTitle1;
        TextView descriptionTourism1;
        ImageView pictureTourism1;
        TextView descriptionTourism2;
        ImageView pictureTourism2;
        TextView descriptionTourism3;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_menu_2, parent, false));
            nameTitle1 = itemView.findViewById(R.id.nameTitle1);
            descriptionTourism1 = itemView.findViewById(R.id.descriptionTourism1);
            pictureTourism1 = itemView.findViewById(R.id.pictureTourism1);
            descriptionTourism2 = itemView.findViewById(R.id.descriptionTourism2);
            pictureTourism2 = itemView.findViewById(R.id.pictureTourism2);
            descriptionTourism3 = itemView.findViewById(R.id.descriptionTourism3);


        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 2;
        private final String[] mNameTitle1;
        private final String[] mDescriptionTourism1;
        private final Drawable[] mPictureTourism1;
        private final String[] mDescriptionTourism2;
        private final Drawable[] mPictureTourism2;
        private final String[] mDescriptionTourism3;


        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mNameTitle1 = resources.getStringArray(R.array.titles);
            mDescriptionTourism1 = resources.getStringArray(R.array.descriptions_tourism1);

            TypedArray a = resources.obtainTypedArray(R.array.tourism_pictures1);
            mPictureTourism1 = new Drawable[a.length()];
            for (int i = 0; i < mPictureTourism1.length; i++) {
                mPictureTourism1[i] = a.getDrawable(i);
            }
            a.recycle();

            mDescriptionTourism2 = resources.getStringArray(R.array.descriptions_tourism2);

            TypedArray b = resources.obtainTypedArray(R.array.tourism_pictures2);
            mPictureTourism2 = new Drawable[b.length()];
            for (int i = 0; i < mPictureTourism2.length; i++) {
                mPictureTourism2[i] = b.getDrawable(i);
            }
            b.recycle();

            mDescriptionTourism3 = resources.getStringArray(R.array.descriptions_tourism3);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.nameTitle1.setText(mNameTitle1[position % mNameTitle1.length]);
            holder.descriptionTourism1.setText(mDescriptionTourism1[position % mDescriptionTourism1.length]);
            holder.pictureTourism1.setImageDrawable(mPictureTourism1[position % mPictureTourism1.length]);
            holder.descriptionTourism2.setText(mDescriptionTourism2[position % mDescriptionTourism2.length]);
            holder.pictureTourism2.setImageDrawable(mPictureTourism2[position % mPictureTourism2.length]);
            holder.descriptionTourism3.setText(mDescriptionTourism3[position % mDescriptionTourism3.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}