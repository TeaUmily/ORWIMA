package hr.ferit.tumiljanovic.osnoverwima_lv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnImageClickListener {


    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.description_edittext)
    EditText etDescription;

    @BindView(R.id.edit_description_button)
    Button btnEditDescription;

    @BindView(R.id.first_person_checkbox)
    CheckBox cbFirstPerson;

    @BindView(R.id.secon_person_checkbox)
    CheckBox cbSecondPerson;

    @BindView(R.id.third_person_checkbox)
    CheckBox cbThirdPerson;

    private RecyclerAdapter adapter = new RecyclerAdapter();
    private List<Person> bestPersons = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecorator(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnImageClickListener(this);

        setView();

    }

    private void setView() {


        bestPersons.add(new Person("Nikola",
                "Tesla",
                1856,
                1943,
                "Nikola Tesla was an engineer known for designing the alternating-current (AC) electric system, which is still the predominant electrical system used across the world today. He also created the \"Tesla coil,\" which is still used in radio technology. ",
                R.drawable.nikola, "“I do not think you can name many great inventions that have been made by married men. NIKOLA TESLA” "));

        bestPersons.add(new Person("Albert",
                "Einstein",
                1879,
                1955,
                "Albert Einstein was a German mathematician and physicist who developed the special and general theories of relativity. In 1921, he won the Nobel Prize for physics for his explanation of the photoelectric effect.",
                R.drawable.einstein, "The difference between stupidity and genius is that genius has its limits. ALBERT EINSTEIN"));

        bestPersons.add(new Person("Isaac",
                "Newton",
                1643,
                1727,
                "Isaac Newton was a physicist and mathematician who developed the principles of modern physics, including the laws of motion, and is credited as one of the great minds of the 17th century Scientific Revolution.",
                R.drawable.isaac, "We build too many walls and not enough bridges. ISAAC NEWTON"));

        adapter.addItems(bestPersons);

    }

    @OnClick(R.id.inspiration_button)
    void OnInspirationBtnClick() {
        Random rn = new Random();
        int randomNum = rn.nextInt(2);

        switch (randomNum) {
            case 0:
                Toast.makeText(this, bestPersons.get(0).getQuote(), Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, bestPersons.get(1).getQuote(), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, bestPersons.get(2).getQuote(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @OnClick(R.id.edit_description_button)
    void OnEditDescriptionBtnClick() {

        if (cbFirstPerson.isChecked()) {
            bestPersons.get(0).setDescription(etDescription.getText().toString());
        }
        if (cbSecondPerson.isChecked()) {
            bestPersons.get(1).setDescription(etDescription.getText().toString());
        }
        if (cbThirdPerson.isChecked()) {
            bestPersons.get(2).setDescription(etDescription.getText().toString());
        }

        adapter.addItems(bestPersons);

    }

    @Override
    public void OnClick(int position) {
        bestPersons.get(position).setImage(0);
        adapter.addItems(bestPersons);
    }
}
