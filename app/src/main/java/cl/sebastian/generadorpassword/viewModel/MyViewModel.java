package cl.sebastian.generadorpassword.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cl.sebastian.generadorpassword.model.Generator;

//MyViewModel extiende de la clase ViewModel
public class MyViewModel extends ViewModel {

    private static final String TAG = "MyViewModel" ;
    private Generator generator;
    private MutableLiveData<String> newPassword;

    public MyViewModel() {
        this.generator = new Generator();
        newPassword =new MutableLiveData();

    }
    public void generatePassword(int targetStringLength){
        String result = generator.generatePassword(targetStringLength);
        newPassword.setValue(result);
        Log.d(TAG, "generatePassword:  "+ result);

    }

    public LiveData<String> getNewPassword() {
        return newPassword;
    }
}
