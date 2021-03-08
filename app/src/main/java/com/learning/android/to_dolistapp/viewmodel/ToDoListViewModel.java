package com.learning.android.to_dolistapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.android.to_dolistapp.Model.ToDoModel;
import com.learning.android.to_dolistapp.Utils.DataRepository;

public class ToDoListViewModel extends ViewModel {

    //Using live data as i want value to be modified only inside the DataRepository class
    private LiveData<ToDoModel> addedTodoItem = DataRepository.getInstance().getTodoItem();

    //Return the reference of todo model back to the parent class so that it could be subscribed
    public LiveData<ToDoModel> getAddedTodoItem(){
        return  addedTodoItem;
    }

}
