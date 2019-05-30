package com.xl.kuxingtx.fragment.Mine.info;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.xl.kuxingtx.R;
import com.xl.kuxingtx.inter.FInfoMvp;
import com.xuexiang.xui.widget.textview.MarqueeTextView;


import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import org.xutils.x;

import java.util.ArrayList;

import java.util.List;

@ContentView(R.layout.fragment_fragment_info)//加载的xml文件
public class FragmentInfo extends Fragment implements View.OnClickListener, FInfoMvp.View{
    private FInfoMvp.Presenter infoPresenter = new InfoPresenter(this);
    @ViewInject(R.id.tv_marquee)
    private MarqueeTextView tv_marquee;
    @ViewInject(R.id.friend_recycler)
    private RecyclerView friend_recycler;
    private FriendAdapter friendAdapter;
    private List<FriendBean> friendDatas = new ArrayList<>();
    private List<String> tvDatas = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_fragment_info, null);
        //ViewUtils.inject(getActivity());
        View view = x.view().inject(this, inflater, container);


        tvDatas.add("内测用户、");
        tvDatas.add("VIP");
        tv_marquee.startSimpleRoll(tvDatas);


        FriendBean friendBean;
        for (int i = 0; i < 15; i++) {
            friendBean = new FriendBean();
            friendBean.setUserName("测试、");
            friendDatas.add(friendBean);
        }
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        friend_recycler.setLayoutManager(layoutManager);

        //创建适配器
        friendAdapter = new FriendAdapter(R.layout.friend_item, friendDatas);

        //给RecyclerView设置适配器
        friend_recycler.setAdapter(friendAdapter);

        return view;
    }


    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
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
}

