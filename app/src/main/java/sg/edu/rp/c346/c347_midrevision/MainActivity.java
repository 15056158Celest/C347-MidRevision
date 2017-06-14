package sg.edu.rp.c346.c347_midrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnShow;
    TextView tvResult;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList <String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) this.findViewById(R.id.btnAdd);
        btnShow = (Button) this.findViewById(R.id.btnShow);
        tvResult = (TextView) this.findViewById(R.id.tvResult);
        lv = (ListView) this.findViewById(R.id.lv);

        al = new ArrayList<>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dh = new DBHelper(MainActivity.this);
                dh.insertContact("Jack", "Male", 1.69);
                dh.close();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dh = new DBHelper(MainActivity.this);
                ArrayList<String> al = dh.getContactContentSQL();
                //Log.d("ArrayList obj", al + "");
                String data = "";
                for (int i = 0; i < al.size(); i++) {
                    Log.d("Al content", al.get(i));
                    data += al.get(i) + "\n";
                }
                tvResult.setText(data);

                al.clear();
                al.addAll(al);
                aa.notifyDataSetChanged();
                dh.close();
            }
        });

    }

}