package com.ahfasxp.kd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ahfasxp.kd.adapter.ListMiracleAdapter;
import com.ahfasxp.kd.model.Miracle;
import com.ahfasxp.kd.model.MiraclesData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMiracles;
    private ArrayList<Miracle> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMiracles = findViewById(R.id.rv_miracles);
        rvMiracles.setHasFixedSize(true);

        list.addAll(MiraclesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMiracles.setLayoutManager(new LinearLayoutManager(this));
        ListMiracleAdapter listMiracleAdapter = new ListMiracleAdapter(list);
        rvMiracles.setAdapter(listMiracleAdapter);

        listMiracleAdapter.setOnItemClickCallback(new ListMiracleAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Miracle data){
                showSelectedMiracle(data);
            }
        });
    }

    private void showSelectedMiracle(Miracle miracle) {
        Intent moveDetail = new Intent(MainActivity.this, DetailActivity.class);
        moveDetail.putExtra(DetailActivity.EXTRA_IMG, miracle.getPhoto());
        moveDetail.putExtra(DetailActivity.EXTRA_NAME, miracle.getName());
        moveDetail.putExtra(DetailActivity.EXTRA_DETAIL, miracle.getDetail());
        startActivity(moveDetail);
        Toast.makeText(this, "Kamu memilih " + miracle.getName(), Toast.LENGTH_SHORT).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                Intent moveDetail = new Intent(MainActivity.this, DetailActivity.class);
                moveDetail.putExtra(DetailActivity.EXTRA_IMG, R.drawable.author);
                moveDetail.putExtra(DetailActivity.EXTRA_NAME, "Muchamad Ahfas Fazria");
                moveDetail.putExtra(DetailActivity.EXTRA_DETAIL, "Ahfasx.parigy@gmail.com");
                startActivity(moveDetail);
                break;
        }
    }
}
