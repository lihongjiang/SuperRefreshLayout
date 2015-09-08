package niorgai.qiu.superrefreshlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import niorgai.qiu.superrefreshlayout.refresh.SuperRefreshLayout;
import niorgai.qiu.superrefreshlayout.test.ListAdapter;

public class MainActivity extends AppCompatActivity implements SuperRefreshLayout.SwipeListener{
    private SuperRefreshLayout refreshLayout;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        refreshLayout = (SuperRefreshLayout) findViewById(R.id.refresh_layout);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ListAdapter(this));
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void refreshFromStart() {
        Toast.makeText(MainActivity.this, "开始刷新", Toast.LENGTH_SHORT).show();
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}