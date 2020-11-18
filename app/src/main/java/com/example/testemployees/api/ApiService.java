package com.example.testemployees.api;

import com.example.testemployees.pojo.EmployeeResponce;

import io.reactivex.Observable;

import retrofit2.http.GET;

public interface ApiService {
    @GET("testTask.json")
    Observable<EmployeeResponce> getEmployees();
}
