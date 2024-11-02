package com.example.change;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    ListView lView;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            lView = findViewById(R.id.lView);

            String[] songs = {"what do you feel", "Everything Black", "Whare Are the days"};// Replace with the song names
            int[] songImages = {R.drawable.whatdoyoufeel, R.drawable.everythingblack, R.drawable.wharearethedays}; // Replace with actual drawable IDs
            int[] songResIds = {R.raw.maatmargisha, R.raw.everythingblack, R.raw.wherearethedays};

            MyCustomAdapter adapter = new MyCustomAdapter(this, songs,songImages);
            //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,songs);
            lView.setAdapter(adapter);

            // Set up item click listener
            lView.setOnItemClickListener((parent, view, position, id) -> {
                // Stop any currently playing song
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                // Create a new MediaPlayer instance for the selected song
                mediaPlayer = MediaPlayer.create(this, songResIds[position]);
                mediaPlayer.start();
            });
            return insets;
        });
    }
}