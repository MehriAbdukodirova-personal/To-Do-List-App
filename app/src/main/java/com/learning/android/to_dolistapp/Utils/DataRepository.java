package com.learning.android.to_dolistapp.Utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learning.android.to_dolistapp.Model.ToDoModel;

public class DataRepository {
    private static DataRepository _instance;

    //using singleton pattern so that only one instance of this class will be used through out the app.
    //making it centralize
    public  static DataRepository getInstance(){
        if(_instance == null){
            _instance = new DataRepository();
        }
        return _instance;
    }
    private static MutableLiveData<ToDoModel> todoItem = new MutableLiveData<>();

    public static void onToDoItemAdded(ToDoModel addedTodo){
         todoItem.postValue(addedTodo);
    }

    public LiveData<ToDoModel> getTodoItem(){
        return  todoItem;
    }
}
