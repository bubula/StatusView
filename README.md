# StatusView
页面加载数据，加载中，加载错误，网络错误，正常显示页面

 StatusLayout statusLayout;
 MyStatusView statusView;
  
    statusView = MyStatusView.getInstance(this, "就是没有数据怎么招吧", new MyStatusView.onRetryClickLister() {
            @Override
            public void onRetryClick() {
                Toast.makeText(Main2Activity.this, "重新加载数据", Toast.LENGTH_LONG).show();
            }
        });
    statusLayout =
                new StatusLayout.Builder().setContentView(ll_content).setStatusView(statusView).build();
    statusLayout.showLoading();
    statusLayout.showEmpty();
    statusLayout.showContent();
    statusLayout.showRetry();
    statusLayout.showSetting();

                 
   
