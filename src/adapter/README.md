# 适配器模式

将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作

ListView 需要能够显示各式各样的视图，显示效果,显示的数据类型和数量各不相同。那么如何隔离这种变化尤为重要。

Android 的做法是增加一个 Adapter 层来应对变化，将 ListView 需要的接口抽象到 Adapter 对象中，
这样只要用户实现了 Adapter 的接口，ListView 就可以按照用户设定的显示效果、数量、数据来显示特定的 Item View。

```
ListView myListView = (ListView)findViewById(listview_id);
myListView.setAdapter(new MyAdapter(context, myDatas));

public class MyAdapter extends BaseAdapter{
 
        private LayoutInflater mInflater;
        List<String> mDatas ; 
         
        public MyAdapter(Context context, List<String> datas){
            this.mInflater = LayoutInflater.from(context);
            mDatas = datas ;
        }
        @Override
        public int getCount() {
            return mDatas.size();
        }
 
        @Override
        public String getItem(int pos) {
            return mDatas.get(pos);
        }
 
        @Override
        public long getItemId(int pos) {
            return pos;
        }
 
 		// 解析、设置、缓存convertView以及相关内容
        @Override
        public View getView(int position, View convertView, ViewGroup parent) { 
            ViewHolder holder = null;
            // Item View的复用
            if (convertView == null) {
                holder = new ViewHolder();  
                convertView = mInflater.inflate(R.layout.my_listview_item, null);
              	// 获取title
                holder.title = (TextView)convertView.findViewById(R.id.title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.title.setText(mDatas.get(position));
            return convertView;
        }
         
    }
```