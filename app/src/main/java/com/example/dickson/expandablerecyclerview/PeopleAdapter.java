package com.example.dickson.expandablerecyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.innodroid.expandablerecycler.ExpandableRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends ExpandableRecyclerAdapter<PeopleAdapter.PeopleListItem> {
    public static final int TYPE_PERSON = 1001;

    public PeopleAdapter(Context context) {
        super(context);

        setItems(getSampleItems());
    }

    public static class PeopleListItem extends ExpandableRecyclerAdapter.ListItem {
        public String Text;

        public PeopleListItem(String group) {
            super(TYPE_HEADER);

            Text = group;
        }

        public PeopleListItem(String first, String last) {
            super(TYPE_PERSON);

            Text = first + " " + last;
        }
    }

    public class HeaderViewHolder extends ExpandableRecyclerAdapter.HeaderViewHolder {
        TextView name;

        public HeaderViewHolder(View view) {
            super(view, (ImageView) view.findViewById(R.id.item_arrow));

            name = (TextView) view.findViewById(R.id.item_header_name);
        }

        public void bind(int position) {
            super.bind(position);

            name.setText(visibleItems.get(position).Text);
        }
    }

    public class PersonViewHolder extends ExpandableRecyclerAdapter.ViewHolder {
        TextView name;

        public PersonViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.item_name);
        }

        public void bind(int position) {
            name.setText(visibleItems.get(position).Text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return new HeaderViewHolder(inflate(R.layout.item_header, parent));
            case TYPE_PERSON:
            default:
                return new PersonViewHolder(inflate(R.layout.item_person, parent));
        }
    }

    @Override
    public void onBindViewHolder(ExpandableRecyclerAdapter.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                ((HeaderViewHolder) holder).bind(position);
                break;
            case TYPE_PERSON:
            default:
                ((PersonViewHolder) holder).bind(position);
                break;
        }
    }

    private List<PeopleListItem> getSampleItems() {
        List<PeopleListItem> items = new ArrayList<>();

        items.add(new PeopleListItem("Productinformatie"));
        items.add(new PeopleListItem("Beschrijving", "Runder Hamburger naturel, 110 gram. 3st."));
        items.add(new PeopleListItem("Bereidingswijze", "Bakken: ca. 6 - 8 min. Barbecue / Grill: ca. 6 - 8 min."));
        items.add(new PeopleListItem("Frank", "Hall"));
        items.add(new PeopleListItem("Sue", "West"));
        items.add(new PeopleListItem("Sue", "West"));

        items.add(new PeopleListItem("Ingrediënten"));
        items.add(new PeopleListItem("Beschrijving", "Runder Hamburger naturel, 110 gram. 3st."));
        items.add(new PeopleListItem("Bereidingswijze", "Bakken: ca. 6 - 8 min. Barbecue / Grill: ca. 6 - 8 min."));
        items.add(new PeopleListItem("Alex", "Hall"));

        items.add(new PeopleListItem("Voedingswaarden"));
        items.add(new PeopleListItem("Beschrijving", "Runder Hamburger naturel, 110 gram. 3st."));
        items.add(new PeopleListItem("Bereidingswijze", "Bakken: ca. 6 - 8 min. Barbecue / Grill: ca. 6 - 8 min."));
        items.add(new PeopleListItem("Jane", "Hall"));
        items.add(new PeopleListItem("Tim", "Lake"));

        items.add(new PeopleListItem("Overige informatie"));
        items.add(new PeopleListItem("Beschrijving", "Runder Hamburger naturel, 110 gram. 3st."));
        items.add(new PeopleListItem("Bereidingswijze", "Bakken: ca. 6 - 8 min. Barbecue / Grill: ca. 6 - 8 min."));
        items.add(new PeopleListItem("Kristin", "Hall"));
        items.add(new PeopleListItem("Pete", "Lake"));

        return items;
    }
}
