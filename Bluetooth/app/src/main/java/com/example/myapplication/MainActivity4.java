package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import java.util.Set;
import android.view.View;
import android.widget.Toast;


public class MainActivity4 extends AppCompatActivity {
    Button button1;
    private BluetoothAdapter blue;
    private ArrayAdapter a;
    private Set<BluetoothDevice> pairedDevices ;
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button1 = (Button) findViewById(R.id.button1);

        blue = BluetoothAdapter.getDefaultAdapter();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Set<BluetoothDevice> pairedDevices = blue.getBondedDevices();
                    ArrayList list = new ArrayList();
                    if (pairedDevices.size() > 0) {
                        for (BluetoothDevice device : pairedDevices) {
                            String devicename = device.getName();
                            list.add(  devicename );
                        }
                        l = (ListView) findViewById(R.id.list);
                        a = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        l.setAdapter(a);
                    }
                }
        });
    }
}