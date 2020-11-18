package com.example.testemployees.adapters;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testemployees.R;
import com.example.testemployees.pojo.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employees;

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item,parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.textViewName.setText(employee.getFName());
        holder.textViewLastName.setText(employee.getLName());
        holder.birthday.setText(employee.getBirthday());
        holder.specialty.setText(String.valueOf(employee.getSpecialty()));
        Log.d("TAG", ""+employee.getSpecialty().get(0));

        String uri = employee.getAvatrUrl();
        Glide.with(holder.itemView.getContext())
                .load(uri)
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewLastName;
        private ImageView imageView;
        private TextView birthday;
        private TextView specialty;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            imageView = itemView.findViewById(R.id.imageView);
            birthday = itemView.findViewById(R.id.textViewBirthday);
            specialty = itemView.findViewById(R.id.textViewSpecialty);

        }
    }
}
