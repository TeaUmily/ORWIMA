package hr.ferit.tumiljanovic.osnoverwima_lv1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class RecyclerAdapter extends RecyclerView.Adapter {


    private List<Person> dataList;
    private OnImageClickListener onImageClickListener;


    public RecyclerAdapter() {
        dataList = new ArrayList<Person>();
    }

    public void addItems(List<Person> items) {
        dataList.clear();
        dataList.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_person, viewGroup, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        final Person current = dataList.get(position);

        PersonViewHolder personHolder = (PersonViewHolder) viewHolder;
        personHolder.onBind(current);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }


    public class PersonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.textview_years)
        TextView years;

        @BindView(R.id.textview_description)
        TextView description;

        @BindView(R.id.ivImage)
        ImageView image;


        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(Person person) {

            image.setImageResource(person.getImage());
            description.setText(person.getDescription());
            years.setText(person.getYears());
            name.setText(person.getFullName());
        }


        @OnClick(R.id.ivImage)
        void OnImageClick() {
            image.setImageResource(0);
            onImageClickListener.OnClick(getAdapterPosition());
        }

    }


}
