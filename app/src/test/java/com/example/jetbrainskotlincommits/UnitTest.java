package com.example.jetbrainskotlincommits;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetbrainskotlincommits.Database.CommitDatabase;
import com.example.jetbrainskotlincommits.model.ApiInterface;
import com.example.jetbrainskotlincommits.model.ResultsPojo;
import com.example.jetbrainskotlincommits.view.MainActivity;
import com.example.jetbrainskotlincommits.viewmodel.CustomAdapter;
import com.example.jetbrainskotlincommits.viewmodel.CustomViewModel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class UnitTest {


//    @Test
//    public void noNetworkConnection() {
//        Boolean networkOnline;
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//            networkOnline = true;
//        } else {
//            networkOnline = false;
//        }
//
//        assertFalse(networkOnline);
//    }
//

    @Mock
    private CustomViewModel model;

    @Test
    public void apiRetunsData() {
        model = new CustomViewModel();
        assertNotNull(model.getCommits());
    }

    @Test
    public void apiDoesNotReturnData() {
        model = new CustomViewModel();
        assertNull(model.getCommits());
    }

//    private Object getSystemService(String connectivityService) {
//        throw new RuntimeException("Stub!");
//    }
}
