package com.example.studentcoursebookingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapterEnroll extends RecyclerView.Adapter<CourseAdapterEnroll.MyViewHolder>{

    private Context context;
    private ArrayList<Course> courseArrayList;

    public CourseAdapterEnroll(Context context, ArrayList<Course> userArrayList) {
        this.context = context;
        this.courseArrayList = userArrayList;
    }

    @NonNull
    @Override
    public CourseAdapterEnroll.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.course_list_item_student_enroll, parent, false);

        return new MyViewHolder(v, courseArrayList);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapterEnroll.MyViewHolder holder, int position) {
        Course course = courseArrayList.get(position);
        holder.courseName.setText(course.getName());
        holder.courseNumber.setText(course.getCourseId());
    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView courseName, courseNumber;

        public MyViewHolder(@NonNull View itemView, ArrayList<Course> courseArrayList) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_name_txt_view);
            courseNumber = itemView.findViewById(R.id.course_number_txt_view);
            itemView.setOnClickListener((v) -> {
                int position = getAdapterPosition();
                Log.d("clickTest", "OnClick -> Course Click: " + courseArrayList.get(position).getName());
            });

            itemView.findViewById(R.id.course_enroll_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ClickWork", "OnClick: Edit Course Click");
                    int position = getAdapterPosition();

                    Log.d("ClickWork", courseArrayList.get(position).getName());
                    Course course = courseArrayList.get(position);

                    // TODO



                }
            });


        }
    }
}
