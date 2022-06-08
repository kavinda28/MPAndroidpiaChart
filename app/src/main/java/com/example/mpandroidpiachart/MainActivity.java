package com.example.mpandroidpiachart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;
    //CircularProgressIndicator circularProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.chart);

        setupPieChart();
    }

    private void setupPieChart(){

        //pupulating list of PieEntires
        List<PieEntry> pieEntires = new ArrayList<>();

            pieEntires.add(new PieEntry(100,0));
        pieEntires.add(new PieEntry(20,1));
        pieEntires.add(new PieEntry(50,3));
        pieEntires.add(new PieEntry(80,4));

        PieDataSet dataSet = new PieDataSet(pieEntires,"");
        dataSet.setColors(getResources().getColor(R.color.red), getResources().getColor(R.color.purple), getResources().getColor(R.color.seeblue), getResources().getColor(R.color.yellow));
        PieData data = new PieData(dataSet);
        //Get the chart
        pieChart.setData(data);
        pieChart.invalidate();
        pieChart.setCenterText("Total 5" );
        pieChart.setCenterTextSize(14f);
        pieChart.setCenterTextColor(Color.BLUE);
        dataSet.setDrawValues(false);
        pieChart.setHoleRadius(70);
        pieChart.setDrawRoundedSlices(true);
        pieChart.getDescription().setEnabled(false);
        //animation
       // pieChart.spin( 2000,0,-360f, Easing.EaseInOutQuad);
      //  pieChart.animateXY(3000, 3000);
        pieChart.animateY(3000, Easing.EaseInBack);

        //legend attributes
        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);


    }

}
