package com.example.mpandroidpiachart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DecoView arcView = (DecoView)findViewById(R.id.dynamicArcView);

// Create background track
        arcView.addSeries(new SeriesItem.Builder(Color.argb(255, 218, 218, 218))
                .setRange(0, 140, 140)
                .setInitialVisibility(false)
                .setLineWidth(62f)
                .build());




//Create data series track
        SeriesItem seriesItem3 = new SeriesItem.Builder(getResources().getColor(R.color.label_back_light))
                .setRange(0, 140, 90)
                .setLineWidth(62f)
                .build();
        SeriesItem seriesItem2 = new SeriesItem.Builder(getResources().getColor(R.color.colorAccent))
                .setRange(0, 140, 80)
                .setLineWidth(62f)
                .build();
        SeriesItem seriesItem1 = new SeriesItem.Builder(getResources().getColor(R.color.colorPrimaryDark))
                .setRange(0, 140, 0)
                .setLineWidth(62f)
                .build();



        int series1Index = arcView.addSeries(seriesItem1);
        int series1Index2 = arcView.addSeries(seriesItem2);
        int series1Index3 = arcView.addSeries(seriesItem3);



        arcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true)
                .setDelay(500)
                .setDuration(1000)
                .build());

        arcView.addEvent(new DecoEvent.Builder(50+80).setIndex(series1Index3).setDelay(12000).build());
        arcView.addEvent(new DecoEvent.Builder(10+80).setIndex(series1Index2).setDelay(8000).build());

      arcView.addEvent(new DecoEvent.Builder(80).setIndex(series1Index).setDelay(4000 ).build());


    }


}
