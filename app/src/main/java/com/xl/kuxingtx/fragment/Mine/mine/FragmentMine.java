package com.xl.kuxingtx.fragment.Mine.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xl.kuxingtx.R;
import com.xl.kuxingtx.inter.FMineMvp;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.fragment_fragment_mine)//加载的xml文件
public class FragmentMine extends Fragment implements  View.OnClickListener, FMineMvp.View {
    private FMineMvp.Presenter minePresenter = new MinePresenter(this);
    //注:这是账号
    @ViewInject(R.id.editAccount)
    private EditText editAccount;

    //注:这是密码
    @ViewInject(R.id.editPassword)
    private EditText editPassword;

    //登录的按钮
    @ViewInject(R.id.buttonLogin)
    private Button buttonLogin;

    //忘记密码的按钮
    @ViewInject(R.id.buttonForget)
    private Button buttonForget;

    //忘记密码的按钮
    @ViewInject(R.id.buttonSign)
    private Button buttonSign;

    //测试用的按钮
    @ViewInject(R.id.buttonTest)
    private Button buttonTest;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_fragment_mine,null);

        View view = x.view().inject(this, inflater, container);


/*        //登录的监听事件
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName= editAccount.getText().toString();
                String password=editPassword.getText().toString();
                 Log.e("登录账号",userName);
                 Log.e("登录密码",password);
                minePresenter.login(userName,password);                                 //注:登录调用这个即可
            }
        });*/

 /*       //注册的监听事件
        buttonSign.setOnClickListener(new View.OnClickListener(){                       //注:注册肯定不是一个按钮就搞定，因而此处只给出测试模板

            @Override
            public void onClick(View view) {
                String userName= editAccount.getText().toString();
                String password=editPassword.getText().toString();
                Log.e("注册账号",userName);
                Log.e("注册密码",password);
                minePresenter.register(userName, password);
            }
        });*/


        //测试的监听事件
        buttonTest.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }




    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if(this.getView()!=null){
            this.getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
        }
    }


    @Override
    public void onClick(View v) {
/*        switch (v.getId()){
            case R.id.home_city://地址
                startActivity(new Intent(getActivity(),CityActivity.class));
                break;
            case R.id.home_map://地图
                break;
            case R.id.home_search://搜索
                break;
        }*/
    }


    @Override
    public void loginSucess() {

    }

    @Override
    public void registerSuccess() {

    }

    @Override
    public void resetPasswordSuccess() {

    }

}