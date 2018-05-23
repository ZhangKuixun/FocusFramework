## 创建控件+焦点移动

### 1.前置条件：
* 服务器整体页面配置数据：
```
		(1)返回参数：
			/**
		     * 横向占用单元格数量
		     */
		    private int wCellNumber;
		    /**
		     * 纵向占用单元格数量
		     */
		    private int hCellNumber;
		    /**
		     * x轴起始单元格
		     */
		    private int xStart;
		    /**
		     * y轴起始单元格
		     */
		    private int yStart;
		    /**
		     * 连接到某页面
		     */
		    public List<Composition> like;

		(2)返回参数转json格式：
			页面1：
			{
				页面1-控件1：
				{wCellNumber:10,hCellNumber:10,xStart=0,yStart=0,link:{
					页面2-控件1：
					wCellNumber:80,hCellNumber:80,xStart=0,yStart=0,link:{
					}
					页面2-控件2：
					wCellNumber:20,hCellNumber:20,xStart=81,yStart=0,link:{
					}
					页面2-控件3：
					wCellNumber:20,hCellNumber:20,xStart=81,yStart=21,link:{
					}
				}}
				页面1-控件2：
				{wCellNumber:10,hCellNumber:10,xStart=11,yStart=11,link:{
				}}
			}

			json参数解释：
			后台计算“返回参数”的屏幕基准：1280*720。
			移动端和服务器约定单元格的宽和高：wCell=12.8f,hCell=7.2f。
```
* 控件库：TVButton,TVImageView,	TextView

* IFocus焦点控制接口：


### 2.实现：
	本地控件排版计算方式：
		控件宽：单元格宽*横向占用单元格数量*屏幕像素
		控件高：单元格高*纵向占用单元格数量*屏幕像素
		控件起始x轴的点：x轴起始单元格*单元格的宽*屏幕像素
		控件起始y轴的点：y轴起始单元格*单元格的高*屏幕像素


-----------------------------------------史上最牛分割线---------------------------------------------


## library使用方式：

### 1.在欢迎页面，访问服务器获取整体页面配置数据。

### 2.欢迎页面：

```
        /**
	 * 服务器整体页面配置数据
	 */
	private static CompositionPage mCompositionPage;
	/**
	 * @return 服务器整体页面配置数据
	 */
	public synchronized static CompositionPage getCompositionPage() {
    	return mCompositionPage;
	}

```

### 3.Activity创建控件时：
```
public class MainActivity extends Activity implements BaseView, View.OnClickListener {
    /**
     * 屏幕宽高
     */
    private int screenWidth, screenHeight;
    private FrameLayout frame;
    private MainActivity3 context;
    /**
     * 页面内所有的控件
     */
    private List<Composition> mCompositions;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("MainActivity3");
        context = this;
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        mCompositions = MyApplication.getCompositionPage().getCompositions();

        frame = (FrameLayout) findViewById(R.id.frame);

        initView();
    }

    private void initView() {
        addView();
    }

    public void addView() {
        for (Composition data : mCompositions) {
            View child = ContentType(type.TextView, data);
            if (child != null)
                frame.addView(child);
        }
    }

    @Override
    public View ContentType(type type, Composition data) {
        if (type == BaseView.type.Button) {
            TextParams params = new TextParams();
            params.setText("button" + i++);
            params.setBackgroundColor(R.drawable.focus_transparent);

            TVButton button = new TVButton(context, i);
            button.setParams(params);
            button.composition(screenWidth, screenHeight, data);
            return button;
        }
        if (type == BaseView.type.TextView) {
            TextParams params = new TextParams();
            params.setText("text" + i);
            params.setBackgroundColor(R.drawable.focus_transparent);

            TVTextView textView = new TVTextView(context, i);
            textView.setParams(params);
            textView.composition(screenWidth, screenHeight, data);
            if (mCompositions.get(i).getLike() != null)
                textView.setOnClickListener(this);
            i++;
            return textView;
        }
        if (type == BaseView.type.ImageView) {
            ImageParams params = new ImageParams();
            params.setBitmapResource(R.mipmap.ic_launcher);
            params.setBackGroundResource(R.drawable.focus_transparent);

            TVImageView imageView = new TVImageView(context, i);
            imageView.setParams(params);
            imageView.composition(screenWidth, screenHeight, data);
            return imageView;
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, MainActivity4.class);
        intent.putExtra("like", (Serializable) mCompositions.get(v.getId()).getLike());
        startActivity(intent);
    }
}
```