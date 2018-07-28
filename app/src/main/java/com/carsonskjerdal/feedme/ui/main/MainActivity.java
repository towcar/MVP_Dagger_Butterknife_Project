package com.carsonskjerdal.feedme.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.carsonskjerdal.feedme.R;
import com.carsonskjerdal.feedme.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Carson on 6/15/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.randomButton)
    Button randomButton;

    @BindView(R.id.textView)
    TextView textView;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this should be a dagger thing, maybe this is why mPresenter didnt work below? An injection thing..
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        //something about this seems wrong, come back to it for a different solution

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {


        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SetUp", "Click");
                mPresenter.onRandomButtonClicked();

            }
        });

        //mPresenter.onViewInitialized();
    }


    @Override
    public void updateTextView(String testVariable) {
        textView.setText(testVariable);
        Log.e("Set Up", "" + textView.getText().toString());
        Log.e("Set Up", "textView Updated!");
    }

    @Override
    public void showLoading() {
        //add to the base activity perhaps?
    }
}
