package com.example.travelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView ;
    private ListView lvDestination;
    ArrayList<Destination> destinationArrayList;
    DestinationAdapter destinationAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        destinationAdapter = new DestinationAdapter(this,R.layout.list_destination, destinationArrayList);
        lvDestination.setAdapter(destinationAdapter);

        lvDestination.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showInforDestination(i);
                return false;
            }
        });

        lvDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteSach(i);
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.nav_profile){
                    Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent);
                }
                if(item.getItemId() == R.id.nav_home1){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }


                return true;
                /*int id= item.getItemId();
                if(id==R.id.nav_home1){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else if(id==R.id.nav_profile){
                    Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent);
                }*/
                //dong drawer lai
                //return true;
            }
        });
    }

    private void AnhXa() {
        lvDestination = (ListView) findViewById(R.id.listviewDestination);
        destinationArrayList = new ArrayList<>();
        destinationArrayList.add(new Destination("Ba Na Hills", "1.000.000 VND", "???? N???ng","?????n v???i Sun World Ba Na Hills, du kh??ch c?? c?? h???i ???????c th??m quan v?? tr???i nghi???m nh???ng c??ng tr??nh v?? ??i???m ?????n ?????c ????o, c?? m???t kh??ng hai. ", R.drawable.banahill));
        destinationArrayList.add(new Destination("Ph??? c??? H???i An", "800.000 VND", "Qu???ng Nam","H???i An l?? m???t th??nh ph??? thu???c t???nh Qu???ng Nam c?? nhi???u khu ph??? c??? ???????c x??y t??? th??? k??? 16 v?? v???n c??n t???n t???i g???n nh?? nguy??n v???n ?????n nay. ", R.drawable.hoian));
        destinationArrayList.add(new Destination("C???u R???ng", "100.000 VND", "???? N???ng", "L?? c??y c???u h??nh con r???ng phun l???a v?? n?????c l??n cao, l?? c??y c???u huy???n tho???i b???c qua c??i s??ng H??n ????? m???i ng?????i v???i th??? l??u th??ng ti???n l???i h??n.",R.drawable.caurong));
        destinationArrayList.add(new Destination("N??i th???n t??i", "300.000 VND", "???? N???ng","Su???i kho??ng n??ng t???i N??i Th???n T??i ???????c kh???i ngu???n t??? ?????nh thi??ng B?? N?? v?? ???????c bao b???c hai b??n b???i ?????i Thanh Long, ?????i B???ch H??? v?? ph??t l??? t???i long huy???t th??n Ph?? T??c.", R.drawable.nuithantai));
        destinationArrayList.add(new Destination("C??? ???? Hu???", "950.000 VND", "Hu???","Qu???n th??? di t??ch C??? ???? Hu??? n???m d???c hai b??n b??? s??ng H????ng thu???c th??nh ph??? Hu??? v?? m???t v??i v??ng ph??? c???n thu???c t???nh Th???a Thi??n Hu???" ,R.drawable.codohue));
        destinationArrayList.add(new Destination("Bi???n M??? Kh??", "200.000 VND", "???? N???ng","B??i Bi???n M??? Kh?? n???i ti???ng v???i c??t tr???ng m???n, s??ng bi???n ??n h??a, n?????c ???m quanh n??m c??ng h??ng d???a th?? m???ng, ?????p tuy???t v???i bao quanh." ,R.drawable.bienmk));

    }

    private void showInforDestination(int position){
        Destination destination = destinationArrayList.get(position);

        Intent i = new Intent(this, DetailActivity.class);

        i.putExtra("Name",destination.getName());
        i.putExtra("NameProvince",destination.getNameProvince());
        i.putExtra("Price",destination.getPrice());
        i.putExtra("Describe",destination.getDescribe());
        i.putExtra("Picture", destination.getPicture());

        startActivity(i);
    }

    private void deleteSach(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete TOUR")
                .setMessage("Do you want delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        destinationArrayList.remove(position);
                        destinationAdapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Cancel", null)
                .show();
    }


}