package com.three.learning.fragment;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.three.learning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Three on 2016/7/9.
 */
public class BookOrMe extends Fragment {
    private List<Map<String,Object>> data = new ArrayList<>();
    public BookOrMe() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_or_me,container,false);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),getData(),R.layout.bookshelf,new String[]{"name","image"},new int[]{R.id.bookTitle,R.id.bookImage});
        ListView list = (ListView) view.findViewById(R.id.booklist);
        list.setAdapter(adapter);
        return view;
    }
    public List<Map<String,Object>> getData(){
        Resources res = getResources();
        String[] title = res.getStringArray(R.array.bookTitle);
        int[] imageId = res.getIntArray(R.array.bookImage);
        for(int i=0;i<title.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name",title[i]);
            map.put("image",R.drawable.cat);
            data.add(map);
        }
        return data;
    }
}
