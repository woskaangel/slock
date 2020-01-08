package com.example.slock;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    Context context;

    ArrayList<LogClass> items = new ArrayList<LogClass>();

    public  LogAdapter(Context context){
        this.context =  context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override //뷰홀더가 만들어지는 시점에 호출되는 메소드(각각의 아이템을 위한 뷰홀더 객체가 처음만들어지는시점)
    //만약에 각각의 아이템을 위한 뷰홀더가 재사용될 수 있는 상태라면 호출되지않음 (그래서 편리함, 이건내생각인데 리스트뷰같은경우는 convertView로 컨트롤해줘야하는데 이건 자동으로해줌)
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.log_item,  viewGroup, false);//viewGroup는 각각의 아이템을 위해서 정의한 xml레이아웃의 최상위 레이아우싱다.

        return new ViewHolder(itemView); //각각의 아이템을 위한 뷰를 담고있는 뷰홀더객체를 반환한다.(각 아이템을 위한 XML 레이아웃을 이용해 뷰 객체를 만든 후 뷰홀더에 담아 반환
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        LogClass item = items.get(position); //리사이클러뷰에서 몇번쨰게 지금 보여야되는시점이다 알려주기위해
        viewHolder.setItem(item); //그거를 홀더에넣어서 뷰홀더가 데이터를 알 수 있게되서 뷰홀더에 들어가있는 뷰에다가 데이터 설정할 수 있음
    }

    //아이템을 한개 추가해주고싶을때
    public  void addItem(LogClass item){
        items.add(item);
    }

    // 한 번에 추가
    public void addItems(ArrayList<LogClass> items){
        this.items = items;
    }

    // 전체 삭제
    public void removeItem(){
        this.items.clear();
    }


    public  LogClass getItem(int position){
        return  items.get(position);
    }

    //뷰홀더 객체는 뷰를 담아두는 역할을 하면서 동시에 뷰에 표시될 데이터를 설정하는 역할을 맡을 수 있습니다.
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        ImageView image;

        public ViewHolder(@NonNull final View itemView) { //뷰홀더는 각각의 아이템을 위한 뷰를 담고있다.
            super(itemView);

            time = itemView.findViewById(R.id.logTime);
            image = itemView.findViewById(R.id.logImage);
        }

        //setItem 메소드는 SingerItem 객체를 전달받아 뷰홀더 안에 있는 뷰에 데이터를 설정하는 역할을 합니다.
        public void setItem(LogClass item) {
            time.setText(item.getTime());

            if(item.getState().equals("open")){
                image.setImageResource(R.drawable.door_open);
            }
            else{
                image.setImageResource(R.drawable.door_close);
            }
        }
    }
}
