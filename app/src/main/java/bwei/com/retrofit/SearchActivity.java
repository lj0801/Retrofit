package bwei.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recycler_search;
    private EditText edit_search_text;
    private    int   page=1,count=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //初始化控件
        createinit();
    }

    private void createinit() {

        recycler_search = findViewById(R.id.recycler_search);
        edit_search_text = findViewById(R.id.edit_search_text);

    }

    public   void     search_click(View  view){




    }



}
