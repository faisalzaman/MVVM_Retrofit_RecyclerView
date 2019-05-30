package com.pokemon.pokemontest.view.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pokemon.pokemontest.R;
import com.pokemon.pokemontest.data.model.Pokemon;
import com.pokemon.pokemontest.utils.Constants;
import com.pokemon.pokemontest.view.callbacks.MainCallBack;
import com.pokemon.pokemontest.view.fragments.Frg_PokemonDetail;
import com.pokemon.pokemontest.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<MainViewModel> implements MainCallBack {

    TextView tvToolbarTitle;
    ImageView ivToolbarback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getViewModel().setCallBack(this);
        initViews();
        setUpToolBar();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel initViewModel() {
        return new MainViewModel();
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        tvToolbarTitle = findViewById(R.id.toolbar_title);
        ivToolbarback = findViewById(R.id.iv_back);
        ivToolbarback.setVisibility(View.INVISIBLE);

        ivToolbarback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivToolbarback.setVisibility(View.INVISIBLE);
                tvToolbarTitle.setText("Pokemon");
                Constants.FLAG="main" ;

                getSupportFragmentManager().popBackStack("detail", getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
            }
        });

        tvToolbarTitle.setText("Pokemon");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getApplicationContext(),""+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String msg) {
        Toast.makeText(getApplicationContext(),""+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initViews() {


    }

    @Override
    public void onBackPressed() {
        ivToolbarback.setVisibility(View.INVISIBLE);
        tvToolbarTitle.setText("Pokemon");

        if (getFragmentManager().getBackStackEntryCount() > 0)
        {
            getSupportFragmentManager().popBackStack("detail", getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
//        getFragmentManager().popBackStack();
        }
        else
            super.onBackPressed();
    }

    public void gotoDetail(int pos){

        Constants.FLAG="detail";
        ivToolbarback.setVisibility(View.VISIBLE);

        Fragment frgDetail = Frg_PokemonDetail.getInstance();
        Bundle bundle = new Bundle();
        bundle.putInt("position",pos);
        frgDetail.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left,
                R.anim.slide_out_right, R.anim.slide_in_right);
        transaction.replace(R.id.list_fragment,frgDetail);
        transaction.addToBackStack("detail");
        transaction.commit();

        tvToolbarTitle.setText("DETAILS");
    }

}
